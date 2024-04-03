package com.rainimator.rainimatormod.item;

import com.rainimator.rainimatormod.registry.ModParticles;
import com.rainimator.rainimatormod.registry.util.FoilItemBase;
import com.rainimator.rainimatormod.registry.util.ModCreativeTab;
import com.rainimator.rainimatormod.util.SoundUtil;
import com.rainimator.rainimatormod.util.Timeout;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Random;

public class MagicEnderPearlItem extends FoilItemBase {
    public MagicEnderPearlItem() {
        super(p -> p.group(ModCreativeTab.items).maxDamage(40).fireproof().rarity(Rarity.RARE));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        TypedActionResult<ItemStack> ar = super.use(world, entity, hand);
        ItemStack itemstack = ar.getValue();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();

        SoundUtil.playSound(world, x, y, z, new Identifier("entity.ender_pearl.throw"), 1, 1);

        if (world instanceof ServerWorld _level)
            _level.spawnParticles((ParticleEffect) ModParticles.PURPLE_LIGHT, x, y, z, 30, 0.5D, 1.0D, 0.5D, 0.02D);
        if (entity.isSprinting()) {
            World projectileLevel = entity.world;
            if (!projectileLevel.isClient()) {
                ProjectileEntity _entityToSpawn = new EnderPearlEntity(EntityType.ENDER_PEARL, projectileLevel);
                _entityToSpawn.setOwner(entity);
                _entityToSpawn.setPosition(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
                _entityToSpawn.setVelocity((entity.getRotationVector()).x, (entity.getRotationVector()).y, (entity.getRotationVector()).z, 2.0F, 0.0F);
                projectileLevel.spawnEntity(_entityToSpawn);
            }

            entity.getItemCooldownManager().set(itemstack.getItem(), 100);

            if (itemstack.damage(1, new Random(), null)) {
                itemstack.decrement(1);
                itemstack.setDamage(0);
            }

        } else {
            World projectileLevel = entity.world;
            if (!projectileLevel.isClient()) {
                ProjectileEntity _entityToSpawn = new EnderPearlEntity(EntityType.ENDER_PEARL, projectileLevel);
                _entityToSpawn.setOwner(entity);
                _entityToSpawn.setPosition(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
                _entityToSpawn.setVelocity((entity.getRotationVector()).x, (entity.getRotationVector()).y, (entity.getRotationVector()).z, 1.5F, 0.0F);
                projectileLevel.spawnEntity(_entityToSpawn);
            }

            if (entity instanceof PlayerEntity)
                entity.getItemCooldownManager().set(itemstack.getItem(), 80);

            if (itemstack.damage(1, new Random(), null)) {
                itemstack.decrement(1);
                itemstack.setDamage(0);
            }
        }
        if (entity.isSneaking()) {

            World projectileLevel = entity.world;
            if (!projectileLevel.isClient()) {
                ProjectileEntity _entityToSpawn = new EnderPearlEntity(EntityType.ENDER_PEARL, projectileLevel);
                _entityToSpawn.setOwner(entity);
                _entityToSpawn.setPosition(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
                _entityToSpawn.setVelocity((entity.getRotationVector()).x, (entity.getRotationVector()).y, (entity.getRotationVector()).z, 1.5F, 0.0F);
                projectileLevel.spawnEntity(_entityToSpawn);
            }

            entity.getItemCooldownManager().set(itemstack.getItem(), 300);

            if (itemstack.damage(1, new Random(), null)) {
                itemstack.decrement(1);
                itemstack.setDamage(0);
            }

            Timeout.create(200, () -> {
                entity.requestTeleport(x, y, z);
                if ((Entity) entity instanceof ServerPlayerEntity _serverPlayer)
                    _serverPlayer.networkHandler.requestTeleport(x, y, z, entity.getYaw(), entity.getPitch());
                SoundUtil.playSound(world, x, y, z, new Identifier("entity.enderman.teleport"), 1.0F, 1.0F);
                if (world instanceof ServerWorld) {
                    ((ServerWorld) world).spawnParticles((ParticleEffect) ModParticles.PURPLE_LIGHT, x, y, z, 50, 0.5D, 1.0D, 0.5D, 0.02D);
                }
            });
        }
        return ar;
    }
}
