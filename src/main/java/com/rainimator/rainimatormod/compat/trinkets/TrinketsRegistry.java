package com.rainimator.rainimatormod.compat.trinkets;

import com.rainimator.rainimatormod.renderer.BackItemLayer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.minecraft.item.Items;

public class TrinketsRegistry {
    public static void register() {
        TrinketRendererRegistry.registerRenderer(Items.DIAMOND_SWORD, new BackItemLayer());
    }
}
