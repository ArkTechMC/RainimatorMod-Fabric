package com.rainimator.rainimatormod.registry.util;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.registry.ModItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class ModCreativeTab {
    public static final ItemGroup main = build(RainimatorMod.MOD_ID, () -> ModItems.WARRIOR_HEART);
    public static final ItemGroup mobs = build(RainimatorMod.MOD_ID + "_mobs", () -> ModItems.ICE_HEART);
    public static final ItemGroup items = build(RainimatorMod.MOD_ID + "_items", () -> ModItems.ENDER_HEART);

    public static ItemGroup build(String label, Supplier<Item> icon) {
        return FabricItemGroupBuilder.create(new Identifier(RainimatorMod.MOD_ID, label)).icon(() -> new ItemStack(icon.get())).build();
    }

    public static Item.Settings createProperty() {
        return createProperty(ModCreativeTab.main);
    }

    public static Item.Settings createProperty(String name) {
        return switch (name) {
            case "mobs" -> createProperty(ModCreativeTab.mobs);
            case "items" -> createProperty(ModCreativeTab.items);
            default -> createProperty(ModCreativeTab.main);
        };
    }

    public static Item.Settings createProperty(ItemGroup tab) {
        return new Item.Settings().group(tab);
    }

    public static void load() {
    }
}
