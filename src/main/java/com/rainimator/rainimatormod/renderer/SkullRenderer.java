package com.rainimator.rainimatormod.renderer;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SkullBlock;
import net.minecraft.block.WallSkullBlock;
import net.minecraft.block.entity.SkullBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.SkullBlockEntityModel;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.Uuids;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationPropertyHelper;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

@Environment(EnvType.CLIENT)
public class SkullRenderer {
    private final Map<SkullBlock.SkullType, SkullBlockEntityModel> MODELS;
    private static final Map<SkullBlock.SkullType, Identifier> TEXTURES = Util.make(Maps.newHashMap(), (map) -> {
        map.put(SkullBlock.Type.SKELETON, new Identifier("textures/entity/skeleton/skeleton.png"));
        map.put(SkullBlock.Type.WITHER_SKELETON, new Identifier("textures/entity/skeleton/wither_skeleton.png"));
        map.put(SkullBlock.Type.ZOMBIE, new Identifier("textures/entity/zombie/zombie.png"));
        map.put(SkullBlock.Type.CREEPER, new Identifier("textures/entity/creeper/creeper.png"));
        map.put(SkullBlock.Type.DRAGON, new Identifier("textures/entity/enderdragon/dragon.png"));
        map.put(SkullBlock.Type.PIGLIN, new Identifier("textures/entity/piglin/piglin.png"));
        map.put(SkullBlock.Type.PLAYER, DefaultSkinHelper.getTexture());
    });

    public static Map<SkullBlock.SkullType, SkullBlockEntityModel> getModels(EntityModelLoader modelLoader) {
        ImmutableMap.Builder<SkullBlock.SkullType, SkullBlockEntityModel> builder = ImmutableMap.builder();
        builder.put(SkullBlock.Type.SKELETON, new SkullEntityModel(modelLoader.getModelPart(EntityModelLayers.SKELETON_SKULL)));
        builder.put(SkullBlock.Type.WITHER_SKELETON, new SkullEntityModel(modelLoader.getModelPart(EntityModelLayers.WITHER_SKELETON_SKULL)));
        builder.put(SkullBlock.Type.PLAYER, new SkullEntityModel(modelLoader.getModelPart(EntityModelLayers.PLAYER_HEAD)));
        builder.put(SkullBlock.Type.ZOMBIE, new SkullEntityModel(modelLoader.getModelPart(EntityModelLayers.ZOMBIE_HEAD)));
        builder.put(SkullBlock.Type.CREEPER, new SkullEntityModel(modelLoader.getModelPart(EntityModelLayers.CREEPER_HEAD)));
        builder.put(SkullBlock.Type.DRAGON, new DragonHeadEntityModel(modelLoader.getModelPart(EntityModelLayers.DRAGON_SKULL)));
        builder.put(SkullBlock.Type.PIGLIN, new PiglinHeadEntityModel(modelLoader.getModelPart(EntityModelLayers.PIGLIN_HEAD)));
        return builder.build();
    }

    public SkullRenderer(BlockEntityRendererFactory.Context ctx) {
        this.MODELS = getModels(ctx.getLayerRenderDispatcher());
    }

    public void render(SkullBlockEntity skullBlockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
        float g = skullBlockEntity.getPoweredTicks(f);
        BlockState blockState = skullBlockEntity.getCachedState();
        boolean bl = blockState.getBlock() instanceof WallSkullBlock;
        Direction direction = bl ? blockState.get(WallSkullBlock.FACING) : null;
        int k = bl ? RotationPropertyHelper.fromDirection(direction.getOpposite()) : blockState.get(SkullBlock.ROTATION);
        float h = RotationPropertyHelper.toDegrees(k);
        SkullBlock.SkullType skullType = ((AbstractSkullBlock)blockState.getBlock()).getSkullType();
        SkullBlockEntityModel skullBlockEntityModel = this.MODELS.get(skullType);
        RenderLayer renderLayer = getRenderLayer(skullType, skullBlockEntity.getOwner());
        renderSkull(direction, h, g, matrixStack, vertexConsumerProvider, i, skullBlockEntityModel, renderLayer);
    }

    public static void renderSkull(@Nullable Direction direction, float yaw, float animationProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, SkullBlockEntityModel model, RenderLayer renderLayer) {
        matrices.push();
        if (direction == null) {
            matrices.translate(0.5F, 0.0F, 0.5F);
        } else {
            float f = 0.25F;
            matrices.translate(0.5F - (float)direction.getOffsetX() * 0.25F, 0.25F, 0.5F - (float)direction.getOffsetZ() * 0.25F);
        }

        matrices.scale(-1.0F, -1.0F, 1.0F);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(renderLayer);
        model.setHeadRotation(animationProgress, yaw, 0.0F);
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }

    public static RenderLayer getRenderLayer(SkullBlock.SkullType type, @Nullable GameProfile profile) {
        Identifier identifier = TEXTURES.get(type);
        if (type == SkullBlock.Type.PLAYER && profile != null) {
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> map = minecraftClient.getSkinProvider().getTextures(profile);
            return map.containsKey(com.mojang.authlib.minecraft.MinecraftProfileTexture.Type.SKIN) ? RenderLayer.getEntityTranslucent(minecraftClient.getSkinProvider().loadSkin(map.get(MinecraftProfileTexture.Type.SKIN), com.mojang.authlib.minecraft.MinecraftProfileTexture.Type.SKIN)) : RenderLayer.getEntityCutoutNoCull(DefaultSkinHelper.getTexture(Uuids.getUuidFromProfile(profile)));
        } else {
            return RenderLayer.getEntityCutoutNoCullZOffset(identifier);
        }
    }
}
