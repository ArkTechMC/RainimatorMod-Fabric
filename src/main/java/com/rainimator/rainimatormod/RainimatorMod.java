package com.rainimator.rainimatormod;

import com.mojang.logging.LogUtils;
import com.rainimator.rainimatormod.compat.trinkets.TrinketsRegistry;
import com.rainimator.rainimatormod.config.ModConfig;
import com.rainimator.rainimatormod.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;

public class RainimatorMod implements ModInitializer {
    public static final String MOD_ID = "rainimator";
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        if (FabricLoader.getInstance().isModLoaded("annoying_villagersbychentu")) {
            LOGGER.error("[annoying_villagersbychentu] failed to load");
            System.exit(1);
        }
        ModEntities.init();
        ModItems.init();
        ModFeatures.addFeatures();
        ModSounds.registerSounds();
        ModTrades.registerTrades();
        ModConfig.load();
        FabricApiCall.run();
        TrinketsRegistry.registerCommon();
    }
}
