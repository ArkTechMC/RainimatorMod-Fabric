package dev.rainimator.mod;

import com.mojang.logging.LogUtils;
import dev.rainimator.mod.ability.AbilityManager;
import dev.rainimator.mod.compat.trinkets.TrinketsRegistry;
import dev.rainimator.mod.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
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
        ModParticles.init();
        FabricApiCall.run();
        AbilityManager.init();
    }
}
