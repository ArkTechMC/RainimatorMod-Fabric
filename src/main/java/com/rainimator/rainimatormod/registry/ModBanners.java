package com.rainimator.rainimatormod.registry;

import com.iafenvoy.mcrconvertlib.item.BannerUtil;
import com.ibm.icu.impl.Pair;
import net.minecraft.block.entity.BannerPatterns;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DyeColor;

public class ModBanners {
    public static final ItemStack FROST = BannerUtil.create("frost",Items.CYAN_BANNER,
            Pair.of(BannerPatterns.CROSS, DyeColor.WHITE),
            Pair.of(BannerPatterns.STRAIGHT_CROSS, DyeColor.WHITE),
            Pair.of(BannerPatterns.CURLY_BORDER, DyeColor.WHITE),
            Pair.of(BannerPatterns.FLOWER, DyeColor.LIGHT_BLUE));
    public static final ItemStack UNDEAD = BannerUtil.create("undead",Items.LIGHT_GRAY_BANNER,
            Pair.of(BannerPatterns.CROSS, DyeColor.BLACK),
            Pair.of(BannerPatterns.STRAIGHT_CROSS, DyeColor.BLACK),
            Pair.of(BannerPatterns.TRIANGLES_TOP, DyeColor.BLACK),
            Pair.of(BannerPatterns.GRADIENT_UP, DyeColor.BLACK),
            Pair.of(BannerPatterns.SKULL, DyeColor.LIGHT_GRAY),
            Pair.of(BannerPatterns.SKULL, DyeColor.WHITE));
    public static final ItemStack NETHER = BannerUtil.create("nether",Items.BLACK_BANNER,
            Pair.of(BannerPatterns.TRIANGLES_TOP, DyeColor.ORANGE),
            Pair.of(BannerPatterns.TRIANGLES_BOTTOM, DyeColor.ORANGE),
            Pair.of(BannerPatterns.CIRCLE, DyeColor.YELLOW),
            Pair.of(BannerPatterns.FLOWER, DyeColor.RED),
            Pair.of(BannerPatterns.SKULL, DyeColor.BLACK),
            Pair.of(BannerPatterns.CURLY_BORDER, DyeColor.BLACK),
            Pair.of(BannerPatterns.BORDER, DyeColor.BLACK));
    public static final ItemStack DRAGONSPIRE = BannerUtil.create("dragonspire",Items.BLUE_BANNER,
            Pair.of(BannerPatterns.SMALL_STRIPES, DyeColor.BLACK),
            Pair.of(BannerPatterns.TRIANGLES_TOP, DyeColor.BLACK),
            Pair.of(BannerPatterns.TRIANGLES_BOTTOM, DyeColor.BLACK),
            Pair.of(BannerPatterns.RHOMBUS, DyeColor.BLUE),
            Pair.of(BannerPatterns.FLOWER, DyeColor.BLACK),
            Pair.of(BannerPatterns.CIRCLE, DyeColor.LIGHT_BLUE),
            Pair.of(BannerPatterns.BORDER, DyeColor.BLACK));
    public static final ItemStack ENDER_PIRATE = BannerUtil.create("ender_pirate",Items.PURPLE_BANNER,
            Pair.of(BannerPatterns.GRADIENT, DyeColor.BLACK),
            Pair.of(BannerPatterns.STRAIGHT_CROSS, DyeColor.MAGENTA),
            Pair.of(BannerPatterns.TRIANGLES_TOP, DyeColor.WHITE),
            Pair.of(BannerPatterns.TRIANGLES_BOTTOM, DyeColor.WHITE),
            Pair.of(BannerPatterns.TRIANGLES_TOP, DyeColor.MAGENTA),
            Pair.of(BannerPatterns.TRIANGLES_BOTTOM, DyeColor.MAGENTA),
            Pair.of(BannerPatterns.SKULL, DyeColor.WHITE));
    public static final ItemStack THE_GATEKEEPERS = BannerUtil.create("the_gatekeepers",Items.CYAN_BANNER,
            Pair.of(BannerPatterns.STRIPE_BOTTOM, DyeColor.MAGENTA),
            Pair.of(BannerPatterns.SMALL_STRIPES, DyeColor.PURPLE),
            Pair.of(BannerPatterns.HALF_HORIZONTAL, DyeColor.PURPLE),
            Pair.of(BannerPatterns.RHOMBUS, DyeColor.BLACK),
            Pair.of(BannerPatterns.TRIANGLES_TOP, DyeColor.CYAN),
            Pair.of(BannerPatterns.TRIANGLES_BOTTOM, DyeColor.CYAN),
            Pair.of(BannerPatterns.CROSS, DyeColor.CYAN),
            Pair.of(BannerPatterns.SMALL_STRIPES, DyeColor.BLACK),
            Pair.of(BannerPatterns.CURLY_BORDER, DyeColor.BLACK));
    public static final ItemStack ORCHID_CITY = BannerUtil.create("orchid_city",Items.GRAY_BANNER,
            Pair.of(BannerPatterns.GRADIENT, DyeColor.MAGENTA),
            Pair.of(BannerPatterns.CROSS, DyeColor.WHITE),
            Pair.of(BannerPatterns.CROSS, DyeColor.BLACK),
            Pair.of(BannerPatterns.CURLY_BORDER, DyeColor.BLACK),
            Pair.of(BannerPatterns.TRIANGLES_TOP, DyeColor.BLACK),
            Pair.of(BannerPatterns.TRIANGLES_BOTTOM, DyeColor.BLACK),
            Pair.of(BannerPatterns.CIRCLE, DyeColor.MAGENTA),
            Pair.of(BannerPatterns.FLOWER, DyeColor.WHITE));
    public static final ItemStack LIGHTBORNE_ISLES = BannerUtil.create("lightborne_isles",Items.WHITE_BANNER,
            Pair.of(BannerPatterns.STRIPE_CENTER, DyeColor.GRAY),
            Pair.of(BannerPatterns.STRIPE_MIDDLE, DyeColor.GRAY),
            Pair.of(BannerPatterns.CURLY_BORDER, DyeColor.BLACK),
            Pair.of(BannerPatterns.CROSS, DyeColor.BLACK),
            Pair.of(BannerPatterns.FLOWER, DyeColor.LIGHT_GRAY),
            Pair.of(BannerPatterns.CIRCLE, DyeColor.WHITE));
    public static final ItemStack THE_UMBRAL_KINGDOM = BannerUtil.create("the_umbral_kingdom",Items.BLACK_BANNER,
            Pair.of(BannerPatterns.STRIPE_CENTER, DyeColor.WHITE),
            Pair.of(BannerPatterns.BRICKS, DyeColor.LIGHT_BLUE),
            Pair.of(BannerPatterns.BRICKS, DyeColor.BLACK),
            Pair.of(BannerPatterns.STRIPE_DOWNLEFT, DyeColor.CYAN),
            Pair.of(BannerPatterns.STRIPE_DOWNRIGHT, DyeColor.MAGENTA),
            Pair.of(BannerPatterns.RHOMBUS, DyeColor.CYAN),
            Pair.of(BannerPatterns.CREEPER, DyeColor.MAGENTA),
            Pair.of(BannerPatterns.CROSS, DyeColor.BLACK),
            Pair.of(BannerPatterns.CIRCLE, DyeColor.MAGENTA),
            Pair.of(BannerPatterns.FLOWER, DyeColor.BLACK),
            Pair.of(BannerPatterns.SKULL, DyeColor.BLACK));
    public static final ItemStack CHORUS_BAY = BannerUtil.create("chorus_bay",Items.LIGHT_BLUE_BANNER,
            Pair.of(BannerPatterns.GRADIENT, DyeColor.BLUE),
            Pair.of(BannerPatterns.TRIANGLES_TOP, DyeColor.WHITE),
            Pair.of(BannerPatterns.FLOWER, DyeColor.LIGHT_BLUE),
            Pair.of(BannerPatterns.CURLY_BORDER, DyeColor.BLACK),
            Pair.of(BannerPatterns.CIRCLE, DyeColor.WHITE));
    public static final ItemStack VOID_ISLANDS = BannerUtil.create("void_islands",Items.WHITE_BANNER,
            Pair.of(BannerPatterns.GRADIENT, DyeColor.BLACK),
            Pair.of(BannerPatterns.SMALL_STRIPES, DyeColor.BLACK),
            Pair.of(BannerPatterns.RHOMBUS, DyeColor.WHITE),
            Pair.of(BannerPatterns.CURLY_BORDER, DyeColor.WHITE),
            Pair.of(BannerPatterns.FLOWER, DyeColor.BLACK),
            Pair.of(BannerPatterns.BORDER, DyeColor.BLACK));
}
