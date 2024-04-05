package com.rainimator.rainimatormod.registry.util;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.registry.ModBanners;
import com.rainimator.rainimatormod.registry.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModCreativeTab {
    public static final ItemGroup main = FabricItemGroup.builder().entries(((displayContext, entries) -> {
        entries.add(ModItems.RUBY_HELMET);
        entries.add(ModItems.RUBY_CHESTPLATE);
        entries.add(ModItems.RUBY_LEGGINGS);
        entries.add(ModItems.RUBY_BOOTS);
        entries.add(ModItems.SAPPHIRE_HELMET);
        entries.add(ModItems.SAPPHIRE_CHESTPLATE);
        entries.add(ModItems.SAPPHIRE_LEGGINGS);
        entries.add(ModItems.SAPPHIRE_BOOTS);
        entries.add(ModItems.CHIEF_OF_THE_PIG_PEOPLE_HELMET);
        entries.add(ModItems.CHIEF_OF_THE_PIG_PEOPLE_CHESTPLATE);
        entries.add(ModItems.CHIEF_OF_THE_PIG_PEOPLE_LEGGINGS);
        entries.add(ModItems.CHIEF_OF_THE_PIG_PEOPLE_BOOTS);
        entries.add(ModItems.SOLDIERS_ARMOR_HELMET);
        entries.add(ModItems.SOLDIERS_ARMOR_CHESTPLATE);
        entries.add(ModItems.SOLDIERS_ARMOR_LEGGINGS);
        entries.add(ModItems.SOLDIERS_ARMOR_BOOTS);
        entries.add(ModItems.PATRICK_HELMET);
        entries.add(ModItems.PATRICK_CHESTPLATE);
        entries.add(ModItems.PATRICK_LEGGINGS);
        entries.add(ModItems.PATRICK_BOOTS);
        entries.add(ModItems.BLUE_DIAMOND_HELMET);
        entries.add(ModItems.BLUE_DIAMOND_CHESTPLATE);
        entries.add(ModItems.BLUE_DIAMOND_LEGGINGS);
        entries.add(ModItems.BLUE_DIAMOND_BOOTS);
        entries.add(ModItems.ABIGAIL_SPEAR);
        entries.add(ModItems.GLUTTON_SLEDGEHAMMER);
        entries.add(ModItems.RED_GOLD_DAGGER);
        entries.add(ModItems.BLACKBONE_THE_BLADE);
        entries.add(ModItems.BLACKBONE_THE_BLADE_SINGLE_HAND);
        entries.add(ModItems.RAIN_SWORD);
        entries.add(ModItems.HEROBRINE_TOMAHAWK);
        entries.add(ModItems.ZECANIRN_THE_BLADE);
        entries.add(ModItems.ENDER_BIG_SWORD);
        entries.add(ModItems.LASER_SWORD);
        entries.add(ModItems.MACE);
        entries.add(ModItems.INTELLIGENCE_TOMAHAWK);
        entries.add(ModItems.GENERAL_PATRICK_LONG_KNIVES);
        entries.add(ModItems.SOLDIERS_HALBERD);
        entries.add(ModItems.SOLDIERS_WAR_HAMMER);
        entries.add(ModItems.THE_BLUE_DAGGER);
        entries.add(ModItems.HOT_GLOVES);
        entries.add(ModItems.DIAMOND_LANCE);
        entries.add(ModItems.BLUE_DIAMOND_SWORD);
        entries.add(ModItems.WINGS_OF_SALVATION);
        entries.add(ModItems.DIAMOND_HATCHET);
        entries.add(ModItems.MAGIC_HAT_HELMET);
        entries.add(ModItems.NETHER_THE_CROWN_HELMET);
        entries.add(ModItems.GLUTTON_HELMET);
        entries.add(ModItems.PIGLIN_KING_CROWN);
        entries.add(ModItems.KING_NORMAL_CROWN);
        entries.add(ModItems.PORKSHIRE_KING_CROWN);
        entries.add(ModItems.HEROBRINE_DIAMOND_PICKAXE);
        entries.add(ModItems.NAEUS_SWORD);
        entries.add(ModItems.NETHER_SPEAR);
        entries.add(ModItems.NETHERITE_FLAME_SABER);
        entries.add(ModItems.END_STAFF);
        entries.add(ModItems.LIGHT_SWORD);
        entries.add(ModItems.SHIELD_EVER);
        entries.add(ModItems.SNOW_SHIELD);
        entries.add(ModItems.FALLEN_SOUL_AXE);
        entries.add(ModItems.SEIZING_SHADOW_HALBERD);
        entries.add(ModItems.SAPPHIRE_SWORD);
        entries.add(ModItems.RUBY_SWORD);
        entries.add(ModItems.SAPPHIRE_AXE);
        entries.add(ModItems.RUBY_AXE);
        entries.add(ModItems.SAPPHIRE_PICKAXE);
        entries.add(ModItems.RUBY_PICKAXE_1);
        entries.add(ModItems.SAPPHIRE_SHOVEL);
        entries.add(ModItems.RUBY_SHOVEL);
        entries.add(ModItems.SAPPHIRE_HOE);
        entries.add(ModItems.RUBY_HOE);
        entries.add(ModItems.ENDER_CURVED_SWORD);
        entries.add(ModItems.BLUE_DIAMOND_SHIELD);
        entries.add(ModItems.BLACK_GUN);
        entries.add(ModItems.BLACK_DEATH_SWORD);
        entries.add(ModItems.RAIN_LAZYED_SWORD);
        entries.add(ModItems.KING_ZOMBIE_PIG_MAN_SWORD);
        entries.add(ModItems.EMERALD_BLADE);
        entries.add(ModItems.BLADE_OF_THE_WHIRLWIND);
        entries.add(ModItems.SNOW_DIAMOND_SWORD);
        entries.add(ModItems.NETHER_SICKLE);
        entries.add(ModItems.THE_GOLDEN_SWORD);
        entries.add(ModItems.DEEP_SICKLE);
        entries.add(ModItems.IRON_DAGGER);
        entries.add(ModItems.DEEP_WAR_HAMMER);
        entries.add(ModItems.SKULL_CRUSHER);
        entries.add(ModItems.IRON_LONG_SPEAR);
        entries.add(ModItems.GOLDEN_PLUNDERING_AXE);
        entries.add(ModItems.PLUNDERING_THE_GIANT_AXE);
        entries.add(ModItems.LIGHT_SWORD_EVER);
        entries.add(ModItems.DIAMOND_BIG_SWORD);
        entries.add(ModItems.SOLDIER_SPEAR);
        entries.add(ModItems.SOUL_RAIDING_HAMMER);
        entries.add(ModItems.KATANA);
        entries.add(ModItems.AMETHYST_WAR_HAMMER);
    })).displayName(Text.translatable("itemGroup." + RainimatorMod.MOD_ID + ".rainimator")).icon(() -> new ItemStack(ModItems.WARRIOR_HEART)).build();
    public static final ItemGroup mobs = FabricItemGroup.builder().entries(((displayContext, entries) -> {
        entries.add(ModItems.HEROBRINE_SPAWN_EGG);
        entries.add(ModItems.CERIS_SPAWN_EGG);
        entries.add(ModItems.ZOMBIES_SPAWN_EGG);
        entries.add(ModItems.NAEUS_SPAWN_EGG);
        entries.add(ModItems.RAIN_SPAWN_EGG);
        entries.add(ModItems.ABIGAIL_SPAWN_EGG);
        entries.add(ModItems.PATRICK_SPAWN_EGG);
        entries.add(ModItems.BLACKBONE_SPAWN_EGG);
        entries.add(ModItems.HOGSWORTH_SPAWN_EGG);
        entries.add(ModItems.CIARA_SPAWN_EGG);
        entries.add(ModItems.HILDA_SPAWN_EGG);
        entries.add(ModItems.SOLDIERS_SPAWN_EGG);
        entries.add(ModItems.WITHERED_SKELETONS_SPAWN_EGG);
        entries.add(ModItems.DARK_SHIELD_SPAWN_EGG);
        entries.add(ModItems.DARK_ZOMBIE_SPAWN_EGG);
        entries.add(ModItems.VORDUS_SPAWN_EGG);
        entries.add(ModItems.WITHER_SHIELD_SPAWN_EGG);
        entries.add(ModItems.SKELETON_SNOW_SPAWN_EGG);
        entries.add(ModItems.ZOMBIES_PIGLIN_KING_SPAWN_EGG);
        entries.add(ModItems.PIGLIN_KING_ZOMBIES_SPAWN_EGG);
        entries.add(ModItems.PIGLIN_KING_ZOMBIE_SPAWN_EGG);
        entries.add(ModItems.PIGLIN_COMMANDER_SPAWN_EGG);
        entries.add(ModItems.NAEUS_KING_SPAWN_EGG);
        entries.add(ModItems.TUSK_SPAWN_EGG);
        entries.add(ModItems.BROTS_SPAWN_EGG);
        entries.add(ModItems.ZOMBIE_PIGLIN_ART_SPAWN_EGG);
        entries.add(ModItems.MUTATED_SPAWN_EGG);
        entries.add(ModItems.NAMTAR_SPAWN_EGG);
        entries.add(ModItems.AGETHA_SPAWN_EGG);
        entries.add(ModItems.TRICER_SPAWN_EGG);
        entries.add(ModItems.BIG_UNDEAD_SKELETON_SPAWN_EGG);
        entries.add(ModItems.ARCHER_SPAWN_EGG);
        entries.add(ModItems.DARYLL_SPAWN_EGG);
        entries.add(ModItems.NULL_LIKE_SPAWN_EGG);
        entries.add(ModItems.GIGABONE_SPAWN_EGG);
        entries.add(ModItems.KLAUS_SPAWN_EGG);
        entries.add(ModItems.KLAUS_2_SPAWN_EGG);
        entries.add(ModItems.KRALOS_SPAWN_EGG);
        entries.add(ModItems.ARABELLA_SPAWN_EGG);
        entries.add(ModItems.AZALEA_SPAWN_EGG);
    })).displayName(Text.translatable("itemGroup." + RainimatorMod.MOD_ID + ".rainimator_mobs")).icon(() -> new ItemStack(ModItems.ICE_HEART)).build();
    public static final ItemGroup item = FabricItemGroup.builder().entries(((displayContext, entries) -> {
        entries.add(ModItems.RUBY_ORE);
        entries.add(ModItems.DEEPSLATE_RUBY_ORE);
        entries.add(ModItems.RAW_RUBY);
        entries.add(ModItems.RUBY);
        entries.add(ModItems.RUBY_BLOCK);
        entries.add(ModItems.SUPER_RUBY);
        entries.add(ModItems.SAPPHIRE_ORE);
        entries.add(ModItems.DEEPSLATE_SAPPHIRE_ORE);
        entries.add(ModItems.RAW_SAPPHIRE);
        entries.add(ModItems.SAPPHIRE_BLOCK);
        entries.add(ModItems.SAPPHIRE);
        entries.add(ModItems.SUPER_SAPPHIRE);
        entries.add(ModItems.HOT_IRON);
        entries.add(ModItems.BLUE_DIAMOND);
        entries.add(ModItems.BLUE_DIAMOND_BLOCK);
        entries.add(ModItems.DARK_OBSIDIAN_BLOCK);
        entries.add(ModItems.ZOMBIE_HEART);
        entries.add(ModItems.WITHER_BONE);
        entries.add(ModItems.NETHERITE_WITHER_BONE);
        entries.add(ModItems.ICE_HEART);
        entries.add(ModItems.WARRIOR_HEART);
        entries.add(ModItems.ENDER_HEART);
        entries.add(ModItems.LIGHT_HEART);
        entries.add(ModItems.DIAMOND_PIECE);
        entries.add(ModItems.BAO_ZHU);
        entries.add(ModItems.MYSTIC_ORE);
        entries.add(ModItems.SOUL_PEOPLE);
        entries.add(ModItems.ENDER_STONE);
        entries.add(ModItems.NEAUS_SOULS);
        entries.add(ModItems.ICED_HEART);
        entries.add(ModItems.RUBY_PICKAXE);
        entries.add(ModItems.SUPER_DIAMOND_APPLE);
        entries.add(ModItems.NETHERITE_NUCLEAR_REACTOR);
        entries.add(ModItems.NIGHTMARES);
        entries.add(ModItems.MAGIC_STARD);
        entries.add(ModItems.DIVINE_CORE);
        entries.add(ModItems.ENDER_BOOK);
        entries.add(ModItems.COTTON_CANDY);
        entries.add(ModItems.DIAMOND_APPLE_SUPPER);
        entries.add(ModItems.UNDER_FLOWER);
        entries.add(ModItems.PURIFICATION);
        entries.add(ModItems.MYSTERIOUS_GIFT_BOX);
        entries.add(ModItems.MAGIC_ENDER_PEARL);
        entries.add(ModItems.SOUL_TOTEM);
        entries.add(ModItems.HIM_MUSIC);
        entries.add(ModItems.CERIS_MUSIC);
        entries.add(ModItems.NULL_MUSIC);
        entries.add(ModItems.BLACKBONE_MUSIC);
        entries.add(ModItems.PIGLIN_KING_MUSIC);
        entries.add(ModItems.NAEUS_MUSIC);
        entries.add(ModItems.GLUTTON_MUSIC);
        entries.add(ModItems.HIM_ONE_LIVES);
        entries.add(ModItems.KRALOS_MUSIC);
        entries.add(ModItems.KLAUS_MUSIC);

        entries.add(ModBanners.FROST);
        entries.add(ModBanners.UNDEAD);
        entries.add(ModBanners.NETHER);
        entries.add(ModBanners.ENDER_WATCHER);
    })).displayName(Text.translatable("itemGroup." + RainimatorMod.MOD_ID + ".rainimator_item")).icon(() -> new ItemStack(ModItems.ENDER_HEART)).build();

    public static void load() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(RainimatorMod.MOD_ID, "main"), main);
        Registry.register(Registries.ITEM_GROUP, new Identifier(RainimatorMod.MOD_ID, "mobs"), mobs);
        Registry.register(Registries.ITEM_GROUP, new Identifier(RainimatorMod.MOD_ID, "item"), item);
    }
}
