package dev.rainimator.mod.registry;

import com.iafenvoy.annotationlib.annotation.CallbackHandler;
import com.iafenvoy.annotationlib.annotation.ModId;
import com.iafenvoy.annotationlib.annotation.registration.RegisterAll;
import com.iafenvoy.annotationlib.api.IAnnotatedRegistryEntry;
import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.util.ModConstants;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
@ModId(RainimatorMod.MOD_ID)
@RegisterAll
public class ModKeybindings implements IAnnotatedRegistryEntry {
    public static final KeyBinding ABILITY = new KeyBinding("keybinding.rainimator.ability", GLFW.GLFW_KEY_C, "keybinding.rainimator.category");

    @CallbackHandler
    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (ABILITY.wasPressed())
                ClientPlayNetworking.send(ModConstants.ABILITY_PACKET_ID, PacketByteBufs.create());
        });
    }
}
