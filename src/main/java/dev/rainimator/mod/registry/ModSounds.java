package dev.rainimator.mod.registry;

import dev.rainimator.mod.RainimatorMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class ModSounds {
    public static final String[] idMap = new String[]{
            "blackbone", "ceris_live", "ceris_skill", "ceris_f", "him_skill", "naeus_living", "fire_soul", "rain_sword_skill", "rain_sword_skill_2",
            "blackbone_living", "blackbone_skill", "naeus_roll", "ceris_death", "naeus_sword_1", "power_skill", "under_flower",
            "sword_teleport1", "sword_teleport2", "sword_teleport3", "sword_teleport4",
            "black_death_sword_skill", "black_death_sword_skills", "black_death_sword_skill_3",
            "gift_box", "him", "stunned",
            "blued_diamond_skill_1", "blue_diamond_skill_2", "blue_diamond_skill_3", "blue_diamond_skill_4",
            "ceris_boss_music", "null_boss_music", "blackbone_boss_music", "piglin_king_boss_music", "naeus_boss_music",
            "glutton_boss_music", "him_music_boss", "him_one_lives", "kralos_boss_music", "klaus_boss_music"
    };
    public static final Map<String, SoundEvent> REGISTRY = new HashMap<>();

    public static void registerSounds() {
        for (String id : idMap) {
            Identifier location = new Identifier(RainimatorMod.MOD_ID, id);
            SoundEvent soundEvent = SoundEvent.of(location);
            Registry.register(Registries.SOUND_EVENT, location, soundEvent);
            REGISTRY.put(id, soundEvent);
        }
    }
}