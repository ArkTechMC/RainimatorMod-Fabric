package com.rainimator.rainimatormod.item;

import com.rainimator.rainimatormod.registry.util.FoilItemBase;
import com.rainimator.rainimatormod.registry.util.ModCreativeTab;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class DivineCoreItem extends FoilItemBase {
    public DivineCoreItem() {
        super(p -> p.group(ModCreativeTab.items).maxDamage(100).rarity(Rarity.UNCOMMON));
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
            if (itemstack.damage(0, new Random(), null)) {
                itemstack.decrement(1);
                itemstack.setDamage(0);
            }
        } else {
            entity.setHealth(entity.getHealth() + MathHelper.nextInt(new Random(), 1, 4));
            if (itemstack.damage(1, new Random(), null)) {
                itemstack.decrement(1);
                itemstack.setDamage(0);
            }
        }
        return ar;
    }
}
