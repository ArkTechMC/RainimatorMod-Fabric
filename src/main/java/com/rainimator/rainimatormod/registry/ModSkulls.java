package com.rainimator.rainimatormod.registry;

import com.rainimator.rainimatormod.entity.HerobrineEntity;
import net.minecraft.block.SkullBlock;
import net.minecraft.client.render.block.entity.SkullBlockEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.SkullEntityModel;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ModSkulls {
    public static void createSkullRenderers(Map<SkullBlock.SkullType, Identifier> textures, EntityModelLoader modelLoader, Map<SkullBlock.SkullType, SkullBlockEntityModel> models) {
        textures.put(SkullType.HEROBRINE, HerobrineEntity.texture.getTexture());
        models.put(SkullType.HEROBRINE, new SkullEntityModel(modelLoader.getModelPart(EntityModelLayers.PLAYER_HEAD)));
    }

    public enum SkullType implements SkullBlock.SkullType {
        HEROBRINE
    }
}
