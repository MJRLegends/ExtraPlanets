package com.mjr.extraplanets;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.handlers.AchievementEventHandler;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class ExtraPlanets_Achievements {

	private static ArrayList<Achievement> achievementslist = new ArrayList<Achievement>();

	private static AchievementPage page1;

	public static Achievement mercury_boss;

	public static Achievement jupiter_planet;
	public static Achievement jupiter_boss;

	public static Achievement saturn_planet;
	public static Achievement saturn_boss;

	public static Achievement uranus_planet;
	public static Achievement uranus_boss;

	public static Achievement neptune_planet;
	public static Achievement neptune_boss;

	public static Achievement pluto_planet;
	public static Achievement pluto_boss;

	public static Achievement eris_planet;
	public static Achievement eris_boss;

	public static Achievement mercury_planet;
	public static Achievement kepler22b_planet;
	public static Achievement ceres_planet;

	public static Achievement craft_rocket_4;
	public static Achievement craft_rocket_5;
	public static Achievement craft_rocket_6;
	public static Achievement craft_rocket_7;
	public static Achievement craft_rocket_8;
	public static Achievement craft_rocket_9;
	public static Achievement craft_rocket_10;

	public static void init() {
		initAchievements();
		initAchievementPage();
		registerAchievementPage();
		MinecraftForge.EVENT_BUS.register(new AchievementEventHandler());
	}

	private static void initAchievements() {
		// Rocket Achievements
		if (Config.MERCURY)
			craft_rocket_4 = new Achievement("achievement.craft_rocket_4", "craft_rocket_4", 3, 2, ExtraPlanets_Items.TIER_4_ROCKET, (Achievement) null).registerStat();
		if (Config.MERCURY && Config.JUPITER)
			craft_rocket_5 = new Achievement("achievement.craft_rocket_5", "craft_rocket_5", 5, 2, ExtraPlanets_Items.TIER_5_ROCKET, craft_rocket_4).registerStat();
		else
			craft_rocket_5 = new Achievement("achievement.craft_rocket_5", "craft_rocket_5", 5, 2, ExtraPlanets_Items.TIER_5_ROCKET, (Achievement) null).registerStat();
		if (Config.JUPITER && Config.SATURN)
			craft_rocket_6 = new Achievement("achievement.craft_rocket_6", "craft_rocket_6", 7, 2, ExtraPlanets_Items.TIER_6_ROCKET, craft_rocket_5).registerStat();
		else
			craft_rocket_6 = new Achievement("achievement.craft_rocket_6", "craft_rocket_6", 7, 2, ExtraPlanets_Items.TIER_6_ROCKET, (Achievement) null).registerStat();
		if (Config.SATURN && Config.URANUS)
			craft_rocket_7 = new Achievement("achievement.craft_rocket_7", "craft_rocket_7", 9, 2, ExtraPlanets_Items.TIER_7_ROCKET, craft_rocket_6).registerStat();
		else
			craft_rocket_7 = new Achievement("achievement.craft_rocket_7", "craft_rocket_7", 9, 2, ExtraPlanets_Items.TIER_7_ROCKET, (Achievement) null).registerStat();
		if (Config.URANUS && Config.NEPTUNE)
			craft_rocket_8 = new Achievement("achievement.craft_rocket_8", "craft_rocket_8", 11, 2, ExtraPlanets_Items.TIER_8_ROCKET, craft_rocket_7).registerStat();
		else
			craft_rocket_8 = new Achievement("achievement.craft_rocket_8", "craft_rocket_8", 11, 2, ExtraPlanets_Items.TIER_8_ROCKET, (Achievement) null).registerStat();
		if (Config.NEPTUNE && Config.PLUTO)
			craft_rocket_9 = new Achievement("achievement.craft_rocket_9", "craft_rocket_9", 13, 2, ExtraPlanets_Items.TIER_9_ROCKET, craft_rocket_8).registerStat();
		else
			craft_rocket_9 = new Achievement("achievement.craft_rocket_9", "craft_rocket_9", 13, 2, ExtraPlanets_Items.TIER_9_ROCKET, (Achievement) null).registerStat();
		if (Config.PLUTO && Config.ERIS)
			craft_rocket_10 = new Achievement("achievement.craft_rocket_10", "craft_rocket_10", 15, 2, ExtraPlanets_Items.TIER_10_ROCKET, craft_rocket_9).registerStat();
		else
			craft_rocket_10 = new Achievement("achievement.craft_rocket_10", "craft_rocket_10", 15, 2, ExtraPlanets_Items.TIER_10_ROCKET, (Achievement) null).registerStat();

		// Main _planets Achievements
		if (Config.MERCURY)
			mercury_planet = new Achievement("achievement.mercury_planet", "mercury_planet", 3, 4, ExtraPlanets_Blocks.MERCURY_BLOCKS, craft_rocket_4).registerStat();
		if (Config.JUPITER)
			jupiter_planet = new Achievement("achievement.jupiter_planet", "jupiter_planet", 5, 4, ExtraPlanets_Blocks.JUPITER_BLOCKS, craft_rocket_5).registerStat();
		if (Config.SATURN)
			saturn_planet = new Achievement("achievement.saturn_planet", "saturn_planet", 7, 4, ExtraPlanets_Blocks.SATURN_BLOCKS, craft_rocket_6).registerStat();
		if (Config.URANUS)
			uranus_planet = new Achievement("achievement.uranus_planet", "uranus_planet", 9, 4, ExtraPlanets_Blocks.URANUS_BLOCKS, craft_rocket_7).registerStat();
		if (Config.NEPTUNE)
			neptune_planet = new Achievement("achievement.neptune_planet", "neptune_planet", 11, 4, ExtraPlanets_Blocks.NEPTUNE_BLOCKS, craft_rocket_8).registerStat();
		if (Config.PLUTO)
			pluto_planet = new Achievement("achievement.pluto_planet", "pluto_planet", 13, 4, ExtraPlanets_Blocks.PLUTO_BLOCKS, craft_rocket_9).registerStat();
		if (Config.ERIS)
			eris_planet = new Achievement("achievement.eris_planet", "eris_planet", 15, 4, ExtraPlanets_Blocks.ERIS_BLOCKS, craft_rocket_10).registerStat();
		if (Config.KEPLER22B)
			kepler22b_planet = new Achievement("achievement.kepler22b_planet", "kepler22b_planet", 17, 4, ExtraPlanets_Blocks.KEPLER22B_BLOCKS, craft_rocket_10).registerStat();

		// Extra _planets Achievements
		if (Config.CERES)
			ceres_planet = new Achievement("achievement.ceres_planet", "ceres_planet", 7, 1, ExtraPlanets_Blocks.CERES_BLOCKS, (Achievement) null).registerStat();

		// _boss Killing Achievements
		if (Config.MERCURY)
			mercury_boss = new Achievement("achievement.mercury_boss", "mercury_boss", 3, 5, new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 9), mercury_planet).registerStat();
		if (Config.JUPITER)
			jupiter_boss = new Achievement("achievement.jupiter_boss", "jupiter_boss", 5, 5, new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 9), jupiter_planet).registerStat();
		if (Config.SATURN)
			saturn_boss = new Achievement("achievement.saturn_boss", "saturn_boss", 7, 5, new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 9), saturn_planet).registerStat();
		if (Config.URANUS)
			uranus_boss = new Achievement("achievement.uranus_boss", "uranus_boss", 9, 5, new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 6), uranus_planet).registerStat();
		if (Config.NEPTUNE)
			neptune_boss = new Achievement("achievement.neptune_boss", "neptune_boss", 11, 5, new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 9), neptune_planet).registerStat();
		if (Config.PLUTO)
			pluto_boss = new Achievement("achievement.pluto_boss", "pluto_boss", 13, 5, new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 9), pluto_planet).registerStat();
		if (Config.ERIS)
			eris_boss = new Achievement("achievement.eris_boss", "eris_boss", 15, 4, new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 9), eris_planet).registerStat();
	}

	private static void initAchievementPage() {
		if (mercury_boss != null)
			achievementslist.add(mercury_boss);
		if (jupiter_planet != null)
			achievementslist.add(jupiter_planet);
		if (jupiter_boss != null)
			achievementslist.add(jupiter_boss);
		if (saturn_planet != null)
			achievementslist.add(saturn_planet);
		if (saturn_boss != null)
			achievementslist.add(saturn_boss);
		if (uranus_planet != null)
			achievementslist.add(uranus_planet);
		if (uranus_boss != null)
			achievementslist.add(uranus_boss);
		if (neptune_planet != null)
			achievementslist.add(neptune_planet);
		if (neptune_boss != null)
			achievementslist.add(neptune_boss);
		if (pluto_planet != null)
			achievementslist.add(pluto_planet);
		if (pluto_boss != null)
			achievementslist.add(pluto_boss);
		if (eris_planet != null)
			achievementslist.add(eris_planet);
		if (eris_boss != null)
			achievementslist.add(eris_boss);
		if (mercury_planet != null)
			achievementslist.add(mercury_planet);
		if (ceres_planet != null)
			achievementslist.add(ceres_planet);
		if (kepler22b_planet != null)
			achievementslist.add(kepler22b_planet);
		if (craft_rocket_4 != null)
			achievementslist.add(craft_rocket_4);
		if (craft_rocket_5 != null)
			achievementslist.add(craft_rocket_5);
		if (craft_rocket_6 != null)
			achievementslist.add(craft_rocket_6);
		if (craft_rocket_7 != null)
			achievementslist.add(craft_rocket_7);
		if (craft_rocket_8 != null)
			achievementslist.add(craft_rocket_8);
		if (craft_rocket_9 != null)
			achievementslist.add(craft_rocket_9);
		if (craft_rocket_10 != null)
			achievementslist.add(craft_rocket_10);
		if (achievementslist.size() > 0) {
			// Setup/Register Achievement Page with Achievements
			page1 = new AchievementPage("ExtraPlanets", achievementslist.toArray(new Achievement[achievementslist.size()]));
		}
	}

	private static void registerAchievementPage() {
		AchievementPage.registerAchievementPage(page1);
		achievementslist.clear();
	}

	public static AchievementPage getAchievementPage() {
		return page1;
	}
}
