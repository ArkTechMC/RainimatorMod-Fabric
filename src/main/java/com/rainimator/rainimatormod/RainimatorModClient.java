package com.rainimator.rainimatormod;

import com.rainimator.rainimatormod.registry.ModEntities;
import com.rainimator.rainimatormod.registry.ModModels;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class RainimatorModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModModels.registerLayerDefinitions();
        ModEntities.registerEntityRenderers();
    }
}
