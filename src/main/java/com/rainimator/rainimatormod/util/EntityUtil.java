package com.rainimator.rainimatormod.util;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class EntityUtil {
    public static <M extends MobEntity> void summon(EntityType<M> entityType, ServerWorld world, Vec3d vec3) {
        summon(entityType, world, vec3.x, vec3.y, vec3.z);
    }

    public static <M extends MobEntity> void summon(EntityType<M> entityType, ServerWorld world, double x, double y, double z) {
        MobEntity entityToSpawn = entityType.create(world);
        if (entityToSpawn != null) {
            entityToSpawn.refreshPositionAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
            entityToSpawn.initialize(world, world.getLocalDifficulty(entityToSpawn.getBlockPos()), SpawnReason.MOB_SUMMONED, null, null);
            world.spawnEntity(entityToSpawn);
        }
    }
}
