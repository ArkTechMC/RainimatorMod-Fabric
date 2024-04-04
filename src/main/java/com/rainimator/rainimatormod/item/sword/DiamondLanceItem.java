package com.rainimator.rainimatormod.item.sword;

import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.registry.util.SwordItemBase;
import com.rainimator.rainimatormod.registry.util.ToolMaterialBase;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class DiamondLanceItem extends SwordItemBase {
    public DiamondLanceItem() {
        super(ToolMaterialBase.of(2000, 4.0F, 7.0F, 0, 3, ModItems.BLUE_DIAMOND), 3, -2.0F, new Settings());
    }

    @Override
    public boolean postHit(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean ret_val = super.postHit(itemstack, entity, sourceentity);
        if (Math.random() < 0.1D) {
            if (entity.getWorld() instanceof ServerWorld _level) {
                LightningEntity entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                if (entityToSpawn != null) {
                    entityToSpawn.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(new BlockPos((int) entity.getX(), (int) entity.getY(), (int) entity.getZ())));
                    entityToSpawn.setCosmetic(true);
                    _level.spawnEntity(entityToSpawn);
                }
            }
            entity.getWorld().setBlockState(new BlockPos((int) entity.getX(), (int) entity.getY(), (int) entity.getZ()), Blocks.FIRE.getDefaultState(), 3);
        }
        return ret_val;
    }
}
