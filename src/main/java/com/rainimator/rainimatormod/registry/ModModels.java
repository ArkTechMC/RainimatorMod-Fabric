package com.rainimator.rainimatormod.registry;

import com.rainimator.rainimatormod.renderer.model.*;
import com.rainimator.rainimatormod.renderer.model.wing.WingsOfSalvationModel;
import net.fabricmc.fabric.impl.client.rendering.EntityModelLayerImpl;

public class ModModels {
    public static void registerLayerDefinitions() {
        EntityModelLayerImpl.PROVIDERS.put(ModelPorkshireKingCrown.LAYER_LOCATION, ModelPorkshireKingCrown::createBodyLayer);
        EntityModelLayerImpl.PROVIDERS.put(ModelMagic.LAYER_LOCATION, ModelMagic::createBodyLayer);
        EntityModelLayerImpl.PROVIDERS.put(ModelCustomModel.LAYER_LOCATION, ModelCustomModel::createBodyLayer);
        EntityModelLayerImpl.PROVIDERS.put(ModelKingNormalCrown.LAYER_LOCATION, ModelKingNormalCrown::createBodyLayer);
        EntityModelLayerImpl.PROVIDERS.put(ModelNetherCrown.LAYER_LOCATION, ModelNetherCrown::createBodyLayer);
        EntityModelLayerImpl.PROVIDERS.put(ModelEnderman.LAYER_LOCATION, ModelEnderman::createBodyLayer);
        EntityModelLayerImpl.PROVIDERS.put(ModelNetherKing2.LAYER_LOCATION, ModelNetherKing2::createBodyLayer);
        EntityModelLayerImpl.PROVIDERS.put(WingsOfSalvationModel.LAYER_LOCATION, WingsOfSalvationModel::createLayer);
    }
}
