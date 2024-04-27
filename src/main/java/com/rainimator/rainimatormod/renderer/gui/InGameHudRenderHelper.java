package com.rainimator.rainimatormod.renderer.gui;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.compat.cca.ManaComponent;
import com.rainimator.rainimatormod.data.config.ModConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class InGameHudRenderHelper {
    public static final Identifier MANA_ICON = new Identifier(RainimatorMod.MOD_ID, "textures/gui/bars.png");

    private static String formatNumber(double number) {
        if (number < 10) return String.format("%.2f", number);
        return String.format("%.0f", number);
    }

    public static String getValueText(double mana, double maxMana) {
        return formatNumber(mana) + "/" + formatNumber(maxMana);
    }

    public static void render(DrawContext context, MinecraftClient client, PlayerEntity playerEntity, int scaledWidth, int scaledHeight, int vehicleHeartCount) {
        if (playerEntity != null && !playerEntity.isInvulnerable()) {
            ManaComponent manaComponent = ManaComponent.MANA_COMPONENT.get(playerEntity);
            if (manaComponent.isEnabled()) {
                int height = scaledHeight - 49, width = scaledWidth / 2 - 91;
                if (vehicleHeartCount == 0) {
                    int y = height + ModConfig.getInstance().manaHudX;
                    int x = width + ModConfig.getInstance().manaHudY;
                    double mana = manaComponent.getMana();
                    double maxMana = manaComponent.getMaxMana();
                    context.drawTexture(MANA_ICON, x - 2, y - 7, 0, 10, 84, 5, 256, 256);
                    context.drawTexture(MANA_ICON, x - 2, y - 7, 0, 15, (int) (84 * mana / maxMana), 5, 256, 256);
                    context.drawCenteredTextWithShadow(client.textRenderer, Text.literal(getValueText(mana, maxMana)), width + 41, y - 14, -1);
                }
            }
        }
    }
}
