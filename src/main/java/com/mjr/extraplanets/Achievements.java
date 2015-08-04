package com.mjr.extraplanets;

import net.minecraft.stats.Achievement;

import com.mjr.extraplanets.blocks.ExtraPlanetsBlocks;

public class Achievements {

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

    public static void init() {
	venusPlanet = new Achievement("achievement.venusPlanet", "venusPlanet", 5, 4, ExtraPlanetsBlocks.venusSurface, (Achievement) null)
	.initIndependentStat().registerStat();

	jupiterPlanet = new Achievement("achievement.jupiterPlanet", "jupiterPlanet", 7, 4, ExtraPlanetsBlocks.jupiterSurface, venusPlanet)
	.initIndependentStat().registerStat();

	saturnPlanet = new Achievement("achievement.saturnPlanet", "saturnPlanet", 9, 4, ExtraPlanetsBlocks.saturnSurface, jupiterPlanet)
	.initIndependentStat().registerStat();

	uranusPlanet = new Achievement("achievement.uranusPlanet", "uranusPlanet", 11, 4, ExtraPlanetsBlocks.uranusSurface, saturnPlanet)
	.initIndependentStat().registerStat();

	neptunePlanet = new Achievement("achievement.neptunePlanet", "neptunePlanet", 13, 4, ExtraPlanetsBlocks.neptuneSurface,
		uranusPlanet).initIndependentStat().registerStat();

	mercuryPlanet = new Achievement("achievement.mercuryPlanet", "mercuryPlanet", 5, 5, ExtraPlanetsBlocks.mercurySurface,
		(Achievement) null).registerStat();

	ceresPlanet = new Achievement("achievement.ceresPlanet", "ceresPlanet", 7, 5, ExtraPlanetsBlocks.ceresSurface, (Achievement) null)
	.initIndependentStat().registerStat();

	plutoPlanet = new Achievement("achievement.plutoPlanet", "plutoPlanet", 9, 5, ExtraPlanetsBlocks.plutoSurface, (Achievement) null)
	.initIndependentStat().registerStat();

	erisPlanet = new Achievement("achievement.erisPlanet", "erisPlanet", 11, 5, ExtraPlanetsBlocks.erisSurface, (Achievement) null)
	.initIndependentStat().registerStat();

	venusBoss = new Achievement("achievement.venusBoss", "venusBoss", 5, 3, ExtraPlanetsBlocks.veunsDungeonBrick, venusPlanet)
	.initIndependentStat().registerStat();

	jupiterBoss = new Achievement("achievement.jupiterBoss", "jupiterBoss", 7, 3, ExtraPlanetsBlocks.jupiterDungeonBrick, jupiterPlanet)
	.initIndependentStat().registerStat();

	saturnBoss = new Achievement("achievement.saturnBoss", "saturnBoss", 9, 3, ExtraPlanetsBlocks.saturnDungeonBrick, saturnPlanet)
	.initIndependentStat().registerStat();

	uranusBoss = new Achievement("achievement.uranusBoss", "uranusBoss", 11, 3, ExtraPlanetsBlocks.uranusDungeonBrick, uranusPlanet)
	.initIndependentStat().registerStat();

	neptuneBoss = new Achievement("achievement.neptuneBoss", "neptuneBoss", 13, 3, ExtraPlanetsBlocks.neptuneDungeonBrick,
		neptunePlanet).initIndependentStat().registerStat();

    }
}
