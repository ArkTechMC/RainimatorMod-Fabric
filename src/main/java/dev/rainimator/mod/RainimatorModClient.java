package dev.rainimator.mod;

import com.afoxxvi.asteorbar.overlay.FabricGuiRegistry;
import dev.rainimator.mod.compat.ElectricitySource;
import dev.rainimator.mod.compat.ElectricitySystem;
import dev.rainimator.mod.compat.asteorbar.ElectricityHud;
import dev.rainimator.mod.compat.asteorbar.ManaHud;
import dev.rainimator.mod.compat.trinkets.TrinketsRegistry;
import dev.rainimator.mod.registry.RainimatorModels;
import dev.rainimator.mod.registry.RainimatorParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;

@Environment(EnvType.CLIENT)
public class RainimatorModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RainimatorModels.registerLayerDefinitions();
        RainimatorParticles.registerParticles();
        TrinketsRegistry.registerClient();
        if (FabricLoader.getInstance().isModLoaded("asteorbar")) {
            FabricGuiRegistry.REGISTRY.add(FabricGuiRegistry.REGISTRY.size() - 1, new ManaHud());
            if (ElectricitySystem.getType() != ElectricitySource.NONE)
                FabricGuiRegistry.REGISTRY.add(FabricGuiRegistry.REGISTRY.size() - 1, new ElectricityHud());
        }
    }
}
