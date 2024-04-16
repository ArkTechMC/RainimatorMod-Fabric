package com.rainimator.rainimatormod.item.armor;

import com.iafenvoy.mcrconvertlib.item.ArmorMaterialUtil;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;


public class PorkshireKingCrownItem extends ArmorItem {
    public PorkshireKingCrownItem(Type slot, Item.Settings properties) {
        super(ArmorMaterialUtil.of("porkshire_king_crown", new int[]{13, 15, 16, 11}, 15, new int[]{0, 0, 0, 4}, 9, null, 0.0F, 0.0F), slot, properties);
    }

    public static class Helmet extends PorkshireKingCrownItem {
        public Helmet() {
            super(Type.HELMET, new Settings());
        }
    }
}
