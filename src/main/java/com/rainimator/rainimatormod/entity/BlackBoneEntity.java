package com.rainimator.rainimatormod.entity;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.registry.ModEffects;
import com.rainimator.rainimatormod.registry.ModItems;
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
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.MessageType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.explosion.Explosion;

public class BlackBoneEntity extends MonsterEntityBase {
    public static final Stage.StagedEntityTextureProvider texture = Stage.ofProvider("blackbone");
    private final ServerBossBar bossInfo = new ServerBossBar(this.getDisplayName(), BossBar.Color.WHITE, BossBar.Style.PROGRESS);

    public BlackBoneEntity(EntityType<BlackBoneEntity> type, World world) {
        super(type, world, EntityGroup.UNDEAD);
        this.experiencePoints = 0;
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.BLACKBONE_THE_BLADE_SINGLE_HAND));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
        builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35D);
        builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 130.0D);
        builder = builder.add(EntityAttributes.GENERIC_ARMOR, 30.0D);
        builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0D);
        builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0D);
        builder = builder.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 5.0D);
        builder = builder.add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.0D);
        return builder;
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2D, false) {
            protected double getSquaredMaxAttackDistance(LivingEntity entity) {
                return (this.mob.getWidth() * this.mob.getWidth() + entity.getWidth());
            }
        });
        this.goalSelector.add(2, new WanderAroundGoal(this, 1.0D));
        this.targetSelector.add(3, new RevengeGoal(this));
        this.targetSelector.add(4, new ActiveTargetGoal<>(this, PlayerEntity.class, false, false));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.goalSelector.add(6, new SwimGoal(this));
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        double y = this.getY();
        Entity sourceentity = source.getAttacker();
        if (sourceentity != null) {
            if (sourceentity instanceof LivingEntity _ent)
                this.setTarget(_ent);
            if (this.hasStatusEffect(ModEffects.FEAR_DARK))
                this.clearStatusEffects();
            else if (this.hasStatusEffect(ModEffects.ICE_PEOPLE))
                this.clearStatusEffects();
            else if (this.hasStatusEffect(ModEffects.SOUL_DEATH))
                this.clearStatusEffects();
            else if (this.hasStatusEffect(StatusEffects.POISON))
                this.clearStatusEffects();
            else if (this.hasStatusEffect(StatusEffects.WITHER))
                this.clearStatusEffects();
            else {
                if (Math.random() < 0.2) {
                    if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasStatusEffect(ModEffects.FEAR_DARK))) {
                        sourceentity.damage(new DamageSource("death by dark"), 12);
                        if (!_livEnt.world.isClient())
                            _livEnt.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 500, 1));
                    }
                } else {
                    if (!(sourceentity instanceof LivingEntity _livEnt && _livEnt.hasStatusEffect(ModEffects.FEAR_DARK))) {
                        SoundUtil.playSound(this.world, this.getX(), this.getY(), this.getZ(), new Identifier(RainimatorMod.MOD_ID, "blackbone_skill"), 1, 1);
                        if (this.world instanceof ServerWorld _level)
                            _level.spawnParticles(ParticleTypes.ELECTRIC_SPARK, this.getX(), this.getY(), this.getZ(), 50, 1, 1, 1, 1);
                        if (sourceentity instanceof LivingEntity _entity && !_entity.world.isClient())
                            _entity.addStatusEffect(new StatusEffectInstance(ModEffects.FEAR_DARK, 300, 0));
                        sourceentity.setOnFireFor(10);
                    }
                }
            }

            if (Math.random() < 0.1) {
                if (!this.world.isClient() && this.world.getServer() != null)
                    if (Math.random() < 0.3)
                        this.world.getServer().getPlayerManager().broadcast(new TranslatableText("entity.rainimator.blackbone.message1"), MessageType.SYSTEM, Util.NIL_UUID);
                    else if (Math.random() < 0.4)
                        this.world.getServer().getPlayerManager().broadcast(new TranslatableText("entity.rainimator.blackbone.message2"), MessageType.SYSTEM, Util.NIL_UUID);
                    else if (Math.random() < 0.5)
                        this.world.getServer().getPlayerManager().broadcast(new TranslatableText("entity.rainimator.blackbone.message3"), MessageType.SYSTEM, Util.NIL_UUID);
                    else
                        this.world.getServer().getPlayerManager().broadcast(new TranslatableText("entity.rainimator.blackbone.message4"), MessageType.SYSTEM, Util.NIL_UUID);

                if (!sourceentity.world.isClient() && sourceentity.getServer() != null)
                    sourceentity.getServer().getCommandManager().execute(sourceentity.getCommandSource().withSilent().withLevel(4), "title @p title {\"text\":\"！！！\",\"color\":\"red\"}");
                Timeout.create(50, () -> {
                    if (!this.world.isClient()) {
                        BlockPos pos = BlackBoneEntity.this.world.raycast(new RaycastContext(this.getCameraPosVec(1f), this.getCameraPosVec(1f).add(this.getRotationVec(1f).multiply(2)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, this)).getBlockPos();
                        this.world.createExplosion(null, (pos.getX()), (y + 1), (pos.getZ()), 1, Explosion.DestructionType.NONE);
                    }

                    Runnable callback = () -> {
                        if (!this.world.isClient()) {
                            BlockPos pos = this.world.raycast(new RaycastContext(this.getCameraPosVec(1f), this.getCameraPosVec(1f).add(this.getRotationVec(1f).multiply(18)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, this)).getBlockPos();
                            this.world.createExplosion(null, (pos.getX()), (y + 1), (pos.getZ()), 1, Explosion.DestructionType.NONE);
                        }
                    };
                    Timeout.create(5, callback);
                    Timeout.create(10, callback);
                    Timeout.create(15, callback);
                    Timeout.create(20, callback);
                    Timeout.create(25, callback);
                    Timeout.create(30, callback);
                    Timeout.create(35, callback);
                    Timeout.create(40, callback);
                });
            }
        }
        if (source == DamageSource.FALL)
            return false;
        if (source == DamageSource.DROWN)
            return false;
        if (source.isExplosive())
            return false;
        if (source == DamageSource.WITHER)
            return false;
        if (source.getName().equals("witherSkull"))
            return false;
        return super.damage(source, amount);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason reason, EntityData livingdata, NbtCompound tag) {
        EntityData retval = super.initialize(world, difficulty, reason, livingdata, tag);
        if (world instanceof World _level)
            SoundUtil.playSound(_level, this.getX(), this.getY(), this.getZ(), new Identifier(RainimatorMod.MOD_ID, "blackbone_living"), 1.0F, 1.0F);

        if (world instanceof ServerWorld _level)
            _level.spawnParticles((ParticleEffect) ParticleTypes.ELECTRIC_SPARK, this.getX(), this.getY(), this.getZ(), 50, 1.0D, 1.0D, 1.0D, 1.0D);
        if (world.getDifficulty() != Difficulty.PEACEFUL) {
            if (!this.world.isClient() && this.getServer() != null)
                this.getServer().getCommandManager().execute(this.getCommandSource().withSilent().withLevel(4), "playsound rainimator:blackbone_boss_music neutral @a ~ ~ ~");

            Runnable callback = () -> {
                if (this.isAlive())
                    if (!this.world.isClient() && this.getServer() != null)
                        this.getServer().getCommandManager().execute(this.getCommandSource().withSilent().withLevel(4), "playsound rainimator:blackbone_boss_music neutral @a ~ ~ ~");
            };
            Timeout.create(3960, callback);
            Timeout.create(7920, callback);
            Timeout.create(11880, callback);
            Timeout.create(15840, callback);
            Timeout.create(19800, callback);
            Timeout.create(23760, callback);
        }

        return retval;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        if (this.hasStatusEffect(ModEffects.STUNNED))
            if (!this.world.isClient()) {
                this.addStatusEffect(new StatusEffectInstance(ModEffects.PURIFICATION, 200, 0));
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 2));
            }
        if (!this.isAlive())
            SoundUtil.stopSound(this.world, new Identifier(RainimatorMod.MOD_ID, "blackbone_boss_music"));
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