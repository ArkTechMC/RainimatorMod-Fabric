package dev.rainimator.mod.item;

import com.iafenvoy.mcrconvertlib.item.ItemBase;
import dev.rainimator.mod.util.ModConstants;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
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
        if (!world.isClient() && entity instanceof ServerPlayerEntity serverPlayer)
            ServerPlayNetworking.send(serverPlayer, ModConstants.ENDER_BOOK_SKILL_PACKET_ID, PacketByteBufs.create());
        return ar;
    }
}
