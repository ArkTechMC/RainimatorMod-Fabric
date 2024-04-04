package com.rainimator.rainimatormod.item;

import com.rainimator.rainimatormod.registry.util.ItemBase;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class CottonCandyItem extends ItemBase {
    public CottonCandyItem() {
        super(p -> p.food((new FoodComponent.Builder()).hunger(3).saturationModifier(0.1F).alwaysEdible().build()));
    }

    @Override
    public ItemStack finishUsing(ItemStack itemstack, World world, LivingEntity entity) {
        ItemStack ret_val = super.finishUsing(itemstack, world, entity);
        if (!entity.getWorld().isClient())
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 200, 0));
        if (entity instanceof PlayerEntity player) {
            ItemStack stack = new ItemStack(Items.STICK);
            stack.setCount(1);
            player.getInventory().insertStack(stack);
        }
        return ret_val;
    }
}
