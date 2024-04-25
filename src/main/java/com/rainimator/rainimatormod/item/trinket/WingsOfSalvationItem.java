package com.rainimator.rainimatormod.item.trinket;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;

public class WingsOfSalvationItem extends ElytraItem implements Trinket, FabricElytraItem {
    public WingsOfSalvationItem() {
        super(new Settings().maxDamage(3000));
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof PlayerEntity player) {
            player.getAbilities().flying = true;
            player.getAbilities().allowFlying = true;
        }
        System.out.println(111);
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof PlayerEntity player) {
            player.getAbilities().flying = false;
            player.getAbilities().allowFlying = false;
        }
    }
}
