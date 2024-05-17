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

public class SapphireArmorItem extends ArmorWithTickItem {
    public SapphireArmorItem(Type slot) {
        super(ArmorMaterialUtil.of("sapphire_armors", new int[]{13, 15, 16, 11}, 40, new int[]{5, 10, 12, 6}, 25, Registries.SOUND_EVENT.get(new Identifier("item.armor.equip_diamond")), 2.5F, 0.0F), slot, new Settings());
    }

    @Override
    public void onArmorTick(World world, PlayerEntity entity) {
        if (entity == null)
            return;
        if (!entity.getWorld().isClient() &&
                world.getGameRules().getBoolean(ModGameRules.enableArmorEffect) &&
                entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.SAPPHIRE_HELMET &&
                entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == ModItems.SAPPHIRE_CHESTPLATE &&
                entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == ModItems.SAPPHIRE_LEGGINGS &&
                entity.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.SAPPHIRE_BOOTS) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300, 0));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 80, 0));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 80, 1));
        }
    }
}