package com.rainimator.rainimatormod.registry.util;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class SwordItemBase extends SwordItem {
    public SwordItemBase(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack itemstack, World world, List<Text> list, TooltipContext flag) {
        super.appendTooltip(itemstack, world, list, flag);
        if (this instanceof IRainimatorInfo)
            list.add(Text.literal(RainimatorInfoManager.getHoverText()));
    }

    public boolean onSwingHand(ItemStack itemstack, World world, double x, double y, double z) {
        return false;
    }
}
