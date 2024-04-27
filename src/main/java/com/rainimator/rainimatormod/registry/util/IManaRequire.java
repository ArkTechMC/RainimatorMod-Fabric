package com.rainimator.rainimatormod.registry.util;

import com.rainimator.rainimatormod.compat.cca.ManaComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public interface IManaRequire {
    default boolean tryUse(PlayerEntity player) {
        if (ManaComponent.MANA_COMPONENT.get(player).tryUseMana(this.manaPerUse())) return true;
        player.sendMessage(Text.translatable("message.rainimator.mana.not_enough"), true);
        return false;
    }

    double manaPerUse();
}
