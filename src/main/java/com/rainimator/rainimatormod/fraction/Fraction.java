package com.rainimator.rainimatormod.fraction;

import com.rainimator.rainimatormod.entity.*;
import com.rainimator.rainimatormod.registry.ModBanners;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public enum Fraction {
    FROST(ModBanners.FROST),
    UNDEAD(ModBanners.UNDEAD),
    NETHER(ModBanners.NETHER),
    ENDER(ModBanners.DRAGONSPIRE);
    private final ItemStack banner;
    private final List<Class<? extends LivingEntity>> members = new ArrayList<>();

    Fraction(ItemStack banner) {
        this.banner = banner;
    }

    public ItemStack getBanner() {
        return this.banner;
    }

    public void addMember(Class<? extends LivingEntity> clazz) {
        this.members.add(clazz);
    }

    private static Fraction find(Class<? extends LivingEntity> clazz) {
        for (Fraction fraction : Fraction.values())
            if (fraction.members.contains(clazz))
                return fraction;
        return null;
    }

    private static void addTarget(HostileEntity entity, Fraction fraction) {
        for (Fraction f : Fraction.values())
            if (f != fraction)
                for (Class<? extends LivingEntity> clazz : f.members)
                    entity.targetSelector.add(1, new ActiveTargetGoal<>(entity, clazz, false, false));
    }

    public static void findAndAddTarget(HostileEntity entity) {
        Fraction fraction = find(entity.getClass());
        if (fraction != null)
            addTarget(entity, fraction);
//        entity.targetSelector.add(1, new ActiveTargetGoal<>(entity, PlayerEntity.class, false, livingEntity -> {
//            if(livingEntity instanceof PlayerEntity player){
//
//            }
//            return true;
//        }));
    }

    static {
        UNDEAD.addMember(HerobrineEntity.class);
        ENDER.addMember(CerisEntity.class);
        UNDEAD.addMember(ZombiesEntity.class);
        NETHER.addMember(NaeusEntity.class);
        FROST.addMember(RainEntity.class);
        NETHER.addMember(AbigailEntity.class);
        FROST.addMember(PatrickEntity.class);
        NETHER.addMember(BlackBoneEntity.class);
        NETHER.addMember(HogsworthEntity.class);

        FROST.addMember(CiaraEntity.class);
        FROST.addMember(HildaEntity.class);
        FROST.addMember(SoldiersEntity.class);
        NETHER.addMember(WitheredSkeletonsEntity.class);
        ENDER.addMember(DarkShieldEntity.class);
        UNDEAD.addMember(DarkZombieEntity.class);
        ENDER.addMember(VordusEntity.class);
        NETHER.addMember(WitherShieldEntity.class);
        UNDEAD.addMember(SkeletonSnowEntity.class);

        NETHER.addMember(ZombiesPiglinKingEntity.class);
        NETHER.addMember(PiglinKingZombiesEntity.class);
        NETHER.addMember(PiglinKingZombieEntity.class);
        NETHER.addMember(PiglinCommanderEntity.class);
        NETHER.addMember(NaeusKingEntity.class);
        NETHER.addMember(TuskEntity.class);
        NETHER.addMember(BrotsEntity.class);
        NETHER.addMember(ZombiePiglinArtEntity.class);
        NETHER.addMember(MutatedEntity.class);

        NETHER.addMember(NamtarEntity.class);
        FROST.addMember(AgethaEntity.class);
        UNDEAD.addMember(TricerEntity.class);
        NETHER.addMember(BigUndeadSkeletonEntity.class);
        FROST.addMember(ArcherEntity.class);
        FROST.addMember(DaryllEntity.class);
        NETHER.addMember(NullLikeEntity.class);
        NETHER.addMember(GigaBoneEntity.class);
        UNDEAD.addMember(KlausEntity.class);

        UNDEAD.addMember(Klaus2Entity.class);
        NETHER.addMember(KralosEntity.class);
        ENDER.addMember(ArabellaEntity.class);
        UNDEAD.addMember(AzaleaEntity.class);
    }
}
