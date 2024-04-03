package com.rainimator.rainimatormod.item;

import com.rainimator.rainimatormod.gui.EnderBookSkillScreen;
import com.rainimator.rainimatormod.registry.util.ItemBase;
import com.rainimator.rainimatormod.registry.util.ModCreativeTab;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class EnderBookItem extends ItemBase {
    public EnderBookItem() {
        super(p -> p.group(ModCreativeTab.items).maxCount(1).rarity(Rarity.EPIC));
    }

    @Override
    public void appendTooltip(ItemStack itemstack, World world, List<Text> list, TooltipContext flag) {
        super.appendTooltip(itemstack, world, list, flag);
        list.add(new TranslatableText("item.rainimator.ender_book.tooltip"));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        TypedActionResult<ItemStack> ar = super.use(world, entity, hand);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();

        MinecraftClient.getInstance().setScreen(new EnderBookSkillScreen(entity.getPos(), new LiteralText("Enderbookskill")));

        return ar;
    }
}
