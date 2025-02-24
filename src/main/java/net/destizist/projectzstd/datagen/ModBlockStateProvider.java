package net.destizist.projectzstd.datagen;

import net.destizist.projectzstd.ProjectZstd;
import net.destizist.projectzstd.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ProjectZstd.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CITROFITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_CITROFITE_ORE);
        blockWithItem(ModBlocks.NETHERITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_NETHERITE_ORE);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
