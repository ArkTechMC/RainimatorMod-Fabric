package com.rainimator.rainimatormod.item.sword;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.registry.util.FoilSwordItemBase;
import com.rainimator.rainimatormod.registry.util.IRainimatorInfo;
import com.rainimator.rainimatormod.registry.util.ModCreativeTab;
import com.rainimator.rainimatormod.registry.util.TierBase;
import com.rainimator.rainimatormod.util.Episode;
import com.rainimator.rainimatormod.util.ParticleUtil;
import com.rainimator.rainimatormod.util.SoundUtil;
import com.rainimator.rainimatormod.util.Timeout;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.Random;

public class BlackBoneTheBladeItem extends FoilSwordItemBase implements IRainimatorInfo {
    public BlackBoneTheBladeItem() {
        super(TierBase.of(1500, 0.0F, 7.0F, 0, 10, ModItems.RUBY), 3, -2.4F, ModCreativeTab.createProperty().fireproof());
    }

    @Override
    public boolean postHit(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean retval = super.postHit(itemstack, entity, sourceentity);
        if (entity instanceof MobEntity _entity)
            if (sourceentity instanceof LivingEntity)
                _entity.setTarget(sourceentity);
        entity.setOnFireFor(8);
        if (Math.random() < 0.1D)
            entity.damage(DamageSource.MAGIC, MathHelper.nextInt(new Random(), 1, 3));
        if (Math.random() < 0.3D)
            sourceentity.setHealth(sourceentity.getHealth() + MathHelper.nextInt(new Random(), 2, 5));
        return retval;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        TypedActionResult<ItemStack> ar = super.use(world, entity, hand);
        double x = entity.getX();
        final double y = entity.getY();
        double z = entity.getZ();
        ItemStack itemstack = ar.getValue();
        if (entity.isSneaking()) {
            SoundUtil.playSound(world, x, y, z, new Identifier(RainimatorMod.MOD_ID, "blackbone_living"), 10.0F, 1.0F);
            if (world instanceof ServerWorld _level)
                _level.spawnParticles((ParticleEffect) ParticleTypes.ELECTRIC_SPARK, x, y, z, 25, 1.0D, 1.0D, 1.0D, 1.0D);
            if (!world.isClient())
                world.createExplosion(null, entity.world.raycast(new RaycastContext(entity.getCameraPosVec(1.0F), entity.getCameraPosVec(1.0F).add(entity.getRotationVec(1.0F).multiply(2.0D)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, entity)).getBlockPos().getX(), y + 1.0D, entity.world
                        .raycast(new RaycastContext(entity.getCameraPosVec(1.0F), entity.getCameraPosVec(1.0F).add(entity.getRotationVec(1.0F).multiply(2.0D)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, entity)).getBlockPos().getZ(), 1.0F, Explosion.DestructionType.NONE);

            entity.getItemCooldownManager().set(itemstack.getItem(), 700);

            Runnable callback = () -> {
                if (world instanceof World) {
                    if (!world.isClient())
                        world.createExplosion(null, entity.world
                                .raycast(new RaycastContext(entity.getCameraPosVec(1.0F), entity.getCameraPosVec(1.0F).add(entity.getRotationVec(1.0F).multiply(12.0D)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, entity)).getBlockPos().getX(), y + 1.0D, entity.world

                                .raycast(new RaycastContext(entity.getCameraPosVec(1.0F), entity.getCameraPosVec(1.0F).add(entity.getRotationVec(1.0F).multiply(12.0D)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, entity)).getBlockPos().getZ(), 2.0F, Explosion.DestructionType.NONE);
                }
            };
            Timeout.create(5, callback);
            Timeout.create(10, callback);
            Timeout.create(15, callback);
            Timeout.create(20, callback);
            Timeout.create(25, callback);
            Timeout.create(30, callback);
            Timeout.create(35, callback);
        }
        return ar;
    }

    @Override
    public boolean onSwingHand(ItemStack itemstack, World world, double x, double y, double z) {
        boolean retval = super.onSwingHand(itemstack, world, x, y, z);
        if (Math.random() < 0.2D)
            ParticleUtil.spawnCircleParticles(world, ParticleTypes.LAVA, x, y, z, 4, 0, 50);
        return retval;
    }

    @Override
    public Episode getEpisode() {
        return Episode.WeAreTheDanger;
    }
}
