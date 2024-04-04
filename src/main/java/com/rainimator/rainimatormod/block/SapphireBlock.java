package com.rainimator.rainimatormod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.Collections;
import java.util.List;

public class SapphireBlock extends Block {
    public SapphireBlock() {
        super(Settings.create().sounds(BlockSoundGroup.STONE).strength(4.0F, 10.0F));
    }

    @Deprecated
    @Override
    public int getOpacity(BlockState state, BlockView worldIn, BlockPos pos) {
        return 15;
    }

    @Deprecated
    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootContextParameterSet.Builder builder) {
        List<ItemStack> dropsOriginal = super.getDroppedStacks(state, builder);
        if (!dropsOriginal.isEmpty())
            return dropsOriginal;
        return Collections.singletonList(new ItemStack(this, 1));
    }
}