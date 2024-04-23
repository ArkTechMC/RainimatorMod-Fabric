package com.rainimator.rainimatormod.entity;

import com.iafenvoy.annotationlib.annotation.registration.AttributeBuilder;
import com.iafenvoy.mcrconvertlib.item.MonsterEntityBase;
import com.iafenvoy.mcrconvertlib.render.Stage;
import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.registry.ModItems;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class DarkShieldEntity extends MonsterEntityBase {
    public static final Stage.StagedEntityTextureProvider texture = Stage.ofProvider(RainimatorMod.MOD_ID, "ender_shield");

    public DarkShieldEntity(EntityType<DarkShieldEntity> type, World world) {
        super(type, world, EntityGroup.DEFAULT);
        this.experiencePoints = 20;
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.LIGHT_SWORD));
        this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(ModItems.LIGHT_SWORD));
    }

    @AttributeBuilder
    public static DefaultAttributeContainer.Builder createAttributes() {
        DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
        builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D);
        builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0D);
        builder = builder.add(EntityAttributes.GENERIC_ARMOR, 10.0D);
        builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0D);
        builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0D);
        builder = builder.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0D);
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
        if (damageSource.isOf(DamageTypes.TRIDENT))
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
    public SoundEvent getHurtSound(@NotNull DamageSource ds) {
        return Registries.SOUND_EVENT.get(new Identifier("entity.generic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return Registries.SOUND_EVENT.get(new Identifier("entity.generic.death"));
    }
}