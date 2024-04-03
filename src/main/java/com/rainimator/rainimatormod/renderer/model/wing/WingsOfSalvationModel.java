package com.rainimator.rainimatormod.renderer.model.wing;

import com.rainimator.rainimatormod.RainimatorMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

@Environment(EnvType.CLIENT)
public class WingsOfSalvationModel<T extends LivingEntity> extends EntityModel<T> {
    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(RainimatorMod.MOD_ID, "wings_of_salvation"), "main");
    public final ModelPart leftWing;
    public final ModelPart rightWing;
    public State state = State.IDLE;

    public WingsOfSalvationModel(ModelPart root) {
        this.leftWing = root.getChild("leftWing");
        this.rightWing = root.getChild("rightWing");
    }

    public static TexturedModelData createLayer() {
        ModelData meshdefinition = new ModelData();
        ModelPartData partdefinition = meshdefinition.getRoot();
        Dilation cubedeformation = new Dilation(1.0F);
        partdefinition.addChild("leftWing",
                ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(0.0F, 0.0F, 0.0F, 1.0F, 16.0F, 32.0F, cubedeformation),
                ModelTransform.of(-16F, 19F, 1F, 0F, 1.57F, -0.75F));
        partdefinition.addChild("rightWing",
                ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, 0.0F, 0.0F, 1.0F, 16.0F, 32.0F, cubedeformation),
                ModelTransform.of(16F, 19F, 0F, 0F, -1.57F, 0.75F));
//        partdefinition.addOrReplaceChild("leftWing", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, 0.0F, 0.0F, 10.0F, 20.0F, 2.0F, cubedeformation), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
//        partdefinition.addOrReplaceChild("rightWing", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 20.0F, 2.0F, cubedeformation), PartPose.offsetAndRotation(-5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(meshdefinition, 64, 64);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.state = State.IDLE;
        float a = 0.125F;
        float b = 0.1F;
        float k = 0.3F;
        float l = -0.7F;
        float m = -1.0F;
        float n = 0.0F;

        if (entity.isFallFlying()) {
            this.state = State.FLYING;
            float o = 1.0F;
            Vec3d vec3d = entity.getVelocity();

            if (vec3d.y < 0.0D) {
                Vec3d vec3d2 = vec3d.normalize();
                o = 1.0F - (float) Math.pow(-vec3d2.y, 1.5D);
            }

            k = o * 0.35F + (1.0F - o) * k;
            l = o * -1.6F + (0.3F - o) * l;

            if (entity.forwardSpeed > 0) {
                a = 0.4F;
                b = 1.0F;
            }
        } else if (entity.isSneaking()) {
            this.state = State.CROUCHING;
            k = 0.7F;
            m = 0.0F;
            n = 0.09F;
        }

        k += Math.sin(entity.age * a) * b;
        this.rightWing.pivotX = 7.0F;
        this.rightWing.pivotY = m;

        if (entity instanceof AbstractClientPlayerEntity player) {
            player.elytraPitch = player.elytraPitch + (k - player.elytraPitch) * 0.1F;
            player.elytraYaw = player.elytraYaw + (n - player.elytraYaw) * 0.1F;
            player.elytraRoll = player.elytraRoll + (l - player.elytraRoll) * 0.1F;
            this.rightWing.pitch = player.elytraPitch;
            this.rightWing.yaw = player.elytraYaw;
            this.rightWing.roll = player.elytraRoll;
        } else {
            this.rightWing.pitch = k;
            this.rightWing.yaw = n;
            this.rightWing.roll = l;
        }

        this.leftWing.pivotX = -this.rightWing.pivotX;
        this.leftWing.pivotY = this.rightWing.pivotY;
        this.leftWing.pitch = this.rightWing.pitch;
        this.leftWing.yaw = -this.rightWing.yaw;
        this.leftWing.roll = -this.rightWing.roll;
    }

    @Override
    public void render(MatrixStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.leftWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.rightWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public enum State {
        IDLE, CROUCHING, FLYING
    }
}
