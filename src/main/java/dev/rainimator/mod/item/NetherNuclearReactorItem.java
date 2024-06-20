package dev.rainimator.mod.item;

import dev.rainimator.mod.data.component.ManaComponent;
import dev.rainimator.mod.item.util.ItemBase;
import dev.rainimator.mod.registry.RainimatorGameRules;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class NetherNuclearReactorItem extends ItemBase {
    public NetherNuclearReactorItem() {
        super(p -> p.maxDamage(16).fireproof());
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        TypedActionResult<ItemStack> ar = super.use(world, entity, hand);
        if (!ManaComponent.tryUse(entity, world.getGameRules().get(RainimatorGameRules.nether_nuclear_reactor).get()))
            return ar;
        ItemStack itemtack = ar.getValue();
        if (!entity.getWorld().isClient())
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0));
        entity.getItemCooldownManager().set(itemtack.getItem(), 800);
        return ar;
    }
}
