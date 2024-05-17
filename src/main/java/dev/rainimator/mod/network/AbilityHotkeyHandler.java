package dev.rainimator.mod.network;

import com.iafenvoy.annotationlib.annotation.TargetId;
import com.iafenvoy.annotationlib.annotation.network.NetworkHandler;
import com.iafenvoy.annotationlib.api.IAnnotatedNetworkEntry;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.item.trinket.WingsOfSalvationItem;
import dev.rainimator.mod.registry.ModItems;
import dev.rainimator.mod.util.ModConstants;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Pair;

import java.util.List;
import java.util.Optional;

@NetworkHandler(@TargetId(namespace = RainimatorMod.MOD_ID, value = ModConstants.ABILITY_PACKET_PATH))
public class AbilityHotkeyHandler implements IAnnotatedNetworkEntry, ServerPlayNetworking.PlayChannelHandler {
    @Override
    public void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        Optional<TrinketComponent> component = TrinketsApi.getTrinketComponent(player);
        if (ModItems.WINGS_OF_SALVATION instanceof WingsOfSalvationItem w && component.isPresent()) {
            List<Pair<SlotReference, ItemStack>> stacks = component.get().getEquipped(ModItems.WINGS_OF_SALVATION);
            if (stacks.size() > 0) {
                ItemStack stack = stacks.get(0).getRight();
                w.keyPress(player, stack);
            }
        }
    }
}
