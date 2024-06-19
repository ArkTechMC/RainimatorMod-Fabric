package dev.rainimator.mod.registry;

import dev.rainimator.mod.RainimatorMod;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class RainimatorKeybindings {
    public static final KeyBinding ABILITY = KeyBindingHelper.registerKeyBinding(new KeyBinding("keybinding.rainimator.ability", GLFW.GLFW_KEY_C, "keybinding.rainimator.category"));

    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (ABILITY.wasPressed())
                ClientPlayNetworking.send(new Identifier(RainimatorMod.MOD_ID, "ability_hotkey"), PacketByteBufs.create());
        });
    }
}
