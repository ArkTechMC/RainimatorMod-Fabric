package com.rainimator.rainimatormod.item.armor;

import com.iafenvoy.mcrconvertlib.item.ArmorMaterialUtil;
import com.rainimator.rainimatormod.registry.ModItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class RainArmorItem extends ArmorItem {
    public RainArmorItem(Type slot) {
        super(ArmorMaterialUtil.of("rain_armors", new int[]{13, 15, 16, 11}, 20, new int[]{0, 0, 20, 0}, 30, Registries.SOUND_EVENT.get(new Identifier("item.armor.equip_diamond")), 0.0F, 0.0F, ModItems.SUPER_SAPPHIRE, ModItems.RAIN_CHESTPLATE), slot,  new Settings());
    }
}