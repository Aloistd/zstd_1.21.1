package net.destizist.projectzstd.datagen;

import net.destizist.projectzstd.ProjectZstd;
import net.destizist.projectzstd.item.ModItems;
import net.destizist.projectzstd.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, ProjectZstd.MOD_ID, registries);
    }

    @Override
    protected void start(HolderLookup.Provider registries) {
        add("withered_bone_from_creeper", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/wither_skeleton"))
                        .and(LootItemRandomChanceCondition.randomChance(0.2f)).build() },
                ModItems.WITHERED_BONE.get()));

    }
}