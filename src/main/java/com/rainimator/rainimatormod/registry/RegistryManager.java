package com.rainimator.rainimatormod.registry;

public class RegistryManager {
    public static void register() {
        ModEntities.init();
        ModEntities.registerAttributes();
        ModEntities.addLivingEntityToBiomes();
        ModItems.init();
        ModModels.registerLayerDefinitions();
        ModParticles.registerParticles();
        ModSounds.registerSounds();
        ModTrades.registerTrades();
    }
}
