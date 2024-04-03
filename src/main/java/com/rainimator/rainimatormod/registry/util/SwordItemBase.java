package com.rainimator.rainimatormod.registry.util;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class SwordItemBase extends SwordItem {
    public SwordItemBase(ToolMaterial p_43269_, int p_43270_, float p_43271_, Settings p_43272_) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
    }

    @Override
    public void appendTooltip(ItemStack itemstack, World world, List<Text> list, TooltipContext flag) {
        super.appendTooltip(itemstack, world, list, flag);
        if (this instanceof IRainimatorInfo)
            list.add(new LiteralText(RainimatorInfoManager.getHoverText()));
    }

    public boolean onSwingHand(ItemStack itemstack, World world, double x, double y, double z) {
        return false;
    }
}
