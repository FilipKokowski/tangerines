package net.hurb.tangerines.datagen;

import net.hurb.tangerines.block.ModBlocks;
import net.hurb.tangerines.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PEELED_TANGERINE.get())
                .requires(ModItems.TANGERINE.get())
                .unlockedBy(getHasName(ModItems.TANGERINE.get()), has(ModItems.TANGERINE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TANGERINE_PEEL_FABRIC.get())
                .pattern("XX")
                .pattern("XX")
                .define('X', ModItems.TANGERINE_PEEL.get())
                .unlockedBy(getHasName(ModItems.TANGERINE_PEEL.get()), has(ModItems.TANGERINE_PEEL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TANGERINE_CAP.get())
                .pattern("XXX")
                .pattern("X X")
                .define('X', ModItems.TANGERINE_PEEL_FABRIC.get())
                .unlockedBy(getHasName(ModItems.TANGERINE_PEEL_FABRIC.get()), has(ModItems.TANGERINE_PEEL_FABRIC.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ORANGEWOOD_WOOD.get())
                .pattern("XX")
                .pattern("XX")
                .define('X', ModBlocks.ORANGEWOOD_LOG.get())
                .unlockedBy(getHasName(ModBlocks.ORANGEWOOD_LOG.get()), has(ModBlocks.ORANGEWOOD_LOG.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRIPPED_ORANGEWOOD_LOG.get())
                .pattern("XX")
                .pattern("XX")
                .define('X', ModBlocks.STRIPPED_ORANGEWOOD_LOG.get())
                .unlockedBy(getHasName(ModBlocks.STRIPPED_ORANGEWOOD_LOG.get()), has(ModBlocks.STRIPPED_ORANGEWOOD_LOG.get()))
                .save(pWriter);


    }
}
