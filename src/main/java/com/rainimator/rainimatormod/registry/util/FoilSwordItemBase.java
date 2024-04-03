package com.rainimator.rainimatormod.registry.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class FoilSwordItemBase extends SwordItemBase {
    public FoilSwordItemBase(ToolMaterial p_43269_, int p_43270_, float p_43271_, Settings p_43272_) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean hasGlint(ItemStack itemstack) {
        return true;
    }
}
