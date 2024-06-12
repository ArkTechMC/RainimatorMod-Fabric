package dev.rainimator.mod.registry;

import com.iafenvoy.annotationlib.annotation.CallbackHandler;
import com.iafenvoy.annotationlib.annotation.ModId;
import com.iafenvoy.annotationlib.annotation.registration.RegisterAll;
import com.iafenvoy.annotationlib.api.IAnnotatedRegistryEntry;
import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.entity.*;
import dev.rainimator.mod.util.ModConstants;
import dev.rainimator.mod.util.SpawnBiome;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.Difficulty;
import net.minecraft.world.Heightmap;

@ModId(RainimatorMod.MOD_ID)
@RegisterAll
public class RainimatorEntities implements IAnnotatedRegistryEntry {
    public static final EntityType<HerobrineEntity> HEROBRINE = build(HerobrineEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<CerisEntity> CERIS = build(CerisEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<ZombiesEntity> ZOMBIES = build(ZombiesEntity::new, SpawnGroup.MONSTER, 32, 3, false, 0.6F, 1.8F);
    public static final EntityType<NaeusEntity> NAEUS = build(NaeusEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<RainEntity> RAIN = build(RainEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<RainEntityProjectile> RAIN_PROJECTILE = build(RainEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F);
    public static final EntityType<AbigailEntity> ABIGAIL = build(AbigailEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<AbigailEntityProjectile> ABIGAIL_PROJECTILE = build(AbigailEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F);
    public static final EntityType<PatrickEntity> PATRICK = build(PatrickEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<PatrickEntityProjectile> PATRICK_PROJECTILE = build(PatrickEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F);
    public static final EntityType<BlackBoneEntity> BLACKBONE = build(BlackBoneEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<HogsworthEntity> HOGSWORTH = build(HogsworthEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<SoldiersEntity> SOLDIERS = build(SoldiersEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<SoldiersEntityProjectile> SOLDIERS_PROJECTILE = build(SoldiersEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F);
    public static final EntityType<CiaraEntity> CIARA = build(CiaraEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<CiaraEntityProjectile> CIARA_PROJECTILE = build(CiaraEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F);
    public static final EntityType<HildaEntity> HILDA = build(HildaEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<HildaEntityProjectile> HILDA_PROJECTILE = build(HildaEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F);
    public static final EntityType<WitheredSkeletonsEntity> WITHERED_SKELETONS = build(WitheredSkeletonsEntity::new, SpawnGroup.MONSTER, 32, 3, true, 0.6F, 1.8F);
    public static final EntityType<EndStaffEntity> END_STAFF = build(EndStaffEntity::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F);
    public static final EntityType<VordusEntity> VORDUS = build(VordusEntity::new, SpawnGroup.MONSTER, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<DarkZombieEntity> DARK_ZOMBIE = build(DarkZombieEntity::new, SpawnGroup.MONSTER, 32, 3, false, 0.6F, 1.8F);
    public static final EntityType<DarkShieldEntity> DARK_SHIELD = build(DarkShieldEntity::new, SpawnGroup.MONSTER, 32, 3, false, 0.6F, 1.8F);
    public static final EntityType<WitherShieldEntity> WITHER_SHIELD = build(WitherShieldEntity::new, SpawnGroup.MONSTER, 32, 3, true, 0.6F, 1.8F);
    public static final EntityType<SkeletonSnowEntity> SKELETON_SNOW = build(SkeletonSnowEntity::new, SpawnGroup.MONSTER, 32, 3, false, 0.6F, 1.8F);
    public static final EntityType<ArabellaEntity> ARABELLA = build(ArabellaEntity::new, SpawnGroup.MONSTER, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<AzaleaEntity> AZALEA = build(AzaleaEntity::new, SpawnGroup.MONSTER, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<NullLikeEntity> NULL_LIKE = build(NullLikeEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<ZombiesPiglinKingEntity> ZOMBIE_PIGLIN_KING = build(ZombiesPiglinKingEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<PiglinKingZombiesEntity> PIGLIN_KING_ZOMBIES = build(PiglinKingZombiesEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<PiglinKingZombieEntity> PIGLIN_KING_ZOMBIE = build(PiglinKingZombieEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<PiglinCommanderEntity> PIGLIN_COMMANDER = build(PiglinCommanderEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<DaryllEntity> DARYLL = build(DaryllEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<DaryllEntityProjectile> DARYLL_PROJECTILE = build(DaryllEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F);
    public static final EntityType<NaeusKingEntity> NAEUS_KING = build(NaeusKingEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<TuskEntity> TUSK = build(TuskEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<BrotsEntity> BROTS = build(BrotsEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<ZombiePiglinArtEntity> ZOMBIE_PIGLIN_ART = build(ZombiePiglinArtEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<MutatedEntity> MUTATED = build(MutatedEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<NamtarEntity> NAMTAR = build(NamtarEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<AgethaEntity> AGETHA = build(AgethaEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<TricerEntity> TRICER = build(TricerEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<BigUndeadSkeletonEntity> BIG_UNDEAD_SKELETON = build(BigUndeadSkeletonEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<ArcherEntity> ARCHER = build(ArcherEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<GigaBoneEntity> GIGABONE = build(GigaBoneEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<KlausEntity> KLAUS = build(KlausEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<Klaus2Entity> KLAUS_2 = build(Klaus2Entity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<KralosEntity> KRALOS = build(KralosEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);

    public static <T extends Entity> EntityType<T> build(EntityType.EntityFactory<T> constructor, SpawnGroup category, int trackingRange, int updateInterval, boolean fireImmune, float sizeX, float sizeY) {
        FabricEntityTypeBuilder<T> builder = FabricEntityTypeBuilder.create(category, constructor).trackRangeBlocks(trackingRange).trackedUpdateRate(updateInterval).dimensions(EntityDimensions.fixed(sizeX, sizeY));
        if (fireImmune) {
            builder.fireImmune();
        }

        return builder.build();
    }

    @CallbackHandler
    public static void init() {
        SpawnRestriction.register(ZOMBIES, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                world.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(world, pos, random) && MobEntity.canMobSpawn(entityType, world, reason, pos, random));
//        DungeonHooks.addDungeonMob(ZOMBIES, 180);
        SpawnRestriction.register(SOLDIERS, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                world.getFluidState(pos.down()).isIn(FluidTags.WATER) && pos.getY() >= ModConstants.SEA_LEVEL - 13 && pos.getY() <= ModConstants.SEA_LEVEL);
        SpawnRestriction.register(HILDA, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                world.getFluidState(pos.down()).isIn(FluidTags.WATER) && pos.getY() >= ModConstants.SEA_LEVEL - 13 && pos.getY() <= ModConstants.SEA_LEVEL);
        SpawnRestriction.register(WITHERED_SKELETONS, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                world.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(world, pos, random) && MobEntity.canMobSpawn(entityType, world, reason, pos, random));
        SpawnRestriction.register(DARK_ZOMBIE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                world.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(world, pos, random) && MobEntity.canMobSpawn(entityType, world, reason, pos, random));
        SpawnRestriction.register(DARK_SHIELD, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                world.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(world, pos, random) && MobEntity.canMobSpawn(entityType, world, reason, pos, random));
//        DungeonHooks.addDungeonMob(DARK_SHIELD, 180);
        SpawnRestriction.register(WITHER_SHIELD, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                world.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(world, pos, random) && MobEntity.canMobSpawn(entityType, world, reason, pos, random));
//        DungeonHooks.addDungeonMob(WITHER_SHIELD, 180);
        SpawnRestriction.register(SKELETON_SNOW, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                world.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(world, pos, random) && MobEntity.canMobSpawn(entityType, world, reason, pos, random));
        SpawnRestriction.register(TUSK, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                world.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(world, pos, random) && MobEntity.canMobSpawn(entityType, world, reason, pos, random));
//        DungeonHooks.addDungeonMob(TUSK, 180);
        SpawnRestriction.register(BROTS, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                world.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(world, pos, random) && MobEntity.canMobSpawn(entityType, world, reason, pos, random));
        SpawnRestriction.register(AGETHA, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                world.getFluidState(pos.down()).isIn(FluidTags.WATER) && pos.getY() >= ModConstants.SEA_LEVEL - 13 && pos.getY() <= ModConstants.SEA_LEVEL);
        SpawnRestriction.register(ARCHER, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                world.getFluidState(pos.down()).isIn(FluidTags.WATER) && pos.getY() >= ModConstants.SEA_LEVEL - 13 && pos.getY() <= ModConstants.SEA_LEVEL);
    }

    @CallbackHandler
    public static void addLivingEntityToBiomes() {
        BiomeModifications.addSpawn(context -> SpawnBiome.COMMON_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.UNDERGROUND_WATER_CREATURE, RainimatorEntities.AGETHA, 10, 1, 1);
        BiomeModifications.addSpawn(context -> SpawnBiome.COMMON_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.UNDERGROUND_WATER_CREATURE, RainimatorEntities.ARCHER, 10, 1, 1);
        BiomeModifications.addSpawn(context -> SpawnBiome.COMMON_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.MONSTER, RainimatorEntities.BROTS, 5, 1, 1);
        BiomeModifications.addSpawn(context -> SpawnBiome.END_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.MONSTER, RainimatorEntities.DARK_SHIELD, 1, 1, 1);
        BiomeModifications.addSpawn(context -> SpawnBiome.COMMON_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.MONSTER, RainimatorEntities.DARK_ZOMBIE, 10, 1, 1);
        BiomeModifications.addSpawn(context -> SpawnBiome.COMMON_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.UNDERGROUND_WATER_CREATURE, RainimatorEntities.HILDA, 10, 1, 1);
        BiomeModifications.addSpawn(context -> SpawnBiome.SNOW_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.MONSTER, RainimatorEntities.SKELETON_SNOW, 10, 1, 1);
        BiomeModifications.addSpawn(context -> SpawnBiome.COMMON_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.UNDERGROUND_WATER_CREATURE, RainimatorEntities.SOLDIERS, 10, 1, 1);
        BiomeModifications.addSpawn(context -> SpawnBiome.COMMON_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.MONSTER, RainimatorEntities.TUSK, 5, 1, 1);
        BiomeModifications.addSpawn(context -> new Identifier("nether_wastes").equals(context.getBiomeKey().getValue()), SpawnGroup.MONSTER, RainimatorEntities.WITHERED_SKELETONS, 19, 2, 2);
        BiomeModifications.addSpawn(context -> SpawnBiome.COMMON_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.MONSTER, RainimatorEntities.WITHER_SHIELD, 3, 1, 1);
        BiomeModifications.addSpawn(context -> SpawnBiome.COMMON_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.MONSTER, RainimatorEntities.ZOMBIES, 10, 1, 1);
    }

    @Environment(EnvType.CLIENT)
    @CallbackHandler(environment = EnvType.CLIENT)
    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(HEROBRINE, HerobrineEntity.texture::createRenderer);
        EntityRendererRegistry.register(CERIS, CerisEntity.texture::createRenderer);
        EntityRendererRegistry.register(ZOMBIES, ZombiesEntity.texture::createRenderer);
        EntityRendererRegistry.register(NAEUS, NaeusEntity.texture::createRenderer);
        EntityRendererRegistry.register(RAIN, RainEntity.texture::createRenderer);
        EntityRendererRegistry.register(RAIN_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ABIGAIL, AbigailEntity.texture::createRenderer);
        EntityRendererRegistry.register(ABIGAIL_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(PATRICK, PatrickEntity.texture::createRenderer);
        EntityRendererRegistry.register(PATRICK_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(BLACKBONE, BlackBoneEntity.texture::createRenderer);
        EntityRendererRegistry.register(HOGSWORTH, HogsworthEntity.texture::createRenderer);
        EntityRendererRegistry.register(SOLDIERS, SoldiersEntity.texture::createRenderer);
        EntityRendererRegistry.register(SOLDIERS_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(CIARA, CiaraEntity.texture::createRenderer);
        EntityRendererRegistry.register(CIARA_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(HILDA, HildaEntity.texture::createRenderer);
        EntityRendererRegistry.register(HILDA_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(WITHERED_SKELETONS, WitheredSkeletonsEntity.texture::createRenderer);
        EntityRendererRegistry.register(END_STAFF, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(VORDUS, VordusEntity.texture::createRenderer);
        EntityRendererRegistry.register(DARK_ZOMBIE, DarkZombieEntity.texture::createRenderer);
        EntityRendererRegistry.register(DARK_SHIELD, DarkShieldEntity.texture::createRenderer);
        EntityRendererRegistry.register(WITHER_SHIELD, WitherShieldEntity.texture::createRenderer);
        EntityRendererRegistry.register(SKELETON_SNOW, SkeletonSnowEntity.texture::createRenderer);
        EntityRendererRegistry.register(ARABELLA, ArabellaEntity.texture::createRenderer);
        EntityRendererRegistry.register(AZALEA, AzaleaEntity.texture::createRenderer);
        EntityRendererRegistry.register(NULL_LIKE, NullLikeEntity.texture::createRenderer);
        EntityRendererRegistry.register(ZOMBIE_PIGLIN_KING, ZombiesPiglinKingEntity.texture::createRenderer);
        EntityRendererRegistry.register(PIGLIN_KING_ZOMBIES, PiglinKingZombiesEntity.texture::createRenderer);
        EntityRendererRegistry.register(PIGLIN_KING_ZOMBIE, PiglinKingZombieEntity.texture::createRenderer);
        EntityRendererRegistry.register(PIGLIN_COMMANDER, PiglinCommanderEntity.texture::createRenderer);
        EntityRendererRegistry.register(DARYLL, DaryllEntity.texture::createRenderer);
        EntityRendererRegistry.register(DARYLL_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(NAEUS_KING, NaeusKingEntity.texture::createRenderer);
        EntityRendererRegistry.register(TUSK, TuskEntity.texture::createRenderer);
        EntityRendererRegistry.register(BROTS, BrotsEntity.texture::createRenderer);
        EntityRendererRegistry.register(ZOMBIE_PIGLIN_ART, ZombiePiglinArtEntity.texture::createRenderer);
        EntityRendererRegistry.register(MUTATED, MutatedEntity.texture::createRenderer);
        EntityRendererRegistry.register(NAMTAR, NamtarEntity.texture::createRenderer);
        EntityRendererRegistry.register(AGETHA, AgethaEntity.texture::createRenderer);
        EntityRendererRegistry.register(TRICER, TricerEntity.texture::createRenderer);
        EntityRendererRegistry.register(BIG_UNDEAD_SKELETON, BigUndeadSkeletonEntity.texture::createRenderer);
        EntityRendererRegistry.register(ARCHER, ArcherEntity.texture::createRenderer);
        EntityRendererRegistry.register(GIGABONE, GigaBoneEntity.texture::createRenderer);
        EntityRendererRegistry.register(KLAUS, KlausEntity.texture::createRenderer);
        EntityRendererRegistry.register(KLAUS_2, Klaus2Entity.texture::createRenderer);
        EntityRendererRegistry.register(KRALOS, KralosEntity.texture::createRenderer);
    }
}
