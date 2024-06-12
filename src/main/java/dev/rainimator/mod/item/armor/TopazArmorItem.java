package dev.rainimator.mod.item.armor;

import com.iafenvoy.mcrconvertlib.item.ArmorMaterialUtil;
import com.iafenvoy.mcrconvertlib.item.ArmorWithTickItem;
import dev.rainimator.mod.registry.RainimatorGameRules;
import dev.rainimator.mod.registry.RainimatorItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class TopazArmorItem extends ArmorWithTickItem {
    public TopazArmorItem(Type slot) {
        super(ArmorMaterialUtil.of("topaz_armor", new int[]{13, 15, 16, 11}, 40, new int[]{5, 10, 12, 6}, 25, Registries.SOUND_EVENT.get(new Identifier("item.armor.equip_diamond")), 2.5F, 0.0F), slot, new Settings());
    }

    @Override
    public void onArmorTick(World world, PlayerEntity entity) {
        if (entity == null)
            return;
        if (!entity.getWorld().isClient() &&
                world.getGameRules().getBoolean(RainimatorGameRules.enableArmorEffect) &&
                entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == RainimatorItems.RUBY_HELMET &&
                entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == RainimatorItems.RUBY_CHESTPLATE &&
                entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == RainimatorItems.RUBY_LEGGINGS &&
                entity.getEquippedStack(EquipmentSlot.FEET).getItem() == RainimatorItems.RUBY_BOOTS) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 80, 0));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 80, 1));
        }
    }
}
