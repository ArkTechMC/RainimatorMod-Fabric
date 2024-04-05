package com.rainimator.rainimatormod;

import com.mojang.logging.LogUtils;
import com.rainimator.rainimatormod.compat.trinkets.TrinketsRegistry;
import com.rainimator.rainimatormod.network.ServerNetworkHandler;
import com.rainimator.rainimatormod.registry.*;
import com.rainimator.rainimatormod.registry.util.ModCreativeTab;
import com.rainimator.rainimatormod.util.Timeout;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;

public class RainimatorMod implements ModInitializer {
    public static final String MOD_ID = "rainimator";
    public static final String MOD_NAME = "Rainimator";
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        if (FabricLoader.getInstance().isModLoaded("annoying_villagersbychentu")) {
            LOGGER.error("[annoying_villagersbychentu] failed to load");
            System.exit(1);
        }
        Timeout.startTimeout();
        ModEntities.init();
        ModEntities.addLivingEntityToBiomes();
        ModFeatures.addFeatures();
        ModItems.init();
        ModModels.registerLayerDefinitions();
        ModParticles.registerParticles();
        ModSounds.registerSounds();
        ModTrades.registerTrades();
        ModCreativeTab.load();
        ServerNetworkHandler.register();
        TrinketsRegistry.register();
    }
}
