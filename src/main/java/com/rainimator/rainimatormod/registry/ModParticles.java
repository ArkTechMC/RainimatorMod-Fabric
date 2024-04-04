package com.rainimator.rainimatormod.registry;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.particle.*;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class ModParticles {
    public static final ParticleType<DefaultParticleType> PURPLE_LIGHT = register("purple_light", () -> new DefaultParticleType(false));
    public static final ParticleType<DefaultParticleType> RED_FLOWER = register("red_flower", () -> new DefaultParticleType(false));
    public static final ParticleType<DefaultParticleType> SNOW = register("snow", () -> new DefaultParticleType(false));
    public static final ParticleType<DefaultParticleType> LIGHTING_1 = register("lightening_1", () -> new DefaultParticleType(false));
    public static final ParticleType<DefaultParticleType> LIGHTING_2 = register("lightening_2", () -> new DefaultParticleType(false));
    public static final ParticleType<DefaultParticleType> YELLOW_LIGHTENING = register("yellow_lightening", () -> new DefaultParticleType(false));
    public static final ParticleType<DefaultParticleType> LIGHTENING_ARC = register("lightening_arc", () -> new DefaultParticleType(false));
    public static final ParticleType<DefaultParticleType> ENDER_DAGGER = register("ender_dagger", () -> new DefaultParticleType(false));
    public static final ParticleType<DefaultParticleType> WHITE_CIRCLE = register("white_circle", () -> new DefaultParticleType(false));
    public static final ParticleType<DefaultParticleType> DARK_CIRCLE = register("dark_circle", () -> new DefaultParticleType(false));
    public static final ParticleType<DefaultParticleType> FLOWER_WHITE = register("flower_white", () -> new DefaultParticleType(false));
    public static final ParticleType<DefaultParticleType> SWEATER_SNOW = register("sweater_snow", () -> new DefaultParticleType(false));
    public static final ParticleType<DefaultParticleType> YELLOW_STARS = register("yellow_stars", () -> new DefaultParticleType(false));

    private static ParticleType<DefaultParticleType> register(String name, Supplier<ParticleType<DefaultParticleType>> provider) {
        return register(name, provider.get());
    }

    private static ParticleType<DefaultParticleType> register(String name, ParticleType<DefaultParticleType> obj) {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(RainimatorMod.MOD_ID, name), obj);
        return obj;
    }

    public static void registerParticles() {
        ParticleFactoryRegistry.getInstance().register(ModParticles.PURPLE_LIGHT, PurpleLightParticle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.RED_FLOWER, RedFlowerParticle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.SNOW, SnowParticle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.LIGHTING_1, Lighting1Particle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.LIGHTING_2, Lighting2Particle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.YELLOW_LIGHTENING, YellowLightingParticle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.LIGHTENING_ARC, LightingArcParticle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.ENDER_DAGGER, EnderDaggerParticle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.WHITE_CIRCLE, WriteCricleParticle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.DARK_CIRCLE, DarkCircleParticle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.FLOWER_WHITE, FlowerWriteParticle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.SWEATER_SNOW, SweaterSnowParticle::provider);
        ParticleFactoryRegistry.getInstance().register(ModParticles.YELLOW_STARS, YellowStearsParticle::provider);
    }
}
