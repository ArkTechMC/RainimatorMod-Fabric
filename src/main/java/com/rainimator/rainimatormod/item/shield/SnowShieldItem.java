package com.rainimator.rainimatormod.item.shield;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.UUID;

public class SnowShieldItem extends ShieldItem {
    protected static final UUID OFF_HAND_MODIFIER = UUID.fromString("9271eeea-5f74-4e12-97b6-7cf3c60ef7a0");
    protected static final UUID MAIN_HAND_MODIFIER = UUID.fromString("7d766720-0695-46c6-b320-44529f3da63f");

    public SnowShieldItem() {
        super(new Settings().maxCount(1).maxDamage(1000).rarity(Rarity.UNCOMMON));
    }

    @Override
    public UseAction getUseAction(ItemStack itemStack) {
        return UseAction.BLOCK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World level, PlayerEntity playerIn, Hand hand) {
        ItemStack itemstack = playerIn.getStackInHand(hand);
        playerIn.setCurrentHand(hand);
        return TypedActionResult.consume(itemstack);
    }

    @Override
    public boolean canRepair(ItemStack itemStack, ItemStack itemStack2) {
        return (itemStack2.isIn(ItemTags.PLANKS) || super.canRepair(itemStack, itemStack2));
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(ItemStack stack, EquipmentSlot equipmentSlot) {
        Multimap<EntityAttribute, EntityAttributeModifier> hashMultimap = HashMultimap.create();
        if (equipmentSlot == EquipmentSlot.OFFHAND) {
            hashMultimap.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(OFF_HAND_MODIFIER, "Weapon modifier", 0.2D, EntityAttributeModifier.Operation.fromId(0)));
            hashMultimap.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(MAIN_HAND_MODIFIER, "Weapon modifier", 4.0D, EntityAttributeModifier.Operation.fromId(0)));
        }
        if (equipmentSlot == EquipmentSlot.MAINHAND)
            hashMultimap.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(MAIN_HAND_MODIFIER, "Weapon modifier", 4.0D, EntityAttributeModifier.Operation.fromId(0)));
        return hashMultimap;
    }
}
