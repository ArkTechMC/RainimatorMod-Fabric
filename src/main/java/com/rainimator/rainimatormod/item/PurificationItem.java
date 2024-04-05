package com.rainimator.rainimatormod.item;

import com.rainimator.rainimatormod.registry.ModEffects;
import com.rainimator.rainimatormod.registry.util.ItemBase;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.List;

public class PurificationItem extends ItemBase {
    public PurificationItem() {
        super(p -> p.maxCount(1).rarity(Rarity.UNCOMMON).food((new FoodComponent.Builder()).hunger(0).saturationModifier(0.0F).alwaysEdible().build()));
    }

    @Override
    public UseAction getUseAction(ItemStack itemtack) {
        return UseAction.DRINK;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean hasGlint(ItemStack itemtack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack itemtack, World world, List<Text> list, TooltipContext flag) {
        super.appendTooltip(itemtack, world, list, flag);
        list.add(Text.translatable("item.rainimator.purification.tooltip"));
    }

    @Override
    public ItemStack finishUsing(ItemStack itemtack, World world, LivingEntity entity) {
        ItemStack retval = new ItemStack(Items.GLASS_BOTTLE);
        super.finishUsing(itemtack, world, entity);
        if (!entity.getWorld().isClient())
            entity.addStatusEffect(new StatusEffectInstance(ModEffects.PURIFICATION, 3000, 0));
        if (itemtack.isEmpty())
            return retval;
        if (entity instanceof PlayerEntity player)
            if (!(player.getAbilities()).creativeMode && !player.getInventory().insertStack(retval))
                player.dropItem(retval, false);
        return itemtack;
    }
}
