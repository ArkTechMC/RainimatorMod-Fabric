package com.rainimator.rainimatormod.item.sword;

import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.registry.util.SwordItemBase;
import com.rainimator.rainimatormod.registry.util.ToolMaterialBase;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class HotGlovesItem extends SwordItemBase {
    public HotGlovesItem() {
        super(ToolMaterialBase.of(1000, 4.0F, 5.0F, 1, 2, ModItems.HOT_IRON), 3, 0.0F, new Settings().fireproof());
    }

    @Override
    public boolean postHit(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean ret_val = super.postHit(itemstack, entity, sourceentity);
        if (Math.random() < 0.7D)
            entity.setOnFireFor(5);
        return ret_val;
    }
}
