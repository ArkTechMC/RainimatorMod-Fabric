package com.rainimator.rainimatormod.item.sword;

import com.rainimator.rainimatormod.registry.util.ModCreativeTab;
import com.rainimator.rainimatormod.registry.util.SwordItemBase;
import com.rainimator.rainimatormod.registry.util.TierBase;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class NetheriteFlameSaberItem extends SwordItemBase {
    public NetheriteFlameSaberItem() {
        super(TierBase.of(2000, 4.0F, 7.0F, 1, 2, Items.NETHERITE_INGOT), 3, -2.0F, ModCreativeTab.createProperty().fireproof());
    }

    @Override
    public boolean postHit(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean retval = super.postHit(itemstack, entity, sourceentity);
        entity.setOnFireFor(10);
        return retval;
    }
}

