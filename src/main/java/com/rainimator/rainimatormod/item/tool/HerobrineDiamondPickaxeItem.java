package com.rainimator.rainimatormod.item.tool;

import com.iafenvoy.mcrconvertlib.item.ToolMaterialUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class HerobrineDiamondPickaxeItem extends PickaxeItem {
    public HerobrineDiamondPickaxeItem() {
        super(ToolMaterialUtil.of(2500, 20.0F, 5.0F, 4, 25, Items.DIAMOND), 1, -2.2F, new Settings().fireproof());
    }

    @Override
    public boolean postMine(ItemStack itemtack, World world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
        boolean retval = super.postMine(itemtack, world, blockstate, pos, entity);
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        if (Math.random() < 0.5D)
            for (double i = -1; i <= 1; i++)
                for (double j = -1; j <= 1; j++)
                    if (i != 0 || j != 0) {
                        BlockPos _pos = new BlockPos((int) (x + i), (int) y, (int) (z + j));
                        Block.dropStacks(((WorldAccess) world).getBlockState(_pos), world, new BlockPos((int) x, (int) y, (int) z), null);
                        world.breakBlock(_pos, false);
                    }
        return retval;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        super.useOnBlock(context);
        World world = context.getWorld();
        double x = context.getBlockPos().getX();
        double y = context.getBlockPos().getY();
        double z = context.getBlockPos().getZ();
        if (context.getPlayer() != null) {
            world.breakBlock(new BlockPos((int) x, (int) y, (int) z), false);
            if (!world.isClient())
                world.spawnEntity(new ExperienceOrbEntity(world, x, y, z, 10));
            if (context.getPlayer() instanceof PlayerEntity)
                if (!context.getPlayer().getWorld().isClient())
                    context.getPlayer().sendMessage(Text.translatable("item.rainimator.herobrine_diamond_pickaxe.breakblock"), true);
            if (context.getPlayer() instanceof PlayerEntity)
                context.getPlayer().getItemCooldownManager().set(context.getStack().getItem(), 4800);
        }

        return ActionResult.SUCCESS;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean hasGlint(ItemStack itemtack) {
        return true;
    }
}
