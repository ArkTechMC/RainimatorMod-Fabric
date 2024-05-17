package dev.rainimator.mod.registry;

import com.iafenvoy.annotationlib.annotation.CallbackHandler;
import com.iafenvoy.annotationlib.annotation.ModId;
import com.iafenvoy.annotationlib.annotation.TargetId;
import com.iafenvoy.annotationlib.annotation.registration.Group;
import com.iafenvoy.annotationlib.annotation.registration.ItemReg;
import com.iafenvoy.annotationlib.annotation.registration.Link;
import com.iafenvoy.annotationlib.api.IAnnotatedRegistryEntry;
import com.iafenvoy.annotationlib.util.TargetType;
import com.iafenvoy.mcrconvertlib.item.FoilItemBase;
import com.iafenvoy.mcrconvertlib.item.FoilSwordItemBase;
import com.iafenvoy.mcrconvertlib.item.ItemBase;
import com.iafenvoy.mcrconvertlib.item.ToolMaterialUtil;
import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.item.*;
import dev.rainimator.mod.item.armor.*;
import dev.rainimator.mod.item.shield.BlueDiamondShieldItem;
import dev.rainimator.mod.item.shield.NetheriteShieldItem;
import dev.rainimator.mod.item.shield.SnowShieldItem;
import dev.rainimator.mod.item.sword.*;
import dev.rainimator.mod.item.tool.*;
import dev.rainimator.mod.item.trinket.NetherTheCrownItem;
import dev.rainimator.mod.item.trinket.WingsOfSalvationItem;
import dev.rainimator.mod.registry.util.MusicItemBase;
import dev.rainimator.mod.registry.util.SpawnEggBase;
import dev.rainimator.mod.util.Episode;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;

