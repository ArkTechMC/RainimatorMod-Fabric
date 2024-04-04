package com.rainimator.rainimatormod.item.sword;

import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.registry.util.SwordItemBase;
import com.rainimator.rainimatormod.registry.util.ToolMaterialBase;
import com.rainimator.rainimatormod.util.RandomHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;

public class RedGoldDaggerItem extends SwordItemBase {
    public RedGoldDaggerItem() {
        super(ToolMaterialBase.of(1000, 4.0F, 6.0F, 0, 3, ModItems.RUBY), 3, -2.0F, new Settings());
    }

    @Override
    public boolean postHit(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean ret_val = super.postHit(itemstack, entity, sourceentity);
        if (entity instanceof MobEntity _entity)
            _entity.setTarget(sourceentity);
        if (Math.random() < 0.4D)
            entity.setOnFireFor(5);
        if (Math.random() < 0.2D)
            sourceentity.setHealth(sourceentity.getHealth() + RandomHelper.nextInt(1, 2));
        return ret_val;
    }
}
