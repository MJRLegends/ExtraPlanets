package com.mjr.extraplanets.jei;

import javax.annotation.Nonnull;

import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.jei.rockets.tier10.Tier10RocketRecipeCategory;
import com.mjr.extraplanets.jei.rockets.tier10.Tier10RocketRecipeMaker;
import com.mjr.extraplanets.jei.rockets.tier10.Tier10RocketRecipeWrapper;
import com.mjr.extraplanets.jei.rockets.tier4.Tier4RocketRecipeCategory;
import com.mjr.extraplanets.jei.rockets.tier4.Tier4RocketRecipeMaker;
import com.mjr.extraplanets.jei.rockets.tier4.Tier4RocketRecipeWrapper;
import com.mjr.extraplanets.jei.rockets.tier5.Tier5RocketRecipeCategory;
import com.mjr.extraplanets.jei.rockets.tier5.Tier5RocketRecipeMaker;
import com.mjr.extraplanets.jei.rockets.tier5.Tier5RocketRecipeWrapper;
import com.mjr.extraplanets.jei.rockets.tier6.Tier6RocketRecipeCategory;
import com.mjr.extraplanets.jei.rockets.tier6.Tier6RocketRecipeMaker;
import com.mjr.extraplanets.jei.rockets.tier6.Tier6RocketRecipeWrapper;
import com.mjr.extraplanets.jei.rockets.tier7.Tier7RocketRecipeCategory;
import com.mjr.extraplanets.jei.rockets.tier7.Tier7RocketRecipeMaker;
import com.mjr.extraplanets.jei.rockets.tier7.Tier7RocketRecipeWrapper;
import com.mjr.extraplanets.jei.rockets.tier8.Tier8RocketRecipeCategory;
import com.mjr.extraplanets.jei.rockets.tier8.Tier8RocketRecipeMaker;
import com.mjr.extraplanets.jei.rockets.tier8.Tier8RocketRecipeWrapper;
import com.mjr.extraplanets.jei.rockets.tier9.Tier9RocketRecipeCategory;
import com.mjr.extraplanets.jei.rockets.tier9.Tier9RocketRecipeMaker;
import com.mjr.extraplanets.jei.rockets.tier9.Tier9RocketRecipeWrapper;
import com.mjr.extraplanets.jei.vehicles.marsRover.MarsRoverRecipeCategory;
import com.mjr.extraplanets.jei.vehicles.marsRover.MarsRoverRecipeMaker;
import com.mjr.extraplanets.jei.vehicles.marsRover.MarsRoverRecipeWrapper;
import com.mjr.extraplanets.jei.vehicles.venusRover.VenusRoverRecipeCategory;
import com.mjr.extraplanets.jei.vehicles.venusRover.VenusRoverRecipeMaker;
import com.mjr.extraplanets.jei.vehicles.venusRover.VenusRoverRecipeWrapper;

@JEIPlugin
public class ExtraPlanetsJEI extends BlankModPlugin {
	@Override
	public void register(@Nonnull IModRegistry registry) {
		if (Config.JEI_SUPPORT) {
			IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();
			registry.addRecipeCategories(
					new Tier4RocketRecipeCategory(guiHelper), 
					new Tier5RocketRecipeCategory(guiHelper), 
					new Tier6RocketRecipeCategory(guiHelper), 
					new Tier7RocketRecipeCategory(guiHelper),
					new Tier8RocketRecipeCategory(guiHelper), 
					new Tier9RocketRecipeCategory(guiHelper), 
					new Tier10RocketRecipeCategory(guiHelper), 
					new MarsRoverRecipeCategory(guiHelper), 
					new VenusRoverRecipeCategory(guiHelper)
			);

	        registry.handleRecipes(INasaWorkbenchRecipe.class, Tier4RocketRecipeWrapper::new, RecipeCategories.ROCKET_T4_ID);
	        registry.handleRecipes(INasaWorkbenchRecipe.class, Tier5RocketRecipeWrapper::new, RecipeCategories.ROCKET_T5_ID);
	        registry.handleRecipes(INasaWorkbenchRecipe.class, Tier6RocketRecipeWrapper::new, RecipeCategories.ROCKET_T6_ID);
	        registry.handleRecipes(INasaWorkbenchRecipe.class, Tier7RocketRecipeWrapper::new, RecipeCategories.ROCKET_T7_ID);
	        registry.handleRecipes(INasaWorkbenchRecipe.class, Tier8RocketRecipeWrapper::new, RecipeCategories.ROCKET_T8_ID);
	        registry.handleRecipes(INasaWorkbenchRecipe.class, Tier9RocketRecipeWrapper::new, RecipeCategories.ROCKET_T9_ID);
	        registry.handleRecipes(INasaWorkbenchRecipe.class, Tier10RocketRecipeWrapper::new, RecipeCategories.ROCKET_T10_ID);

	        registry.handleRecipes(INasaWorkbenchRecipe.class, MarsRoverRecipeWrapper::new, RecipeCategories.MARS_ROVER_ID);
	        registry.handleRecipes(INasaWorkbenchRecipe.class, VenusRoverRecipeWrapper::new, RecipeCategories.VENUS_ROVER_ID);

			registry.addRecipes(Tier4RocketRecipeMaker.getRecipesList(), RecipeCategories.ROCKET_T4_ID);
			registry.addRecipes(Tier5RocketRecipeMaker.getRecipesList(), RecipeCategories.ROCKET_T5_ID);
			registry.addRecipes(Tier6RocketRecipeMaker.getRecipesList(), RecipeCategories.ROCKET_T6_ID);
			registry.addRecipes(Tier7RocketRecipeMaker.getRecipesList(), RecipeCategories.ROCKET_T7_ID);
			registry.addRecipes(Tier8RocketRecipeMaker.getRecipesList(), RecipeCategories.ROCKET_T8_ID);
			registry.addRecipes(Tier9RocketRecipeMaker.getRecipesList(), RecipeCategories.ROCKET_T9_ID);
			registry.addRecipes(Tier10RocketRecipeMaker.getRecipesList(), RecipeCategories.ROCKET_T10_ID);
			registry.addRecipes(MarsRoverRecipeMaker.getRecipesList(), RecipeCategories.MARS_ROVER_ID);
			registry.addRecipes(VenusRoverRecipeMaker.getRecipesList(), RecipeCategories.VENUS_ROVER_ID);
		}
	}
}