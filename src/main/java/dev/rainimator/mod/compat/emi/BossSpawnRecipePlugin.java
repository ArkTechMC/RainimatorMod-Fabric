package dev.rainimator.mod.compat.emi;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import dev.rainimator.mod.RainimatorMod;
import dev.rainimator.mod.registry.RainimatorItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Environment(EnvType.CLIENT)
public class BossSpawnRecipePlugin implements EmiPlugin {
    private static final Identifier BOSS_SPAWN = new Identifier(RainimatorMod.MOD_ID, "boss_spawn_recipe");
    private static final EmiTexture TEXTURE = new EmiTexture(new Identifier(RainimatorMod.MOD_ID, "textures/gui/gui_boss_spawn_recipe.png"), 0, 0, 140, 44);
    private static final EmiStack WORKSTATION = EmiStack.of(RainimatorItems.DARK_OBSIDIAN_BLOCK);
    private static final EmiRecipeCategory BOSS_SPAWN_CATEGORY = new EmiRecipeCategory(BOSS_SPAWN, WORKSTATION, TEXTURE);
    private static final List<BossSpawnRecipe> RECIPES = List.of(
            new BossSpawnRecipe("herobrine", RainimatorItems.LIGHT_HEART, RainimatorItems.HEROBRINE_SPAWN_EGG),
            new BossSpawnRecipe("kralos", Blocks.WITHER_ROSE, RainimatorItems.KRALOS_SPAWN_EGG),
            new BossSpawnRecipe("klaus", Items.TOTEM_OF_UNDYING, RainimatorItems.KLAUS_SPAWN_EGG),
            new BossSpawnRecipe("gigabone", Blocks.WITHER_SKELETON_SKULL, RainimatorItems.GIGABONE_SPAWN_EGG),
            new BossSpawnRecipe("namtar", RainimatorItems.SOUL_PEOPLE, RainimatorItems.NAMTAR_SPAWN_EGG),
            new BossSpawnRecipe("big_undead_skeleton", RainimatorItems.WITHER_BONE, RainimatorItems.BIG_UNDEAD_SKELETON_SPAWN_EGG),
            new BossSpawnRecipe("piglin_commander", Items.GOLDEN_SWORD, RainimatorItems.PIGLIN_COMMANDER_SPAWN_EGG),
            new BossSpawnRecipe("zombie_piglin_king", Items.GOLD_INGOT, RainimatorItems.ZOMBIES_PIGLIN_KING_SPAWN_EGG),
            new BossSpawnRecipe("piglin_king_zombies", Blocks.GOLD_BLOCK, RainimatorItems.PIGLIN_KING_ZOMBIES_SPAWN_EGG),
            new BossSpawnRecipe("null_like", RainimatorItems.BAO_ZHU, RainimatorItems.NULL_LIKE_SPAWN_EGG),
            new BossSpawnRecipe("naeus", RainimatorItems.WARRIOR_HEART, RainimatorItems.NAEUS_SPAWN_EGG),
            new BossSpawnRecipe("ciara", RainimatorItems.ICE_HEART, RainimatorItems.CIARA_SPAWN_EGG),
            new BossSpawnRecipe("ceris", RainimatorItems.ENDER_HEART, RainimatorItems.CERIS_SPAWN_EGG),
            new BossSpawnRecipe("patrick", RainimatorItems.MAGIC_STAR, RainimatorItems.PATRICK_SPAWN_EGG),
            new BossSpawnRecipe("blackbone", RainimatorItems.NETHERITE_WITHER_BONE, RainimatorItems.BLACKBONE_SPAWN_EGG),
            new BossSpawnRecipe("abigail", RainimatorItems.UNDER_FLOWER, RainimatorItems.ABIGAIL_SPAWN_EGG)
    );

    @Override
    public void register(EmiRegistry registry) {
        registry.addCategory(BOSS_SPAWN_CATEGORY);
        registry.addWorkstation(BOSS_SPAWN_CATEGORY, WORKSTATION);
        for (BossSpawnRecipe recipe : RECIPES)
            registry.addRecipe(recipe);
    }

    private record BossSpawnRecipe(String id, ItemConvertible input, ItemConvertible output) implements EmiRecipe {
        @Override
        public EmiRecipeCategory getCategory() {
            return BOSS_SPAWN_CATEGORY;
        }

        @Override
        public @NotNull Identifier getId() {
            return new Identifier(RainimatorMod.MOD_ID, this.id);
        }

        @Override
        public List<EmiIngredient> getInputs() {
            return List.of(EmiIngredient.of(Ingredient.ofItems(this.input)));
        }

        @Override
        public List<EmiStack> getOutputs() {
            return List.of(EmiStack.of(this.output));
        }

        @Override
        public int getDisplayWidth() {
            return 140;
        }

        @Override
        public int getDisplayHeight() {
            return 44;
        }

        @Override
        public void addWidgets(WidgetHolder widgets) {
            widgets.addTexture(TEXTURE, 0, 0);
            widgets.addSlot(this.getInputs().get(0), 13, 12);
            widgets.addSlot(EmiIngredient.of(List.of(WORKSTATION)), 61, 12);
            widgets.addSlot(this.getOutputs().get(0), 109, 12).recipeContext(this);
        }
    }
}
