package com.mjr.extraplanets.planets;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.world.AtmosphereInfo;
import micdoodle8.mods.galacticraft.api.world.EnumAtmosphericGas;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedEnderman;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome.SpawnListEntry;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets_SolarSystems;
import com.mjr.extraplanets.planets.Ceres.TeleportTypeCeres;
import com.mjr.extraplanets.planets.Ceres.WorldProviderCeres;
import com.mjr.extraplanets.planets.Ceres.worldgen.CeresBiomes;
import com.mjr.extraplanets.planets.Eris.TeleportTypeEris;
import com.mjr.extraplanets.planets.Eris.WorldProviderEris;
import com.mjr.extraplanets.planets.Eris.worldgen.ErisBiomes;
import com.mjr.extraplanets.planets.Jupiter.TeleportTypeJupiter;
import com.mjr.extraplanets.planets.Jupiter.WorldProviderJupiter;
import com.mjr.extraplanets.planets.Jupiter.worldgen.JupiterBiomes;
import com.mjr.extraplanets.planets.Kepler22b.TeleportTypeKepler22b;
import com.mjr.extraplanets.planets.Kepler22b.WorldProviderKepler22b;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.Kepler22bBiomes;
import com.mjr.extraplanets.planets.Mercury.TeleportTypeMercury;
import com.mjr.extraplanets.planets.Mercury.WorldProviderMercury;
import com.mjr.extraplanets.planets.Mercury.worldgen.MercuryBiomes;
import com.mjr.extraplanets.planets.Neptune.TeleportTypeNeptune;
import com.mjr.extraplanets.planets.Neptune.WorldProviderNeptune;
import com.mjr.extraplanets.planets.Neptune.worldgen.NeptuneBiomes;
import com.mjr.extraplanets.planets.Pluto.TeleportTypePluto;
import com.mjr.extraplanets.planets.Pluto.WorldProviderPluto;
import com.mjr.extraplanets.planets.Pluto.worldgen.PlutoBiomes;
import com.mjr.extraplanets.planets.Saturn.TeleportTypeSaturn;
import com.mjr.extraplanets.planets.Saturn.WorldProviderSaturn;
import com.mjr.extraplanets.planets.Saturn.worldgen.SaturnBiomes;
import com.mjr.extraplanets.planets.Uranus.TeleportTypeUranus;
import com.mjr.extraplanets.planets.Uranus.WorldProviderUranus;
import com.mjr.extraplanets.planets.Uranus.worldgen.UranusBiomes;
import com.mjr.extraplanets.util.GCRegisterUtilities;

public class ExtraPlanets_Planets {
	public static Planet MERCURY;
	public static Planet CERES;
	public static Planet JUPITER;
	public static Planet SATURN;
	public static Planet URANUS;
	public static Planet NEPTUNE;
	public static Planet PLUTO;
	public static Planet HAUNEA;
	public static Planet ERIS;
	public static Planet KUIPER_BELT;
	public static Planet MAKEMAKE;

	public static Planet KEPLER22B;

	public static Planet KEPLER47B;
	public static Planet KEPLER47C;

	public static Planet KEPLER62B;
	public static Planet KEPLER62C;
	public static Planet KEPLER62D;
	public static Planet KEPLER62E;
	public static Planet KEPLER62F;

	public static Planet KEPLER69B;
	public static Planet KEPLER69C;

	public static Planet TATOOINE;
	public static Planet CRAIT;
	public static Planet HOTH;
	public static Planet AQUA;

	public static Planet QUSTROITHEA;
	public static Planet JETRARUTA;
	public static Planet MOSWION;
	public static Planet KETHERTH;
	public static Planet XOVIS;

	public static Planet OARILIA;
	public static Planet STRURONIDES;
	public static Planet BRAJUTOV;
	public static Planet SPESHANI16;
	public static Planet TRARS9;

	public static void init() {
		initializePlanets();
		registerPlanets();
	}

