package dev.rainimator.mod.ability;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import dev.rainimator.mod.item.trinket.WingsOfSalvationItem;
import dev.rainimator.mod.registry.ModGameRules;
import dev.rainimator.mod.registry.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Pair;

import java.util.List;
import java.util.Optional;

public class WingsOfSalvationAbility extends Ability.AbilityWithItem {
    public WingsOfSalvationAbility(ServerWorld world) {
        super("wings_of_salvation", world.getGameRules().get(ModGameRules.wings_of_salvation_boost).get());
    }

    @Override
    public boolean release(PlayerEntity player, ItemStack stack) {
        if (ModItems.WINGS_OF_SALVATION instanceof WingsOfSalvationItem w) {
            w.keyPress(player, stack);
            return true;
        }
        return false;
    }

    @Override
    public ItemStack hasItem(PlayerEntity player) {
        Optional<TrinketComponent> component = TrinketsApi.getTrinketComponent(player);
        if (component.isPresent()) {
            List<Pair<SlotReference, ItemStack>> stacks = component.get().getEquipped(ModItems.WINGS_OF_SALVATION);
            if (stacks.size() > 0)
                return stacks.get(0).getRight();
        }
        return ItemStack.EMPTY;
    }
}
