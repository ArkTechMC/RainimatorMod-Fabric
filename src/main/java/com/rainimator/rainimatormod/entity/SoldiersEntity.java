package com.rainimator.rainimatormod.entity;

import com.rainimator.rainimatormod.registry.ModEntities;
import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.registry.util.MonsterEntityBase;
import com.rainimator.rainimatormod.util.RandomHelper;
import com.rainimator.rainimatormod.util.Stage;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

public class SoldiersEntity extends MonsterEntityBase implements RangedAttackMob {
    public static final Stage.StagedEntityTextureProvider texture = Stage.ofProvider("soldiers");

    public SoldiersEntity(EntityType<SoldiersEntity> type, World world) {
        super(type, world, EntityGroup.DEFAULT);
        this.experiencePoints = 10;
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.SOLDIERS_WAR_HAMMER));
        this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(ModItems.SNOW_SHIELD));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
        builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D);
        builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 35.0D);
        builder = builder.add(EntityAttributes.GENERIC_ARMOR, 25.0D);
        builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0D);
        builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0D);
        builder = builder.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0D);
        builder = builder.add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.0D);
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
        this.goalSelector.add(5, new LongDoorInteractGoal(this, true));
        this.goalSelector.add(6, new LongDoorInteractGoal(this, false));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.goalSelector.add(8, new SwimGoal(this));
        this.goalSelector.add(1, new ProjectileAttackGoal(this, 1.25D, 20, 10.0F) {
            public boolean shouldContinue() {
                return this.canStart();
            }
        });
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
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason reason, EntityData livingdata, NbtCompound tag) {
        EntityData retval = super.initialize(world, difficulty, reason, livingdata, tag);
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        if (Math.random() < 0.1D) {
            if (world instanceof ServerWorld _level) {
                SoldiersEntity soldiersEntity = new SoldiersEntity(ModEntities.SOLDIERS, _level);
                soldiersEntity.refreshPositionAndAngles(x + RandomHelper.nextInt(-2, 2), y + 2.0D, z + RandomHelper.nextInt(-2, 2), (world).getRandom().nextFloat() * 360.0F, 0.0F);
                soldiersEntity.initialize(_level, (world).getLocalDifficulty(soldiersEntity.getBlockPos()), SpawnReason.MOB_SUMMONED, null, null);
                world.spawnEntity(soldiersEntity);
            }
        } else if (Math.random() < 0.1D) {
            if (world instanceof ServerWorld _level) {
                AgethaEntity agethaEntity = new AgethaEntity(ModEntities.AGETHA, _level);
                agethaEntity.refreshPositionAndAngles(x + RandomHelper.nextInt(-2, 2), y + 2.0D, z + RandomHelper.nextInt(-2, 2), (world).getRandom().nextFloat() * 360.0F, 0.0F);
                agethaEntity.initialize(_level, world.getLocalDifficulty(agethaEntity.getBlockPos()), SpawnReason.MOB_SUMMONED, null, null);
                world.spawnEntity(agethaEntity);
            }
        } else if (Math.random() < 0.1D && world instanceof ServerWorld) {
            ServerWorld _level = (ServerWorld) world;
            ArcherEntity archerEntity = new ArcherEntity(ModEntities.ARCHER, _level);
            archerEntity.refreshPositionAndAngles(x + RandomHelper.nextInt(-2, 2), y + 2.0D, z + RandomHelper.nextInt(-2, 2), (world).getRandom().nextFloat() * 360.0F, 0.0F);
            archerEntity.initialize(_level, world.getLocalDifficulty(archerEntity.getBlockPos()), SpawnReason.MOB_SUMMONED, null, null);
            world.spawnEntity(archerEntity);
        }

        return retval;
    }

    @Override
    public void attack(LivingEntity target, float flval) {
        SoldiersEntityProjectile entityarrow = new SoldiersEntityProjectile(ModEntities.SOLDIERS_PROJECTILE, this, this.getWorld());
        double d0 = target.getY() + target.getStandingEyeHeight() - 1.1D;
        double d1 = target.getX() - this.getX();
        double d3 = target.getZ() - this.getZ();
        entityarrow.setVelocity(d1, d0 - entityarrow.getY() + Math.sqrt(d1 * d1 + d3 * d3) * 0.20000000298023224D, d3, 1.6F, 12.0F);
        this.getWorld().spawnEntity(entityarrow);
    }
}