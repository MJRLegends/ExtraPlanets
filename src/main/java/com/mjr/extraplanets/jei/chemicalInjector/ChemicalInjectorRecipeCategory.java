package com.mjr.extraplanets.jei.chemicalInjector;

import java.util.List;

import javax.annotation.Nonnull;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.util.ResourceLocation;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.jei.RecipeCategories;

public class ChemicalInjectorRecipeCategory extends BlankRecipeCategory {
	private static final ResourceLocation guiTexture = new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/chemical_injector.png");

	@Nonnull
	private final IDrawable background;
	@Nonnull
	private final String localizedName;

	@Nonnull
	public ChemicalInjectorRecipeCategory(IGuiHelper guiHelper) {
		this.background = guiHelper.createDrawable(guiTexture, 3, 4, 168, 80);
		this.localizedName = GCCoreUtil.translate("container.basic.chemical_injector.name");
	}

	@Nonnull
	@Override
	public String getUid() {
		return RecipeCategories.CHEMAICAL_INJECTOR_ID;
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

		itemstacks.init(0, true, 26, 30);
		itemstacks.init(1, true, 66, 30);
		itemstacks.init(2, false, 116, 30);

		if (recipeWrapper instanceof ChemicalInjectorRecipeWrapper) {
			ChemicalInjectorRecipeWrapper circuitFabricatorRecipeWrapper = (ChemicalInjectorRecipeWrapper) recipeWrapper;
			List inputs = circuitFabricatorRecipeWrapper.getInputs();

			for (int i = 0; i < inputs.size(); ++i) {
				Object o = inputs.get(i);
				if (o != null) {
					itemstacks.setFromRecipe(i, o);
				}
			}
			itemstacks.setFromRecipe(2, circuitFabricatorRecipeWrapper.getOutputs());
		}
	}
}
