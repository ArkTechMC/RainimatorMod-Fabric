package com.rainimator.rainimatormod.item.armor;

import com.iafenvoy.mcrconvertlib.item.ArmorMaterialUtil;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;


public class PiglinKingCrownItem extends ArmorItem {
    public PiglinKingCrownItem(Type slot, Item.Settings properties) {
        super(ArmorMaterialUtil.of("piglin_king_crown", new int[]{13, 15, 16, 11}, 15, new int[]{0, 0, 0, 3}, 9, null, 0.0F, 0.0F), slot, properties);
    }

    public static class Helmet extends PiglinKingCrownItem {
        public Helmet() {
            super(Type.HELMET, new Settings());
        }
    }
}

