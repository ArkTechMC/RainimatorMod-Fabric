package com.rainimator.rainimatormod.registry;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.item.block.entity.DarkObsidianBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<DarkObsidianBlockEntity> DARK_OBSIDIAN_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(DarkObsidianBlockEntity::new, ModBlocks.DARK_OBSIDIAN_BLOCK).build();

    public static void register() {
        Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(RainimatorMod.MOD_ID, "dark_obsidian_block"), DARK_OBSIDIAN_BLOCK_ENTITY);
    }
}
