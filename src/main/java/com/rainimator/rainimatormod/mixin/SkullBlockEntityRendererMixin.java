package com.rainimator.rainimatormod.mixin;

import com.rainimator.rainimatormod.registry.ModSkulls;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.SkullBlock;
import net.minecraft.client.render.block.entity.SkullBlockEntityModel;
import net.minecraft.client.render.block.entity.SkullBlockEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLoader;
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
    @Final
    @Shadow
    private static Map<SkullBlock.SkullType, Identifier> TEXTURES;

    @Inject(method = "getModels", at = @At("TAIL"))
    private static void addOwnModels(EntityModelLoader modelLoader, CallbackInfoReturnable<Map<SkullBlock.SkullType, SkullBlockEntityModel>> cir) {
        Map<SkullBlock.SkullType, SkullBlockEntityModel> models = cir.getReturnValue();
//        ModSkulls.createSkullRenderers(TEXTURES, modelLoader, models);
    }
}
