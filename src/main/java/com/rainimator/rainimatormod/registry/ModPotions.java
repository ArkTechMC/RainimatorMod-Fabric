package com.rainimator.rainimatormod.registry;

import com.iafenvoy.annotationlib.annotation.ModId;
import com.iafenvoy.annotationlib.annotation.registration.RegisterAll;
import com.iafenvoy.annotationlib.api.IAnnotatedRegistryEntry;
import com.rainimator.rainimatormod.RainimatorMod;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;

@ModId(RainimatorMod.MOD_ID)
@RegisterAll
public class ModPotions implements IAnnotatedRegistryEntry {
    public static final Potion PURIFICATION_POTION = new Potion("purification", new StatusEffectInstance(ModEffects.PURIFICATION, 3000, 0));
}
