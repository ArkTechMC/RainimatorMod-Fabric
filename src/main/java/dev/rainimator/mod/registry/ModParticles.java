package dev.rainimator.mod.registry;

import com.iafenvoy.annotationlib.annotation.ModId;
import com.iafenvoy.annotationlib.annotation.registration.ParticleReg;
import com.iafenvoy.annotationlib.api.IAnnotatedRegistryEntry;
import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.particle.*;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;

@ModId(RainimatorMod.MOD_ID)
public class ModParticles implements IAnnotatedRegistryEntry {
    @ParticleReg(PurpleLightParticle.class)
    public static final DefaultParticleType PURPLE_LIGHT = FabricParticleTypes.simple();
    @ParticleReg(RedFlowerParticle.class)
    public static final DefaultParticleType RED_FLOWER = FabricParticleTypes.simple();
    @ParticleReg(SnowParticle.class)
    public static final DefaultParticleType SNOW = FabricParticleTypes.simple();
    @ParticleReg(Lighting1Particle.class)
    public static final DefaultParticleType LIGHTING_1 = FabricParticleTypes.simple();
    @ParticleReg(Lighting2Particle.class)
    public static final DefaultParticleType LIGHTING_2 = FabricParticleTypes.simple();
    @ParticleReg(YellowLightingParticle.class)
    public static final DefaultParticleType YELLOW_LIGHTENING = FabricParticleTypes.simple();
    @ParticleReg(LightingArcParticle.class)
    public static final DefaultParticleType LIGHTENING_ARC = FabricParticleTypes.simple();
    @ParticleReg(EnderDaggerParticle.class)
    public static final DefaultParticleType ENDER_DAGGER = FabricParticleTypes.simple();
    @ParticleReg(WhiteCircleParticle.class)
    public static final DefaultParticleType WHITE_CIRCLE = FabricParticleTypes.simple();
    @ParticleReg(DarkCircleParticle.class)
    public static final DefaultParticleType DARK_CIRCLE = FabricParticleTypes.simple();
    @ParticleReg(FlowerWriteParticle.class)
    public static final DefaultParticleType FLOWER_WHITE = FabricParticleTypes.simple();
    @ParticleReg(SweaterSnowParticle.class)
    public static final DefaultParticleType SWEATER_SNOW = FabricParticleTypes.simple();
    @ParticleReg(YellowStarsParticle.class)
    public static final DefaultParticleType YELLOW_STARS = FabricParticleTypes.simple();
}
