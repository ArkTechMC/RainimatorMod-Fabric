package com.rainimator.rainimatormod.item.block;

import com.rainimator.rainimatormod.registry.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

public class BlueDiamondBlock extends Block {

    public BlueDiamondBlock() {
        super(FabricBlockSettings.create().requiresTool().strength(6).sounds(BlockSoundGroup.METAL));
    }

    @Override
    public int getOpacity(BlockState state, BlockView worldIn, BlockPos pos) {
        return 15;
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);
        dropStack(world,pos,new ItemStack(ModBlocks.BLUE_DIAMOND_BLOCK));
    }
}