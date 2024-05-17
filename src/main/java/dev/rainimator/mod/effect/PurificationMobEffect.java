package dev.rainimator.mod.effect;

import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.registry.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;

import java.util.ArrayList;
import java.util.List;

public class PurificationMobEffect extends StatusEffect {
    private static final List<StatusEffect> effects = new ArrayList<>();

    public PurificationMobEffect() {
        super(StatusEffectCategory.BENEFICIAL, -10027009);
    }

    public static synchronized void initEffectList() {
        effects.add(ModEffects.FEAR_DARK);
        effects.add(ModEffects.SOUL_DEATH);
        effects.add(ModEffects.STUNNED);
        effects.add(ModEffects.ICE_PEOPLE);
        effects.add(StatusEffects.BAD_OMEN);
        effects.add(StatusEffects.BLINDNESS);
        effects.add(StatusEffects.HUNGER);
        effects.add(StatusEffects.INSTANT_DAMAGE);
        effects.add(StatusEffects.MINING_FATIGUE);
        effects.add(StatusEffects.POISON);
        effects.add(StatusEffects.SLOWNESS);
        effects.add(StatusEffects.UNLUCK);
        effects.add(StatusEffects.WEAKNESS);
        effects.add(StatusEffects.WITHER);
        effects.add(StatusEffects.NAUSEA);
        effects.add(StatusEffects.LEVITATION);
    }

    @Override
    public String getTranslationKey() {
        return "effect." + RainimatorMod.MOD_ID + ".purification";
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (effects.size() == 0) initEffectList();
        for (StatusEffect effect : effects)
            if (entity.hasStatusEffect(effect)) {
                entity.removeStatusEffect(effect);
                break;
            }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
