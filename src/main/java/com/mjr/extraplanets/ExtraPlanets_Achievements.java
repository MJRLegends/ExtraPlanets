package com.mjr.extraplanets;

import java.util.ArrayList;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.handlers.AchievementEventHandler;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class ExtraPlanets_Achievements {

	private static ArrayList<Achievement> achievementslist = new ArrayList<Achievement>();

	private static AchievementPage page1;

	public static Achievement venus_planet;
	public static Achievement venus_boss;

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
		if (Config.venus)
			craft_rocket_4 = new Achievement("achievement.craft_rocket_4", "craft_rocket_4", 3, 2, ExtraPlanets_Items.tier4Rocket, (Achievement) null).registerStat();
		if (Config.venus && Config.jupiter)
			craft_rocket_5 = new Achievement("achievement.craft_rocket_5", "craft_rocket_5", 5, 2, ExtraPlanets_Items.tier5Rocket, craft_rocket_4).registerStat();
		else
			craft_rocket_5 = new Achievement("achievement.craft_rocket_5", "craft_rocket_5", 5, 2, ExtraPlanets_Items.tier5Rocket, (Achievement) null).registerStat();
		if (Config.jupiter && Config.saturn)
			craft_rocket_6 = new Achievement("achievement.craft_rocket_6", "craft_rocket_6", 7, 2, ExtraPlanets_Items.tier6Rocket, craft_rocket_5).registerStat();
		else
			craft_rocket_6 = new Achievement("achievement.craft_rocket_6", "craft_rocket_6", 7, 2, ExtraPlanets_Items.tier6Rocket, (Achievement) null).registerStat();
		if (Config.saturn && Config.uranus)
			craft_rocket_7 = new Achievement("achievement.craft_rocket_7", "craft_rocket_7", 9, 2, ExtraPlanets_Items.tier7Rocket, craft_rocket_6).registerStat();
		else
			craft_rocket_7 = new Achievement("achievement.craft_rocket_7", "craft_rocket_7", 9, 2, ExtraPlanets_Items.tier7Rocket, (Achievement) null).registerStat();
		if (Config.uranus && Config.neptune)
			craft_rocket_8 = new Achievement("achievement.craft_rocket_8", "craft_rocket_8", 11, 2, ExtraPlanets_Items.tier8Rocket, craft_rocket_7).registerStat();
		else
			craft_rocket_8 = new Achievement("achievement.craft_rocket_8", "craft_rocket_8", 11, 2, ExtraPlanets_Items.tier8Rocket, (Achievement) null).registerStat();
		if (Config.neptune && Config.pluto)
			craft_rocket_9 = new Achievement("achievement.craft_rocket_9", "craft_rocket_9", 13, 2, ExtraPlanets_Items.tier9Rocket, craft_rocket_8).registerStat();
		else
			craft_rocket_9 = new Achievement("achievement.craft_rocket_9", "craft_rocket_9", 13, 2, ExtraPlanets_Items.tier9Rocket, (Achievement) null).registerStat();
		if (Config.pluto && Config.eris)
			craft_rocket_10 = new Achievement("achievement.craft_rocket_10", "craft_rocket_10", 15, 2, ExtraPlanets_Items.tier10Rocket, craft_rocket_9).registerStat();
		else
			craft_rocket_10 = new Achievement("achievement.craft_rocket_10", "craft_rocket_10", 15, 2, ExtraPlanets_Items.tier10Rocket, (Achievement) null).registerStat();

		// Main Planets Achievements
		if (Config.venus)
			venus_planet = new Achievement("achievement.venus_planet", "venus_planet", 3, 4, ExtraPlanets_Blocks.venusBlocks, craft_rocket_4).registerStat();
		if (Config.jupiter)
			jupiter_planet = new Achievement("achievement.jupiter_planet", "jupiter_planet", 5, 4, ExtraPlanets_Blocks.jupiterBlocks, craft_rocket_5).registerStat();
		if (Config.saturn)
			saturn_planet = new Achievement("achievement.saturn_planet", "saturn_planet", 7, 4, ExtraPlanets_Blocks.saturnBlocks, craft_rocket_6).registerStat();
		if (Config.uranus)
			uranus_planet = new Achievement("achievement.uranus_planet", "uranus_planet", 9, 4, ExtraPlanets_Blocks.uranusBlocks, craft_rocket_7).registerStat();
		if (Config.neptune)
			neptune_planet = new Achievement("achievement.neptune_planet", "neptune_planet", 11, 4, ExtraPlanets_Blocks.neptuneBlocks, craft_rocket_8).registerStat();
		if (Config.pluto)
			pluto_planet = new Achievement("achievement.pluto_planet", "pluto_planet", 13, 4, ExtraPlanets_Blocks.plutoBlocks, craft_rocket_9).registerStat();
		if (Config.eris)
			eris_planet = new Achievement("achievement.eris_planet", "eris_planet", 15, 4, ExtraPlanets_Blocks.erisBlocks, craft_rocket_10).registerStat();
		if (Config.kepler22b && Config.keplerSolarSystems)
			kepler22b_planet = new Achievement("achievement.kepler22b_planet", "kepler22b_planet", 17, 4, ExtraPlanets_Blocks.kepler22bBlocks, craft_rocket_10).registerStat();

		// ExtraPlanets Achievements
		if (Config.mercury)
			mercury_planet = new Achievement("achievement.mercury_planet", "mercury_planet", 5, 1, ExtraPlanets_Blocks.mercuryBlocks, (Achievement) null).registerStat();
		if (Config.ceres)
			ceres_planet = new Achievement("achievement.ceres_planet", "ceres_planet", 7, 1, ExtraPlanets_Blocks.ceresBlocks, (Achievement) null).registerStat();

		//Boss Killing Achievements
		if (Config.venus)
			venus_boss = new Achievement("achievement.venus_boss", "venus_boss", 3, 5, ExtraPlanets_Blocks.veunsDungeonBrick, venus_planet).registerStat();
		if (Config.jupiter)
			jupiter_boss = new Achievement("achievement.jupiter_boss", "jupiter_boss", 5, 5, ExtraPlanets_Blocks.jupiterDungeonBrick, jupiter_planet).registerStat();
		if (Config.saturn)
			saturn_boss = new Achievement("achievement.saturn_boss", "saturn_boss", 7, 5, ExtraPlanets_Blocks.saturnDungeonBrick, saturn_planet).registerStat();
		if (Config.uranus)
			uranus_boss = new Achievement("achievement.uranus_boss", "uranus_boss", 9, 5, ExtraPlanets_Blocks.uranusDungeonBrick, uranus_planet).registerStat();
		if (Config.neptune)
			neptune_boss = new Achievement("achievement.neptune_boss", "neptune_boss", 11, 5, ExtraPlanets_Blocks.neptuneDungeonBrick, neptune_planet).registerStat();
		if (Config.pluto)
			pluto_boss = new Achievement("achievement.pluto_boss", "pluto_boss", 13, 5, ExtraPlanets_Blocks.plutoDungeonBrick, pluto_planet).registerStat();
		if (Config.eris)
			eris_boss = new Achievement("achievement.eris_boss", "eris_boss", 15, 4, ExtraPlanets_Blocks.erisDungeonBrick, eris_planet).registerStat();
	}

	private static void initAchievementPage() {
		if (venus_planet != null)
			achievementslist.add(venus_planet);
		if (venus_boss != null)
			achievementslist.add(venus_boss);
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
