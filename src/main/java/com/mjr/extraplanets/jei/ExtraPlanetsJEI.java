package com.mjr.extraplanets.jei;

import javax.annotation.Nonnull;

import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;

import com.mjr.extraplanets.jei.rockets.tier10.Tier10RocketRecipeCategory;
import com.mjr.extraplanets.jei.rockets.tier10.Tier10RocketRecipeHandler;
import com.mjr.extraplanets.jei.rockets.tier10.Tier10RocketRecipeMaker;
import com.mjr.extraplanets.jei.rockets.tier4.Tier4RocketRecipeCategory;
import com.mjr.extraplanets.jei.rockets.tier4.Tier4RocketRecipeHandler;
import com.mjr.extraplanets.jei.rockets.tier4.Tier4RocketRecipeMaker;
import com.mjr.extraplanets.jei.rockets.tier5.Tier5RocketRecipeCategory;
import com.mjr.extraplanets.jei.rockets.tier5.Tier5RocketRecipeHandler;
import com.mjr.extraplanets.jei.rockets.tier5.Tier5RocketRecipeMaker;
import com.mjr.extraplanets.jei.rockets.tier6.Tier6RocketRecipeCategory;
import com.mjr.extraplanets.jei.rockets.tier6.Tier6RocketRecipeHandler;
import com.mjr.extraplanets.jei.rockets.tier6.Tier6RocketRecipeMaker;
import com.mjr.extraplanets.jei.rockets.tier7.Tier7RocketRecipeCategory;
import com.mjr.extraplanets.jei.rockets.tier7.Tier7RocketRecipeHandler;
import com.mjr.extraplanets.jei.rockets.tier7.Tier7RocketRecipeMaker;
import com.mjr.extraplanets.jei.rockets.tier8.Tier8RocketRecipeCategory;
import com.mjr.extraplanets.jei.rockets.tier8.Tier8RocketRecipeHandler;
import com.mjr.extraplanets.jei.rockets.tier8.Tier8RocketRecipeMaker;
import com.mjr.extraplanets.jei.rockets.tier9.Tier9RocketRecipeCategory;
import com.mjr.extraplanets.jei.rockets.tier9.Tier9RocketRecipeHandler;
import com.mjr.extraplanets.jei.rockets.tier9.Tier9RocketRecipeMaker;

@JEIPlugin
public class ExtraPlanetsJEI extends BlankModPlugin {
	@Override
	public void register(@Nonnull IModRegistry registry) {
		IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();
		registry.addRecipeCategories(new Tier4RocketRecipeCategory(guiHelper), new Tier5RocketRecipeCategory(guiHelper), new Tier6RocketRecipeCategory(guiHelper), new Tier7RocketRecipeCategory(guiHelper), new Tier8RocketRecipeCategory(guiHelper),
				new Tier9RocketRecipeCategory(guiHelper), new Tier10RocketRecipeCategory(guiHelper));
		registry.addRecipeHandlers(new Tier4RocketRecipeHandler(), new Tier5RocketRecipeHandler(), new Tier6RocketRecipeHandler(), new Tier7RocketRecipeHandler(), new Tier8RocketRecipeHandler(), new Tier9RocketRecipeHandler(),
				new Tier10RocketRecipeHandler());
		registry.addRecipes(Tier4RocketRecipeMaker.getRecipesList());
		registry.addRecipes(Tier5RocketRecipeMaker.getRecipesList());
		registry.addRecipes(Tier6RocketRecipeMaker.getRecipesList());
		registry.addRecipes(Tier7RocketRecipeMaker.getRecipesList());
		registry.addRecipes(Tier8RocketRecipeMaker.getRecipesList());
		registry.addRecipes(Tier9RocketRecipeMaker.getRecipesList());
		registry.addRecipes(Tier10RocketRecipeMaker.getRecipesList());

	}
}