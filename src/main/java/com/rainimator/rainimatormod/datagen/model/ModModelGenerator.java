package com.rainimator.rainimatormod.datagen.model;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.registry.ModBlocks;
import com.rainimator.rainimatormod.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Optional;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SUGILITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOPAZ_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SUGILITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOPAZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MYSTIC_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_DIAMOND_BLOCK);
        blockStateModelGenerator.blockStateCollector.accept(MultipartBlockStateSupplier.create(ModBlocks.DARK_OBSIDIAN_BLOCK)
                .with(When.create().set(Properties.HORIZONTAL_FACING, Direction.NORTH), BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R0))
                .with(When.create().set(Properties.HORIZONTAL_FACING, Direction.EAST), BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(Properties.HORIZONTAL_FACING, Direction.SOUTH), BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .with(When.create().set(Properties.HORIZONTAL_FACING, Direction.WEST), BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R270))
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BLUE_DIAMOND_SWORD, createItem("blue_diamond_sword", TextureKey.of("4"), TextureKey.PARTICLE));
    }

    private static Model createItem(String name, TextureKey... textureKeys) {
        return new Model(Optional.of(new Identifier(RainimatorMod.MOD_ID, "custom/" + name)), Optional.empty(), textureKeys);
    }
}
