package com.rainimator.rainimatormod.compat.trinkets;

import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.renderer.BackItemRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.Items;

@Environment(EnvType.CLIENT)
public class TrinketsRegistry {
    public static void register() {
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
    }
}
