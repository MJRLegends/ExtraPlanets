package com.mjr.extraplanets.jei;

import javax.annotation.Nonnull;

import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.jei.blocksmasher.BlockSmasherRecipeCategory;
import com.mjr.extraplanets.jei.blocksmasher.BlockSmasherRecipeHandler;
import com.mjr.extraplanets.jei.blocksmasher.BlockSmasherRecipeMaker;
import com.mjr.extraplanets.jei.chemicalInjector.ChemicalInjectorRecipeCategory;
import com.mjr.extraplanets.jei.chemicalInjector.ChemicalInjectorRecipeHandler;
import com.mjr.extraplanets.jei.chemicalInjector.ChemicalInjectorRecipeMaker;
import com.mjr.extraplanets.jei.crystallizer.CrystallizerRecipeCategory;
import com.mjr.extraplanets.jei.crystallizer.CrystallizerRecipeHandler;
import com.mjr.extraplanets.jei.crystallizer.CrystallizerRecipeMaker;
import com.mjr.extraplanets.jei.rockets.tier10.Tier10RocketRecipeCategory;
import com.mjr.extraplanets.jei.rockets.tier10.Tier10RocketRecipeHandler;
import com.mjr.extraplanets.jei.rockets.tier10.Tier10RocketRecipeMaker;
import com.mjr.extraplanets.jei.rockets.tier10Electric.Tier10ElectricRocketRecipeCategory;
import com.mjr.extraplanets.jei.rockets.tier10Electric.Tier10ElectricRocketRecipeHandler;
import com.mjr.extraplanets.jei.rockets.tier10Electric.Tier10ElectricRocketRecipeMaker;
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
import com.mjr.extraplanets.jei.solarEvaporationChamber.SolarEvaporationChamberRecipeCategory;
import com.mjr.extraplanets.jei.solarEvaporationChamber.SolarEvaporationChamberRecipeHandler;
import com.mjr.extraplanets.jei.solarEvaporationChamber.SolarEvaporationChamberRecipeMaker;
import com.mjr.extraplanets.jei.vehicles.marsRover.MarsRoverRecipeCategory;
import com.mjr.extraplanets.jei.vehicles.marsRover.MarsRoverRecipeHandler;
import com.mjr.extraplanets.jei.vehicles.marsRover.MarsRoverRecipeMaker;
import com.mjr.extraplanets.jei.vehicles.venusRover.VenusRoverRecipeCategory;
import com.mjr.extraplanets.jei.vehicles.venusRover.VenusRoverRecipeHandler;
import com.mjr.extraplanets.jei.vehicles.venusRover.VenusRoverRecipeMaker;

@JEIPlugin
public class ExtraPlanetsJEI extends BlankModPlugin {
	@Override
	public void register(@Nonnull IModRegistry registry) {
		if (Config.JEI_SUPPORT) {
			IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();
			registry.addRecipeCategories(new Tier4RocketRecipeCategory(guiHelper), new Tier5RocketRecipeCategory(guiHelper), new Tier6RocketRecipeCategory(guiHelper), new Tier7RocketRecipeCategory(guiHelper),
					new Tier8RocketRecipeCategory(guiHelper), new Tier9RocketRecipeCategory(guiHelper), new Tier10RocketRecipeCategory(guiHelper), new MarsRoverRecipeCategory(guiHelper), new VenusRoverRecipeCategory(guiHelper),
					new BlockSmasherRecipeCategory(guiHelper), new SolarEvaporationChamberRecipeCategory(guiHelper), new Tier10ElectricRocketRecipeCategory(guiHelper), new ChemicalInjectorRecipeCategory(guiHelper), new CrystallizerRecipeCategory(
							guiHelper));
			registry.addRecipeHandlers(new Tier4RocketRecipeHandler(), new Tier5RocketRecipeHandler(), new Tier6RocketRecipeHandler(), new Tier7RocketRecipeHandler(), new Tier8RocketRecipeHandler(), new Tier9RocketRecipeHandler(),
					new Tier10RocketRecipeHandler(), new MarsRoverRecipeHandler(), new VenusRoverRecipeHandler(), new BlockSmasherRecipeHandler(), new SolarEvaporationChamberRecipeHandler(), new Tier10ElectricRocketRecipeHandler(),
					new ChemicalInjectorRecipeHandler(), new CrystallizerRecipeHandler());
			registry.addRecipes(Tier4RocketRecipeMaker.getRecipesList());
			registry.addRecipes(Tier5RocketRecipeMaker.getRecipesList());
			registry.addRecipes(Tier6RocketRecipeMaker.getRecipesList());
			registry.addRecipes(Tier7RocketRecipeMaker.getRecipesList());
			registry.addRecipes(Tier8RocketRecipeMaker.getRecipesList());
			registry.addRecipes(Tier9RocketRecipeMaker.getRecipesList());
			registry.addRecipes(Tier10RocketRecipeMaker.getRecipesList());
			registry.addRecipes(Tier10ElectricRocketRecipeMaker.getRecipesList());
			registry.addRecipes(MarsRoverRecipeMaker.getRecipesList());
			registry.addRecipes(VenusRoverRecipeMaker.getRecipesList());
			registry.addRecipes(BlockSmasherRecipeMaker.getRecipesList());
			registry.addRecipes(SolarEvaporationChamberRecipeMaker.getRecipesList());
			registry.addRecipes(ChemicalInjectorRecipeMaker.getRecipesList());
			registry.addRecipes(CrystallizerRecipeMaker.getRecipesList());
		}
	}
}