package com.rainimator.rainimatormod.item.trinket;

import com.iafenvoy.mcrconvertlib.misc.Timeout;
import com.rainimator.rainimatormod.data.config.ModConfig;
import com.rainimator.rainimatormod.registry.ModKeybindings;
import dev.emi.trinkets.api.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import reborncore.common.powerSystem.RcEnergyItem;
import reborncore.common.powerSystem.RcEnergyTier;

public class WingsOfSalvationForTR extends WingsOfSalvationItem implements RcEnergyItem {
    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof PlayerEntity player && ModConfig.getInstance().enableWingsCreativeFly && !player.isCreative()) {
            player.getAbilities().allowFlying = false;
            Timeout.create(0, () -> {
                if (slot.inventory().getStack(slot.index()).getItem() != this)
                    player.getAbilities().flying = false;
            });
        }
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (!entity.getWorld().isClient() && entity instanceof ServerPlayerEntity player) {
            if (ModConfig.getInstance().enableWingsCreativeFly && !player.isCreative())
                if (player.getAbilities().flying && !this.tryUseEnergy(stack, 50))
                    noEnoughEnergy(player);
        }
        this.lastBoostTick--;
        if (this.lastBoostTick < 0) this.lastBoostTick = 0;
    }

    @Override
    public void keyPress(PlayerEntity player, ItemStack stack) {
        if (player.isFallFlying())
            if (this.lastBoostTick <= 0 && this.tryUseEnergy(stack, 800))
                this.speedUp(player);
    }

    @Override
    public long getEnergyCapacity() {
        return 600000;
    }

    @Override
    public RcEnergyTier getTier() {
        return RcEnergyTier.INFINITE;
    }
}
