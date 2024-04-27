package com.rainimator.rainimatormod.compat.asteorbar;

import com.afoxxvi.asteorbar.overlay.parts.SimpleBarOverlay;
import com.afoxxvi.asteorbar.utils.GuiHelper;
import com.rainimator.rainimatormod.compat.cca.ManaComponent;
import com.rainimator.rainimatormod.gui.InGameHudRenderHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;

public class ManaHud extends SimpleBarOverlay {
    @Override
    protected Parameters getParameters(PlayerEntity playerEntity) {
        ManaComponent manaComponent = ManaComponent.MANA_COMPONENT.get(playerEntity);
        Parameters parameters = new Parameters();
        parameters.capacity = manaComponent.getMaxMana();
        parameters.value = manaComponent.getMana();
        parameters.fillColor = 0xFF00FFFF;
        parameters.boundColor = 0xFF004444;
        parameters.emptyColor = 0xFF444444;
        parameters.centerColor = 0xFFFFFF;
        parameters.centerText = InGameHudRenderHelper.getValueText(manaComponent.getMana(), manaComponent.getMaxMana());
        return parameters;
    }

    @Override
    protected boolean shouldRender(PlayerEntity playerEntity) {
        return true;
    }

    @Override
    protected boolean isLeftSide() {
        return true;
    }

    @Override
    protected void drawDecorations(DrawContext guiGraphics, int left, int top, int right, int bottom, Parameters parameters, boolean flip) {
        int x = left + 2, y = top - 2;
        x -= MinecraftClient.getInstance().textRenderer.getWidth(parameters.centerText) / 2 - 40;
        GuiHelper.drawString(guiGraphics, parameters.centerText, x, y, parameters.centerColor, true);
    }
}
