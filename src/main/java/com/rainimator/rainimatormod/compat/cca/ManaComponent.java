package com.rainimator.rainimatormod.compat.cca;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.config.ModConfig;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.CommonTickingComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;

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
        this.maxMana = base * multiple + modifier;
    }

    private void measureRestoreSpeed() {
        double base = ModConfig.getInstance().baseRestoreSpeed, multiple = 1.0, modifier = 0.0;
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
}
