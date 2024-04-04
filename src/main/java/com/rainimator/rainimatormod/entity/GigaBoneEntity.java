package com.rainimator.rainimatormod.entity;

import com.rainimator.rainimatormod.registry.ModEntities;
import com.rainimator.rainimatormod.registry.util.MonsterEntityBase;
import com.rainimator.rainimatormod.util.RandomHelper;
import com.rainimator.rainimatormod.util.Stage;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class GigaBoneEntity extends MonsterEntityBase {
    public static final Stage.StagedEntityTextureProvider texture = Stage.ofProvider("gigabone");

    public GigaBoneEntity(EntityType<GigaBoneEntity> type, World world) {
        super(type, world, EntityGroup.UNDEAD);
        this.experiencePoints = 100;
        this.setPersistent();
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
        builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D);
        builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 600.0D);
        builder = builder.add(EntityAttributes.GENERIC_ARMOR, 30.0D);
        builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0D);
        builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0D);
        builder = builder.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 100.0D);
        builder = builder.add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 6.0D);
        return builder;
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, false, false));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.2D, false) {
            protected double getSquaredMaxAttackDistance(LivingEntity entity) {
                return (this.mob.getWidth() * this.mob.getWidth() + entity.getWidth());
            }
        });
        this.goalSelector.add(3, new WanderAroundGoal(this, 1.0D));
        this.targetSelector.add(4, new RevengeGoal(this));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.goalSelector.add(6, new SwimGoal(this));
    }

    @Override
    public boolean canImmediatelyDespawn(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        LivingEntity _livEnt = this;
        if (_livEnt.getHealth() <= 100.0F)
            if (this.getWorld() instanceof ServerWorld _level)
                if (Math.random() < 0.2D) {
                    WitherSkeletonEntity witherSkeleton = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, _level);
                    witherSkeleton.refreshPositionAndAngles(this.getX() + RandomHelper.nextInt(-2, 2), this.getY() + 2.0D, this.getZ() + RandomHelper.nextInt(-2, 2), this.getWorld().getRandom().nextFloat() * 360.0F, 0.0F);
                    witherSkeleton.initialize(_level, this.getWorld().getLocalDifficulty(witherSkeleton.getBlockPos()), SpawnReason.MOB_SUMMONED, null, null);
                    this.getWorld().spawnEntity(witherSkeleton);
                } else if (Math.random() < 0.2D) {
                    WitheredSkeletonsEntity witheredSkeletonsEntity = new WitheredSkeletonsEntity(ModEntities.WITHERED_SKELETONS, _level);
                    witheredSkeletonsEntity.refreshPositionAndAngles(this.getX() + RandomHelper.nextInt(-2, 2), this.getY() + 2.0D, this.getZ() + RandomHelper.nextInt(-2, 2), this.getWorld().getRandom().nextFloat() * 360.0F, 0.0F);
                    witheredSkeletonsEntity.initialize(_level, this.getWorld().getLocalDifficulty(witheredSkeletonsEntity.getBlockPos()), SpawnReason.MOB_SUMMONED, null, null);
                    this.getWorld().spawnEntity(witheredSkeletonsEntity);
                }
        return super.damage(source, amount);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        if (damageSource.isOf(DamageTypes.FALL))
            return true;
        if (damageSource.isOf(DamageTypes.EXPLOSION))
            return true;
        if (damageSource.isOf(DamageTypes.WITHER))
            return true;
        if (damageSource.isOf(DamageTypes.WITHER_SKULL))
            return true;
        return super.isInvulnerableTo(damageSource);
    }

    @Override
    public SoundEvent getHurtSound(@NotNull DamageSource ds) {
        return Registries.SOUND_EVENT.get(new Identifier("entity.generic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return Registries.SOUND_EVENT.get(new Identifier("entity.generic.death"));
    }
}