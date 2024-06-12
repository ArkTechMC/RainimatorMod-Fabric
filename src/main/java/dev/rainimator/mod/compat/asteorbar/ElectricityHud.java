package dev.rainimator.mod.compat.asteorbar;

import com.afoxxvi.asteorbar.overlay.parts.SimpleBarOverlay;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import dev.rainimator.mod.compat.ElectricitySource;
import dev.rainimator.mod.compat.ElectricitySystem;
import dev.rainimator.mod.item.trinket.WingsOfSalvationForTR;
import dev.rainimator.mod.registry.RainimatorItems;
import dev.rainimator.mod.util.NumberUtil;
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
        if (RainimatorItems.WINGS_OF_SALVATION instanceof WingsOfSalvationForTR tr && component.isPresent()) {
            List<Pair<SlotReference, ItemStack>> stacks = component.get().getEquipped(RainimatorItems.WINGS_OF_SALVATION);
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
        return component.map(trinketComponent -> trinketComponent.isEquipped(RainimatorItems.WINGS_OF_SALVATION)).orElse(false);
    }
}
