package com.rainimator.rainimatormod;

import com.rainimator.rainimatormod.registry.ModEntityRenderers;
import net.fabricmc.api.ClientModInitializer;

public class RainimatorModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModEntityRenderers.registerEntityRenderers();
    }
}
