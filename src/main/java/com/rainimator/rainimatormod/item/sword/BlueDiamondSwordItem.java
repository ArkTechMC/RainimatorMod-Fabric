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
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
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
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.explosion.Explosion;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class BlueDiamondSwordItem extends SwordItemBase implements IRainimatorInfo {
    public BlueDiamondSwordItem() {
        super(TierBase.of(3000, 4.0F, 15.0F, 0, 30, ModItems.BLUE_DIAMOND), 3, -2.0F, ModCreativeTab.createProperty().fireproof());
    }

    @Override
    public boolean postHit(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean retval = super.postHit(itemstack, entity, sourceentity);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        if (entity instanceof LivingEntity)
            if (entity.hasStatusEffect(StatusEffects.GLOWING) && Math.random() < 0.4D)
                entity.damage(DamageSource.MAGIC, 5.0F);
        if (Math.random() < 0.1D) {
            if (entity.world instanceof ServerWorld _level) {
                LightningEntity entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                if (entityToSpawn != null) {
                    entityToSpawn.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(new BlockPos(x, y, z)));
                    entityToSpawn.setCosmetic(true);
                    _level.spawnEntity(entityToSpawn);
                }
            }
            entity.world.setBlockState(new BlockPos(x, y, z), Blocks.FIRE.getDefaultState(), 3);
        }

        return retval;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        TypedActionResult<ItemStack> ar = super.use(world, entity, hand);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        ItemStack itemstack = ar.getValue();
        final Vec3d _center = new Vec3d(x, y, z);
        List<Entity> _entfound = world.getEntitiesByClass(Entity.class, new Box(_center, _center).expand(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.squaredDistanceTo(_center))).toList();
        for (Entity entityiterator : _entfound) {
            if (entity.isSneaking()) {
                if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == ModItems.BLUE_DIAMOND_SWORD) {
                    if (itemstack.damage(0, new Random(), null)) {
                        itemstack.decrement(1);
                        itemstack.setDamage(0);
                    }
                } else {
                    if (entityiterator instanceof LivingEntity _livEnt && _livEnt.getGroup() == EntityGroup.ARTHROPOD) {
                        if (world instanceof ServerWorld _level)
                            _level.spawnParticles(ParticleTypes.END_ROD, x, y, z, 50, 0.5, 0.5, 0.5, 0.2);
                        SoundUtil.playSound(world, x, y, z, new Identifier(RainimatorMod.MOD_ID, "blued_diamond_skill_1"), 5, 1);
                        if (!_livEnt.world.isClient())
                            _livEnt.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 1200, 0));
                        entityiterator.setOnFireFor(10);
                        entity.getItemCooldownManager().set(itemstack.getItem(), 1000);
                        if (!entity.world.isClient())
                            entity.sendMessage(new TranslatableText("item.rainimator.blue_diamond_sword.skill1"), true);
                        if (world.isClient())
                            MinecraftClient.getInstance().gameRenderer.showFloatingItem(itemstack);
                        Runnable callback = () -> {
                            if (entityiterator.isAlive()) {
                                if (world instanceof ServerWorld _level) {
                                    LightningEntity entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                                    if (entityToSpawn != null) {
                                        entityToSpawn.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(new BlockPos(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())));
                                        entityToSpawn.setCosmetic(true);
                                        _level.spawnEntity(entityToSpawn);
                                    }
                                }
                                world.setBlockState(new BlockPos(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), Blocks.FIRE.getDefaultState(), 3);
                                entityiterator.damage(DamageSource.MAGIC, 5);
                            }
                        };
                        Timeout.create(40, callback);
                        Timeout.create(80, callback);
                        Timeout.create(120, callback);
                        Timeout.create(160, callback);
                        Timeout.create(200, callback);
                    } else if ((entityiterator instanceof LivingEntity _livEnt && _livEnt.getGroup() == EntityGroup.DEFAULT)) {
                        if ((WorldAccess) world instanceof ServerWorld _level)
                            _level.spawnParticles(ParticleTypes.END_ROD, x, y, z, 50, 0.5, 0.5, 0.5, 0.2);
                        SoundUtil.playSound(world, x, y, z, new Identifier(RainimatorMod.MOD_ID, "blue_diamond_skill_2"), 5, 1);
                        if (!_livEnt.world.isClient())
                            _livEnt.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 1200, 0));
                        entityiterator.setOnFireFor(10);
                        entity.getItemCooldownManager().set(itemstack.getItem(), 1000);
                        if (!entity.world.isClient())
                            entity.sendMessage(new TranslatableText("item.rainimator.blue_diamond_sword.skill2"), true);
                        if (((WorldAccess) world).isClient())
                            MinecraftClient.getInstance().gameRenderer.showFloatingItem(itemstack);

                        Runnable callback1 = () -> {
                            if (entityiterator.isAlive()) {
                                if (!world.isClient())
                                    world.createExplosion(null, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 2, Explosion.DestructionType.NONE);
                                entityiterator.damage(DamageSource.MAGIC, 5);
                            }
                        };
                        Timeout.create(40, callback1);
                        Timeout.create(80, callback1);
                        Timeout.create(120, callback1);
                        Timeout.create(160, callback1);
                        Timeout.create(200, callback1);
                    } else if (entityiterator instanceof LivingEntity _livEnt && (_livEnt.getGroup() == EntityGroup.UNDEAD || _livEnt.getGroup() == EntityGroup.ILLAGER)) {
                        entityiterator.setOnFireFor(10);
                        if (!_livEnt.world.isClient()) {
                            _livEnt.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 1200, 0));
                            _livEnt.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 160, 2));
                            _livEnt.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 160, 0));
                        }
                        SoundUtil.playSound(world, x, y, z, new Identifier(RainimatorMod.MOD_ID, "blue_diamond_skill_3"), 5, 1);
                        if (world instanceof ServerWorld _level)
                            _level.spawnParticles(ParticleTypes.END_ROD, x, y, z, 50, 0.5, 0.5, 0.5, 0.2);
                        entity.getItemCooldownManager().set(itemstack.getItem(), 1000);
                        if (!entity.world.isClient())
                            entity.sendMessage(new TranslatableText("item.rainimator.blue_diamond_sword.skill3"), true);
                        if (world.isClient())
                            MinecraftClient.getInstance().gameRenderer.showFloatingItem(itemstack);
                        Runnable callback1 = () -> {
                            if (world instanceof ServerWorld _level)
                                _level.spawnParticles((DefaultParticleType) ModParticles.FLOWER_WHITE, entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), 50, 0.5, 2, 0.5, 0.2);
                        };
                        Runnable callback2 = () -> {
                            entityiterator.requestTeleport(x + MathHelper.nextDouble(new Random(), -1, 1), y + 2, z + MathHelper.nextDouble(new Random(), -1, 1));
                            if (entityiterator instanceof ServerPlayerEntity _serverPlayer)
                                _serverPlayer.networkHandler.requestTeleport(x + MathHelper.nextDouble(new Random(), -1, 1), y + 2, z + MathHelper.nextDouble(new Random(), -1, 1), entityiterator.getYaw(), entityiterator.getPitch());
                        };
                        Runnable callback3 = () -> {
                            SoundUtil.playSound(world, x, y, z, new Identifier(RainimatorMod.MOD_ID, "blue_diamond_skill_4"), 5, 1);
                            callback1.run();
                            entityiterator.requestTeleport(x + MathHelper.nextDouble(new Random(), -1, 1), y + 2, z + MathHelper.nextDouble(new Random(), -1, 1));
                            if (entityiterator instanceof ServerPlayerEntity _serverPlayer)
                                _serverPlayer.networkHandler.requestTeleport(x + MathHelper.nextDouble(new Random(), -1, 1), y + 2, z + MathHelper.nextDouble(new Random(), -1, 1), entityiterator.getYaw(), entityiterator.getPitch());
                        };
                        Timeout.create(20, callback3);
                        Timeout.create(40, callback3);
                        Timeout.create(60, callback1);
                        Timeout.create(80, callback1);
                        Timeout.create(100, callback1);
                        Timeout.create(120, callback1);
                        Timeout.create(140, callback1);
                        Timeout.create(155, callback2);
                        Timeout.create(160, () -> {
                            if (entityiterator.isAlive()) {
                                if (world instanceof ServerWorld _level) {
                                    LightningEntity entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                                    if (entityToSpawn != null) {
                                        entityToSpawn.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(new BlockPos(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())));
                                        entityToSpawn.setCosmetic(true);
                                        _level.spawnEntity(entityToSpawn);
                                    }
                                }
                                if (!world.isClient())
                                    world.createExplosion(null, entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), 8, Explosion.DestructionType.NONE);
                                if (world instanceof ServerWorld _level)
                                    _level.spawnParticles((DefaultParticleType) ModParticles.LIGHTENING_ARC, entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), 50, 0.5, 1, 0.5, 0.2);
                            }
                        });
                    }
                }
            }
        }
        return ar;
    }

    @Override
    public boolean onSwingHand(ItemStack itemstack, World world, double x, double y, double z) {
        boolean retval = super.onSwingHand(itemstack, world, x, y, z);
        if (Math.random() < 0.2D)
            ParticleUtil.spawnCircleParticles(world, ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 2, 0, 50);
        return retval;
    }

    @Override
    public Episode getEpisode() {
        return Episode.Unknown;
    }
}