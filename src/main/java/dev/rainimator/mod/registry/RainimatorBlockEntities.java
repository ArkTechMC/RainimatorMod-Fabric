package dev.rainimator.mod.registry;

import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.item.block.entity.DarkObsidianBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RainimatorBlockEntities {
    public static final BlockEntityType<DarkObsidianBlockEntity> DARK_OBSIDIAN_BLOCK = register("dark_obsidian_block", FabricBlockEntityTypeBuilder.create(DarkObsidianBlockEntity::new, RainimatorBlocks.DARK_OBSIDIAN_BLOCK).build());

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(RainimatorMod.MOD_ID, name), type);
    }

    public static void init() {
    }
}
