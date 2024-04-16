package com.rainimator.rainimatormod.item.armor;

import com.iafenvoy.mcrconvertlib.item.ArmorMaterialUtil;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;


public class MagicHatItem extends ArmorItem {
    public MagicHatItem(Type slot, Item.Settings properties) {
        super(ArmorMaterialUtil.of("magic_hat", new int[]{13, 15, 16, 11}, 8, new int[]{0, 0, 0, 4}, 50, null, 0.5F, 0.0F), slot, properties);
    }

    public static class Helmet extends MagicHatItem {
        public Helmet() {
            super(Type.HELMET, new Settings());
        }
    }
}
