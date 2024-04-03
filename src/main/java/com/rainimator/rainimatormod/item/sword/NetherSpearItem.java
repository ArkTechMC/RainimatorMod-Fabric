package com.rainimator.rainimatormod.item.sword;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.registry.util.IRainimatorInfo;
import com.rainimator.rainimatormod.registry.util.ModCreativeTab;
import com.rainimator.rainimatormod.registry.util.SwordItemBase;
import com.rainimator.rainimatormod.registry.util.TierBase;
import com.rainimator.rainimatormod.util.Episode;
import com.rainimator.rainimatormod.util.ParticleUtil;
import com.rainimator.rainimatormod.util.SoundUtil;
import com.rainimator.rainimatormod.util.Timeout;
import dev.emi.trinkets.api.Trinket;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.Random;

public class NetherSpearItem extends SwordItemBase implements IRainimatorInfo, Trinket {
    public NetherSpearItem() {
        super(TierBase.of(3000, 0.0F, 11.0F, 0, 25), 3, -2.2F, ModCreativeTab.createProperty().fireproof());
    }

    @Override
    public boolean postHit(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean retval = super.postHit(itemstack, entity, sourceentity);
        if (entity instanceof MobEntity _entity)
            _entity.setTarget(sourceentity);
        if (Math.random() < 0.2D)
            entity.setOnFireFor(10);
        if (Math.random() < 0.2D)
            sourceentity.setHealth(((sourceentity instanceof LivingEntity) ? sourceentity.getHealth() : -1.0F) + MathHelper.nextInt(new Random(), 1, 4));
        return retval;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        TypedActionResult<ItemStack> ar = super.use(world, entity, hand);
        double x = entity.getX();
        final double y = entity.getY();
        double z = entity.getZ();
        ItemStack itemstack = ar.getValue();
        if (entity.isSneaking())
            SoundUtil.playSound(world, x, y, z, new Identifier(RainimatorMod.MOD_ID, "naeus_sword_1"), 5.0F, 1.0F);
        BlockPos pos1 = entity.world.raycast(new RaycastContext(entity.getCameraPosVec(1.0F), entity.getCameraPosVec(1.0F).add(entity.getRotationVec(1.0F).multiply(2.0D)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, entity)).getBlockPos();
        if (world instanceof ServerWorld _level) {
            LightningEntity entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
            if (entityToSpawn != null) {
                entityToSpawn.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(new BlockPos(pos1.getX(), y, pos1.getZ())));
                entityToSpawn.setCosmetic(true);
                _level.spawnEntity(entityToSpawn);
            }
        }

        world.setBlockState(new BlockPos(pos1.getX(), y, pos1.getZ()), Blocks.FIRE.getDefaultState(), 3);

        Runnable callback = () -> {
            BlockPos pos = entity.world.raycast(new RaycastContext(entity.getCameraPosVec(1.0F), entity.getCameraPosVec(1.0F).add(entity.getRotationVec(1.0F).multiply(12.0D)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, entity)).getBlockPos();
            if (world instanceof ServerWorld _level) {
                LightningEntity entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                if (entityToSpawn != null) {
                    entityToSpawn.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(new BlockPos(pos.getX(), y, pos.getZ())));
                    entityToSpawn.setCosmetic(true);
                    _level.spawnEntity(entityToSpawn);
                }
            }
            world.setBlockState(new BlockPos(pos.getX(), y, pos.getZ()), Blocks.FIRE.getDefaultState(), 3);
        };
        Timeout.create(2, callback);
        Timeout.create(4, callback);
        Timeout.create(6, callback);
        Timeout.create(8, callback);
        Timeout.create(10, callback);
        Timeout.create(12, callback);
        Timeout.create(14, callback);
        Timeout.create(16, callback);
        Timeout.create(18, callback);
        Timeout.create(20, callback);

        if (entity instanceof PlayerEntity)
            entity.getItemCooldownManager().set(itemstack.getItem(), 1200);

        return ar;
    }

    @Override
    public boolean onSwingHand(ItemStack itemstack, World world, double x, double y, double z) {
        boolean retval = super.onSwingHand(itemstack, world, x, y, z);
        if (Math.random() < 0.2D)
            ParticleUtil.spawnCircleParticles(world, ParticleTypes.FLAME, x, y, z, 4, 0, 50);
        return retval;
    }

    @Override
    public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, world, entity, slot, selected);
        if (selected && entity instanceof LivingEntity _livEnt && !_livEnt.world.isClient()) {
            if (((entity instanceof LivingEntity) ? _livEnt.getArmor() : 0) <= 10)
                _livEnt.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 3));
            else {
                if (((entity instanceof LivingEntity) ? _livEnt.getArmor() : 0) <= 20)
                    _livEnt.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 2));
                else {
                    if (((entity instanceof LivingEntity) ? _livEnt.getArmor() : 0) <= 30)
                        _livEnt.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 1));
                    else {
                        if (((entity instanceof LivingEntity) ? _livEnt.getArmor() : 0) <= 40)
                            _livEnt.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 0));
                    }
                }
            }
        }
    }

    @Override
    public Episode getEpisode() {
        return Episode.HardPillToSwallow;
    }
}
