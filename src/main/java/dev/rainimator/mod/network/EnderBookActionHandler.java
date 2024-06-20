package dev.rainimator.mod.network;

import dev.rainimator.mod.util.Timeout;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.Blocks;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EnderBookActionHandler implements ServerPlayNetworking.PlayChannelHandler {
    @Override
    public void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        String target = buf.readString(100);
        Identifier identifier = new Identifier(target);
        RegistryKey<World> dimension;
        if (identifier.equals(World.OVERWORLD.getValue())) dimension = World.OVERWORLD;
        else if (identifier.equals(World.NETHER.getValue())) dimension = World.NETHER;
        else if (identifier.equals(World.END.getValue())) dimension = World.END;
        else throw new UnsupportedOperationException();
        if (player.getWorld().getRegistryKey() == dimension)
            player.sendMessage(Text.translatable("item.rainimator.ender_book.error"), false);
        else {
            ServerWorld nextLevel = player.server.getWorld(dimension);
            if (nextLevel != null) {
                player.teleport(nextLevel, player.getX(), player.getY(), player.getZ(), player.getYaw(), player.getPitch());
                BlockPos blockBelow = new BlockPos((int) player.getX(), (int) (player.getY() - 1), (int) player.getZ());
                if (nextLevel.getBlockState(blockBelow).getBlock() == Blocks.AIR) {
                    nextLevel.setBlockState(blockBelow, Blocks.DIRT.getDefaultState(), 3);
                    Timeout.create(200, () -> nextLevel.setBlockState(blockBelow, Blocks.AIR.getDefaultState(), 3));
                }
                player.sendMessage(Text.translatable("item.rainimator.ender_book.success"), false);
            }
        }
    }
}
