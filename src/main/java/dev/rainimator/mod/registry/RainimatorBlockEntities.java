package dev.rainimator.mod.registry;

import com.iafenvoy.annotationlib.annotation.ModId;
import com.iafenvoy.annotationlib.annotation.registration.RegisterAll;
import com.iafenvoy.annotationlib.api.IAnnotatedRegistryEntry;
import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.item.block.entity.DarkObsidianBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;

@ModId(RainimatorMod.MOD_ID)
@RegisterAll
public class RainimatorBlockEntities implements IAnnotatedRegistryEntry {
    public static final BlockEntityType<DarkObsidianBlockEntity> DARK_OBSIDIAN_BLOCK = FabricBlockEntityTypeBuilder.create(DarkObsidianBlockEntity::new, RainimatorBlocks.DARK_OBSIDIAN_BLOCK).build();
}
