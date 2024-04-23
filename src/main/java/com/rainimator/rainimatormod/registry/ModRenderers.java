package com.rainimator.rainimatormod.registry;

import com.rainimator.rainimatormod.renderer.armor.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;

@Environment(EnvType.CLIENT)
public class ModRenderers {
    public static void registerRenderers() {
        ArmorRenderer.register(new GluttonArmorHelmetRenderer(), ModItems.GLUTTON_HELMET);
        ArmorRenderer.register(new KingNormalCrownRenderer(), ModItems.KING_NORMAL_CROWN);
        ArmorRenderer.register(new MagicHatRenderer(), ModItems.MAGIC_HAT_HELMET);
        ArmorRenderer.register(new NetherTheCrownRenderer(), ModItems.NETHER_THE_CROWN_HELMET);
        ArmorRenderer.register(new PiglinKingCrownRenderer(), ModItems.PIGLIN_KING_CROWN);
        ArmorRenderer.register(new PorkshireKingCrownRenderer(), ModItems.PORKSHIRE_KING_CROWN);
    }
}
