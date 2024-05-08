package com.rainimator.rainimatormod.data.config;

import com.iafenvoy.annotationlib.annotation.config.ConfigFile;
import com.iafenvoy.annotationlib.api.AnnotationApi;
import com.iafenvoy.annotationlib.api.IAnnotatedConfigEntry;
import com.rainimator.rainimatormod.RainimatorMod;

@ConfigFile(path = "./config/" + RainimatorMod.MOD_ID, file = "main.json")
public class ModConfig implements IAnnotatedConfigEntry {
    public FractionType fraction = FractionType.OFF;
    public int manaHudX = 0;
    public int manaHudY = 0;

    public static ModConfig getInstance() {
        return AnnotationApi.getConfig(ModConfig.class);
    }

}
