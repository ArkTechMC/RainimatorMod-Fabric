package com.rainimator.rainimatormod.registry;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.block.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SkullBlock;
import net.minecraft.block.WallSkullBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class ModBlocks {
    public static final Block RUBY_ORE = register("ruby_ore", RubyOreBlock::new);
    public static final Block SAPPHIRE_ORE = register("sapphire_ore", SapphireOreBlock::new);
    public static final Block DEEPSLATE_SAPPHIRE_ORE = register("deepslate_sapphire_ore", DeepslateSapphireOreBlock::new);
    public static final Block DEEPSLATE_RUBY_ORE = register("deepslate_ruby_ore", DeepslateRubyOreBlock::new);
    public static final Block DARK_OBSIDIAN_BLOCK = register("dark_obsidian_block", DarkObsidianBlock::new);
    public static final Block RUBY_BLOCK = register("ruby_block", RubyBlock::new);
    public static final Block SAPPHIRE_BLOCK = register("sapphire_block", SapphireBlock::new);
    public static final Block BLUE_DIAMOND_BLOCK = register("blue_diamond_block", BlueDiamondBlock::new);
    public static final Block MYSTIC_ORE = register("mystic_ore", MysticoreBlock::new);

    private static Block register(String name, Supplier<Block> provider) {
        return register(name, provider.get());
    }

    private static Block register(String name, Block obj) {
        Registry.register(Registries.BLOCK, new Identifier(RainimatorMod.MOD_ID, name), obj);
        return obj;
    }
}
