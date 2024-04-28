package com.rainimator.rainimatormod.compat.asteorbar;

import com.afoxxvi.asteorbar.overlay.parts.SimpleBarOverlay;
import com.rainimator.rainimatormod.network.ManaComponent;
import com.rainimator.rainimatormod.renderer.gui.InGameHudRenderHelper;
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
}
