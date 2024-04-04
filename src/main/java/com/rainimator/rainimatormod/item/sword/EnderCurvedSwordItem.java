package com.rainimator.rainimatormod.item.sword;

import com.rainimator.rainimatormod.registry.util.SwordItemBase;
import com.rainimator.rainimatormod.registry.util.ToolMaterialBase;
import com.rainimator.rainimatormod.util.DamageUtil;
import com.rainimator.rainimatormod.util.RandomHelper;
import com.rainimator.rainimatormod.util.SoundUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class EnderCurvedSwordItem extends SwordItemBase {
    public EnderCurvedSwordItem() {
        super(ToolMaterialBase.of(2000, 0.0F, 6.0F, 0, 25), 3, -2.0F, new Settings().fireproof());
    }

    @Override
    public boolean postHit(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean ret_val = super.postHit(itemstack, entity, sourceentity);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        if (entity instanceof MobEntity _entity)
            _entity.setTarget(sourceentity);
        boolean hurted = true;
        if (Math.random() < 0.3D)
            entity.damage(DamageUtil.build(sourceentity, DamageTypes.MAGIC), 4.0F);
        else if (Math.random() < 0.3D)
            entity.damage(DamageUtil.build(sourceentity, DamageTypes.MAGIC), 6.0F);
        else if (Math.random() < 0.3D)
            entity.damage(DamageUtil.build(sourceentity, DamageTypes.MAGIC), 8.0F);
        else if (Math.random() < 0.3D)
            entity.damage(DamageUtil.build(sourceentity, DamageTypes.MAGIC), 10.0F);
        else hurted = false;
        if (hurted) {
            SoundUtil.playSound(entity.getWorld(), x, y, z, new Identifier("block.anvil.land"), 5.0F, 1.0F);
            if (itemstack.damage(1, entity.getRandom(), null)) {
                itemstack.decrement(1);
                itemstack.setDamage(0);
            }
        }
        if (Math.random() < 0.25D && sourceentity instanceof PlayerEntity _player)
            _player.addExperience(RandomHelper.nextInt(10, 25));
        return ret_val;
    }
}
