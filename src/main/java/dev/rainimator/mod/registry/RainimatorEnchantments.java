package dev.rainimator.mod.registry;

import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.item.enchantment.MagicProtection;
import dev.rainimator.mod.item.enchantment.ManaRegeneration;
import dev.rainimator.mod.item.enchantment.ManaUpgrade;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

@SuppressWarnings("unused")
public class RainimatorEnchantments {
    public static final Enchantment MANA_REGENERATION = register("mana_regeneration", new ManaRegeneration());
    public static final Enchantment MANA_UPGRADE = register("mana_upgrade", new ManaUpgrade());
    public static final Enchantment MAGIC_PROTECTION = register("mana_protection", new MagicProtection());

    private static <T extends Enchantment> T register(String name, T enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(RainimatorMod.MOD_ID, name), enchantment);
    }

    public static void init() {
    }
}
