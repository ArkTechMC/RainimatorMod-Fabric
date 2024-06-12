package dev.rainimator.mod.registry;

import com.iafenvoy.annotationlib.annotation.ModId;
import com.iafenvoy.annotationlib.annotation.registration.RegisterAll;
import com.iafenvoy.annotationlib.api.IAnnotatedRegistryEntry;
import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.item.enchantment.MagicProtection;
import dev.rainimator.mod.item.enchantment.ManaRegeneration;
import dev.rainimator.mod.item.enchantment.ManaUpgrade;
import net.minecraft.enchantment.Enchantment;

@ModId(RainimatorMod.MOD_ID)
@RegisterAll
public class RainimatorEnchantments implements IAnnotatedRegistryEntry {
    public static final Enchantment MANA_REGENERATION = new ManaRegeneration();
    public static final Enchantment MANA_UPGRADE = new ManaUpgrade();
    public static final Enchantment MAGIC_PROTECTION = new MagicProtection();
}
