package net.destizist.projectzstd.item;

import net.destizist.projectzstd.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier CITROFITE = new ForgeTier(2500, 11, 5f, 25,
            ModTags.Blocks.NEEDS_CITROFITE_TOOL, () -> Ingredient.of(ModItems.CITROFITE_INGOT.get()),
            ModTags.Blocks.INCORRECT_FOR_CITROFITE_TOOL);
}