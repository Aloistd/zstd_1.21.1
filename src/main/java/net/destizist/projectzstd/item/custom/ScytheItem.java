package net.destizist.projectzstd.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
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
            double lookX = player.getLookAngle().x;
            double lookZ = player.getLookAngle().z;

            double centerX = player.getX() + lookX * 2;
            double centerZ = player.getZ() + lookZ * 2;

            AABB area = new AABB(
                    centerX - 1.5, player.getY(), centerZ - 1.5,
                    centerX + 1.5, player.getY() + 1, centerZ + 1.5
            );

            for (LivingEntity entity : player.level().getEntitiesOfClass(LivingEntity.class, area)) {
                if (entity != player && entity != target) {
                    entity.hurt(player.damageSources().playerAttack(player), aoeDamage);
                    player.level().addParticle(ParticleTypes.SWEEP_ATTACK, entity.getX(), entity.getY(), entity.getZ(), 0, 0, 0);
                }
            }

            player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.PLAYER_ATTACK_SWEEP, player.getSoundSource(), 1.0F, 1.0F);
        }

        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
    }
}