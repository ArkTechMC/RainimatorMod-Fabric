package dev.rainimator.mod;

import com.mojang.logging.LogUtils;
import dev.rainimator.mod.ability.AbilityManager;
import dev.rainimator.mod.compat.trinkets.TrinketsRegistry;
import dev.rainimator.mod.registry.*;
import dev.rainimator.mod.util.Timeout;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;

public class RainimatorMod implements ModInitializer {
    public static final String MOD_ID = "rainimator";
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        Timeout.startTimeout();
        RainimatorFeatures.addFeatures();
        RainimatorSounds.registerSounds();
        RainimatorTrades.registerTrades();
        TrinketsRegistry.registerCommon();
        RainimatorGameRules.init();
        RainimatorParticles.init();
        FabricApiCall.run();
        AbilityManager.init();
    }
}
