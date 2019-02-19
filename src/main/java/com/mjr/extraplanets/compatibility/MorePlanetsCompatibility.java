package com.mjr.extraplanets.compatibility;

import java.lang.reflect.Method;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.mjrlegendslib.util.MessageUtilities;

import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import net.minecraft.item.ItemStack;

public class MorePlanetsCompatibility {
	public static void init() {
		registerRocketCrusherRecipes();
	}

	private static void registerRocketCrusherRecipes() {
		try {
			Class<?> clazz = Class.forName("stevekung.mods.moreplanets.util.helper.RecipeHelper");
			if (clazz != null) {
				Method registerMethod = null;
				Method[] methodz = clazz.getMethods();
				for (Method m : methodz) {
					if (m.getName().equals("addRocketCrusherRecipe")) {
						registerMethod = m;
						break;
					}
				}
				for (int i = 0; i < 4; i++) {
					registerMethod.invoke(null, new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 21, 3), new Object[] {"DDD", "PRP", "DDD", 'D', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 4), 'P', new ItemStack(AsteroidsItems.basicItem, 1, 5), 'R',
							new ItemStack(ExtraPlanets_Items.TIER_4_ROCKET, 1, i)});
					registerMethod.invoke(null, new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 21, 3), new Object[] {"DDD", "PRP", "DDD", 'D', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 4), 'P', new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3), 'R',
							new ItemStack(ExtraPlanets_Items.TIER_5_ROCKET, 1, i)});
					registerMethod.invoke(null, new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 21, 3), new Object[] {"DDD", "PRP", "DDD", 'D', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4), 'P', new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3), 'R',
							new ItemStack(ExtraPlanets_Items.TIER_6_ROCKET, 1, i)});
					registerMethod.invoke(null, new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 21, 3), new Object[] {"DDD", "PRP", "DDD", 'D', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 6), 'P', new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3), 'R',
							new ItemStack(ExtraPlanets_Items.TIER_7_ROCKET, 1, i)});
					registerMethod.invoke(null, new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 21, 3), new Object[] {"DDD", "PRP", "DDD", 'D', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 4), 'P', new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3), 'R',
							new ItemStack(ExtraPlanets_Items.TIER_8_ROCKET, 1, i)});
					registerMethod.invoke(null, new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 21, 3), new Object[] {"DDD", "PRP", "DDD", 'D', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 4), 'P', new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3), 'R',
							new ItemStack(ExtraPlanets_Items.TIER_9_ROCKET, 1, i)});
					registerMethod.invoke(null, new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 21, 3), new Object[] {"DDD", "PRP", "DDD", 'D', new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 4), 'P', new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3), 'R',
							new ItemStack(ExtraPlanets_Items.TIER_10_ROCKET, 1, i)});

				}
			}
		} catch (Exception e) {
			MessageUtilities.fatalErrorMessageToLog(Constants.modID, "Error when setting up MorePlanets Compatibility, ErrorMessage: "); 
			e.printStackTrace();
		}
	}
}
