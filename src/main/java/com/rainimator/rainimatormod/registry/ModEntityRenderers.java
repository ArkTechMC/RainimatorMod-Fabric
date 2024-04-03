package com.rainimator.rainimatormod.registry;

import com.rainimator.rainimatormod.entity.*;
import net.minecraft.client.render.entity.EntityRenderers;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class ModEntityRenderers {
    public static void registerEntityRenderers() {
        EntityRenderers.register(ModEntities.HEROBRINE, HerobrineEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.CERIS, CerisEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.ZOMBIES, ZombiesEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.NAEUS, NaeusEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.RAIN, RainEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.RAIN_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRenderers.register(ModEntities.ABIGAIL, AbigailEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.ABIGAIL_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRenderers.register(ModEntities.PATRICK, PatrickEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.PATRICK_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRenderers.register(ModEntities.BLACKBONE, BlackBoneEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.HOGSWORTH, HogsworthEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.SOLDIERS, SoldiersEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.SOLDIERS_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRenderers.register(ModEntities.CIARA, CiaraEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.CIARA_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRenderers.register(ModEntities.HILDA, HildaEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.HILDA_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRenderers.register(ModEntities.WITHERED_SKELETONS, WitheredSkeletonsEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.END_STAFF, FlyingItemEntityRenderer::new);
        EntityRenderers.register(ModEntities.VORDUS, VordusEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.DARK_ZOMBIE, DarkZombieEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.DARK_SHIELD, DarkShieldEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.WITHER_SHIELD, WitherShieldEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.SKELETON_SNOW, SkeletonSnowEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.ARABELLA, ArabellaEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.AZALEA, AzaleaEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.NULL_LIKE, NullLikeEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.ZOMBIE_PIGLIN_KING, ZombiesPiglinKingEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.PIGLIN_KING_ZOMBIES, PiglinKingZombiesEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.PIGLIN_KING_ZOMBIE, PiglinKingZombieEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.PIGLIN_COMMANDER, PiglinCommanderEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.DARYLL, DaryllEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.DARYLL_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRenderers.register(ModEntities.NAEUS_KING, NaeusKingEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.TUSK, TuskEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.BROTS, BrotsEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.ZOMBIE_PIGLIN_ART, ZombiePiglinArtEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.MUTATED, MutatedEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.NAMTAR, NamtarEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.AGETHA, AgethaEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.TRICER, TricerEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.BIG_UNDEAD_SKELETON, BigUndeadSkeletonEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.ARCHER, ArcherEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.GIGABONE, GigaBoneEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.KLAUS, KlausEntity.texture::createRenderer);
        EntityRenderers.register(ModEntities.KLAUS_2, Klaus2Entity.texture::createRenderer);
        EntityRenderers.register(ModEntities.KRALOS, KralosEntity.texture::createRenderer);
    }
}