package com.rainimator.rainimatormod;

import com.afoxxvi.asteorbar.overlay.FabricGuiRegistry;
import com.rainimator.rainimatormod.compat.asteorbar.ManaHud;
import com.rainimator.rainimatormod.compat.trinkets.TrinketsRegistry;
import com.rainimator.rainimatormod.registry.ModEntities;
import com.rainimator.rainimatormod.registry.ModModels;
import com.rainimator.rainimatormod.registry.ModParticles;
import com.rainimator.rainimatormod.registry.ModRenderers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;

@Environment(EnvType.CLIENT)
public class RainimatorModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModModels.registerLayerDefinitions();
        ModEntities.registerEntityRenderers();
        ModRenderers.registerRenderers();
        ModParticles.registerParticles();
        TrinketsRegistry.registerClient();
        if (FabricLoader.getInstance().isModLoaded("asteorbar"))
            FabricGuiRegistry.REGISTRY.add(FabricGuiRegistry.REGISTRY.size() - 1, new ManaHud());
    }
}
