package dev.rainimator.mod.registry;

import com.iafenvoy.annotationlib.annotation.ModId;
import com.iafenvoy.annotationlib.annotation.registration.RegisterAll;
import com.iafenvoy.annotationlib.api.IAnnotatedRegistryEntry;
import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.item.block.*;
import net.minecraft.block.Block;

@ModId(RainimatorMod.MOD_ID)
@RegisterAll
@SuppressWarnings("unused")
public class ModBlocks implements IAnnotatedRegistryEntry {
    public static final Block RUBY_ORE = new RubyOreBlock();
    public static final Block SAPPHIRE_ORE = new SapphireOreBlock();
    public static final Block SUGILITE_ORE = new SugiliteOreBlock();
    public static final Block TOPAZ_ORE = new TopazOreBlock();
    public static final Block DEEPSLATE_RUBY_ORE = new DeepslateRubyOreBlock();
    public static final Block DEEPSLATE_SAPPHIRE_ORE = new DeepslateSapphireOreBlock();
    public static final Block DARK_OBSIDIAN_BLOCK = new DarkObsidianBlock();
    public static final Block RUBY_BLOCK = new RubyBlock();
    public static final Block SAPPHIRE_BLOCK = new SapphireBlock();
    public static final Block SUGILITE_BLOCK = new SugiliteBlock();
    public static final Block TOPAZ_BLOCK = new TopazBlock();
    public static final Block BLUE_DIAMOND_BLOCK = new BlueDiamondBlock();
    public static final Block MYSTIC_ORE = new MysticoreBlock();
}
