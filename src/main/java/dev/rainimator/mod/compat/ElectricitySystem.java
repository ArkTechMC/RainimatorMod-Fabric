package dev.rainimator.mod.compat;

import dev.rainimator.mod.RainimatorMod;
import net.fabricmc.loader.api.FabricLoader;

public class ElectricitySystem {
    private static final ElectricitySource currentElectricityProvider;

    static {
        RainimatorMod.LOGGER.info("Trying to find electricity provider for Rainimator Mod.");
        boolean ae2 = FabricLoader.getInstance().isModLoaded("appliedenergistics2");
        boolean tr = FabricLoader.getInstance().isModLoaded("techreborn");
        if (ae2) {
            RainimatorMod.LOGGER.info("Applied Energistics 2 found.");
            currentElectricityProvider = ElectricitySource.AE2;
        } else if (tr) {
            RainimatorMod.LOGGER.info("Tech Reborn found.");
            currentElectricityProvider = ElectricitySource.TR;
        } else
            currentElectricityProvider = ElectricitySource.NONE;
    }

    public static ElectricitySource getType() {
        return currentElectricityProvider;
    }
}
