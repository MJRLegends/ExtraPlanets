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

    public static Achievement deimosMoon;
    public static Achievement europaMoon;
    public static Achievement ioMoon;
    public static Achievement phobosMoon;
    public static Achievement tritonMoon;

    public static void init() {
	if (Config.venus)
	    venusPlanet = new Achievement("achievement.venusPlanet", "venusPlanet", 5, 4, ExtraPlanetsBlocks.venusSurface,
		    (Achievement) null).initIndependentStat().registerStat();
	if (Config.jupiter && Config.venus)
	    jupiterPlanet = new Achievement("achievement.jupiterPlanet", "jupiterPlanet", 7, 4, ExtraPlanetsBlocks.jupiterSurface,
		    venusPlanet).registerStat();
	else if (Config.jupiter && !Config.venus)
	    jupiterPlanet = new Achievement("achievement.jupiterPlanet", "jupiterPlanet", 7, 4, ExtraPlanetsBlocks.jupiterSurface,
		    (Achievement) null).initIndependentStat().registerStat();
	if (Config.saturn && Config.jupiter)
	    saturnPlanet = new Achievement("achievement.saturnPlanet", "saturnPlanet", 9, 4, ExtraPlanetsBlocks.saturnSurface,
		    jupiterPlanet).registerStat();
	else if (Config.saturn && !Config.jupiter)
	    saturnPlanet = new Achievement("achievement.saturnPlanet", "saturnPlanet", 9, 4, ExtraPlanetsBlocks.saturnSurface,
		    (Achievement) null).initIndependentStat().registerStat();
	if (Config.uranus && Config.saturn)
	    uranusPlanet = new Achievement("achievement.uranusPlanet", "uranusPlanet", 11, 4, ExtraPlanetsBlocks.uranusSurface,
		    saturnPlanet).registerStat();
	else if (Config.uranus && !Config.saturn)
	    uranusPlanet = new Achievement("achievement.uranusPlanet", "uranusPlanet", 11, 4, ExtraPlanetsBlocks.uranusSurface,
		    (Achievement) null).initIndependentStat().registerStat();
	if (Config.neptune && Config.uranus)
	    neptunePlanet = new Achievement("achievement.neptunePlanet", "neptunePlanet", 13, 4, ExtraPlanetsBlocks.neptuneSurface,
		    uranusPlanet).registerStat();
	else if (Config.neptune && !Config.uranus)
	    neptunePlanet = new Achievement("achievement.neptunePlanet", "neptunePlanet", 13, 4, ExtraPlanetsBlocks.neptuneSurface,
		    (Achievement) null).initIndependentStat().registerStat();

	if (Config.mercury)
	    mercuryPlanet = new Achievement("achievement.mercuryPlanet", "mercuryPlanet", 5, 5, ExtraPlanetsBlocks.mercurySurface,
		    (Achievement) null).registerStat();

	if (Config.ceres)
	    ceresPlanet = new Achievement("achievement.ceresPlanet", "ceresPlanet", 7, 5, ExtraPlanetsBlocks.ceresSurface,
		    (Achievement) null).initIndependentStat().registerStat();

	if (Config.pluto)
	    plutoPlanet = new Achievement("achievement.plutoPlanet", "plutoPlanet", 9, 5, ExtraPlanetsBlocks.plutoSurface,
		    (Achievement) null).initIndependentStat().registerStat();

	if (Config.eris)
	    erisPlanet = new Achievement("achievement.erisPlanet", "erisPlanet", 11, 5, ExtraPlanetsBlocks.erisSurface, (Achievement) null)
		    .initIndependentStat().registerStat();

	if (Config.venus)
	    venusBoss = new Achievement("achievement.venusBoss", "venusBoss", 5, 3, ExtraPlanetsBlocks.veunsDungeonBrick, venusPlanet)
		    .registerStat();

	if (Config.jupiter)
	    jupiterBoss = new Achievement("achievement.jupiterBoss", "jupiterBoss", 7, 3, ExtraPlanetsBlocks.jupiterDungeonBrick,
		    jupiterPlanet).registerStat();

	if (Config.saturn)
	    saturnBoss = new Achievement("achievement.saturnBoss", "saturnBoss", 9, 3, ExtraPlanetsBlocks.saturnDungeonBrick, saturnPlanet)
		    .registerStat();

	if (Config.uranus)
	    uranusBoss = new Achievement("achievement.uranusBoss", "uranusBoss", 11, 3, ExtraPlanetsBlocks.uranusDungeonBrick, uranusPlanet)
		    .registerStat();

	if (Config.neptune)
	    neptuneBoss = new Achievement("achievement.neptuneBoss", "neptuneBoss", 13, 3, ExtraPlanetsBlocks.neptuneDungeonBrick,
		    neptunePlanet).registerStat();

	if (Config.deimos)
	    deimosMoon = new Achievement("achievement.deimosMoon", "deimosMoon", 13, 5, ExtraPlanetsBlocks.deimosSurface,
		    (Achievement) null).initIndependentStat().registerStat();
	if (Config.europa)
	    europaMoon = new Achievement("achievement.europaMoon", "europaMoon", 15, 5, ExtraPlanetsBlocks.europaSurface,
		    (Achievement) null).initIndependentStat().registerStat();
	if (Config.io)
	    ioMoon = new Achievement("achievement.ioMoon", "ioMoon", 13, 3, ExtraPlanetsBlocks.ioSurface, (Achievement) null)
		    .initIndependentStat().registerStat();
	if (Config.phobos)
	    phobosMoon = new Achievement("achievement.phobosMoon", "phobosMoon", 5, 6, ExtraPlanetsBlocks.phobosSurface, (Achievement) null)
		    .initIndependentStat().registerStat();
	if (Config.triton)
	    tritonMoon = new Achievement("achievement.tritonMoon", "tritonMoon", 7, 6, ExtraPlanetsBlocks.tritonSurface, (Achievement) null)
		    .initIndependentStat().registerStat();
    }
}
