package dev.rainimator.mod.ability;

import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.data.component.ManaComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public abstract class Ability {
    public static final Ability EMPTY = new EmptyAbility("", 0);
    private final String id;
    private final double manaRequired;

    public Ability(String id, double manaRequired) {
        this.id = id;
        this.manaRequired = manaRequired;
    }

    public boolean tryUseMana(PlayerEntity player) {
        return ManaComponent.tryUse(player, this.manaRequired);
    }

    public abstract boolean release(PlayerEntity player);

    public abstract AbilityType type();

    public String getTranslationKey() {
        return "ability." + RainimatorMod.MOD_ID + "." + this.id;
    }

    public String getId() {
        return this.id;
    }

    public enum AbilityType {
        NONE, RING, ITEM
    }

    public static abstract class AbilityWithRing extends Ability {
        public AbilityWithRing(String id, double manaRequired) {
            super(id, manaRequired);
        }

        @Override
        public AbilityType type() {
            return AbilityType.RING;
        }
    }

    public static abstract class AbilityWithItem extends Ability {
        public AbilityWithItem(String id, double manaRequired) {
            super(id, manaRequired);
        }

        @Override
        public AbilityType type() {
            return AbilityType.ITEM;
        }

        public abstract ItemStack hasItem(PlayerEntity player);

        @Override
        public boolean release(PlayerEntity player) {
            return this.release(player, ItemStack.EMPTY);
        }

        public abstract boolean release(PlayerEntity player, ItemStack stack);
    }

    private static class EmptyAbility extends AbilityWithRing {
        public EmptyAbility(String id, double manaRequired) {
            super(id, manaRequired);
        }

        @Override
        public boolean release(PlayerEntity player) {
            return false;
        }
    }
}
