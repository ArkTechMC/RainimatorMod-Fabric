package com.rainimator.rainimatormod.item;

import com.rainimator.rainimatormod.gui.EnderBookSkillScreen;
import com.rainimator.rainimatormod.registry.util.ItemBase;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class EnderBookItem extends ItemBase {
    public EnderBookItem() {
        super(p -> p.maxCount(1).rarity(Rarity.EPIC));
    }

    @Override
    public void appendTooltip(ItemStack itemtack, World world, List<Text> list, TooltipContext flag) {
        super.appendTooltip(itemtack, world, list, flag);
        list.add(Text.translatable("item.rainimator.ender_book.tooltip"));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        TypedActionResult<ItemStack> ar = super.use(world, entity, hand);
        MinecraftClient.getInstance().setScreen(new EnderBookSkillScreen(entity.getPos(), Text.literal("EnderBookSkill")));
        return ar;
    }
}
