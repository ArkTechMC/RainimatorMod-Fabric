package com.rainimator.rainimatormod.item.armor;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.renderer.model.ModelCustomModel;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.Collections;
import java.util.Map;

public class GluttonArmorItem extends ArmorItem {
    public GluttonArmorItem(Type slot, Item.Settings properties) {
        super(new ArmorMaterial() {
            @Override
            public int getDurability(Type slot) {
                return new int[]{13, 15, 16, 11}[slot.getEquipmentSlot().getEntitySlotId()] * 25;
            }

            @Override
            public int getProtection(Type slot) {
                return new int[]{0, 0, 0, 4}[slot.getEquipmentSlot().getEntitySlotId()];
            }

            @Override
            public int getEnchantability() {
                return 9;
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
                return RainimatorMod.MOD_ID + ":glutton_armors";
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

    public static class Helmet extends GluttonArmorItem implements ArmorRenderer {
        public Helmet() {
            super(Type.HELMET, new Settings());
            ArmorRenderer.register(this, this);
        }

        private BipedEntityModel<LivingEntity> getArmorModel(LivingEntity living) {
            BipedEntityModel<LivingEntity> armorModel = new BipedEntityModel<>(new ModelPart(Collections.emptyList(), Map.of("head", (new ModelCustomModel<>(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(ModelCustomModel.LAYER_LOCATION))).Head, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(
                    Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(
                    Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(
                    Collections.emptyList(), Collections.emptyMap()))));
            armorModel.sneaking = living.isSneaking();
            armorModel.riding = living.hasVehicle();
            armorModel.child = living.isBaby();
            return armorModel;
        }

        private Identifier getTexture() {
            return new Identifier(RainimatorMod.MOD_ID, "textures/models/armor/glutton_armors_layer_1.png");
        }

        @Override
        public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, ItemStack stack, LivingEntity entity, EquipmentSlot slot, int light, BipedEntityModel<LivingEntity> contextModel) {
            ArmorRenderer.renderPart(matrices, vertexConsumers, light, stack, this.getArmorModel(entity), this.getTexture());
        }
    }
}
