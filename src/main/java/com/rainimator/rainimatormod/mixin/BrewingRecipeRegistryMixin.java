package com.rainimator.rainimatormod.mixin;

import com.rainimator.rainimatormod.registry.ModEffects;
import com.rainimator.rainimatormod.registry.ModItems;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrewingRecipeRegistry.class)
public class BrewingRecipeRegistryMixin {
    @Shadow
    public static void registerPotionRecipe(Potion input, Item item, Potion output) {
    }

    @Inject(method = "registerDefaults", at = @At("RETURN"))
    private static void afterRegistration(CallbackInfo cb) {
        registerPotionRecipe(Potions.AWKWARD, ModItems.BLUE_DIAMOND, new Potion("purification", new StatusEffectInstance(ModEffects.PURIFICATION, 3000, 0)));
    }
}
