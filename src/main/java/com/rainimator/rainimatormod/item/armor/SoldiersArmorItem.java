package com.rainimator.rainimatormod.item.armor;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.registry.util.ArmorWithTickItem;
import com.rainimator.rainimatormod.registry.util.ModCreativeTab;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;


public class SoldiersArmorItem extends ArmorWithTickItem {
    public SoldiersArmorItem(EquipmentSlot slot, Item.Settings properties) {
        super(new ArmorMaterial() {
            @Override
            public int getDurability(EquipmentSlot slot) {
                return new int[]{13, 15, 16, 11}[slot.getEntitySlotId()] * 25;
            }

            @Override
            public int getProtectionAmount(EquipmentSlot slot) {
                return new int[]{4, 8, 9, 4}[slot.getEntitySlotId()];
            }

            @Override
            public int getEnchantability() {
                return 10;
            }

            @Override
            public SoundEvent getEquipSound() {
                return null;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.empty();
            }

            @Override
            public String getName() {
                return RainimatorMod.MOD_ID + ":soldiers_armor";
            }

            @Override
            public float getToughness() {
                return 2.0F;
            }

            @Override
            public float getKnockbackResistance() {
                return 0.0F;
            }
        }, slot, properties);
    }

    @Override
    public void onArmorTick(World world, PlayerEntity entity) {
        if (entity == null)
            return;
        if (entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.SOLDIERS_ARMOR_HELMET)
            if (entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == ModItems.SOLDIERS_ARMOR_CHESTPLATE)
                if (entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == ModItems.SOLDIERS_ARMOR_LEGGINGS)
                    if (entity.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.SOLDIERS_ARMOR_BOOTS)
                        if (!entity.world.isClient())
                            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 80, 0));
    }

    public static class Helmet extends SoldiersArmorItem {
        public Helmet() {
            super(EquipmentSlot.HEAD, ModCreativeTab.createProperty());
        }
    }

    public static class Chestplate extends SoldiersArmorItem {
        public Chestplate() {
            super(EquipmentSlot.CHEST, ModCreativeTab.createProperty());
        }
    }

    public static class Leggings extends SoldiersArmorItem {
        public Leggings() {
            super(EquipmentSlot.LEGS, ModCreativeTab.createProperty());
        }
    }

    public static class Boots extends SoldiersArmorItem {
        public Boots() {
            super(EquipmentSlot.FEET, ModCreativeTab.createProperty());
        }
    }
}
