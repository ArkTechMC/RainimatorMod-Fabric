package com.rainimator.rainimatormod.command;

import com.google.gson.Gson;
import com.iafenvoy.annotationlib.annotation.command.CommandProcessor;
import com.iafenvoy.annotationlib.annotation.command.Permission;
import com.iafenvoy.annotationlib.api.IAnnotatedCommandEntry;
import com.mojang.brigadier.context.CommandContext;
import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.config.ManaConfig;
import com.rainimator.rainimatormod.config.ModConfig;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("unused")
@CommandProcessor("update_rainimator_config")
public class UpdateConfigCommand implements IAnnotatedCommandEntry {
    @CommandProcessor("main")
    @Permission(1)
    public static int updateMain(CommandContext<ServerCommandSource> context) {
        try {
            saveFile("main.json", ModConfig.getInstance());
            context.getSource().sendFeedback(() -> Text.literal("Success to save main.json!"), true);
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            context.getSource().sendFeedback(() -> Text.literal("Fail to save main.json!"), true);
            return 0;
        }
    }

    @CommandProcessor("mana")
    @Permission(1)
    public static int updateMana(CommandContext<ServerCommandSource> context) {
        try {
            saveFile("mana.json", ManaConfig.getInstance());
            context.getSource().sendFeedback(() -> Text.literal("Success to save mana.json!"), true);
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            context.getSource().sendFeedback(() -> Text.literal("Fail to save mana.json!"), true);
            return 0;
        }
    }

    private static void saveFile(String path, Object content) throws IOException {
        File configFolder = new File("./config/" + RainimatorMod.MOD_ID);
        if (!configFolder.exists())
            configFolder.mkdir();
        FileWriter writer = new FileWriter("./config/" + RainimatorMod.MOD_ID + "/" + path);
        new Gson().toJson(content, writer);
        writer.close();
    }
}
