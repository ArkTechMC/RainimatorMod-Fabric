package com.rainimator.rainimatormod.registry;

import com.ibm.icu.impl.Pair;
import com.rainimator.rainimatormod.registry.util.BannerUtil;
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
    public static final ItemStack ENDER_WATCHER = BannerUtil.create("ender_watcher",Items.BLUE_BANNER,
            Pair.of(BannerPatterns.SMALL_STRIPES, DyeColor.BLACK),
            Pair.of(BannerPatterns.TRIANGLES_TOP, DyeColor.BLACK),
            Pair.of(BannerPatterns.TRIANGLES_BOTTOM, DyeColor.BLACK),
            Pair.of(BannerPatterns.RHOMBUS, DyeColor.BLUE),
            Pair.of(BannerPatterns.FLOWER, DyeColor.BLACK),
            Pair.of(BannerPatterns.CIRCLE, DyeColor.LIGHT_BLUE),
            Pair.of(BannerPatterns.BORDER, DyeColor.BLACK));
}
