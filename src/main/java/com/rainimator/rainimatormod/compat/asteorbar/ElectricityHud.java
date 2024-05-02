package com.rainimator.rainimatormod.compat.asteorbar;

import com.afoxxvi.asteorbar.overlay.parts.SimpleBarOverlay;
import com.rainimator.rainimatormod.compat.ElectricitySource;
import com.rainimator.rainimatormod.compat.ElectricitySystem;
import com.rainimator.rainimatormod.item.trinket.WingsOfSalvationForTR;
import com.rainimator.rainimatormod.item.trinket.WingsOfSalvationItem;
import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.util.NumberUtil;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;

import java.util.List;
import java.util.Optional;

public class ElectricityHud extends SimpleBarOverlay {
    @Override
    protected Parameters getParameters(PlayerEntity playerEntity) {
        Parameters parameters = new Parameters();
        parameters.capacity = 0;
        parameters.value = 0;
        parameters.fillColor = 0xFFFFFF00;
        parameters.boundColor = 0xFF004444;
        parameters.emptyColor = 0xFF444444;
        parameters.centerColor = 0xFFFFFF;
        parameters.centerText = "";
        Optional<TrinketComponent> component = TrinketsApi.getTrinketComponent(playerEntity);
        if (ModItems.WINGS_OF_SALVATION instanceof WingsOfSalvationForTR tr && component.isPresent()) {
            List<Pair<SlotReference, ItemStack>> stacks = component.get().getEquipped(ModItems.WINGS_OF_SALVATION);
            if (stacks.size() > 0) {
                ItemStack stack = stacks.get(0).getRight();
                long stored = tr.getStoredEnergy(stack), max = tr.getEnergyCapacity();
                parameters.centerText = NumberUtil.formatNumber(stored) + "/" + NumberUtil.formatNumber(max);
                parameters.capacity = max;
                parameters.value = stored;
            }
        }
        return parameters;
    }

    @Override
    protected boolean shouldRender(PlayerEntity playerEntity) {
        if (ElectricitySystem.getType() == ElectricitySource.NONE) return false;
        Optional<TrinketComponent> component = TrinketsApi.getTrinketComponent(playerEntity);
        return component.map(trinketComponent -> trinketComponent.isEquipped(ModItems.WINGS_OF_SALVATION)).orElse(false);
    }
}
