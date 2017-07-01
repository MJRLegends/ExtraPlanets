package com.mjr.extraplanets.jei.blocksmasher;

import javax.annotation.Nonnull;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.util.ResourceLocation;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.jei.RecipeCategories;

public class BlockSmasherRecipeCategory extends BlankRecipeCategory {
	private static final ResourceLocation guiTexture = new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/smasher.png");

	@Nonnull
	private final IDrawable background;
	@Nonnull
	private final String localizedName;

	@Nonnull
	public BlockSmasherRecipeCategory(IGuiHelper guiHelper) {
		this.background = guiHelper.createDrawable(guiTexture, 3, 4, 168, 80);
		this.localizedName = GCCoreUtil.translate("container.basic.smasher.name");
	}

	@Nonnull
	@Override
	public String getUid() {
		return RecipeCategories.BLOCK_SMASHER_ID;
	}

	@Nonnull
	@Override
	public String getTitle() {
		return this.localizedName;
	}

	@Nonnull
	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull IRecipeWrapper recipeWrapper) {
		IGuiItemStackGroup itemstacks = recipeLayout.getItemStacks();

		itemstacks.init(0, true, 46, 30);
		itemstacks.init(1, false, 108, 30);

		if (recipeWrapper instanceof BlockSmasherRecipeWrapper) {
			BlockSmasherRecipeWrapper circuitFabricatorRecipeWrapper = (BlockSmasherRecipeWrapper) recipeWrapper;
			itemstacks.setFromRecipe(0, circuitFabricatorRecipeWrapper.getInputs());
			itemstacks.setFromRecipe(1, circuitFabricatorRecipeWrapper.getOutputs());
		}
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, IRecipeWrapper recipeWrapper, IIngredients ingredients) {
		this.setRecipe(recipeLayout, recipeWrapper);
	}
}
