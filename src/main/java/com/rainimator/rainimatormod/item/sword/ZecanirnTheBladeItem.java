package com.rainimator.rainimatormod.item.sword;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.registry.ModParticles;
import com.rainimator.rainimatormod.registry.util.IRainimatorInfo;
import com.rainimator.rainimatormod.registry.util.ModCreativeTab;
import com.rainimator.rainimatormod.registry.util.SwordItemBase;
import com.rainimator.rainimatormod.registry.util.TierBase;
import com.rainimator.rainimatormod.util.Episode;
import com.rainimator.rainimatormod.util.ParticleUtil;
import com.rainimator.rainimatormod.util.SoundUtil;
import com.rainimator.rainimatormod.util.Timeout;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ZecanirnTheBladeItem extends SwordItemBase implements IRainimatorInfo {
    public ZecanirnTheBladeItem() {
        super(TierBase.of(1500, 4.0F, 11.0F, 0, 20, ModItems.SUPER_SAPPHIRE, ModItems.SUPER_RUBY), 3, -2.2F, ModCreativeTab.createProperty());
    }

    @Override
    public boolean postHit(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean ret_val = super.postHit(itemstack, entity, sourceentity);
        if (entity instanceof MobEntity _entity)
            _entity.setTarget(sourceentity);
        if (sourceentity.getMainHandStack().getItem() == ModItems.ZECANIRN_THE_BLADE)
            if (Math.random() < 0.9D) {
                if (entity.world instanceof ServerWorld _level)
                    _level.spawnParticles((ParticleEffect) ModParticles.PURPLE_LIGHT, entity.getX(), entity.getY(), entity.getZ(), 50, 0.5D, 1.0D, 0.5D, 0.2D);
                if (Math.random() < 0.5D)
                    SoundUtil.playSound(entity.world, entity.getX(), entity.getY(), entity.getZ(), new Identifier(RainimatorMod.MOD_ID, "sword_teleport1"), 4.0F, 1.0F);
                else if (Math.random() < 0.5D)
                    SoundUtil.playSound(entity.world, entity.getX(), entity.getY(), entity.getZ(), new Identifier(RainimatorMod.MOD_ID, "sword_teleport2"), 4.0F, 1.0F);
                else if (Math.random() < 0.5D)
                    SoundUtil.playSound(entity.world, entity.getX(), entity.getY(), entity.getZ(), new Identifier(RainimatorMod.MOD_ID, "sword_teleport3"), 4.0F, 1.0F);
                else
                    SoundUtil.playSound(entity.world, entity.getX(), entity.getY(), entity.getZ(), new Identifier(RainimatorMod.MOD_ID, "sword_teleport4"), 4.0F, 1.0F);

                sourceentity.requestTeleport(entity.world.raycast(new RaycastContext(entity.getCameraPosVec(1.0F), entity.getCameraPosVec(1.0F).add(entity.getRotationVec(1.0F).multiply(-2.0D)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, entity)).getBlockPos().getX(), entity.getY() + 0.5D, entity.world
                        .raycast(new RaycastContext(entity.getCameraPosVec(1.0F), entity.getCameraPosVec(1.0F).add(entity.getRotationVec(1.0F).multiply(-2.0D)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, entity)).getBlockPos().getZ());
                if (sourceentity instanceof ServerPlayerEntity _serverPlayer) {
                    _serverPlayer.networkHandler.requestTeleport(entity.world
                            .raycast(new RaycastContext(entity.getCameraPosVec(1.0F), entity.getCameraPosVec(1.0F).add(entity.getRotationVec(1.0F).multiply(-2.0D)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, entity)).getBlockPos().getX(), entity.getY() + 0.5D, entity.world
                            .raycast(new RaycastContext(entity.getCameraPosVec(1.0F), entity.getCameraPosVec(1.0F).add(entity.getRotationVec(1.0F).multiply(-2.0D)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, entity)).getBlockPos().getZ(), sourceentity
                            .getYaw(), sourceentity.getPitch());
                }

                entity.world.breakBlock(new BlockPos(sourceentity.getX(), entity.getY(), sourceentity.getZ()), false);
                entity.world.breakBlock(new BlockPos(sourceentity.getX(), entity.getY() + 1.0D, sourceentity.getZ()), false);
                entity.world.breakBlock(new BlockPos(sourceentity.getX(), entity.getY() + 2.0D, sourceentity.getZ()), false);

                if (itemstack.damage(MathHelper.nextInt(new Random(), 1, 5), new Random(), null)) {
                    itemstack.decrement(1);
                    itemstack.setDamage(0);
                }
            } else {
                entity.damage(DamageSource.MAGIC, 3.0F);
                if (entity instanceof LivingEntity) {
                    if (!entity.world.isClient())
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 100, 0));
                }

                if (itemstack.damage(MathHelper.nextInt(new Random(), 1, 5), new Random(), null)) {
                    itemstack.decrement(1);
                    itemstack.setDamage(0);
                }
                Timeout.create(100, () -> {
                    if (!entity.world.isClient())
                        entity.world.createExplosion(null, entity.getX(), entity.getY() + 1.0D, entity.getZ(), 1.0F, Explosion.DestructionType.NONE);
                });
            }
        return ret_val;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        TypedActionResult<ItemStack> ar = super.use(world, entity, hand);

        Vec3d _center = entity.getPos();
        List<Entity> _entfound = world.getEntitiesByClass(Entity.class, (new Box(_center, _center)).expand(8.0D), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.squaredDistanceTo(_center))).toList();
        for (Entity entityiterator : _entfound) {
            if (!(entityiterator instanceof LivingEntity _livEnt)) continue;
            if (_livEnt.getMainHandStack().getItem() == ModItems.ZECANIRN_THE_BLADE) {
                if (entity instanceof PlayerEntity)
                    entity.getItemCooldownManager().set(ar.getValue().getItem(), 0);
                continue;
            }
            if (entity.isSneaking()) {
                if (entity.getOffHandStack().getItem() == ModItems.ENDER_STONE) {
                    if (entity.getHealth() > 5.0F) {
                        entity.damage(DamageSource.MAGIC, 5.0F);
                        ItemStack _setstack = new ItemStack(Blocks.AIR);
                        _setstack.setCount(1);
                        entity.setStackInHand(Hand.OFF_HAND, _setstack);
                        entity.getInventory().markDirty();
                        entityiterator.damage(DamageSource.MAGIC, 10.0F);
                        if (world instanceof ServerWorld _level)
                            _level.spawnParticles((ParticleEffect) ModParticles.PURPLE_LIGHT, entity.getX(), entity.getY(), entity.getZ(), 40, 0.5D, 0.5D, 0.5D, 0.5D);
                        SoundUtil.playSound(world, entity.getX(), entity.getY(), entity.getZ(), new Identifier(RainimatorMod.MOD_ID, "black_death_sword_skills"), 4.0F, 1.0F);

                        Runnable callback = () -> {
                            entity.requestTeleport(entity.getX(), entity.getY(), entity.getZ());
                            if ((Entity) entity instanceof ServerPlayerEntity _serverPlayer)
                                _serverPlayer.networkHandler.requestTeleport(entity.getX(), entity.getY(), entity.getZ(), entity.getYaw(), entity.getPitch());

                            entityiterator.damage(DamageSource.MAGIC, 15.0F);
                            if (world instanceof ServerWorld _level) {
                                for (double z = -7; z <= 7; z++)
                                    _level.spawnParticles((ParticleEffect) ModParticles.PURPLE_LIGHT, entity.getX(), entity.getY(), entity.getZ() + z, 20, 0.2D, 0.5D, 0.2D, 0.2D);
                                for (double x = -7; x <= 7; x++)
                                    _level.spawnParticles((ParticleEffect) ModParticles.PURPLE_LIGHT, entity.getX() + x, entity.getY(), entity.getZ(), 20, 0.2D, 0.5D, 0.2D, 0.2D);
                            }
                            SoundUtil.playSound(world, entity.getX(), entity.getY(), entity.getZ(), new Identifier(RainimatorMod.MOD_ID, "black_death_sword_skills"), 4.0F, 1.0F);
                        };
                        Timeout.create(5, callback);
                        Timeout.create(10, callback);
                        Timeout.create(15, callback);
                        Timeout.create(20, callback);
                        Timeout.create(25, callback);
                        entity.getItemCooldownManager().set(ar.getValue().getItem(), 1200);
                        continue;
                    }
                    if (!entity.world.isClient())
                        entity.sendMessage(new TranslatableText("item.rainimator.zecanirn_the_blade.error.health"), true);
                    continue;
                }
                if (!entity.world.isClient())
                    entity.sendMessage(new TranslatableText("item.rainimator.zecanirn_the_blade.error.magic"), true);
            }
        }
        return ar;
    }

    @Override
    public boolean onSwingHand(ItemStack itemstack, World world, double x, double y, double z) {
        boolean ret_val = super.onSwingHand(itemstack, world, x, y, z);
        if (Math.random() < 0.2D)
            ParticleUtil.spawnCircleParticles(world, (ParticleEffect) ModParticles.PURPLE_LIGHT, x, y, z, 4, 0, 50);
        return ret_val;
    }

    @Override
    public Episode getEpisode() {
        return Episode.Goodbye;
    }
}
