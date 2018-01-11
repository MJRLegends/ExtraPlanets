package com.mjr.extraplanets.jei;

import javax.annotation.Nonnull;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.jei.blocksmasher.BlockSmasherRecipeCategory;
import com.mjr.extraplanets.jei.blocksmasher.BlockSmasherRecipeMaker;
import com.mjr.extraplanets.jei.blocksmasher.BlockSmasherRecipeWrapper;
import com.mjr.extraplanets.jei.chemicalInjector.ChemicalInjectorRecipeCategory;
import com.mjr.extraplanets.jei.chemicalInjector.ChemicalInjectorRecipeMaker;
import com.mjr.extraplanets.jei.chemicalInjector.ChemicalInjectorRecipeWrapper;
import com.mjr.extraplanets.jei.crystallizer.CrystallizerRecipeCategory;
import com.mjr.extraplanets.jei.crystallizer.CrystallizerRecipeMaker;
import com.mjr.extraplanets.jei.crystallizer.CrystallizerRecipeWrapper;
import com.mjr.extraplanets.jei.densifier.DensifierRecipeCategory;
import com.mjr.extraplanets.jei.densifier.DensifierRecipeMaker;
import com.mjr.extraplanets.jei.purifier.PurifierRecipeCategory;
import com.mjr.extraplanets.jei.purifier.PurifierRecipeMaker;
import com.mjr.extraplanets.jei.purifier.PurifierRecipeWrapper;
import com.mjr.extraplanets.jei.rockets.tier10.Tier10RocketRecipeCategory;
import com.mjr.extraplanets.jei.rockets.tier10.Tier10RocketRecipeMaker;
import com.mjr.extraplanets.jei.rockets.tier10.Tier10RocketRecipeWrapper;
import com.mjr.extraplanets.jei.rockets.tier10Electric.Tier10ElectricRocketRecipeCategory;
import com.mjr.extraplanets.jei.rockets.tier10Electric.Tier10ElectricRocketRecipeMaker;
import com.mjr.extraplanets.jei.rockets.tier10Electric.Tier10ElectricRocketRecipeWrapper;
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
import com.mjr.extraplanets.jei.solarEvaporationChamber.SolarEvaporationChamberRecipeCategory;
import com.mjr.extraplanets.jei.solarEvaporationChamber.SolarEvaporationChamberRecipeMaker;
import com.mjr.extraplanets.jei.solarEvaporationChamber.SolarEvaporationChamberRecipeWrapper;
import com.mjr.extraplanets.jei.vehicles.marsRover.MarsRoverRecipeCategory;
import com.mjr.extraplanets.jei.vehicles.marsRover.MarsRoverRecipeMaker;
import com.mjr.extraplanets.jei.vehicles.marsRover.MarsRoverRecipeWrapper;
import com.mjr.extraplanets.jei.vehicles.venusRover.VenusRoverRecipeCategory;
import com.mjr.extraplanets.jei.vehicles.venusRover.VenusRoverRecipeMaker;
import com.mjr.extraplanets.jei.vehicles.venusRover.VenusRoverRecipeWrapper;

