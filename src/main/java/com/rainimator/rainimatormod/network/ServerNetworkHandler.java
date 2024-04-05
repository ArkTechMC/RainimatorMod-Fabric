package com.rainimator.rainimatormod.network;

import com.rainimator.rainimatormod.util.ModConstants;
import com.rainimator.rainimatormod.util.Timeout;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ServerNetworkHandler {
    public static void register() {
        ServerPlayNetworking.registerGlobalReceiver(ModConstants.ENDER_BOOK_SKILL_PACKET_ID, (server, player, handler, buf, sender) -> {
            String target = buf.readString(100);
            Identifier identifier = new Identifier(target);
            RegistryKey<World> dimension;
            if (identifier.equals(World.OVERWORLD.getValue()))
                dimension = World.OVERWORLD;
            else if (identifier.equals(World.NETHER.getValue()))
                dimension = World.NETHER;
            else if (identifier.equals(World.END.getValue()))
                dimension = World.END;
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
        });
    }
}
