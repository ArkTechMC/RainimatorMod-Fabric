package dev.rainimator.mod.item.armor;

import com.iafenvoy.mcrconvertlib.item.ArmorMaterialUtil;
import dev.rainimator.mod.registry.RainimatorItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class HerobrineArmorItem extends ArmorItem {
    public HerobrineArmorItem(Type slot) {
        super(ArmorMaterialUtil.of("herobrine_armors", new int[]{13, 15, 16, 11}, 20, new int[]{0, 0, 20, 0}, 17, Registries.SOUND_EVENT.get(new Identifier("item.armor.equip_diamond")), 5.0F, 0.0F, RainimatorItems.SUPER_RUBY, RainimatorItems.HEROBRINE_CHESTPLATE), slot, new Settings());
    }
}
