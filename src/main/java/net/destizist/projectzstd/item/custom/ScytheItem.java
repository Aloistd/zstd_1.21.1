package net.destizist.projectzstd.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.component.Tool.Rule;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import java.util.List;

public class ScytheItem extends TieredItem {
    private final int attackDamage;
    private final float attackSpeed;
    private final double aoeRadius;
    private final float aoeDamage;

    public ScytheItem(Tier tier, int attackDamage, float attackSpeed, double aoeRadius, float aoeDamage, Properties properties) {
        super(tier, properties.component(DataComponents.TOOL, createToolProperties())
                .component(DataComponents.ATTRIBUTE_MODIFIERS, createAttributes(tier, attackDamage, attackSpeed)));
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.aoeRadius = aoeRadius;
        this.aoeDamage = aoeDamage;
    }

    private static Tool createToolProperties() {
        return new Tool(List.of(Rule.minesAndDrops(List.of(Blocks.COBWEB), 15.0F), Rule.overrideSpeed(BlockTags.SWORD_EFFICIENT, 1.5F)), 1.0F, 2);
    }

    public static ItemAttributeModifiers createAttributes(Tier tier, int attackDamage, float attackSpeed) {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (double) (attackDamage + tier.getAttackDamageBonus()), Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, (double) attackSpeed, Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build();
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player player) {
            // Проверяем, находится ли предмет на перезарядке
            if (player.getCooldowns().isOnCooldown(this)) {
                return false; // Если на перезарядке, атака не выполняется
            }

            // Устанавливаем перезарядку в 2 секунды (40 тиков)
            player.getCooldowns().addCooldown(this, 20);

            double lookX = player.getLookAngle().x;
            double lookZ = player.getLookAngle().z;

            double centerX = player.getX() + lookX * 2;
            double centerZ = player.getZ() + lookZ * 2;

            AABB area = new AABB(
                    centerX - aoeRadius, player.getY(), centerZ - aoeRadius,
                    centerX + aoeRadius, player.getY() + 1, centerZ + aoeRadius
            );

            // Получаем урон, который будет нанесен
            float damage = (float) player.getAttributeValue(Attributes.ATTACK_DAMAGE);

            // Наносим урон всем сущностям в области, включая основную цель
            for (LivingEntity entity : player.level().getEntitiesOfClass(LivingEntity.class, area)) {
                if (entity != player) { // Игрок не должен наносить урон сам себе
                    entity.hurt(player.damageSources().playerAttack(player), damage);
                    player.level().addParticle(ParticleTypes.SWEEP_ATTACK, entity.getX(), entity.getY(), entity.getZ(), 0, 0, 0);
                }
            }

            // Воспроизводим звук
            player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.PLAYER_ATTACK_SWEEP, player.getSoundSource(), 1.0F, 1.0F);

            // Добавляем частицы для визуальной обратной связи
            player.level().addParticle(ParticleTypes.ENCHANT, player.getX(), player.getY() + 1.0, player.getZ(), 0.0, 0.5, 0.0);

            // Возвращаем true, так как урон был нанесен
            return true;
        }

        // Если атакующий не игрок, наносим урон только основной цели
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Наносим износ предмету после атаки
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        // Запрещаем атаку блоков в творческом режиме
        return !player.isCreative();
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        // Разрешаем действия, доступные для мечей
        return ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
    }
}