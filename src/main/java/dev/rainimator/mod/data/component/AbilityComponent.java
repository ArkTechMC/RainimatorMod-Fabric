package dev.rainimator.mod.data.component;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.CommonTickingComponent;
import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.ability.Ability;
import dev.rainimator.mod.ability.AbilityManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class AbilityComponent implements ComponentV3, AutoSyncedComponent, CommonTickingComponent {
    public static final ComponentKey<AbilityComponent> ABILITY_COMPONENT = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(RainimatorMod.MOD_ID, "ability"), AbilityComponent.class);
    private final List<Ability> abilities = new ArrayList<>();
    public LivingEntity entity;
    private boolean enabled = true;

    public AbilityComponent(LivingEntity entity) {
        this.entity = entity;
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        this.abilities.clear();
        NbtList list = tag.getList("ability", NbtElement.STRING_TYPE);
        for (int i = 0; i < list.size(); i++)
            this.abilities.add(AbilityManager.getOrEmpty(list.getString(i)));
        this.enabled = tag.getBoolean("enabled");
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        NbtList list = new NbtList();
        this.abilities.forEach(x -> list.add(NbtString.of(x.getId())));
        tag.put("ability", list);
        tag.putBoolean("enabled", this.enabled);
    }

    public List<Ability> getAbilities() {
        return this.abilities;
    }

    public boolean addAbility(Ability ability) {
        if (this.abilities.contains(ability)) return false;
        this.abilities.add(ability);
        this.doSync();
        return true;
    }

    public boolean removeAbility(Ability ability) {
        if (!this.abilities.contains(ability)) return false;
        this.abilities.remove(ability);
        this.doSync();
        return true;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public void tick() {
    }

    public void doSync() {
        AbilityComponent.ABILITY_COMPONENT.sync(this.entity);
    }
}
