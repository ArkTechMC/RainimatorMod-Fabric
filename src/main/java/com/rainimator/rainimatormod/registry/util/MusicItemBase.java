package com.rainimator.rainimatormod.registry.util;

import com.rainimator.rainimatormod.registry.ModSounds;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import java.util.List;

public class MusicItemBase extends MusicDiscItem {
    public MusicItemBase(String musicId) {
        super(2, ModSounds.REGISTRY.get(musicId), new Settings().maxCount(1).rarity(Rarity.RARE), 0);
    }//TODO:LENGTH

    @Override
    @Environment(EnvType.CLIENT)
    public boolean hasGlint(ItemStack itemtack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack itemtack, World world, List<Text> list, TooltipContext flag) {
        super.appendTooltip(itemtack, world, list, flag);
        if (this instanceof IRainimatorInfo)
            list.add(Text.literal(RainimatorInfoManager.getHoverText()));
    }
}