	private static void initializePlanets() {
		if (Config.MERCURY) {
			MERCURY = new Planet("Mercury").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			MERCURY.setTierRequired(3);
			MERCURY.setRingColorRGB(0.1F, 0.9F, 0.6F);
			MERCURY.setPhaseShift(1.45F);
			MERCURY.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.5F + Config.MERCURY_DISTANCE_OFFSET, 0.5F + Config.MERCURY_DISTANCE_OFFSET));
			MERCURY.setRelativeOrbitTime(0.24096385542168674698795180722892F);
			MERCURY.atmosphereComponent(EnumAtmosphericGas.HYDROGEN);
			MERCURY.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/mercury.png"));
			MERCURY.setDimensionInfo(Config.MERCURY_ID, WorldProviderMercury.class);
			MERCURY.setAtmosphere(new AtmosphereInfo(false, false, false, Config.THERMAL_PADDINGS ? 50.0F : 5.0F, 0.0F, 0.1F));
			MERCURY.addChecklistKeys("tier_3_thermal_padding", "space_suit", "equipOxygenSuit", "equipParachute");
			MERCURY.setBiomeInfo(MercuryBiomes.mercury);
			MERCURY.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
			MERCURY.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
			MERCURY.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
			MERCURY.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
			MERCURY.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		}
		if (Config.CERES) {
			CERES = new Planet("Ceres").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			CERES.setTierRequired(4);
			CERES.setRingColorRGB(0.1F, 0.9F, 0.6F);
			CERES.setPhaseShift(Constants.floatPI);
			CERES.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.50F + Config.CERES_DISTANCE_OFFSET, 1.50F + Config.CERES_DISTANCE_OFFSET));
			CERES.setRelativeOrbitTime((float) 11.861993428258488499452354874042 / 2);
			CERES.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM);
			CERES.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/ceres.png"));
			CERES.setDimensionInfo(Config.CERES_ID, WorldProviderCeres.class);
			CERES.setAtmosphere(new AtmosphereInfo(false, false, false, -1.5F, 5.0F, 0.1F));
			CERES.addChecklistKeys("thermalPadding", "space_suit", "equipOxygenSuit", "equipParachute");
			CERES.setBiomeInfo(CeresBiomes.ceres);
			CERES.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
			CERES.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
			CERES.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
			CERES.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
			CERES.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		}
		if (Config.JUPITER) {
			JUPITER = new Planet("Jupiter").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			JUPITER.setTierRequired(4);
			JUPITER.setRingColorRGB(0.1F, 0.9F, 0.6F);
			JUPITER.setPhaseShift(Constants.floatPI);
			JUPITER.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.75F + Config.JUPITER_DISTANCE_OFFSET, 1.75F + Config.JUPITER_DISTANCE_OFFSET));
			JUPITER.setRelativeOrbitTime(11.861993428258488499452354874042F);
			JUPITER.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM);
			JUPITER.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/jupiter.png"));
			JUPITER.setDimensionInfo(Config.JUPITER_ID, WorldProviderJupiter.class);
			JUPITER.setAtmosphere(new AtmosphereInfo(false, false, true, 100.0F, 3.0F, 0.1F));
			JUPITER.addChecklistKeys("tier_4_thermal_padding", "space_suit", "equipOxygenSuit", "equipParachute", "equipShieldController");
			JUPITER.setBiomeInfo(JupiterBiomes.jupiter, JupiterBiomes.jupiterMagmaSea, JupiterBiomes.jupiterSands);
			JUPITER.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
			JUPITER.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
			JUPITER.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
			JUPITER.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
			JUPITER.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		}
		if (Config.SATURN) {
			SATURN = new Planet("Saturn").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			SATURN.setTierRequired(5);
			SATURN.setRingColorRGB(0.1F, 0.9F, 0.6F);
			SATURN.setPhaseShift(5.45F);
			SATURN.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.00F + Config.SATURN_DISTANCE_OFFSET, 2.00F + Config.SATURN_DISTANCE_OFFSET));
			SATURN.setRelativeOrbitTime(29.463307776560788608981380065717F);
			SATURN.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE);
			SATURN.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/saturn.png"));
			SATURN.setDimensionInfo(Config.SATURN_ID, WorldProviderSaturn.class);
			SATURN.setAtmosphere(new AtmosphereInfo(false, false, true, 80.0F, 0.0F, 0.1F));
			SATURN.addChecklistKeys("tier_4_thermal_padding", "space_suit", "equipOxygenSuit", "equipParachute", "equipShieldController");
			SATURN.setBiomeInfo(SaturnBiomes.saturn, SaturnBiomes.saturnHydroCarbonSea, SaturnBiomes.saturnNuclearLand);
			SATURN.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
			SATURN.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
			SATURN.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
			SATURN.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
			SATURN.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		}
		if (Config.URANUS) {
			URANUS = new Planet("Uranus").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			URANUS.setTierRequired(6);
			URANUS.setRingColorRGB(0.1F, 0.9F, 0.6F);
			URANUS.setPhaseShift(1.38F);
			URANUS.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.25F + Config.URANUS_DISTANCE_OFFSET, 2.25F + Config.URANUS_DISTANCE_OFFSET));
			URANUS.setRelativeOrbitTime(84.063526834611171960569550930997F);
			URANUS.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.METHANE).atmosphereComponent(EnumAtmosphericGas.WATER);
			URANUS.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/uranus.png"));
			URANUS.setDimensionInfo(Config.URANUS_ID, WorldProviderUranus.class);
			URANUS.setAtmosphere(new AtmosphereInfo(false, false, true, -120.0F, 4.0F, 0.1F));
			URANUS.addChecklistKeys("tier_5_thermal_padding", "space_suit", "equipOxygenSuit", "equipParachute", "equipShieldController");
			URANUS.setBiomeInfo(UranusBiomes.uranus, UranusBiomes.uranusFrozenWaterSea, UranusBiomes.uranusSnowLands);
			URANUS.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
			URANUS.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
			URANUS.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
			URANUS.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
			URANUS.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		}
		if (Config.NEPTUNE) {
			NEPTUNE = new Planet("Neptune").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			NEPTUNE.setTierRequired(7);
			NEPTUNE.setRingColorRGB(0.1F, 0.9F, 0.6F);
			NEPTUNE.setPhaseShift(1.0F);
			NEPTUNE.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.50F + Config.NEPTUNE_DISTANCE_OFFSET, 2.50F + Config.NEPTUNE_DISTANCE_OFFSET));
			NEPTUNE.setRelativeOrbitTime(164.84118291347207009857612267251F);
			NEPTUNE.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.WATER);
			NEPTUNE.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/neptune.png"));
			NEPTUNE.setDimensionInfo(Config.NEPTUNE_ID, WorldProviderNeptune.class);
			NEPTUNE.setAtmosphere(new AtmosphereInfo(false, false, true, -140.0F, 5.0F, 0.1F));
			NEPTUNE.addChecklistKeys("tier_5_thermal_padding", "space_suit", "equipOxygenSuit", "equipParachute", "equipShieldController");
			NEPTUNE.setBiomeInfo(NeptuneBiomes.neptune, NeptuneBiomes.neptuneLayeredHills, NeptuneBiomes.neptuneRadioActiveWaterSea);
			NEPTUNE.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
			NEPTUNE.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
			NEPTUNE.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
			NEPTUNE.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
			NEPTUNE.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		}
		if (Config.PLUTO) {
			PLUTO = new Planet("Pluto").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			PLUTO.setTierRequired(8);
			PLUTO.setRingColorRGB(0.1F, 0.9F, 0.6F);
			PLUTO.setPhaseShift(2.0F);
			PLUTO.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.75F + Config.PLUTO_DISTANCE_OFFSET, 2.75F + Config.PLUTO_DISTANCE_OFFSET));
			PLUTO.setRelativeOrbitTime((float) (164.84118291347207009857612267251 * 2));
			PLUTO.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.WATER);
			PLUTO.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/pluto.png"));
			PLUTO.setDimensionInfo(Config.PLUTO_ID, WorldProviderPluto.class);
			PLUTO.setAtmosphere(new AtmosphereInfo(false, false, false, Config.THERMAL_PADDINGS ? -140.0F : 5.0F, 5.0F, 0.1F));
			PLUTO.addChecklistKeys("tier_5_thermal_padding", "space_suit", "equipOxygenSuit", "equipParachute");
			PLUTO.setBiomeInfo(PlutoBiomes.pluto);
			PLUTO.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
			PLUTO.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
			PLUTO.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
			PLUTO.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
			PLUTO.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		}
		if (Config.ERIS) {
			ERIS = new Planet("Eris").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			ERIS.setTierRequired(9);
			ERIS.setRingColorRGB(0.1F, 0.9F, 0.6F);
			ERIS.setPhaseShift(1.0F);
			ERIS.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(3.75F + Config.ERIS_DISTANCE_OFFSET, 3.75F + Config.ERIS_DISTANCE_OFFSET));
			ERIS.setRelativeOrbitTime((float) (164.84118291347207009857612267251 * 3));
			ERIS.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.WATER);
			ERIS.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/eris.png"));
			ERIS.setDimensionInfo(Config.ERIS_ID, WorldProviderEris.class);
			ERIS.setAtmosphere(new AtmosphereInfo(false, false, false, Config.THERMAL_PADDINGS ? -150.0F : 5.0F, 5.0F, 0.1F));
			ERIS.addChecklistKeys("tier_5_thermal_padding", "space_suit", "equipOxygenSuit", "equipParachute");
			ERIS.setBiomeInfo(ErisBiomes.eris);
			ERIS.addMobInfo(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
			ERIS.addMobInfo(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
			ERIS.addMobInfo(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
			ERIS.addMobInfo(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
			ERIS.addMobInfo(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
		}
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			KEPLER22B = new Planet("kepler22b").setParentSolarSystem(ExtraPlanets_SolarSystems.kepler22);
			KEPLER22B.setTierRequired(10);
			KEPLER22B.setRingColorRGB(0.1F, 0.9F, 0.6F);
			KEPLER22B.setPhaseShift(1.45F);
			KEPLER22B.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.5F, 0.5F));
			KEPLER22B.setRelativeOrbitTime(164.84118291347207009857612267251F);
			KEPLER22B.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.WATER).atmosphereComponent(EnumAtmosphericGas.OXYGEN);
			KEPLER22B.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler22b.png"));
			KEPLER22B.setDimensionInfo(Config.KEPLER22B_ID, WorldProviderKepler22b.class);
			KEPLER22B.setAtmosphere(new AtmosphereInfo(true, true, false, 0.0F, 5.0F, 0.05F));
			KEPLER22B.addChecklistKeys("equipParachute");
			KEPLER22B.setBiomeInfo(Kepler22bBiomes.kepler22bBlueForest, Kepler22bBiomes.kepler22bCandyLand, Kepler22bBiomes.kepler22bCoalPlains, Kepler22bBiomes.kepler22bDiamondPlains, Kepler22bBiomes.kepler22bEmeraldPlains,
					Kepler22bBiomes.kepler22bGoldPlains, Kepler22bBiomes.kepler22bIronPlains, Kepler22bBiomes.kepler22bPlains, Kepler22bBiomes.kepler22bPurpleForest, Kepler22bBiomes.kepler22bRedDesert, Kepler22bBiomes.kepler22bRedForest,
					Kepler22bBiomes.kepler22bWasteLands, Kepler22bBiomes.kepler22bYellowForest);
			KEPLER22B.addMobInfo(new SpawnListEntry(EntityZombie.class, 100, 4, 4));
			KEPLER22B.addMobInfo(new SpawnListEntry(EntitySpider.class, 100, 4, 4));
			KEPLER22B.addMobInfo(new SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
			KEPLER22B.addMobInfo(new SpawnListEntry(EntityCreeper.class, 100, 4, 4));
			KEPLER22B.addMobInfo(new SpawnListEntry(EntityEnderman.class, 100, 1, 4));
			KEPLER22B.addMobInfo(new SpawnListEntry(EntityWitch.class, 5, 1, 1));
			KEPLER22B.addMobInfo(new SpawnListEntry(EntitySheep.class, 12, 4, 4));
			KEPLER22B.addMobInfo(new SpawnListEntry(EntityPig.class, 10, 4, 4));
			KEPLER22B.addMobInfo(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
			KEPLER22B.addMobInfo(new SpawnListEntry(EntityCow.class, 8, 4, 4));
		}
		if (Config.KUIPER_BELT) {
			KUIPER_BELT = GCRegisterUtilities.registerUnreachablePlanet("kuiperBelt", GalacticraftCore.solarSystemSol);
			if (KUIPER_BELT != null) {
				KUIPER_BELT.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(4.0F + Config.KUIPER_BELT_DISTANCE_OFFSET, 4.0F + Config.KUIPER_BELT_DISTANCE_OFFSET))
						.setRelativeOrbitTime(164.84118291347207009857612267251F);
				KUIPER_BELT.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kuiper_belt.png"));
			}
		}
		if (Config.MAKEMAKE) {
			MAKEMAKE = GCRegisterUtilities.registerUnreachablePlanet("makemake", GalacticraftCore.solarSystemSol);
			if (MAKEMAKE != null) {
				MAKEMAKE.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(4.50F + Config.MAKEMAKE_DISTANCE_OFFSET, 4.50F + Config.MAKEMAKE_DISTANCE_OFFSET))
						.setRelativeOrbitTime(164.84118291347207009857612267251F);
				MAKEMAKE.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/makemake.png"));
			}
		}
		if (Config.HAUMEA) {
			HAUNEA = GCRegisterUtilities.registerUnreachablePlanet("haumea", GalacticraftCore.solarSystemSol);
			if (HAUNEA != null) {
				HAUNEA.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(3.50F + Config.HAUMEA_DISTANCE_OFFSET, 3.50F + Config.HAUMEA_DISTANCE_OFFSET))
						.setRelativeOrbitTime(164.84118291347207009857612267251F);
				HAUNEA.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/haumea.png"));
			}
		}
		if (Config.KEPLER_SOLAR_SYSTEMS) {
			// Kepler Solar System

			// Kepler 47 Solar System
			KEPLER47B = GCRegisterUtilities.registerUnreachablePlanet("kepler47b", ExtraPlanets_SolarSystems.kepler47);
			if (KEPLER47B != null) {
				KEPLER47B.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.5F, 0.5F)).setRelativeOrbitTime(164.84118291347207009857612267251F);
				KEPLER47B.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler47b.png"));
			}

			KEPLER47C = GCRegisterUtilities.registerUnreachablePlanet("kepler47c", ExtraPlanets_SolarSystems.kepler47);
			if (KEPLER47C != null) {
				KEPLER47C.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.0F, 1.0F)).setRelativeOrbitTime(164.84118291347207009857612267251F);
				KEPLER47C.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler47c.png"));
			}

			// Kepler 62 Solar System
			KEPLER62B = GCRegisterUtilities.registerUnreachablePlanet("kepler62b", ExtraPlanets_SolarSystems.kepler62);
			if (KEPLER62B != null) {
				KEPLER62B.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(0.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.5F, 0.5F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 6);
				KEPLER62B.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler62b.png"));
			}

			KEPLER62C = GCRegisterUtilities.registerUnreachablePlanet("kepler62c", ExtraPlanets_SolarSystems.kepler62);
			if (KEPLER62C != null) {
				KEPLER62C.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.0F, 1.0F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 5);
				KEPLER62C.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler62c.png"));
			}

			KEPLER62D = GCRegisterUtilities.registerUnreachablePlanet("kepler62d", ExtraPlanets_SolarSystems.kepler62);
			if (KEPLER62D != null) {
				KEPLER62D.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(2.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.50F, 1.50F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 4);
				KEPLER62D.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler62d.png"));
			}

			KEPLER62E = GCRegisterUtilities.registerUnreachablePlanet("kepler62e", ExtraPlanets_SolarSystems.kepler62);
			if (KEPLER62E != null) {
				KEPLER62E.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(3.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.75F, 1.75F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 3);
				KEPLER62E.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler62e.png"));
			}

			KEPLER62F = GCRegisterUtilities.registerUnreachablePlanet("kepler62f", ExtraPlanets_SolarSystems.kepler62);
			if (KEPLER62F != null) {
				KEPLER62F.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(4.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.0F, 2.0F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 2);
				KEPLER62F.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler62f.png"));
			}

			// Kepler 69 Solar System
			KEPLER69B = GCRegisterUtilities.registerUnreachablePlanet("kepler69b", ExtraPlanets_SolarSystems.kepler69);
			if (KEPLER69B != null) {
				KEPLER69B.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(5.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.5F, 0.5F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 1);
				KEPLER69B.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler69b.png"));
			}

			KEPLER69C = GCRegisterUtilities.registerUnreachablePlanet("kepler69c", ExtraPlanets_SolarSystems.kepler69);
			if (KEPLER69C != null) {
				KEPLER69C.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(6.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.0F, 1.0F)).setRelativeOrbitTime(164.84118291347207009857612267251F);
				KEPLER69C.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler69c.png"));
			}
		}
		if (Config.CUSTOM_GALAXIES) {
			TATOOINE = GCRegisterUtilities.registerUnreachablePlanet("tatooine", ExtraPlanets_SolarSystems.epsilonSolaria);
			if (TATOOINE != null) {
				TATOOINE.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(0.75F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.5F, 0.5F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 8);
				TATOOINE.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/tatooine.png"));
			}
			CRAIT = GCRegisterUtilities.registerUnreachablePlanet("crait", ExtraPlanets_SolarSystems.epsilonSolaria);
			if (CRAIT != null) {
				CRAIT.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(5.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.0F, 1.0F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 6);
				CRAIT.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/crait.png"));
			}
			HOTH = GCRegisterUtilities.registerUnreachablePlanet("hoth", ExtraPlanets_SolarSystems.epsilonSolaria);
			if (HOTH != null) {
				HOTH.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.5F, 1.5F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 4);
				HOTH.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/hoth.png"));
			}
			AQUA = GCRegisterUtilities.registerUnreachablePlanet("aqua", ExtraPlanets_SolarSystems.epsilonSolaria);
			if (AQUA != null) {
				AQUA.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(2.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.0F, 2.0F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 2);
				AQUA.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/aqua.png"));
			}

			QUSTROITHEA = GCRegisterUtilities.registerUnreachablePlanet("qustroithea", ExtraPlanets_SolarSystems.xenos157);
			if (QUSTROITHEA != null) {
				QUSTROITHEA.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.5F, 0.5F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 8);
				QUSTROITHEA.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/qustroithea.png"));
			}
			JETRARUTA = GCRegisterUtilities.registerUnreachablePlanet("jetraruta", ExtraPlanets_SolarSystems.xenos157);
			if (JETRARUTA != null) {
				JETRARUTA.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(2.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.0F, 1.0F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 6);
				JETRARUTA.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/jetraruta.png"));
			}
			MOSWION = GCRegisterUtilities.registerUnreachablePlanet("moswion", ExtraPlanets_SolarSystems.xenos157);
			if (MOSWION != null) {
				MOSWION.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(3.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(3.0F, 3.0F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 4);
				MOSWION.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/moswion.png"));
			}
			KETHERTH = GCRegisterUtilities.registerUnreachablePlanet("ketherth", ExtraPlanets_SolarSystems.xenos157);
			if (KETHERTH != null) {
				KETHERTH.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(4.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(4.0F, 4.0F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 2);
				KETHERTH.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/ketherth.png"));
			}
			XOVIS = GCRegisterUtilities.registerUnreachablePlanet("xovis", ExtraPlanets_SolarSystems.xenos157);
			if (XOVIS != null) {
				XOVIS.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(5.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(4.5F, 4.5F)).setRelativeOrbitTime(164.84118291347207009857612267251F);
				XOVIS.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/xovis.png"));
			}

			OARILIA = GCRegisterUtilities.registerUnreachablePlanet("oarilia", ExtraPlanets_SolarSystems.vendrizi161);
			if (OARILIA != null) {
				OARILIA.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.5F, 0.5F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 8);
				OARILIA.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/oarilia.png"));
			}
			STRURONIDES = GCRegisterUtilities.registerUnreachablePlanet("struronides", ExtraPlanets_SolarSystems.vendrizi161);
			if (STRURONIDES != null) {
				STRURONIDES.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(2.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.0F, 1.0F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 6);
				STRURONIDES.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/struronides.png"));
			}
			BRAJUTOV = GCRegisterUtilities.registerUnreachablePlanet("brajutov", ExtraPlanets_SolarSystems.vendrizi161);
			if (BRAJUTOV != null) {
				BRAJUTOV.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(3.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.5F, 1.5F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 4);
				BRAJUTOV.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/brajutov.png"));
			}
			SPESHANI16 = GCRegisterUtilities.registerUnreachablePlanet("speshani16", ExtraPlanets_SolarSystems.vendrizi161);
			if (SPESHANI16 != null) {
				SPESHANI16.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(4.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.0F, 2.0F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 2);
				SPESHANI16.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/speshani16.png"));
			}
			TRARS9 = GCRegisterUtilities.registerUnreachablePlanet("trars9", ExtraPlanets_SolarSystems.vendrizi161);
			if (TRARS9 != null) {
				TRARS9.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(5.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.5F, 2.5F)).setRelativeOrbitTime(164.84118291347207009857612267251F);
				TRARS9.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/trars9.png"));
			}
		}
	}

	private static void registerPlanets() {
		if (Config.MERCURY) {
			GalaxyRegistry.registerPlanet(MERCURY);
			GalacticraftRegistry.registerTeleportType(WorldProviderMercury.class, new TeleportTypeMercury());
			GalacticraftRegistry.registerRocketGui(WorldProviderMercury.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/mercury_rocket_gui.png"));
		}
		if (Config.CERES) {
			GalaxyRegistry.registerPlanet(CERES);
			GalacticraftRegistry.registerTeleportType(WorldProviderCeres.class, new TeleportTypeCeres());
			GalacticraftRegistry.registerRocketGui(WorldProviderCeres.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/ceres_rocket_gui.png"));
		}
		if (Config.JUPITER) {
			GalaxyRegistry.registerPlanet(JUPITER);
			GalacticraftRegistry.registerTeleportType(WorldProviderJupiter.class, new TeleportTypeJupiter());
			GalacticraftRegistry.registerRocketGui(WorldProviderJupiter.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/jupiter_rocket_gui.png"));
		}
		if (Config.SATURN) {
			GalaxyRegistry.registerPlanet(SATURN);
			GalacticraftRegistry.registerTeleportType(WorldProviderSaturn.class, new TeleportTypeSaturn());
			GalacticraftRegistry.registerRocketGui(WorldProviderSaturn.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/saturn_rocket_gui.png"));
		}
		if (Config.URANUS) {
			GalaxyRegistry.registerPlanet(URANUS);
			GalacticraftRegistry.registerTeleportType(WorldProviderUranus.class, new TeleportTypeUranus());
			GalacticraftRegistry.registerRocketGui(WorldProviderUranus.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/uranus_rocket_gui.png"));
		}
		if (Config.NEPTUNE) {
			GalaxyRegistry.registerPlanet(NEPTUNE);
			GalacticraftRegistry.registerTeleportType(WorldProviderNeptune.class, new TeleportTypeNeptune());
			GalacticraftRegistry.registerRocketGui(WorldProviderNeptune.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/neptune_rocket_gui.png"));
		}
		if (Config.PLUTO) {
			GalaxyRegistry.registerPlanet(PLUTO);
			GalacticraftRegistry.registerTeleportType(WorldProviderPluto.class, new TeleportTypePluto());
			GalacticraftRegistry.registerRocketGui(WorldProviderPluto.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/pluto_rocket_gui.png"));
		}
		if (Config.ERIS) {
			GalaxyRegistry.registerPlanet(ERIS);
			GalacticraftRegistry.registerTeleportType(WorldProviderEris.class, new TeleportTypeEris());
			GalacticraftRegistry.registerRocketGui(WorldProviderEris.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/eris_rocket_gui.png"));
		}
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			GalaxyRegistry.registerPlanet(KEPLER22B);
			GalacticraftRegistry.registerTeleportType(WorldProviderKepler22b.class, new TeleportTypeKepler22b());
			GalacticraftRegistry.registerRocketGui(WorldProviderKepler22b.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/kepler22b_rocket_gui.png"));
		}
	}
}