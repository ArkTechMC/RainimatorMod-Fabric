package com.rainimator.rainimatormod.item;

import com.iafenvoy.mcrconvertlib.item.FoilItemBase;
import com.iafenvoy.mcrconvertlib.misc.Timeout;
import com.iafenvoy.mcrconvertlib.world.SoundUtil;
import com.rainimator.rainimatormod.network.ManaComponent;
import com.rainimator.rainimatormod.registry.ModGameRules;
import com.rainimator.rainimatormod.registry.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.Comparator;
import java.util.List;

public class SoulTotemItem extends FoilItemBase {
    public SoulTotemItem() {
        super(p -> p.maxCount(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        TypedActionResult<ItemStack> ar = super.use(world, entity, hand);
        if (!ManaComponent.tryUse(entity, world.getGameRules().get(ModGameRules.soul_totem).get())) return ar;
        ItemStack itemtack = ar.getValue();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();

        if (entity.isOnGround()) {
            if (world.isClient())
                (MinecraftClient.getInstance()).gameRenderer.showFloatingItem(itemtack);
            SoundUtil.playSound(world, x, y, z, new Identifier("block.anvil.land"), 5.0F, 1.0F);
            if (world instanceof ServerWorld _level)
                _level.spawnParticles((ParticleEffect) ParticleTypes.END_ROD, x, y, z, 100, 3.0D, 4.0D, 3.0D, 0.002D);
            if (!entity.getWorld().isClient())
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 140, 4));
            entity.getItemCooldownManager().set(itemtack.getItem(), 400);

            Timeout.create(100, () -> {
                if (!entity.getWorld().isClient())
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 300, 1));
            });
        } else {
            if (((WorldAccess) world).isClient())
                (MinecraftClient.getInstance()).gameRenderer.showFloatingItem(itemtack);
            SoundUtil.playSound(world, x, y, z, new Identifier("block.anvil.land"), 5.0F, 1.0F);
            if (world instanceof ServerWorld _level)
                _level.spawnParticles((ParticleEffect) ParticleTypes.END_ROD, x, y, z, 100, 3.0D, 4.0D, 3.0D, 0.002D);
            if (!entity.getWorld().isClient())
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 400, 0));
            entity.getItemCooldownManager().set(itemtack.getItem(), 600);
        }
        return ar;
    }

    @Override
    public void inventoryTick(ItemStack itemtack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemtack, world, entity, slot, selected);
        if (selected) {
            Vec3d _center = new Vec3d(entity.getX(), entity.getY(), entity.getZ());
            List<Entity> _entfound = world.getEntitiesByClass(Entity.class, new Box(_center, _center).expand(5.0d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.squaredDistanceTo(_center))).toList();
            for (Entity entity1 : _entfound) {
                if ((WorldAccess) world instanceof World _lvl) {
                    if (_lvl.isDay()) {
                        if (entity1 instanceof PlayerEntity _entity) {
                            if (!_entity.getWorld().isClient())
                                _entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0));
                        } else if (entity1 instanceof HostileEntity _entity2)
                            if (!_entity2.getWorld().isClient())
                                _entity2.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0));
                    }
                }
            }
        }
        if (entity instanceof PlayerEntity _playerHasItem && _playerHasItem.getInventory().contains(new ItemStack(ModItems.SOUL_TOTEM))) {
            if (world.isDay()) {
                LivingEntity _entity = (LivingEntity) entity;
                if (!_entity.getWorld().isClient())
                    _entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 100, 1));
                if (Math.random() < 0.005)
                    if (!world.isClient())
                        world.spawnEntity(new ExperienceOrbEntity(world, entity.getX(), entity.getY(), entity.getZ(), 1));
            }
        }
    }
}
