package com.rainimator.rainimatormod.item.armor;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.registry.util.ArmorWithTickItem;
import com.rainimator.rainimatormod.registry.util.ModCreativeTab;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

public class PatrickArmorItem extends ArmorWithTickItem {
    public PatrickArmorItem(EquipmentSlot slot, Item.Settings properties) {
        super(new ArmorMaterial() {
            @Override
            public int getDurability(EquipmentSlot slot) {
                return new int[]{13, 15, 16, 11}[slot.getEntitySlotId()] * 25;
            }

            @Override
            public int getProtectionAmount(EquipmentSlot slot) {
                return new int[]{3, 8, 12, 5}[slot.getEntitySlotId()];
            }

            @Override
            public int getEnchantability() {
                return 20;
            }

            @Override
            public SoundEvent getEquipSound() {
                return null;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.ofStacks(new ItemStack(ModItems.SUPER_SAPPHIRE));
            }

            @Override
            public String getName() {
                return RainimatorMod.MOD_ID + ":patrick_armor";
            }

            @Override
            public float getToughness() {
                return 3.0F;
            }

            @Override
            public float getKnockbackResistance() {
                return 0.0F;
            }
        }, slot, properties);
    }

    @Override
    public void onArmorTick(World world, PlayerEntity entity) {
        if (entity == null) return;
        if (((LivingEntity) entity).getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.PATRICK_HELMET)
            if (((LivingEntity) entity).getEquippedStack(EquipmentSlot.CHEST).getItem() == ModItems.PATRICK_CHESTPLATE)
                if (((LivingEntity) entity).getEquippedStack(EquipmentSlot.LEGS).getItem() == ModItems.PATRICK_LEGGINGS)
                    if (((LivingEntity) entity).getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.PATRICK_BOOTS)
                        if (!entity.world.isClient()) {
                            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 80, 1));
                            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 80, 1));
                        }
    }

    public static class Helmet extends PatrickArmorItem {
        public Helmet() {
            super(EquipmentSlot.HEAD, (new Item.Settings()).group(ModCreativeTab.main));
        }
    }

    public static class Chestplate extends PatrickArmorItem {
        public Chestplate() {
            super(EquipmentSlot.CHEST, (new Item.Settings()).group(ModCreativeTab.main));
        }
    }

    public static class Leggings extends PatrickArmorItem {
        public Leggings() {
            super(EquipmentSlot.LEGS, (new Item.Settings()).group(ModCreativeTab.main));
        }
    }

    public static class Boots extends PatrickArmorItem {
        public Boots() {
            super(EquipmentSlot.FEET, (new Item.Settings()).group(ModCreativeTab.main));
        }
    }
}
