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


public class SapphireArmorItem extends ArmorWithTickItem {
    public SapphireArmorItem(EquipmentSlot slot, Item.Settings properties) {
        super(new ArmorMaterial() {
            @Override
            public int getDurability(EquipmentSlot slot) {
                return new int[]{13, 15, 16, 11}[slot.getEntitySlotId()] * 40;
            }

            @Override
            public int getProtectionAmount(EquipmentSlot slot) {
                return new int[]{5, 10, 12, 6}[slot.getEntitySlotId()];
            }

            @Override
            public int getEnchantability() {
                return 25;
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
                return RainimatorMod.MOD_ID + ":sapphire_armors";
            }

            @Override
            public float getToughness() {
                return 2.5F;
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
        if (entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.SAPPHIRE_HELMET)
            if (entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == ModItems.SAPPHIRE_CHESTPLATE)
                if (entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == ModItems.SAPPHIRE_LEGGINGS)
                    if (entity.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.SAPPHIRE_BOOTS)
                        if (!entity.world.isClient()) {
                            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300, 0));
                            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 80, 0));
                            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 80, 1));
                        }
    }

    public static class Helmet extends SapphireArmorItem {
        public Helmet() {
            super(EquipmentSlot.HEAD, ModCreativeTab.createProperty());
        }
    }

    public static class Chestplate extends SapphireArmorItem {
        public Chestplate() {
            super(EquipmentSlot.CHEST, ModCreativeTab.createProperty());
        }
    }

    public static class Leggings extends SapphireArmorItem {
        public Leggings() {
            super(EquipmentSlot.LEGS, ModCreativeTab.createProperty());
        }
    }

    public static class Boots extends SapphireArmorItem {
        public Boots() {
            super(EquipmentSlot.FEET, ModCreativeTab.createProperty());
        }
    }
}