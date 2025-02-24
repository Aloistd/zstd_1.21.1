package net.destizist.projectzstd.datagen;

import net.destizist.projectzstd.ProjectZstd;
import net.destizist.projectzstd.item.ModItems;
import net.destizist.projectzstd.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, ProjectZstd.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
       // tag(ModTags.Items.TRANSFORMABLE_ITEMS)
       //         //.add(ModItems.ALEXANDRITE.get())
       //         //.add(ModItems.RAW_ALEXANDRITE.get())
       //         .add(Items.COAL)
       //         .add(Items.STICK)
       //         .add(Items.COMPASS);


        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.CITROFITE_HELMET.get())
                .add(ModItems.CITROFITE_CHESTPLATE.get())
                .add(ModItems.CITROFITE_LEGGINGS.get())
                .add(ModItems.CITROFITE_BOOTS.get());
    }
}
