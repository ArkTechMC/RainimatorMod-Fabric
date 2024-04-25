package com.rainimator.rainimatormod.config;

import com.google.gson.Gson;
import com.rainimator.rainimatormod.RainimatorMod;

import java.io.FileReader;
import java.io.IOException;

public class ModConfig {
    private static ModConfig INSTANCE = new ModConfig();
    private static final String CONFIG_PATH = "./config/" + RainimatorMod.MOD_ID + "/";
    public FractionType fraction = FractionType.OFF;

    public ModConfig() {
    }

    public static ModConfig getInstance() {
        return INSTANCE;
    }

    public static void load() {
        RainimatorMod.LOGGER.info("Loading Rainimator Mod Config...");
        try {
            FileReader reader = new FileReader(CONFIG_PATH + "main.json");
            INSTANCE = new Gson().fromJson(reader, ModConfig.class);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
