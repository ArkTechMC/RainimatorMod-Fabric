package dev.rainimator.mod.entity;

import com.iafenvoy.annotationlib.annotation.registration.AttributeBuilder;
import com.iafenvoy.mcrconvertlib.item.MonsterEntityBase;
import com.iafenvoy.mcrconvertlib.render.Stage;
import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.data.fraction.Fraction;
import dev.rainimator.mod.registry.RainimatorItems;
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
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ZombiesEntity extends MonsterEntityBase {
    public static final Stage.StagedEntityTextureProvider texture = Stage.ofProvider(RainimatorMod.MOD_ID, "zombies");

    public ZombiesEntity(EntityType<ZombiesEntity> type, World world) {
        super(type, world, EntityGroup.UNDEAD);
        this.experiencePoints = 0;
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(RainimatorItems.IRON_LONG_SPEAR));
        this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
        this.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));
        this.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
    }

    @AttributeBuilder
    public static DefaultAttributeContainer.Builder createAttributes() {
        DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
        builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D);
        builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0D);
        builder = builder.add(EntityAttributes.GENERIC_ARMOR, 0.0D);
        builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0D);
        builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0D);
        builder = builder.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0D);
        builder = builder.add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.0D);
        return builder;
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        Fraction.findAndAddTarget(this);
        this.goalSelector.add(2, new AvoidSunlightGoal(this));
        this.goalSelector.add(3, new MeleeAttackGoal(this, 1.2D, true) {
            protected double getSquaredMaxAttackDistance(LivingEntity entity) {
                return (this.mob.getWidth() * this.mob.getWidth() + entity.getWidth());
            }
        });
        this.targetSelector.add(4, (new RevengeGoal(this)).setGroupRevenge());
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.goalSelector.add(7, new SwimGoal(this));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return Registries.SOUND_EVENT.get(new Identifier("entity.zombie.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return Registries.SOUND_EVENT.get(new Identifier("entity.generic.death"));
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        if (damageSource.isOf(DamageTypes.DROWN))
            return true;
        return super.isInvulnerableTo(damageSource);
    }
}