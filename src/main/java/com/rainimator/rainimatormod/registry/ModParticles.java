package com.rainimator.rainimatormod.registry;

import com.iafenvoy.annotationlib.api.IAnnotatedRegistryEntry;
import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.particle.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles implements IAnnotatedRegistryEntry {
    public static final DefaultParticleType PURPLE_LIGHT = register("purple_light", FabricParticleTypes.simple());
    public static final DefaultParticleType RED_FLOWER = register("red_flower", FabricParticleTypes.simple());
    public static final DefaultParticleType SNOW = register("snow", FabricParticleTypes.simple());
    public static final DefaultParticleType LIGHTING_1 = register("lightening_1", FabricParticleTypes.simple());
    public static final DefaultParticleType LIGHTING_2 = register("lightening_2", FabricParticleTypes.simple());
    public static final DefaultParticleType YELLOW_LIGHTENING = register("yellow_lightening", FabricParticleTypes.simple());
    public static final DefaultParticleType LIGHTENING_ARC = register("lightening_arc", FabricParticleTypes.simple());
    public static final DefaultParticleType ENDER_DAGGER = register("ender_dagger", FabricParticleTypes.simple());
    public static final DefaultParticleType WHITE_CIRCLE = register("white_circle", FabricParticleTypes.simple());
    public static final DefaultParticleType DARK_CIRCLE = register("dark_circle", FabricParticleTypes.simple());
    public static final DefaultParticleType FLOWER_WHITE = register("flower_white", FabricParticleTypes.simple());
    public static final DefaultParticleType SWEATER_SNOW = register("sweater_snow", FabricParticleTypes.simple());
    public static final DefaultParticleType YELLOW_STARS = register("yellow_stars", FabricParticleTypes.simple());

    private static DefaultParticleType register(String name, DefaultParticleType obj) {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(RainimatorMod.MOD_ID, name), obj);
        return obj;
    }

    public static void init() {
    }

    @Environment(EnvType.CLIENT)
    public static void registerParticles() {
        ParticleFactoryRegistry.getInstance().register(ModParticles.PURPLE_LIGHT, PurpleLightParticle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.RED_FLOWER, RedFlowerParticle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.SNOW, SnowParticle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.LIGHTING_1, Lighting1Particle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.LIGHTING_2, Lighting2Particle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.YELLOW_LIGHTENING, YellowLightingParticle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.LIGHTENING_ARC, LightingArcParticle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.ENDER_DAGGER, EnderDaggerParticle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.WHITE_CIRCLE, WhiteCircleParticle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.DARK_CIRCLE, DarkCircleParticle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.FLOWER_WHITE, FlowerWriteParticle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.SWEATER_SNOW, SweaterSnowParticle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.YELLOW_STARS, YellowStearParticle::provider);
    }
}
