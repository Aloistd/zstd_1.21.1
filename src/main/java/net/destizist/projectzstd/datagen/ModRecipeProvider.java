package net.destizist.projectzstd.datagen;

import net.destizist.projectzstd.ProjectZstd;
import net.destizist.projectzstd.block.ModBlocks;
import net.destizist.projectzstd.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> NETHERITE_SMELTABLES = List.of(
                ModBlocks.NETHERITE_ORE.get(), ModBlocks.DEEPSLATE_NETHERITE_ORE.get());
        List<ItemLike> CITROFITE_ORE_SMELTABLES = List.of(
                ModBlocks.CITROFITE_ORE.get(), ModBlocks.DEEPSLATE_CITROFITE_ORE.get());
        List<ItemLike> RAW_CITROFITE_SMELTABLES = List.of(
                ModItems.RAW_CITROFITE.get());
        List<ItemLike> CITROFITE_CHARGE_SMELTABLES = List.of(
                ModItems.CITROFITE_CHARGE.get());
        List<ItemLike> WITHERED_STEEL_CHARGE_SMELTABLES = List.of(
                ModItems.WITHERED_STEEL_CHARGE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WOODEN_SCYTHE.get())
                .pattern("###")
                .pattern(" @#")
                .pattern("@  ")
                .define('@', Items.STICK)
                .define('#', ItemTags.PLANKS)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STONE_SCYTHE.get())
                .pattern("###")
                .pattern(" @#")
                .pattern("@  ")
                .define('@', Items.STICK)
                .define('#', Items.COBBLESTONE)
                .unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_SCYTHE.get())
                .pattern("###")
                .pattern(" @#")
                .pattern("@  ")
                .define('@', Items.STICK)
                .define('#', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLDEN_SCYTHE.get())
                .pattern("###")
                .pattern(" @#")
                .pattern("@  ")
                .define('@', Items.STICK)
                .define('#', Items.GOLD_INGOT)
                .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_SCYTHE.get())
                .pattern("###")
                .pattern(" @#")
                .pattern("@  ")
                .define('@', Items.STICK)
                .define('#', Items.DIAMOND)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.NETHERITE_SCRAP)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.NETHERITE_NUGGET.get())
                .unlockedBy(getHasName(ModItems.NETHERITE_NUGGET.get()), has(ModItems.NETHERITE_NUGGET.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CITROFITE_CHARGE.get(), 2)
                .requires(ModItems.PURE_CITROFITE.get(),4)
                .requires(Items.NETHERITE_SCRAP,4)
                .requires(Items.NETHER_STAR)
               .unlockedBy(getHasName(ModItems.PURE_CITROFITE.get()), has(ModItems.PURE_CITROFITE.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WITHERED_STEEL_CHARGE.get(), 6)
                .requires(ModItems.WITHERED_BONE.get(),4)
                .requires(Items.IRON_INGOT,5)
                .unlockedBy(getHasName(ModItems.WITHERED_BONE.get()), has(ModItems.WITHERED_BONE.get())).save(pRecipeOutput);

        //ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WITHERED_STEEL_CHARGE.get(), 6)
                //.requires(ModItems.WITHERED_BONE.get(),4)
                //.requires(Items.RAW_IRON,5)
                //.unlockedBy(getHasName(ModItems.WITHERED_BONE.get()), has(ModItems.WITHERED_BONE.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WITHERED_STEEL_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .requires(ModItems.WITHERED_STEEL_INGOT.get(),4)
                .requires(ModItems.NETHERITE_NUGGET.get(),4)
                .requires(ModItems.WITHERED_STEEL_UPGRADE_SMITHING_TEMPLATE.get())
                .unlockedBy(getHasName(ModItems.WITHERED_STEEL_UPGRADE_SMITHING_TEMPLATE.get()), has(ModItems.WITHERED_STEEL_UPGRADE_SMITHING_TEMPLATE.get())).save(pRecipeOutput);

        //ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WITHERED_STEEL_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                //.requires(ModItems.WITHERED_STEEL_INGOT.get(),4)
                //.requires(ModItems.NETHERITE_NUGGET.get(),4)
                //.requires(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                //.unlockedBy(getHasName(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), has(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)).save(pRecipeOutput);

        oreSmelting(pRecipeOutput, NETHERITE_SMELTABLES, RecipeCategory.MISC, ModItems.NETHERITE_NUGGET.get(), 0.25f, 200, "netherite");
        oreBlasting(pRecipeOutput, NETHERITE_SMELTABLES, RecipeCategory.MISC, ModItems.NETHERITE_NUGGET.get(), 0.25f, 100, "netherite");
        oreSmelting(pRecipeOutput, CITROFITE_ORE_SMELTABLES, RecipeCategory.MISC, ModItems.RAW_CITROFITE.get(), 0.40f, 400, "citrofite");
        oreBlasting(pRecipeOutput, CITROFITE_ORE_SMELTABLES, RecipeCategory.MISC, ModItems.RAW_CITROFITE.get(), 0.40f, 200, "citrofite");
        oreSmelting(pRecipeOutput, RAW_CITROFITE_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_CITROFITE.get(), 0.20f, 200, "citrofite");
        oreBlasting(pRecipeOutput, RAW_CITROFITE_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_CITROFITE.get(), 0.20f, 100, "citrofite");
        oreSmelting(pRecipeOutput, CITROFITE_CHARGE_SMELTABLES, RecipeCategory.MISC, ModItems.CITROFITE_INGOT.get(), 0.80f, 1600, "citrofite");
        oreBlasting(pRecipeOutput, CITROFITE_CHARGE_SMELTABLES, RecipeCategory.MISC, ModItems.CITROFITE_INGOT.get(), 0.80f, 800, "citrofite");
        oreSmelting(pRecipeOutput, WITHERED_STEEL_CHARGE_SMELTABLES, RecipeCategory.MISC, ModItems.WITHERED_STEEL_INGOT.get(), 0.25f, 400, "withered_steel");
        oreBlasting(pRecipeOutput, WITHERED_STEEL_CHARGE_SMELTABLES, RecipeCategory.MISC, ModItems.WITHERED_STEEL_INGOT.get(), 0.25f, 200, "withered_steel");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, ProjectZstd.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
