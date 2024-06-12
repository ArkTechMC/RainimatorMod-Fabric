package dev.rainimator.mod.registry;

import com.iafenvoy.annotationlib.annotation.ModId;
import com.iafenvoy.annotationlib.annotation.registration.AutoNetwork;
import com.iafenvoy.annotationlib.annotation.registration.RegisterAll;
import com.iafenvoy.annotationlib.api.IAnnotatedRegistryEntry;
import dev.rainimator.mod.RainimatorMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
@ModId(RainimatorMod.MOD_ID)
@RegisterAll
public class RainimatorKeybindings implements IAnnotatedRegistryEntry {
    @AutoNetwork
    public static final KeyBinding ABILITY = new KeyBinding("keybinding.rainimator.ability", GLFW.GLFW_KEY_C, "keybinding.rainimator.category");
}
