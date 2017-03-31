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

	public static Achievement mercuryBoss;

	public static Achievement jupiterPlanet;
	public static Achievement jupiterBoss;

	public static Achievement saturnPlanet;
	public static Achievement saturnBoss;

	public static Achievement uranusPlanet;
	public static Achievement uranusBoss;

	public static Achievement neptunePlanet;
	public static Achievement neptuneBoss;

	public static Achievement plutoPlanet;
	public static Achievement plutoBoss;

	public static Achievement erisPlanet;
	public static Achievement erisBoss;

	public static Achievement mercuryPlanet;
	public static Achievement kepler22bPlanet;
	public static Achievement ceresPlanet;

	public static Achievement craftRocket4;
	public static Achievement craftRocket5;
	public static Achievement craftRocket6;
	public static Achievement craftRocket7;
	public static Achievement craftRocket8;
	public static Achievement craftRocket9;
	public static Achievement craftRocket10;

	public static void init() {
		initAchievements();
		initAchievementPage();
		registerAchievementPage();
		MinecraftForge.EVENT_BUS.register(new AchievementEventHandler());
	}

	private static void initAchievements() {
		// Rocket Achievements
		if (Config.MERCURY)
			craftRocket4 = new Achievement("achievement.craftRocket4", "craftRocket4", 3, 2, ExtraPlanets_Items.TIER_4_ROCKET, (Achievement) null).registerStat();
		if (Config.MERCURY && Config.JUPITER)
			craftRocket5 = new Achievement("achievement.craftRocket5", "craftRocket5", 5, 2, ExtraPlanets_Items.TIER_5_ROCKET, craftRocket4).registerStat();
		else
			craftRocket5 = new Achievement("achievement.craftRocket5", "craftRocket5", 5, 2, ExtraPlanets_Items.TIER_5_ROCKET, (Achievement) null).registerStat();
		if (Config.JUPITER && Config.SATURN)
			craftRocket6 = new Achievement("achievement.craftRocket6", "craftRocket6", 7, 2, ExtraPlanets_Items.TIER_6_ROCKET, craftRocket5).registerStat();
		else
			craftRocket6 = new Achievement("achievement.craftRocket6", "craftRocket6", 7, 2, ExtraPlanets_Items.TIER_6_ROCKET, (Achievement) null).registerStat();
		if (Config.SATURN && Config.URANUS)
			craftRocket7 = new Achievement("achievement.craftRocket7", "craftRocket7", 9, 2, ExtraPlanets_Items.TIER_7_ROCKET, craftRocket6).registerStat();
		else
			craftRocket7 = new Achievement("achievement.craftRocket7", "craftRocket7", 9, 2, ExtraPlanets_Items.TIER_7_ROCKET, (Achievement) null).registerStat();
		if (Config.URANUS && Config.NEPTUNE)
			craftRocket8 = new Achievement("achievement.craftRocket8", "craftRocket8", 11, 2, ExtraPlanets_Items.TIER_8_ROCKET, craftRocket7).registerStat();
		else
			craftRocket8 = new Achievement("achievement.craftRocket8", "craftRocket8", 11, 2, ExtraPlanets_Items.TIER_8_ROCKET, (Achievement) null).registerStat();
		if (Config.NEPTUNE && Config.PLUTO)
			craftRocket9 = new Achievement("achievement.craftRocket9", "craftRocket9", 13, 2, ExtraPlanets_Items.TIER_9_ROCKET, craftRocket8).registerStat();
		else
			craftRocket9 = new Achievement("achievement.craftRocket9", "craftRocket9", 13, 2, ExtraPlanets_Items.TIER_9_ROCKET, (Achievement) null).registerStat();
		if (Config.PLUTO && Config.ERIS)
			craftRocket10 = new Achievement("achievement.craftRocket10", "craftRocket10", 15, 2, ExtraPlanets_Items.TIER_10_ROCKET, craftRocket9).registerStat();
		else
			craftRocket10 = new Achievement("achievement.craftRocket10", "craftRocket10", 15, 2, ExtraPlanets_Items.TIER_10_ROCKET, (Achievement) null).registerStat();

		// Main Planets Achievements
		if (Config.MERCURY)
			mercuryPlanet = new Achievement("achievement.mercuryPlanet", "mercuryPlanet", 3, 4, ExtraPlanets_Blocks.MERCURY_BLOCKS, craftRocket4).registerStat();
		if (Config.JUPITER)
			jupiterPlanet = new Achievement("achievement.jupiterPlanet", "jupiterPlanet", 5, 4, ExtraPlanets_Blocks.JUPITER_BLOCKS, craftRocket5).registerStat();
		if (Config.SATURN)
			saturnPlanet = new Achievement("achievement.saturnPlanet", "saturnPlanet", 7, 4, ExtraPlanets_Blocks.SATURN_BLOCKS, craftRocket6).registerStat();
		if (Config.URANUS)
			uranusPlanet = new Achievement("achievement.uranusPlanet", "uranusPlanet", 9, 4, ExtraPlanets_Blocks.URANUS_BLOCKS, craftRocket7).registerStat();
		if (Config.NEPTUNE)
			neptunePlanet = new Achievement("achievement.neptunePlanet", "neptunePlanet", 11, 4, ExtraPlanets_Blocks.NEPTUNE_BLOCKS, craftRocket8).registerStat();
		if (Config.PLUTO)
			plutoPlanet = new Achievement("achievement.plutoPlanet", "plutoPlanet", 13, 4, ExtraPlanets_Blocks.PLUTO_BLOCKS, craftRocket9).registerStat();
		if (Config.ERIS)
			erisPlanet = new Achievement("achievement.erisPlanet", "erisPlanet", 15, 4, ExtraPlanets_Blocks.ERIS_BLOCKS, craftRocket10).registerStat();
		if (Config.KEPLER22B)
			kepler22bPlanet = new Achievement("achievement.kepler22bPlanet", "kepler22bPlanet", 17, 4, ExtraPlanets_Blocks.KEPLER22B_BLOCKS, craftRocket10).registerStat();

		// Extra Planets Achievements
		if (Config.CERES)
			ceresPlanet = new Achievement("achievement.ceresPlanet", "ceresPlanet", 7, 1, ExtraPlanets_Blocks.CERES_BLOCKS, (Achievement) null).registerStat();

		// Boss Killing Achievements
		if (Config.MERCURY)
			mercuryBoss = new Achievement("achievement.mercuryBoss", "mercuryBoss", 3, 5, new ItemStack(ExtraPlanets_Blocks.MERCURY_BLOCKS, 1, 9), mercuryPlanet).registerStat();
		if (Config.JUPITER)
			jupiterBoss = new Achievement("achievement.jupiterBoss", "jupiterBoss", 5, 5, new ItemStack(ExtraPlanets_Blocks.JUPITER_BLOCKS, 1, 9), jupiterPlanet).registerStat();
		if (Config.SATURN)
			saturnBoss = new Achievement("achievement.saturnBoss", "saturnBoss", 7, 5, new ItemStack(ExtraPlanets_Blocks.SATURN_BLOCKS, 1, 9), saturnPlanet).registerStat();
		if (Config.URANUS)
			uranusBoss = new Achievement("achievement.uranusBoss", "uranusBoss", 9, 5, new ItemStack(ExtraPlanets_Blocks.URANUS_BLOCKS, 1, 6), uranusPlanet).registerStat();
		if (Config.NEPTUNE)
			neptuneBoss = new Achievement("achievement.neptuneBoss", "neptuneBoss", 11, 5, new ItemStack(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 1, 9), neptunePlanet).registerStat();
		if (Config.PLUTO)
			plutoBoss = new Achievement("achievement.plutoBoss", "plutoBoss", 13, 5, new ItemStack(ExtraPlanets_Blocks.PLUTO_BLOCKS, 1, 9), plutoPlanet).registerStat();
		if (Config.ERIS)
			erisBoss = new Achievement("achievement.erisBoss", "erisBoss", 15, 4, new ItemStack(ExtraPlanets_Blocks.ERIS_BLOCKS, 1, 9), erisPlanet).registerStat();
	}

	private static void initAchievementPage() {
		if (mercuryBoss != null)
			achievementslist.add(mercuryBoss);
		if (jupiterPlanet != null)
			achievementslist.add(jupiterPlanet);
		if (jupiterBoss != null)
			achievementslist.add(jupiterBoss);
		if (saturnPlanet != null)
			achievementslist.add(saturnPlanet);
		if (saturnBoss != null)
			achievementslist.add(saturnBoss);
		if (uranusPlanet != null)
			achievementslist.add(uranusPlanet);
		if (uranusBoss != null)
			achievementslist.add(uranusBoss);
		if (neptunePlanet != null)
			achievementslist.add(neptunePlanet);
		if (neptuneBoss != null)
			achievementslist.add(neptuneBoss);
		if (plutoPlanet != null)
			achievementslist.add(plutoPlanet);
		if (plutoBoss != null)
			achievementslist.add(plutoBoss);
		if (erisPlanet != null)
			achievementslist.add(erisPlanet);
		if (erisBoss != null)
			achievementslist.add(erisBoss);
		if (mercuryPlanet != null)
			achievementslist.add(mercuryPlanet);
		if (ceresPlanet != null)
			achievementslist.add(ceresPlanet);
		if (kepler22bPlanet != null)
			achievementslist.add(kepler22bPlanet);
		if (craftRocket4 != null)
			achievementslist.add(craftRocket4);
		if (craftRocket5 != null)
			achievementslist.add(craftRocket5);
		if (craftRocket6 != null)
			achievementslist.add(craftRocket6);
		if (craftRocket7 != null)
			achievementslist.add(craftRocket7);
		if (craftRocket8 != null)
			achievementslist.add(craftRocket8);
		if (craftRocket9 != null)
			achievementslist.add(craftRocket9);
		if (craftRocket10 != null)
			achievementslist.add(craftRocket10);
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
