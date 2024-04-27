package com.rainimator.rainimatormod.compat.cca;

import com.rainimator.rainimatormod.RainimatorMod;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ClientTickingComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;

public class ManaComponent implements ComponentV3, AutoSyncedComponent, ServerTickingComponent, ClientTickingComponent {
    public static final ComponentKey<ManaComponent> MANA_COMPONENT = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(RainimatorMod.MOD_ID, "mana"), ManaComponent.class);

    public LivingEntity entity;
    private double mana = 0;
    private final double restoreSpeed = 3;
    private final double maxMana = 100;
    private final boolean enabled = true;

    public ManaComponent(LivingEntity entity) {
        this.entity = entity;
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        this.mana = tag.getDouble("mana");
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putDouble("mana", this.mana);
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
        return true;
    }

    @Override
    public void serverTick() {
        this.mana += this.restoreSpeed;
        if (this.mana > this.maxMana)
            this.mana = this.maxMana;
    }

    @Override
    public void clientTick() {
        this.mana += this.restoreSpeed;
        if (this.mana > this.maxMana)
            this.mana = this.maxMana;
    }
}
