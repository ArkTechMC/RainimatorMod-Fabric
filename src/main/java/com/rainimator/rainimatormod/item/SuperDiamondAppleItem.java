package com.rainimator.rainimatormod.item;

import com.rainimator.rainimatormod.registry.util.ItemBase;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SuperDiamondAppleItem extends ItemBase {
    public SuperDiamondAppleItem() {
        super(p -> p.food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F).alwaysEdible().build()));
    }

    @Override
    public ItemStack finishUsing(ItemStack itemstack, World world, LivingEntity entity) {
        ItemStack retval = super.finishUsing(itemstack, world, entity);
        if (!entity.getWorld().isClient()) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 2400, 4));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 2400, 1));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 2400, 1));
        }
        return retval;
    }
}
