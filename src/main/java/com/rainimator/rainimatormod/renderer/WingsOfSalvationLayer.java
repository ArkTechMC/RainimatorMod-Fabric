package com.rainimator.rainimatormod.renderer;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.renderer.model.wing.WingsOfSalvationModel;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class WingsOfSalvationLayer<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> {
    private static final Identifier WINGS_LOCATION = new Identifier(RainimatorMod.MOD_ID, "textures/entities/wings_of_salvation.png");
    private final WingsOfSalvationModel<T> wingModel;

    public WingsOfSalvationLayer(FeatureRendererContext<T, M> renderLayerParent, EntityModelLoader modelSet) {
        super(renderLayerParent);
        this.wingModel = new WingsOfSalvationModel<>(modelSet.getModelPart(WingsOfSalvationModel.LAYER_LOCATION));
    }

    @Override
    public void render(MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight, T entity, float limbAngle, float limbDistance, float p_116957_, float animationProgress, float headYaw, float headPitch) {
        ItemStack itemstack = entity.getEquippedStack(EquipmentSlot.CHEST);
        if (itemstack.getItem() == ModItems.WINGS_OF_SALVATION) {
            poseStack.push();
            poseStack.translate(0.0D, 0.0D, 0.125D);
            this.getContextModel().copyStateTo(this.wingModel);
            this.wingModel.setAngles(entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferSource, RenderLayer.getArmorCutoutNoCull(WINGS_LOCATION), false, itemstack.hasGlint());
            this.wingModel.render(poseStack, vertexconsumer, packedLight, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
            poseStack.pop();
        }
    }
}
