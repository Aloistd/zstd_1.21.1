package net.destizist.projectzstd.util;

import net.destizist.projectzstd.ProjectZstd;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_CITROFITE_TOOL = createTag("needs_citrofite_tool");
        public static final TagKey<Block> INCORRECT_FOR_CITROFITE_TOOL = createTag("incorrect_for_citrofite_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ProjectZstd.MOD_ID, name));
        }
    }
}