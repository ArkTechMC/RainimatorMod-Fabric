package com.rainimator.rainimatormod.item;

import com.iafenvoy.mcrconvertlib.item.ItemBase;
import com.rainimator.rainimatormod.data.config.ManaConfig;
import com.rainimator.rainimatormod.registry.util.IManaRequire;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class NetherNuclearReactorItem extends ItemBase implements IManaRequire {
    public NetherNuclearReactorItem() {
        super(p -> p.maxDamage(16).fireproof());
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        TypedActionResult<ItemStack> ar = super.use(world, entity, hand);
        if(!this.tryUse(entity)) return ar;
        ItemStack itemtack = ar.getValue();
        if (!entity.getWorld().isClient())
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0));
        entity.getItemCooldownManager().set(itemtack.getItem(), 800);
        return ar;
    }

    @Override
    public double manaPerUse() {
        return ManaConfig.getInstance().nether_nuclear_reactor;
    }
}
