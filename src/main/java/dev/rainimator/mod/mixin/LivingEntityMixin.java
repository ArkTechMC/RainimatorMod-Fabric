package dev.rainimator.mod.mixin;

import com.iafenvoy.mcrconvertlib.world.EntityUtil;
import dev.rainimator.mod.registry.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "onDeath", at = @At("TAIL"))
    private void dropBox(DamageSource damageSource, CallbackInfo ci) {
        if (Math.random() < 0.05 && this.getWorld() instanceof ServerWorld serverWorld)
            EntityUtil.item(serverWorld, this.getX(), this.getY(), this.getZ(), ModItems.MYSTERIOUS_GIFT_BOX, 10);
    }
}
