package com.mjr.extraplanets.planets;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Satellite;
import micdoodle8.mods.galacticraft.core.world.gen.BiomeOrbit;
import micdoodle8.mods.galacticraft.planets.mars.MarsModule;
import micdoodle8.mods.galacticraft.planets.venus.VenusModule;
import net.minecraft.util.ResourceLocation;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.planets.Ceres.spacestation.TeleportTypeCeresOrbit;
import com.mjr.extraplanets.planets.Ceres.spacestation.WorldProviderCeresOrbit;
import com.mjr.extraplanets.planets.Eris.spacestation.TeleportTypeErisOrbit;
import com.mjr.extraplanets.planets.Eris.spacestation.WorldProviderErisOrbit;
import com.mjr.extraplanets.planets.Jupiter.spacestation.TeleportTypeJupiterOrbit;
import com.mjr.extraplanets.planets.Jupiter.spacestation.WorldProviderJupiterOrbit;
import com.mjr.extraplanets.planets.Kepler22b.spacestation.TeleportTypeKepler22bOrbit;
import com.mjr.extraplanets.planets.Kepler22b.spacestation.WorldProviderKepler22bOrbit;
import com.mjr.extraplanets.planets.Mercury.spacestation.TeleportTypeMercuryOrbit;
import com.mjr.extraplanets.planets.Mercury.spacestation.WorldProviderMercuryOrbit;
import com.mjr.extraplanets.planets.Neptune.spacestation.TeleportTypeNeptuneOrbit;
import com.mjr.extraplanets.planets.Neptune.spacestation.WorldProviderNeptuneOrbit;
import com.mjr.extraplanets.planets.Pluto.spacestation.TeleportTypePlutoOrbit;
import com.mjr.extraplanets.planets.Pluto.spacestation.WorldProviderPlutoOrbit;
import com.mjr.extraplanets.planets.Saturn.spacestation.TeleportTypeSaturnOrbit;
import com.mjr.extraplanets.planets.Saturn.spacestation.WorldProviderSaturnOrbit;
import com.mjr.extraplanets.planets.Uranus.spacestation.TeleportTypeUranusOrbit;
import com.mjr.extraplanets.planets.Uranus.spacestation.WorldProviderUranusOrbit;
import com.mjr.extraplanets.planets.mars.spacestation.TeleportTypeMarsOrbit;
import com.mjr.extraplanets.planets.mars.spacestation.WorldProviderMarsOrbit;
import com.mjr.extraplanets.planets.venus.spacestation.TeleportTypeVenusOrbit;
import com.mjr.extraplanets.planets.venus.spacestation.WorldProviderVenusOrbit;

public class ExtraPlanets_SpaceStations {

	public static Satellite MERCURY_SPACE_STATION;
	public static Satellite VENUS_SPACE_STATION;
	public static Satellite CERES_SPACE_STATION;
	public static Satellite MARS_SPACE_STATION;
	public static Satellite JUPITER_SPACE_STATION;
	public static Satellite SATURN_SPACE_STATION;
	public static Satellite URANUS_SPACE_STATION;
	public static Satellite NEPTUNE_SPACE_STATION;
	public static Satellite PLUTO_SPACE_STATION;
	public static Satellite ERIS_SPACE_STATION;
	public static Satellite KEPLER22B_SPACE_STATION;

	public static void init() {
		initializeSatellites();
		registerSatellites();
	}

