package com.rainimator.rainimatormod.item.sword;

import com.iafenvoy.mcrconvertlib.item.SwordItemBase;
import com.iafenvoy.mcrconvertlib.item.ToolMaterialUtil;
import com.iafenvoy.mcrconvertlib.misc.RandomHelper;
import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.registry.util.IRainimatorInfo;
import com.rainimator.rainimatormod.util.Episode;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;

public class AbigailSpearItem extends SwordItemBase implements IRainimatorInfo {
    public AbigailSpearItem() {
        super(ToolMaterialUtil.of(2000, 4.0F, 8.0F, 1, 20, ModItems.SUPER_RUBY), 3, -2.0F, new Settings().fireproof());
    }

    @Override
    public boolean postHit(ItemStack itemtack, LivingEntity entity, LivingEntity sourceentity) {
        boolean ret_val = super.postHit(itemtack, entity, sourceentity);
        if (entity instanceof MobEntity _entity)
            _entity.setTarget(sourceentity);
        if (Math.random() < 0.5D)
            sourceentity.setHealth(sourceentity.getHealth() + RandomHelper.nextInt(1, 3));
        return ret_val;
    }

    @Override
    public Episode getEpisode() {
        return Episode.BeginAgain;
    }
}
