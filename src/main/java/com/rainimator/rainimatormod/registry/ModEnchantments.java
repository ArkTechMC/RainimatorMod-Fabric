package com.rainimator.rainimatormod.registry;

import com.iafenvoy.annotationlib.annotation.ModId;
import com.iafenvoy.annotationlib.annotation.registration.RegisterAll;
import com.iafenvoy.annotationlib.api.IAnnotatedRegistryEntry;
import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.item.enchantment.ManaRegeneration;
import com.rainimator.rainimatormod.item.enchantment.ManaUpgrade;
import net.minecraft.enchantment.Enchantment;

@ModId(RainimatorMod.MOD_ID)
@RegisterAll
public class ModEnchantments implements IAnnotatedRegistryEntry {
    public static final Enchantment MANA_REGENERATION = new ManaRegeneration();
    public static final Enchantment MANA_UPGRADE = new ManaUpgrade();
}
