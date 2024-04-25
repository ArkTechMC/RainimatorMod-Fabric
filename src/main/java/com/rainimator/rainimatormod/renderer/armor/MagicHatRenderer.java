package com.rainimator.rainimatormod.renderer.armor;

import com.rainimator.rainimatormod.renderer.model.ModelMagic;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.Collections;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class MagicHatRenderer implements ArmorRenderer {
    private BipedEntityModel<LivingEntity> getArmorModel(LivingEntity living) {
        BipedEntityModel<LivingEntity> armorModel = new BipedEntityModel<>(new ModelPart(Collections.emptyList(), Map.of("head", (new ModelMagic<>(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(ModelMagic.LAYER_LOCATION))).Head, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(
                Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(
                Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(
                Collections.emptyList(), Collections.emptyMap()))));
        armorModel.sneaking = living.isSneaking();
        armorModel.riding = living.hasVehicle();
        armorModel.child = living.isBaby();
        return armorModel;
    }

    private Identifier getTexture() {
        return new Identifier("textures/models/armor/magic_hat.png");
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, ItemStack stack, LivingEntity entity, EquipmentSlot slot, int light, BipedEntityModel<LivingEntity> contextModel) {
        ArmorRenderer.renderPart(matrices, vertexConsumers, light, stack, this.getArmorModel(entity), this.getTexture());
    }
}
