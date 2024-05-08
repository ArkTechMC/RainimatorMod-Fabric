package com.rainimator.rainimatormod.registry;

import com.rainimator.rainimatormod.RainimatorMod;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final Potion PURIFICATION_POTION = new Potion(new StatusEffectInstance(ModEffects.PURIFICATION, 3000, 0));

    public static void init() {
        Registry.register(Registries.POTION, new Identifier(RainimatorMod.MOD_ID, "purification"), PURIFICATION_POTION);
    }
}
