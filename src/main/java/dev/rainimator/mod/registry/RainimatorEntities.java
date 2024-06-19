package dev.rainimator.mod.registry;

import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.entity.*;
import dev.rainimator.mod.util.ModConstants;
import dev.rainimator.mod.util.SpawnBiome;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.Difficulty;
import net.minecraft.world.Heightmap;

public class RainimatorEntities {
    public static final EntityType<HerobrineEntity> HEROBRINE = build("herobrine", HerobrineEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<CerisEntity> CERIS = build("ceris", CerisEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<ZombiesEntity> ZOMBIES = build("zombies", ZombiesEntity::new, SpawnGroup.MONSTER, 32, 3, false, 0.6F, 1.8F);
    public static final EntityType<NaeusEntity> NAEUS = build("naeus", NaeusEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<RainEntity> RAIN = build("rain", RainEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<RainEntityProjectile> RAIN_PROJECTILE = build("rain_projectile", RainEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F);
    public static final EntityType<AbigailEntity> ABIGAIL = build("abigail", AbigailEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<AbigailEntityProjectile> ABIGAIL_PROJECTILE = build("abigail_projectile", AbigailEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F);
    public static final EntityType<PatrickEntity> PATRICK = build("patrick", PatrickEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<PatrickEntityProjectile> PATRICK_PROJECTILE = build("patrick_projectile", PatrickEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F);
    public static final EntityType<BlackBoneEntity> BLACKBONE = build("blackbone", BlackBoneEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<HogsworthEntity> HOGSWORTH = build("hogsworth", HogsworthEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<SoldiersEntity> SOLDIERS = build("soldiers", SoldiersEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<SoldiersEntityProjectile> SOLDIERS_PROJECTILE = build("soldiers_projectile", SoldiersEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F);
    public static final EntityType<CiaraEntity> CIARA = build("ciara", CiaraEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<CiaraEntityProjectile> CIARA_PROJECTILE = build("ciara_projectile", CiaraEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F);
    public static final EntityType<HildaEntity> HILDA = build("hilda", HildaEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<HildaEntityProjectile> HILDA_PROJECTILE = build("hilda_projectile", HildaEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F);
    public static final EntityType<WitheredSkeletonsEntity> WITHERED_SKELETONS = build("withered_skeletons", WitheredSkeletonsEntity::new, SpawnGroup.MONSTER, 32, 3, true, 0.6F, 1.8F);
    public static final EntityType<EndStaffEntity> END_STAFF = build("end_staff", EndStaffEntity::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F);
    public static final EntityType<VordusEntity> VORDUS = build("vordus", VordusEntity::new, SpawnGroup.MONSTER, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<DarkZombieEntity> DARK_ZOMBIE = build("dark_zombie", DarkZombieEntity::new, SpawnGroup.MONSTER, 32, 3, false, 0.6F, 1.8F);
    public static final EntityType<DarkShieldEntity> DARK_SHIELD = build("dark_shield", DarkShieldEntity::new, SpawnGroup.MONSTER, 32, 3, false, 0.6F, 1.8F);
    public static final EntityType<WitherShieldEntity> WITHER_SHIELD = build("wither_shield", WitherShieldEntity::new, SpawnGroup.MONSTER, 32, 3, true, 0.6F, 1.8F);
    public static final EntityType<SkeletonSnowEntity> SKELETON_SNOW = build("skeleton_snow", SkeletonSnowEntity::new, SpawnGroup.MONSTER, 32, 3, false, 0.6F, 1.8F);
    public static final EntityType<ArabellaEntity> ARABELLA = build("arabella", ArabellaEntity::new, SpawnGroup.MONSTER, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<AzaleaEntity> AZALEA = build("azalea", AzaleaEntity::new, SpawnGroup.MONSTER, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<NullLikeEntity> NULL_LIKE = build("null_like", NullLikeEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<ZombiesPiglinKingEntity> ZOMBIE_PIGLIN_KING = build("zombie_piglin_king", ZombiesPiglinKingEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<PiglinKingZombiesEntity> PIGLIN_KING_ZOMBIES = build("piglin_king_zombies", PiglinKingZombiesEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<PiglinKingZombieEntity> PIGLIN_KING_ZOMBIE = build("piglin_king_zombie", PiglinKingZombieEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<PiglinCommanderEntity> PIGLIN_COMMANDER = build("piglin_commander", PiglinCommanderEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<DaryllEntity> DARYLL = build("daryll", DaryllEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<DaryllEntityProjectile> DARYLL_PROJECTILE = build("daryll_projectile", DaryllEntityProjectile::new, SpawnGroup.MISC, 64, 1, false, 0.5F, 0.5F);
    public static final EntityType<NaeusKingEntity> NAEUS_KING = build("naeus_king", NaeusKingEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<TuskEntity> TUSK = build("tusk", TuskEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<BrotsEntity> BROTS = build("brots", BrotsEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<ZombiePiglinArtEntity> ZOMBIE_PIGLIN_ART = build("zombie_piglin_art", ZombiePiglinArtEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<MutatedEntity> MUTATED = build("mutated", MutatedEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<NamtarEntity> NAMTAR = build("namtar", NamtarEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<AgethaEntity> AGETHA = build("agetha", AgethaEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<TricerEntity> TRICER = build("tricer", TricerEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<BigUndeadSkeletonEntity> BIG_UNDEAD_SKELETON = build("bug_undead_skeleton", BigUndeadSkeletonEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<ArcherEntity> ARCHER = build("archer", ArcherEntity::new, SpawnGroup.UNDERGROUND_WATER_CREATURE, 64, 3, false, 0.6F, 1.8F);
    public static final EntityType<GigaBoneEntity> GIGABONE = build("gigabone", GigaBoneEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<KlausEntity> KLAUS = build("klaus", KlausEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<Klaus2Entity> KLAUS_2 = build("klaus_2", Klaus2Entity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);
    public static final EntityType<KralosEntity> KRALOS = build("kralos", KralosEntity::new, SpawnGroup.MONSTER, 64, 3, true, 0.6F, 1.8F);

    private static <T extends Entity> EntityType<T> build(String name, EntityType.EntityFactory<T> constructor, SpawnGroup category, int trackingRange, int updateInterval, boolean fireImmune, float sizeX, float sizeY) {
        FabricEntityTypeBuilder<T> builder = FabricEntityTypeBuilder.create(category, constructor).trackRangeBlocks(trackingRange).trackedUpdateRate(updateInterval).dimensions(EntityDimensions.fixed(sizeX, sizeY));
        if (fireImmune) builder.fireImmune();
        return register(name, builder.build());
    }

    private static <T extends Entity> EntityType<T> register(String name, EntityType<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, new Identifier(RainimatorMod.MOD_ID, name), type);
    }

    public static void init() {
        registerAttributes();
        addSpawner();
        addLivingEntityToBiomes();
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(HEROBRINE, HerobrineEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(CERIS, CerisEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ZOMBIES, ZombiesEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(NAEUS, NaeusEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(RAIN, RainEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ABIGAIL, AbigailEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(PATRICK, PatrickEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(BLACKBONE, BlackBoneEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(HOGSWORTH, HogsworthEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(CIARA, CiaraEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(HILDA, HildaEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(SOLDIERS, SoldiersEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(WITHERED_SKELETONS, WitheredSkeletonsEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(DARK_SHIELD, DarkShieldEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(DARK_ZOMBIE, DarkZombieEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(VORDUS, VordusEntity.createEndermanAttributes());
        FabricDefaultAttributeRegistry.register(WITHER_SHIELD, WitherShieldEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(SKELETON_SNOW, SkeletonSnowEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ZOMBIE_PIGLIN_KING, ZombiesPiglinKingEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(PIGLIN_KING_ZOMBIES, PiglinKingZombiesEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(PIGLIN_KING_ZOMBIE, PiglinKingZombieEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(PIGLIN_COMMANDER, PiglinCommanderEntity.createAttributes());
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
        FabricDefaultAttributeRegistry.register(DARYLL, DaryllEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(NULL_LIKE, NullLikeEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(GIGABONE, GigaBoneEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(KLAUS, KlausEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(KLAUS_2, Klaus2Entity.createAttributes());
        FabricDefaultAttributeRegistry.register(KRALOS, KralosEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ARABELLA, ArabellaEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AZALEA, AzaleaEntity.createAttributes());
    }

    private static void addSpawner() {
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

    private static void addLivingEntityToBiomes() {
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
