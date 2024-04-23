package com.rainimator.rainimatormod.registry;

import com.iafenvoy.annotationlib.annotation.ModId;
import com.iafenvoy.annotationlib.annotation.registration.RegisterAll;
import com.iafenvoy.annotationlib.api.IAnnotatedRegistryEntry;
import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.effect.*;
import net.minecraft.entity.effect.StatusEffect;

@ModId(RainimatorMod.MOD_ID)
@RegisterAll
public class ModEffects implements IAnnotatedRegistryEntry {
    public static final StatusEffect FEAR_DARK = new FeardarkMobEffect();
    public static final StatusEffect ICE_PEOPLE = new IcePeopleMobEffect();
    public static final StatusEffect SOUL_DEATH = new SoulDeathMobEffect();
    public static final StatusEffect PURIFICATION = new PurificationMobEffect();
    public static final StatusEffect STUNNED = new StunnedMobEffect();
    public static final StatusEffect SHADOW_EROSION = new ShadowErosionMobEffect();
}
