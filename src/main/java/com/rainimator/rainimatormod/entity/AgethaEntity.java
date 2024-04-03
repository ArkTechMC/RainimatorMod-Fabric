package com.rainimator.rainimatormod.entity;

import com.rainimator.rainimatormod.registry.ModEntities;
import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.registry.util.MonsterEntityBase;
import com.rainimator.rainimatormod.util.Stage;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

import java.util.Random;

public class AgethaEntity extends MonsterEntityBase {
    public static final Stage.StagedEntityTextureProvider texture = Stage.ofProvider("agetha");

    public AgethaEntity(EntityType<AgethaEntity> type, World world) {
        super(type, world, EntityGroup.DEFAULT);
        this.experiencePoints = 10;
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.DIAMOND_BIG_SWORD));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
        builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D);
        builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0D);
        builder = builder.add(EntityAttributes.GENERIC_ARMOR, 21.0D);
        builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0D);
        builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0D);
        builder = builder.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 4.0D);
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
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (source == DamageSource.DROWN)
            return false;
        return super.damage(source, amount);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason reason, EntityData livingdata, NbtCompound tag) {
        EntityData ret_val = super.initialize(world, difficulty, reason, livingdata, tag);
        if (!(world instanceof ServerWorld _level)) return ret_val;
        if (Math.random() < 0.1D) {
            SoldiersEntity soldiersEntity = new SoldiersEntity(ModEntities.SOLDIERS, _level);
            soldiersEntity.refreshPositionAndAngles(this.getX() + MathHelper.nextInt(new Random(), -2, 2), this.getY() + 2.0D, this.getZ() + MathHelper.nextInt(new Random(), -2, 2), world.getRandom().nextFloat() * 360.0F, 0.0F);
            soldiersEntity.initialize(_level, world.getLocalDifficulty(soldiersEntity.getBlockPos()), SpawnReason.MOB_SUMMONED, null, null);
            world.spawnEntity(soldiersEntity);
        } else if (Math.random() < 0.1D) {
            AgethaEntity agethaEntity = new AgethaEntity(ModEntities.AGETHA, _level);
            agethaEntity.refreshPositionAndAngles(this.getX() + MathHelper.nextInt(new Random(), -2, 2), this.getY() + 2.0D, this.getZ() + MathHelper.nextInt(new Random(), -2, 2), world.getRandom().nextFloat() * 360.0F, 0.0F);
            agethaEntity.initialize(_level, world.getLocalDifficulty(agethaEntity.getBlockPos()), SpawnReason.MOB_SUMMONED, null, null);
            world.spawnEntity(agethaEntity);
        } else if (Math.random() < 0.1D) {
            ArcherEntity archerEntity = new ArcherEntity(ModEntities.ARCHER, _level);
            archerEntity.refreshPositionAndAngles(this.getX() + MathHelper.nextInt(new Random(), -2, 2), this.getY() + 2.0D, this.getZ() + MathHelper.nextInt(new Random(), -2, 2), world.getRandom().nextFloat() * 360.0F, 0.0F);
            archerEntity.initialize(_level, world.getLocalDifficulty(archerEntity.getBlockPos()), SpawnReason.MOB_SUMMONED, null, null);
            world.spawnEntity(archerEntity);
        }
        return ret_val;
    }
}