@ModId(RainimatorMod.MOD_ID)
@SuppressWarnings("unused")
public class ModItems implements IAnnotatedRegistryEntry {
    //resources
    @ItemReg(group = @TargetId("item"))
    public static final Item SUPER_RUBY = new ItemBase(Item.Settings::fireproof);
    @ItemReg(group = @TargetId("main"))
    public static final Item ABIGAIL_SPEAR = new AbigailSpearItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item GLUTTON_SLEDGE_HAMMER = new SwordItem(ToolMaterialUtil.of(1000, 2.0F, 8.0F, 0, 15, SUPER_RUBY), 3, -2.2F, new Item.Settings().fireproof());
    @ItemReg(group = @TargetId("item"))
    public static final Item RUBY = new ItemBase(p -> p);
    @ItemReg(group = @TargetId("item"))
    public static final Item TOPAZ = new ItemBase(p -> p);
    @ItemReg(group = @TargetId("item"))
    public static final Item SUGILITE = new ItemBase(p -> p);
    @ItemReg(group = @TargetId("main"))
    public static final Item RED_GOLD_DAGGER = new RedGoldDaggerItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item BLACKBONE_THE_BLADE = new BlackBoneTheBladeItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item BLACKBONE_THE_BLADE_SINGLE_HAND = new BlackBoneTheBladeSingleHandItem();
    @Group(@TargetId("item"))
    @Link(type = TargetType.BLOCK, target = @TargetId("ruby_ore"))
    public static Item RUBY_ORE = null;
    @Group(@TargetId("item"))
    @Link(type = TargetType.BLOCK, target = @TargetId("deepslate_ruby_ore"))
    public static Item DEEPSLATE_RUBY_ORE = null;
    @Group(@TargetId("item"))
    @Link(type = TargetType.BLOCK, target = @TargetId("ruby_block"))
    public static Item RUBY_BLOCK = null;
    @ItemReg(group = @TargetId("item"))
    public static final Item RAW_RUBY = new ItemBase(p -> p);
    @ItemReg(group = @TargetId("item"))
    public static final Item RAW_SUGILITE = new ItemBase(p -> p);
    @ItemReg(group = @TargetId("item"))
    public static final Item RAW_TOPAZ = new ItemBase(p -> p);
    @ItemReg(group = @TargetId("item"))
    public static final Item SUPER_SAPPHIRE = new ItemBase(Item.Settings::fireproof);
    @ItemReg(group = @TargetId("item"))
    public static final Item SUPER_SUGILITE = new ItemBase(Item.Settings::fireproof);
    @ItemReg(group = @TargetId("item"))
    public static final Item SUPER_TOPAZ = new ItemBase(Item.Settings::fireproof);
    @Group(@TargetId("item"))
    @Link(type = TargetType.BLOCK, target = @TargetId("topaz_ore"))
    public static Item TOPAZ_ORE = null;
    @Group(@TargetId("item"))
    @Link(type = TargetType.BLOCK, target = @TargetId("sugilite_ore"))
    public static Item SUGILITE_ORE = null;
    @Group(@TargetId("item"))
    @Link(type = TargetType.BLOCK, target = @TargetId("topaz_block"))
    public static Item TOPAZ_BLOCK = null;
    @Group(@TargetId("item"))
    @Link(type = TargetType.BLOCK, target = @TargetId("sugilite_block"))
    public static Item SUGILITE_BLOCK = null;
    @ItemReg(group = @TargetId("main"))
    public static final Item PATRICK_HELMET = new PatrickArmorItem(ArmorItem.Type.HELMET);
    @ItemReg(group = @TargetId("main"))
    public static final Item PATRICK_CHESTPLATE = new PatrickArmorItem(ArmorItem.Type.CHESTPLATE);
    @ItemReg(group = @TargetId("main"))
    public static final Item PATRICK_LEGGINGS = new PatrickArmorItem(ArmorItem.Type.LEGGINGS);
    @ItemReg(group = @TargetId("main"))
    public static final Item PATRICK_BOOTS = new PatrickArmorItem(ArmorItem.Type.BOOTS);
    @ItemReg(group = @TargetId("main"))
    public static final Item RAIN_SWORD = new RainSwordItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item HEROBRINE_TOMAHAWK = new HerobrineTomahawkItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item ZECANIRN_THE_BLADE = new ZecanirnTheBladeItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item ENDER_BIG_SWORD = new EnderBigSwordItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item LASER_SWORD = new FoilSwordItemBase(ToolMaterialUtil.of(3000, 4.0F, 13.0F, 1, 18, ModItems.SUPER_SAPPHIRE, Items.ENDER_EYE), 3, -2.4F, new Item.Settings());
    @ItemReg(group = @TargetId("main"))
    public static final Item MACE = new SwordItem(ToolMaterialUtil.of(12000, 4.0F, 10.0F, 0, 10, ModItems.SUPER_SAPPHIRE), 3, -2.6F, new Item.Settings().fireproof());
    @ItemReg(group = @TargetId("item"))
    public static final Item SAPPHIRE = new ItemBase(p -> p);
    @ItemReg(group = @TargetId("main"))
    public static final Item INTELLIGENCE_TOMAHAWK = new IntelligenceTomahawkItem();
    //sword
    @ItemReg(group = @TargetId("main"))
    public static final Item GENERAL_PATRICK_LONG_KNIVES = new SwordItem(ToolMaterialUtil.of(2500, 4.0F, 7.0F, 0, 5, SAPPHIRE), 3, -2.0F, new Item.Settings().fireproof());
    @ItemReg(group = @TargetId("main"))
    public static final Item SOLDIERS_HALBERD = new SwordItem(ToolMaterialUtil.of(1500, 4.0F, 7.0F, 0, 5, SAPPHIRE), 3, -2.0F, new Item.Settings());
    @ItemReg(group = @TargetId("main"))
    public static final Item SOLDIERS_WAR_HAMMER = new SwordItem(ToolMaterialUtil.of(2000, 4.0F, 6.0F, 0, 5, SAPPHIRE), 3, -2.2F, new Item.Settings());
    @ItemReg(group = @TargetId("main"))
    public static final Item THE_BLUE_DAGGER = new SwordItem(ToolMaterialUtil.of(2000, 4.0F, 5.0F, 1, 10, ModItems.SAPPHIRE), 3, -2.0F, new Item.Settings());
    @Group(@TargetId("item"))
    @Link(type = TargetType.BLOCK, target = @TargetId("sapphire_ore"))
    public static Item SAPPHIRE_ORE = null;
    @Group(@TargetId("item"))
    @Link(type = TargetType.BLOCK, target = @TargetId("deepslate_sapphire_ore"))
    public static Item DEEPSLATE_SAPPHIRE_ORE = null;
    @Group(@TargetId("item"))
    @Link(type = TargetType.BLOCK, target = @TargetId("sapphire_block"))
    public static Item SAPPHIRE_BLOCK = null;
    @ItemReg(group = @TargetId("item"))
    public static final Item RAW_SAPPHIRE = new ItemBase(p -> p);
    //armor
    @ItemReg(group = @TargetId("item"))
    public static final Item HOT_IRON = new ItemBase(p -> p);
    @ItemReg(group = @TargetId("main"))
    public static final Item HOT_GLOVES = new HotGlovesItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item HEROBRINE_CHESTPLATE = new HerobrineArmorItem(ArmorItem.Type.CHESTPLATE);
    @ItemReg(group = @TargetId("item"))
    public static final Item BLUE_DIAMOND = new BlueDiamondItem();
    @ItemReg(group = @TargetId("item"))
    public static final Item BLUE_DIAMOND_HELMET = new BlueDiamondArmorsItem(ArmorItem.Type.HELMET);
    @ItemReg(group = @TargetId("item"))
    public static final Item BLUE_DIAMOND_CHESTPLATE = new BlueDiamondArmorsItem(ArmorItem.Type.CHESTPLATE);
    @ItemReg(group = @TargetId("item"))
    public static final Item BLUE_DIAMOND_LEGGINGS = new BlueDiamondArmorsItem(ArmorItem.Type.LEGGINGS);
    @ItemReg(group = @TargetId("item"))
    public static final Item BLUE_DIAMOND_BOOTS = new BlueDiamondArmorsItem(ArmorItem.Type.BOOTS);
    @ItemReg(group = @TargetId("main"))
    public static final Item DIAMOND_LANCE = new DiamondLanceItem();
    @ItemReg(group = @TargetId("item"))
    public static final Item BLUE_DIAMOND_SWORD = new BlueDiamondSwordItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item WINGS_OF_SALVATION = WingsOfSalvationItem.create();
    //axe
    @ItemReg(group = @TargetId("main"))
    public static final Item DIAMOND_HATCHET = new AxeItem(ToolMaterialUtil.of(1500, 4.0F, 5.0F, 2, 2, BLUE_DIAMOND), 1.0F, -2.0F, new Item.Settings());
    @Group(@TargetId("item"))
    @Link(type = TargetType.BLOCK, target = @TargetId("blue_diamond_block"))
    public static Item BLUE_DIAMOND_BLOCK = null;
    @Group(@TargetId("item"))
    @Link(type = TargetType.BLOCK, target = @TargetId("dark_obsidian_block"))
    public static Item DARK_OBSIDIAN_BLOCK = null;
    @ItemReg(group = @TargetId("item"))
    public static final Item ZOMBIE_HEART = new ZombieHeartItem();
    @ItemReg(group = @TargetId("item"))
    public static final Item WITHER_BONE = new ItemBase(p -> p.maxCount(16).fireproof());
    @ItemReg(group = @TargetId("item"))
    public static final Item NETHERITE_WITHER_BONE = new FoilItemBase(p -> p.maxCount(16).fireproof());
    @ItemReg(group = @TargetId("item"))
    public static final Item ICE_HEART = new FoilItemBase(p -> p.maxCount(1).fireproof().rarity(Rarity.EPIC));
    @ItemReg(group = @TargetId("item"))
    public static final Item WARRIOR_HEART = new FoilItemBase(p -> p.maxCount(1).fireproof().rarity(Rarity.EPIC));
    @ItemReg(group = @TargetId("item"))
    public static final Item ENDER_HEART = new FoilItemBase(p -> p.maxCount(1).fireproof().rarity(Rarity.EPIC));
    @ItemReg(group = @TargetId("item"))
    public static final Item LIGHT_HEART = new FoilItemBase(p -> p.maxCount(1).fireproof().rarity(Rarity.EPIC));
    @ItemReg(group = @TargetId("item"))
    public static final Item DIAMOND_PIECE = new ItemBase(p -> p);
    @ItemReg(group = @TargetId("item"))
    public static final Item BAO_ZHU = new FoilItemBase(p -> p.maxCount(32).rarity(Rarity.UNCOMMON));
    @Group(@TargetId("item"))
    @Link(type = TargetType.BLOCK, target = @TargetId("mystic_ore"))
    public static Item MYSTIC_ORE = null;
    @ItemReg(group = @TargetId("item"))
    public static final Item SOUL_PEOPLE = new FoilItemBase(p -> p.maxCount(32).rarity(Rarity.UNCOMMON));
    @ItemReg(group = @TargetId("item"))
    public static final Item ENDER_STONE = new FoilItemBase(p -> p.maxCount(1).fireproof().rarity(Rarity.UNCOMMON));
    @ItemReg(group = @TargetId("item"))
    public static final Item NEAUS_SOULS = new FoilItemBase(p -> p.maxCount(32).fireproof().rarity(Rarity.EPIC));
    @ItemReg(group = @TargetId("item"))
    public static final Item ICED_HEART = new ItemBase(p -> p.maxCount(1).rarity(Rarity.UNCOMMON));
    @ItemReg(group = @TargetId("main"))
    public static final Item CHIEF_OF_THE_PIG_PEOPLE_HELMET = new ChiefOfThePigPeopleArmorItem(ArmorItem.Type.HELMET);
    @ItemReg(group = @TargetId("main"))
    public static final Item CHIEF_OF_THE_PIG_PEOPLE_CHESTPLATE = new ChiefOfThePigPeopleArmorItem(ArmorItem.Type.CHESTPLATE);
    @ItemReg(group = @TargetId("main"))
    public static final Item CHIEF_OF_THE_PIG_PEOPLE_LEGGINGS = new ChiefOfThePigPeopleArmorItem(ArmorItem.Type.LEGGINGS);
    @ItemReg(group = @TargetId("main"))
    public static final Item CHIEF_OF_THE_PIG_PEOPLE_BOOTS = new ChiefOfThePigPeopleArmorItem(ArmorItem.Type.BOOTS);
    @ItemReg(group = @TargetId("main"))
    public static final Item SOLDIERS_ARMOR_HELMET = new SoldiersArmorItem(ArmorItem.Type.HELMET);
    @ItemReg(group = @TargetId("main"))
    public static final Item SOLDIERS_ARMOR_CHESTPLATE = new SoldiersArmorItem(ArmorItem.Type.CHESTPLATE);
    @ItemReg(group = @TargetId("main"))
    public static final Item SOLDIERS_ARMOR_LEGGINGS = new SoldiersArmorItem(ArmorItem.Type.LEGGINGS);
    @ItemReg(group = @TargetId("main"))
    public static final Item SOLDIERS_ARMOR_BOOTS = new SoldiersArmorItem(ArmorItem.Type.BOOTS);
    @ItemReg(group = @TargetId("main"))
    public static final Item RAIN_CHESTPLATE = new RainArmorItem(ArmorItem.Type.CHESTPLATE);
    @ItemReg(group = @TargetId("item"))
    public static final Item RUBY_HELMET = new RubyArmorItem(ArmorItem.Type.HELMET);
    @ItemReg(group = @TargetId("item"))
    public static final Item RUBY_CHESTPLATE = new RubyArmorItem(ArmorItem.Type.CHESTPLATE);
    @ItemReg(group = @TargetId("item"))
    public static final Item RUBY_LEGGINGS = new RubyArmorItem(ArmorItem.Type.LEGGINGS);
    @ItemReg(group = @TargetId("item"))
    public static final Item RUBY_BOOTS = new RubyArmorItem(ArmorItem.Type.BOOTS);
    @ItemReg(group = @TargetId("item"))
    public static final Item SAPPHIRE_HELMET = new SapphireArmorItem(ArmorItem.Type.HELMET);
    @ItemReg(group = @TargetId("item"))
    public static final Item SAPPHIRE_CHESTPLATE = new SapphireArmorItem(ArmorItem.Type.CHESTPLATE);
    @ItemReg(group = @TargetId("item"))
    public static final Item SAPPHIRE_LEGGINGS = new SapphireArmorItem(ArmorItem.Type.LEGGINGS);
    @ItemReg(group = @TargetId("item"))
    public static final Item SAPPHIRE_BOOTS = new SapphireArmorItem(ArmorItem.Type.BOOTS);
    @ItemReg(group = @TargetId("item"))
    public static final Item SUGILITE_HELMET = new SugiliteArmorItem(ArmorItem.Type.HELMET);
    @ItemReg(group = @TargetId("item"))
    public static final Item SUGILITE_CHESTPLATE = new SugiliteArmorItem(ArmorItem.Type.CHESTPLATE);
    @ItemReg(group = @TargetId("item"))
    public static final Item SUGILITE_LEGGINGS = new SugiliteArmorItem(ArmorItem.Type.LEGGINGS);
    @ItemReg(group = @TargetId("item"))
    public static final Item SUGILITE_BOOTS = new SugiliteArmorItem(ArmorItem.Type.BOOTS);
    @ItemReg(group = @TargetId("item"))
    public static final Item TOPAZ_HELMET = new TopazArmorItem(ArmorItem.Type.HELMET);
    @ItemReg(group = @TargetId("item"))
    public static final Item TOPAZ_CHESTPLATE = new TopazArmorItem(ArmorItem.Type.CHESTPLATE);
    @ItemReg(group = @TargetId("item"))
    public static final Item TOPAZ_LEGGINGS = new TopazArmorItem(ArmorItem.Type.LEGGINGS);
    @ItemReg(group = @TargetId("item"))
    public static final Item TOPAZ_BOOTS = new TopazArmorItem(ArmorItem.Type.BOOTS);
    @ItemReg(group = @TargetId("main"))
    public static final Item MAGIC_HAT = new ItemBase(p -> p);
    @ItemReg(group = @TargetId("main"))
    public static final Item NETHER_THE_CROWN = new NetherTheCrownItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item GLUTTON_HELMET = new ItemBase(p -> p);
    @ItemReg(group = @TargetId("main"))
    public static final Item PIGLIN_KING_CROWN = new ItemBase(p -> p);
    @ItemReg(group = @TargetId("main"))
    public static final Item KING_NORMAL_CROWN = new ItemBase(p -> p);
    @ItemReg(group = @TargetId("main"))
    public static final Item PORKSHIRE_KING_CROWN = new ItemBase(p -> p);
    //tool
    @ItemReg(group = @TargetId("item"))
    public static final Item GEMSTONE_MIXTURE = new FoilItemBase(p -> p.maxCount(1).rarity(Rarity.EPIC));
    @ItemReg(group = @TargetId("main"))
    public static final Item HEROBRINE_DIAMOND_PICKAXE = new HerobrineDiamondPickaxeItem();
    @ItemReg(group = @TargetId("item"))
    public static final Item SUPER_DIAMOND_APPLE = new SuperDiamondAppleItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item NAEUS_SWORD = new NaeusSwordItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item NETHER_SPEAR = new NetherSpearItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item NETHERITE_FLAME_SABER = new NetheriteFlameSaberItem();
    @ItemReg(group = @TargetId("item"))
    public static final Item NETHERITE_NUCLEAR_REACTOR = new NetherNuclearReactorItem();
    @ItemReg(group = @TargetId("item"))
    public static final Item NIGHTMARES = new NightmaresItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item END_STAFF = new EndStaffItem();
    @ItemReg(group = @TargetId("item"))
    public static final Item MAGIC_STAR = new ItemBase(p -> p.maxDamage(5));
    @ItemReg(group = @TargetId("main"))
    public static final Item LIGHT_SWORD = new FoilSwordItemBase(ToolMaterialUtil.of(200, 0.0F, 5.0F, 0, 25), 3, -2.2F, new Item.Settings().fireproof());
    @ItemReg(group = @TargetId("main"))
    public static final Item NETHERITE_SHIELD = new NetheriteShieldItem();
    @ItemReg(group = @TargetId("item"))
    public static final Item DIVINE_CORE = new DivineCoreItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item SNOW_SHIELD = new SnowShieldItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item FALLEN_SOUL_AXE = new FallenSoulAxeItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item SEIZING_SHADOW_HALBERD = new SeizingShadowHalberdItem();
    @ItemReg(group = @TargetId("item"))
    public static final Item ENDER_BOOK = new EnderBookItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item COTTON_CANDY = new CottonCandyItem();
    @ItemReg(group = @TargetId("item"))
    public static final Item SAPPHIRE_SWORD = new SapphireTools.Sword();
    @ItemReg(group = @TargetId("item"))
    public static final Item RUBY_SWORD = new RubyTools.Sword();
    @ItemReg(group = @TargetId("item"))
    public static final Item SAPPHIRE_AXE = new SapphireTools.Axe();
    @ItemReg(group = @TargetId("item"))
    public static final Item RUBY_AXE = new RubyTools.Axe();
    @ItemReg(group = @TargetId("item"))
    public static final Item SAPPHIRE_PICKAXE = new SapphireTools.Pickaxe();
    @ItemReg(group = @TargetId("item"))
    public static final Item RUBY_PICKAXE = new RubyTools.Pickaxe();
    @ItemReg(group = @TargetId("item"))
    public static final Item SAPPHIRE_SHOVEL = new SapphireTools.Shovel();
    @ItemReg(group = @TargetId("item"))
    public static final Item RUBY_SHOVEL = new RubyTools.Shovel();
    @ItemReg(group = @TargetId("item"))
    public static final Item SAPPHIRE_HOE = new SapphireTools.Hoe();
    @ItemReg(group = @TargetId("item"))
    public static final Item RUBY_HOE = new RubyTools.Hoe();
    @ItemReg(group = @TargetId("item"))
    public static final Item SUGILITE_SWORD = new SugiliteTools.Sword();
    @ItemReg(group = @TargetId("item"))
    public static final Item TOPAZ_SWORD = new TopazTools.Sword();
    @ItemReg(group = @TargetId("item"))
    public static final Item SUGILITE_AXE = new SugiliteTools.Axe();
    @ItemReg(group = @TargetId("item"))
    public static final Item TOPAZ_AXE = new TopazTools.Axe();
    @ItemReg(group = @TargetId("item"))
    public static final Item SUGILITE_PICKAXE = new SugiliteTools.Pickaxe();
    @ItemReg(group = @TargetId("item"))
    public static final Item TOPAZ_PICKAXE = new TopazTools.Pickaxe();
    @ItemReg(group = @TargetId("item"))
    public static final Item SUGILITE_SHOVEL = new SugiliteTools.Shovel();
    @ItemReg(group = @TargetId("item"))
    public static final Item TOPAZ_SHOVEL = new TopazTools.Shovel();
    @ItemReg(group = @TargetId("item"))
    public static final Item SUGILITE_HOE = new SugiliteTools.Hoe();
    @ItemReg(group = @TargetId("item"))
    public static final Item TOPAZ_HOE = new TopazTools.Hoe();
    @ItemReg(group = @TargetId("item"))
    public static final Item DIAMOND_APPLE_SUPPER = new DiamondAppleSupperItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item ENDER_CURVED_SWORD = new EnderCurvedSwordItem();
    @ItemReg(group = @TargetId("item"))
    public static final Item UNDER_FLOWER = new UnderFlowerItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item BLUE_DIAMOND_SHIELD = new BlueDiamondShieldItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item BLACK_GUN = new BlackGunItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item BLACK_DEATH_SWORD = new BlackDeathSwordItem();
    @ItemReg(group = @TargetId("item"))
    public static final Item MYSTERIOUS_GIFT_BOX = new MysteriousGiftBoxItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item RAIN_LAZYED_SWORD = new FoilSwordItemBase(ToolMaterialUtil.of(1500, 0.0F, 8.0F, 0, 15), 3, -2.0F, new Item.Settings());
    @ItemReg(group = @TargetId("item"))
    public static final Item MAGIC_ENDER_PEARL = new MagicEnderPearlItem();
    @ItemReg(group = @TargetId("item"))
    public static final Item SOUL_TOTEM = new SoulTotemItem();
    @ItemReg(group = @TargetId("main"))
    public static final Item KING_ZOMBIE_PIG_MAN_SWORD = new SwordItem(ToolMaterialUtil.of(500, 0.0F, 6.0F, 0, 25, Items.GOLD_INGOT), 3, -2.3F, new Item.Settings());
    @ItemReg(group = @TargetId("main"))
    public static final Item EMERALD_BLADE = new SwordItem(ToolMaterialUtil.of(1200, 4.0F, 5.0F, 0, 3, Blocks.EMERALD_BLOCK), 3, -2.2F, new Item.Settings().fireproof());
    @ItemReg(group = @TargetId("main"))
    public static final Item BLADE_OF_THE_WHIRLWIND = new SwordItem(ToolMaterialUtil.of(2500, 4.0F, 6.0F, 0, 2, Blocks.OAK_LEAVES), 3, -2.8F, new Item.Settings());
    @ItemReg(group = @TargetId("main"))
    public static final Item SNOW_DIAMOND_SWORD = new SwordItem(ToolMaterialUtil.of(3000, 4.0F, 6.0F, 0, 2, Blocks.SNOW_BLOCK), 3, -2.0F, new Item.Settings());
    @ItemReg(group = @TargetId("main"))
    public static final Item NETHER_SICKLE = new SwordItem(ToolMaterialUtil.of(2000, 4.0F, 3.0F, 1, 2, Blocks.STRIPPED_WARPED_STEM), 3, -2.0F, new Item.Settings());
    @ItemReg(group = @TargetId("main"))
    public static final Item THE_GOLDEN_SWORD = new SwordItem(ToolMaterialUtil.of(3000, 4.0F, 6.0F, 1, 5, Blocks.GOLD_BLOCK), 3, -2.0F, new Item.Settings().fireproof());
    @ItemReg(group = @TargetId("main"))
    public static final Item DEEP_SICKLE = new SwordItem(ToolMaterialUtil.of(1000, 4.0F, 6.0F, 1, 2, Blocks.MOSS_BLOCK), 3, -2.4F, new Item.Settings());
    @ItemReg(group = @TargetId("main"))
    public static final Item IRON_DAGGER = new SwordItem(ToolMaterialUtil.of(1400, 4.0F, 7.0F, 1, 8, Blocks.IRON_BLOCK.asItem(), Items.IRON_INGOT), 3, -2.0F, new Item.Settings());
    @ItemReg(group = @TargetId("main"))
    public static final Item DEEP_WAR_HAMMER = new SwordItem(ToolMaterialUtil.of(1500, 0.0F, 8.0F, 0, 5), 3, -2.3F, new Item.Settings());
    @ItemReg(group = @TargetId("main"))
    public static final Item SKULL_CRUSHER = new SwordItem(ToolMaterialUtil.of(1500, 0.0F, 7.0F, 0, 15), 3, -2.2F, new Item.Settings().fireproof());
    @ItemReg(group = @TargetId("main"))
    public static final Item IRON_LONG_SPEAR = new SwordItem(ToolMaterialUtil.of(500, 0.0F, 3.0F, 0, 1), 3, -2.2F, new Item.Settings());
    @ItemReg(group = @TargetId("main"))
    public static final Item GOLDEN_PLUNDERING_AXE = new SwordItem(ToolMaterialUtil.of(1200, 0.0F, 5.0F, 0, 10), 3, -2.2F, new Item.Settings());
    @ItemReg(group = @TargetId("main"))
    public static final Item PLUNDERING_THE_GIANT_AXE = new SwordItem(ToolMaterialUtil.of(1300, 0.0F, 7.0F, 0, 8), 3, -2.2F, new Item.Settings());
    @ItemReg(group = @TargetId("main"))
    public static final Item LIGHT_SWORD_EVER = new SwordItem(ToolMaterialUtil.of(1000, 0.0F, 8.0F, 0, 30), 3, -2.0F, new Item.Settings());
    @ItemReg(group = @TargetId("main"))
    public static final Item DIAMOND_BIG_SWORD = new SwordItem(ToolMaterialUtil.of(2000, 0.0F, 9.0F, 0, 15), 3, -2.3F, new Item.Settings());
    @ItemReg(group = @TargetId("main"))
    public static final Item SOLDIER_SPEAR = new SwordItem(ToolMaterialUtil.of(1000, 0.0F, 5.0F, 0, 10), 3, -2.2F, new Item.Settings());
    @ItemReg(group = @TargetId("main"))
    public static final Item SOUL_RAIDING_HAMMER = new SwordItem(ToolMaterialUtil.of(2000, 0.0F, 10.0F, 0, 20), 3, -2.2F, new Item.Settings());
    @ItemReg(group = @TargetId("main"))
    public static final Item KATANA = new SwordItem(ToolMaterialUtil.of(1000, 0.0F, 6.0F, 0, 10), 3, -2.0F, new Item.Settings());
    @ItemReg(group = @TargetId("main"))
    public static final Item AMETHYST_WAR_HAMMER = new SwordItem(ToolMaterialUtil.of(1500, 0.0F, 9.0F, 0, 25), 3, -2.0F, new Item.Settings());
    //spawn egg
    @ItemReg(group = @TargetId("mobs"))
    public static final Item HEROBRINE_SPAWN_EGG = new SpawnEggBase(Episode.TheStruggle, ModEntities.HEROBRINE, -10092544, -65536, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item CERIS_SPAWN_EGG = new SpawnEggBase(Episode.ColdAsIce, ModEntities.CERIS, -10092442, -65281, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item ZOMBIES_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.ZOMBIES, -16724941, -16751104, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item NAEUS_SPAWN_EGG = new SpawnEggBase(Episode.BeginAgain, ModEntities.NAEUS, -10066330, -3355444, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item RAIN_SPAWN_EGG = new SpawnEggBase(Episode.TheStruggle, ModEntities.RAIN, -16777063, -13408513, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item ABIGAIL_SPAWN_EGG = new SpawnEggBase(Episode.BeginAgain, ModEntities.ABIGAIL, -65332, -39169, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item PATRICK_SPAWN_EGG = new SpawnEggBase(Episode.ColdAsIce, ModEntities.PATRICK, -16737895, -13369345, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item BLACKBONE_SPAWN_EGG = new SpawnEggBase(Episode.WeAreTheDanger, ModEntities.BLACKBONE, -16777216, -10066330, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item HOGSWORTH_SPAWN_EGG = new SpawnEggBase(Episode.HardPillToSwallow, ModEntities.HOGSWORTH, -26215, -13108, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item CIARA_SPAWN_EGG = new SpawnEggBase(Episode.Nightmares, ModEntities.CIARA, -52378, -39220, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item HILDA_SPAWN_EGG = new SpawnEggBase(Episode.ColdAsIceRemake, ModEntities.HILDA, -256, -3355444, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item SOLDIERS_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.SOLDIERS, -1, -1, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item WITHERED_SKELETONS_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.WITHERED_SKELETONS, -13421773, -10066330, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item DARK_SHIELD_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.DARK_SHIELD, -6736897, -16777216, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item DARK_ZOMBIE_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.DARK_ZOMBIE, -16751104, -13369549, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item VORDUS_SPAWN_EGG = new SpawnEggBase(Episode.Goodbye, ModEntities.VORDUS, -13421773, -3355648, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item WITHER_SHIELD_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.WITHER_SHIELD, -16777216, -1, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item SKELETON_SNOW_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.SKELETON_SNOW, -1, -13369345, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item ZOMBIES_PIGLIN_KING_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.ZOMBIE_PIGLIN_KING, -39424, -256, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item PIGLIN_KING_ZOMBIES_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.PIGLIN_KING_ZOMBIES, -26368, -52, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item PIGLIN_KING_ZOMBIE_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.PIGLIN_KING_ZOMBIE, -256, -13108, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item PIGLIN_COMMANDER_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.PIGLIN_COMMANDER, -52, -256, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item NAEUS_KING_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.NAEUS_KING, -6737152, -65536, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item TUSK_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.TUSK, -13159, -13108, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item BROTS_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.BROTS, -3399168, -9175040, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item ZOMBIE_PIGLIN_ART_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.ZOMBIE_PIGLIN_ART, -1343393, -412045, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item MUTATED_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.MUTATED, -5134336, -16735132, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item NAMTAR_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.NAMTAR, -7274496, -12544, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item AGETHA_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.AGETHA, -6710887, -3381760, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item TRICER_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.TRICER, -3407872, -16777216, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item BIG_UNDEAD_SKELETON_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.BIG_UNDEAD_SKELETON, -10066330, -16777216, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item ARCHER_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.ARCHER, -6710887, -16750951, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item DARYLL_SPAWN_EGG = new SpawnEggBase(Episode.ColdAsIce, ModEntities.DARYLL, -6737152, -1, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item NULL_LIKE_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.NULL_LIKE, -1, -16777216, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item GIGABONE_SPAWN_EGG = new SpawnEggBase(Episode.WeAreTheDanger, ModEntities.GIGABONE, -10066330, -3355393, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item KLAUS_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.KLAUS, -10066432, -16764109, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item KLAUS_2_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.KLAUS_2, -6711040, -16751002, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item KRALOS_SPAWN_EGG = new SpawnEggBase(Episode.None, ModEntities.KRALOS, -16777165, -6750157, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item ARABELLA_SPAWN_EGG = new SpawnEggBase(Episode.ToTheVoid, ModEntities.ARABELLA, -3407668, -13369345, new Item.Settings());
    @ItemReg(group = @TargetId("mobs"))
    public static final Item AZALEA_SPAWN_EGG = new SpawnEggBase(Episode.PreachToTheChoir, ModEntities.AZALEA, -256, -16738048, new Item.Settings());
    //music
    @ItemReg(group = @TargetId("item"))
    public static final Item HIM_MUSIC = new MusicItemBase("him_music_boss");
    @ItemReg(group = @TargetId("item"))
    public static final Item CERIS_MUSIC = new MusicItemBase("ceris_boss_music");
    @ItemReg(group = @TargetId("item"))
    public static final Item NULL_MUSIC = new MusicItemBase("null_boss_music");
    @ItemReg(group = @TargetId("item"))
    public static final Item BLACKBONE_MUSIC = new MusicItemBase("blackbone_boss_music");
    @ItemReg(group = @TargetId("item"))
    public static final Item PIGLIN_KING_MUSIC = new MusicItemBase("piglin_king_boss_music");
    @ItemReg(group = @TargetId("item"))
    public static final Item NAEUS_MUSIC = new MusicItemBase("naeus_boss_music");
    @ItemReg(group = @TargetId("item"))
    public static final Item GLUTTON_MUSIC = new MusicItemBase("glutton_boss_music");
    @ItemReg(group = @TargetId("item"))
    public static final Item HIM_ONE_LIVES = new MusicItemBase("him_one_lives");
    @ItemReg(group = @TargetId("item"))
    public static final Item KRALOS_MUSIC = new MusicItemBase("kralos_boss_music");
    @ItemReg(group = @TargetId("item"))
    public static final Item KLAUS_MUSIC = new MusicItemBase("klaus_boss_music");
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("herobrine_head"), @TargetId("herobrine_wall_head")})
    public static Item HEROBRINE_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("ceris_head"), @TargetId("ceris_wall_head")})
    public static Item CERIS_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("zombies_head"), @TargetId("zombies_wall_head")})
    public static Item ZOMBIES_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("naeus_head"), @TargetId("naeus_wall_head")})
    public static Item NAEUS_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("rain_head"), @TargetId("rain_wall_head")})
    public static Item RAIN_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("abigail_head"), @TargetId("abigail_wall_head")})
    public static Item ABIGAIL_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("patrick_head"), @TargetId("patrick_wall_head")})
    public static Item PATRICK_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("blackbone_head"), @TargetId("blackbone_wall_head")})
    public static Item BLACKBONE_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("hogsworth_head"), @TargetId("hogsworth_wall_head")})
    public static Item HOGSWORTH_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("ciara_head"), @TargetId("ciara_wall_head")})
    public static Item CIARA_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("hilda_head"), @TargetId("hilda_wall_head")})
    public static Item HILDA_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("soldiers_head"), @TargetId("soldiers_wall_head")})
    public static Item SOLDIERS_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("withered_skeletons_head"), @TargetId("withered_skeletons_wall_head")})
    public static Item WITHERED_SKELETONS_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("dark_shield_head"), @TargetId("dark_shield_wall_head")})
    public static Item DARK_SHIELD_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("dark_zombie_head"), @TargetId("dark_zombie_wall_head")})
    public static Item DARK_ZOMBIE_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("vordus_head"), @TargetId("vordus_wall_head")})
    public static Item VORDUS_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("wither_shield_head"), @TargetId("wither_shield_wall_head")})
    public static Item WITHER_SHIELD_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("skeleton_snow_head"), @TargetId("skeleton_snow_wall_head")})
    public static Item SKELETON_SNOW_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("piglin_king_head"), @TargetId("piglin_king_wall_head")})
    public static Item PIGLIN_KING_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("glutton_head"), @TargetId("glutton_wall_head")})
    public static Item GLUTTON_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("glutton_old_head"), @TargetId("glutton_old_wall_head")})
    public static Item GLUTTON_OLD_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("porkshire_head"), @TargetId("porkshire_wall_head")})
    public static Item PORKSHIRE_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("naeus_king_head"), @TargetId("naeus_king_wall_head")})
    public static Item NAEUS_KING_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("tusk_head"), @TargetId("tusk_wall_head")})
    public static Item TUSK_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("brots_head"), @TargetId("brots_wall_head")})
    public static Item BROTS_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("zombie_pig_head"), @TargetId("zombie_pig_wall_head")})
    public static Item ZOMBIE_PIG_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("mutated_head"), @TargetId("mutated_wall_head")})
    public static Item MUTATED_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("namtar_head"), @TargetId("namtar_wall_head")})
    public static Item NAMTAR_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("agetha_head"), @TargetId("agetha_wall_head")})
    public static Item AGETHA_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("tricer_head"), @TargetId("tricer_wall_head")})
    public static Item TRICER_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("big_black_skeleton_head"), @TargetId("big_black_skeleton_wall_head")})
    public static Item BIG_BLACK_SKELETON_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("archer_head"), @TargetId("archer_wall_head")})
    public static Item ARCHER_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("daryll_head"), @TargetId("daryll_wall_head")})
    public static Item DARYLL_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("null_like_head"), @TargetId("null_like_wall_head")})
    public static Item NULL_LIKE_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("gigabone_head"), @TargetId("gigabone_wall_head")})
    public static Item GIGABONE_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("klaus_head"), @TargetId("klaus_wall_head")})
    public static Item KLAUS_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("klaus_2_head"), @TargetId("klaus_2_wall_head")})
    public static Item KLAUS_2_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("kralos_head"), @TargetId("kralos_wall_head")})
    public static Item KRALOS_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("arabella_head"), @TargetId("arabella_wall_head")})
    public static Item ARABELLA_HEAD = null;
    @Group(@TargetId("mobs"))
    @Link(type = TargetType.SKULL, targets = {@TargetId("azalea_head"), @TargetId("azalea_wall_head")})
    public static Item AZALEA_HEAD = null;

    @CallbackHandler
    public static void init() {
        FuelRegistry.INSTANCE.add(ModItems.HOT_IRON, 2000);
    }
}