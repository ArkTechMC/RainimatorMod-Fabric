package com.rainimator.rainimatormod.entity;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.registry.ModEffects;
import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.registry.ModParticles;
import com.rainimator.rainimatormod.registry.util.MonsterEntityBase;
import com.rainimator.rainimatormod.util.SoundUtil;
import com.rainimator.rainimatormod.util.Stage;
import com.rainimator.rainimatormod.util.Timeout;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.*;

import java.util.Random;

public class CerisEntity extends MonsterEntityBase {
    public static final Stage.StagedEntityTextureProvider texture = Stage.ofProvider("ceris").setEyeTextureId("ceris_eye");
    private final ServerBossBar bossInfo = new ServerBossBar(this.getDisplayName(), BossBar.Color.PURPLE, BossBar.Style.PROGRESS);

    public CerisEntity(EntityType<CerisEntity> type, World world) {
        super(type, world, EntityGroup.DEFAULT);
        this.experiencePoints = 0;
        this.setPersistent();
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.ENDER_BIG_SWORD));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
        builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35D);
        builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 200.0D);
        builder = builder.add(EntityAttributes.GENERIC_ARMOR, 35.0D);
        builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0D);
        builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0D);
        builder = builder.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 5.0D);
        builder = builder.add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 5.0D);
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
        Entity sourceentity = source.getAttacker();
        if (sourceentity instanceof LivingEntity _ent)
            this.setTarget(_ent);
        if (this.hasStatusEffect(ModEffects.STUNNED)) {
            if (!this.world.isClient()) {
                this.addStatusEffect(new StatusEffectInstance(ModEffects.PURIFICATION, 100, 0));
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 100, 3));
            }
        } else {

            LivingEntity _entity = this;
            if (!_entity.world.isClient())
                _entity.addStatusEffect(new StatusEffectInstance(ModEffects.PURIFICATION, 100, 0));

            if (Math.random() < 0.3D) {
                SoundUtil.playSound(this.world, this.getX(), this.getY(), this.getZ(), new Identifier("entity.enderman.teleport"), 4.0F, 1.0F);

                if (this.world instanceof ServerWorld) {
                    ServerWorld _level = (ServerWorld) this.world;
                    _level.spawnParticles((ParticleEffect) ModParticles.PURPLE_LIGHT, this.getX(), this.getY(), this.getZ(), 50, 0.5D, 0.1D, 0.5D, 0.3D);
                }
                this.getNavigation().startMovingTo(this.getX() + MathHelper.nextInt(new Random(), 3, 9), this.getY(), this.getZ() + MathHelper.nextInt(new Random(), 3, 9), 20.0D);
                if (!this.world.isClient())
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 100, 2));
                if (sourceentity instanceof LivingEntity livingEntity) {
                    if (!livingEntity.world.isClient())
                        livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.FEAR_DARK, 200, 0));
                    if (!livingEntity.hasStatusEffect(StatusEffects.GLOWING)) {
                        SoundUtil.playSound(this.world, this.getX(), this.getY(), this.getZ(), new Identifier(RainimatorMod.MOD_ID, "ceris_f"), 1.0F, 1.0F);
                        if (livingEntity instanceof LivingEntity)
                            if (!livingEntity.world.isClient())
                                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 100, 0));
                    }
                    if (sourceentity instanceof LivingEntity && livingEntity.hasStatusEffect(StatusEffects.GLOWING)) {
                        if (!sourceentity.world.isClient()) {
                            ((LivingEntity) sourceentity).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 3));
                            ((LivingEntity) sourceentity).addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 0));
                        }
                        Timeout.create(60, () -> {
                            sourceentity.requestTeleport(this.world
                                    .raycast(new RaycastContext(this.getCameraPosVec(1.0F), this.getCameraPosVec(1.0F).add(this.getRotationVec(1.0F).multiply(1.0D)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, this)).getBlockPos().getX(), this
                                    .getY(), this.world.raycast(new RaycastContext(this.getCameraPosVec(1.0F), this.getCameraPosVec(1.0F).add(this.getRotationVec(1.0F).multiply(1.0D)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, this))
                                    .getBlockPos().getZ());
                            if (sourceentity instanceof ServerPlayerEntity _serverPlayer) {
                                _serverPlayer.networkHandler.requestTeleport(this.world
                                        .raycast(new RaycastContext(this.getCameraPosVec(1.0F), this.getCameraPosVec(1.0F).add(this.getRotationVec(1.0F).multiply(1.0D)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, this)).getBlockPos()
                                        .getX(), this
                                        .getY(), this.world.raycast(new RaycastContext(this.getCameraPosVec(1.0F), this.getCameraPosVec(1.0F).add(this.getRotationVec(1.0F).multiply(1.0D)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, this))
                                        .getBlockPos().getZ(), sourceentity
                                        .getYaw(), sourceentity.getPitch());
                            }
                            World levelAccessor = this.world;
                            SoundUtil.playSound(this.world, this.getX(), this.getY(), this.getZ(), new Identifier(RainimatorMod.MOD_ID, "ceris_skill"), 1.0F, 1.0F);
                            if (levelAccessor instanceof ServerWorld _level)
                                _level.spawnParticles((ParticleEffect) ModParticles.PURPLE_LIGHT, this.getX(), this.getY(), this.getZ(), 50, 0.5D, 0.1D, 0.5D, 0.3D);
                        });
                    }
                }
            }
        }

        if (source.getSource() instanceof PersistentProjectileEntity)
            return false;
        if (source == DamageSource.FALL)
            return false;
        if (source == DamageSource.DROWN)
            return false;
        if (source == DamageSource.LIGHTNING_BOLT)
            return false;
        if (source.isExplosive())
            return false;
        if (source.getName().equals("trident"))
            return false;
        if (source == DamageSource.DRAGON_BREATH)
            return false;
        if (source == DamageSource.WITHER)
            return false;
        if (source.getName().equals("witherSkull"))
            return false;
        return super.damage(source, amount);
    }

    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);
        SoundUtil.playSound(this.world, this.getX(), this.getY(), this.getZ(), new Identifier(RainimatorMod.MOD_ID, "ceris_death"), 1.0F, 1.0F);
        if (this.world instanceof ServerWorld _level)
            _level.spawnParticles((ParticleEffect) ModParticles.PURPLE_LIGHT, this.getX(), this.getY(), this.getZ(), 60, 0.5D, 1.0D, 0.5D, 0.5D);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason reason, EntityData livingdata, NbtCompound tag) {
        EntityData ret_val = super.initialize(world, difficulty, reason, livingdata, tag);
        Entity entity = this;
        SoundUtil.playSound(this.world, this.getX(), this.getY(), this.getZ(), new Identifier(RainimatorMod.MOD_ID, "ceris_live"), 1.0F, 1.0F);

        if (world instanceof ServerWorld _level)
            _level.spawnParticles((ParticleEffect) ModParticles.PURPLE_LIGHT, this.getX(), this.getY(), this.getZ(), 50, 0.5D, 0.5D, 0.5D, 0.5D);
        if (world.getDifficulty() != Difficulty.PEACEFUL) {
            if (!entity.world.isClient() && entity.getServer() != null)
                entity.getServer().getCommandManager().execute(entity.getCommandSource().withSilent().withLevel(4), "/playsound rainimator:ceris_boss_music neutral @a ~ ~ ~");

            Runnable callback = () -> {
                if (entity.isAlive()) {
                    if (!entity.world.isClient() && entity.getServer() != null) {
                        entity.getServer().getCommandManager().execute(entity.getCommandSource().withSilent().withLevel(4), "/playsound rainimator:ceris_boss_music neutral @a ~ ~ ~");
                    }
                }
            };
            Timeout.create(4700, callback);
            Timeout.create(9400, callback);
            Timeout.create(14100, callback);
            Timeout.create(18800, callback);
            Timeout.create(23500, callback);
            Timeout.create(28200, callback);
            Timeout.create(32900, callback);
        }

        return ret_val;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        if (!this.world.isClient()) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 80, 1));
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 80, 1));
        }
        if (!this.isAlive())
            SoundUtil.stopSound(this.world, new Identifier(RainimatorMod.MOD_ID, "ceris_boss_music"));
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