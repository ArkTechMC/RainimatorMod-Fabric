package com.rainimator.rainimatormod.network;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.data.config.ModConfig;
import com.rainimator.rainimatormod.registry.ModEnchantments;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.CommonTickingComponent;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ManaComponent implements ComponentV3, AutoSyncedComponent, CommonTickingComponent {
    public static final ComponentKey<ManaComponent> MANA_COMPONENT = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(RainimatorMod.MOD_ID, "mana"), ManaComponent.class);

    public LivingEntity entity;
    private double mana = 0;
    private double restoreSpeed;
    private double maxMana;
    private boolean enabled = true;

    public ManaComponent(LivingEntity entity) {
        this.entity = entity;
        this.restoreSpeed = ModConfig.getInstance().baseRestoreSpeed;
        this.maxMana = ModConfig.getInstance().baseMaxMana;
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        this.mana = tag.getDouble("mana");
        this.restoreSpeed = tag.getDouble("restoreSpeed");
        this.maxMana = tag.getDouble("maxMana");
        this.enabled = tag.getBoolean("enabled");
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putDouble("mana", this.mana);
        tag.putDouble("restoreSpeed", this.restoreSpeed);
        tag.putDouble("maxMana", this.maxMana);
        tag.putBoolean("enabled", this.enabled);
    }

    public double getMana() {
        return this.mana;
    }

    public double getMaxMana() {
        return this.maxMana;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean tryUseMana(double amount) {
        if (this.entity instanceof PlayerEntity player && player.isCreative()) return true;
        if (amount > this.mana) return false;
        this.mana -= amount;
        doSync(this.entity);
        return true;
    }

    private void measureMaxMana() {
        double base = ModConfig.getInstance().baseMaxMana, multiple = 1.0, modifier = 0.0;
        Map<EquipmentSlot, ItemStack> upgrade = ModEnchantments.MANA_UPGRADE.getEquipment(this.entity);
        for (Map.Entry<EquipmentSlot, ItemStack> entry : upgrade.entrySet())
            multiple += EnchantmentHelper.getLevel(ModEnchantments.MANA_UPGRADE, entry.getValue());
        this.maxMana = base * multiple + modifier;
    }

    private void measureRestoreSpeed() {
        double base = ModConfig.getInstance().baseRestoreSpeed, multiple = 1.0, modifier = 0.0;
        Map<EquipmentSlot, ItemStack> regeneration = ModEnchantments.MANA_REGENERATION.getEquipment(this.entity);
        for (Map.Entry<EquipmentSlot, ItemStack> entry : regeneration.entrySet())
            multiple += EnchantmentHelper.getLevel(ModEnchantments.MANA_REGENERATION, entry.getValue());
        this.restoreSpeed = base * multiple + modifier;
    }

    @Override
    public void tick() {
        this.measureMaxMana();
        this.measureRestoreSpeed();
        this.mana += this.restoreSpeed / 20;
        if (this.mana > this.maxMana)
            this.mana = this.maxMana;
    }

    public static void doSync(LivingEntity entity) {
        ManaComponent.MANA_COMPONENT.sync(entity);
    }

    public static boolean tryUse(PlayerEntity player,double amount){
        if (ManaComponent.MANA_COMPONENT.get(player).tryUseMana(amount)) return true;
        player.sendMessage(Text.translatable("message.rainimator.mana.not_enough"), true);
        return false;
    }
}
