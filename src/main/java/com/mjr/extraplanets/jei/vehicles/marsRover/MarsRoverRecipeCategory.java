package com.mjr.extraplanets.jei.vehicles.marsRover;

import java.util.List;

import javax.annotation.Nonnull;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.jei.RecipeCategories;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class MarsRoverRecipeCategory extends BlankRecipeCategory {
	private static final ResourceLocation buggyGuiTexture = new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/mars_roverbench.png");

	@Nonnull
	private final IDrawable background;
	@Nonnull
	private final String localizedName;

	public MarsRoverRecipeCategory(IGuiHelper guiHelper) {
		this.background = guiHelper.createDrawable(buggyGuiTexture, 3, 4, 168, 130);
		this.localizedName = TranslateUtilities.translate("tile.rocket_workbench.name");

	}

	@Nonnull
	@Override
	public String getUid() {
		return RecipeCategories.MARS_ROVER_ID;
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
		IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();

		itemStacks.init(0, true, 35, 28);
		itemStacks.init(1, true, 35, 46);
		itemStacks.init(2, true, 35, 64);
		itemStacks.init(3, true, 35, 82);
		itemStacks.init(4, true, 35, 100);

		itemStacks.init(5, true, 53, 28);
		itemStacks.init(6, true, 53, 46);
		itemStacks.init(7, true, 53, 64);
		itemStacks.init(8, true, 53, 82);
		itemStacks.init(9, true, 53, 100);

		itemStacks.init(10, true, 71, 28);
		itemStacks.init(11, true, 71, 46);
		itemStacks.init(12, true, 71, 64);
		itemStacks.init(13, true, 71, 82);
		itemStacks.init(14, true, 71, 100);

		itemStacks.init(15, true, 17, 28);
		itemStacks.init(16, true, 17, 64);
		itemStacks.init(17, true, 17, 100);

		itemStacks.init(18, true, 89, 28);
		itemStacks.init(19, true, 89, 64);
		itemStacks.init(20, true, 89, 100);

		itemStacks.init(21, true, 89, 7);
		itemStacks.init(22, true, 115, 7);
		itemStacks.init(23, true, 141, 7);
		itemStacks.init(24, false, 138, 100);

		if (recipeWrapper instanceof MarsRoverRecipeWrapper) {
			MarsRoverRecipeWrapper buggyRecipeWrapper = (MarsRoverRecipeWrapper) recipeWrapper;
			List<ItemStack> inputs = buggyRecipeWrapper.getInputs();

			for (int i = 0; i < inputs.size(); ++i) {
				Object o = inputs.get(i);
				if (o != null) {
					itemStacks.setFromRecipe(i, o);
				}
			}
			itemStacks.setFromRecipe(24, buggyRecipeWrapper.getOutputs());
		}
	}
}