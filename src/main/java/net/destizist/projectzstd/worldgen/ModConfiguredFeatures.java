package net.destizist.projectzstd.worldgen;

import net.destizist.projectzstd.ProjectZstd;
import net.destizist.projectzstd.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_CITROFITE_ORE_KEY = registerKey("citrofite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_NETHERITE_ORE_KEY = registerKey("netherite_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldCitrofiteOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.CITROFITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_CITROFITE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldNetheriteOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.NETHERITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_NETHERITE_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_CITROFITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldCitrofiteOres, 5));
        register(context, OVERWORLD_NETHERITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldNetheriteOres, 5));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ProjectZstd.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}