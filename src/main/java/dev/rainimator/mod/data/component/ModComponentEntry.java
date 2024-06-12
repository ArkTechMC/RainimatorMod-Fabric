package dev.rainimator.mod.data.component;

import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;

public class ModComponentEntry implements EntityComponentInitializer {
    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(ManaComponent.MANA_COMPONENT, ManaComponent::new, RespawnCopyStrategy.INVENTORY);
        registry.registerForPlayers(AbilityComponent.ABILITY_COMPONENT, AbilityComponent::new, RespawnCopyStrategy.INVENTORY);
    }
}
