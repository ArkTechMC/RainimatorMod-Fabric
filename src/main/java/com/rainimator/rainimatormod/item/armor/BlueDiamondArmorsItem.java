package com.rainimator.rainimatormod.item.armor;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.registry.util.ArmorWithTickItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

public class BlueDiamondArmorsItem extends ArmorWithTickItem {
    public BlueDiamondArmorsItem(Type slot, Item.Settings properties) {
        super(new ArmorMaterial() {
            @Override
            public int getDurability(Type slot) {
                return new int[]{13, 15, 16, 11}[slot.getEquipmentSlot().getEntitySlotId()] * 70;
            }

            @Override
            public int getProtection(Type slot) {
                return new int[]{9, 13, 18, 10}[slot.getEquipmentSlot().getEntitySlotId()];
            }

            @Override
            public int getEnchantability() {
                return 40;
            }

            @Override
            public SoundEvent getEquipSound() {
                return null;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.ofStacks(new ItemStack(ModItems.BLUE_DIAMOND));
            }

            @Override
            public String getName() {
                return RainimatorMod.MOD_ID + ":blue_diamond_armors";
            }

            @Override
            public float getToughness() {
                return 5.0F;
            }

            @Override
            public float getKnockbackResistance() {
                return 0.3F;
            }
        }, slot, properties);
    }

    @Override
    public void onArmorTick(World world, PlayerEntity entity) {
        if (entity == null)
            return;
        if (entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.BLUE_DIAMOND_HELMET)
            if (entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == ModItems.BLUE_DIAMOND_CHESTPLATE)
                if (entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == ModItems.BLUE_DIAMOND_LEGGINGS)
                    if (entity.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.BLUE_DIAMOND_BOOTS)
                        if (!entity.getWorld().isClient()) {
                            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 80, 1));
                            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 80, 2));
                            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 80, 0));
                            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 80, 0));
                            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 80, 4));
                        }
    }

    public static class Helmet extends BlueDiamondArmorsItem {
        public Helmet() {
            super(Type.HELMET, new Settings().fireproof());
        }
    }

    public static class Chestplate extends BlueDiamondArmorsItem {
        public Chestplate() {
            super(Type.CHESTPLATE, new Settings().fireproof());
        }
    }

    public static class Leggings extends BlueDiamondArmorsItem {
        public Leggings() {
            super(Type.LEGGINGS, new Settings().fireproof());
        }
    }

    public static class Boots extends BlueDiamondArmorsItem {
        public Boots() {
            super(Type.BOOTS, new Settings().fireproof());
        }
    }
}

