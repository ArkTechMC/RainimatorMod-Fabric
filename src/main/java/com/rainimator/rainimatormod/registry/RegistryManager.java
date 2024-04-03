package com.rainimator.rainimatormod.registry;

public class RegistryManager {
    public static void register() {
        ModEntities.init();
        ModEntities.addLivingEntityToBiomes();
        ModEntityRenderers.registerEntityRenderers();
        ModItems.init();
        ModModels.registerLayerDefinitions();
//        ModOres.init();
        ModParticles.registerParticles();
        ModSounds.registerSounds();
        ModTrades.registerTrades();
    }
}
