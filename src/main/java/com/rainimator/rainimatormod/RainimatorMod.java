package com.rainimator.rainimatormod;

import com.mojang.logging.LogUtils;
import com.rainimator.rainimatormod.compat.trinkets.TrinketsRegistry;
import com.rainimator.rainimatormod.registry.*;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;

public class RainimatorMod implements ModInitializer {
    public static final String MOD_ID = "rainimator";
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        ModBlockEntities.register();
        ModFeatures.addFeatures();
        ModSounds.registerSounds();
        ModTrades.registerTrades();
        FabricApiCall.run();
        TrinketsRegistry.registerCommon();
        ModParticles.init();
        ModGameRules.init();
    }
}
