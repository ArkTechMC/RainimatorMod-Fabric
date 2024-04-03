package com.rainimator.rainimatormod.registry;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class ModStructures {

    private static StructureFeature<DefaultFeatureConfig> register(String id, StructureFeature<DefaultFeatureConfig> feature) {
        return Registry.register(Registry.STRUCTURE_FEATURE, id, feature);
    }
}
