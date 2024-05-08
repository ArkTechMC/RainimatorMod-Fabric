package com.rainimator.rainimatormod.item.armor;

import com.iafenvoy.mcrconvertlib.item.ArmorMaterialUtil;
import com.rainimator.rainimatormod.registry.ModItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class HerobrineArmorItem extends ArmorItem {
    public HerobrineArmorItem(Type slot) {
        super(ArmorMaterialUtil.of("herobrine_armors", new int[]{13, 15, 16, 11}, 20, new int[]{0, 0, 20, 0}, 17, Registries.SOUND_EVENT.get(new Identifier("item.armor.equip_diamond")), 5.0F, 0.0F, ModItems.SUPER_RUBY, ModItems.HEROBRINE_CHESTPLATE), slot, new Settings());
    }
}
