package com.rainimator.rainimatormod.compat.trinkets;

import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.renderer.BackItemRenderer;
import com.rainimator.rainimatormod.renderer.WingsOfSalvationRenderer;
import dev.emi.trinkets.api.TrinketsApi;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.minecraft.item.Items;

public class TrinketsRegistry {
    public static void registerClient() {
        TrinketRendererRegistry.registerRenderer(Items.WOODEN_SWORD, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(Items.STONE_SWORD, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(Items.IRON_SWORD, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(Items.GOLDEN_SWORD, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(Items.DIAMOND_SWORD, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(Items.NETHERITE_SWORD, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(ModItems.ENDER_BIG_SWORD, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(ModItems.NETHER_SPEAR, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(ModItems.RAIN_SWORD, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(ModItems.ABIGAIL_SPEAR, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(ModItems.WINGS_OF_SALVATION, new WingsOfSalvationRenderer());
    }

    public static void registerCommon() {
        TrinketsApi.registerTrinket(ModItems.WINGS_OF_SALVATION, ModItems.WINGS_OF_SALVATION);
    }
}
