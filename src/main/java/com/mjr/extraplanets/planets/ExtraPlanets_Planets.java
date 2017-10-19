package com.mjr.extraplanets.planets;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.world.AtmosphereInfo;
import micdoodle8.mods.galacticraft.api.world.EnumAtmosphericGas;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.util.ResourceLocation;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets_SolarSystems;
import com.mjr.extraplanets.planets.Ceres.TeleportTypeCeres;
import com.mjr.extraplanets.planets.Ceres.WorldProviderCeres;
import com.mjr.extraplanets.planets.Eris.TeleportTypeEris;
import com.mjr.extraplanets.planets.Eris.WorldProviderEris;
import com.mjr.extraplanets.planets.Jupiter.TeleportTypeJupiter;
import com.mjr.extraplanets.planets.Jupiter.WorldProviderJupiter;
import com.mjr.extraplanets.planets.Kepler22b.TeleportTypeKepler22b;
import com.mjr.extraplanets.planets.Kepler22b.WorldProviderKepler22b;
import com.mjr.extraplanets.planets.Mercury.TeleportTypeMercury;
import com.mjr.extraplanets.planets.Mercury.WorldProviderMercury;
import com.mjr.extraplanets.planets.Neptune.TeleportTypeNeptune;
import com.mjr.extraplanets.planets.Neptune.WorldProviderNeptune;
import com.mjr.extraplanets.planets.Pluto.TeleportTypePluto;
import com.mjr.extraplanets.planets.Pluto.WorldProviderPluto;
import com.mjr.extraplanets.planets.Saturn.TeleportTypeSaturn;
import com.mjr.extraplanets.planets.Saturn.WorldProviderSaturn;
import com.mjr.extraplanets.planets.Uranus.TeleportTypeUranus;
import com.mjr.extraplanets.planets.Uranus.WorldProviderUranus;
import com.mjr.extraplanets.util.RegisterHelper;

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
			MERCURY.setAtmosphere(new AtmosphereInfo(false, false, false, 50.0F, 0.0F, 0.1F));
			MERCURY.addChecklistKeys("tier_3_thermal_padding", "tier_1_space_suit", "equipOxygenSuit", "equipParachute");
		}
		if (Config.CERES) {
			CERES = new Planet("Ceres").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			CERES.setTierRequired(Config.ROCKET_TIER_CERES);
			CERES.setRingColorRGB(0.1F, 0.9F, 0.6F);
			CERES.setPhaseShift(Constants.floatPI);
			CERES.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.50F + Config.CERES_DISTANCE_OFFSET, 1.50F + Config.CERES_DISTANCE_OFFSET));
			CERES.setRelativeOrbitTime((float) 11.861993428258488499452354874042 / 2);
			CERES.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM);
			CERES.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/ceres.png"));
			CERES.setDimensionInfo(Config.CERES_ID, WorldProviderCeres.class);
			CERES.setAtmosphere(new AtmosphereInfo(false, false, false, -1.5F, 5.0F, 0.1F));
			CERES.addChecklistKeys("thermalPadding", "tier_1_space_suit", "equipOxygenSuit", "equipParachute");
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
			JUPITER.addChecklistKeys("tier_4_thermal_padding", "tier_2_space_suit", "equipOxygenSuit", "equipParachute");
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
			SATURN.addChecklistKeys("tier_4_thermal_padding", "tier_3_space_suit", "equipOxygenSuit", "equipParachute");
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
			URANUS.addChecklistKeys("tier_5_thermal_padding", "tier_3_space_suit", "equipOxygenSuit", "equipParachute");
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
			NEPTUNE.addChecklistKeys("tier_5_thermal_padding", "tier_4_space_suit", "equipOxygenSuit", "equipParachute");
		}
		if (Config.PLUTO) {
			PLUTO = new Planet("Pluto").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			PLUTO.setTierRequired(8);
			PLUTO.setRingColorRGB(0.1F, 0.9F, 0.6F);
			PLUTO.setPhaseShift(1.0F);
			PLUTO.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.75F + Config.PLUTO_DISTANCE_OFFSET, 2.75F + Config.PLUTO_DISTANCE_OFFSET));
			PLUTO.setRelativeOrbitTime((float) (164.84118291347207009857612267251 * 2));
			PLUTO.atmosphereComponent(EnumAtmosphericGas.HYDROGEN).atmosphereComponent(EnumAtmosphericGas.HELIUM).atmosphereComponent(EnumAtmosphericGas.WATER);
			PLUTO.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/pluto.png"));
			PLUTO.setDimensionInfo(Config.PLUTO_ID, WorldProviderPluto.class);
			PLUTO.setAtmosphere(new AtmosphereInfo(false, false, false, -140.0F, 5.0F, 0.1F));
			PLUTO.addChecklistKeys("tier_5_thermal_padding", "tier_4_space_suit", "equipOxygenSuit", "equipParachute");
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
			ERIS.setAtmosphere(new AtmosphereInfo(false, false, false, -150.0F, 5.0F, 0.1F));
			ERIS.addChecklistKeys("tier_5_thermal_padding", "tier_4_space_suit", "equipOxygenSuit", "equipParachute");
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
		}
		if (Config.KUIPER_BELT) {
			KUIPER_BELT = RegisterHelper.registerUnreachablePlanet("kuiperBelt", GalacticraftCore.solarSystemSol);
			if (KUIPER_BELT != null) {
				KUIPER_BELT.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(4.0F + Config.KUIPER_BELT_DISTANCE_OFFSET, 4.0F + Config.KUIPER_BELT_DISTANCE_OFFSET))
						.setRelativeOrbitTime(164.84118291347207009857612267251F);
				KUIPER_BELT.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kuiper_belt.png"));
			}
		}
		if (Config.MAKEMAKE) {
			MAKEMAKE = RegisterHelper.registerUnreachablePlanet("makemake", GalacticraftCore.solarSystemSol);
			if (MAKEMAKE != null) {
				MAKEMAKE.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(4.50F + Config.MAKEMAKE_DISTANCE_OFFSET, 4.50F + Config.MAKEMAKE_DISTANCE_OFFSET))
						.setRelativeOrbitTime(164.84118291347207009857612267251F);
				MAKEMAKE.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/makemake.png"));
			}
		}
		if (Config.HAUMEA) {
			HAUNEA = RegisterHelper.registerUnreachablePlanet("haumea", GalacticraftCore.solarSystemSol);
			if (HAUNEA != null) {
				HAUNEA.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(3.50F + Config.HAUMEA_DISTANCE_OFFSET, 3.50F + Config.HAUMEA_DISTANCE_OFFSET))
						.setRelativeOrbitTime(164.84118291347207009857612267251F);
				HAUNEA.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/haumea.png"));
			}
		}
		if (Config.KEPLER_SOLAR_SYSTEMS) {
			// Kepler Solar System

			// Kepler 47 Solar System
			KEPLER47B = RegisterHelper.registerUnreachablePlanet("kepler47b", ExtraPlanets_SolarSystems.kepler47);
			if (KEPLER47B != null) {
				KEPLER47B.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.5F, 0.5F)).setRelativeOrbitTime(164.84118291347207009857612267251F);
				KEPLER47B.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler47b.png"));
			}

			KEPLER47C = RegisterHelper.registerUnreachablePlanet("kepler47c", ExtraPlanets_SolarSystems.kepler47);
			if (KEPLER47C != null) {
				KEPLER47C.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.0F, 1.0F)).setRelativeOrbitTime(164.84118291347207009857612267251F);
				KEPLER47C.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler47c.png"));
			}

			// Kepler 62 Solar System
			KEPLER62B = RegisterHelper.registerUnreachablePlanet("kepler62b", ExtraPlanets_SolarSystems.kepler62);
			if (KEPLER62B != null) {
				KEPLER62B.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.5F, 0.5F)).setRelativeOrbitTime(164.84118291347207009857612267251F);
				KEPLER62B.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler62b.png"));
			}

			KEPLER62C = RegisterHelper.registerUnreachablePlanet("kepler62c", ExtraPlanets_SolarSystems.kepler62);
			if (KEPLER62C != null) {
				KEPLER62C.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.0F, 1.0F)).setRelativeOrbitTime(164.84118291347207009857612267251F);
				KEPLER62C.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler62c.png"));
			}

			KEPLER62D = RegisterHelper.registerUnreachablePlanet("kepler62d", ExtraPlanets_SolarSystems.kepler62);
			if (KEPLER62D != null) {
				KEPLER62D.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.50F, 1.50F)).setRelativeOrbitTime(164.84118291347207009857612267251F);
				KEPLER62D.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler62d.png"));
			}

			KEPLER62E = RegisterHelper.registerUnreachablePlanet("kepler62e", ExtraPlanets_SolarSystems.kepler62);
			if (KEPLER62E != null) {
				KEPLER62E.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.75F, 1.75F)).setRelativeOrbitTime(164.84118291347207009857612267251F);
				KEPLER62E.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler62e.png"));
			}

			KEPLER62F = RegisterHelper.registerUnreachablePlanet("kepler62f", ExtraPlanets_SolarSystems.kepler62);
			if (KEPLER62F != null) {
				KEPLER62F.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.0F, 2.0F)).setRelativeOrbitTime(164.84118291347207009857612267251F);
				KEPLER62F.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler62f.png"));
			}

			// Kepler 69 Solar System
			KEPLER69B = RegisterHelper.registerUnreachablePlanet("kepler69b", ExtraPlanets_SolarSystems.kepler69);
			if (KEPLER69B != null) {
				KEPLER69B.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.5F, 0.5F)).setRelativeOrbitTime(164.84118291347207009857612267251F);
				KEPLER69B.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler69b.png"));
			}

			KEPLER69C = RegisterHelper.registerUnreachablePlanet("kepler69c", ExtraPlanets_SolarSystems.kepler69);
			if (KEPLER69C != null) {
				KEPLER69C.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.0F, 1.0F)).setRelativeOrbitTime(164.84118291347207009857612267251F);
				KEPLER69C.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler69c.png"));
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