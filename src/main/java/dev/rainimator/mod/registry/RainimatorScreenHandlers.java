package dev.rainimator.mod.registry;

import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.screen.gui.EnderBookSkillScreen;
import dev.rainimator.mod.screen.handler.EnderBookSkillScreenHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class RainimatorScreenHandlers {
    public static final ScreenHandlerType<EnderBookSkillScreenHandler> ENDER_BOOK = register("ender_book", new ScreenHandlerType<>(EnderBookSkillScreenHandler::new, FeatureFlags.VANILLA_FEATURES));

    private static <T extends ScreenHandler> ScreenHandlerType<T> register(String name, ScreenHandlerType<T> type) {
        return Registry.register(Registries.SCREEN_HANDLER, new Identifier(RainimatorMod.MOD_ID, name), type);
    }

    public static void init() {
    }

    public static void registerGui() {
        HandledScreens.register(ENDER_BOOK, EnderBookSkillScreen::new);
    }
}