	private static void initializeSatellites() {
		if (Config.MERCURY_SPACE_STATION && Config.MERCURY) {
			MERCURY_SPACE_STATION = new Satellite("space_station.mercury").setParentBody(ExtraPlanets_Planets.MERCURY);
			MERCURY_SPACE_STATION.setRelativeSize(0.2667F);
			MERCURY_SPACE_STATION.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			MERCURY_SPACE_STATION.setRelativeOrbitTime(20.0F);
			MERCURY_SPACE_STATION.setTierRequired(ExtraPlanets_Planets.MERCURY.getTierRequirement());
			MERCURY_SPACE_STATION.setDimensionInfo(Config.MERCURY_SPACE_STATION_ID, Config.MERCURY_SPACE_STATION_STATIC_ID, WorldProviderMercuryOrbit.class);
			MERCURY_SPACE_STATION.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/space_station.png"));
			MERCURY_SPACE_STATION.addChecklistKeys("thermal_padding", "equip_oxygen_suit", "equip_parachute");
			MERCURY_SPACE_STATION.setBiomeInfo(BiomeOrbit.space);
		}
		if (Config.VENUS_SPACE_STATION) {
			VENUS_SPACE_STATION = new Satellite("space_station.venus").setParentBody(VenusModule.planetVenus);
			VENUS_SPACE_STATION.setRelativeSize(0.2667F);
			VENUS_SPACE_STATION.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			VENUS_SPACE_STATION.setRelativeOrbitTime(20.0F);
			VENUS_SPACE_STATION.setTierRequired(VenusModule.planetVenus.getTierRequirement());
			VENUS_SPACE_STATION.setDimensionInfo(Config.VENUS_SPACE_STATION_ID, Config.VENUS_SPACE_STATION_STATIC_ID, WorldProviderVenusOrbit.class);
			VENUS_SPACE_STATION.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/space_station.png"));
			VENUS_SPACE_STATION.addChecklistKeys("thermal_padding", "equip_oxygen_suit", "equip_parachute");
			VENUS_SPACE_STATION.setBiomeInfo(BiomeOrbit.space);
		}
		if (Config.CERES_SPACE_STATION && Config.CERES) {
			CERES_SPACE_STATION = new Satellite("space_station.ceres").setParentBody(ExtraPlanets_Planets.CERES);
			CERES_SPACE_STATION.setRelativeSize(0.2667F);
			CERES_SPACE_STATION.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			CERES_SPACE_STATION.setRelativeOrbitTime(20.0F);
			CERES_SPACE_STATION.setTierRequired(ExtraPlanets_Planets.CERES.getTierRequirement());
			CERES_SPACE_STATION.setDimensionInfo(Config.CERES_SPACE_STATION_ID, Config.CERES_SPACE_STATION_STATIC_ID, WorldProviderCeresOrbit.class);
			CERES_SPACE_STATION.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/space_station.png"));
			CERES_SPACE_STATION.addChecklistKeys("thermal_padding", "equip_oxygen_suit", "equip_parachute");
			CERES_SPACE_STATION.setBiomeInfo(BiomeOrbit.space);
		}
		if (Config.MARS_SPACE_STATION && MarsModule.planetMars != null) {
			MARS_SPACE_STATION = new Satellite("space_station.mars").setParentBody(MarsModule.planetMars);
			MARS_SPACE_STATION.setRelativeSize(0.2667F);
			MARS_SPACE_STATION.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			MARS_SPACE_STATION.setRelativeOrbitTime(20.0F);
			MARS_SPACE_STATION.setTierRequired(MarsModule.planetMars.getTierRequirement());
			MARS_SPACE_STATION.setDimensionInfo(Config.MARS_SPACE_STATION_ID, Config.MARS_SPACE_STATION_STATIC_ID, WorldProviderMarsOrbit.class);
			MARS_SPACE_STATION.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/space_station.png"));
			MARS_SPACE_STATION.addChecklistKeys("thermal_padding", "equip_oxygen_suit", "equip_parachute");
			MARS_SPACE_STATION.setBiomeInfo(BiomeOrbit.space);
		}
		if (Config.JUPITER_SPACE_STATION && Config.JUPITER) {
			JUPITER_SPACE_STATION = new Satellite("space_station.jupiter").setParentBody(ExtraPlanets_Planets.JUPITER);
			JUPITER_SPACE_STATION.setRelativeSize(0.2667F);
			JUPITER_SPACE_STATION.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			JUPITER_SPACE_STATION.setRelativeOrbitTime(20.0F);
			JUPITER_SPACE_STATION.setTierRequired(ExtraPlanets_Planets.JUPITER.getTierRequirement());
			JUPITER_SPACE_STATION.setDimensionInfo(Config.JUPITER_SPACE_STATION_ID, Config.JUPITER_SPACE_STATION_STATIC_ID, WorldProviderJupiterOrbit.class);
			JUPITER_SPACE_STATION.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/space_station.png"));
			JUPITER_SPACE_STATION.addChecklistKeys("thermal_padding", "equip_oxygen_suit", "equip_parachute");
			JUPITER_SPACE_STATION.setBiomeInfo(BiomeOrbit.space);
		}
		if (Config.SATURN_SPACE_STATION && Config.SATURN) {
			SATURN_SPACE_STATION = new Satellite("space_station.saturn").setParentBody(ExtraPlanets_Planets.SATURN);
			SATURN_SPACE_STATION.setRelativeSize(0.2667F);
			SATURN_SPACE_STATION.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			SATURN_SPACE_STATION.setRelativeOrbitTime(20.0F);
			SATURN_SPACE_STATION.setTierRequired(ExtraPlanets_Planets.SATURN.getTierRequirement());
			SATURN_SPACE_STATION.setDimensionInfo(Config.SATURN_SPACE_STATION_ID, Config.SATURN_SPACE_STATION_STATIC_ID, WorldProviderSaturnOrbit.class);
			SATURN_SPACE_STATION.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/space_station.png"));
			SATURN_SPACE_STATION.addChecklistKeys("thermal_padding", "equip_oxygen_suit", "equip_parachute");
			SATURN_SPACE_STATION.setBiomeInfo(BiomeOrbit.space);
		}
		if (Config.URANUS_SPACE_STATION && Config.URANUS) {
			URANUS_SPACE_STATION = new Satellite("space_station.uranus").setParentBody(ExtraPlanets_Planets.URANUS);
			URANUS_SPACE_STATION.setRelativeSize(0.2667F);
			URANUS_SPACE_STATION.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			URANUS_SPACE_STATION.setRelativeOrbitTime(20.0F);
			URANUS_SPACE_STATION.setTierRequired(ExtraPlanets_Planets.URANUS.getTierRequirement());
			URANUS_SPACE_STATION.setDimensionInfo(Config.URANUS_SPACE_STATION_ID, Config.URANUS_SPACE_STATION_STATIC_ID, WorldProviderUranusOrbit.class);
			URANUS_SPACE_STATION.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/space_station.png"));
			URANUS_SPACE_STATION.addChecklistKeys("thermal_padding", "equip_oxygen_suit", "equip_parachute");
			URANUS_SPACE_STATION.setBiomeInfo(BiomeOrbit.space);
		}
		if (Config.NEPTUNE_SPACE_STATION && Config.NEPTUNE) {
			NEPTUNE_SPACE_STATION = new Satellite("space_station.neptune").setParentBody(ExtraPlanets_Planets.NEPTUNE);
			NEPTUNE_SPACE_STATION.setRelativeSize(0.2667F);
			NEPTUNE_SPACE_STATION.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			NEPTUNE_SPACE_STATION.setRelativeOrbitTime(20.0F);
			NEPTUNE_SPACE_STATION.setTierRequired(ExtraPlanets_Planets.NEPTUNE.getTierRequirement());
			NEPTUNE_SPACE_STATION.setDimensionInfo(Config.NEPTUNE_SPACE_STATION_ID, Config.NEPTUNE_SPACE_STATION_STATIC_ID, WorldProviderNeptuneOrbit.class);
			NEPTUNE_SPACE_STATION.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/space_station.png"));
			NEPTUNE_SPACE_STATION.addChecklistKeys("thermal_padding", "equip_oxygen_suit", "equip_parachute");
			NEPTUNE_SPACE_STATION.setBiomeInfo(BiomeOrbit.space);
		}
		if (Config.PLUTO_SPACE_STATION && Config.PLUTO) {
			PLUTO_SPACE_STATION = new Satellite("space_station.pluto").setParentBody(ExtraPlanets_Planets.PLUTO);
			PLUTO_SPACE_STATION.setRelativeSize(0.2667F);
			PLUTO_SPACE_STATION.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			PLUTO_SPACE_STATION.setRelativeOrbitTime(20.0F);
			PLUTO_SPACE_STATION.setTierRequired(ExtraPlanets_Planets.PLUTO.getTierRequirement());
			PLUTO_SPACE_STATION.setDimensionInfo(Config.PLUTO_SPACE_STATION_ID, Config.PLUTO_SPACE_STATION_STATIC_ID, WorldProviderPlutoOrbit.class);
			PLUTO_SPACE_STATION.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/space_station.png"));
			PLUTO_SPACE_STATION.addChecklistKeys("thermal_padding", "equip_oxygen_suit", "equip_parachute");
			PLUTO_SPACE_STATION.setBiomeInfo(BiomeOrbit.space);
		}
		if (Config.ERIS_SPACE_STATION && Config.ERIS) {
			ERIS_SPACE_STATION = new Satellite("space_station.eris").setParentBody(ExtraPlanets_Planets.ERIS);
			ERIS_SPACE_STATION.setRelativeSize(0.2667F);
			ERIS_SPACE_STATION.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			ERIS_SPACE_STATION.setRelativeOrbitTime(20.0F);
			ERIS_SPACE_STATION.setTierRequired(ExtraPlanets_Planets.ERIS.getTierRequirement());
			ERIS_SPACE_STATION.setDimensionInfo(Config.ERIS_SPACE_STATION_ID, Config.ERIS_SPACE_STATION_STATIC_ID, WorldProviderErisOrbit.class);
			ERIS_SPACE_STATION.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/space_station.png"));
			ERIS_SPACE_STATION.addChecklistKeys("thermal_padding", "equip_oxygen_suit", "equip_parachute");
			ERIS_SPACE_STATION.setBiomeInfo(BiomeOrbit.space);
		}
		if (Config.KEPLER22B_SPACE_STATION && Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			KEPLER22B_SPACE_STATION = new Satellite("space_station.kepler22b").setParentBody(ExtraPlanets_Planets.KEPLER22B);
			KEPLER22B_SPACE_STATION.setRelativeSize(0.2667F);
			KEPLER22B_SPACE_STATION.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			KEPLER22B_SPACE_STATION.setRelativeOrbitTime(20.0F);
			KEPLER22B_SPACE_STATION.setTierRequired(ExtraPlanets_Planets.KEPLER22B.getTierRequirement());
			KEPLER22B_SPACE_STATION.setDimensionInfo(Config.KEPLER22B_SPACE_STATION_ID, Config.KEPLER22B_SPACE_STATION_STATIC_ID, WorldProviderKepler22bOrbit.class);
			KEPLER22B_SPACE_STATION.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/space_station.png"));
			KEPLER22B_SPACE_STATION.addChecklistKeys("thermal_padding", "equip_oxygen_suit", "equip_parachute");
			KEPLER22B_SPACE_STATION.setBiomeInfo(BiomeOrbit.space);
		}
	}

