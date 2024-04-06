package com.rainimator.rainimatormod.registry;

import com.rainimator.rainimatormod.RainimatorMod;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;


public class ModFeatures {
    public static final RegistryKey<PlacedFeature> RUBY_ORE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(RainimatorMod.MOD_ID, "ruby_ore"));
    public static final RegistryKey<PlacedFeature> SAPPHIRE_ORE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(RainimatorMod.MOD_ID, "sapphire_ore"));
    public static final RegistryKey<PlacedFeature> MYSTIC_ORE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(RainimatorMod.MOD_ID, "mystic_ore"));

    public static void addFeatures() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_DECORATION, RUBY_ORE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, SAPPHIRE_ORE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, MYSTIC_ORE);
    }
}
