package com.mjr.extraplanets.jei.purifier;

import java.util.List;

import javax.annotation.Nonnull;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.jei.RecipeCategories;

public class PurifierRecipeCategory extends BlankRecipeCategory {
	private static final ResourceLocation guiTexture = new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/purifier.png");

	@Nonnull
	private final IDrawable background;
	@Nonnull
	private final String localizedName;
	@Nonnull
	private final IDrawableAnimated saltBar;
	@Nonnull
	private final IDrawableAnimated saltBar2;
	@Nonnull
	private final IDrawableAnimated saltBar3;

	@Nonnull
	public PurifierRecipeCategory(IGuiHelper guiHelper) {
		this.background = guiHelper.createDrawable(guiTexture, 3, 4, 168, 80);
		this.localizedName = GCCoreUtil.translate("container.basic.purifier.name");
		IDrawableStatic progressBarDrawableSalt = guiHelper.createDrawable(guiTexture, 192, 0, 16, 38);
		this.saltBar = guiHelper.createAnimatedDrawable(progressBarDrawableSalt, 70, IDrawableAnimated.StartDirection.TOP, true);
		IDrawableStatic progressBarDrawableSalt2 = guiHelper.createDrawable(guiTexture, 192, 0, 16, 38);
		this.saltBar2 = guiHelper.createAnimatedDrawable(progressBarDrawableSalt2, 70, IDrawableAnimated.StartDirection.TOP, true);
		IDrawableStatic progressBarDrawableSalt3 = guiHelper.createDrawable(guiTexture, 192, 0, 16, 38);
		this.saltBar3 = guiHelper.createAnimatedDrawable(progressBarDrawableSalt3, 70, IDrawableAnimated.StartDirection.TOP, false);
	}

	@Nonnull
	@Override
	public String getUid() {
		return RecipeCategories.PURIFIER_ID;
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
	public void drawAnimations(@Nonnull Minecraft minecraft) {
		// this.saltBar.draw(minecraft, 4, 24);
		// this.saltBar2.draw(minecraft, 29, 24);
		// this.saltBar3.draw(minecraft, 129, 24);
	}

	@Override
	public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull IRecipeWrapper recipeWrapper) {
		IGuiItemStackGroup itemstacks = recipeLayout.getItemStacks();

		itemstacks.init(0, true, 3, 2);
		itemstacks.init(1, true, 28, 2);
		itemstacks.init(2, true, 69, 31);
		itemstacks.init(3, false, 28, 2);
		itemstacks.init(4, false, 118, 2);

		if (recipeWrapper instanceof PurifierRecipeWrapper) {
			PurifierRecipeWrapper circuitFabricatorRecipeWrapper = (PurifierRecipeWrapper) recipeWrapper;
			List inputs = circuitFabricatorRecipeWrapper.getInputs();

			for (int i = 0; i < inputs.size(); ++i) {
				Object o = inputs.get(i);
				if (o != null) {
					itemstacks.setFromRecipe(i, o);
				}
			}

			List outputs = circuitFabricatorRecipeWrapper.getOutputs();

			for (int i = 0; i < outputs.size(); ++i) {
				Object o = outputs.get(i);
				if (o != null) {
					itemstacks.setFromRecipe(i + 3, o);
				}
			}
		}
	}
}
