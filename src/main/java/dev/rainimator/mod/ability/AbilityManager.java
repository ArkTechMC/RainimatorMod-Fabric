package dev.rainimator.mod.ability;

import dev.rainimator.mod.RainimatorMod;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class AbilityManager {
    public static final String ABILITY_KEY = "ability_hotkey";
    private static final HashMap<String, Ability> abilities = new HashMap<>();

    static {
        register(Ability.EMPTY);
    }

    public static Ability getOrEmpty(String id) {
        return abilities.getOrDefault(id, Ability.EMPTY);
    }

    public static void register(Ability ability) {
        abilities.put(ability.getId(), ability);
    }

    public static void init() {
        ServerPlayNetworking.registerGlobalReceiver(new Identifier(RainimatorMod.MOD_ID, ABILITY_KEY), (server, player, handler, buf, responseSender) -> {
            System.out.println(111);
        });
    }
}