@JEIPlugin
public class ExtraPlanetsJEI implements IModPlugin {
	@Override
	public void register(@Nonnull IModRegistry registry) {
		if (Config.JEI_SUPPORT) {
			// IStackHelper stackHelper = registry.getJeiHelpers().getStackHelper();

			registry.handleRecipes(INasaWorkbenchRecipe.class, Tier4RocketRecipeWrapper::new, RecipeCategories.ROCKET_T4_ID);
			registry.handleRecipes(INasaWorkbenchRecipe.class, Tier5RocketRecipeWrapper::new, RecipeCategories.ROCKET_T5_ID);
			registry.handleRecipes(INasaWorkbenchRecipe.class, Tier6RocketRecipeWrapper::new, RecipeCategories.ROCKET_T6_ID);
			registry.handleRecipes(INasaWorkbenchRecipe.class, Tier7RocketRecipeWrapper::new, RecipeCategories.ROCKET_T7_ID);
			registry.handleRecipes(INasaWorkbenchRecipe.class, Tier8RocketRecipeWrapper::new, RecipeCategories.ROCKET_T8_ID);
			registry.handleRecipes(INasaWorkbenchRecipe.class, Tier9RocketRecipeWrapper::new, RecipeCategories.ROCKET_T9_ID);
			registry.handleRecipes(INasaWorkbenchRecipe.class, Tier10RocketRecipeWrapper::new, RecipeCategories.ROCKET_T10_ID);
			registry.handleRecipes(INasaWorkbenchRecipe.class, Tier10ElectricRocketRecipeWrapper::new, RecipeCategories.ROCKET_T10_ELECTRIC_ID);

			registry.handleRecipes(INasaWorkbenchRecipe.class, MarsRoverRecipeWrapper::new, RecipeCategories.MARS_ROVER_ID);
			registry.handleRecipes(INasaWorkbenchRecipe.class, VenusRoverRecipeWrapper::new, RecipeCategories.VENUS_ROVER_ID);

			registry.handleRecipes(BlockSmasherRecipeWrapper.class, recipe -> recipe, RecipeCategories.BLOCK_SMASHER_ID);
			registry.handleRecipes(SolarEvaporationChamberRecipeWrapper.class, recipe -> recipe, RecipeCategories.SOLAR_EVAPORTATION_CHAMBER_ID);
			registry.handleRecipes(ChemicalInjectorRecipeWrapper.class, recipe -> recipe, RecipeCategories.CHEMAICAL_INJECTOR_ID);
			registry.handleRecipes(CrystallizerRecipeWrapper.class, recipe -> recipe, RecipeCategories.CRYSTALLIZER_ID);
			registry.handleRecipes(PurifierRecipeWrapper.class, recipe -> recipe, RecipeCategories.PURIFIER_ID);

			registry.addRecipes(Tier4RocketRecipeMaker.getRecipesList(), RecipeCategories.ROCKET_T4_ID);
			registry.addRecipes(Tier5RocketRecipeMaker.getRecipesList(), RecipeCategories.ROCKET_T5_ID);
			registry.addRecipes(Tier6RocketRecipeMaker.getRecipesList(), RecipeCategories.ROCKET_T6_ID);
			registry.addRecipes(Tier7RocketRecipeMaker.getRecipesList(), RecipeCategories.ROCKET_T7_ID);
			registry.addRecipes(Tier8RocketRecipeMaker.getRecipesList(), RecipeCategories.ROCKET_T8_ID);
			registry.addRecipes(Tier9RocketRecipeMaker.getRecipesList(), RecipeCategories.ROCKET_T9_ID);
			registry.addRecipes(Tier10RocketRecipeMaker.getRecipesList(), RecipeCategories.ROCKET_T10_ID);
			registry.addRecipes(Tier10ElectricRocketRecipeMaker.getRecipesList(), RecipeCategories.ROCKET_T10_ELECTRIC_ID);
			registry.addRecipes(MarsRoverRecipeMaker.getRecipesList(), RecipeCategories.MARS_ROVER_ID);
			registry.addRecipes(VenusRoverRecipeMaker.getRecipesList(), RecipeCategories.VENUS_ROVER_ID);
			registry.addRecipes(BlockSmasherRecipeMaker.getRecipesList(), RecipeCategories.BLOCK_SMASHER_ID);
			registry.addRecipes(SolarEvaporationChamberRecipeMaker.getRecipesList(), RecipeCategories.SOLAR_EVAPORTATION_CHAMBER_ID);
			registry.addRecipes(ChemicalInjectorRecipeMaker.getRecipesList(), RecipeCategories.CHEMAICAL_INJECTOR_ID);
			registry.addRecipes(CrystallizerRecipeMaker.getRecipesList(), RecipeCategories.CRYSTALLIZER_ID);
			registry.addRecipes(PurifierRecipeMaker.getRecipesList(), RecipeCategories.PURIFIER_ID);
			registry.addRecipes(DensifierRecipeMaker.getRecipesList(), RecipeCategories.DENSIFIER_ID);

		}
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();
		registry.addRecipeCategories(new Tier4RocketRecipeCategory(guiHelper), new Tier5RocketRecipeCategory(guiHelper), new Tier6RocketRecipeCategory(guiHelper), new Tier7RocketRecipeCategory(guiHelper), new Tier8RocketRecipeCategory(guiHelper),
				new Tier9RocketRecipeCategory(guiHelper), new Tier10RocketRecipeCategory(guiHelper), new MarsRoverRecipeCategory(guiHelper), new VenusRoverRecipeCategory(guiHelper), new BlockSmasherRecipeCategory(guiHelper),
				new SolarEvaporationChamberRecipeCategory(guiHelper), new Tier10ElectricRocketRecipeCategory(guiHelper), new ChemicalInjectorRecipeCategory(guiHelper), new CrystallizerRecipeCategory(guiHelper), new PurifierRecipeCategory(guiHelper),
				new DensifierRecipeCategory(guiHelper));

	}
}