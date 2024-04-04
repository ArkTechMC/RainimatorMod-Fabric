package com.rainimator.rainimatormod.item;

import com.rainimator.rainimatormod.registry.util.FoilItemBase;
import com.rainimator.rainimatormod.util.RandomHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class DivineCoreItem extends FoilItemBase {
    public DivineCoreItem() {
        super(p -> p.maxDamage(100).rarity(Rarity.UNCOMMON));
    }

    @Override
    public UseAction getUseAction(ItemStack itemstack) {
        return UseAction.BLOCK;
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public int getMaxUseTime(ItemStack itemstack) {
        return 1;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        TypedActionResult<ItemStack> ar = super.use(world, entity, hand);
        ItemStack itemstack = ar.getValue();

        if (entity.getHealth() == entity.getMaxHealth()) {
            if (itemstack.damage(0, entity.getRandom(), null)) {
                itemstack.decrement(1);
                itemstack.setDamage(0);
            }
        } else {
            entity.setHealth(entity.getHealth() + RandomHelper.nextInt(1, 4));
            if (itemstack.damage(1, entity.getRandom(), null)) {
                itemstack.decrement(1);
                itemstack.setDamage(0);
            }
        }
        return ar;
    }
}
