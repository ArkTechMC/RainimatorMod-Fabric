package com.rainimator.rainimatormod.network;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.s2c.play.*;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

public class EnderBookSkillC2SPacket implements Packet<ServerPlayNetworkHandler> {
    private final RegistryKey<World> dimension;

    public EnderBookSkillC2SPacket(RegistryKey<World> dimension) {
        this.dimension = dimension;
    }

    public EnderBookSkillC2SPacket(PacketByteBuf buf) {
        Identifier identifier = new Identifier(buf.readString(128));
        if (identifier.equals(World.OVERWORLD.getValue()))
            this.dimension = World.OVERWORLD;
        else if (identifier.equals(World.NETHER.getValue()))
            this.dimension = World.NETHER;
        else if (identifier.equals(World.END.getValue()))
            this.dimension = World.END;
        else throw new UnsupportedOperationException("Unknown Dimension : " + identifier);
    }

    @Override
    public void write(PacketByteBuf buf) {
        buf.writeString(this.dimension.getValue().toString());
    }

    @Override
    public void apply(ServerPlayNetworkHandler handler) {
        ServerPlayerEntity player = handler.getPlayer();
        if (player.world.getRegistryKey() == this.dimension)
            player.sendMessage(new TranslatableText("item.rainimator.ender_book.error"), false);
        else {
            ServerWorld nextLevel = player.server.getWorld(this.dimension);
            if (nextLevel != null) {
                player.teleport(nextLevel, player.getX(), player.getY(), player.getZ(), player.getYaw(), player.getPitch());
                handler.sendPacket(new CloseScreenS2CPacket(0));
                handler.sendPacket(new PlayerAbilitiesS2CPacket(player.getAbilities()));
                handler.sendPacket(new GameStateChangeS2CPacket(GameStateChangeS2CPacket.GAME_WON, 0.0F));
                for (StatusEffectInstance effectInstance : player.getStatusEffects())
                    handler.sendPacket(new EntityStatusEffectS2CPacket(player.getId(), effectInstance));
                handler.sendPacket(new WorldEventS2CPacket(1032, BlockPos.ORIGIN, 0, false));
                player.sendMessage(new TranslatableText("item.rainimator.ender_book.success"), false);
            }
        }
    }
}
