package com.rainimator.rainimatormod.registry.util;

import com.rainimator.rainimatormod.util.Episode;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class SpawnEggBase extends SpawnEggItem implements IRainimatorInfo {
    private final Episode episode;

    public SpawnEggBase(Episode episode, EntityType<? extends MobEntity> type, int backgroundColor, int highlightColor, Settings props) {
        super(type, backgroundColor, highlightColor, props);
        this.episode = episode;
    }

    @Override
    public void appendTooltip(ItemStack itemtack, World world, List<Text> list, TooltipContext flag) {
        super.appendTooltip(itemtack, world, list, flag);
        if (this.episode != Episode.None)
            list.add(Text.literal(RainimatorInfoManager.getHoverText()));
    }

    @Override
    public Episode getEpisode() {
        return this.episode;
    }
}
