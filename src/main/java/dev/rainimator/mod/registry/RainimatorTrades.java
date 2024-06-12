package dev.rainimator.mod.registry;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RainimatorTrades {
    public static void registerTrades() {
        //TOOL SMITH
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 1, factories -> factories.addAll(List.of(
                new BuyWithPrice(new ItemStack(RainimatorItems.DIAMOND_HATCHET), new ItemStack(RainimatorItems.UNDER_FLOWER), new ItemStack(RainimatorItems.INTELLIGENCE_TOMAHAWK), 1, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.SOUL_PEOPLE), new ItemStack(RainimatorItems.RUBY, 2), 5, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.SOUL_PEOPLE), new ItemStack(RainimatorItems.SAPPHIRE, 2), 5, 5, 0.05F),
                new BuyWithPrice(new ItemStack(Items.IRON_INGOT, 2), new ItemStack(Items.COPPER_INGOT, 3), new ItemStack(Items.DIAMOND), 10, 5, 0.05F),
                new BuyWithPrice(new ItemStack(Blocks.AMETHYST_BLOCK, 2), new ItemStack(Items.COPPER_INGOT, 3), new ItemStack(Items.DIAMOND), 10, 5, 0.05F)
        )));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 2, factories -> factories.addAll(List.of(
                new BuyWithPrice(new ItemStack(RainimatorItems.RAW_RUBY), new ItemStack(RainimatorItems.SAPPHIRE), 25, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.RAW_SAPPHIRE), new ItemStack(RainimatorItems.RUBY), 25, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.RUBY, 2), new ItemStack(RainimatorItems.RUBY_PICKAXE), 1, 25, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.RUBY, 2), new ItemStack(RainimatorItems.RUBY_AXE), 1, 25, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.SAPPHIRE, 2), new ItemStack(RainimatorItems.SAPPHIRE_PICKAXE), 1, 25, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.SAPPHIRE, 2), new ItemStack(RainimatorItems.SAPPHIRE_AXE), 1, 25, 0.05F)
        )));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 4, factories -> factories.addAll(List.of(
                new BuyWithPrice(new ItemStack(RainimatorItems.SUPER_RUBY), new ItemStack(RainimatorItems.DIAMOND_APPLE_SUPPER, 3), 5, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.SUPER_SAPPHIRE), new ItemStack(RainimatorItems.DIAMOND_APPLE_SUPPER, 3), 5, 5, 0.05F)
        )));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 4, factories -> factories.addAll(List.of(
                new BuyWithPrice(new ItemStack(RainimatorItems.BLUE_DIAMOND), new ItemStack(RainimatorItems.SUPER_RUBY), new ItemStack(RainimatorItems.DIAMOND_APPLE_SUPPER, 3), 1, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.BLUE_DIAMOND), new ItemStack(RainimatorItems.SUPER_SAPPHIRE), new ItemStack(RainimatorItems.DIAMOND_APPLE_SUPPER, 3), 1, 5, 0.05F)
        )));
        //WEAPON SMITH
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 1, factories -> factories.addAll(List.of(
                new BuyWithPrice(new ItemStack(RainimatorItems.SOUL_PEOPLE), new ItemStack(RainimatorItems.RUBY, 2), 5, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.SOUL_PEOPLE), new ItemStack(RainimatorItems.SAPPHIRE, 2), 5, 5, 0.05F),
                new BuyWithPrice(new ItemStack(Items.REDSTONE, 3), new ItemStack(Items.STICK, 16), new ItemStack(Items.GOLDEN_APPLE), 10, 5, 0.05F),
                new BuyWithPrice(new ItemStack(Items.QUARTZ, 3), new ItemStack(Items.STICK, 16), new ItemStack(Items.ENCHANTED_GOLDEN_APPLE), 10, 5, 0.05F)
        )));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 2, factories -> factories.addAll(List.of(
                new BuyWithPrice(new ItemStack(RainimatorItems.ZOMBIE_HEART, 10), new ItemStack(RainimatorItems.WITHER_BONE, 2), new ItemStack(RainimatorItems.SUPER_RUBY), 5, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.ZOMBIE_HEART, 10), new ItemStack(RainimatorItems.WITHER_BONE, 2), new ItemStack(RainimatorItems.SUPER_SAPPHIRE), 5, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.BAO_ZHU), new ItemStack(RainimatorItems.WITHER_BONE), new ItemStack(RainimatorItems.MAGIC_STAR), 5, 5, 0.05F)
        )));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 3, factories -> factories.addAll(List.of(
                new BuyWithPrice(new ItemStack(RainimatorItems.ZOMBIE_HEART, 20), new ItemStack(RainimatorItems.WITHER_BONE, 5), new ItemStack(RainimatorItems.BLUE_DIAMOND), 3, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.RUBY), new ItemStack(RainimatorItems.RUBY_SWORD), 2, 25, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.SAPPHIRE), new ItemStack(RainimatorItems.SAPPHIRE_SWORD), 2, 25, 0.05F)
        )));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 4, factories -> factories.add(
                new BuyWithPrice(new ItemStack(Items.NETHERITE_SCRAP), new ItemStack(RainimatorItems.WITHER_BONE), new ItemStack(RainimatorItems.NETHERITE_WITHER_BONE), 5, 5, 0.05F)
        ));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 5, factories -> factories.addAll(List.of(
                new BuyWithPrice(new ItemStack(RainimatorItems.RUBY, 2), new ItemStack(RainimatorItems.SAPPHIRE, 2), new ItemStack(RainimatorItems.BLUE_DIAMOND), 3, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.HOT_IRON, 2), new ItemStack(Items.IRON_SWORD), new ItemStack(RainimatorItems.NETHERITE_FLAME_SABER), 1, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.SUPER_RUBY), new ItemStack(Items.IRON_SWORD), new ItemStack(RainimatorItems.RED_GOLD_DAGGER), 1, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.BLUE_DIAMOND), new ItemStack(RainimatorItems.MAGIC_STAR, 5), new ItemStack(RainimatorItems.BLACK_GUN), 1, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.BLUE_DIAMOND), new ItemStack(RainimatorItems.SUPER_RUBY), new ItemStack(RainimatorItems.NEAUS_SOULS), 1, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.BLUE_DIAMOND), new ItemStack(RainimatorItems.SUPER_SAPPHIRE), new ItemStack(RainimatorItems.NEAUS_SOULS), 1, 5, 0.05F)
        )));
        //ARMORER
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 1, factories -> factories.addAll(List.of(
                new BuyWithPrice(new ItemStack(Items.REDSTONE, 5), new ItemStack(RainimatorItems.SOUL_PEOPLE), 10, 5, 0.05F),
                new BuyWithPrice(new ItemStack(Items.ROTTEN_FLESH, 3), new ItemStack(Items.GOLDEN_CARROT), 10, 5, 0.05F),
                new BuyWithPrice(new ItemStack(Items.STRING, 3), new ItemStack(Items.GOLDEN_CARROT), 10, 5, 0.05F),
                new BuyWithPrice(new ItemStack(Items.BONE, 3), new ItemStack(Items.GOLDEN_CARROT), 10, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.MAGIC_STAR), new ItemStack(Blocks.COPPER_BLOCK), new ItemStack(Blocks.DIAMOND_BLOCK), 1, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.MAGIC_STAR), new ItemStack(Blocks.IRON_BLOCK), new ItemStack(Blocks.DIAMOND_BLOCK), 1, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.MAGIC_STAR), new ItemStack(Blocks.GOLD_BLOCK), new ItemStack(Blocks.DIAMOND_BLOCK), 1, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.MAGIC_STAR), new ItemStack(Blocks.REDSTONE_BLOCK), new ItemStack(Blocks.DIAMOND_BLOCK), 1, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.MAGIC_STAR), new ItemStack(Blocks.EMERALD_BLOCK), new ItemStack(Blocks.DIAMOND_BLOCK), 1, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.MAGIC_STAR), new ItemStack(Blocks.LAPIS_BLOCK), new ItemStack(Blocks.DIAMOND_BLOCK), 1, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.MAGIC_STAR), new ItemStack(Blocks.NETHERITE_BLOCK), new ItemStack(Blocks.DIAMOND_BLOCK), 1, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.MAGIC_STAR), new ItemStack(RainimatorBlocks.SAPPHIRE_BLOCK), new ItemStack(Blocks.DIAMOND_BLOCK), 1, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.MAGIC_STAR), new ItemStack(RainimatorBlocks.RUBY_BLOCK), new ItemStack(Blocks.DIAMOND_BLOCK), 1, 5, 0.05F)
        )));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 2, factories -> factories.add(
                new BuyWithPrice(new ItemStack(Items.REDSTONE, 5), new ItemStack(RainimatorItems.SOUL_PEOPLE, 2), 5, 5, 0.05F)
        ));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 3, factories -> factories.addAll(List.of(
                new BuyWithPrice(new ItemStack(RainimatorBlocks.SAPPHIRE_BLOCK), new ItemStack(RainimatorItems.DIAMOND_PIECE), new ItemStack(RainimatorItems.BLUE_DIAMOND), 1, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorBlocks.RUBY_BLOCK), new ItemStack(RainimatorItems.DIAMOND_PIECE), new ItemStack(RainimatorItems.BLUE_DIAMOND), 1, 5, 0.05F)
        )));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 4, factories -> factories.addAll(List.of(
                new BuyWithPrice(new ItemStack(RainimatorItems.SUPER_DIAMOND_APPLE), new ItemStack(RainimatorItems.ICE_HEART), new ItemStack(RainimatorItems.DIAMOND_APPLE_SUPPER, 2), 2, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.SUPER_DIAMOND_APPLE), new ItemStack(RainimatorItems.WARRIOR_HEART), new ItemStack(RainimatorItems.DIAMOND_APPLE_SUPPER, 2), 2, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.SUPER_DIAMOND_APPLE), new ItemStack(RainimatorItems.ENDER_HEART), new ItemStack(RainimatorItems.DIAMOND_APPLE_SUPPER, 2), 2, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.SUPER_DIAMOND_APPLE), new ItemStack(RainimatorItems.LIGHT_HEART), new ItemStack(RainimatorItems.DIAMOND_APPLE_SUPPER, 2), 2, 5, 0.05F)
        )));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 5, factories -> factories.add(
                new BuyWithPrice(new ItemStack(RainimatorItems.GEMSTONE_MIXTURE), new ItemStack(RainimatorItems.BLUE_DIAMOND), new ItemStack(RainimatorItems.DIAMOND_HATCHET), 1, 5, 0.05F)
        ));
        //FLETCHER
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FLETCHER, 1, factories -> factories.addAll(List.of(
                new BuyWithPrice(new ItemStack(Items.REDSTONE, 10), new ItemStack(RainimatorItems.SOUL_PEOPLE), 5, 5, 0.05F),
                new BuyWithPrice(new ItemStack(Items.COPPER_INGOT, 5), new ItemStack(RainimatorItems.MYSTERIOUS_GIFT_BOX), 5, 5, 0.05F),
                new BuyWithPrice(new ItemStack(Items.REDSTONE, 5), new ItemStack(RainimatorItems.MYSTERIOUS_GIFT_BOX), 5, 5, 0.05F),
                new BuyWithPrice(new ItemStack(Items.QUARTZ, 5), new ItemStack(RainimatorItems.MYSTERIOUS_GIFT_BOX), 5, 5, 0.05F),
                new BuyWithPrice(new ItemStack(Blocks.COPPER_BLOCK), new ItemStack(RainimatorItems.MYSTERIOUS_GIFT_BOX, 3), 3, 5, 0.05F),
                new BuyWithPrice(new ItemStack(Blocks.REDSTONE_BLOCK), new ItemStack(RainimatorItems.MYSTERIOUS_GIFT_BOX, 3), 3, 5, 0.05F),
                new BuyWithPrice(new ItemStack(Items.ROTTEN_FLESH, 5), new ItemStack(Items.EMERALD), 10, 5, 0.05F),
                new BuyWithPrice(new ItemStack(Items.BONE, 5), new ItemStack(Items.EMERALD), 10, 5, 0.05F),
                new BuyWithPrice(new ItemStack(Items.STRING, 5), new ItemStack(Items.EMERALD), 10, 5, 0.05F),
                new BuyWithPrice(new ItemStack(Items.GUNPOWDER, 5), new ItemStack(Items.EMERALD), 10, 5, 0.05F),
                new BuyWithPrice(new ItemStack(Items.SPIDER_EYE, 5), new ItemStack(Items.EMERALD), 10, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.ZOMBIE_HEART, 5), new ItemStack(Items.EMERALD), 10, 5, 0.05F),
                new BuyWithPrice(new ItemStack(Items.ARROW, 5), new ItemStack(Items.EMERALD), 10, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.WITHER_BONE, 5), new ItemStack(Items.EMERALD), 10, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.RUBY), new ItemStack(RainimatorItems.HOT_IRON), new ItemStack(RainimatorItems.COTTON_CANDY, 10), 10, 5, 0.05F),
                new BuyWithPrice(new ItemStack(RainimatorItems.SAPPHIRE), new ItemStack(RainimatorItems.HOT_IRON), new ItemStack(RainimatorItems.COTTON_CANDY, 10), 10, 5, 0.05F)
        )));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FLETCHER, 2, factories -> factories.add(
                new BuyWithPrice(new ItemStack(Items.REDSTONE, 8), new ItemStack(RainimatorItems.SOUL_PEOPLE), 5, 5, 0.05F)
        ));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FLETCHER, 3, factories -> factories.add(
                new BuyWithPrice(new ItemStack(Items.REDSTONE, 6), new ItemStack(RainimatorItems.SOUL_PEOPLE), 5, 5, 0.05F)
        ));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FLETCHER, 4, factories -> factories.add(
                new BuyWithPrice(new ItemStack(Items.REDSTONE, 4), new ItemStack(RainimatorItems.SOUL_PEOPLE), 5, 5, 0.05F)
        ));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FLETCHER, 5, factories -> factories.add(
                new BuyWithPrice(new ItemStack(Items.REDSTONE, 2), new ItemStack(RainimatorItems.SOUL_PEOPLE), 5, 5, 0.05F)
        ));
    }

    private static class BuyWithPrice implements TradeOffers.Factory {
        private final ItemStack input1;
        private final ItemStack input2;
        private final ItemStack output;
        private final int maxUses;
        private final int experience;
        private final float multiplier;

        public BuyWithPrice(ItemStack input, ItemStack output, int maxUses, int experience, float priceMultiplier) {
            this(input, null, output, maxUses, experience, priceMultiplier);
        }

        public BuyWithPrice(ItemStack input1, ItemStack input2, ItemStack output, int maxUses, int experience, float priceMultiplier) {
            this.input1 = input1;
            this.input2 = input2;
            this.output = output;
            this.maxUses = maxUses;
            this.experience = experience;
            this.multiplier = priceMultiplier;
        }

        @Nullable
        @Override
        public TradeOffer create(Entity entity, Random random) {
            if (this.input2 == null)
                return new TradeOffer(this.input1, this.output, this.maxUses, this.experience, this.multiplier);
            return new TradeOffer(this.input1, this.input2, this.output, this.maxUses, this.experience, this.multiplier);
        }
    }
}
