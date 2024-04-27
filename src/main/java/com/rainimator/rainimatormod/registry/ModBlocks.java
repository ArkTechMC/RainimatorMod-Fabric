package com.rainimator.rainimatormod.registry;

import com.iafenvoy.annotationlib.annotation.ModId;
import com.iafenvoy.annotationlib.annotation.registration.RegisterAll;
import com.iafenvoy.annotationlib.api.IAnnotatedRegistryEntry;
import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.item.block.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SkullBlock;
import net.minecraft.block.WallSkullBlock;

@ModId(RainimatorMod.MOD_ID)
@RegisterAll
@SuppressWarnings("unused")
public class ModBlocks implements IAnnotatedRegistryEntry {
    public static final Block RUBY_ORE = new RubyOreBlock();
    public static final Block SAPPHIRE_ORE = new SapphireOreBlock();
    public static final Block DEEPSLATE_RUBY_ORE = new DeepslateRubyOreBlock();
    public static final Block DEEPSLATE_SAPPHIRE_ORE = new DeepslateSapphireOreBlock();
    public static final Block DARK_OBSIDIAN_BLOCK = new DarkObsidianBlock();
    public static final Block RUBY_BLOCK = new RubyBlock();
    public static final Block SAPPHIRE_BLOCK = new SapphireBlock();
    public static final Block BLUE_DIAMOND_BLOCK = new BlueDiamondBlock();
    public static final Block MYSTIC_ORE = new MysticoreBlock();
    //skull
    public static final Block HEROBRINE_HEAD = new SkullBlock(ModSkulls.SkullType.HEROBRINE, AbstractBlock.Settings.create());
    public static final Block HEROBRINE_WALL_HEAD = new WallSkullBlock(ModSkulls.SkullType.HEROBRINE, AbstractBlock.Settings.create());
}
