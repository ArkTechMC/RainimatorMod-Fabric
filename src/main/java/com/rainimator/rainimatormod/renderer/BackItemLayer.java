package com.rainimator.rainimatormod.renderer;

import com.rainimator.rainimatormod.registry.ModItems;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3f;

import java.util.HashMap;
import java.util.function.Consumer;

public class BackItemLayer implements TrinketRenderer {
    private static final HashMap<Item, Consumer<MatrixStack>> specialItemPose = new HashMap<>();

    public static void initPoseConsumers() {
        specialItemPose.put(ModItems.ENDER_BIG_SWORD, poseStack -> {
            poseStack.translate(-0.7, -0.3, 0.15);
            poseStack.scale(0.6F, 0.6F, 0.6F);
            poseStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(45));
        });
        specialItemPose.put(ModItems.RAIN_SWORD, poseStack -> {
            poseStack.translate(-0.7, -0.3, 0.3);
            poseStack.scale(0.6F, 0.6F, 0.6F);
            poseStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(45));
        });
    }

    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if (specialItemPose.size() == 0) initPoseConsumers();
        matrices.push();
        matrices.multiply(Vec3f.NEGATIVE_Y.getDegreesQuaternion(entity.bodyYaw));
        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180));
        if (specialItemPose.containsKey(stack.getItem())) specialItemPose.get(stack.getItem()).accept(matrices);
        matrices.translate(0, -2, -0.6);
        MinecraftClient.getInstance().getHeldItemRenderer().renderItem(entity, stack, ModelTransformation.Mode.HEAD, false, matrices, vertexConsumers, light);
        matrices.pop();
    }
}
