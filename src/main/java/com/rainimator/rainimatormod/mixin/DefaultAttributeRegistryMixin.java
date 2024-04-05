package com.rainimator.rainimatormod.mixin;

import com.rainimator.rainimatormod.registry.ModEntities;
import net.minecraft.entity.attribute.DefaultAttributeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultAttributeRegistry.class)
public class DefaultAttributeRegistryMixin {
    @Inject(method = "checkMissing", at = @At("HEAD"))
    private static void addDefaultAttribute(CallbackInfo ci) {
        ModEntities.registerAttributes();
    }
}
