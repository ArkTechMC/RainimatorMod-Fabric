package com.rainimator.rainimatormod.item;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.registry.ModItems;
import com.rainimator.rainimatormod.registry.util.ItemBase;
import com.rainimator.rainimatormod.registry.util.ModCreativeTab;
import com.rainimator.rainimatormod.util.SoundUtil;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.List;

public class MysteriousGiftBoxItem extends ItemBase {
    private static final List<Triple<ItemConvertible, Integer, String>> lootTable = new ArrayList<>();

    public MysteriousGiftBoxItem() {
        super(p -> p.group(ModCreativeTab.items).maxCount(16).rarity(Rarity.EPIC).food((new FoodComponent.Builder()).hunger(0).saturationModifier(0.0F).alwaysEdible().build()));
    }

    private static synchronized void initLootTable() {
        lootTable.add(Triple.of(Items.ROTTEN_FLESH, 5, ""));
        lootTable.add(Triple.of(Items.SPIDER_EYE, 3, ""));
        lootTable.add(Triple.of(Items.BONE, 3, ""));
        lootTable.add(Triple.of(Blocks.SWEET_BERRY_BUSH, 3, ""));
        lootTable.add(Triple.of(Items.GOLD_NUGGET, 5, ""));
        lootTable.add(Triple.of(Items.IRON_NUGGET, 5, ""));
        lootTable.add(Triple.of(ModItems.COTTON_CANDY, 3, ""));
        lootTable.add(Triple.of(Items.GLOW_BERRIES, 3, ""));
        lootTable.add(Triple.of(Items.STICK, 6, ""));
        lootTable.add(Triple.of(Items.FEATHER, 3, ""));
        lootTable.add(Triple.of(Items.PHANTOM_MEMBRANE, 2, ""));
        lootTable.add(Triple.of(Items.APPLE, 3, ""));
        lootTable.add(Triple.of(Items.SUGAR_CANE, 3, ""));
        lootTable.add(Triple.of(Items.GLOWSTONE_DUST, 3, ""));
        lootTable.add(Triple.of(Items.GUNPOWDER, 3, ""));
        lootTable.add(Triple.of(Items.PAPER, 5, ""));
        lootTable.add(Triple.of(Items.CLAY_BALL, 5, ""));
        lootTable.add(Triple.of(Blocks.MAGMA_BLOCK, 5, ""));
        lootTable.add(Triple.of(Items.COAL, 5, ""));
        lootTable.add(Triple.of(Items.CHARCOAL, 5, "item.rainimator.mysterious_gift_box.goodluck1"));
        lootTable.add(Triple.of(Items.BAMBOO, 5, ""));
        lootTable.add(Triple.of(Items.LEATHER, 5, ""));
        lootTable.add(Triple.of(Items.STRING, 5, ""));
        lootTable.add(Triple.of(Items.WHEAT_SEEDS, 5, ""));
        lootTable.add(Triple.of(Items.WHEAT, 4, "item.rainimator.mysterious_gift_box.goodluck1"));
        lootTable.add(Triple.of(Items.ARROW, 5, ""));
        lootTable.add(Triple.of(Items.NETHER_WART, 5, ""));
        lootTable.add(Triple.of(Items.COPPER_INGOT, 5, ""));
        lootTable.add(Triple.of(Blocks.AMETHYST_BLOCK, 3, ""));
        lootTable.add(Triple.of(Items.ENDER_PEARL, 5, ""));
        lootTable.add(Triple.of(Items.ENDER_EYE, 3, ""));
        lootTable.add(Triple.of(Items.AMETHYST_SHARD, 3, ""));
        lootTable.add(Triple.of(Items.QUARTZ, 5, ""));
        lootTable.add(Triple.of(ModItems.ZOMBIE_HEART, 3, ""));
        lootTable.add(Triple.of(ModItems.WITHER_BONE, 3, ""));
        lootTable.add(Triple.of(ModItems.NETHERITE_WITHER_BONE, 1, "item.rainimator.mysterious_gift_box.goodluck1"));
        lootTable.add(Triple.of(Items.IRON_INGOT, 3, ""));
        lootTable.add(Triple.of(Blocks.IRON_BLOCK, 1, "item.rainimator.mysterious_gift_box.goodluck1"));
        lootTable.add(Triple.of(ModItems.HOT_IRON, 3, "item.rainimator.mysterious_gift_box.goodluck2"));
        lootTable.add(Triple.of(Items.EXPERIENCE_BOTTLE, 3, ""));
        lootTable.add(Triple.of(Items.BLAZE_ROD, 3, ""));
        lootTable.add(Triple.of(Items.BLAZE_POWDER, 5, "item.rainimator.mysterious_gift_box.goodluck1"));
        lootTable.add(Triple.of(Items.SLIME_BALL, 5, ""));
        lootTable.add(Triple.of(Blocks.SLIME_BLOCK, 1, "item.rainimator.mysterious_gift_box.goodluck1"));
        lootTable.add(Triple.of(Items.ENCHANTED_GOLDEN_APPLE, 3, ""));
        lootTable.add(Triple.of(Items.GOLDEN_APPLE, 5, ""));
        lootTable.add(Triple.of(Items.BREAD, 5, ""));
        lootTable.add(Triple.of(Items.GOLDEN_CARROT, 5, "item.rainimator.mysterious_gift_box.goodluck1"));
        lootTable.add(Triple.of(Items.DIAMOND, 5, ""));
        lootTable.add(Triple.of(Blocks.DIAMOND_BLOCK, 1, ""));
        lootTable.add(Triple.of(ModItems.BLUE_DIAMOND, 5, "item.rainimator.mysterious_gift_box.goodluck2"));
        lootTable.add(Triple.of(Items.GOLD_INGOT, 5, ""));
        lootTable.add(Triple.of(Blocks.GOLD_BLOCK, 1, "item.rainimator.mysterious_gift_box.goodluck1"));
        lootTable.add(Triple.of(Items.NETHERITE_INGOT, 5, ""));
        lootTable.add(Triple.of(Blocks.NETHERITE_BLOCK, 1, "item.rainimator.mysterious_gift_box.goodluck1"));
        lootTable.add(Triple.of(ModItems.SAPPHIRE, 3, ""));
        lootTable.add(Triple.of(ModItems.SAPPHIRE_BLOCK, 1, "item.rainimator.mysterious_gift_box.goodluck1"));
        lootTable.add(Triple.of(ModItems.RUBY, 3, ""));
        lootTable.add(Triple.of(ModItems.RUBY_BLOCK, 1, "item.rainimator.mysterious_gift_box.goodluck1"));
        lootTable.add(Triple.of(Items.EMERALD, 5, ""));
        lootTable.add(Triple.of(Blocks.EMERALD_BLOCK, 1, "item.rainimator.mysterious_gift_box.goodluck1"));
        lootTable.add(Triple.of(ModItems.SOUL_PEOPLE, 3, ""));
        lootTable.add(Triple.of(ModItems.SUPER_DIAMOND_APPLE, 1, "item.rainimator.mysterious_gift_box.goodluck1"));
        lootTable.add(Triple.of(Blocks.LAPIS_BLOCK, 1, ""));
        lootTable.add(Triple.of(Blocks.REDSTONE_BLOCK, 1, ""));
        lootTable.add(Triple.of(ModItems.MYSTERIOUS_GIFT_BOX, 1, "item.rainimator.mysterious_gift_box.goodluck3"));
    }

