package dev.rainimator.mod.registry;

import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.item.block.*;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

@SuppressWarnings("unused")
public class RainimatorBlocks {
    public static final Block RUBY_ORE = register("ruby_ore", new RubyOreBlock());
    public static final Block SAPPHIRE_ORE = register("sapphire_ore", new SapphireOreBlock());
    public static final Block SUGILITE_ORE = register("sugilite_ore", new SugiliteOreBlock());
    public static final Block TOPAZ_ORE = register("topaz_ore", new TopazOreBlock());
    public static final Block DEEPSLATE_RUBY_ORE = register("deepslate_ruby_ore", new DeepslateRubyOreBlock());
    public static final Block DEEPSLATE_SAPPHIRE_ORE = register("deepslate_sapphire_ore", new DeepslateSapphireOreBlock());
    public static final Block DARK_OBSIDIAN_BLOCK = register("dark_obsidian_block", new DarkObsidianBlock());
    public static final Block RUBY_BLOCK = register("ruby_block", new RubyBlock());
    public static final Block SAPPHIRE_BLOCK = register("sapphire_block", new SapphireBlock());
    public static final Block SUGILITE_BLOCK = register("sugilite_block", new SugiliteBlock());
    public static final Block TOPAZ_BLOCK = register("topaz_block", new TopazBlock());
    public static final Block BLUE_DIAMOND_BLOCK = register("blue_diamond_block", new BlueDiamondBlock());
    public static final Block MYSTIC_ORE = register("mystic_ore", new MysticoreBlock());

    private static <T extends Block> T register(String name, T block) {
        Registry.register(Registries.ITEM, new Identifier(RainimatorMod.MOD_ID, name), new BlockItem(block, new Item.Settings()));
        return Registry.register(Registries.BLOCK, new Identifier(RainimatorMod.MOD_ID, name), block);
    }

    public static void init() {
    }
}
