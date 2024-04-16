package com.rainimator.rainimatormod.registry;

import com.rainimator.rainimatormod.renderer.model.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;

@Environment(EnvType.CLIENT)
public class ModModels {
    public static void registerLayerDefinitions() {
        EntityModelLayerRegistry.registerModelLayer(ModelPorkshireKingCrown.LAYER_LOCATION, ModelPorkshireKingCrown::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(ModelMagic.LAYER_LOCATION, ModelMagic::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(ModelCustomModel.LAYER_LOCATION, ModelCustomModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(ModelKingNormalCrown.LAYER_LOCATION, ModelKingNormalCrown::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(ModelNetherCrown.LAYER_LOCATION, ModelNetherCrown::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(ModelEnderman.LAYER_LOCATION, ModelEnderman::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(ModelNetherKing2.LAYER_LOCATION, ModelNetherKing2::createBodyLayer);
    }
}
