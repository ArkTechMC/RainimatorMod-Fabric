package com.rainimator.rainimatormod.util;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.renderer.EntityRendererBase;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public enum Stage {
    First, Second;

    public static StagedEntityTextureProvider ofProvider(String... textures) {
        return new StagedEntityTextureProvider(textures);
    }

    public interface StagedEntity {
        Stage getStage();
    }

    public static class StagedEntityTextureProvider {
        private final HashMap<Stage, String> textureIds = new HashMap<>();
        private String eyeTextureId = null;

        public StagedEntityTextureProvider(String... textures) {
            Stage[] stages = Stage.values();
            for (int i = 0; i < stages.length && i < textures.length; i++)
                this.textureIds.put(stages[i], textures[i]);
        }

        public StagedEntityTextureProvider setEyeTextureId(String eyeTextureId) {
            this.eyeTextureId = eyeTextureId;
            return this;
        }

        public Identifier getTexture() {
            return this.getTexture(Stage.First);
        }

        public Identifier getTexture(Stage stage) {
            return new Identifier(RainimatorMod.MOD_ID, "textures/entities/" + this.getTextureId(stage) + ".png");
        }

        private String getTextureId(Stage stage) {
            if (this.textureIds.containsKey(stage))
                return this.textureIds.get(stage);
            if (this.textureIds.size() == 0)
                return "";
            return this.textureIds.get(Stage.First);
        }

        public <T extends MobEntity> EntityRendererBase<T> createRenderer(EntityRendererFactory.Context context) {
            return new EntityRendererBase<>(context, this, this.eyeTextureId);
        }
    }
}
