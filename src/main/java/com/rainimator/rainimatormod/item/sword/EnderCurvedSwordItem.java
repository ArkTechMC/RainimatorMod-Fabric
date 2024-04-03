package com.rainimator.rainimatormod.item.sword;

import com.rainimator.rainimatormod.registry.util.ModCreativeTab;
import com.rainimator.rainimatormod.registry.util.SwordItemBase;
import com.rainimator.rainimatormod.registry.util.TierBase;
import com.rainimator.rainimatormod.util.SoundUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class EnderCurvedSwordItem extends SwordItemBase {
    public EnderCurvedSwordItem() {
        super(TierBase.of(2000, 0.0F, 6.0F, 0, 25), 3, -2.0F, ModCreativeTab.createProperty().fireproof());
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
            entity.damage(DamageSource.MAGIC, 4.0F);
        else if (Math.random() < 0.3D)
            entity.damage(DamageSource.MAGIC, 6.0F);
        else if (Math.random() < 0.3D)
            entity.damage(DamageSource.MAGIC, 8.0F);
        else if (Math.random() < 0.3D)
            entity.damage(DamageSource.MAGIC, 10.0F);
        else hurted = false;
        if (hurted) {
            SoundUtil.playSound(entity.world, x, y, z, new Identifier("block.anvil.land"), 5.0F, 1.0F);
            if (itemstack.damage(1, new Random(), null)) {
                itemstack.decrement(1);
                itemstack.setDamage(0);
            }
        }
        if (Math.random() < 0.25D && sourceentity instanceof PlayerEntity _player)
            _player.addExperience(MathHelper.nextInt(new Random(), 10, 25));
        return ret_val;
    }
}
