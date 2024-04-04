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
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;


public class RubyArmorItem extends ArmorWithTickItem {
    public RubyArmorItem(Type slot, Item.Settings properties) {
        super(new ArmorMaterial() {
            @Override
            public int getDurability(Type slot) {
                return new int[]{13, 15, 16, 11}[slot.getEquipmentSlot().getEntitySlotId()] * 40;
            }

            @Override
            public int getProtection(Type slot) {
                return new int[]{5, 10, 12, 6}[slot.getEquipmentSlot().getEntitySlotId()];
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
                return RainimatorMod.MOD_ID + ":ruby_armor";
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
        if (entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.RUBY_HELMET)
            if (entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == ModItems.RUBY_CHESTPLATE)
                if (entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == ModItems.RUBY_LEGGINGS)
                    if (entity.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.RUBY_BOOTS)
                        if (!entity.getWorld().isClient()) {
                            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 80, 0));
                            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 80, 1));
                        }
    }

    public static class Helmet extends RubyArmorItem {
        public Helmet() {
            super(Type.HELMET, new Settings());
        }
    }

    public static class Chestplate extends RubyArmorItem {
        public Chestplate() {
            super(Type.CHESTPLATE, new Settings());
        }
    }

    public static class Leggings extends RubyArmorItem {
        public Leggings() {
            super(Type.LEGGINGS, new Settings());
        }
    }

    public static class Boots extends RubyArmorItem {
        public Boots() {
            super(Type.BOOTS, new Settings());
        }
    }
}
