package com.rainimator.rainimatormod.item.tool;

import com.rainimator.rainimatormod.registry.util.ModCreativeTab;
import com.rainimator.rainimatormod.registry.util.TierBase;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;

public class RubyShovelItem extends ShovelItem {
    public RubyShovelItem() {
        super(TierBase.of(1000, 10.0F, 3.0F, 3, 20), 1.0F, -2.2F, ModCreativeTab.createProperty());
    }

    @Override
    public boolean postHit(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean retval = super.postHit(itemstack, entity, sourceentity);
        if (Math.random() < 0.5D) {
            entity.setOnFireFor(5);
            entity.damage(DamageSource.IN_FIRE, 2.0F);
        }
        return retval;
    }
}
