package com.rainimator.rainimatormod.item.armor;

import com.iafenvoy.mcrconvertlib.item.ArmorMaterialUtil;
import com.rainimator.rainimatormod.registry.ModItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class HerobrineArmorItem extends ArmorItem {
    public HerobrineArmorItem(Type slot, Item.Settings properties) {
        super(ArmorMaterialUtil.of("herobrine_armors", new int[]{13, 15, 16, 11}, 20, new int[]{0, 0, 20, 0}, 17, null, 5.0F, 0.0F, ModItems.SUPER_RUBY, ModItems.HEROBRINE_CHESTPLATE), slot, properties);
    }

    public static class Chestplate extends HerobrineArmorItem {
        public Chestplate() {
            super(Type.CHESTPLATE, new Settings());
        }
    }
}
