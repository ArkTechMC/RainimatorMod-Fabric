package com.rainimator.rainimatormod.entity;

import com.iafenvoy.annotationlib.annotation.registration.AttributeBuilder;
import com.iafenvoy.mcrconvertlib.item.MonsterEntityBase;
import com.iafenvoy.mcrconvertlib.render.Stage;
import com.rainimator.rainimatormod.RainimatorMod;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class TricerEntity extends MonsterEntityBase {
    public static final Stage.StagedEntityTextureProvider texture = Stage.ofProvider(RainimatorMod.MOD_ID, "tricer");
    private final ServerBossBar bossInfo = new ServerBossBar(this.getDisplayName(), BossBar.Color.RED, BossBar.Style.NOTCHED_6);

    public TricerEntity(EntityType<TricerEntity> type, World world) {
        super(type, world, EntityGroup.AQUATIC);
        this.experiencePoints = 100;
        this.setPersistent();
    }

    @AttributeBuilder
    public static DefaultAttributeContainer.Builder createAttributes() {
        DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
        builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D);
        builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 500.0D);
        builder = builder.add(EntityAttributes.GENERIC_ARMOR, 50.0D);
        builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10.0D);
        builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0D);
        builder = builder.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 10.0D);
        builder = builder.add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 10.0D);
        return builder;
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new PounceAtTargetGoal(this, 0.5F));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, MobEntity.class, false, false));
        this.goalSelector.add(3, new MeleeAttackGoal(this, 1.2D, false) {
            protected double getSquaredMaxAttackDistance(LivingEntity entity) {
                return (this.mob.getWidth() * this.mob.getWidth() + entity.getWidth());
            }
        });
        this.targetSelector.add(4, new ActiveTargetGoal<>(this, PlayerEntity.class, false, false));
        this.targetSelector.add(5, new ActiveTargetGoal<>(this, HostileEntity.class, false, false));
        this.goalSelector.add(6, new WanderAroundGoal(this, 1.0D));
        this.targetSelector.add(7, new RevengeGoal(this));
        this.goalSelector.add(8, new LongDoorInteractGoal(this, false));
        this.goalSelector.add(9, new LongDoorInteractGoal(this, true));
        this.goalSelector.add(10, new LookAroundGoal(this));
        this.goalSelector.add(11, new SwimGoal(this));
    }

    @Override
    public boolean canImmediatelyDespawn(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return Registries.SOUND_EVENT.get(new Identifier("entity.generic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return Registries.SOUND_EVENT.get(new Identifier("entity.generic.death"));
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        if (damageSource.getSource() instanceof PersistentProjectileEntity)
            return true;
        if (damageSource.isOf(DamageTypes.FALL))
            return true;
        if (damageSource.isOf(DamageTypes.CACTUS))
            return true;
        if (damageSource.isOf(DamageTypes.DROWN))
            return true;
        if (damageSource.isOf(DamageTypes.LIGHTNING_BOLT))
            return true;
        if (damageSource.isOf(DamageTypes.EXPLOSION))
            return true;
        if (damageSource.isOf(DamageTypes.TRIDENT))
            return true;
        if (damageSource.isOf(DamageTypes.FALLING_ANVIL))
            return true;
        if (damageSource.isOf(DamageTypes.DRAGON_BREATH))
            return true;
        if (damageSource.isOf(DamageTypes.WITHER))
            return true;
        if (damageSource.isOf(DamageTypes.WITHER_SKULL))
            return true;
        return super.isInvulnerableTo(damageSource);
    }

    @Override
    public boolean canUsePortals() {
        return false;
    }

    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossInfo.addPlayer(player);
    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossInfo.removePlayer(player);
    }

    @Override
    public void mobTick() {
        super.mobTick();
        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
    }
}