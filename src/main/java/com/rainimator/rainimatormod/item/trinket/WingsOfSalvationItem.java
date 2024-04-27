package com.rainimator.rainimatormod.item.trinket;

import com.iafenvoy.mcrconvertlib.item.ItemBase;
import com.rainimator.rainimatormod.compat.cca.ManaComponent;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class WingsOfSalvationItem extends ItemBase implements Trinket, FabricElytraItem {
    public WingsOfSalvationItem() {
        super(p -> p);
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof PlayerEntity player)
            player.getAbilities().allowFlying = true;
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof PlayerEntity player)
            player.getAbilities().allowFlying = false;
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof PlayerEntity player && player.getAbilities().flying)
            if (!ManaComponent.MANA_COMPONENT.get(entity).tryUseMana(5))
                player.getAbilities().flying = false;
    }

    @Override
    public boolean useCustomElytra(LivingEntity entity, ItemStack chestStack, boolean tickElytra) {
        return true;
    }
}
