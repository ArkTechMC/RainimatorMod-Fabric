package com.rainimator.rainimatormod.registry;

import com.iafenvoy.annotationlib.annotation.ModId;
import com.iafenvoy.annotationlib.annotation.registration.ObjectReg;
import com.iafenvoy.annotationlib.api.IAnnotatedRegistryEntry;
import com.iafenvoy.annotationlib.api.ItemGroupApi;
import com.rainimator.rainimatormod.RainimatorMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@ModId(RainimatorMod.MOD_ID)
@SuppressWarnings("unused")
public class ModCreativeTabs implements IAnnotatedRegistryEntry {
    @ObjectReg
    public static final ItemGroup main = FabricItemGroup.builder().entries(((displayContext, entries) -> ItemGroupApi.addItemToGroup(new Identifier(RainimatorMod.MOD_ID, "main"), entries))).displayName(Text.translatable("itemGroup." + RainimatorMod.MOD_ID + ".rainimator")).icon(() -> new ItemStack(ModItems.WARRIOR_HEART)).build();
    @ObjectReg
    public static final ItemGroup mobs = FabricItemGroup.builder().entries(((displayContext, entries) -> ItemGroupApi.addItemToGroup(new Identifier(RainimatorMod.MOD_ID, "mobs"), entries))).displayName(Text.translatable("itemGroup." + RainimatorMod.MOD_ID + ".rainimator_mobs")).icon(() -> new ItemStack(ModItems.ICE_HEART)).build();
    @ObjectReg
    public static final ItemGroup item = FabricItemGroup.builder().entries(((displayContext, entries) -> ItemGroupApi.addItemToGroup(new Identifier(RainimatorMod.MOD_ID, "item"), entries))).displayName(Text.translatable("itemGroup." + RainimatorMod.MOD_ID + ".rainimator_item")).icon(() -> new ItemStack(ModItems.ENDER_HEART)).build();
}