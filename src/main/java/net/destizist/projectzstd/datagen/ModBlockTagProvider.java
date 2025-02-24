package net.destizist.projectzstd.datagen;

import net.destizist.projectzstd.ProjectZstd;
import net.destizist.projectzstd.block.ModBlocks;
import net.destizist.projectzstd.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;


import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ProjectZstd.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.NETHERITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_NETHERITE_ORE.get())
                .add(ModBlocks.CITROFITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_CITROFITE_ORE.get());
//МЕГАКОСТЫЛЬ
        tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .add(ModBlocks.CITROFITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_CITROFITE_ORE.get());
        tag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .add(ModBlocks.CITROFITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_CITROFITE_ORE.get());
        tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .add(ModBlocks.CITROFITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_CITROFITE_ORE.get());
        tag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .add(ModBlocks.CITROFITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_CITROFITE_ORE.get());
        tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .add(ModBlocks.CITROFITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_CITROFITE_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DEEPSLATE_NETHERITE_ORE.get())
                .add(ModBlocks.NETHERITE_ORE.get());
    }
}
