package com.rainimator.rainimatormod.item.armor;

import com.iafenvoy.mcrconvertlib.item.ArmorMaterialUtil;
import com.iafenvoy.mcrconvertlib.item.ArmorWithTickItem;
import com.rainimator.rainimatormod.registry.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ChiefOfThePigPeopleArmorItem extends ArmorWithTickItem {
    public ChiefOfThePigPeopleArmorItem(Type slot, Item.Settings properties) {
        super(ArmorMaterialUtil.of("chief_of_the_pig_people_armors", new int[]{13, 15, 16, 11}, 25, new int[]{5, 10, 12, 5}, 10, Registries.SOUND_EVENT.get(new Identifier("item.armor.equip_diamond")), 3.0F, 0F, Items.NETHERITE_INGOT), slot, properties);
    }

    @Override
    public void onArmorTick(World world, PlayerEntity entity) {
        if (entity == null)
            return;
        if (entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.CHIEF_OF_THE_PIG_PEOPLE_HELMET)
            if (entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == ModItems.CHIEF_OF_THE_PIG_PEOPLE_CHESTPLATE)
                if (entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == ModItems.CHIEF_OF_THE_PIG_PEOPLE_LEGGINGS)
                    if (entity.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.CHIEF_OF_THE_PIG_PEOPLE_BOOTS)
                        if (!entity.getWorld().isClient()) {
                            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 80, 1));
                            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 80, 1));
                        }
    }

    public static class Helmet extends ChiefOfThePigPeopleArmorItem {
        public Helmet() {
            super(Type.HELMET, new Settings());
        }
    }

    public static class Chestplate extends ChiefOfThePigPeopleArmorItem {
        public Chestplate() {
            super(Type.CHESTPLATE, new Settings());
        }
    }

    public static class Leggings extends ChiefOfThePigPeopleArmorItem {
        public Leggings() {
            super(Type.LEGGINGS, new Settings());
        }
    }

    public static class Boots extends ChiefOfThePigPeopleArmorItem {
        public Boots() {
            super(Type.BOOTS, new Settings());
        }
    }
}
