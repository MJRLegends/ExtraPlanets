package com.mjr.extraplanets.jei.densifier;

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

public class DensifierRecipeCategory extends BlankRecipeCategory {
	private static final ResourceLocation guiTexture = new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/densifier.png");

	@Nonnull
	private final IDrawable background;
	@Nonnull
	private final String localizedName;

	@Nonnull
	public DensifierRecipeCategory(IGuiHelper guiHelper) {
		this.background = guiHelper.createDrawable(guiTexture, 3, 4, 168, 80);
		this.localizedName = GCCoreUtil.translate("container.basic.densifier.name");
	}

	@Nonnull
	@Override
	public String getUid() {
		return RecipeCategories.DENSIFIER_ID;
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
	public void setRecipe(IRecipeLayout recipeLayout, IRecipeWrapper recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup itemstacks = recipeLayout.getItemStacks();

		itemstacks.init(0, true, 3, 2);
		itemstacks.init(1, false, 108, 30);
        itemstacks.set(ingredients);
	}

	@Override
	public String getModName() {
		return Constants.modName;
	}
}
