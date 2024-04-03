package com.rainimator.rainimatormod.gui;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.network.EnderBookSkillC2SPacket;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EnderBookSkillScreen extends Screen {
    private final Vec3d pos;

    public EnderBookSkillScreen(Vec3d pos, Text text) {
        super(text);
        this.pos = pos;
    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            if (this.client != null && this.client.player != null)
                this.client.player.closeHandledScreen();
            return true;
        }
        return super.keyPressed(key, b, c);
    }

    @Override
    public void close() {
        super.close();
        MinecraftClient.getInstance().keyboard.setRepeatEvents(false);
    }

    @Override
    public void init() {
        super.init();
        int leftPos = (this.width - 300) / 2;
        int topPos = (this.height - 100) / 2;
        if (this.client != null)
            this.client.keyboard.setRepeatEvents(true);

        this.addDrawableChild(new TexturedButtonWidget(leftPos + 32, topPos + 19, 64, 64, 0, 0, 64, new Identifier(RainimatorMod.MOD_ID, "textures/screens/atlas/overworld.png"), 64, 128, e -> {
            if (this.client.getNetworkHandler() != null)
                this.client.getNetworkHandler().sendPacket(new EnderBookSkillC2SPacket(World.OVERWORLD));
        }));
        this.addDrawableChild(new TexturedButtonWidget(leftPos + 118, topPos + 19, 64, 64, 0, 0, 64, new Identifier(RainimatorMod.MOD_ID, "textures/screens/atlas/nether.png"), 64, 128, e -> {
            if (this.client.getNetworkHandler() != null)
                this.client.getNetworkHandler().sendPacket(new EnderBookSkillC2SPacket(World.NETHER));
        }));
        this.addDrawableChild(new TexturedButtonWidget(leftPos + 203, topPos + 19, 64, 64, 0, 0, 64, new Identifier(RainimatorMod.MOD_ID, "textures/screens/atlas/end.png"), 64, 128, e -> {
            if (this.client.getNetworkHandler() != null)
                this.client.getNetworkHandler().sendPacket(new EnderBookSkillC2SPacket(World.END));
        }));
    }
}