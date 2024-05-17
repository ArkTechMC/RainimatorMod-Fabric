package dev.rainimator.mod.network;

import com.iafenvoy.annotationlib.annotation.TargetId;
import com.iafenvoy.annotationlib.annotation.network.NetworkHandler;
import com.iafenvoy.annotationlib.api.IAnnotatedNetworkEntry;
import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.renderer.gui.EnderBookSkillScreen;
import dev.rainimator.mod.util.ModConstants;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;

@NetworkHandler(@TargetId(namespace = RainimatorMod.MOD_ID, value = ModConstants.ENDER_BOOK_SKILL_PACKET_PATH))
public class EnderBookOpenHandler implements IAnnotatedNetworkEntry, ClientPlayNetworking.PlayChannelHandler {
    @Override
    public void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        client.execute(() -> client.setScreen(new EnderBookSkillScreen(Text.literal("Ender Book"))));
    }
}
