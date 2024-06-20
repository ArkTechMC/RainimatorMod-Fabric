package dev.rainimator.mod;

import com.mojang.logging.LogUtils;
import dev.rainimator.mod.ability.AbilityManager;
import dev.rainimator.mod.network.EnderBookActionHandler;
import dev.rainimator.mod.registry.*;
import dev.rainimator.mod.util.ModConstants;
import dev.rainimator.mod.util.Timeout;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import org.slf4j.Logger;

public class RainimatorMod implements ModInitializer {
    public static final String MOD_ID = "rainimator";
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        Timeout.startTimeout();

        RainimatorBanners.init();
        RainimatorBlockEntities.init();
        RainimatorBlocks.init();
        RainimatorEffects.init();
        RainimatorEnchantments.init();
        RainimatorEntities.init();
        RainimatorFeatures.init();
        RainimatorGameRules.init();
        RainimatorItemGroups.init();
        RainimatorItems.init();
        RainimatorParticles.init();
        RainimatorPotions.init();
        RainimatorScreenHandlers.init();
        RainimatorSkulls.init();
        RainimatorSounds.init();
        RainimatorTrades.registerTrades();

        FabricApiCall.run();
        AbilityManager.init();

        ServerPlayNetworking.registerGlobalReceiver(ModConstants.ENDER_BOOK_SKILL_PACKET_ID, new EnderBookActionHandler());
    }
}
