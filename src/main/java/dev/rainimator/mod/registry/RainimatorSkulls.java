package dev.rainimator.mod.registry;

import com.iafenvoy.annotationlib.annotation.CallbackHandler;
import com.iafenvoy.annotationlib.annotation.ModId;
import com.iafenvoy.annotationlib.annotation.registration.RegisterAll;
import com.iafenvoy.annotationlib.api.IAnnotatedRegistryEntry;
import com.iafenvoy.mcrconvertlib.render.SkullRenderRegistry;
import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.entity.*;
import net.fabricmc.api.EnvType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SkullBlock;
import net.minecraft.block.WallSkullBlock;

@ModId(RainimatorMod.MOD_ID)
@RegisterAll
public class RainimatorSkulls implements IAnnotatedRegistryEntry {
    public static final Block HEROBRINE_HEAD = new SkullBlock(RainimatorSkulls.SkullType.HEROBRINE, AbstractBlock.Settings.create());
    public static final Block HEROBRINE_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.HEROBRINE, AbstractBlock.Settings.create());
    public static final Block CERIS_HEAD = new SkullBlock(RainimatorSkulls.SkullType.CERIS, AbstractBlock.Settings.create());
    public static final Block CERIS_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.CERIS, AbstractBlock.Settings.create());
    public static final Block ZOMBIES_HEAD = new SkullBlock(RainimatorSkulls.SkullType.ZOMBIES, AbstractBlock.Settings.create());
    public static final Block ZOMBIES_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.ZOMBIES, AbstractBlock.Settings.create());
    public static final Block NAEUS_HEAD = new SkullBlock(RainimatorSkulls.SkullType.NAEUS, AbstractBlock.Settings.create());
    public static final Block NAEUS_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.NAEUS, AbstractBlock.Settings.create());
    public static final Block RAIN_HEAD = new SkullBlock(RainimatorSkulls.SkullType.RAIN, AbstractBlock.Settings.create());
    public static final Block RAIN_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.RAIN, AbstractBlock.Settings.create());
    public static final Block ABIGAIL_HEAD = new SkullBlock(RainimatorSkulls.SkullType.ABIGAIL, AbstractBlock.Settings.create());
    public static final Block ABIGAIL_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.ABIGAIL, AbstractBlock.Settings.create());
    public static final Block PATRICK_HEAD = new SkullBlock(RainimatorSkulls.SkullType.PATRICK, AbstractBlock.Settings.create());
    public static final Block PATRICK_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.PATRICK, AbstractBlock.Settings.create());
    public static final Block BLACKBONE_HEAD = new SkullBlock(RainimatorSkulls.SkullType.BLACKBONE, AbstractBlock.Settings.create());
    public static final Block BLACKBONE_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.BLACKBONE, AbstractBlock.Settings.create());
    public static final Block HOGSWORTH_HEAD = new SkullBlock(RainimatorSkulls.SkullType.HOGSWORTH, AbstractBlock.Settings.create());
    public static final Block HOGSWORTH_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.HOGSWORTH, AbstractBlock.Settings.create());
    public static final Block CIARA_HEAD = new SkullBlock(RainimatorSkulls.SkullType.CIARA, AbstractBlock.Settings.create());
    public static final Block CIARA_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.CIARA, AbstractBlock.Settings.create());
    public static final Block HILDA_HEAD = new SkullBlock(RainimatorSkulls.SkullType.HILDA, AbstractBlock.Settings.create());
    public static final Block HILDA_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.HILDA, AbstractBlock.Settings.create());
    public static final Block SOLDIERS_HEAD = new SkullBlock(RainimatorSkulls.SkullType.SOLDIERS, AbstractBlock.Settings.create());
    public static final Block SOLDIERS_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.SOLDIERS, AbstractBlock.Settings.create());
    public static final Block WITHERED_SKELETONS_HEAD = new SkullBlock(RainimatorSkulls.SkullType.WITHERED_SKELETONS, AbstractBlock.Settings.create());
    public static final Block WITHERED_SKELETONS_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.WITHERED_SKELETONS, AbstractBlock.Settings.create());
    public static final Block DARK_SHIELD_HEAD = new SkullBlock(RainimatorSkulls.SkullType.DARK_SHIELD, AbstractBlock.Settings.create());
    public static final Block DARK_SHIELD_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.DARK_SHIELD, AbstractBlock.Settings.create());
    public static final Block DARK_ZOMBIE_HEAD = new SkullBlock(RainimatorSkulls.SkullType.DARK_ZOMBIE, AbstractBlock.Settings.create());
    public static final Block DARK_ZOMBIE_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.DARK_ZOMBIE, AbstractBlock.Settings.create());
    public static final Block VORDUS_HEAD = new SkullBlock(RainimatorSkulls.SkullType.VORDUS, AbstractBlock.Settings.create());
    public static final Block VORDUS_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.VORDUS, AbstractBlock.Settings.create());
    public static final Block WITHER_SHIELD_HEAD = new SkullBlock(RainimatorSkulls.SkullType.WITHER_SHIELD, AbstractBlock.Settings.create());
    public static final Block WITHER_SHIELD_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.WITHER_SHIELD, AbstractBlock.Settings.create());
    public static final Block SKELETON_SNOW_HEAD = new SkullBlock(RainimatorSkulls.SkullType.SKELETON_SNOW, AbstractBlock.Settings.create());
    public static final Block SKELETON_SNOW_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.SKELETON_SNOW, AbstractBlock.Settings.create());
    public static final Block PIGLIN_KING_HEAD = new SkullBlock(RainimatorSkulls.SkullType.PIGLIN_KING, AbstractBlock.Settings.create());
    public static final Block PIGLIN_KING_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.PIGLIN_KING, AbstractBlock.Settings.create());
    public static final Block GLUTTON_HEAD = new SkullBlock(RainimatorSkulls.SkullType.GLUTTON, AbstractBlock.Settings.create());
    public static final Block GLUTTON_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.GLUTTON, AbstractBlock.Settings.create());
    public static final Block GLUTTON_OLD_HEAD = new SkullBlock(RainimatorSkulls.SkullType.GLUTTON_OLD, AbstractBlock.Settings.create());
    public static final Block GLUTTON_OLD_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.GLUTTON_OLD, AbstractBlock.Settings.create());
    public static final Block PORKSHIRE_HEAD = new SkullBlock(RainimatorSkulls.SkullType.PORKSHIRE, AbstractBlock.Settings.create());
    public static final Block PORKSHIRE_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.PORKSHIRE, AbstractBlock.Settings.create());
    public static final Block NAEUS_KING_HEAD = new SkullBlock(RainimatorSkulls.SkullType.NAEUS_KING, AbstractBlock.Settings.create());
    public static final Block NAEUS_KING_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.NAEUS_KING, AbstractBlock.Settings.create());
    public static final Block TUSK_HEAD = new SkullBlock(RainimatorSkulls.SkullType.TUSK, AbstractBlock.Settings.create());
    public static final Block TUSK_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.TUSK, AbstractBlock.Settings.create());
    public static final Block BROTS_HEAD = new SkullBlock(RainimatorSkulls.SkullType.BROTS, AbstractBlock.Settings.create());
    public static final Block BROTS_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.BROTS, AbstractBlock.Settings.create());
    public static final Block ZOMBIE_PIG_HEAD = new SkullBlock(RainimatorSkulls.SkullType.ZOMBIE_PIG, AbstractBlock.Settings.create());
    public static final Block ZOMBIE_PIG_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.ZOMBIE_PIG, AbstractBlock.Settings.create());
    public static final Block MUTATED_HEAD = new SkullBlock(RainimatorSkulls.SkullType.MUTATED, AbstractBlock.Settings.create());
    public static final Block MUTATED_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.MUTATED, AbstractBlock.Settings.create());
    public static final Block NAMTAR_HEAD = new SkullBlock(RainimatorSkulls.SkullType.NAMTAR, AbstractBlock.Settings.create());
    public static final Block NAMTAR_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.NAMTAR, AbstractBlock.Settings.create());
    public static final Block AGETHA_HEAD = new SkullBlock(RainimatorSkulls.SkullType.AGETHA, AbstractBlock.Settings.create());
    public static final Block AGETHA_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.AGETHA, AbstractBlock.Settings.create());
    public static final Block TRICER_HEAD = new SkullBlock(RainimatorSkulls.SkullType.TRICER, AbstractBlock.Settings.create());
    public static final Block TRICER_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.TRICER, AbstractBlock.Settings.create());
    public static final Block BIG_BLACK_SKELETON_HEAD = new SkullBlock(RainimatorSkulls.SkullType.BIG_BLACK_SKELETON, AbstractBlock.Settings.create());
    public static final Block BIG_BLACK_SKELETON_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.BIG_BLACK_SKELETON, AbstractBlock.Settings.create());
    public static final Block ARCHER_HEAD = new SkullBlock(RainimatorSkulls.SkullType.ARCHER, AbstractBlock.Settings.create());
    public static final Block ARCHER_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.ARCHER, AbstractBlock.Settings.create());
    public static final Block DARYLL_HEAD = new SkullBlock(RainimatorSkulls.SkullType.DARYLL, AbstractBlock.Settings.create());
    public static final Block DARYLL_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.DARYLL, AbstractBlock.Settings.create());
    public static final Block NULL_LIKE_HEAD = new SkullBlock(RainimatorSkulls.SkullType.NULL_LIKE, AbstractBlock.Settings.create());
    public static final Block NULL_LIKE_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.NULL_LIKE, AbstractBlock.Settings.create());
    public static final Block GIGABONE_HEAD = new SkullBlock(RainimatorSkulls.SkullType.GIGABONE, AbstractBlock.Settings.create());
    public static final Block GIGABONE_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.GIGABONE, AbstractBlock.Settings.create());
    public static final Block KLAUS_HEAD = new SkullBlock(RainimatorSkulls.SkullType.KLAUS, AbstractBlock.Settings.create());
    public static final Block KLAUS_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.KLAUS, AbstractBlock.Settings.create());
    public static final Block KLAUS_2_HEAD = new SkullBlock(RainimatorSkulls.SkullType.KLAUS_2, AbstractBlock.Settings.create());
    public static final Block KLAUS_2_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.KLAUS_2, AbstractBlock.Settings.create());
    public static final Block KRALOS_HEAD = new SkullBlock(RainimatorSkulls.SkullType.KRALOS, AbstractBlock.Settings.create());
    public static final Block KRALOS_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.KRALOS, AbstractBlock.Settings.create());
    public static final Block ARABELLA_HEAD = new SkullBlock(RainimatorSkulls.SkullType.ARABELLA, AbstractBlock.Settings.create());
    public static final Block ARABELLA_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.ARABELLA, AbstractBlock.Settings.create());
    public static final Block AZALEA_HEAD = new SkullBlock(RainimatorSkulls.SkullType.AZALEA, AbstractBlock.Settings.create());
    public static final Block AZALEA_WALL_HEAD = new WallSkullBlock(RainimatorSkulls.SkullType.AZALEA, AbstractBlock.Settings.create());

    @CallbackHandler(environment = EnvType.CLIENT)
    public static void init() {
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
