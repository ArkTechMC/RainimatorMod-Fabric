package com.rainimator.rainimatormod.item.sword;

import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.registry.util.SwordItemBase;
import com.rainimator.rainimatormod.registry.util.ToolMaterialBase;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

public class HerobrineTomahawkItem extends SwordItemBase {
    public HerobrineTomahawkItem() {
        super(ToolMaterialBase.of(2500, 12.0F, 11.0F, 0, 20, ModItems.SUPER_RUBY, ModItems.SUPER_SAPPHIRE), 3, -2.2F, new Settings().fireproof());
    }

    @Override
    public boolean postHit(ItemStack itemtack, LivingEntity entity, LivingEntity sourceentity) {
        boolean ret_val = super.postHit(itemtack, entity, sourceentity);
        if (entity.getWorld().isClient()) return ret_val;
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 100, 0));
        if (Math.random() < 0.5D) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 60, 0));
            if (Math.random() < 0.1D) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 100, 1));
                if (Math.random() < 0.05D) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 100, 1));
                    if (Math.random() < 0.025D) {
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 100, 2));
                        if (Math.random() < 0.001D)
                            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 100, 3));
                    }
                }
            }
        }
        return ret_val;
    }
}
