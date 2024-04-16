package com.rainimator.rainimatormod;

import com.mojang.logging.LogUtils;
import com.rainimator.rainimatormod.network.ServerNetworkHandler;
import com.rainimator.rainimatormod.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.Ingredient;
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
        ModEntities.init();
        ModEntities.addLivingEntityToBiomes();
        ModItems.init();
        ModFeatures.addFeatures();
        ModParticles.registerParticles();
        ModSounds.registerSounds();
        ModTrades.registerTrades();
        ModCreativeTabs.load();
        ServerNetworkHandler.register();
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Ingredient.ofItems(ModItems.BLUE_DIAMOND), new Potion("purification", new StatusEffectInstance(ModEffects.PURIFICATION, 3000, 0)));
    }
}
