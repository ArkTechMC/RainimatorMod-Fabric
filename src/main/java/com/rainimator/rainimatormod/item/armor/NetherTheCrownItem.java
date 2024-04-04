package com.rainimator.rainimatormod.item.armor;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.entity.WitheredSkeletonsEntity;
import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.registry.util.ArmorWithTickItem;
import com.rainimator.rainimatormod.renderer.model.ModelNetherCrown;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class NetherTheCrownItem extends ArmorWithTickItem {
    public NetherTheCrownItem(Type slot, Item.Settings properties) {
        super(new ArmorMaterial() {
            @Override
            public int getDurability(Type slot) {
                return new int[]{13, 15, 16, 11}[slot.getEquipmentSlot().getEntitySlotId()] * 30;
            }

            @Override
            public int getProtection(Type slot) {
                return new int[]{0, 0, 0, 5}[slot.getEquipmentSlot().getEntitySlotId()];
            }

            @Override
            public int getEnchantability() {
                return 15;
            }

            @Override
            public SoundEvent getEquipSound() {
                return null;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.empty();
            }

            @Override
            public String getName() {
                return RainimatorMod.MOD_ID + ":nether_the_crown";
            }

            @Override
            public float getToughness() {
                return 0.0F;
            }

            @Override
            public float getKnockbackResistance() {
                return 0.0F;
            }
        }, slot, properties);
    }

    @Override
    public void onArmorTick(World world, PlayerEntity entity) {
        if (entity == null) {
            return;
        }
        Vec3d _center = new Vec3d(entity.getX(), entity.getY(), entity.getZ());
        List<Entity> _entfound = world.getEntitiesByClass(Entity.class, (new Box(_center, _center)).expand(16.0D), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.squaredDistanceTo(_center))).toList();
        for (Entity entityiterator : _entfound) {
            if (entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.NETHER_THE_CROWN_HELMET) {
                if (entityiterator instanceof WitheredSkeletonsEntity) {
                    MobEntity _entity = (MobEntity) entityiterator;
                    _entity.getNavigation().stop();
                    continue;
                }
                if (entityiterator instanceof WitherSkeletonEntity) {
                    MobEntity _entity = (MobEntity) entityiterator;
                    _entity.getNavigation().stop();
                    continue;
                }
                if (entityiterator instanceof PiglinEntity) {
                    MobEntity _entity = (MobEntity) entityiterator;
                    _entity.getNavigation().stop();
                    continue;
                }
                if (entityiterator instanceof PiglinBruteEntity) {
                    MobEntity _entity = (MobEntity) entityiterator;
                    _entity.getNavigation().stop();
                    continue;
                }
                if (entityiterator instanceof ZombifiedPiglinEntity) {
                    MobEntity _entity = (MobEntity) entityiterator;
                    _entity.getNavigation().stop();
                    continue;
                }
                if (entityiterator instanceof ZoglinEntity) {
                    MobEntity _entity = (MobEntity) entityiterator;
                    _entity.getNavigation().stop();
                }
            }
        }
    }

    public static class Helmet extends NetherTheCrownItem implements ArmorRenderer {
        public Helmet() {
            super(Type.HELMET, new Settings().fireproof());
            ArmorRenderer.register(this, this);
        }

        private BipedEntityModel<LivingEntity> getArmorModel(LivingEntity living) {
            BipedEntityModel<LivingEntity> armorModel = new BipedEntityModel<>(new ModelPart(Collections.emptyList(), Map.of("head", (new ModelNetherCrown<>(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(ModelNetherCrown.LAYER_LOCATION))).Head, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(
                    Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(
                    Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(
                    Collections.emptyList(), Collections.emptyMap()))));
            armorModel.sneaking = living.isSneaking();
            armorModel.riding = living.hasVehicle();
            armorModel.child = living.isBaby();
            return armorModel;
        }

        private Identifier getTexture() {
            return new Identifier(RainimatorMod.MOD_ID, "nether_the_crown");
        }

        @Override
        public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, ItemStack stack, LivingEntity entity, EquipmentSlot slot, int light, BipedEntityModel<LivingEntity> contextModel) {
            ArmorRenderer.renderPart(matrices, vertexConsumers, light, stack, this.getArmorModel(entity), this.getTexture());
        }
    }
}
