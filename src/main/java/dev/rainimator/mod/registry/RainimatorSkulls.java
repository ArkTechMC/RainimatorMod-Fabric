package dev.rainimator.mod.registry;

import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.entity.*;
import dev.rainimator.mod.renderer.util.SkullRenderRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SkullBlock;
import net.minecraft.block.WallSkullBlock;
import net.minecraft.item.Item;
import net.minecraft.item.SkullItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RainimatorSkulls {
    public static final Block HEROBRINE_HEAD = register("herobrine_head", new SkullBlock(RainimatorSkulls.SkullType.HEROBRINE, AbstractBlock.Settings.create()));
    public static final Block HEROBRINE_WALL_HEAD = register("herobrine_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.HEROBRINE, AbstractBlock.Settings.create()));
    public static final Block CERIS_HEAD = register("ceris_head", new SkullBlock(RainimatorSkulls.SkullType.CERIS, AbstractBlock.Settings.create()));
    public static final Block CERIS_WALL_HEAD = register("ceris_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.CERIS, AbstractBlock.Settings.create()));
    public static final Block ZOMBIES_HEAD = register("zombies_head", new SkullBlock(RainimatorSkulls.SkullType.ZOMBIES, AbstractBlock.Settings.create()));
    public static final Block ZOMBIES_WALL_HEAD = register("zombies_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.ZOMBIES, AbstractBlock.Settings.create()));
    public static final Block NAEUS_HEAD = register("naeus_head", new SkullBlock(RainimatorSkulls.SkullType.NAEUS, AbstractBlock.Settings.create()));
    public static final Block NAEUS_WALL_HEAD = register("naeus_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.NAEUS, AbstractBlock.Settings.create()));
    public static final Block RAIN_HEAD = register("rain_head", new SkullBlock(RainimatorSkulls.SkullType.RAIN, AbstractBlock.Settings.create()));
    public static final Block RAIN_WALL_HEAD = register("rain_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.RAIN, AbstractBlock.Settings.create()));
    public static final Block ABIGAIL_HEAD = register("abigail_head", new SkullBlock(RainimatorSkulls.SkullType.ABIGAIL, AbstractBlock.Settings.create()));
    public static final Block ABIGAIL_WALL_HEAD = register("abigail_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.ABIGAIL, AbstractBlock.Settings.create()));
    public static final Block PATRICK_HEAD = register("patrick_head", new SkullBlock(RainimatorSkulls.SkullType.PATRICK, AbstractBlock.Settings.create()));
    public static final Block PATRICK_WALL_HEAD = register("patrick_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.PATRICK, AbstractBlock.Settings.create()));
    public static final Block BLACKBONE_HEAD = register("blackbone_head", new SkullBlock(RainimatorSkulls.SkullType.BLACKBONE, AbstractBlock.Settings.create()));
    public static final Block BLACKBONE_WALL_HEAD = register("blackbone_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.BLACKBONE, AbstractBlock.Settings.create()));
    public static final Block HOGSWORTH_HEAD = register("hogsworth_head", new SkullBlock(RainimatorSkulls.SkullType.HOGSWORTH, AbstractBlock.Settings.create()));
    public static final Block HOGSWORTH_WALL_HEAD = register("hogsworth_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.HOGSWORTH, AbstractBlock.Settings.create()));
    public static final Block CIARA_HEAD = register("ciara_head", new SkullBlock(RainimatorSkulls.SkullType.CIARA, AbstractBlock.Settings.create()));
    public static final Block CIARA_WALL_HEAD = register("ciara_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.CIARA, AbstractBlock.Settings.create()));
    public static final Block HILDA_HEAD = register("hilda_head", new SkullBlock(RainimatorSkulls.SkullType.HILDA, AbstractBlock.Settings.create()));
    public static final Block HILDA_WALL_HEAD = register("hilda_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.HILDA, AbstractBlock.Settings.create()));
    public static final Block SOLDIERS_HEAD = register("soldiers_head", new SkullBlock(RainimatorSkulls.SkullType.SOLDIERS, AbstractBlock.Settings.create()));
    public static final Block SOLDIERS_WALL_HEAD = register("soldiers_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.SOLDIERS, AbstractBlock.Settings.create()));
    public static final Block WITHERED_SKELETONS_HEAD = register("withered_skeletons_head", new SkullBlock(RainimatorSkulls.SkullType.WITHERED_SKELETONS, AbstractBlock.Settings.create()));
    public static final Block WITHERED_SKELETONS_WALL_HEAD = register("withered_skeletons_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.WITHERED_SKELETONS, AbstractBlock.Settings.create()));
    public static final Block DARK_SHIELD_HEAD = register("dark_shield_head", new SkullBlock(RainimatorSkulls.SkullType.DARK_SHIELD, AbstractBlock.Settings.create()));
    public static final Block DARK_SHIELD_WALL_HEAD = register("dark_shield_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.DARK_SHIELD, AbstractBlock.Settings.create()));
    public static final Block DARK_ZOMBIE_HEAD = register("dark_zombie_head", new SkullBlock(RainimatorSkulls.SkullType.DARK_ZOMBIE, AbstractBlock.Settings.create()));
    public static final Block DARK_ZOMBIE_WALL_HEAD = register("dark_zombie_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.DARK_ZOMBIE, AbstractBlock.Settings.create()));
    public static final Block VORDUS_HEAD = register("vordus_head", new SkullBlock(RainimatorSkulls.SkullType.VORDUS, AbstractBlock.Settings.create()));
    public static final Block VORDUS_WALL_HEAD = register("vordus_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.VORDUS, AbstractBlock.Settings.create()));
    public static final Block WITHER_SHIELD_HEAD = register("wither_shield_head", new SkullBlock(RainimatorSkulls.SkullType.WITHER_SHIELD, AbstractBlock.Settings.create()));
    public static final Block WITHER_SHIELD_WALL_HEAD = register("wither_shield_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.WITHER_SHIELD, AbstractBlock.Settings.create()));
    public static final Block SKELETON_SNOW_HEAD = register("skeleton_snow_head", new SkullBlock(RainimatorSkulls.SkullType.SKELETON_SNOW, AbstractBlock.Settings.create()));
    public static final Block SKELETON_SNOW_WALL_HEAD = register("skeleton_snow_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.SKELETON_SNOW, AbstractBlock.Settings.create()));
    public static final Block PIGLIN_KING_HEAD = register("piglin_king_head", new SkullBlock(RainimatorSkulls.SkullType.PIGLIN_KING, AbstractBlock.Settings.create()));
    public static final Block PIGLIN_KING_WALL_HEAD = register("piglin_king_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.PIGLIN_KING, AbstractBlock.Settings.create()));
    public static final Block GLUTTON_HEAD = register("glutton_head", new SkullBlock(RainimatorSkulls.SkullType.GLUTTON, AbstractBlock.Settings.create()));
    public static final Block GLUTTON_WALL_HEAD = register("glutton_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.GLUTTON, AbstractBlock.Settings.create()));
    public static final Block GLUTTON_OLD_HEAD = register("glutton_old_head", new SkullBlock(RainimatorSkulls.SkullType.GLUTTON_OLD, AbstractBlock.Settings.create()));
    public static final Block GLUTTON_OLD_WALL_HEAD = register("glutton_old_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.GLUTTON_OLD, AbstractBlock.Settings.create()));
    public static final Block PORKSHIRE_HEAD = register("porkshire_head", new SkullBlock(RainimatorSkulls.SkullType.PORKSHIRE, AbstractBlock.Settings.create()));
    public static final Block PORKSHIRE_WALL_HEAD = register("porkshire_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.PORKSHIRE, AbstractBlock.Settings.create()));
    public static final Block NAEUS_KING_HEAD = register("naeus_king_head", new SkullBlock(RainimatorSkulls.SkullType.NAEUS_KING, AbstractBlock.Settings.create()));
    public static final Block NAEUS_KING_WALL_HEAD = register("naeus_king_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.NAEUS_KING, AbstractBlock.Settings.create()));
    public static final Block TUSK_HEAD = register("tusk_head", new SkullBlock(RainimatorSkulls.SkullType.TUSK, AbstractBlock.Settings.create()));
    public static final Block TUSK_WALL_HEAD = register("tusk_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.TUSK, AbstractBlock.Settings.create()));
    public static final Block BROTS_HEAD = register("brots_head", new SkullBlock(RainimatorSkulls.SkullType.BROTS, AbstractBlock.Settings.create()));
    public static final Block BROTS_WALL_HEAD = register("brots_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.BROTS, AbstractBlock.Settings.create()));
    public static final Block ZOMBIE_PIG_HEAD = register("zombie_pig_head", new SkullBlock(RainimatorSkulls.SkullType.ZOMBIE_PIG, AbstractBlock.Settings.create()));
    public static final Block ZOMBIE_PIG_WALL_HEAD = register("zombie_pig_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.ZOMBIE_PIG, AbstractBlock.Settings.create()));
    public static final Block MUTATED_HEAD = register("mutated_head", new SkullBlock(RainimatorSkulls.SkullType.MUTATED, AbstractBlock.Settings.create()));
    public static final Block MUTATED_WALL_HEAD = register("mutated_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.MUTATED, AbstractBlock.Settings.create()));
    public static final Block NAMTAR_HEAD = register("namtar_head", new SkullBlock(RainimatorSkulls.SkullType.NAMTAR, AbstractBlock.Settings.create()));
    public static final Block NAMTAR_WALL_HEAD = register("namtar_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.NAMTAR, AbstractBlock.Settings.create()));
    public static final Block AGETHA_HEAD = register("agetha_head", new SkullBlock(RainimatorSkulls.SkullType.AGETHA, AbstractBlock.Settings.create()));
    public static final Block AGETHA_WALL_HEAD = register("agetha_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.AGETHA, AbstractBlock.Settings.create()));
    public static final Block TRICER_HEAD = register("tricer_head", new SkullBlock(RainimatorSkulls.SkullType.TRICER, AbstractBlock.Settings.create()));
    public static final Block TRICER_WALL_HEAD = register("tricer_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.TRICER, AbstractBlock.Settings.create()));
    public static final Block BIG_BLACK_SKELETON_HEAD = register("big_black_skeleton_head", new SkullBlock(RainimatorSkulls.SkullType.BIG_BLACK_SKELETON, AbstractBlock.Settings.create()));
    public static final Block BIG_BLACK_SKELETON_WALL_HEAD = register("big_black_skeleton_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.BIG_BLACK_SKELETON, AbstractBlock.Settings.create()));
    public static final Block ARCHER_HEAD = register("archer_head", new SkullBlock(RainimatorSkulls.SkullType.ARCHER, AbstractBlock.Settings.create()));
    public static final Block ARCHER_WALL_HEAD = register("archer_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.ARCHER, AbstractBlock.Settings.create()));
    public static final Block DARYLL_HEAD = register("daryll_head", new SkullBlock(RainimatorSkulls.SkullType.DARYLL, AbstractBlock.Settings.create()));
    public static final Block DARYLL_WALL_HEAD = register("daryll_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.DARYLL, AbstractBlock.Settings.create()));
    public static final Block NULL_LIKE_HEAD = register("null_like_head", new SkullBlock(RainimatorSkulls.SkullType.NULL_LIKE, AbstractBlock.Settings.create()));
    public static final Block NULL_LIKE_WALL_HEAD = register("null_like_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.NULL_LIKE, AbstractBlock.Settings.create()));
    public static final Block GIGABONE_HEAD = register("gigabone_head", new SkullBlock(RainimatorSkulls.SkullType.GIGABONE, AbstractBlock.Settings.create()));
    public static final Block GIGABONE_WALL_HEAD = register("gigabone_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.GIGABONE, AbstractBlock.Settings.create()));
    public static final Block KLAUS_HEAD = register("klaus_head", new SkullBlock(RainimatorSkulls.SkullType.KLAUS, AbstractBlock.Settings.create()));
    public static final Block KLAUS_WALL_HEAD = register("klaus_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.KLAUS, AbstractBlock.Settings.create()));
    public static final Block KLAUS_2_HEAD = register("klaus_2_head", new SkullBlock(RainimatorSkulls.SkullType.KLAUS_2, AbstractBlock.Settings.create()));
    public static final Block KLAUS_2_WALL_HEAD = register("klaus_2_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.KLAUS_2, AbstractBlock.Settings.create()));
    public static final Block KRALOS_HEAD = register("kralos_head", new SkullBlock(RainimatorSkulls.SkullType.KRALOS, AbstractBlock.Settings.create()));
    public static final Block KRALOS_WALL_HEAD = register("kralos_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.KRALOS, AbstractBlock.Settings.create()));
    public static final Block ARABELLA_HEAD = register("arabella_head", new SkullBlock(RainimatorSkulls.SkullType.ARABELLA, AbstractBlock.Settings.create()));
    public static final Block ARABELLA_WALL_HEAD = register("arabella_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.ARABELLA, AbstractBlock.Settings.create()));
    public static final Block AZALEA_HEAD = register("azalea_head", new SkullBlock(RainimatorSkulls.SkullType.AZALEA, AbstractBlock.Settings.create()));
    public static final Block AZALEA_WALL_HEAD = register("azalea_wall_head", new WallSkullBlock(RainimatorSkulls.SkullType.AZALEA, AbstractBlock.Settings.create()));

    public static final Item HEROBRINE_HEAD_ITEM = register("herobrine", HEROBRINE_HEAD, HEROBRINE_WALL_HEAD);
    public static final Item CERIS_HEAD_ITEM = register("ceris", CERIS_HEAD, CERIS_WALL_HEAD);
    public static final Item ZOMBIES_HEAD_ITEM = register("zombies", ZOMBIES_HEAD, ZOMBIES_WALL_HEAD);
    public static final Item NAEUS_HEAD_ITEM = register("naeus", NAEUS_HEAD, NAEUS_WALL_HEAD);
    public static final Item RAIN_HEAD_ITEM = register("rain", RAIN_HEAD, RAIN_WALL_HEAD);
    public static final Item ABIGAIL_HEAD_ITEM = register("abigail", ABIGAIL_HEAD, ABIGAIL_WALL_HEAD);
    public static final Item PATRICK_HEAD_ITEM = register("patrick", PATRICK_HEAD, PATRICK_WALL_HEAD);
    public static final Item BLACKBONE_HEAD_ITEM = register("blackbone", BLACKBONE_HEAD, BLACKBONE_WALL_HEAD);
    public static final Item HOGSWORTH_HEAD_ITEM = register("hogsworth", HOGSWORTH_HEAD, HOGSWORTH_WALL_HEAD);
    public static final Item CIARA_HEAD_ITEM = register("ciara", CIARA_HEAD, CIARA_WALL_HEAD);
    public static final Item HILDA_HEAD_ITEM = register("hilda", HILDA_HEAD, HILDA_WALL_HEAD);
    public static final Item SOLDIERS_HEAD_ITEM = register("soldiers", SOLDIERS_HEAD, SOLDIERS_WALL_HEAD);
    public static final Item WITHERED_SKELETONS_HEAD_ITEM = register("withered_skeletons", WITHERED_SKELETONS_HEAD, WITHERED_SKELETONS_WALL_HEAD);
    public static final Item DARK_SHIELD_HEAD_ITEM = register("dark_shield", DARK_SHIELD_HEAD, DARK_SHIELD_WALL_HEAD);
    public static final Item DARK_ZOMBIE_HEAD_ITEM = register("dark_zombie", DARK_ZOMBIE_HEAD, DARK_ZOMBIE_WALL_HEAD);
    public static final Item VORDUS_HEAD_ITEM = register("vordus", VORDUS_HEAD, VORDUS_WALL_HEAD);
    public static final Item WITHER_SHIELD_HEAD_ITEM = register("wither_shield", WITHER_SHIELD_HEAD, WITHER_SHIELD_WALL_HEAD);
    public static final Item SKELETON_SNOW_HEAD_ITEM = register("skeleton_snow", SKELETON_SNOW_HEAD, SKELETON_SNOW_WALL_HEAD);
    public static final Item PIGLIN_KING_HEAD_ITEM = register("piglin_king", PIGLIN_KING_HEAD, PIGLIN_KING_WALL_HEAD);
    public static final Item GLUTTON_HEAD_ITEM = register("glutton", GLUTTON_HEAD, GLUTTON_WALL_HEAD);
    public static final Item GLUTTON_OLD_HEAD_ITEM = register("glutton_old", GLUTTON_OLD_HEAD, GLUTTON_OLD_WALL_HEAD);
    public static final Item PORKSHIRE_HEAD_ITEM = register("porkshire", PORKSHIRE_HEAD, PORKSHIRE_WALL_HEAD);
    public static final Item NAEUS_KING_HEAD_ITEM = register("naeus_king", NAEUS_KING_HEAD, NAEUS_KING_WALL_HEAD);
    public static final Item TUSK_HEAD_ITEM = register("tusk", TUSK_HEAD, TUSK_WALL_HEAD);
    public static final Item BROTS_HEAD_ITEM = register("brots", BROTS_HEAD, BROTS_WALL_HEAD);
    public static final Item ZOMBIE_PIG_HEAD_ITEM = register("zombie_pig", ZOMBIE_PIG_HEAD, ZOMBIE_PIG_WALL_HEAD);
    public static final Item MUTATED_HEAD_ITEM = register("mutated", MUTATED_HEAD, MUTATED_WALL_HEAD);
    public static final Item NAMTAR_HEAD_ITEM = register("namtar", NAMTAR_HEAD, NAMTAR_WALL_HEAD);
    public static final Item AGETHA_HEAD_ITEM = register("agetha", AGETHA_HEAD, AGETHA_WALL_HEAD);
    public static final Item TRICER_HEAD_ITEM = register("tricer", TRICER_HEAD, TRICER_WALL_HEAD);
    public static final Item BIG_BLACK_SKELETON_HEAD_ITEM = register("big_black_skeleton", BIG_BLACK_SKELETON_HEAD, BIG_BLACK_SKELETON_WALL_HEAD);
    public static final Item ARCHER_HEAD_ITEM = register("archer", ARCHER_HEAD, ARCHER_WALL_HEAD);
    public static final Item DARYLL_HEAD_ITEM = register("daryll", DARYLL_HEAD, DARYLL_WALL_HEAD);
    public static final Item NULL_LIKE_HEAD_ITEM = register("null_like", NULL_LIKE_HEAD, NULL_LIKE_WALL_HEAD);
    public static final Item GIGABONE_HEAD_ITEM = register("gigabone", GIGABONE_HEAD, GIGABONE_WALL_HEAD);
    public static final Item KLAUS_HEAD_ITEM = register("klaus", KLAUS_HEAD, KLAUS_WALL_HEAD);
    public static final Item KLAUS_2_HEAD_ITEM = register("klaus_2", KLAUS_2_HEAD, KLAUS_2_WALL_HEAD);
    public static final Item KRALOS_HEAD_ITEM = register("kralos", KRALOS_HEAD, KRALOS_WALL_HEAD);
    public static final Item ARABELLA_HEAD_ITEM = register("arabella", ARABELLA_HEAD, ARABELLA_WALL_HEAD);
    public static final Item AZALEA_HEAD_ITEM = register("azalea", AZALEA_HEAD, AZALEA_WALL_HEAD);

    private static Block register(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(RainimatorMod.MOD_ID, name), block);
    }

    private static Item register(String name, Block head, Block wallHead) {
        return Registry.register(Registries.ITEM, new Identifier(RainimatorMod.MOD_ID, name + "_head"), new SkullItem(head, wallHead, new Item.Settings()));
    }

    public static void init() {
    }

    @Environment(EnvType.CLIENT)
    public static void clientInit() {
        SkullRenderRegistry.register(SkullType.HEROBRINE, HerobrineEntity.texture.getTexture(), HEROBRINE_HEAD, HEROBRINE_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.CERIS, CerisEntity.texture.getTexture(), CERIS_HEAD, CERIS_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.ZOMBIES, ZombiesEntity.texture.getTexture(), ZOMBIES_HEAD, ZOMBIES_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.NAEUS, NaeusEntity.texture.getTexture(), NAEUS_HEAD, NAEUS_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.RAIN, RainEntity.texture.getTexture(), RAIN_HEAD, RAIN_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.ABIGAIL, AbigailEntity.texture.getTexture(), ABIGAIL_HEAD, ABIGAIL_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.PATRICK, PatrickEntity.texture.getTexture(), PATRICK_HEAD, PATRICK_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.BLACKBONE, BlackBoneEntity.texture.getTexture(), BLACKBONE_HEAD, BLACKBONE_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.HOGSWORTH, HogsworthEntity.texture.getTexture(), HOGSWORTH_HEAD, HOGSWORTH_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.CIARA, CiaraEntity.texture.getTexture(), CIARA_HEAD, CIARA_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.HILDA, HildaEntity.texture.getTexture(), HILDA_HEAD, HILDA_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.SOLDIERS, SoldiersEntity.texture.getTexture(), SOLDIERS_HEAD, SOLDIERS_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.WITHERED_SKELETONS, WitheredSkeletonsEntity.texture.getTexture(), WITHERED_SKELETONS_HEAD, WITHERED_SKELETONS_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.DARK_SHIELD, DarkShieldEntity.texture.getTexture(), DARK_SHIELD_HEAD, DARK_SHIELD_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.DARK_ZOMBIE, DarkZombieEntity.texture.getTexture(), DARK_ZOMBIE_HEAD, DARK_ZOMBIE_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.VORDUS, VordusEntity.texture.getTexture(), VORDUS_HEAD, VORDUS_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.WITHER_SHIELD, WitherShieldEntity.texture.getTexture(), WITHER_SHIELD_HEAD, WITHER_SHIELD_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.SKELETON_SNOW, SkeletonSnowEntity.texture.getTexture(), SKELETON_SNOW_HEAD, SKELETON_SNOW_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.PIGLIN_KING, ZombiesPiglinKingEntity.texture.getTexture(), PIGLIN_KING_HEAD, PIGLIN_KING_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.GLUTTON, PiglinKingZombiesEntity.texture.getTexture(), GLUTTON_HEAD, GLUTTON_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.GLUTTON_OLD, PiglinKingZombieEntity.texture.getTexture(), GLUTTON_OLD_HEAD, GLUTTON_OLD_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.PORKSHIRE, PiglinCommanderEntity.texture.getTexture(), PORKSHIRE_HEAD, PORKSHIRE_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.NAEUS_KING, NaeusKingEntity.texture.getTexture(), NAEUS_KING_HEAD, NAEUS_KING_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.TUSK, TuskEntity.texture.getTexture(), TUSK_HEAD, TUSK_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.BROTS, BrotsEntity.texture.getTexture(), BROTS_HEAD, BROTS_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.ZOMBIE_PIG, ZombiePiglinArtEntity.texture.getTexture(), ZOMBIE_PIG_HEAD, ZOMBIE_PIG_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.MUTATED, MutatedEntity.texture.getTexture(), MUTATED_HEAD, MUTATED_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.NAMTAR, NamtarEntity.texture.getTexture(), NAMTAR_HEAD, NAMTAR_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.AGETHA, AgethaEntity.texture.getTexture(), AGETHA_HEAD, AGETHA_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.TRICER, TricerEntity.texture.getTexture(), TRICER_HEAD, TRICER_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.BIG_BLACK_SKELETON, BigUndeadSkeletonEntity.texture.getTexture(), BIG_BLACK_SKELETON_HEAD, BIG_BLACK_SKELETON_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.ARCHER, ArcherEntity.texture.getTexture(), ARCHER_HEAD, ARCHER_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.DARYLL, DaryllEntity.texture.getTexture(), DARYLL_HEAD, DARYLL_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.NULL_LIKE, NullLikeEntity.texture.getTexture(), NULL_LIKE_HEAD, NULL_LIKE_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.GIGABONE, GigaBoneEntity.texture.getTexture(), GIGABONE_HEAD, GIGABONE_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.KLAUS, KlausEntity.texture.getTexture(), KLAUS_HEAD, KLAUS_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.KLAUS_2, Klaus2Entity.texture.getTexture(), KLAUS_2_HEAD, KLAUS_2_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.KRALOS, KralosEntity.texture.getTexture(), KRALOS_HEAD, KRALOS_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.ARABELLA, ArabellaEntity.texture.getTexture(), ARABELLA_HEAD, ARABELLA_WALL_HEAD);
        SkullRenderRegistry.register(SkullType.AZALEA, AzaleaEntity.texture.getTexture(), AZALEA_HEAD, AZALEA_WALL_HEAD);
    }

    public enum SkullType implements SkullBlock.SkullType {
        HEROBRINE, CERIS, ZOMBIES, NAEUS, RAIN, ABIGAIL, PATRICK, BLACKBONE, HOGSWORTH,
        CIARA, HILDA, SOLDIERS, WITHERED_SKELETONS, DARK_SHIELD, DARK_ZOMBIE, VORDUS, WITHER_SHIELD, SKELETON_SNOW,
        PIGLIN_KING, GLUTTON, GLUTTON_OLD, PORKSHIRE, NAEUS_KING, TUSK, BROTS, ZOMBIE_PIG, MUTATED,
        NAMTAR, AGETHA, TRICER, BIG_BLACK_SKELETON, ARCHER, DARYLL, NULL_LIKE, GIGABONE, KLAUS,
        KLAUS_2, KRALOS, ARABELLA, AZALEA
    }
}
