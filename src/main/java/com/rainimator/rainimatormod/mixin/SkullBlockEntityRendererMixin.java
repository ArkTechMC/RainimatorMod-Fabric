package com.rainimator.rainimatormod.mixin;

import com.google.common.collect.ImmutableMap;
import com.rainimator.rainimatormod.entity.HerobrineEntity;
import com.rainimator.rainimatormod.registry.ModSkulls;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.SkullBlock;
import net.minecraft.client.render.block.entity.SkullBlockEntityModel;
import net.minecraft.client.render.block.entity.SkullBlockEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.SkullEntityModel;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Environment(EnvType.CLIENT)
@Mixin(SkullBlockEntityRenderer.class)
public class SkullBlockEntityRendererMixin {
    @Shadow
    @Final
    private static Map<SkullBlock.SkullType, Identifier> TEXTURES;

    @Inject(method = "getModels", at = @At("TAIL"), cancellable = true)
    private static void registerOwn(EntityModelLoader modelLoader, CallbackInfoReturnable<Map<SkullBlock.SkullType, SkullBlockEntityModel>> cir) {
        TEXTURES.put(ModSkulls.SkullType.HEROBRINE, HerobrineEntity.texture.getTexture());
        ImmutableMap.Builder<SkullBlock.SkullType, SkullBlockEntityModel> builder = ImmutableMap.builder();
        builder.putAll(cir.getReturnValue());
        builder.put(ModSkulls.SkullType.HEROBRINE, new SkullEntityModel(modelLoader.getModelPart(EntityModelLayers.ZOMBIE_HEAD)));
        cir.setReturnValue(builder.build());
    }
}
