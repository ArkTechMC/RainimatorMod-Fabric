package com.rainimator.rainimatormod.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.rainimator.rainimatormod.entity.EndStaffEntity;
import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.registry.util.ItemBase;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.Random;

public class EndStaffItem extends ItemBase {
    public EndStaffItem() {
        super(p -> p.maxDamage(10000));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        entity.setCurrentHand(hand);
        return new TypedActionResult<>(ActionResult.SUCCESS, entity.getStackInHand(hand));
    }

    @Override
    public UseAction getUseAction(ItemStack itemstack) {
        return UseAction.BOW;
    }

    @Override
    public int getMaxUseTime(ItemStack itemstack) {
        return 72000;
    }

    @Deprecated
    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
            builder.putAll(super.getAttributeModifiers(slot));
            builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Ranged item modifier", 8.0D, EntityAttributeModifier.Operation.ADDITION));
            builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Ranged item modifier", -2.4D, EntityAttributeModifier.Operation.ADDITION));
            return builder.build();
        }
        return super.getAttributeModifiers(slot);
    }

    @Override
    public void onStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
        if (!world.isClient() && entityLiving instanceof ServerPlayerEntity entity) {
            ItemStack stack = RangedWeaponItem.getHeldProjectile(entity, e -> (e.getItem() == ModItems.MAGIC_STARD));
            if (stack == ItemStack.EMPTY)
                for (int i = 0; i < (entity.getInventory()).main.size(); i++) {
                    ItemStack teststack = (entity.getInventory()).main.get(i);
                    if (teststack.getItem() == ModItems.MAGIC_STARD) {
                        stack = teststack;
                        break;
                    }
                }
            if ((entity.getAbilities()).creativeMode || stack != ItemStack.EMPTY) {
                EndStaffEntity entityarrow = EndStaffEntity.shoot(world, entity, new Random(), 1.2F, 7.0D, 0);
                itemstack.damage(1, (LivingEntity) entity, e -> e.sendToolBreakStatus(entity.getActiveHand()));
                if ((entity.getAbilities()).creativeMode) {
                    entityarrow.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                } else if ((new ItemStack(ModItems.MAGIC_STARD)).isDamageable()) {
                    if (stack.damage(1, world.getRandom(), entity)) {
                        stack.decrement(1);
                        stack.setDamage(0);
                        if (stack.isEmpty())
                            entity.getInventory().removeOne(stack);
                    }
                } else {
                    stack.decrement(1);
                    if (stack.isEmpty())
                        entity.getInventory().removeOne(stack);
                }
                entity.getItemCooldownManager().set(itemstack.getItem(), 100);
            }
        }
    }
}