package com.rainimator.rainimatormod.item.tool;

import com.iafenvoy.mcrconvertlib.item.ToolMaterialUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;

public class SapphireShovelItem extends ShovelItem {
    public SapphireShovelItem() {
        super(ToolMaterialUtil.of(1000, 10.0F, 3.0F, 3, 20), 1.0F, -2.2F, new Settings());
    }

    @Override
    public boolean postHit(ItemStack itemtack, LivingEntity entity, LivingEntity sourceentity) {
        boolean retval = super.postHit(itemtack, entity, sourceentity);
        if (Math.random() < 0.5D) {
            if (!entity.getWorld().isClient()) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 0));
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 0));
            }
        }
        return retval;
    }
}
