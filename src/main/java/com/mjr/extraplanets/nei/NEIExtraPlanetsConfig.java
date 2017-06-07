package com.mjr.extraplanets.nei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import codechicken.nei.api.stack.PositionedStack;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class NEIExtraPlanetsConfig implements IConfigureNEI {
	private static HashMap<ArrayList<PositionedStack>, PositionedStack> t4rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();
	private static HashMap<ArrayList<PositionedStack>, PositionedStack> t5rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();
	private static HashMap<ArrayList<PositionedStack>, PositionedStack> t6rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();
	private static HashMap<ArrayList<PositionedStack>, PositionedStack> t7rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();
	private static HashMap<ArrayList<PositionedStack>, PositionedStack> t8rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();
	private static HashMap<ArrayList<PositionedStack>, PositionedStack> t9rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();
	private static HashMap<ArrayList<PositionedStack>, PositionedStack> t10rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();
	private static HashMap<HashMap<Integer, PositionedStack>, PositionedStack> circuitFabricatorRecipes = new HashMap<HashMap<Integer, PositionedStack>, PositionedStack>();
	private static HashMap<HashMap<Integer, PositionedStack>, PositionedStack> marsRoverBenchRecipes = new HashMap<HashMap<Integer, PositionedStack>, PositionedStack>();
	private static HashMap<HashMap<Integer, PositionedStack>, PositionedStack> venusRoverBenchRecipes = new HashMap<HashMap<Integer, PositionedStack>, PositionedStack>();

	@Override
	public void loadConfig() {
		if (Config.NEI_SUPPORT) {
			if (Config.MERCURY)
				this.registerTier4Recipe();
			if (Config.JUPITER)
				this.registerTier5Recipe();
			if (Config.SATURN)
				this.registerTier6Recipe();
			if (Config.URANUS)
				this.registerTier7Recipe();
			if (Config.NEPTUNE)
				this.registerTier8Recipe();
			if (Config.PLUTO)
				this.registerTier9Recipe();
			if (Config.ERIS)
				this.registerTier10Recipe();
			this.addCircuitFabricatorRecipes();
			this.addMarsRoverRecipes();
			this.addVenusRoverRecipes();

			if (Config.MERCURY) {
				API.registerRecipeHandler(new RocketT4RecipeHandler());
				API.registerUsageHandler(new RocketT4RecipeHandler());
				API.hideItem(new ItemStack(ExtraPlanets_Blocks.MERCURY_SPAWNER));
			}
			if (Config.JUPITER) {
				API.registerRecipeHandler(new RocketT5RecipeHandler());
				API.registerUsageHandler(new RocketT5RecipeHandler());
				API.hideItem(new ItemStack(ExtraPlanets_Blocks.JUIPTER_SPAWNER));
			}
			if (Config.SATURN) {
				API.registerRecipeHandler(new RocketT6RecipeHandler());
				API.registerUsageHandler(new RocketT6RecipeHandler());
				API.hideItem(new ItemStack(ExtraPlanets_Blocks.SATURN_SPAWNER));
			}
			if (Config.URANUS) {
				API.registerRecipeHandler(new RocketT7RecipeHandler());
				API.registerUsageHandler(new RocketT7RecipeHandler());
				API.hideItem(new ItemStack(ExtraPlanets_Blocks.URANUS_SPAWNER));
			}
			if (Config.NEPTUNE) {
				API.registerRecipeHandler(new RocketT8RecipeHandler());
				API.registerUsageHandler(new RocketT8RecipeHandler());
				API.hideItem(new ItemStack(ExtraPlanets_Blocks.NEPTUNE_SPAWNER));
			}
			if (Config.PLUTO) {
				API.registerRecipeHandler(new RocketT9RecipeHandler());
				API.registerUsageHandler(new RocketT9RecipeHandler());
				API.hideItem(new ItemStack(ExtraPlanets_Blocks.PLUTO_SPAWNER));
			}
			if (Config.ERIS) {
				API.registerRecipeHandler(new RocketT10RecipeHandler());
				API.registerUsageHandler(new RocketT10RecipeHandler());
				API.hideItem(new ItemStack(ExtraPlanets_Blocks.ERIS_SPAWNER));
			}
			API.registerRecipeHandler(new CircuitFabricatorRecipeHandler());
			API.registerUsageHandler(new CircuitFabricatorRecipeHandler());

			API.hideItem(new ItemStack(ExtraPlanets_Blocks.ADVANCED_LAUCHPAD_FULL, 0, 0));
			API.hideItem(new ItemStack(ExtraPlanets_Blocks.ADVANCED_LAUCHPAD_FULL, 0, 1));

			API.registerRecipeHandler(new MarsRoverRecipeHandler());
			API.registerUsageHandler(new MarsRoverRecipeHandler());
			API.registerRecipeHandler(new VenusRoverRecipeHandler());
			API.registerUsageHandler(new VenusRoverRecipeHandler());
		}
	}

	@Override
	public String getName() {
		return "ExtraPlanets NEI Plugin";
	}

	@Override
	public String getVersion() {
		return Constants.LOCALMAJVERSION + "." + Constants.LOCALMINVERSION + "." + Constants.LOCALBUILDVERSION;
	}

	public void registerTier4RocketBenchRecipe(ArrayList<PositionedStack> input, PositionedStack output) {
		NEIExtraPlanetsConfig.t4rocketBenchRecipes.put(input, output);
	}

	public static Set<Map.Entry<ArrayList<PositionedStack>, PositionedStack>> getTier4RocketBenchRecipes() {
		return NEIExtraPlanetsConfig.t4rocketBenchRecipes.entrySet();
	}

	public void registerTier5RocketBenchRecipe(ArrayList<PositionedStack> input, PositionedStack output) {
		NEIExtraPlanetsConfig.t5rocketBenchRecipes.put(input, output);
	}

	public static Set<Map.Entry<ArrayList<PositionedStack>, PositionedStack>> getTier5RocketBenchRecipes() {
		return NEIExtraPlanetsConfig.t5rocketBenchRecipes.entrySet();
	}

	public void registerTier6RocketBenchRecipe(ArrayList<PositionedStack> input, PositionedStack output) {
		NEIExtraPlanetsConfig.t6rocketBenchRecipes.put(input, output);
	}

	public static Set<Map.Entry<ArrayList<PositionedStack>, PositionedStack>> getTier6RocketBenchRecipes() {
		return NEIExtraPlanetsConfig.t6rocketBenchRecipes.entrySet();
	}

	public void registerTier7RocketBenchRecipe(ArrayList<PositionedStack> input, PositionedStack output) {
		NEIExtraPlanetsConfig.t7rocketBenchRecipes.put(input, output);
	}

	public static Set<Map.Entry<ArrayList<PositionedStack>, PositionedStack>> getTier7RocketBenchRecipes() {
		return NEIExtraPlanetsConfig.t7rocketBenchRecipes.entrySet();
	}

	public void registerTier8RocketBenchRecipe(ArrayList<PositionedStack> input, PositionedStack output) {
		NEIExtraPlanetsConfig.t8rocketBenchRecipes.put(input, output);
	}

	public static Set<Map.Entry<ArrayList<PositionedStack>, PositionedStack>> getTier8RocketBenchRecipes() {
		return NEIExtraPlanetsConfig.t8rocketBenchRecipes.entrySet();
	}

	public void registerTier9RocketBenchRecipe(ArrayList<PositionedStack> input, PositionedStack output) {
		NEIExtraPlanetsConfig.t9rocketBenchRecipes.put(input, output);
	}

	public static Set<Map.Entry<ArrayList<PositionedStack>, PositionedStack>> getTier9RocketBenchRecipes() {
		return NEIExtraPlanetsConfig.t9rocketBenchRecipes.entrySet();
	}

	public void registerTier10RocketBenchRecipe(ArrayList<PositionedStack> input, PositionedStack output) {
		NEIExtraPlanetsConfig.t10rocketBenchRecipes.put(input, output);
	}

	public static Set<Map.Entry<ArrayList<PositionedStack>, PositionedStack>> getTier10RocketBenchRecipes() {
		return NEIExtraPlanetsConfig.t10rocketBenchRecipes.entrySet();
	}

	public void registerCircuitFabricatorRecipe(HashMap<Integer, PositionedStack> input, PositionedStack output) {
		NEIExtraPlanetsConfig.circuitFabricatorRecipes.put(input, output);
	}

	public static Set<Entry<HashMap<Integer, PositionedStack>, PositionedStack>> getCircuitFabricatorRecipes() {
		return NEIExtraPlanetsConfig.circuitFabricatorRecipes.entrySet();
	}
	
	public void registerMarsRoverBenchRecipe(HashMap<Integer, PositionedStack> input, PositionedStack output) {
		NEIExtraPlanetsConfig.marsRoverBenchRecipes.put(input, output);
	}

	public static Set<Entry<HashMap<Integer, PositionedStack>, PositionedStack>> getMarsRoverBenchRecipes() {
		return NEIExtraPlanetsConfig.marsRoverBenchRecipes.entrySet();
	}

	public void registerVenusRoverBenchRecipe(HashMap<Integer, PositionedStack> input, PositionedStack output) {
		NEIExtraPlanetsConfig.venusRoverBenchRecipes.put(input, output);
	}

	public static Set<Entry<HashMap<Integer, PositionedStack>, PositionedStack>> getVenusRoverBenchRecipes() {
		return NEIExtraPlanetsConfig.venusRoverBenchRecipes.entrySet();
	}


	public void registerTier4Recipe() {
		final int changeY = 15;

		ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_NOSE_CONE), 45, -8 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), 36, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), 36, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), 36, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), 36, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), 36, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), 54, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), 54, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), 54, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), 54, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), 54, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 0), 45, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 1), 18, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 1), 72, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 2), 18, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 2), 18, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 2), 72, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 2), 72, 100 + changeY));
		this.registerTier4RocketBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ROCKET, 1, 0), 139, 87 + changeY));

		ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ROCKET, 1, 3), 139, 87 + changeY));
	}

	public void registerTier5Recipe() {
		final int changeY = 15;

		ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_NOSE_CONE), 45, -8 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), 36, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), 36, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), 36, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), 36, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), 36, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), 54, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), 54, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), 54, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), 54, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), 54, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 0), 45, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 1), 18, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 1), 72, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 2), 18, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 2), 18, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 2), 72, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 2), 72, 100 + changeY));
		this.registerTier5RocketBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ROCKET, 1, 0), 139, 87 + changeY));

		ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ROCKET, 1, 3), 139, 87 + changeY));
	}

	public void registerTier6Recipe() {
		final int changeY = 15;

		ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_NOSE_CONE), 45, -8 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), 36, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), 36, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), 36, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), 36, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), 36, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), 54, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), 54, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), 54, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), 54, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), 54, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 0), 45, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 1), 18, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 1), 72, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 2), 18, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 2), 18, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 2), 72, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 2), 72, 100 + changeY));
		this.registerTier6RocketBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ROCKET, 1, 0), 139, 87 + changeY));

		ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_6_ROCKET, 1, 3), 139, 87 + changeY));
	}

	public void registerTier7Recipe() {
		final int changeY = 15;

		ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_NOSE_CONE), 45, -8 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), 36, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), 36, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), 36, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), 36, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), 36, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), 54, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), 54, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), 54, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), 54, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), 54, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 0), 45, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 1), 18, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 1), 72, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 2), 18, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 2), 18, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 2), 72, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 2), 72, 100 + changeY));
		this.registerTier7RocketBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ROCKET, 1, 0), 139, 87 + changeY));

		ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ROCKET, 1, 3), 139, 87 + changeY));
	}

	public void registerTier8Recipe() {
		final int changeY = 15;

		ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_NOSE_CONE), 45, -8 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), 36, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), 36, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), 36, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), 36, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), 36, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), 54, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), 54, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), 54, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), 54, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), 54, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 0), 45, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 1), 18, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 1), 72, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 2), 18, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 2), 18, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 2), 72, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 2), 72, 100 + changeY));
		this.registerTier8RocketBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ROCKET, 1, 0), 139, 87 + changeY));

		ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ROCKET, 1, 3), 139, 87 + changeY));
	}

	public void registerTier9Recipe() {
		final int changeY = 15;

		ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_NOSE_CONE), 45, -8 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), 36, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), 36, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), 36, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), 36, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), 36, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), 54, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), 54, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), 54, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), 54, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), 54, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 0), 45, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 1), 18, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 1), 72, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 2), 18, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 2), 18, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 2), 72, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 2), 72, 100 + changeY));
		this.registerTier9RocketBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ROCKET, 1, 0), 139, 87 + changeY));

		ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_9_ROCKET, 1, 3), 139, 87 + changeY));
	}

	public void registerTier10Recipe() {
		final int changeY = 15;

		ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_NOSE_CONE), 45, -8 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), 36, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), 36, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), 36, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), 36, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), 36, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), 54, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), 54, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), 54, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), 54, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3), 54, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 0), 45, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 1), 18, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 1), 72, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 2), 18, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 2), 18, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 2), 72, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 2), 72, 100 + changeY));
		this.registerTier10RocketBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ROCKET, 1, 0), 139, 87 + changeY));

		ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		this.registerTier10RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		this.registerTier10RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier10RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ROCKET, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		this.registerTier10RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier10RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier10RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ROCKET, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.CHEST), 90 + 52, -15 + changeY));
		this.registerTier10RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_10_ROCKET, 1, 3), 139, 87 + changeY));
	}

	private void addCircuitFabricatorRecipes() {
		HashMap<Integer, PositionedStack> input1 = new HashMap<Integer, PositionedStack>();
		int siliconCount = OreDictionary.getOres(ConfigManagerCore.otherModsSilicon).size();
		ItemStack[] silicons = new ItemStack[siliconCount + 1];
		silicons[0] = new ItemStack(GCItems.basicItem, 1, 2);
		for (int j = 0; j < siliconCount; j++) {
			silicons[j + 1] = OreDictionary.getOres(ConfigManagerCore.otherModsSilicon).get(j);
		}
		input1.put(1, new PositionedStack(silicons, 69, 51));
		input1.put(2, new PositionedStack(silicons, 69, 69));
		input1.put(3, new PositionedStack(new ItemStack(Items.REDSTONE), 117, 51));

		// Diamond
		input1.put(0, new PositionedStack(new ItemStack(Items.DIAMOND), 10, 22));
		input1.put(4, new PositionedStack(new ItemStack(Blocks.REDSTONE_LAMP), 140, 25));
		this.registerCircuitFabricatorRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 0), 147, 91));

		// Carbon
		HashMap<Integer, PositionedStack> input2 = new HashMap<Integer, PositionedStack>(input1);
		if (Config.MERCURY) {
			input2.put(0, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 5), 10, 22));
			input2.put(4, new PositionedStack(new ItemStack(Items.COMPARATOR), 140, 25));
			this.registerCircuitFabricatorRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 1), 147, 91));
		}
		// Titanium
		input2 = new HashMap<Integer, PositionedStack>(input1);
		input2.put(0, new PositionedStack(new ItemStack(AsteroidsItems.basicItem, 1, 5), 10, 22));
		input2.put(4, new PositionedStack(new ItemStack(Blocks.REDSTONE_TORCH), 140, 25));
		this.registerCircuitFabricatorRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 2), 147, 91));

		if (Config.JUPITER) {
			// Red Gem
			input2 = new HashMap<Integer, PositionedStack>(input1);
			input2.put(0, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 8), 10, 22));
			input2.put(4, new PositionedStack(new ItemStack(Items.REPEATER), 140, 25));
			this.registerCircuitFabricatorRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 3), 147, 91));
		}
		if (Config.NEPTUNE) {
			// Blue Gem
			input2 = new HashMap<Integer, PositionedStack>(input1);
			input2.put(0, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 6), 10, 22));
			input2.put(4, new PositionedStack(new ItemStack(Items.REPEATER), 140, 25));
			this.registerCircuitFabricatorRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 4), 147, 91));
		}
		if (Config.URANUS) {
			// White Gem
			input2 = new HashMap<Integer, PositionedStack>(input1);
			input2.put(0, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 7), 10, 22));
			input2.put(4, new PositionedStack(new ItemStack(Items.REPEATER), 140, 25));
			this.registerCircuitFabricatorRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.WAFERS, 3, 5), 147, 91));
		}
	}
	private void addMarsRoverRecipes() {
		HashMap<Integer, PositionedStack> input1 = new HashMap<Integer, PositionedStack>();

		input1 = new HashMap<Integer, PositionedStack>();
		input1.put(0, new PositionedStack(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 3), 18, 18 + 11));
		input1.put(1, new PositionedStack(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 3), 90, 18 + 11));
		input1.put(2, new PositionedStack(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 3), 18, 55 + 10));
		input1.put(3, new PositionedStack(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 3), 90, 55 + 10));
		input1.put(4, new PositionedStack(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 3), 18, 93 + 8));
		input1.put(5, new PositionedStack(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 3), 90, 93 + 8));
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 5; y++) {
				if (x == 2 && y == 1) {
					input1.put(y * 3 + x + 6, new PositionedStack(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 0), 36 + x * 18, 19 + 10 + y * 18));
				} else if (x == 1 && y == 1) {
					input1.put(y * 3 + x + 6, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 1), 36 + x * 18, 19 + 10 + y * 18));
				} else {
					input1.put(y * 3 + x + 6, new PositionedStack(new ItemStack(MarsItems.marsItemBasic, 1, 3), 36 + x * 18, 19 + 10 + y * 18));
				}
			}
		}
		this.registerMarsRoverBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.MARS_ROVER, 1, 0), 139, 101));

		HashMap<Integer, PositionedStack> input2 = new HashMap<Integer, PositionedStack>(input1);
		input2.put(22, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 90, 8));
		this.registerMarsRoverBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.MARS_ROVER, 1, 1), 139, 101));

		input2 = new HashMap<Integer, PositionedStack>(input1);
		input2.put(23, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 116, 8));
		this.registerMarsRoverBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.MARS_ROVER, 1, 1), 139, 101));

		input2 = new HashMap<Integer, PositionedStack>(input1);
		input2.put(24, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 142, 8));
		this.registerMarsRoverBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.MARS_ROVER, 1, 1), 139, 101));

		input2 = new HashMap<Integer, PositionedStack>(input1);
		input2.put(22, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 90, 8));
		input2.put(23, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 116, 8));
		this.registerMarsRoverBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.MARS_ROVER, 1, 2), 139, 101));

		input2 = new HashMap<Integer, PositionedStack>(input1);
		input2.put(23, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 116, 8));
		input2.put(24, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 142, 8));
		this.registerMarsRoverBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.MARS_ROVER, 1, 2), 139, 101));

		input2 = new HashMap<Integer, PositionedStack>(input1);
		input2.put(22, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 90, 8));
		input2.put(24, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 142, 8));
		this.registerMarsRoverBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.MARS_ROVER, 1, 2), 139, 101));

		input2 = new HashMap<Integer, PositionedStack>(input1);
		input2.put(22, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 90, 8));
		input2.put(23, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 116, 8));
		input2.put(24, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 142, 8));
		this.registerMarsRoverBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.MARS_ROVER, 1, 3), 139, 101));
	}

	private void addVenusRoverRecipes() {
		HashMap<Integer, PositionedStack> input1 = new HashMap<Integer, PositionedStack>();

		input1 = new HashMap<Integer, PositionedStack>();
		input1.put(0, new PositionedStack(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 4), 18, 18 + 11));
		input1.put(1, new PositionedStack(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 4), 90, 18 + 11));
		input1.put(2, new PositionedStack(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 1), 18, 55 + 10));
		input1.put(3, new PositionedStack(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 1), 90, 55 + 10));
		input1.put(4, new PositionedStack(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 4), 18, 93 + 8));
		input1.put(5, new PositionedStack(new ItemStack(ExtraPlanets_Items.ELECTRIC_PARTS, 1, 4), 90, 93 + 8));
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 5; y++) {
				if (x == 1 && y == 1) {
					input1.put(y * 3 + x + 6, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 1), 36 + x * 18, 19 + 10 + y * 18));
				} else {
					input1.put(y * 3 + x + 6, new PositionedStack(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), 36 + x * 18, 19 + 10 + y * 18));
				}
			}
		}
		this.registerMarsRoverBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.VENUS_ROVER, 1, 0), 139, 101));

		HashMap<Integer, PositionedStack> input2 = new HashMap<Integer, PositionedStack>(input1);
		input2.put(22, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 90, 8));
		this.registerMarsRoverBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.VENUS_ROVER, 1, 1), 139, 101));

		input2 = new HashMap<Integer, PositionedStack>(input1);
		input2.put(23, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 116, 8));
		this.registerMarsRoverBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.VENUS_ROVER, 1, 1), 139, 101));

		input2 = new HashMap<Integer, PositionedStack>(input1);
		input2.put(24, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 142, 8));
		this.registerMarsRoverBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.VENUS_ROVER, 1, 1), 139, 101));

		input2 = new HashMap<Integer, PositionedStack>(input1);
		input2.put(22, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 90, 8));
		input2.put(23, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 116, 8));
		this.registerMarsRoverBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.VENUS_ROVER, 1, 2), 139, 101));

		input2 = new HashMap<Integer, PositionedStack>(input1);
		input2.put(23, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 116, 8));
		input2.put(24, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 142, 8));
		this.registerMarsRoverBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.VENUS_ROVER, 1, 2), 139, 101));

		input2 = new HashMap<Integer, PositionedStack>(input1);
		input2.put(22, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 90, 8));
		input2.put(24, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 142, 8));
		this.registerMarsRoverBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.VENUS_ROVER, 1, 2), 139, 101));

		input2 = new HashMap<Integer, PositionedStack>(input1);
		input2.put(22, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 90, 8));
		input2.put(23, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 116, 8));
		input2.put(24, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 2), 142, 8));
		this.registerMarsRoverBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.VENUS_ROVER, 1, 3), 139, 101));
	}
}
