package com.rainimator.rainimatormod.item.sword;

import com.rainimator.rainimatormod.registry.util.SwordItemBase;
import com.rainimator.rainimatormod.registry.util.ToolMaterialBase;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class NetheriteFlameSaberItem extends SwordItemBase {
    public NetheriteFlameSaberItem() {
        super(ToolMaterialBase.of(2000, 4.0F, 7.0F, 1, 2, Items.NETHERITE_INGOT), 3, -2.0F, new Settings().fireproof());
    }

    @Override
    public boolean postHit(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean retval = super.postHit(itemstack, entity, sourceentity);
        entity.setOnFireFor(10);
        return retval;
    }
}

