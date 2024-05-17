package dev.rainimator.mod;

import com.mojang.logging.LogUtils;
import dev.rainimator.mod.compat.trinkets.TrinketsRegistry;
import dev.rainimator.mod.registry.ModFeatures;
import dev.rainimator.mod.registry.ModGameRules;
import dev.rainimator.mod.registry.ModSounds;
import dev.rainimator.mod.registry.ModTrades;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;

public class RainimatorMod implements ModInitializer {
    public static final String MOD_ID = "rainimator";
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        ModFeatures.addFeatures();
        ModSounds.registerSounds();
        ModTrades.registerTrades();
        TrinketsRegistry.registerCommon();
        ModGameRules.init();
        FabricApiCall.run();
    }
}
