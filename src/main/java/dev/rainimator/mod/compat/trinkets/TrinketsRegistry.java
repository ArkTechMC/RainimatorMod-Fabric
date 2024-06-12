package dev.rainimator.mod.compat.trinkets;

import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketsApi;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import dev.rainimator.mod.registry.RainimatorItems;
import dev.rainimator.mod.renderer.BackItemRenderer;
import dev.rainimator.mod.renderer.WingsOfSalvationRenderer;
import dev.rainimator.mod.renderer.armor.*;
import net.minecraft.item.Items;

public class TrinketsRegistry {
    public static void registerClient() {
        TrinketRendererRegistry.registerRenderer(Items.WOODEN_SWORD, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(Items.STONE_SWORD, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(Items.IRON_SWORD, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(Items.GOLDEN_SWORD, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(Items.DIAMOND_SWORD, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(Items.NETHERITE_SWORD, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(RainimatorItems.ENDER_BIG_SWORD, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(RainimatorItems.NETHER_SPEAR, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(RainimatorItems.RAIN_SWORD, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(RainimatorItems.ABIGAIL_SPEAR, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(RainimatorItems.WINGS_OF_SALVATION, new WingsOfSalvationRenderer());

        TrinketRendererRegistry.registerRenderer(RainimatorItems.KING_NORMAL_CROWN, new KingNormalCrownRenderer());
        TrinketRendererRegistry.registerRenderer(RainimatorItems.GLUTTON_HELMET, new GluttonArmorHelmetRenderer());
        TrinketRendererRegistry.registerRenderer(RainimatorItems.MAGIC_HAT, new MagicHatRenderer());
        TrinketRendererRegistry.registerRenderer(RainimatorItems.NETHER_THE_CROWN, new NetherTheCrownRenderer());
        TrinketRendererRegistry.registerRenderer(RainimatorItems.PIGLIN_KING_CROWN, new PiglinKingCrownRenderer());
        TrinketRendererRegistry.registerRenderer(RainimatorItems.PORKSHIRE_KING_CROWN, new PorkshireKingCrownRenderer());
    }

    public static void registerCommon() {
        TrinketsApi.registerTrinket(RainimatorItems.WINGS_OF_SALVATION, (Trinket) RainimatorItems.WINGS_OF_SALVATION);
    }
}
