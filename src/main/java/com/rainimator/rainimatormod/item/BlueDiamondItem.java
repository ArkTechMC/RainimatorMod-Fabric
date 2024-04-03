package com.rainimator.rainimatormod.item;

import com.rainimator.rainimatormod.registry.util.FoilItemBase;
import com.rainimator.rainimatormod.registry.util.ModCreativeTab;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import java.util.List;

public class BlueDiamondItem extends FoilItemBase {
    public BlueDiamondItem() {
        super(p -> p.group(ModCreativeTab.items).fireproof().rarity(Rarity.EPIC));
    }

    @Override
    public void appendTooltip(ItemStack itemstack, World world, List<Text> list, TooltipContext flag) {
        super.appendTooltip(itemstack, world, list, flag);
        list.add(new TranslatableText("item.rainimator.blue_diamond.tooltip1"));
        list.add(new TranslatableText("item.rainimator.blue_diamond.tooltip2"));
    }
}
