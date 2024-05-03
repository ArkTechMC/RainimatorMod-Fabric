package com.rainimator.rainimatormod.item.trinket;

import com.iafenvoy.mcrconvertlib.item.ItemBase;
import com.rainimator.rainimatormod.compat.ElectricitySource;
import com.rainimator.rainimatormod.compat.ElectricitySystem;
import com.rainimator.rainimatormod.network.ManaComponent;
import com.rainimator.rainimatormod.registry.ModGameRules;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.lang.reflect.InvocationTargetException;

public class WingsOfSalvationItem extends ItemBase implements Trinket, FabricElytraItem {
    protected int lastBoostTick = 0;

    protected WingsOfSalvationItem() {
        super(p -> p);
    }

    protected static void noEnoughEnergy(PlayerEntity player) {
        player.getAbilities().flying = false;
    }

    public static WingsOfSalvationItem create() {
        ElectricitySource source = ElectricitySystem.getType();
        if (source == ElectricitySource.TR)
            return get();
        return new WingsOfSalvationItem();
    }

    private static WingsOfSalvationItem get() {
        try {
            Class<?> clazz = Class.forName("com.rainimator.rainimatormod.item.trinket.WingsOfSalvationForTR");
            return (WingsOfSalvationItem) clazz.getConstructor().newInstance();
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof PlayerEntity player && entity.getWorld().getGameRules().get(ModGameRules.enableWingsCreativeFly).get() && !player.isCreative()) {
            player.getAbilities().allowFlying = true;
            player.sendAbilitiesUpdate();
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof PlayerEntity player && entity.getWorld().getGameRules().get(ModGameRules.enableWingsCreativeFly).get() && !player.isCreative()) {
            player.getAbilities().allowFlying = false;
            player.getAbilities().flying = false;
            player.sendAbilitiesUpdate();
        }
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof PlayerEntity player) {
            if (entity.getWorld().getGameRules().get(ModGameRules.enableWingsCreativeFly).get() && !player.isCreative()) {
                if(!player.getAbilities().allowFlying) {
                    player.getAbilities().allowFlying = true;
                    player.sendAbilitiesUpdate();
                }
                if (player.getAbilities().flying && !ManaComponent.tryUse(player, entity.getWorld().getGameRules().get(ModGameRules.wings_of_salvation_second).get() / 20))
                    noEnoughEnergy(player);
            }
        }
        this.lastBoostTick--;
        if (this.lastBoostTick < 0) this.lastBoostTick = 0;
    }

    public void keyPress(PlayerEntity player, ItemStack stack) {
        if (player.isFallFlying())
            if (this.lastBoostTick <= 0 && ManaComponent.tryUse(player, player.getWorld().getGameRules().get(ModGameRules.wings_of_salvation_boost).get()))
                this.speedUp(player);
    }

    protected void speedUp(PlayerEntity player) {
        this.lastBoostTick = 20;
        FireworkRocketEntity entity = new FireworkRocketEntity(player.getWorld(), new ItemStack(Items.AIR), player);
        player.getWorld().spawnEntity(entity);
    }

    @Override
    public boolean useCustomElytra(LivingEntity entity, ItemStack chestStack, boolean tickElytra) {
        return true;
    }
}
