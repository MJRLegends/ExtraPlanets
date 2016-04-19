package com.mjr.extraplanets.nei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import micdoodle8.mods.galacticraft.core.Constants;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class NEIExtraPlanetsConfig implements IConfigureNEI {
	private static HashMap<ArrayList<PositionedStack>, PositionedStack> t4rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();
	private static HashMap<ArrayList<PositionedStack>, PositionedStack> t5rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();
	private static HashMap<ArrayList<PositionedStack>, PositionedStack> t6rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();
	private static HashMap<ArrayList<PositionedStack>, PositionedStack> t7rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();
	private static HashMap<ArrayList<PositionedStack>, PositionedStack> t8rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();
	private static HashMap<ArrayList<PositionedStack>, PositionedStack> t9rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();

	@Override
	public void loadConfig() {
		if (Config.neiSupport) {
			this.registerTier4Recipe();
			this.registerTier5Recipe();
			this.registerTier6Recipe();
			this.registerTier7Recipe();
			this.registerTier8Recipe();
			this.registerTier9Recipe();

			API.registerRecipeHandler(new RocketT4RecipeHandler());
			API.registerUsageHandler(new RocketT4RecipeHandler());
			API.registerRecipeHandler(new RocketT5RecipeHandler());
			API.registerUsageHandler(new RocketT5RecipeHandler());
			API.registerRecipeHandler(new RocketT6RecipeHandler());
			API.registerUsageHandler(new RocketT6RecipeHandler());
			API.registerRecipeHandler(new RocketT7RecipeHandler());
			API.registerUsageHandler(new RocketT7RecipeHandler());
			API.registerRecipeHandler(new RocketT8RecipeHandler());
			API.registerUsageHandler(new RocketT8RecipeHandler());
			API.registerRecipeHandler(new RocketT9RecipeHandler());
			API.registerUsageHandler(new RocketT9RecipeHandler());
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

	public void registerTier4Recipe() {
		final int changeY = 15;

		ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.noseConeTier4), 45, -8 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 36, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 36, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 36, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 36, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 36, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 54, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 54, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 54, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 54, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 54, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 0), 45, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 1), 18, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 1), 72, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 2), 18, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 2), 18, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 2), 72, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 2), 72, 100 + changeY));
		this.registerTier4RocketBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Rocket, 1, 0), 139, 87 + changeY));

		ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Rocket, 1, 3), 139, 87 + changeY));
	}

	public void registerTier5Recipe() {
		final int changeY = 15;

		ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.noseConeTier5), 45, -8 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 36, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 36, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 36, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 36, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 36, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 54, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 54, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 54, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 54, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 54, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 0), 45, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 1), 18, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 1), 72, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 2), 18, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 2), 18, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 2), 72, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 2), 72, 100 + changeY));
		this.registerTier5RocketBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Rocket, 1, 0), 139, 87 + changeY));

		ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Rocket, 1, 3), 139, 87 + changeY));
	}

	public void registerTier6Recipe() {
		final int changeY = 15;

		ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.noseConeTier6), 45, -8 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 36, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 36, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 36, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 36, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 36, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 54, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 54, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 54, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 54, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 54, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 0), 45, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 1), 18, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 1), 72, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 2), 18, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 2), 18, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 2), 72, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 2), 72, 100 + changeY));
		this.registerTier6RocketBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Rocket, 1, 0), 139, 87 + changeY));

		ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Rocket, 1, 3), 139, 87 + changeY));
	}

	public void registerTier7Recipe() {
		final int changeY = 15;

		ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.noseConeTier7), 45, -8 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 36, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 36, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 36, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 36, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 36, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 54, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 54, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 54, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 54, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 54, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 0), 45, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 1), 18, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 1), 72, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 2), 18, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 2), 18, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 2), 72, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 2), 72, 100 + changeY));
		this.registerTier7RocketBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Rocket, 1, 0), 139, 87 + changeY));

		ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Rocket, 1, 3), 139, 87 + changeY));
	}

	public void registerTier8Recipe() {
		final int changeY = 15;

		ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.noseConeTier8), 45, -8 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 36, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 36, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 36, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 36, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 36, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 54, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 54, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 54, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 54, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 54, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 0), 45, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 1), 18, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 1), 72, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 2), 18, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 2), 18, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 2), 72, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 2), 72, 100 + changeY));
		this.registerTier8RocketBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Rocket, 1, 0), 139, 87 + changeY));

		ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Rocket, 1, 3), 139, 87 + changeY));
	}

	public void registerTier9Recipe() {
		final int changeY = 15;

		ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.noseConeTier9), 45, -8 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 36, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 36, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 36, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 36, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 36, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 54, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 54, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 54, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 54, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 54, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 0), 45, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 1), 18, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 1), 72, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 2), 18, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 2), 18, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 2), 72, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 2), 72, 100 + changeY));
		this.registerTier9RocketBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Rocket, 1, 0), 139, 87 + changeY));

		ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Rocket, 1, 3), 139, 87 + changeY));
	}
}
