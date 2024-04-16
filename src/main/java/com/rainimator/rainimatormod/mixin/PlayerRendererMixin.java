package com.rainimator.rainimatormod.mixin;

import com.rainimator.rainimatormod.renderer.WingsOfSalvationRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Environment(EnvType.CLIENT)
@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerRendererMixin extends LivingEntityRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {
    public PlayerRendererMixin(EntityRendererFactory.Context rainimator$context, boolean p_174558_) {
        super(rainimator$context, new PlayerEntityModel<>(rainimator$context.getPart(p_174558_ ? EntityModelLayers.PLAYER_SLIM : EntityModelLayers.PLAYER), p_174558_), 0.5F);
    }

    @Inject(method = "<init>", at = @At("TAIL"), locals = LocalCapture.CAPTURE_FAILHARD)
    public void postConstructor(EntityRendererFactory.Context p_174557_, boolean p_174558_, CallbackInfo ci) {
        this.addFeature(new WingsOfSalvationRenderer<>(this, p_174557_.getModelLoader()));
    }
}
