package com.rainimator.rainimatormod.registry;

import com.rainimator.rainimatormod.RainimatorMod;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Block;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.Arrays;

public class ModOres {
    public static final PlacedFeature RUBY_ORE = register("ruby_ore", ModBlocks.RUBY_ORE, OreConfiguredFeatures.STONE_ORE_REPLACEABLES, 7, 2, YOffset.fixed(-1), YOffset.fixed(20));
    public static final PlacedFeature SAPPHIRE_ORE = register("sapphire_ore", ModBlocks.SAPPHIRE_ORE, OreConfiguredFeatures.STONE_ORE_REPLACEABLES, 7, 2, YOffset.fixed(-1), YOffset.fixed(20));
    public static final PlacedFeature DEEPSLATE_RUBY_ORE = register("deepslate_ruby_ore", ModBlocks.DEEPSLATE_RUBY_ORE, OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, 7, 2, YOffset.fixed(-60), YOffset.fixed(-10));
    public static final PlacedFeature DEEPSLATE_SAPPHIRE_ORE = register("deepslate_sapphire_ore", ModBlocks.DEEPSLATE_SAPPHIRE_ORE, OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, 7, 2, YOffset.fixed(-60), YOffset.fixed(-10));
    public static final PlacedFeature MYSTIC_ORE = register("mystic_ore", ModBlocks.MYSTIC_ORE, OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, 6, 1, YOffset.fixed(-60), YOffset.fixed(-15));

    private static PlacedFeature register(String id, Block oreBlock, RuleTest replaceRule, int size, int countPerChunk) {
        return register(id, oreBlock, replaceRule, size, countPerChunk, YOffset.getBottom(), YOffset.fixed(64));
    }

    private static PlacedFeature register(String id, Block oreBlock, RuleTest replaceRule, int size, int countPerChunk, YOffset minY, YOffset maxY) {
        ConfiguredFeature<?, ?> configuredFeature = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(replaceRule, oreBlock.getDefaultState(), size));
        PlacedFeature placedFeature = new PlacedFeature(RegistryEntry.of(configuredFeature), Arrays.asList(CountPlacementModifier.of(countPerChunk), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(minY, maxY)));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(RainimatorMod.MOD_ID, id), configuredFeature);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(RainimatorMod.MOD_ID, id), placedFeature);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(RainimatorMod.MOD_ID, id)));
        return placedFeature;
    }

    public static void init() {
    }
}
