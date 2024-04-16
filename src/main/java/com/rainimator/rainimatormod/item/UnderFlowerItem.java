package com.rainimator.rainimatormod.item;

import com.iafenvoy.mcrconvertlib.item.FoilItemBase;
import com.iafenvoy.mcrconvertlib.world.SoundUtil;
import com.rainimator.rainimatormod.RainimatorMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UnderFlowerItem extends FoilItemBase {
    public UnderFlowerItem() {
        super(p -> p.maxCount(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        super.useOnBlock(context);
        World world = context.getWorld();
        double x = context.getBlockPos().getX();
        double y = context.getBlockPos().getY();
        double z = context.getBlockPos().getZ();
        PlayerEntity entity = context.getPlayer();
        ItemStack itemtack = context.getStack();
        if (entity != null) {
            BlockState _bs;
            if (entity.isSneaking())
                _bs = Blocks.SOUL_FIRE.getDefaultState();
            else
                _bs = Blocks.FIRE.getDefaultState();
            SoundUtil.playSound(world, x, y, z, new Identifier(RainimatorMod.MOD_ID, "under_flower"), 1.0F, 1.0F);
            BlockPos _bp = new BlockPos((int) x, (int) (y + 1.0D), (int) z);
            world.setBlockState(_bp, _bs, 3);
            entity.getItemCooldownManager().set(itemtack.getItem(), 400);
        }
        return ActionResult.SUCCESS;
    }
}
