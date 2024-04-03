package com.rainimator.rainimatormod.feature;

import com.rainimator.rainimatormod.RainimatorMod;
import net.minecraft.structure.Structure;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.List;
import java.util.Set;

public class DarkweryFeature extends Feature<DefaultFeatureConfig> {
    public static final Set<Identifier> GENERATE_BIOMES = null;
    public static DarkweryFeature FEATURE = null;
    public static RegistryEntry<ConfiguredFeature<DefaultFeatureConfig, ?>> CONFIGURED_FEATURE = null;
    public static RegistryEntry<PlacedFeature> PLACED_FEATURE = null;
    private final Set<RegistryKey<World>> generate_dimensions = Set.of(World.OVERWORLD);
    private Structure template = null;

    public DarkweryFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    public static Feature<?> feature() {
        FEATURE = new DarkweryFeature();
        CONFIGURED_FEATURE = ConfiguredFeatures.register(RainimatorMod.MOD_ID + ":dark_wery", FEATURE, FeatureConfig.DEFAULT);
        PLACED_FEATURE = PlacedFeatures.register(RainimatorMod.MOD_ID + ":dark_wery", CONFIGURED_FEATURE, List.of());
        return FEATURE;
    }

    public static RegistryEntry<PlacedFeature> placedFeature() {
        return PLACED_FEATURE;
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        if (!this.generate_dimensions.contains(context.getWorld().toServerWorld().getRegistryKey()))
            return false;
        if (this.template == null)
            this.template = context.getWorld().toServerWorld().getStructureManager().getStructureOrBlank(new Identifier(RainimatorMod.MOD_ID, "dark_wery"));
        boolean anyPlaced = false;
        if (context.getRandom().nextInt(1000000) + 1 <= 100) {
            int count = context.getRandom().nextInt(1) + 1;
            for (int a = 0; a < count; a++) {
                int i = context.getOrigin().getX() + context.getRandom().nextInt(16);
                int k = context.getOrigin().getZ() + context.getRandom().nextInt(16);
                int j = context.getWorld().getTopY(Heightmap.Type.OCEAN_FLOOR_WG, i, k) - 1;
                BlockPos spawnTo = new BlockPos(i, j, k);
                if (this.template.place(context.getWorld(), spawnTo, spawnTo, (new StructurePlacementData()).setMirror(BlockMirror.NONE).setRotation(BlockRotation.NONE).setRandom(context.getRandom()).addProcessor(BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS).setIgnoreEntities(false), context.getRandom(), 2))
                    anyPlaced = true;
            }
        }
        return anyPlaced;
    }
}
