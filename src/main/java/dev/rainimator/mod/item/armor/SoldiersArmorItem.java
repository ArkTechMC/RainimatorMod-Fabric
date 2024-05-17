package dev.rainimator.mod.item.armor;

import com.iafenvoy.mcrconvertlib.item.ArmorMaterialUtil;
import com.iafenvoy.mcrconvertlib.item.ArmorWithTickItem;
import dev.rainimator.mod.registry.ModGameRules;
import dev.rainimator.mod.registry.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class SoldiersArmorItem extends ArmorWithTickItem {
    public SoldiersArmorItem(Type slot) {
        super(ArmorMaterialUtil.of("soldiers_armor", new int[]{13, 15, 16, 11}, 25, new int[]{4, 8, 9, 4}, 10, Registries.SOUND_EVENT.get(new Identifier("item.armor.equip_diamond")), 2.0F, 0.0F), slot, new Settings());
    }

    @Override
    public void onArmorTick(World world, PlayerEntity entity) {
        if (entity == null)
            return;
        if (!entity.getWorld().isClient() &&
                world.getGameRules().getBoolean(ModGameRules.enableArmorEffect) &&
                entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.SOLDIERS_ARMOR_HELMET &&
                entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == ModItems.SOLDIERS_ARMOR_CHESTPLATE &&
                entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == ModItems.SOLDIERS_ARMOR_LEGGINGS &&
                entity.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.SOLDIERS_ARMOR_BOOTS)
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 80, 0));
    }
}
