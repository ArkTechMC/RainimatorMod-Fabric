package com.rainimator.rainimatormod.item.sword;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.registry.ModParticles;
import com.rainimator.rainimatormod.registry.util.IRainimatorInfo;
import com.rainimator.rainimatormod.registry.util.SwordItemBase;
import com.rainimator.rainimatormod.registry.util.ToolMaterialBase;
import com.rainimator.rainimatormod.util.Episode;
import com.rainimator.rainimatormod.util.ParticleUtil;
import com.rainimator.rainimatormod.util.SoundUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class BlackDeathSwordItem extends SwordItemBase implements IRainimatorInfo {
    public BlackDeathSwordItem() {
        super(ToolMaterialBase.of(1000, 0.0F, 9.0F, 0, 30), 3, -1.7F, new Settings().fireproof());
    }

    @Override
    public boolean postHit(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean retval = super.postHit(itemstack, entity, sourceentity);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        if (entity instanceof MobEntity _entity)
            _entity.setTarget(sourceentity);
        if (Math.random() < 0.7D) {
            if (!entity.getWorld().isClient()) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 100, 2));
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 2));
            }
            if (Math.random() < 0.7D)
                SoundUtil.playSound(entity.getWorld(), x, y, z, new Identifier(RainimatorMod.MOD_ID, "black_death_sword_skills"), 4.0F, 1.0F);
            else
                SoundUtil.playSound(entity.getWorld(), x, y, z, new Identifier(RainimatorMod.MOD_ID, "black_death_sword_skill_3"), 4.0F, 1.0F);
            if (entity.getWorld() instanceof ServerWorld _level)
                _level.spawnParticles((ParticleEffect) ModParticles.FLOWER_WHITE, x, y, z, 50, 0.5D, 1.0D, 0.5D, 0.1D);
        } else {
            if (!sourceentity.getWorld().isClient())
                sourceentity.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 1));
        }

        return retval;
    }

    @Override
    public boolean onSwingHand(ItemStack itemstack, World world, double x, double y, double z) {
        boolean retval = super.onSwingHand(itemstack, world, x, y, z);
        if (Math.random() < 0.2D)
            ParticleUtil.spawnCircleParticles(world, ParticleTypes.SOUL, x, y, z, 3, 0, 50);
        return retval;
    }

    @Override
    public Episode getEpisode() {
        return Episode.Unknown;
    }
}