	private static void registerSatellites() {
		if (Config.MERCURY_SPACE_STATION && Config.MERCURY) {
			GalaxyRegistry.registerSatellite(MERCURY_SPACE_STATION);
			GalacticraftRegistry.registerTeleportType(WorldProviderMercuryOrbit.class, new TeleportTypeMercuryOrbit());
			GalacticraftRegistry.registerDimension("Mercury Space Station", "_mercury_orbit", Config.MERCURY_SPACE_STATION_ID, WorldProviderMercuryOrbit.class, false);
			GalacticraftRegistry.registerDimension("Mercury Space Station", "_mercury_orbit", Config.MERCURY_SPACE_STATION_STATIC_ID, WorldProviderMercuryOrbit.class, true);
		}
		if (Config.VENUS_SPACE_STATION) {
			GalaxyRegistry.registerSatellite(VENUS_SPACE_STATION);
			GalacticraftRegistry.registerTeleportType(WorldProviderVenusOrbit.class, new TeleportTypeVenusOrbit());
			GalacticraftRegistry.registerDimension("Venus Space Station", "_venus_orbit", Config.VENUS_SPACE_STATION_ID, WorldProviderVenusOrbit.class, false);
			GalacticraftRegistry.registerDimension("Venus Space Station", "_venus_orbit", Config.VENUS_SPACE_STATION_STATIC_ID, WorldProviderVenusOrbit.class, true);
		}
		if (Config.CERES_SPACE_STATION && Config.CERES) {
			GalaxyRegistry.registerSatellite(CERES_SPACE_STATION);
			GalacticraftRegistry.registerTeleportType(WorldProviderCeresOrbit.class, new TeleportTypeCeresOrbit());
			GalacticraftRegistry.registerDimension("Ceres Space Station", "_ceres_orbit", Config.CERES_SPACE_STATION_ID, WorldProviderCeresOrbit.class, false);
			GalacticraftRegistry.registerDimension("Ceres Space Station", "_ceres_orbit", Config.CERES_SPACE_STATION_STATIC_ID, WorldProviderCeresOrbit.class, true);
		}
		if (Config.MARS_SPACE_STATION && MarsModule.planetMars != null) {
			GalaxyRegistry.registerSatellite(MARS_SPACE_STATION);
			GalacticraftRegistry.registerTeleportType(WorldProviderMarsOrbit.class, new TeleportTypeMarsOrbit());
			GalacticraftRegistry.registerDimension("Mars Space Station", "_mars_orbit", Config.MARS_SPACE_STATION_ID, WorldProviderMarsOrbit.class, false);
			GalacticraftRegistry.registerDimension("Mars Space Station", "_mars_orbit", Config.MARS_SPACE_STATION_STATIC_ID, WorldProviderMarsOrbit.class, true);
		}
		if (Config.JUPITER_SPACE_STATION && Config.JUPITER) {
			GalaxyRegistry.registerSatellite(JUPITER_SPACE_STATION);
			GalacticraftRegistry.registerTeleportType(WorldProviderJupiterOrbit.class, new TeleportTypeJupiterOrbit());
			GalacticraftRegistry.registerDimension("Jupiter Space Station", "_jupiter_orbit", Config.JUPITER_SPACE_STATION_ID, WorldProviderJupiterOrbit.class, false);
			GalacticraftRegistry.registerDimension("Jupiter Space Station", "_jupiter_orbit", Config.JUPITER_SPACE_STATION_STATIC_ID, WorldProviderJupiterOrbit.class, true);
		}
		if (Config.SATURN_SPACE_STATION && Config.SATURN) {
			GalaxyRegistry.registerSatellite(SATURN_SPACE_STATION);
			GalacticraftRegistry.registerTeleportType(WorldProviderSaturnOrbit.class, new TeleportTypeSaturnOrbit());
			GalacticraftRegistry.registerDimension("Saturn Space Station", "_saturn_orbit", Config.SATURN_SPACE_STATION_ID, WorldProviderSaturnOrbit.class, false);
			GalacticraftRegistry.registerDimension("Saturn Space Station", "_saturn_orbit", Config.SATURN_SPACE_STATION_STATIC_ID, WorldProviderSaturnOrbit.class, true);
		}
		if (Config.URANUS_SPACE_STATION && Config.URANUS) {
			GalaxyRegistry.registerSatellite(URANUS_SPACE_STATION);
			GalacticraftRegistry.registerTeleportType(WorldProviderUranusOrbit.class, new TeleportTypeUranusOrbit());
			GalacticraftRegistry.registerDimension("Uranus Space Station", "_uranus_orbit", Config.URANUS_SPACE_STATION_ID, WorldProviderUranusOrbit.class, false);
			GalacticraftRegistry.registerDimension("Uranus Space Station", "_uranus_orbit", Config.URANUS_SPACE_STATION_STATIC_ID, WorldProviderUranusOrbit.class, true);
		}
		if (Config.NEPTUNE_SPACE_STATION && Config.NEPTUNE) {
			GalaxyRegistry.registerSatellite(NEPTUNE_SPACE_STATION);
			GalacticraftRegistry.registerTeleportType(WorldProviderNeptuneOrbit.class, new TeleportTypeNeptuneOrbit());
			GalacticraftRegistry.registerDimension("Neptune Space Station", "_neptune_orbit", Config.NEPTUNE_SPACE_STATION_ID, WorldProviderNeptuneOrbit.class, false);
			GalacticraftRegistry.registerDimension("Neptune Space Station", "_neptune_orbit", Config.NEPTUNE_SPACE_STATION_STATIC_ID, WorldProviderNeptuneOrbit.class, true);
		}
		if (Config.PLUTO_SPACE_STATION && Config.PLUTO) {
			GalaxyRegistry.registerSatellite(PLUTO_SPACE_STATION);
			GalacticraftRegistry.registerTeleportType(WorldProviderPlutoOrbit.class, new TeleportTypePlutoOrbit());
			GalacticraftRegistry.registerDimension("Pluto Space Station", "_pluto_orbit", Config.PLUTO_SPACE_STATION_ID, WorldProviderPlutoOrbit.class, false);
			GalacticraftRegistry.registerDimension("Pluto Space Station", "_pluto_orbit", Config.PLUTO_SPACE_STATION_STATIC_ID, WorldProviderPlutoOrbit.class, true);
		}
		if (Config.ERIS_SPACE_STATION && Config.ERIS) {
			GalaxyRegistry.registerSatellite(ERIS_SPACE_STATION);
			GalacticraftRegistry.registerTeleportType(WorldProviderErisOrbit.class, new TeleportTypeErisOrbit());
			GalacticraftRegistry.registerDimension("Eris Space Station", "_eris_orbit", Config.ERIS_SPACE_STATION_ID, WorldProviderErisOrbit.class, false);
			GalacticraftRegistry.registerDimension("Eris Space Station", "_eris_orbit", Config.ERIS_SPACE_STATION_STATIC_ID, WorldProviderErisOrbit.class, true);
		}
		if (Config.KEPLER22B_SPACE_STATION && Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			GalaxyRegistry.registerSatellite(KEPLER22B_SPACE_STATION);
			GalacticraftRegistry.registerTeleportType(WorldProviderKepler22bOrbit.class, new TeleportTypeKepler22bOrbit());
			GalacticraftRegistry.registerDimension("Kepler22b Space Station", "_kepler22b_orbit", Config.KEPLER22B_SPACE_STATION_ID, WorldProviderKepler22bOrbit.class, false);
			GalacticraftRegistry.registerDimension("Kepler22b Space Station", "_kepler22b_orbit", Config.KEPLER22B_SPACE_STATION_STATIC_ID, WorldProviderKepler22bOrbit.class, true);
		}
	}
}
