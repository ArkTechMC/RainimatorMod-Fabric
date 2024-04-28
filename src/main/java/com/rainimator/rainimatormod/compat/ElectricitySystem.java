package com.rainimator.rainimatormod.compat;

import com.rainimator.rainimatormod.RainimatorMod;
import net.fabricmc.loader.api.FabricLoader;

public class ElectricitySystem {
    private static ElectricitySource currentElectricityProvider = null;

    private static void find() {
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
        if (currentElectricityProvider == null)
            find();
        return currentElectricityProvider;
    }
}
