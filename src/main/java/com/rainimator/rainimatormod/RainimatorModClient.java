package com.rainimator.rainimatormod;

import com.afoxxvi.asteorbar.overlay.FabricGuiRegistry;
import com.rainimator.rainimatormod.compat.ElectricitySource;
import com.rainimator.rainimatormod.compat.ElectricitySystem;
import com.rainimator.rainimatormod.compat.asteorbar.ElectricityHud;
import com.rainimator.rainimatormod.compat.asteorbar.ManaHud;
import com.rainimator.rainimatormod.compat.trinkets.TrinketsRegistry;
import com.rainimator.rainimatormod.registry.*;
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
        ModKeybindings.register();
        TrinketsRegistry.registerClient();
        if (FabricLoader.getInstance().isModLoaded("asteorbar")) {
            FabricGuiRegistry.REGISTRY.add(FabricGuiRegistry.REGISTRY.size() - 1, new ManaHud());
            if (ElectricitySystem.getType() != ElectricitySource.NONE)
                FabricGuiRegistry.REGISTRY.add(FabricGuiRegistry.REGISTRY.size() - 1, new ElectricityHud());
        }
    }
}
