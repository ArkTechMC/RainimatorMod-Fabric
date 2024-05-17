package dev.rainimator.mod.compat.trinkets;

import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketsApi;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import dev.rainimator.mod.registry.ModItems;
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
        TrinketRendererRegistry.registerRenderer(ModItems.ENDER_BIG_SWORD, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(ModItems.NETHER_SPEAR, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(ModItems.RAIN_SWORD, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(ModItems.ABIGAIL_SPEAR, new BackItemRenderer());
        TrinketRendererRegistry.registerRenderer(ModItems.WINGS_OF_SALVATION, new WingsOfSalvationRenderer());

        TrinketRendererRegistry.registerRenderer(ModItems.KING_NORMAL_CROWN, new KingNormalCrownRenderer());
        TrinketRendererRegistry.registerRenderer(ModItems.GLUTTON_HELMET, new GluttonArmorHelmetRenderer());
        TrinketRendererRegistry.registerRenderer(ModItems.MAGIC_HAT, new MagicHatRenderer());
        TrinketRendererRegistry.registerRenderer(ModItems.NETHER_THE_CROWN, new NetherTheCrownRenderer());
        TrinketRendererRegistry.registerRenderer(ModItems.PIGLIN_KING_CROWN, new PiglinKingCrownRenderer());
        TrinketRendererRegistry.registerRenderer(ModItems.PORKSHIRE_KING_CROWN, new PorkshireKingCrownRenderer());
    }

    public static void registerCommon() {
        TrinketsApi.registerTrinket(ModItems.WINGS_OF_SALVATION, (Trinket) ModItems.WINGS_OF_SALVATION);
    }
}