    @Override
    public UseAction getUseAction(ItemStack itemstack) {
        return UseAction.BLOCK;
    }

    @Override
    public int getMaxUseTime(ItemStack itemstack) {
        return 1;
    }

    @Override
    public void appendTooltip(ItemStack itemstack, World world, List<Text> list, TooltipContext flag) {
        super.appendTooltip(itemstack, world, list, flag);
        list.add(new TranslatableText("item.rainimator.mysterious_gift_box.tooltip"));
    }

    @Override
    public ItemStack finishUsing(ItemStack itemstack, World world, LivingEntity entity) {
        ItemStack retval = super.finishUsing(itemstack, world, entity);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();

        if (entity instanceof PlayerEntity _player) {
            SoundUtil.playSound(world, x, y, z, new Identifier(RainimatorMod.MOD_ID, "gift_box"), 15.0F, 1.0F);
            ItemStack _stktoremove = new ItemStack(ModItems.MYSTERIOUS_GIFT_BOX);
            _player.getInventory().remove(p -> (_stktoremove.getItem() == p.getItem()), 0, _player.playerScreenHandler.getCraftingInput());
            ItemStack stack = new ItemStack(Items.AIR);
            if (lootTable.size() == 0) initLootTable();
            for (Triple<ItemConvertible, Integer, String> triple : lootTable) {
                if (Math.random() < 0.1D) {
                    stack = new ItemStack(triple.getLeft(), triple.getMiddle());
                    if (!triple.getRight().isBlank() && !_player.world.isClient())
                        _player.sendMessage(new TranslatableText(triple.getRight()), true);
                    break;
                }
            }
            if (stack.getItem() == Items.AIR)
                if (!_player.world.isClient())
                    _player.sendMessage(new TranslatableText("item.rainimator.mysterious_gift_box.goodluck4"), true);
            _player.getInventory().insertStack(stack);
        }
        return retval;
    }
}
