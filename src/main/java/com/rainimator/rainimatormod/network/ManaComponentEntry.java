package com.rainimator.rainimatormod.network;

import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;

public class ManaComponentEntry implements EntityComponentInitializer {
    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(ManaComponent.MANA_COMPONENT, ManaComponent::new, RespawnCopyStrategy.INVENTORY);
    }
}
