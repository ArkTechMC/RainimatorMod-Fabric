package com.rainimator.rainimatormod.item.armor;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.registry.util.ModCreativeTab;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public class HerobrineArmorItem extends ArmorItem {
    public HerobrineArmorItem(EquipmentSlot slot, Item.Settings properties) {
        super(new ArmorMaterial() {
            @Override
            public int getDurability(EquipmentSlot slot) {
                return new int[]{13, 15, 16, 11}[slot.getEntitySlotId()] * 20;
            }

            @Override
            public int getProtectionAmount(EquipmentSlot slot) {
                return new int[]{0, 0, 20, 0}[slot.getEntitySlotId()];
            }

            @Override
            public int getEnchantability() {
                return 17;
            }

            @Override
            public SoundEvent getEquipSound() {
                return null;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.ofStacks(new ItemStack(ModItems.SUPER_RUBY), new ItemStack(ModItems.HEROBRINE_CHESTPLATE));
            }

            @Override
            public String getName() {
                return RainimatorMod.MOD_ID + ":herobrine_armors";
            }

            @Override
            public float getToughness() {
                return 5.0F;
            }

            @Override
            public float getKnockbackResistance() {
                return 0.0F;
            }
        }, slot, properties);
    }

    public static class Chestplate extends HerobrineArmorItem {
        public Chestplate() {
            super(EquipmentSlot.CHEST, ModCreativeTab.createProperty());
        }
    }
}
