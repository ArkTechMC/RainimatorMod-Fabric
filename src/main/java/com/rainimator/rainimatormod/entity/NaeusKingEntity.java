package com.rainimator.rainimatormod.entity;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.registry.ModEffects;
import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.registry.ModParticles;
import com.rainimator.rainimatormod.registry.util.MonsterEntityBase;
import com.rainimator.rainimatormod.util.DamageUtil;
import com.rainimator.rainimatormod.util.SoundUtil;
import com.rainimator.rainimatormod.util.Stage;
import com.rainimator.rainimatormod.util.Timeout;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.*;

public class NaeusKingEntity extends MonsterEntityBase {
    public static final Stage.StagedEntityTextureProvider texture = Stage.ofProvider("naeus_king");
    private final ServerBossBar bossInfo = new ServerBossBar(this.getDisplayName(), BossBar.Color.RED, BossBar.Style.PROGRESS);

    public NaeusKingEntity(EntityType<NaeusKingEntity> type, World world) {
        super(type, world, EntityGroup.UNDEAD);
        this.experiencePoints = 0;
        this.setPersistent();
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.NETHER_SPEAR));
        this.equipStack(EquipmentSlot.HEAD, new ItemStack(ModItems.NETHER_THE_CROWN_HELMET));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
        builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35D);
        builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 250.0D);
        builder = builder.add(EntityAttributes.GENERIC_ARMOR, 50.0D);
        builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0D);
        builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0D);
        builder = builder.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 10.0D);
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
    public SoundEvent getHurtSound(DamageSource ds) {
        return Registries.SOUND_EVENT.get(new Identifier("entity.generic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return Registries.SOUND_EVENT.get(new Identifier("entity.generic.death"));
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        double x = this.getX();
        final double y = this.getY();
        double z = this.getZ();
        Entity sourceentity = source.getAttacker();
        if (sourceentity != null) {
            if (sourceentity instanceof LivingEntity _ent)
                this.setTarget(_ent);
            if (this.hasStatusEffect(ModEffects.ICE_PEOPLE))
                this.clearStatusEffects();
            else {
                if (Math.random() < 0.5D) {
                    SoundUtil.playSound(this.getWorld(), x, y, z, new Identifier(RainimatorMod.MOD_ID, "fire_soul"), 1.0F, 1.0F);
                    if (this.getWorld() instanceof ServerWorld _level)
                        _level.spawnParticles((ParticleEffect) ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 100, 1.0D, 2.0D, 1.0D, 2.0E-4D);
                    if (!this.getWorld().isClient()) {
                        this.addStatusEffect(new StatusEffectInstance(ModEffects.PURIFICATION, 100, 0));
                        this.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 100, 2));
                        this.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 1));
                    }
                    if (sourceentity instanceof LivingEntity _entity)
                        if (!_entity.getWorld().isClient())
                            _entity.addStatusEffect(new StatusEffectInstance(ModEffects.SOUL_DEATH, 100, 0));
                    sourceentity.damage(DamageUtil.build(this.getWorld(), source, DamageTypes.MAGIC), 5.0F);
                }
                if (Math.random() < 0.1D) {
                    if (!this.getWorld().isClient() && this.getWorld().getServer() != null)
                        if (Math.random() < 0.3D)
                            (this.getWorld()).getServer().getPlayerManager().broadcast(Text.translatable("entity.rainimator.naeus_king.message1"), false);
                        else if (Math.random() < 0.4D)
                            this.getWorld().getServer().getPlayerManager().broadcast(Text.translatable("entity.rainimator.naeus_king.message2"), false);
                        else if (Math.random() < 0.45D)
                            this.getWorld().getServer().getPlayerManager().broadcast(Text.translatable("entity.rainimator.naeus_king.message3"), false);
                        else if (Math.random() < 0.5D)
                            this.getWorld().getServer().getPlayerManager().broadcast(Text.translatable("entity.rainimator.naeus_king.message4"), false);
                        else
                            this.getWorld().getServer().getPlayerManager().broadcast(Text.translatable("entity.rainimator.naeus_king.message5"), false);

                    if (!sourceentity.getWorld().isClient() && sourceentity.getServer() != null)
                        sourceentity.getServer().getCommandManager().executeWithPrefix(sourceentity.getCommandSource().withSilent().withLevel(4), "title @p title {\"text\":\"！！！\",\"color\":\"red\"}");

                    BlockPos pos = this.getWorld().raycast(new RaycastContext(this.getCameraPosVec(1.0F), this.getCameraPosVec(1.0F).add(this.getRotationVec(1.0F).multiply(2.0D)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, NaeusKingEntity.this)).getBlockPos();
                    Runnable callback = () -> {
                        WorldAccess levelAccessor = this.getWorld();
                        BlockPos pos1 = this.getWorld().raycast(new RaycastContext(this.getCameraPosVec(1.0F), this.getCameraPosVec(1.0F).add(this.getRotationVec(1.0F).multiply(0.0D)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, NaeusKingEntity.this)).getBlockPos();
                        if (levelAccessor instanceof ServerWorld _level) {
                            LightningEntity entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                            if (entityToSpawn != null) {
                                entityToSpawn.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(new BlockPos(pos.getX(), (int) y, pos1.getZ())));
                                entityToSpawn.setCosmetic(true);
                                _level.spawnEntity(entityToSpawn);
                            }
                        }
                        this.getWorld().setBlockState(new BlockPos(pos.getX(), (int) y, pos1.getZ()), Blocks.FIRE.getDefaultState(), 3);
                        if (levelAccessor instanceof ServerWorld _level) {
                            LightningEntity entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                            if (entityToSpawn != null) {
                                entityToSpawn.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(new BlockPos(pos1.getX(), (int) y, pos.getZ())));
                                entityToSpawn.setCosmetic(true);
                                _level.spawnEntity(entityToSpawn);
                            }
                        }
                        this.getWorld().setBlockState(new BlockPos(pos1.getX(), (int) y, pos.getZ()), Blocks.FIRE.getDefaultState(), 3);
                    };
                    Timeout.create(50, () -> {
                        WorldAccess levelAccessor = this.getWorld();
                        if (levelAccessor instanceof ServerWorld _level) {
                            LightningEntity entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                            if (entityToSpawn != null) {
                                entityToSpawn.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(new BlockPos(pos.getX(), (int) y, pos.getZ())));
                                entityToSpawn.setCosmetic(true);
                                _level.spawnEntity(entityToSpawn);
                            }
                        }

                        this.getWorld().setBlockState(new BlockPos(pos.getX(), (int) y, pos.getZ()), Blocks.FIRE.getDefaultState(), 3);
                        Timeout.create(2, callback);
                        Timeout.create(4, callback);
                        Timeout.create(6, callback);
                        Timeout.create(8, callback);
                        Timeout.create(10, callback);
                        Timeout.create(12, callback);
                        Timeout.create(14, callback);
                        Timeout.create(16, callback);
                        Timeout.create(18, callback);
                        Timeout.create(20, callback);
                    });
                }
            }
        }
        return super.damage(source, amount);
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
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason reason, EntityData livingdata, NbtCompound tag) {
        EntityData retval = super.initialize(world, difficulty, reason, livingdata, tag);
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        SoundUtil.playSound(this.getWorld(), x, y, z, new Identifier(RainimatorMod.MOD_ID, "naeus_living"), 1, 1);
        if (world instanceof ServerWorld _level)
            _level.spawnParticles((ParticleEffect) ModParticles.RED_FLOWER, x, y, z, 50, 0.5D, 1.0D, 0.5D, 0.01D);
        if (world.getDifficulty() != Difficulty.PEACEFUL) {
            Runnable callback = () -> {
                if (this.isAlive())
                    SoundUtil.playSound(this.getWorld(), x, y, z, new Identifier(RainimatorMod.MOD_ID, "naeus_boss_music"), 1, 1);
            };
            Timeout.create(0, callback);
            Timeout.create(4300, callback);
            Timeout.create(8600, callback);
            Timeout.create(12900, callback);
            Timeout.create(17200, callback);
            Timeout.create(21500, callback);
            Timeout.create(25800, callback);
        }

        return retval;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        if (this.hasStatusEffect(ModEffects.ICE_PEOPLE) || this.hasStatusEffect(ModEffects.FEAR_DARK) || this.hasStatusEffect(ModEffects.SOUL_DEATH)) {
            this.clearStatusEffects();
            this.requestTeleport(x, (y + 3), z);
        }
        if (!this.isAlive())
            SoundUtil.stopSound(this.getWorld(), new Identifier(RainimatorMod.MOD_ID, "naeus_boss_music"));
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