package dev.rainimator.mod.item.trinket;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.rainimator.mod.data.component.ManaComponent;
import dev.rainimator.mod.item.util.ItemBase;
import dev.rainimator.mod.registry.RainimatorGameRules;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class WingsOfSalvationItem extends ItemBase implements Trinket, FabricElytraItem {
    protected int lastBoostTick = 0;

    public WingsOfSalvationItem() {
        super(p -> p);
    }

    protected static void noEnoughEnergy(PlayerEntity player) {
        player.getAbilities().flying = false;
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof PlayerEntity player && entity.getWorld().getGameRules().get(RainimatorGameRules.enableWingsCreativeFly).get() && !player.isCreative()) {
            player.getAbilities().allowFlying = true;
            player.sendAbilitiesUpdate();
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof PlayerEntity player && entity.getWorld().getGameRules().get(RainimatorGameRules.enableWingsCreativeFly).get() && !player.isCreative()) {
            player.getAbilities().allowFlying = false;
            player.getAbilities().flying = false;
            player.sendAbilitiesUpdate();
        }
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof PlayerEntity player) {
            if (entity.getWorld().getGameRules().get(RainimatorGameRules.enableWingsCreativeFly).get() && !player.isCreative()) {
                if (!player.getAbilities().allowFlying) {
                    player.getAbilities().allowFlying = true;
                    player.sendAbilitiesUpdate();
                }
                if (player.getAbilities().flying && !ManaComponent.tryUse(player, entity.getWorld().getGameRules().get(RainimatorGameRules.wings_of_salvation_second).get() / 20))
                    noEnoughEnergy(player);
            }
        }
        this.lastBoostTick--;
        if (this.lastBoostTick < 0) this.lastBoostTick = 0;
    }

    public void keyPress(PlayerEntity player, ItemStack stack) {
        if (player.isFallFlying())
            if (this.lastBoostTick <= 0 && ManaComponent.tryUse(player, player.getWorld().getGameRules().get(RainimatorGameRules.wings_of_salvation_boost).get()))
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
