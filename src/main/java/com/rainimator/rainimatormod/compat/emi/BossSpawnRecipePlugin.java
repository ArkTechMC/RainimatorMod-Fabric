package com.rainimator.rainimatormod.compat.emi;

import com.rainimator.rainimatormod.RainimatorMod;
import com.rainimator.rainimatormod.registry.ModItems;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BossSpawnRecipePlugin implements EmiPlugin {
    private static final Identifier BOSS_SPAWN = new Identifier(RainimatorMod.MOD_ID, "boss_spawn_recipe");
    private static final EmiTexture TEXTURE = new EmiTexture(new Identifier(RainimatorMod.MOD_ID, "textures/gui/gui_boss_spawn_recipe.png"), 0, 0, 140, 44);
    private static final EmiStack WORKSTATION = EmiStack.of(ModItems.DARK_OBSIDIAN_BLOCK);
    private static final EmiRecipeCategory BOSS_SPAWN_CATEGORY = new EmiRecipeCategory(BOSS_SPAWN, WORKSTATION, TEXTURE);
    private static final List<BossSpawnRecipe> RECIPES = List.of(
            new BossSpawnRecipe("herobrine", ModItems.LIGHT_HEART, ModItems.HEROBRINE_SPAWN_EGG),
            new BossSpawnRecipe("kralos", Blocks.WITHER_ROSE, ModItems.KRALOS_SPAWN_EGG),
            new BossSpawnRecipe("klaus", Items.TOTEM_OF_UNDYING, ModItems.KLAUS_SPAWN_EGG),
            new BossSpawnRecipe("gigabone", Blocks.WITHER_SKELETON_SKULL, ModItems.GIGABONE_SPAWN_EGG),
            new BossSpawnRecipe("namtar", ModItems.SOUL_PEOPLE, ModItems.NAMTAR_SPAWN_EGG),
            new BossSpawnRecipe("big_undead_skeleton", ModItems.WITHER_BONE, ModItems.BIG_UNDEAD_SKELETON_SPAWN_EGG),
            new BossSpawnRecipe("piglin_commander", Items.GOLDEN_SWORD, ModItems.PIGLIN_COMMANDER_SPAWN_EGG),
            new BossSpawnRecipe("zombie_piglin_king", Items.GOLD_INGOT, ModItems.ZOMBIES_PIGLIN_KING_SPAWN_EGG),
            new BossSpawnRecipe("piglin_king_zombies", Blocks.GOLD_BLOCK, ModItems.PIGLIN_KING_ZOMBIES_SPAWN_EGG),
            new BossSpawnRecipe("null_like", ModItems.BAO_ZHU, ModItems.NULL_LIKE_SPAWN_EGG),
            new BossSpawnRecipe("naeus", ModItems.WARRIOR_HEART, ModItems.NAEUS_SPAWN_EGG),
            new BossSpawnRecipe("ciara", ModItems.ICE_HEART, ModItems.CIARA_SPAWN_EGG),
            new BossSpawnRecipe("dark_shield", ModItems.ENDER_HEART, ModItems.DARK_SHIELD_SPAWN_EGG),
            new BossSpawnRecipe("patrick", ModItems.MAGIC_STARD, ModItems.PATRICK_SPAWN_EGG),
            new BossSpawnRecipe("blackbone", ModItems.NETHERITE_WITHER_BONE, ModItems.BLACKBONE_SPAWN_EGG),
            new BossSpawnRecipe("abigail", ModItems.UNDER_FLOWER, ModItems.ABIGAIL_SPAWN_EGG)
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
            return 76;
        }

        @Override
        public int getDisplayHeight() {
            return 18;
        }

        @Override
        public void addWidgets(WidgetHolder widgets) {
            widgets.addTexture(TEXTURE, 0, 0);

            // Adds an input slot on the left
            widgets.addSlot(this.getInputs().get(0), 14, 13);
            widgets.addSlot(EmiIngredient.of(List.of(WORKSTATION)), 62, 13);

            // Adds an output slot on the right
            // Note that output slots need to call `recipeContext` to inform EMI about their recipe context
            // This includes being able to resolve recipe trees, favorite stacks with recipe context, and more
            widgets.addSlot(this.getOutputs().get(0), 110, 13).recipeContext(this);
        }
    }
}
