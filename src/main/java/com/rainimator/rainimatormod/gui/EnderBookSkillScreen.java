package com.rainimator.rainimatormod.gui;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.util.ModConstants;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

@Environment(EnvType.CLIENT)
public class EnderBookSkillScreen extends Screen {

    public EnderBookSkillScreen(Vec3d pos, Text text) {
        super(text);
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
    public void init() {
        super.init();
        int leftPos = (this.width - 300) / 2;
        int topPos = (this.height - 100) / 2;

        this.addDrawableChild(new TexturedButtonWidget(leftPos + 32, topPos + 19, 64, 64, 0, 0, 64, new Identifier(RainimatorMod.MOD_ID, "textures/screens/atlas/overworld.png"), 64, 128, e -> {
            ClientPlayNetworking.send(ModConstants.ENDER_BOOK_SKILL_PACKET_ID, PacketByteBufs.create().writeString(World.OVERWORLD.getValue().toString()));
        }));
        this.addDrawableChild(new TexturedButtonWidget(leftPos + 118, topPos + 19, 64, 64, 0, 0, 64, new Identifier(RainimatorMod.MOD_ID, "textures/screens/atlas/nether.png"), 64, 128, e -> {
            ClientPlayNetworking.send(ModConstants.ENDER_BOOK_SKILL_PACKET_ID, PacketByteBufs.create().writeString(World.NETHER.getValue().toString()));
        }));
        this.addDrawableChild(new TexturedButtonWidget(leftPos + 203, topPos + 19, 64, 64, 0, 0, 64, new Identifier(RainimatorMod.MOD_ID, "textures/screens/atlas/end.png"), 64, 128, e -> {
            ClientPlayNetworking.send(ModConstants.ENDER_BOOK_SKILL_PACKET_ID, PacketByteBufs.create().writeString(World.END.getValue().toString()));
        }));
    }
}