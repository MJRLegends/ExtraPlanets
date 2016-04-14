package com.mjr.extraplanets;

import java.util.ArrayList;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.handlers.AchievementEventHandler;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class ExtraPlanets_Achievements {

	private static ArrayList<Achievement> achievementslist = new ArrayList();

	private static AchievementPage page1;

	public static Achievement venusPlanet;
	public static Achievement venusBoss;

	public static Achievement jupiterPlanet;
	public static Achievement jupiterBoss;

	public static Achievement saturnPlanet;
	public static Achievement saturnBoss;

	public static Achievement uranusPlanet;
	public static Achievement uranusBoss;

	public static Achievement neptunePlanet;
	public static Achievement neptuneBoss;

	public static Achievement mercuryPlanet;

	public static Achievement ceresPlanet;

	public static Achievement plutoPlanet;

	public static Achievement erisPlanet;

	public static Achievement craftRocket4;
	public static Achievement craftRocket5;
	public static Achievement craftRocket6;
	public static Achievement craftRocket7;
	public static Achievement craftRocket8;
	public static Achievement craftRocket9;

	public static void init() {
		initAchievements();
		initAchievementPage();
		registerAchievementPage();
		MinecraftForge.EVENT_BUS.register(new AchievementEventHandler());
	}

	private static void initAchievements() {
		// Planet Achievements
		if (Config.venus)
			venusPlanet = new Achievement("achievement.venusPlanet", "venusPlanet", 5, 4, ExtraPlanets_Blocks.venusBlocks, (Achievement) null)
					.initIndependentStat().registerStat();
		if (Config.jupiter && Config.venus)
			jupiterPlanet = new Achievement("achievement.jupiterPlanet", "jupiterPlanet", 7, 4, ExtraPlanets_Blocks.jupiterBlocks, venusPlanet).registerStat();
		else if (Config.jupiter && !Config.venus)
			jupiterPlanet = new Achievement("achievement.jupiterPlanet", "jupiterPlanet", 7, 4, ExtraPlanets_Blocks.jupiterBlocks, (Achievement) null)
					.initIndependentStat().registerStat();
		if (Config.saturn && Config.jupiter)
			saturnPlanet = new Achievement("achievement.saturnPlanet", "saturnPlanet", 9, 4, ExtraPlanets_Blocks.saturnBlocks, jupiterPlanet).registerStat();
		else if (Config.saturn && !Config.jupiter)
			saturnPlanet = new Achievement("achievement.saturnPlanet", "saturnPlanet", 9, 4, ExtraPlanets_Blocks.saturnBlocks, (Achievement) null)
					.initIndependentStat().registerStat();
		if (Config.uranus && Config.saturn)
			uranusPlanet = new Achievement("achievement.uranusPlanet", "uranusPlanet", 11, 4, ExtraPlanets_Blocks.uranusBlocks, saturnPlanet).registerStat();
		else if (Config.uranus && !Config.saturn)
			uranusPlanet = new Achievement("achievement.uranusPlanet", "uranusPlanet", 11, 4, ExtraPlanets_Blocks.uranusBlocks, (Achievement) null)
					.initIndependentStat().registerStat();
		if (Config.neptune && Config.uranus)
			neptunePlanet = new Achievement("achievement.neptunePlanet", "neptunePlanet", 13, 4, ExtraPlanets_Blocks.neptuneBlocks, uranusPlanet)
					.registerStat();
		else if (Config.neptune && !Config.uranus)
			neptunePlanet = new Achievement("achievement.neptunePlanet", "neptunePlanet", 13, 4, ExtraPlanets_Blocks.neptuneBlocks, (Achievement) null)
					.initIndependentStat().registerStat();
		if (Config.mercury)
			mercuryPlanet = new Achievement("achievement.mercuryPlanet", "mercuryPlanet", 5, 5, ExtraPlanets_Blocks.mercuryBlocks, (Achievement) null)
					.registerStat();
		if (Config.ceres)
			ceresPlanet = new Achievement("achievement.ceresPlanet", "ceresPlanet", 7, 5, ExtraPlanets_Blocks.ceresBlocks, (Achievement) null)
					.initIndependentStat().registerStat();
		if (Config.pluto)
			plutoPlanet = new Achievement("achievement.plutoPlanet", "plutoPlanet", 9, 5, ExtraPlanets_Blocks.plutoBlocks, (Achievement) null)
					.initIndependentStat().registerStat();
		if (Config.eris)
			erisPlanet = new Achievement("achievement.erisPlanet", "erisPlanet", 11, 5, ExtraPlanets_Blocks.erisBlocks, (Achievement) null)
					.initIndependentStat().registerStat();

		// Boss Killing Achievements
		if (Config.venus)
			venusBoss = new Achievement("achievement.venusBoss", "venusBoss", 5, 3, ExtraPlanets_Blocks.veunsDungeonBrick, venusPlanet).registerStat();
		if (Config.jupiter)
			jupiterBoss = new Achievement("achievement.jupiterBoss", "jupiterBoss", 7, 3, ExtraPlanets_Blocks.jupiterDungeonBrick, jupiterPlanet)
					.registerStat();
		if (Config.saturn)
			saturnBoss = new Achievement("achievement.saturnBoss", "saturnBoss", 9, 3, ExtraPlanets_Blocks.saturnDungeonBrick, saturnPlanet).registerStat();
		if (Config.uranus)
			uranusBoss = new Achievement("achievement.uranusBoss", "uranusBoss", 11, 3, ExtraPlanets_Blocks.uranusDungeonBrick, uranusPlanet).registerStat();
		if (Config.neptune)
			neptuneBoss = new Achievement("achievement.neptuneBoss", "neptuneBoss", 13, 3, ExtraPlanets_Blocks.neptuneDungeonBrick, neptunePlanet)
					.registerStat();

		// Rocket Achievements
		if (Config.venus)
			craftRocket4 = new Achievement("achievement.craftRocket1", "craftRocket1", 3, 5, ExtraPlanets_Items.tier4Rocket, (Achievement) null).registerStat();
		if (Config.venus && Config.jupiter)
			craftRocket5 = new Achievement("achievement.craftRocket5", "craftRocket5", 5, 5, ExtraPlanets_Items.tier5Rocket, craftRocket4).registerStat();
		else
			craftRocket5 = new Achievement("achievement.craftRocket5", "craftRocket5", 5, 5, ExtraPlanets_Items.tier5Rocket, (Achievement) null).registerStat();
		if (Config.jupiter && Config.saturn)
			craftRocket6 = new Achievement("achievement.craftRocket6", "craftRocket6", 7, 5, ExtraPlanets_Items.tier6Rocket, craftRocket5).registerStat();
		else
			craftRocket6 = new Achievement("achievement.craftRocket6", "craftRocket6", 7, 5, ExtraPlanets_Items.tier6Rocket, (Achievement) null).registerStat();
		if (Config.saturn && Config.uranus)
			craftRocket7 = new Achievement("achievement.craftRocket7", "craftRocket7", 9, 5, ExtraPlanets_Items.tier7Rocket, craftRocket6).registerStat();
		else
			craftRocket7 = new Achievement("achievement.craftRocket7", "craftRocket7", 9, 5, ExtraPlanets_Items.tier7Rocket, (Achievement) null).registerStat();
		if (Config.uranus && Config.neptune)
			craftRocket8 = new Achievement("achievement.craftRocket8", "craftRocket8", 11, 5, ExtraPlanets_Items.tier8Rocket, craftRocket7).registerStat();
		else
			craftRocket8 = new Achievement("achievement.craftRocket8", "craftRocket8", 11, 5, ExtraPlanets_Items.tier8Rocket, (Achievement) null)
					.registerStat();
		if (Config.neptune && Config.pluto)
			craftRocket9 = new Achievement("achievement.craftRocket9", "craftRocket9", 13, 5, ExtraPlanets_Items.tier9Rocket, craftRocket8).registerStat();
		else
			craftRocket9 = new Achievement("achievement.craftRocket9", "craftRocket9", 13, 5, ExtraPlanets_Items.tier9Rocket, (Achievement) null)
					.registerStat();
	}

	private static void initAchievementPage() {
		if (venusPlanet != null)
			achievementslist.add(venusPlanet);
		if (venusBoss != null)
			achievementslist.add(venusBoss);
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
		if (mercuryPlanet != null)
			achievementslist.add(mercuryPlanet);
		if (ceresPlanet != null)
			achievementslist.add(ceresPlanet);
		if (plutoPlanet != null)
			achievementslist.add(plutoPlanet);
		if (erisPlanet != null)
			achievementslist.add(erisPlanet);
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
		if (achievementslist.size() > 0) {
			// Setup/Register Achievement Page with Achievements
			page1 = new AchievementPage("ExtraPlanets", (Achievement[]) achievementslist.toArray(new Achievement[achievementslist.size()]));
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
