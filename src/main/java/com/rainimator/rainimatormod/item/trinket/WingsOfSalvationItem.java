package com.rainimator.rainimatormod.item.trinket;

import com.iafenvoy.mcrconvertlib.item.ItemBase;
import com.iafenvoy.mcrconvertlib.misc.Timeout;
import com.rainimator.rainimatormod.compat.ElectricitySource;
import com.rainimator.rainimatormod.compat.ElectricitySystem;
import com.rainimator.rainimatormod.data.config.ManaConfig;
import com.rainimator.rainimatormod.data.config.ModConfig;
import com.rainimator.rainimatormod.network.ManaComponent;
import com.rainimator.rainimatormod.registry.ModKeybindings;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import reborncore.common.powerSystem.RcEnergyItem;
import reborncore.common.powerSystem.RcEnergyTier;

public class WingsOfSalvationItem extends ItemBase implements Trinket, FabricElytraItem {
    private int lastBoostTick = 0;

    private WingsOfSalvationItem() {
        super(p -> p);
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof PlayerEntity player && ModConfig.getInstance().enableWingsCreativeFly && !player.isCreative())
            player.getAbilities().allowFlying = true;
    }

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
        if (entity instanceof PlayerEntity player) {
            if (ModConfig.getInstance().enableWingsCreativeFly && !player.isCreative()) {
                if (player.getAbilities().flying)
                    if (stack.getItem() instanceof WingsOfSalvationForTR tr) {
                        if (!tr.tryUseEnergy(stack, 50))
                            noEnoughEnergy(player);
                    } else if (!ManaComponent.tryUse(player, ManaConfig.getInstance().wings_of_salvation_second / 20))
                        noEnoughEnergy(player);
            }
            this.lastBoostTick--;
            if (this.lastBoostTick < 0) this.lastBoostTick = 0;
            if (player.isFallFlying()) {
                if (ModKeybindings.ABILITY.wasPressed() && this.lastBoostTick <= 0) {
                    if (stack.getItem() instanceof WingsOfSalvationForTR tr) {
                        if (tr.tryUseEnergy(stack, 800))
                            this.speedUp(player);
                    } else if (ManaComponent.tryUse(player, ManaConfig.getInstance().wings_of_salvation_boost))
                        this.speedUp(player);
                }
            }
        }
    }

    private static void noEnoughEnergy(PlayerEntity player) {
        player.getAbilities().flying = false;
    }

    private void speedUp(PlayerEntity player) {
        this.lastBoostTick = 20;
        Vec3d vec3d = player.getRotationVector();
        Vec3d vec3d2 = player.getVelocity();
        player.setVelocity(vec3d2.add(vec3d.x * 0.1 + (vec3d.x * 1.5 - vec3d2.x) * 0.5, vec3d.y * 0.1 + (vec3d.y * 1.5 - vec3d2.y) * 0.5, vec3d.z * 0.1 + (vec3d.z * 1.5 - vec3d2.z) * 0.5).multiply(2));
    }

    @Override
    public boolean useCustomElytra(LivingEntity entity, ItemStack chestStack, boolean tickElytra) {
        return true;
    }

    public static WingsOfSalvationItem create() {
        ElectricitySource source = ElectricitySystem.getType();
        if (source == ElectricitySource.TR)
            return new WingsOfSalvationForTR();
        return new WingsOfSalvationItem();
    }

    public static class WingsOfSalvationForTR extends WingsOfSalvationItem implements RcEnergyItem {
        @Override
        public long getEnergyCapacity() {
            return 600000;
        }

        @Override
        public RcEnergyTier getTier() {
            return RcEnergyTier.INFINITE;
        }
    }
}
