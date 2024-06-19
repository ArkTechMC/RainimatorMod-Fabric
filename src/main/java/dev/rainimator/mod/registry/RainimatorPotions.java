package dev.rainimator.mod.registry;

import dev.rainimator.mod.RainimatorMod;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RainimatorPotions {
    public static final Potion PURIFICATION_POTION = register("purification", new Potion("purification", new StatusEffectInstance(RainimatorEffects.PURIFICATION, 3000, 0)));

    private static Potion register(String name, Potion potion) {
        return Registry.register(Registries.POTION, new Identifier(RainimatorMod.MOD_ID, name), potion);
    }

    public static void init() {
    }
}
