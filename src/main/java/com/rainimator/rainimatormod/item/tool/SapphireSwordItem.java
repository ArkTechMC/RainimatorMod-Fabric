package com.rainimator.rainimatormod.item.tool;

import com.rainimator.rainimatormod.registry.util.ToolMaterialBase;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public class SapphireSwordItem extends SwordItem {
    public SapphireSwordItem() {
        super(ToolMaterialBase.of(1000, 0.0F, 6.0F, 0, 20), 3, -2.0F, new Settings());
    }

    @Override
    public boolean postHit(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean retval = super.postHit(itemstack, entity, sourceentity);
        if (Math.random() < 0.5D)
            if (!entity.getWorld().isClient()) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 0));
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 0));
            }
        return retval;
    }
}
