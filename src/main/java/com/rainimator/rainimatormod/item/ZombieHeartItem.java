package com.rainimator.rainimatormod.item;

import com.rainimator.rainimatormod.registry.util.ItemBase;
import com.rainimator.rainimatormod.registry.util.ModCreativeTab;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ZombieHeartItem extends ItemBase {
    public ZombieHeartItem() {
        super(p -> p.group(ModCreativeTab.items).food((new FoodComponent.Builder()).hunger(10).saturationModifier(1.0F).alwaysEdible().meat().build()));
    }

    @Override
    public int getMaxUseTime(ItemStack itemstack) {
        return 36;
    }

    @Override
    public ItemStack finishUsing(ItemStack itemstack, World world, LivingEntity entity) {
        ItemStack retval = super.finishUsing(itemstack, world, entity);
        if (entity instanceof LivingEntity)
            if (!entity.world.isClient()) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 1));
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200, 1));
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 1));
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 200, 1));
            }
        return retval;
    }
}