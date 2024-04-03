package com.rainimator.rainimatormod.registry;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.entity.*;
import com.rainimator.rainimatormod.util.ModConstants;
import com.rainimator.rainimatormod.util.SpawnBiome;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Difficulty;
import net.minecraft.world.Heightmap;

import java.util.Map;
import java.util.function.Supplier;

public class ModEntities {
    public static final EntityType<HerobrineEntity> HEROBRINE = register("herobrine", build(HerobrineEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<CerisEntity> CERIS = register("ceris", build(CerisEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<ZombiesEntity> ZOMBIES = register("zombies", build(ZombiesEntity::new, SpawnGroup.MONSTER, 32, 3, false, 0.6F, 1.8F));
    public static final EntityType<NaeusEntity> NAEUS = register("naeus", build(NaeusEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<RainEntity> RAIN = register("rain", build(RainEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F));
    public static final EntityType<RainEntityProjectile> RAIN_PROJECTILE = register("projectile_rain", build(RainEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F));
    public static final EntityType<AbigailEntity> ABIGAIL = register("abigail", build(AbigailEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<AbigailEntityProjectile> ABIGAIL_PROJECTILE = register("projectile_abigail", build(AbigailEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F));
    public static final EntityType<PatrickEntity> PATRICK = register("patrick", build(PatrickEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F));
    public static final EntityType<PatrickEntityProjectile> PATRICK_PROJECTILE = register("projectile_patrick", build(PatrickEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F));
    public static final EntityType<BlackBoneEntity> BLACKBONE = register("blackbone", build(BlackBoneEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<HogsworthEntity> HOGSWORTH = register("hogsworth", build(HogsworthEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<SoldiersEntity> SOLDIERS = register("soldiers", build(SoldiersEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F));
    public static final EntityType<SoldiersEntityProjectile> SOLDIERS_PROJECTILE = register("projectile_soldiers", build(SoldiersEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F));
    public static final EntityType<CiaraEntity> CIARA = register("ciara", build(CiaraEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F));
    public static final EntityType<CiaraEntityProjectile> CIARA_PROJECTILE = register("projectile_ciara", build(CiaraEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F));
    public static final EntityType<HildaEntity> HILDA = register("hilda", build(HildaEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F));
    public static final EntityType<HildaEntityProjectile> HILDA_PROJECTILE = register("projectile_hilda", build(HildaEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F));
    public static final EntityType<WitheredSkeletonsEntity> WITHERED_SKELETONS = register("withered_skeletons", build(WitheredSkeletonsEntity::new, SpawnGroup.MONSTER, 32, 3, true, 0.6F, 1.8F));
    public static final EntityType<EndStaffEntity> END_STAFF = register("projectile_end_staff", build(EndStaffEntity::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F));
    public static final EntityType<VordusEntity> VORDUS = register("vordus", build(VordusEntity::new, SpawnGroup.MONSTER, 64, 3, false, 0.6F, 1.8F));
    public static final EntityType<DarkZombieEntity> DARK_ZOMBIE = register("dark_zombie", build(DarkZombieEntity::new, SpawnGroup.MONSTER, 32, 3, false, 0.6F, 1.8F));
    public static final EntityType<DarkShieldEntity> DARK_SHIELD = register("dark_shield", build(DarkShieldEntity::new, SpawnGroup.MONSTER, 32, 3, false, 0.6F, 1.8F));
    public static final EntityType<WitherShieldEntity> WITHER_SHIELD = register("wither_shield", build(WitherShieldEntity::new, SpawnGroup.MONSTER, 32, 3, true, 0.6F, 1.8F));
    public static final EntityType<SkeletonSnowEntity> SKELETON_SNOW = register("skeleton_snow", build(SkeletonSnowEntity::new, SpawnGroup.MONSTER, 32, 3, false, 0.6F, 1.8F));
    public static final EntityType<ArabellaEntity> ARABELLA = register("arabella", build(ArabellaEntity::new, SpawnGroup.MONSTER, 64, 3, false, 0.6F, 1.8F));
    public static final EntityType<AzaleaEntity> AZALEA = register("azalea", build(AzaleaEntity::new, SpawnGroup.MONSTER, 64, 3, false, 0.6F, 1.8F));
    public static final EntityType<NullLikeEntity> NULL_LIKE = register("null_like", build(NullLikeEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<ZombiesPiglinKingEntity> ZOMBIE_PIGLIN_KING = register("zombie_piglin_king", build(ZombiesPiglinKingEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<PiglinKingZombiesEntity> PIGLIN_KING_ZOMBIES = register("piglin_king_zombies", build(PiglinKingZombiesEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<PiglinKingZombieEntity> PIGLIN_KING_ZOMBIE = register("piglin_king_zombie", build(PiglinKingZombieEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<PiglinCommanderEntity> PIGLIN_COMMANDER = register("piglin_commander", build(PiglinCommanderEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<DaryllEntity> DARYLL = register("daryll", build(DaryllEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F));
    public static final EntityType<DaryllEntityProjectile> DARYLL_PROJECTILE = register("projectile_daryll", build(DaryllEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F));
    public static final EntityType<NaeusKingEntity> NAEUS_KING = register("naeus_king", build(NaeusKingEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<TuskEntity> TUSK = register("tusk", build(TuskEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<BrotsEntity> BROTS = register("brots", build(BrotsEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<ZombiePiglinArtEntity> ZOMBIE_PIGLIN_ART = register("zombie_piglin_art", build(ZombiePiglinArtEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<MutatedEntity> MUTATED = register("mutated", build(MutatedEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<NamtarEntity> NAMTAR = register("namtar", build(NamtarEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<AgethaEntity> AGETHA = register("agetha", build(AgethaEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F));
    public static final EntityType<TricerEntity> TRICER = register("tricer", build(TricerEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<BigUndeadSkeletonEntity> BIG_UNDEAD_SKELETON = register("big_undead_skeleton", build(BigUndeadSkeletonEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<ArcherEntity> ARCHER = register("archer", build(ArcherEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F));
    public static final EntityType<GigaBoneEntity> GIGABONE = register("gigabone", build(GigaBoneEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<KlausEntity> KLAUS = register("klaus", build(KlausEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<Klaus2Entity> KLAUS_2 = register("klaus_2", build(Klaus2Entity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F));
    public static final EntityType<KralosEntity> KRALOS = register("kralos", build(KralosEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F));

    private static <T extends Entity> EntityType<T> register(String registryName, EntityType.Builder<T> entityTypeBuilder) {
        return register(registryName, () -> entityTypeBuilder.build(registryName));
    }

    private static <T extends Entity> EntityType.Builder<T> build(EntityType.EntityFactory<T> constructor, SpawnGroup category, int trackingRange, int updateInterval, boolean fireImmune, float sizeX, float sizeY) {
        EntityType.Builder<T> builder = EntityType.Builder.create(constructor, category).maxTrackingRange(trackingRange).trackingTickInterval(updateInterval).setDimensions(sizeX, sizeY);
        if (fireImmune) return builder.makeFireImmune();
        return builder;
    }

    private static <T extends Entity> EntityType<T> register(String name, Supplier<EntityType<T>> provider) {
        return register(name, provider.get());
    }

    private static <T extends Entity> EntityType<T> register(String name, EntityType<T> obj) {
        Registry.register(Registry.ENTITY_TYPE, new Identifier(RainimatorMod.MOD_ID, name), obj);
        return obj;
    }

    public static void init() {
        SpawnRestriction.register(ZOMBIES, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                (world.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(world, pos, random) && MobEntity.canMobSpawn(entityType, world, reason, pos, random)));
//        DungeonHooks.addDungeonMob(ZOMBIES, 180);
        SpawnRestriction.register(SOLDIERS, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                (world.getFluidState(pos.down()).isIn(FluidTags.WATER) && pos.getY() >= ModConstants.SEA_LEVEL - 13 && pos.getY() <= ModConstants.SEA_LEVEL));
        SpawnRestriction.register(HILDA, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                (world.getFluidState(pos.down()).isIn(FluidTags.WATER) && pos.getY() >= ModConstants.SEA_LEVEL - 13 && pos.getY() <= ModConstants.SEA_LEVEL));
        SpawnRestriction.register(WITHERED_SKELETONS, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                (world.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(world, pos, random) && MobEntity.canMobSpawn(entityType, world, reason, pos, random)));
        SpawnRestriction.register(DARK_ZOMBIE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                (world.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(world, pos, random) && MobEntity.canMobSpawn(entityType, world, reason, pos, random)));
        SpawnRestriction.register(DARK_SHIELD, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                (world.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(world, pos, random) && MobEntity.canMobSpawn(entityType, world, reason, pos, random)));
//        DungeonHooks.addDungeonMob(DARK_SHIELD, 180);
        SpawnRestriction.register(WITHER_SHIELD, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                (world.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(world, pos, random) && MobEntity.canMobSpawn(entityType, world, reason, pos, random)));
//        DungeonHooks.addDungeonMob(WITHER_SHIELD, 180);
        SpawnRestriction.register(SKELETON_SNOW, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                (world.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(world, pos, random) && MobEntity.canMobSpawn(entityType, world, reason, pos, random)));
        SpawnRestriction.register(TUSK, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                (world.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(world, pos, random) && MobEntity.canMobSpawn(entityType, world, reason, pos, random)));
//        DungeonHooks.addDungeonMob(TUSK, 180);
        SpawnRestriction.register(BROTS, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                (world.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(world, pos, random) && MobEntity.canMobSpawn(entityType, world, reason, pos, random)));
        SpawnRestriction.register(AGETHA, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                (world.getFluidState(pos.down()).isIn(FluidTags.WATER) && pos.getY() >= ModConstants.SEA_LEVEL - 13 && pos.getY() <= ModConstants.SEA_LEVEL));
        SpawnRestriction.register(ARCHER, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) ->
                (world.getFluidState(pos.down()).isIn(FluidTags.WATER) && pos.getY() >= ModConstants.SEA_LEVEL - 13 && pos.getY() <= ModConstants.SEA_LEVEL));

    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(HEROBRINE, HerobrineEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(CERIS, CerisEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ZOMBIES, ZombiesEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(NAEUS, NaeusEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(RAIN, RainEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ABIGAIL, AbigailEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(PATRICK, PatrickEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(BLACKBONE, BlackBoneEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(HOGSWORTH, HogsworthEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(SOLDIERS, SoldiersEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(CIARA, CiaraEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(HILDA, HildaEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(WITHERED_SKELETONS, WitheredSkeletonsEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(VORDUS, VordusEntity.createEndermanAttributes());
        FabricDefaultAttributeRegistry.register(DARK_ZOMBIE, DarkZombieEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(DARK_SHIELD, DarkShieldEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(WITHER_SHIELD, WitherShieldEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(SKELETON_SNOW, SkeletonSnowEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ARABELLA, ArabellaEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AZALEA, AzaleaEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(NULL_LIKE, NullLikeEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ZOMBIE_PIGLIN_KING, ZombiesPiglinKingEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(PIGLIN_KING_ZOMBIES, PiglinKingZombiesEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(PIGLIN_KING_ZOMBIE, PiglinKingZombieEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(PIGLIN_COMMANDER, PiglinCommanderEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(DARYLL, DaryllEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(NAEUS_KING, NaeusKingEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(TUSK, TuskEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(BROTS, BrotsEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ZOMBIE_PIGLIN_ART, ZombiePiglinArtEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(MUTATED, MutatedEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(NAMTAR, NamtarEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AGETHA, AgethaEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(TRICER, TricerEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(BIG_UNDEAD_SKELETON, BigUndeadSkeletonEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ARCHER, ArcherEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(GIGABONE, GigaBoneEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(KLAUS, KlausEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(KLAUS_2, Klaus2Entity.createAttributes());
        FabricDefaultAttributeRegistry.register(KRALOS, KralosEntity.createAttributes());
    }

    public static void addLivingEntityToBiomes() {
        BiomeModifications.addSpawn(context -> SpawnBiome.COMMON_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.UNDERGROUND_WATER_CREATURE, ModEntities.AGETHA, 10, 1, 1);
        BiomeModifications.addSpawn(context -> SpawnBiome.COMMON_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.UNDERGROUND_WATER_CREATURE, ModEntities.ARCHER, 10, 1, 1);
        BiomeModifications.addSpawn(context -> SpawnBiome.COMMON_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.MONSTER, ModEntities.BROTS, 5, 1, 1);
        BiomeModifications.addSpawn(context -> SpawnBiome.END_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.MONSTER, ModEntities.DARK_SHIELD, 1, 1, 1);
        BiomeModifications.addSpawn(context -> SpawnBiome.COMMON_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.MONSTER, ModEntities.DARK_ZOMBIE, 10, 1, 1);
        BiomeModifications.addSpawn(context -> SpawnBiome.COMMON_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.UNDERGROUND_WATER_CREATURE, ModEntities.HILDA, 10, 1, 1);
        BiomeModifications.addSpawn(context -> SpawnBiome.SNOW_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.MONSTER, ModEntities.SKELETON_SNOW, 10, 1, 1);
        BiomeModifications.addSpawn(context -> SpawnBiome.COMMON_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.UNDERGROUND_WATER_CREATURE, ModEntities.SOLDIERS, 10, 1, 1);
        BiomeModifications.addSpawn(context -> SpawnBiome.COMMON_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.MONSTER, ModEntities.TUSK, 5, 1, 1);
        BiomeModifications.addSpawn(context -> new Identifier("nether_wastes").equals(context.getBiomeKey().getValue()), SpawnGroup.MONSTER, ModEntities.WITHERED_SKELETONS, 19, 2, 2);
        BiomeModifications.addSpawn(context -> SpawnBiome.COMMON_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.MONSTER, ModEntities.WITHER_SHIELD, 3, 1, 1);
        BiomeModifications.addSpawn(context -> SpawnBiome.COMMON_SPAWN_BIOMES.contains(context.getBiomeKey().getValue()), SpawnGroup.MONSTER, ModEntities.ZOMBIES, 10, 1, 1);
    }
}
