package com.rainimator.rainimatormod.registry.util;

import net.minecraft.entity.player.PlayerEntity;

public class ManaRequireImpl implements IManaRequire {
    private final double manaPerUse;

    public ManaRequireImpl(double manaPerUse) {
        this.manaPerUse = manaPerUse;
    }

    @Override
    public double manaPerUse() {
        return this.manaPerUse;
    }
}
