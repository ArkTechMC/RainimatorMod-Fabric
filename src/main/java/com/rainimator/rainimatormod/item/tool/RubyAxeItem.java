package com.rainimator.rainimatormod.item.tool;

import com.rainimator.rainimatormod.registry.util.ToolMaterialBase;
import com.rainimator.rainimatormod.util.DamageUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

public class RubyAxeItem extends AxeItem {
    public RubyAxeItem() {
        super(ToolMaterialBase.of(1500, 10.0F, 8.0F, 3, 20), 1.0F, -2.2F, new Settings());
    }

    @Override
    public boolean postHit(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean ret_val = super.postHit(itemstack, entity, sourceentity);
        if (Math.random() < 0.5D) {
            entity.setOnFireFor(5);
            entity.damage(DamageUtil.build(entity, DamageTypes.IN_FIRE), 2.0F);
        }
        return ret_val;
    }
}

