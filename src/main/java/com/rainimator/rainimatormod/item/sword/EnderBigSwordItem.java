package com.rainimator.rainimatormod.item.sword;

import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.registry.ModParticles;
import com.rainimator.rainimatormod.registry.util.SwordItemBase;
import com.rainimator.rainimatormod.registry.util.ToolMaterialBase;
import com.rainimator.rainimatormod.util.SoundUtil;
import dev.emi.trinkets.api.Trinket;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class EnderBigSwordItem extends SwordItemBase implements Trinket {
    public EnderBigSwordItem() {
        super(ToolMaterialBase.of(2000, 4.0F, 9.0F, 1, 15, ModItems.SUPER_SAPPHIRE, Items.ENDER_EYE), 3, -2.2F, new Settings());
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        TypedActionResult<ItemStack> ar = super.use(world, entity, hand);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        ItemStack itemstack = ar.getValue();
        double ender_1 = 0.0D;
        if (entity.isSneaking()) {
            BlockPos blockPos1 = entity.getWorld().raycast(new RaycastContext(entity.getCameraPosVec(1.0F), entity.getCameraPosVec(1.0F).add(entity.getRotationVec(1.0F).multiply(ender_1 + 6.0D)), RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, entity)).getBlockPos();
            BlockPos blockPos2 = entity.getWorld().raycast(new RaycastContext(entity.getCameraPosVec(1.0F), entity.getCameraPosVec(1.0F).add(entity.getRotationVec(1.0F).multiply(ender_1)), RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, entity)).getBlockPos();
            entity.requestTeleport(blockPos1.getX(), blockPos2.getY(), blockPos1.getZ());
            if ((Entity) entity instanceof ServerPlayerEntity _serverPlayer)
                _serverPlayer.networkHandler.requestTeleport(blockPos1.getX(), blockPos2.getY(), blockPos1.getZ(), entity.getYaw(), entity.getPitch());
            SoundUtil.playSound(world, x, y, z, new Identifier("entity.enderman.teleport"), 1.0F, 1.0F);
            if (world instanceof ServerWorld _level) {
                _level.spawnParticles((ParticleEffect) ModParticles.PURPLE_LIGHT, x, y, z, 50, 0.5D, 0.0D, 0.5D, 0.2D);
                entity.getItemCooldownManager().set(itemstack.getItem(), 300);
            }
        }
        return ar;
    }
}

