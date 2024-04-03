package com.rainimator.rainimatormod.item.sword;

import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.registry.util.ModCreativeTab;
import com.rainimator.rainimatormod.registry.util.SwordItemBase;
import com.rainimator.rainimatormod.registry.util.TierBase;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class RedGoldDaggerItem extends SwordItemBase {
    public RedGoldDaggerItem() {
        super(TierBase.of(1000, 4.0F, 6.0F, 0, 3, ModItems.RUBY), 3, -2.0F, ModCreativeTab.createProperty());
    }

    @Override
    public boolean postHit(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean ret_val = super.postHit(itemstack, entity, sourceentity);
        if (entity instanceof MobEntity _entity)
            _entity.setTarget(sourceentity);
        if (Math.random() < 0.4D)
            entity.setOnFireFor(5);
        if (Math.random() < 0.2D)
            sourceentity.setHealth(sourceentity.getHealth() + MathHelper.nextInt(new Random(), 1, 2));
        return ret_val;
    }
}
