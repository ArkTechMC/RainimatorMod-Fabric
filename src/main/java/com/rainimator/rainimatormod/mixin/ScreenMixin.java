package com.rainimator.rainimatormod.mixin;

import com.rainimator.rainimatormod.registry.util.RainimatorInfoManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(Screen.class)
public class ScreenMixin {
    @Inject(method = "renderTooltip(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/item/ItemStack;II)V", at = @At("HEAD"))
    private void onRenderTooltipInternal(MatrixStack matrices, ItemStack stack, int x, int y, CallbackInfo ci) {
        if (stack != ItemStack.EMPTY)
            RainimatorInfoManager.onRenderToolTip(stack.getItem());
    }
}
