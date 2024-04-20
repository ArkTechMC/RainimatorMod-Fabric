package com.rainimator.rainimatormod.registry;

import com.iafenvoy.annotationlib.annotation.ModId;
import com.iafenvoy.annotationlib.annotation.ObjectReg;
import com.iafenvoy.annotationlib.api.IAnnotationLibEntryPoint;
import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.effect.*;
import net.minecraft.entity.effect.StatusEffect;

@ModId(RainimatorMod.MOD_ID)
public class ModEffects implements IAnnotationLibEntryPoint {
    @ObjectReg
    public static final StatusEffect FEAR_DARK = new FeardarkMobEffect();
    @ObjectReg
    public static final StatusEffect ICE_PEOPLE = new IcePeopleMobEffect();
    @ObjectReg
    public static final StatusEffect SOUL_DEATH = new SoulDeathMobEffect();
    @ObjectReg
    public static final StatusEffect PURIFICATION = new PurificationMobEffect();
    @ObjectReg
    public static final StatusEffect STUNNED = new StunnedMobEffect();
    @ObjectReg
    public static final StatusEffect SHADOW_EROSION = new ShadowErosionMobEffect();
}
