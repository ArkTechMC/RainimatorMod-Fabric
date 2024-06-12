package dev.rainimator.mod.ability;

import com.iafenvoy.annotationlib.api.AnnotationApi;

import java.util.HashMap;

public class AbilityManager {
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
        AnnotationApi.registerHotkeyHandler("ability", (server, player, handler, buf, responseSender) -> {
            System.out.println(111);
        });
    }
}
