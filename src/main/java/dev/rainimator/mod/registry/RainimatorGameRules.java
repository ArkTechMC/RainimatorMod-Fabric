package dev.rainimator.mod.registry;

import dev.rainimator.mod.RainimatorMod;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.gamerule.v1.rule.DoubleRule;
import net.minecraft.world.GameRules;

public class RainimatorGameRules {
    //main
    public static final GameRules.Key<GameRules.BooleanRule> showModLightening = GameRuleRegistry.register("showLightening", GameRules.Category.UPDATES, GameRuleFactory.createBooleanRule(true));
    public static final GameRules.Key<DoubleRule> baseMaxMana = register("basic.baseMaxMana", GameRules.Category.PLAYER, GameRuleFactory.createDoubleRule(100));
    public static final GameRules.Key<DoubleRule> baseRestoreSpeed = register("basic.baseRestoreSpeed", GameRules.Category.PLAYER, GameRuleFactory.createDoubleRule(3));
    public static final GameRules.Key<GameRules.BooleanRule> enableWingsCreativeFly = register("basic.enableWingsCreativeFly", GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(false));
    public static final GameRules.Key<GameRules.BooleanRule> enableArmorEffect = register("basic.enableArmorEffect", GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(true));
    //mana
    public static final GameRules.Key<DoubleRule> blackbone_the_blade = register("mana.blackbone_the_blade", GameRules.Category.MISC, GameRuleFactory.createDoubleRule(30));
    public static final GameRules.Key<DoubleRule> blue_diamond_sword = register("mana.blue_diamond_sword", GameRules.Category.MISC, GameRuleFactory.createDoubleRule(40));
    public static final GameRules.Key<DoubleRule> ender_big_sword = register("mana.ender_big_sword", GameRules.Category.MISC, GameRuleFactory.createDoubleRule(15));
    public static final GameRules.Key<DoubleRule> fallen_soul_axe = register("mana.fallen_soul_axe", GameRules.Category.MISC, GameRuleFactory.createDoubleRule(30));
    public static final GameRules.Key<DoubleRule> naeus_sword = register("mana.naeus_sword", GameRules.Category.MISC, GameRuleFactory.createDoubleRule(15));
    public static final GameRules.Key<DoubleRule> nether_spear = register("mana.nether_spear", GameRules.Category.MISC, GameRuleFactory.createDoubleRule(30));
    public static final GameRules.Key<DoubleRule> rain_sword = register("mana.rain_sword", GameRules.Category.MISC, GameRuleFactory.createDoubleRule(30));
    public static final GameRules.Key<DoubleRule> seizing_shadow_halberd = register("mana.seizing_shadow_halberd", GameRules.Category.MISC, GameRuleFactory.createDoubleRule(50));
    public static final GameRules.Key<DoubleRule> zecanirn_the_blade = register("mana.zecanirn_the_blade", GameRules.Category.MISC, GameRuleFactory.createDoubleRule(35));
    public static final GameRules.Key<DoubleRule> herobrine_diamond_pickaxe = register("mana.herobrine_diamond_pickaxe", GameRules.Category.MISC, GameRuleFactory.createDoubleRule(5));
    public static final GameRules.Key<DoubleRule> intelligence_tomahawk = register("mana.intelligence_tomahawk", GameRules.Category.MISC, GameRuleFactory.createDoubleRule(20));
    public static final GameRules.Key<DoubleRule> divine_core = register("mana.divine_core", GameRules.Category.MISC, GameRuleFactory.createDoubleRule(5));
    public static final GameRules.Key<DoubleRule> nether_nuclear_reactor = register("mana.nether_nuclear_reactor", GameRules.Category.MISC, GameRuleFactory.createDoubleRule(5));
    public static final GameRules.Key<DoubleRule> soul_totem = register("mana.soul_totem", GameRules.Category.MISC, GameRuleFactory.createDoubleRule(5));
    public static final GameRules.Key<DoubleRule> under_flower = register("mana.under_flower", GameRules.Category.MISC, GameRuleFactory.createDoubleRule(5));
    public static final GameRules.Key<DoubleRule> wings_of_salvation_second = register("mana.wings_of_salvation_second", GameRules.Category.MISC, GameRuleFactory.createDoubleRule(10));
    public static final GameRules.Key<DoubleRule> wings_of_salvation_boost = register("mana.wings_of_salvation_boost", GameRules.Category.MISC, GameRuleFactory.createDoubleRule(25));

    public static void init() {
    }

    private static <T extends GameRules.Rule<T>> GameRules.Key<T> register(String name, GameRules.Category category, GameRules.Type<T> rule) {
        return GameRuleRegistry.register(RainimatorMod.MOD_ID + ":" + name, category, rule);
    }
}
