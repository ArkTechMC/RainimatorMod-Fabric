package com.rainimator.rainimatormod.item.sword;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.registry.util.SwordItemBase;
import com.rainimator.rainimatormod.registry.util.ToolMaterialBase;
import com.rainimator.rainimatormod.util.DamageUtil;
import com.rainimator.rainimatormod.util.SoundUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Comparator;
import java.util.List;

public class NaeusSwordItem extends SwordItemBase {
    public NaeusSwordItem() {
        super(ToolMaterialBase.of(4000, 4.0F, 9.0F, 0, 10), 3, -2.0F, new Settings().fireproof());
    }

    @Override
    public boolean postHit(ItemStack itemstack, LivingEntity entity, LivingEntity sourceEntity) {
        boolean ret_val = super.postHit(itemstack, entity, sourceEntity);
        if (!entity.getWorld().isClient())
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0));
        entity.setOnFireFor(5);
        return ret_val;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        TypedActionResult<ItemStack> ar = super.use(world, entity, hand);
        Vec3d _center = entity.getPos();
        List<Entity> _entfound = world.getEntitiesByClass(Entity.class, (new Box(_center, _center)).expand(6.0D), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.squaredDistanceTo(_center))).toList();
        for (Entity entityIterator : _entfound) {
            if (entity.isSneaking()) {
                if (entityIterator instanceof PlayerEntity)
                    entity.damage(DamageUtil.build(entity, DamageTypes.GENERIC), 0.0F);
                else {
                    entityIterator.damage(DamageUtil.build(entity, DamageTypes.MAGIC), 5.0F);
                    if (entityIterator instanceof LivingEntity _entity)
                        if (!_entity.getWorld().isClient())
                            _entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 300, 1));
                    entityIterator.setOnFireFor(10);
                    SoundUtil.playSound(world, _center.x, _center.y, _center.z, new Identifier(RainimatorMod.MOD_ID, "naeus_sword_1"), 1.0F, 1.0F);
                    if (entity instanceof PlayerEntity)
                        entity.getItemCooldownManager().set(ar.getValue().getItem(), 600);
                }
            }
        }
        return ar;
    }
}