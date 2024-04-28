package com.rainimator.rainimatormod.data.config;

import com.iafenvoy.annotationlib.annotation.config.ConfigFile;
import com.iafenvoy.annotationlib.api.AnnotationApi;
import com.iafenvoy.annotationlib.api.IAnnotatedConfigEntry;
import com.rainimator.rainimatormod.RainimatorMod;

@ConfigFile(path = "./config/" + RainimatorMod.MOD_ID, file = "mana.json")
public class ManaConfig implements IAnnotatedConfigEntry {
    public double blackbone_the_blade = 30;
    public double blue_diamond_sword = 40;
    public double ender_big_sword = 15;
    public double fallen_soul_axe = 30;
    public double naeus_sword = 15;
    public double nether_spear = 30;
    public double rain_sword = 30;
    public double seizing_shadow_halberd = 50;
    public double zecanirn_the_blade = 35;
    public double herobrine_diamond_pickaxe = 5;
    public double intelligence_tomahawk = 20;
    public double divine_core = 5;
    public double nether_nuclear_reactor = 5;
    public double soul_totem = 5;
    public double under_flower = 5;
    public double wings_of_salvation_second = 10;
    public double wings_of_salvation_boost = 25;

    public static ManaConfig getInstance() {
        return AnnotationApi.getConfig(ManaConfig.class);
    }
}
