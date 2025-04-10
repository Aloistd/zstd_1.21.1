package net.destizist.projectzstd.datagen;

import net.destizist.projectzstd.block.ModBlocks;
import net.destizist.projectzstd.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        this.add(ModBlocks.CITROFITE_ORE.get(),
                block -> createOreDrop(ModBlocks.CITROFITE_ORE.get(), ModItems.RAW_CITROFITE.get()));
        this.add(ModBlocks.DEEPSLATE_CITROFITE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_CITROFITE_ORE.get(), ModItems.RAW_CITROFITE.get()));
        this.add(ModBlocks.NETHERITE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.NETHERITE_ORE.get(), ModItems.NETHERITE_NUGGET.get(), 1, 3));
        this.add(ModBlocks.DEEPSLATE_NETHERITE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.DEEPSLATE_NETHERITE_ORE.get(), ModItems.NETHERITE_NUGGET.get(), 1, 3));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
