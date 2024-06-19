package dev.rainimator.mod.registry;

import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.effect.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RainimatorEffects {
    public static final StatusEffect FEAR_DARK = register("fear_dark", new FeardarkMobEffect());
    public static final StatusEffect ICE_PEOPLE = register("ice_people", new IcePeopleMobEffect());
    public static final StatusEffect SOUL_DEATH = register("soul_death", new SoulDeathMobEffect());
    public static final StatusEffect PURIFICATION = register("purification", new PurificationMobEffect());
    public static final StatusEffect STUNNED = register("stunned", new StunnedMobEffect());
    public static final StatusEffect SHADOW_EROSION = register("shadow_erosion", new ShadowErosionMobEffect());

    private static <T extends StatusEffect> T register(String name, T effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(RainimatorMod.MOD_ID, name), effect);
    }

    public static void init() {
    }
}
