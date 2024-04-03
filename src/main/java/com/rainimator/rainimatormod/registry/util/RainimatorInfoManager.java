package com.rainimator.rainimatormod.registry.util;

import com.rainimator.rainimatormod.gui.ModItemInfoScreen;
import com.rainimator.rainimatormod.util.Episode;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.Item;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import org.lwjgl.glfw.GLFW;

import java.util.Optional;

public class RainimatorInfoManager {
    public static void onRenderToolTip(Item item) {
        if (!InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_LEFT_ALT))
            return;
        if (item instanceof IRainimatorInfo info && info.getEpisode() != Episode.None) {
            Optional<RegistryKey<Item>> optLocation = Registry.ITEM.getKey(item);
            if (optLocation.isEmpty()) return;
            Identifier location = optLocation.get().getValue();
            if (location == null) return;
            String id = location.getPath();
            ModItemInfoScreen.InfoType infoType = ModItemInfoScreen.InfoType.Item;
            if (item instanceof SpawnEggBase) {
                id = id.replace("_spawn_egg", "");
                infoType = ModItemInfoScreen.InfoType.Entity;
            }
            MinecraftClient.getInstance().setScreen(new ModItemInfoScreen(new LiteralText("ModItemInfo"),
                    new ModItemInfoScreen.ItemInfo(id, location.getPath(), infoType, info.getEpisode()),
                    MinecraftClient.getInstance().currentScreen
            ));
        }
    }

    public static String getHoverText() {
        return I18n.translate("gui.rainimator.item_info.alt_info");
    }
}
