package dev.rainimator.mod.item.armor;

import dev.rainimator.mod.item.util.ArmorMaterialUtil;
import dev.rainimator.mod.item.util.ArmorWithTickItem;
import dev.rainimator.mod.registry.RainimatorGameRules;
import dev.rainimator.mod.registry.RainimatorItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class SapphireArmorItem extends ArmorWithTickItem {
    public SapphireArmorItem(Type slot) {
        super(ArmorMaterialUtil.of("sapphire_armors", new int[]{13, 15, 16, 11}, 40, new int[]{5, 10, 12, 6}, 25, Registries.SOUND_EVENT.get(new Identifier("item.armor.equip_diamond")), 2.5F, 0.0F), slot, new Settings());
    }

    @Override
    public void onArmorTick(World world, PlayerEntity entity) {
        if (entity == null)
            return;
        if (!entity.getWorld().isClient() &&
                world.getGameRules().getBoolean(RainimatorGameRules.enableArmorEffect) &&
                entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == RainimatorItems.SAPPHIRE_HELMET &&
                entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == RainimatorItems.SAPPHIRE_CHESTPLATE &&
                entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == RainimatorItems.SAPPHIRE_LEGGINGS &&
                entity.getEquippedStack(EquipmentSlot.FEET).getItem() == RainimatorItems.SAPPHIRE_BOOTS) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300, 0));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 80, 0));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 80, 1));
        }
    }
}