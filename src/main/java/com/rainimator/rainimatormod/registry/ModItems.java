package com.rainimator.rainimatormod.registry;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.item.*;
import com.rainimator.rainimatormod.item.armor.*;
import com.rainimator.rainimatormod.item.shield.BlueDiamondShieldItem;
import com.rainimator.rainimatormod.item.shield.NetheriteShieldItem;
import com.rainimator.rainimatormod.item.shield.SnowShieldItem;
import com.rainimator.rainimatormod.item.sword.*;
import com.rainimator.rainimatormod.item.tool.*;
import com.rainimator.rainimatormod.registry.util.*;
import com.rainimator.rainimatormod.util.Episode;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Direction;

import java.util.function.Supplier;

public class ModItems {
    //resources
    public static final Item SUPER_RUBY = register("super_ruby", new ItemBase(Item.Settings::fireproof));
    public static final Item ABIGAIL_SPEAR = register("abigail_spear", AbigailSpearItem::new);
    public static final Item GLUTTON_SLEDGEHAMMER = register("glutton_sledge_hammer", new SwordItem(ToolMaterialBase.of(1000, 2.0F, 8.0F, 0, 15, SUPER_RUBY), 3, -2.2F, new Item.Settings().fireproof()));
    public static final Item RUBY = register("ruby", new ItemBase(p -> p));
    public static final Item RED_GOLD_DAGGER = register("red_gold_dagger", RedGoldDaggerItem::new);
    public static final Item BLACKBONE_THE_BLADE = register("blackbone_the_blade", BlackBoneTheBladeItem::new);
    public static final Item BLACKBONE_THE_BLADE_SINGLE_HAND = register("blackbone_the_blade_single_hand", BlackBoneTheBladeSingleHandItem::new);
    public static final Item RUBY_ORE = block("ruby_ore", ModBlocks.RUBY_ORE);
    public static final Item DEEPSLATE_RUBY_ORE = block("deepslate_ruby_ore", ModBlocks.DEEPSLATE_RUBY_ORE);
    public static final Item RUBY_BLOCK = block("ruby_block", ModBlocks.RUBY_BLOCK);
    public static final Item RAW_RUBY = register("raw_ruby", new ItemBase(p -> p.maxCount(32)));
    public static final Item SUPER_SAPPHIRE = register("super_sapphire", new ItemBase(Item.Settings::fireproof));
    public static final Item PATRICK_HELMET = register("patrick_helmet", PatrickArmorItem.Helmet::new);
    public static final Item PATRICK_CHESTPLATE = register("patrick_chestplate", PatrickArmorItem.Chestplate::new);
    public static final Item PATRICK_LEGGINGS = register("patrick_leggings", PatrickArmorItem.Leggings::new);
    public static final Item PATRICK_BOOTS = register("patrick_boots", PatrickArmorItem.Boots::new);
    public static final Item RAIN_SWORD = register("rain_sword", RainSwordItem::new);
    public static final Item HEROBRINE_TOMAHAWK = register("herobrine_tomahawk", HerobrineTomahawkItem::new);
    public static final Item ZECANIRN_THE_BLADE = register("zecanirn_the_blade", ZecanirnTheBladeItem::new);
    public static final Item ENDER_BIG_SWORD = register("ender_big_sword", EnderBigSwordItem::new);
    public static final Item LASER_SWORD = register("laser_sword", new FoilSwordItemBase(ToolMaterialBase.of(3000, 4.0F, 13.0F, 1, 18, ModItems.SUPER_SAPPHIRE, Items.ENDER_EYE), 3, -2.4F, new Item.Settings()));
    public static final Item MACE = register("mace", new SwordItem(ToolMaterialBase.of(12000, 4.0F, 10.0F, 0, 10, ModItems.SUPER_SAPPHIRE), 3, -2.6F, new Item.Settings().fireproof()));
    public static final Item SAPPHIRE = register("sapphire", new ItemBase(p -> p));
    public static final Item INTELLIGENCE_TOMAHAWK = register("intelligence_tomahawk", IntelligenceTomahawkItem::new);
    //sword
    public static final Item GENERAL_PATRICK_LONG_KNIVES = register("general_patrick_long_knives", new SwordItem(ToolMaterialBase.of(2500, 4.0F, 7.0F, 0, 5, SAPPHIRE), 3, -2.0F, new Item.Settings().fireproof()));
    public static final Item SOLDIERS_HALBERD = register("soldiers_halberd", new SwordItem(ToolMaterialBase.of(1500, 4.0F, 7.0F, 0, 5, SAPPHIRE), 3, -2.0F, new Item.Settings()));
    public static final Item SOLDIERS_WAR_HAMMER = register("soldiers_war_hammer", new SwordItem(ToolMaterialBase.of(2000, 4.0F, 6.0F, 0, 5, SAPPHIRE), 3, -2.2F, new Item.Settings()));
    public static final Item THE_BLUE_DAGGER = register("the_blue_dagger", new SwordItem(ToolMaterialBase.of(2000, 4.0F, 5.0F, 1, 10, ModItems.SAPPHIRE), 3, -2.0F, new Item.Settings()));
    public static final Item SAPPHIRE_ORE = block("sapphire_ore", ModBlocks.SAPPHIRE_ORE);
    public static final Item DEEPSLATE_SAPPHIRE_ORE = block("deepslate_sapphire_ore", ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
    public static final Item SAPPHIRE_BLOCK = block("sapphire_block", ModBlocks.SAPPHIRE_BLOCK);
    public static final Item RAW_SAPPHIRE = register("raw_sapphire", new ItemBase(p -> p.maxCount(32)));    //armor
    public static final Item HOT_IRON = register("hot_iron", new ItemBase(p -> p));
    public static final Item HOT_GLOVES = register("hot_gloves", HotGlovesItem::new);    public static final Item HEROBRINE_CHESTPLATE = register("herobrine_chestplate", HerobrineArmorItem.Chestplate::new);
    public static final Item BLUE_DIAMOND = register("blue_diamond", BlueDiamondItem::new);
    public static final Item BLUE_DIAMOND_HELMET = register("blue_diamond_helmet", BlueDiamondArmorsItem.Helmet::new);
    public static final Item BLUE_DIAMOND_CHESTPLATE = register("blue_diamond_chestplate", BlueDiamondArmorsItem.Chestplate::new);
    public static final Item BLUE_DIAMOND_LEGGINGS = register("blue_diamond_leggings", BlueDiamondArmorsItem.Leggings::new);
    public static final Item BLUE_DIAMOND_BOOTS = register("blue_diamond_boots", BlueDiamondArmorsItem.Boots::new);
    public static final Item DIAMOND_LANCE = register("diamond_lance", DiamondLanceItem::new);
    public static final Item BLUE_DIAMOND_SWORD = register("blue_diamond_sword", BlueDiamondSwordItem::new);
    public static final Item WINGS_OF_SALVATION = register("wings_of_salvation", WingsOfSalvationItem.Chestplate::new);
    //axe
    public static final Item DIAMOND_HATCHET = register("diamond_hatchet", new AxeItem(ToolMaterialBase.of(1500, 4.0F, 5.0F, 2, 2, BLUE_DIAMOND), 1.0F, -2.0F, new Item.Settings()));
    public static final Item BLUE_DIAMOND_BLOCK = block("blue_diamond_block", ModBlocks.BLUE_DIAMOND_BLOCK);
    public static final Item DARK_OBSIDIAN_BLOCK = block("dark_obsidian_block", ModBlocks.DARK_OBSIDIAN_BLOCK);
    public static final Item ZOMBIE_HEART = register("zombie_heart", ZombieHeartItem::new);
    public static final Item WITHER_BONE = register("wither_bone", new ItemBase(p -> p.maxCount(16).fireproof()));
    public static final Item NETHERITE_WITHER_BONE = register("netherite_wither_bone", new FoilItemBase(p -> p.maxCount(16).fireproof()));
    public static final Item ICE_HEART = register("ice_heart", new FoilItemBase(p -> p.maxCount(1).fireproof().rarity(Rarity.EPIC)));
    public static final Item WARRIOR_HEART = register("warrior_heart", new FoilItemBase(p -> p.maxCount(1).fireproof().rarity(Rarity.EPIC)));
    public static final Item ENDER_HEART = register("ender_heart", new FoilItemBase(p -> p.maxDamage(15).fireproof().rarity(Rarity.EPIC)));
    public static final Item LIGHT_HEART = register("light_heart", new FoilItemBase(p -> p.maxCount(1).fireproof().rarity(Rarity.EPIC)));
    public static final Item DIAMOND_PIECE = register("diamond_piece", new ItemBase(p -> p));
    public static final Item BAO_ZHU = register("bao_zhu", new FoilItemBase(p -> p.maxCount(32).rarity(Rarity.UNCOMMON)));
    public static final Item MYSTIC_ORE = block("mystic_ore", ModBlocks.MYSTIC_ORE);
    public static final Item SOUL_PEOPLE = register("soul_people", new FoilItemBase(p -> p.maxCount(32).rarity(Rarity.UNCOMMON)));
    public static final Item ENDER_STONE = register("ender_stone", new FoilItemBase(p -> p.maxCount(1).fireproof().rarity(Rarity.UNCOMMON)));
    public static final Item NEAUS_SOULS = register("neaus_souls", new FoilItemBase(p -> p.maxCount(32).fireproof().rarity(Rarity.EPIC)));
    public static final Item ICED_HEART = register("iced_heart", new ItemBase(p -> p.maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item CHIEF_OF_THE_PIG_PEOPLE_HELMET = register("chief_of_the_pig_people_helmet", ChiefOfThePigPeopleArmorItem.Helmet::new);
    public static final Item CHIEF_OF_THE_PIG_PEOPLE_CHESTPLATE = register("chief_of_the_pig_people_chestplate", ChiefOfThePigPeopleArmorItem.Chestplate::new);
    public static final Item CHIEF_OF_THE_PIG_PEOPLE_LEGGINGS = register("chief_of_the_pig_people_leggings", ChiefOfThePigPeopleArmorItem.Leggings::new);
    public static final Item CHIEF_OF_THE_PIG_PEOPLE_BOOTS = register("chief_of_the_pig_people_boots", ChiefOfThePigPeopleArmorItem.Boots::new);
    public static final Item SOLDIERS_ARMOR_HELMET = register("soldiers_armor_helmet", SoldiersArmorItem.Helmet::new);
    public static final Item SOLDIERS_ARMOR_CHESTPLATE = register("soldiers_armor_chestplate", SoldiersArmorItem.Chestplate::new);    public static final Item RAIN_CHESTPLATE = register("rain_chestplate", RainArmorItem.Chestplate::new);
    public static final Item SOLDIERS_ARMOR_LEGGINGS = register("soldiers_armor_leggings", SoldiersArmorItem.Leggings::new);
    public static final Item SOLDIERS_ARMOR_BOOTS = register("soldiers_armor_boots", SoldiersArmorItem.Boots::new);
    public static final Item RUBY_HELMET = register("ruby_helmet", RubyArmorItem.Helmet::new);
    public static final Item RUBY_CHESTPLATE = register("ruby_chestplate", RubyArmorItem.Chestplate::new);
    public static final Item RUBY_LEGGINGS = register("ruby_leggings", RubyArmorItem.Leggings::new);
    public static final Item RUBY_BOOTS = register("ruby_boots", RubyArmorItem.Boots::new);
    public static final Item SAPPHIRE_HELMET = register("sapphire_helmet", SapphireArmorItem.Helmet::new);
    public static final Item SAPPHIRE_CHESTPLATE = register("sapphire_chestplate", SapphireArmorItem.Chestplate::new);
    public static final Item SAPPHIRE_LEGGINGS = register("sapphire_leggings", SapphireArmorItem.Leggings::new);
    public static final Item SAPPHIRE_BOOTS = register("sapphire_boots", SapphireArmorItem.Boots::new);
    public static final Item MAGIC_HAT_HELMET = register("magic_hat", MagicHatItem.Helmet::new);
    public static final Item NETHER_THE_CROWN_HELMET = register("nether_the_crown_helmet", NetherTheCrownItem.Helmet::new);
    public static final Item GLUTTON_HELMET = register("glutton_helmet", GluttonArmorItem.Helmet::new);
    public static final Item PIGLIN_KING_CROWN = register("piglin_king_crown", PiglinKingCrownItem.Helmet::new);
    public static final Item KING_NORMAL_CROWN = register("king_normal_crown", KingNormalCrownItem.Helmet::new);
    public static final Item PORKSHIRE_KING_CROWN = register("porkshire_king_crown", PorkshireKingCrownItem.Helmet::new);
    //tool
    public static final Item RUBY_PICKAXE = register("ruby_pickaxe", RubyPickaxeItem::new);
    public static final Item HEROBRINE_DIAMOND_PICKAXE = register("herobrine_diamond_pickaxe", HerobrineDiamondPickaxeItem::new);
    public static final Item SUPER_DIAMOND_APPLE = register("super_diamond_apple", SuperDiamondAppleItem::new);
    public static final Item NAEUS_SWORD = register("naeus_sword", NaeusSwordItem::new);
    public static final Item NETHER_SPEAR = register("nether_spear", NetherSpearItem::new);
    public static final Item NETHERITE_FLAME_SABER = register("netherite_flame_saber", NetheriteFlameSaberItem::new);
    public static final Item NETHERITE_NUCLEAR_REACTOR = register("netherite_nuclear_reactor", NetherNuclearReactorItem::new);
    public static final Item NIGHTMARES = register("nightmares", NightmaresItem::new);
    public static final Item END_STAFF = register("end_staff", EndStaffItem::new);
    public static final Item MAGIC_STARD = register("magic_stard", new ItemBase(p -> p.maxDamage(5)));
    public static final Item LIGHT_SWORD = register("light_sword", new FoilSwordItemBase(ToolMaterialBase.of(200, 0.0F, 5.0F, 0, 25), 3, -2.2F, new Item.Settings().fireproof()));
    public static final Item SHIELD_EVER = register("netherite_shield", NetheriteShieldItem::new);
    public static final Item DIVINE_CORE = register("divine_core", DivineCoreItem::new);
    public static final Item SNOW_SHIELD = register("snow_shield", SnowShieldItem::new);
    public static final Item FALLEN_SOUL_AXE = register("fallen_soul_axe", FallenSoulAxeItem::new);
    public static final Item SEIZING_SHADOW_HALBERD = register("seizing_shadow_halberd", SeizingShadowHalberdItem::new);
    public static final Item ENDER_BOOK = register("ender_book", EnderBookItem::new);
    public static final Item COTTON_CANDY = register("cotton_candy", CottonCandyItem::new);
    public static final Item SAPPHIRE_SWORD = register("sapphire_sword", SapphireSwordItem::new);
    public static final Item RUBY_SWORD = register("ruby_sword", RubySwordItem::new);
    public static final Item SAPPHIRE_AXE = register("sapphire_axe", SapphireAxeItem::new);
    public static final Item RUBY_AXE = register("ruby_axe", RubyAxeItem::new);
    public static final Item SAPPHIRE_PICKAXE = register("sapphire_pickaxe", SapphirePickaxeItem::new);
    public static final Item RUBY_PICKAXE_1 = register("ruby_pickaxe_1", RubyPickaxe1Item::new);
    public static final Item SAPPHIRE_SHOVEL = register("sapphire_shovel", SapphireShovelItem::new);
    public static final Item RUBY_SHOVEL = register("ruby_shovel", RubyShovelItem::new);
    public static final Item SAPPHIRE_HOE = register("sapphire_hoe", SapphireHoeItem::new);
    public static final Item RUBY_HOE = register("ruby_hoe", RubyHoeItem::new);
    public static final Item DIAMOND_APPLE_SUPPER = register("diamond_apple_supper", DiamondAppleSupperItem::new);
    public static final Item ENDER_CURVED_SWORD = register("ender_curved_sword", EnderCurvedSwordItem::new);
    public static final Item UNDER_FLOWER = register("under_flower", UnderFlowerItem::new);
    public static final Item BLUE_DIAMOND_SHIELD = register("blue_diamond_shield", BlueDiamondShieldItem::new);
    public static final Item BLACK_GUN = register("black_gun", BlackGunItem::new);
    public static final Item BLACK_DEATH_SWORD = register("black_death_sword", BlackDeathSwordItem::new);
    public static final Item PURIFICATION = register("purification", PurificationItem::new);
    public static final Item MYSTERIOUS_GIFT_BOX = register("mysterious_gift_box", MysteriousGiftBoxItem::new);
    public static final Item RAIN_LAZYED_SWORD = register("rain_lazyed_sword", new FoilSwordItemBase(ToolMaterialBase.of(1500, 0.0F, 8.0F, 0, 15), 3, -2.0F, new Item.Settings()));
    public static final Item MAGIC_ENDER_PEARL = register("magic_ender_pearl", MagicEnderPearlItem::new);
    public static final Item SOUL_TOTEM = register("soul_totem", SoulTotemItem::new);
    public static final Item KING_ZOMBIE_PIG_MAN_SWORD = register("king_zombie_pig_man_sword", new SwordItem(ToolMaterialBase.of(500, 0.0F, 6.0F, 0, 25, Items.GOLD_INGOT), 3, -2.3F, new Item.Settings()));
    public static final Item EMERALD_BLADE = register("emerald_blade", new SwordItem(ToolMaterialBase.of(1200, 4.0F, 5.0F, 0, 3, Blocks.EMERALD_BLOCK), 3, -2.2F, new Item.Settings().fireproof()));
    public static final Item BLADE_OF_THE_WHIRLWIND = register("blade_of_the_whirlwind", new SwordItem(ToolMaterialBase.of(2500, 4.0F, 6.0F, 0, 2, Blocks.OAK_LEAVES), 3, -2.8F, new Item.Settings()));
    public static final Item SNOW_DIAMOND_SWORD = register("snow_diamond_sword", new SwordItem(ToolMaterialBase.of(3000, 4.0F, 6.0F, 0, 2, Blocks.SNOW_BLOCK), 3, -2.0F, new Item.Settings()));
    public static final Item NETHER_SICKLE = register("nether_sickle", new SwordItem(ToolMaterialBase.of(2000, 4.0F, 3.0F, 1, 2, Blocks.STRIPPED_WARPED_STEM), 3, -2.0F, new Item.Settings()));
    public static final Item THE_GOLDEN_SWORD = register("the_golden_sword", new SwordItem(ToolMaterialBase.of(3000, 4.0F, 6.0F, 1, 5, Blocks.GOLD_BLOCK), 3, -2.0F, new Item.Settings().fireproof()));
    public static final Item DEEP_SICKLE = register("deep_sickle", new SwordItem(ToolMaterialBase.of(1000, 4.0F, 6.0F, 1, 2, Blocks.MOSS_BLOCK), 3, -2.4F, new Item.Settings()));
    public static final Item IRON_DAGGER = register("iron_dagger", new SwordItem(ToolMaterialBase.of(1400, 4.0F, 7.0F, 1, 8, Blocks.IRON_BLOCK.asItem(), Items.IRON_INGOT), 3, -2.0F, new Item.Settings()));
    public static final Item DEEP_WAR_HAMMER = register("deep_war_hammer", new SwordItem(ToolMaterialBase.of(1500, 0.0F, 8.0F, 0, 5), 3, -2.3F, new Item.Settings()));
    public static final Item SKULL_CRUSHER = register("skull_crusher", new SwordItem(ToolMaterialBase.of(1500, 0.0F, 7.0F, 0, 15), 3, -2.2F, new Item.Settings().fireproof()));
    public static final Item IRON_LONG_SPEAR = register("iron_long_spear", new SwordItem(ToolMaterialBase.of(500, 0.0F, 3.0F, 0, 1), 3, -2.2F, new Item.Settings()));
    public static final Item GOLDEN_PLUNDERING_AXE = register("golden_plundering_axe", new SwordItem(ToolMaterialBase.of(1200, 0.0F, 5.0F, 0, 10), 3, -2.2F, new Item.Settings()));
    public static final Item PLUNDERING_THE_GIANT_AXE = register("plundering_the_giant_axe", new SwordItem(ToolMaterialBase.of(1300, 0.0F, 7.0F, 0, 8), 3, -2.2F, new Item.Settings()));
    public static final Item LIGHT_SWORD_EVER = register("light_sword_ever", new SwordItem(ToolMaterialBase.of(1000, 0.0F, 8.0F, 0, 30), 3, -2.0F, new Item.Settings()));
    public static final Item DIAMOND_BIG_SWORD = register("diamond_big_sword", new SwordItem(ToolMaterialBase.of(2000, 0.0F, 9.0F, 0, 15), 3, -2.3F, new Item.Settings()));
    public static final Item SOLDIER_SPEAR = register("soldier_spear", new SwordItem(ToolMaterialBase.of(1000, 0.0F, 5.0F, 0, 10), 3, -2.2F, new Item.Settings()));
    public static final Item SOUL_RAIDING_HAMMER = register("soul_raiding_hammer", new SwordItem(ToolMaterialBase.of(2000, 0.0F, 10.0F, 0, 20), 3, -2.2F, new Item.Settings()));
    public static final Item KATANA = register("katana", new SwordItem(ToolMaterialBase.of(1000, 0.0F, 6.0F, 0, 10), 3, -2.0F, new Item.Settings()));
    public static final Item AMETHYST_WAR_HAMMER = register("amethyst_war_hammer", new SwordItem(ToolMaterialBase.of(1500, 0.0F, 9.0F, 0, 25), 3, -2.0F, new Item.Settings()));
    //spawn egg
    public static final Item HEROBRINE_SPAWN_EGG = register("herobrine_spawn_egg", new SpawnEggBase(Episode.TheStruggle, ModEntities.HEROBRINE, -10092544, -65536, new Item.Settings()));
    public static final Item CERIS_SPAWN_EGG = register("ceris_spawn_egg", new SpawnEggBase(Episode.ColdAsIce, ModEntities.CERIS, -10092442, -65281, new Item.Settings()));
    public static final Item ZOMBIES_SPAWN_EGG = register("zombies_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.ZOMBIES, -16724941, -16751104, new Item.Settings()));
    public static final Item NAEUS_SPAWN_EGG = register("naeus_spawn_egg", new SpawnEggBase(Episode.BeginAgain, ModEntities.NAEUS, -10066330, -3355444, new Item.Settings()));
    public static final Item RAIN_SPAWN_EGG = register("rain_spawn_egg", new SpawnEggBase(Episode.TheStruggle, ModEntities.RAIN, -16777063, -13408513, new Item.Settings()));
    public static final Item ABIGAIL_SPAWN_EGG = register("abigail_spawn_egg", new SpawnEggBase(Episode.BeginAgain, ModEntities.ABIGAIL, -65332, -39169, new Item.Settings()));
    public static final Item PATRICK_SPAWN_EGG = register("patrick_spawn_egg", new SpawnEggBase(Episode.ColdAsIce, ModEntities.PATRICK, -16737895, -13369345, new Item.Settings()));
    public static final Item BLACKBONE_SPAWN_EGG = register("blackbone_spawn_egg", new SpawnEggBase(Episode.WeAreTheDanger, ModEntities.BLACKBONE, -16777216, -10066330, new Item.Settings()));
    public static final Item HOGSWORTH_SPAWN_EGG = register("hogsworth_spawn_egg", new SpawnEggBase(Episode.HardPillToSwallow, ModEntities.HOGSWORTH, -26215, -13108, new Item.Settings()));
    public static final Item CIARA_SPAWN_EGG = register("ciara_spawn_egg", new SpawnEggBase(Episode.Nightmares, ModEntities.CIARA, -52378, -39220, new Item.Settings()));
    public static final Item HILDA_SPAWN_EGG = register("hilda_spawn_egg", new SpawnEggBase(Episode.ColdAsIceRemake, ModEntities.HILDA, -256, -3355444, new Item.Settings()));
    public static final Item SOLDIERS_SPAWN_EGG = register("soldiers_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.SOLDIERS, -1, -1, new Item.Settings()));
    public static final Item WITHERED_SKELETONS_SPAWN_EGG = register("withered_skeletons_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.WITHERED_SKELETONS, -13421773, -10066330, new Item.Settings()));
    public static final Item DARK_SHIELD_SPAWN_EGG = register("dark_shield_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.DARK_SHIELD, -6736897, -16777216, new Item.Settings()));
    public static final Item DARK_ZOMBIE_SPAWN_EGG = register("dark_zombie_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.DARK_ZOMBIE, -16751104, -13369549, new Item.Settings()));
    public static final Item VORDUS_SPAWN_EGG = register("vordus_spawn_egg", new SpawnEggBase(Episode.Goodbye, ModEntities.VORDUS, -13421773, -3355648, new Item.Settings()));
    public static final Item WITHER_SHIELD_SPAWN_EGG = register("wither_shield_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.WITHER_SHIELD, -16777216, -1, new Item.Settings()));
    public static final Item SKELETON_SNOW_SPAWN_EGG = register("skeleton_snow_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.SKELETON_SNOW, -1, -13369345, new Item.Settings()));
    public static final Item ZOMBIES_PIGLIN_KING_SPAWN_EGG = register("zombies_piglin_king_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.ZOMBIE_PIGLIN_KING, -39424, -256, new Item.Settings()));
    public static final Item PIGLIN_KING_ZOMBIES_SPAWN_EGG = register("piglin_king_zombies_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.PIGLIN_KING_ZOMBIES, -26368, -52, new Item.Settings()));
    public static final Item PIGLIN_KING_ZOMBIE_SPAWN_EGG = register("piglin_king_zombie_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.PIGLIN_KING_ZOMBIE, -256, -13108, new Item.Settings()));
    public static final Item PIGLIN_COMMANDER_SPAWN_EGG = register("piglin_commander_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.PIGLIN_COMMANDER, -52, -256, new Item.Settings()));
    public static final Item NAEUS_KING_SPAWN_EGG = register("naeus_king_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.NAEUS_KING, -6737152, -65536, new Item.Settings()));
    public static final Item TUSK_SPAWN_EGG = register("tusk_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.TUSK, -13159, -13108, new Item.Settings()));
    public static final Item BROTS_SPAWN_EGG = register("brots_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.BROTS, -3399168, -9175040, new Item.Settings()));
    public static final Item ZOMBIE_PIGLIN_ART_SPAWN_EGG = register("zombie_piglin_art_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.ZOMBIE_PIGLIN_ART, -1343393, -412045, new Item.Settings()));
    public static final Item MUTATED_SPAWN_EGG = register("mutated_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.MUTATED, -5134336, -16735132, new Item.Settings()));
    public static final Item NAMTAR_SPAWN_EGG = register("namtar_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.NAMTAR, -7274496, -12544, new Item.Settings()));
    public static final Item AGETHA_SPAWN_EGG = register("agetha_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.AGETHA, -6710887, -3381760, new Item.Settings()));
    public static final Item TRICER_SPAWN_EGG = register("tricer_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.TRICER, -3407872, -16777216, new Item.Settings()));
    public static final Item BIG_UNDEAD_SKELETON_SPAWN_EGG = register("big_undead_skeleton_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.BIG_UNDEAD_SKELETON, -10066330, -16777216, new Item.Settings()));
    public static final Item ARCHER_SPAWN_EGG = register("archer_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.ARCHER, -6710887, -16750951, new Item.Settings()));
    public static final Item DARYLL_SPAWN_EGG = register("daryll_spawn_egg", new SpawnEggBase(Episode.ColdAsIce, ModEntities.DARYLL, -6737152, -1, new Item.Settings()));
    public static final Item NULL_LIKE_SPAWN_EGG = register("null_like_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.NULL_LIKE, -1, -16777216, new Item.Settings()));
    public static final Item GIGABONE_SPAWN_EGG = register("gigabone_spawn_egg", new SpawnEggBase(Episode.WeAreTheDanger, ModEntities.GIGABONE, -10066330, -3355393, new Item.Settings()));
    public static final Item KLAUS_SPAWN_EGG = register("klaus_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.KLAUS, -10066432, -16764109, new Item.Settings()));
    public static final Item KLAUS_2_SPAWN_EGG = register("klaus_2_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.KLAUS_2, -6711040, -16751002, new Item.Settings()));
    public static final Item KRALOS_SPAWN_EGG = register("kralos_spawn_egg", new SpawnEggBase(Episode.None, ModEntities.KRALOS, -16777165, -6750157, new Item.Settings()));
    public static final Item ARABELLA_SPAWN_EGG = register("arabella_spawn_egg", new SpawnEggBase(Episode.ToTheVoid, ModEntities.ARABELLA, -3407668, -13369345, new Item.Settings()));
    public static final Item AZALEA_SPAWN_EGG = register("azalea_spawn_egg", new SpawnEggBase(Episode.PreachToTheChoir, ModEntities.AZALEA, -256, -16738048, new Item.Settings()));
    //music
    public static final Item HIM_MUSIC = register("him_music", new MusicItemBase("him_music_boss"));
    public static final Item CERIS_MUSIC = register("ceris_music", new MusicItemBase("ceris_boss_music"));
    public static final Item NULL_MUSIC = register("null_music", new MusicItemBase("null_boss_music"));
    public static final Item BLACKBONE_MUSIC = register("blackbone_music", new MusicItemBase("blackbone_boss_music"));
    public static final Item PIGLIN_KING_MUSIC = register("piglin_king_music", new MusicItemBase("piglin_king_boss_music"));
    public static final Item NAEUS_MUSIC = register("naeus_music", new MusicItemBase("naeus_boss_music"));
    public static final Item GLUTTON_MUSIC = register("glutton_music", new MusicItemBase("glutton_boss_music"));
    public static final Item HIM_ONE_LIVES = register("him_one_lives", new MusicItemBase("him_one_lives"));
    public static final Item KRALOS_MUSIC = register("kralos_music", new MusicItemBase("kralos_boss_music"));
    public static final Item KLAUS_MUSIC = register("klaus_music", new MusicItemBase("klaus_boss_music"));

    private static Item register(String name, Supplier<Item> provider) {
        return register(name, provider.get());
    }

    private static Item register(String name, Item obj) {
        Registry.register(Registries.ITEM, new Identifier(RainimatorMod.MOD_ID, name), obj);
        return obj;
    }

    private static Item block(String registerName, Block block) {
        return register(registerName, new BlockItem(block, new Item.Settings()));
    }

    private static Item skull(String registerName, Block block1, Block block2) {
        return register(registerName, new VerticallyAttachableBlockItem(block1, block2, new Item.Settings().rarity(Rarity.UNCOMMON), Direction.UP));
    }

    public static void init() {
        FuelRegistry.INSTANCE.add(ModItems.HOT_IRON, 2000);
    }
}