package com.rainimator.rainimatormod.item.armor;

import com.iafenvoy.mcrconvertlib.item.ArmorMaterialUtil;
import com.iafenvoy.mcrconvertlib.item.ArmorWithTickItem;
import com.rainimator.rainimatormod.entity.WitheredSkeletonsEntity;
import com.rainimator.rainimatormod.registry.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Comparator;
import java.util.List;

public class NetherTheCrownItem extends ArmorWithTickItem {
    public NetherTheCrownItem(Type slot, Item.Settings properties) {
        super(ArmorMaterialUtil.of("nether_the_crown", new int[]{13, 15, 16, 11}, 30, new int[]{0, 0, 0, 5}, 15, null, 0.0F, 0.0F), slot, properties);
    }

    @Override
    public void onArmorTick(World world, PlayerEntity entity) {
        if (entity == null) {
            return;
        }
        Vec3d _center = new Vec3d(entity.getX(), entity.getY(), entity.getZ());
        List<Entity> _entfound = world.getEntitiesByClass(Entity.class, (new Box(_center, _center)).expand(16.0D), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.squaredDistanceTo(_center))).toList();
        for (Entity entityiterator : _entfound) {
            if (entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.NETHER_THE_CROWN_HELMET) {
                if (entityiterator instanceof WitheredSkeletonsEntity) {
                    MobEntity _entity = (MobEntity) entityiterator;
                    _entity.getNavigation().stop();
                    continue;
                }
                if (entityiterator instanceof WitherSkeletonEntity) {
                    MobEntity _entity = (MobEntity) entityiterator;
                    _entity.getNavigation().stop();
                    continue;
                }
                if (entityiterator instanceof PiglinEntity) {
                    MobEntity _entity = (MobEntity) entityiterator;
                    _entity.getNavigation().stop();
                    continue;
                }
                if (entityiterator instanceof PiglinBruteEntity) {
                    MobEntity _entity = (MobEntity) entityiterator;
                    _entity.getNavigation().stop();
                    continue;
                }
                if (entityiterator instanceof ZombifiedPiglinEntity) {
                    MobEntity _entity = (MobEntity) entityiterator;
                    _entity.getNavigation().stop();
                    continue;
                }
                if (entityiterator instanceof ZoglinEntity) {
                    MobEntity _entity = (MobEntity) entityiterator;
                    _entity.getNavigation().stop();
                }
            }
        }
    }

    public static class Helmet extends NetherTheCrownItem {
        public Helmet() {
            super(Type.HELMET, new Settings().fireproof());
        }
    }
}
