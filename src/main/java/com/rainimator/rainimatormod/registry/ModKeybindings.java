package com.rainimator.rainimatormod.registry;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class ModKeybindings {
    public static final KeyBinding ABILITY = new KeyBinding("keybinding.rainimator.ability", GLFW.GLFW_KEY_C, "keybinding.rainimator.category");

    public static void register() {
        KeyBindingHelper.registerKeyBinding(ABILITY);
    }
}
