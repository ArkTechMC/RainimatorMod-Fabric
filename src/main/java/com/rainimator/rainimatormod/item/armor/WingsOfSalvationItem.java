package com.rainimator.rainimatormod.item.armor;

import com.rainimator.rainimatormod.RainimatorMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public class WingsOfSalvationItem extends ArmorItem {
    public WingsOfSalvationItem(Type slot, Settings properties) {
        super(new ArmorMaterial() {
            @Override
            public int getDurability(Type slot) {
                return new int[]{13, 15, 16, 11}[slot.getEquipmentSlot().getEntitySlotId()] * 15;
            }

            @Override
            public int getProtection(Type slot) {
                return new int[]{0, 0, 0, 4}[slot.getEquipmentSlot().getEntitySlotId()];
            }

            @Override
            public int getEnchantability() {
                return 9;
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
                return RainimatorMod.MOD_ID + ":wings_of_salvation";
            }

            @Override
            public float getToughness() {
                return 0.0F;
            }

            @Override
            public float getKnockbackResistance() {
                return 0.0F;
            }
        }, slot, properties);
    }

    public static class Chestplate extends WingsOfSalvationItem {
        public Chestplate() {
            super(Type.CHESTPLATE, new Settings());
        }
    }
}
