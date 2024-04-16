package com.rainimator.rainimatormod.renderer;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.renderer.model.wing.WingsOfSalvationModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
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
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class WingsOfSalvationRenderer<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> {
    private static final Identifier WINGS_LOCATION = new Identifier(RainimatorMod.MOD_ID, "textures/wings/tech_wings.png");
    private static final Identifier WINGS_LOCATION2 = new Identifier(RainimatorMod.MOD_ID, "textures/wings/tech_wings_2.png");

    public WingsOfSalvationRenderer(FeatureRendererContext<T, M> renderLayerParent, EntityModelLoader modelSet) {
        super(renderLayerParent);
    }

    @Override
    public void render(MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight, T entity, float limbAngle, float limbDistance, float p_116957_, float animationProgress, float headYaw, float headPitch) {
        ItemStack itemtack = entity.getEquippedStack(EquipmentSlot.CHEST);
        if (itemtack.getItem() == ModItems.WINGS_OF_SALVATION) {
            WingsOfSalvationModel<T> wingModel = new WingsOfSalvationModel<>(WingsOfSalvationModel.createLayer().createModel());
            poseStack.push();
            poseStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));
            poseStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180));
            this.getContextModel().copyStateTo(wingModel);
            wingModel.setAngles(entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferSource, RenderLayer.getArmorCutoutNoCull(WINGS_LOCATION), false, itemtack.hasGlint());
            wingModel.render(poseStack, vertexconsumer, packedLight, OverlayTexture.DEFAULT_UV, 0, 1.0F, 1.0F, 0.5F);
            vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferSource, RenderLayer.getArmorCutoutNoCull(WINGS_LOCATION2), false, itemtack.hasGlint());
            wingModel.render(poseStack, vertexconsumer, packedLight, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
            poseStack.pop();
        }
    }
}
