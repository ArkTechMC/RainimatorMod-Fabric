package com.rainimator.rainimatormod.item.armor;

import com.iafenvoy.mcrconvertlib.item.ArmorMaterialUtil;
import com.iafenvoy.mcrconvertlib.item.ArmorWithTickItem;
import com.rainimator.rainimatormod.registry.ModGameRules;
import com.rainimator.rainimatormod.registry.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class PatrickArmorItem extends ArmorWithTickItem {
    public PatrickArmorItem(Type slot) {
        super(ArmorMaterialUtil.of("patrick_armor", new int[]{13, 15, 16, 11}, 25, new int[]{3, 8, 12, 5}, 20, Registries.SOUND_EVENT.get(new Identifier("item.armor.equip_diamond")), 3.0F, 0.0F, ModItems.SUPER_SAPPHIRE), slot, new Settings());
    }

    @Override
    public void onArmorTick(World world, PlayerEntity entity) {
        if (entity == null) return;
        if (!entity.getWorld().isClient() &&
                world.getGameRules().getBoolean(ModGameRules.enableArmorEffect) &&
                entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.PATRICK_HELMET &&
                entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == ModItems.PATRICK_CHESTPLATE &&
                entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == ModItems.PATRICK_LEGGINGS &&
                entity.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.PATRICK_BOOTS) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 80, 1));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 80, 1));
        }
    }
}
