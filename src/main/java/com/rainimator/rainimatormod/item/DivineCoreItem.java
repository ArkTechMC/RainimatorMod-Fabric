package com.rainimator.rainimatormod.item;

import com.iafenvoy.mcrconvertlib.item.FoilItemBase;
import com.iafenvoy.mcrconvertlib.misc.RandomHelper;
import com.rainimator.rainimatormod.data.config.ManaConfig;
import com.rainimator.rainimatormod.registry.util.IManaRequire;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class DivineCoreItem extends FoilItemBase implements IManaRequire {
    public DivineCoreItem() {
        super(p -> p.maxDamage(100).rarity(Rarity.UNCOMMON));
    }

    @Override
    public UseAction getUseAction(ItemStack itemtack) {
        return UseAction.BLOCK;
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public int getMaxUseTime(ItemStack itemtack) {
        return 1;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        TypedActionResult<ItemStack> ar = super.use(world, entity, hand);
        if(!this.tryUse(entity)) return ar;
        ItemStack itemtack = ar.getValue();

        if (entity.getHealth() == entity.getMaxHealth()) {
            if (itemtack.damage(0, entity.getRandom(), null)) {
                itemtack.decrement(1);
                itemtack.setDamage(0);
            }
        } else {
            entity.setHealth(entity.getHealth() + RandomHelper.nextInt(1, 4));
            if (itemtack.damage(1, entity.getRandom(), null)) {
                itemtack.decrement(1);
                itemtack.setDamage(0);
            }
        }
        return ar;
    }

    @Override
    public double manaPerUse() {
        return ManaConfig.getInstance().divine_core;
    }
}
