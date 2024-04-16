package com.rainimator.rainimatormod.item.armor;

import com.iafenvoy.mcrconvertlib.item.ArmorMaterialUtil;
import com.iafenvoy.mcrconvertlib.item.ArmorWithTickItem;
import com.rainimator.rainimatormod.registry.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class PatrickArmorItem extends ArmorWithTickItem {
    public PatrickArmorItem(Type slot, Item.Settings properties) {
        super(ArmorMaterialUtil.of("patrick_armor", new int[]{13, 15, 16, 11}, 25, new int[]{3, 8, 12, 5}, 20, null, 3.0F, 0.0F,ModItems.SUPER_SAPPHIRE), slot, properties);
    }

    @Override
    public void onArmorTick(World world, PlayerEntity entity) {
        if (entity == null) return;
        if (((LivingEntity) entity).getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.PATRICK_HELMET)
            if (((LivingEntity) entity).getEquippedStack(EquipmentSlot.CHEST).getItem() == ModItems.PATRICK_CHESTPLATE)
                if (((LivingEntity) entity).getEquippedStack(EquipmentSlot.LEGS).getItem() == ModItems.PATRICK_LEGGINGS)
                    if (((LivingEntity) entity).getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.PATRICK_BOOTS)
                        if (!entity.getWorld().isClient()) {
                            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 80, 1));
                            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 80, 1));
                        }
    }

    public static class Helmet extends PatrickArmorItem {
        public Helmet() {
            super(Type.HELMET, new Settings());
        }
    }

    public static class Chestplate extends PatrickArmorItem {
        public Chestplate() {
            super(Type.CHESTPLATE, new Settings());
        }
    }

    public static class Leggings extends PatrickArmorItem {
        public Leggings() {
            super(Type.LEGGINGS, new Settings());
        }
    }

    public static class Boots extends PatrickArmorItem {
        public Boots() {
            super(Type.BOOTS, new Settings());
        }
    }
}
