package com.rainimator.rainimatormod.block;

import com.rainimator.rainimatormod.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.List;

public class DeepslateSapphireOreBlock extends Block {
    public DeepslateSapphireOreBlock() {
        super(Settings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(4.0F, 10.0F).luminance(s -> 1).requiresTool());
    }

    @Deprecated
    @Override
    public int getOpacity(BlockState state, BlockView worldIn, BlockPos pos) {
        return 15;
    }

    @Deprecated
    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootContext.Builder builder) {
        List<ItemStack> dropsOriginal = super.getDroppedStacks(state, builder);
        if (!dropsOriginal.isEmpty())
            return dropsOriginal;
        return Collections.singletonList(new ItemStack(ModItems.RAW_RUBY));
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        if (player != null) {
            double[] p = {0.25, 0.2, 0.15, 0.1, 0.05};
            for (int i = 1; i <= EnchantmentHelper.getLevel(Enchantments.FORTUNE, player.getMainHandStack()); i++)
                if (Math.random() < p[i - 1]) {
                    for (int j = 0; j < i; j++) {
                        ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(ModItems.RAW_RUBY));
                        entityToSpawn.setPickupDelay(50);
                        world.spawnEntity(entityToSpawn);
                    }
                    break;
                }
            for (int i = 1; i <= EnchantmentHelper.getLevel(Enchantments.FORTUNE, player.getOffHandStack()); i++)
                if (Math.random() < p[i - 1]) {
                    for (int j = 0; j < i; j++) {
                        ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(ModItems.RAW_RUBY));
                        entityToSpawn.setPickupDelay(50);
                        world.spawnEntity(entityToSpawn);
                    }
                    break;
                }
        }
    }
}