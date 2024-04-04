package com.rainimator.rainimatormod.registry;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.effect.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class ModEffects {
    public static final StatusEffect FEAR_DARK = register("fear_dark", FeardarkMobEffect::new);
    public static final StatusEffect ICE_PEOPLE = register("ice_people", IcePeopleMobEffect::new);
    public static final StatusEffect SOUL_DEATH = register("soul_death", SoulDeathMobEffect::new);
    public static final StatusEffect PURIFICATION = register("purification", PurificationMobEffect::new);
    public static final StatusEffect STUNNED = register("stunned", StunnedMobEffect::new);
    public static final StatusEffect SHADOW_EROSION = register("shadow_erosion", ShadowErosionMobEffect::new);

    private static StatusEffect register(String name, Supplier<StatusEffect> provider) {
        return register(name, provider.get());
    }

    private static StatusEffect register(String name, StatusEffect obj) {
        Registry.register(Registries.STATUS_EFFECT, new Identifier(RainimatorMod.MOD_ID, name), obj);
        return obj;
    }
}
