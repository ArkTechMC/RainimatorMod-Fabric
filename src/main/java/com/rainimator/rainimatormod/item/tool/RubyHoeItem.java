package com.rainimator.rainimatormod.item.tool;

import com.iafenvoy.mcrconvertlib.item.ToolMaterialUtil;
import com.iafenvoy.mcrconvertlib.world.DamageUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;

public class RubyHoeItem extends HoeItem {
    public RubyHoeItem() {
        super(ToolMaterialUtil.of(1000, 10.0F, 2.0F, 3, 20), 0, -2.2F, new Settings());
    }

    @Override
    public boolean postHit(ItemStack itemtack, LivingEntity entity, LivingEntity sourceentity) {
        boolean retval = super.postHit(itemtack, entity, sourceentity);
        if (Math.random() < 0.5D) {
            entity.setOnFireFor(5);
            entity.damage(DamageUtil.build(sourceentity, DamageTypes.IN_FIRE), 2.0F);
        }
        return retval;
    }
}