package com.rainimator.rainimatormod;

import com.rainimator.rainimatormod.registry.ModEntities;
import net.fabricmc.api.ClientModInitializer;

public class RainimatorModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModEntities.registerAttributes();
    }
}
