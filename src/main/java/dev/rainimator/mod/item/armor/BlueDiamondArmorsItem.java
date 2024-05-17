package dev.rainimator.mod.item.armor;

import com.iafenvoy.mcrconvertlib.item.ArmorMaterialUtil;
import com.iafenvoy.mcrconvertlib.item.ArmorWithTickItem;
import dev.rainimator.mod.registry.ModGameRules;
import dev.rainimator.mod.registry.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class BlueDiamondArmorsItem extends ArmorWithTickItem {
    public BlueDiamondArmorsItem(Type slot) {
        super(ArmorMaterialUtil.of("blue_diamond_armors", new int[]{13, 15, 16, 11}, 70, new int[]{9, 13, 18, 10}, 40, Registries.SOUND_EVENT.get(new Identifier("item.armor.equip_diamond")), 5.0F, 0.3F, ModItems.BLUE_DIAMOND), slot, new Settings().fireproof());
    }

    @Override
    public void onArmorTick(World world, PlayerEntity entity) {
        if (entity == null)
            return;
        if (!entity.getWorld().isClient() &&
                world.getGameRules().getBoolean(ModGameRules.enableArmorEffect) &&
                entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.BLUE_DIAMOND_HELMET &&
                entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == ModItems.BLUE_DIAMOND_CHESTPLATE &&
                entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == ModItems.BLUE_DIAMOND_LEGGINGS &&
                entity.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.BLUE_DIAMOND_BOOTS) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 80, 1));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 80, 2));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 80, 0));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 80, 0));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 80, 4));
        }
    }
}

