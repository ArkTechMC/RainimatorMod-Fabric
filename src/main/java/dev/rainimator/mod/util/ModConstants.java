package dev.rainimator.mod.util;

import dev.rainimator.mod.RainimatorMod;
import net.minecraft.util.Identifier;

public class ModConstants {
    public static final int SEA_LEVEL = 63;
    public static final String ABILITY_PACKET_PATH = "ability_c2s";
    public static final Identifier ABILITY_PACKET_ID = new Identifier(RainimatorMod.MOD_ID, ModConstants.ABILITY_PACKET_PATH);
    public static final String ENDER_BOOK_SKILL_PACKET_PATH = "ender_book_skill_c2s";
    public static final Identifier ENDER_BOOK_SKILL_PACKET_ID = new Identifier(RainimatorMod.MOD_ID, ModConstants.ENDER_BOOK_SKILL_PACKET_PATH);
}
