package com.rainimator.rainimatormod.registry.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class FoilSwordItemBase extends SwordItemBase {
    public FoilSwordItemBase(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean hasGlint(ItemStack itemstack) {
        return true;
    }
}
