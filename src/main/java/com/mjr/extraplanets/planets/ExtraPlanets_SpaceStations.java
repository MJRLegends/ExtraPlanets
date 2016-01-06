package com.mjr.extraplanets.planets;

import java.util.HashMap;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Satellite;
import micdoodle8.mods.galacticraft.api.recipe.SpaceStationRecipe;
import micdoodle8.mods.galacticraft.api.world.SpaceStationType;
import micdoodle8.mods.galacticraft.planets.mars.MarsModule;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.planets.Ceres.spacestation.TeleportTypeCeresOrbit;
import com.mjr.extraplanets.planets.Ceres.spacestation.WorldProviderCeresOrbit;
import com.mjr.extraplanets.planets.Eris.spacestation.TeleportTypeErisOrbit;
import com.mjr.extraplanets.planets.Eris.spacestation.WorldProviderErisOrbit;
import com.mjr.extraplanets.planets.Jupiter.spacestation.TeleportTypeJupiterOrbit;
import com.mjr.extraplanets.planets.Jupiter.spacestation.WorldProviderJupiterOrbit;
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
import com.mjr.extraplanets.planets.Venus.spacestation.TeleportTypeVenusOrbit;
import com.mjr.extraplanets.planets.Venus.spacestation.WorldProviderVenusOrbit;
import com.mjr.extraplanets.planets.mars.spacestation.TeleportTypeMarsOrbit;
import com.mjr.extraplanets.planets.mars.spacestation.WorldProviderMarsOrbit;

public class ExtraPlanets_SpaceStations {

	public static Satellite mercurySpaceStation;
	public static Satellite venusSpaceStation;
	public static Satellite ceresSpaceStation;
	public static Satellite marsSpaceStation;
	public static Satellite jupiterSpaceStation;
	public static Satellite saturnSpaceStation;
	public static Satellite uranusSpaceStation;
	public static Satellite neptuneSpaceStation;
	public static Satellite plutoSpaceStation;
	public static Satellite erisSpaceStation;

	public static void init() {
		initializeSatellites();
		registerSatellites();
		registerSatellitesRecipes();
	}

	private static void initializeSatellites() {
		mercurySpaceStation = new Satellite("spaceStation.mercury").setParentBody(ExtraPlanets_Planets.mercury);
		mercurySpaceStation.setRelativeSize(0.2667F);
		mercurySpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8.5F, 8.5F));
		mercurySpaceStation.setRelativeOrbitTime(20.0F);
		mercurySpaceStation.setTierRequired(4);
		mercurySpaceStation.setDimensionInfo(Config.mercurySpaceStationID, Config.mercurySpaceStationStaticID, WorldProviderMercuryOrbit.class);
		mercurySpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));

		venusSpaceStation = new Satellite("spaceStation.venus").setParentBody(ExtraPlanets_Planets.venus);
		venusSpaceStation.setRelativeSize(0.2667F);
		venusSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8.5F, 8.5F));
		venusSpaceStation.setRelativeOrbitTime(20.0F);
		venusSpaceStation.setTierRequired(4);
		venusSpaceStation.setDimensionInfo(Config.venusSpaceStationID, Config.venusSpaceStationStaticID, WorldProviderVenusOrbit.class);
		venusSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));

		ceresSpaceStation = new Satellite("spaceStation.ceres").setParentBody(ExtraPlanets_Planets.ceres);
		ceresSpaceStation.setRelativeSize(0.2667F);
		ceresSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8.5F, 8.5F));
		ceresSpaceStation.setRelativeOrbitTime(20.0F);
		ceresSpaceStation.setTierRequired(4);
		ceresSpaceStation.setDimensionInfo(Config.ceresSpaceStationID, Config.ceresSpaceStationStaticID, WorldProviderCeresOrbit.class);
		ceresSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));

		marsSpaceStation = new Satellite("spaceStation.mars").setParentBody(MarsModule.planetMars);
		marsSpaceStation.setRelativeSize(0.2667F);
		marsSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8.5F, 8.5F));
		marsSpaceStation.setRelativeOrbitTime(20.0F);
		marsSpaceStation.setTierRequired(4);
		marsSpaceStation.setDimensionInfo(Config.marsSpaceStationID, Config.marsSpaceStationStaticID, WorldProviderMarsOrbit.class);
		marsSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));

		jupiterSpaceStation = new Satellite("spaceStation.jupiter").setParentBody(ExtraPlanets_Planets.jupiter);
		jupiterSpaceStation.setRelativeSize(0.2667F);
		jupiterSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8.5F, 8.5F));
		jupiterSpaceStation.setRelativeOrbitTime(20.0F);
		jupiterSpaceStation.setTierRequired(4);
		jupiterSpaceStation.setDimensionInfo(Config.jupiterSpaceStationID, Config.jupiterSpaceStationStaticID, WorldProviderJupiterOrbit.class);
		jupiterSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));

		saturnSpaceStation = new Satellite("spaceStation.saturn").setParentBody(ExtraPlanets_Planets.saturn);
		saturnSpaceStation.setRelativeSize(0.2667F);
		saturnSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8.5F, 8.5F));
		saturnSpaceStation.setRelativeOrbitTime(20.0F);
		saturnSpaceStation.setTierRequired(4);
		saturnSpaceStation.setDimensionInfo(Config.saturnSpaceStationID, Config.saturnSpaceStationStaticID, WorldProviderSaturnOrbit.class);
		saturnSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));

		uranusSpaceStation = new Satellite("spaceStation.uranus").setParentBody(ExtraPlanets_Planets.uranus);
		uranusSpaceStation.setRelativeSize(0.2667F);
		uranusSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8.5F, 8.5F));
		uranusSpaceStation.setRelativeOrbitTime(20.0F);
		uranusSpaceStation.setTierRequired(4);
		uranusSpaceStation.setDimensionInfo(Config.uranusSpaceStationID, Config.uranusSpaceStationStaticID, WorldProviderUranusOrbit.class);
		uranusSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));

		neptuneSpaceStation = new Satellite("spaceStation.neptune").setParentBody(ExtraPlanets_Planets.neptune);
		neptuneSpaceStation.setRelativeSize(0.2667F);
		neptuneSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8.5F, 8.5F));
		neptuneSpaceStation.setRelativeOrbitTime(20.0F);
		neptuneSpaceStation.setTierRequired(4);
		neptuneSpaceStation.setDimensionInfo(Config.neptuneSpaceStationID, Config.neptuneSpaceStationStaticID, WorldProviderNeptuneOrbit.class);
		neptuneSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));

		plutoSpaceStation = new Satellite("spaceStation.pluto").setParentBody(ExtraPlanets_Planets.pluto);
		plutoSpaceStation.setRelativeSize(0.2667F);
		plutoSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8.5F, 8.5F));
		plutoSpaceStation.setRelativeOrbitTime(20.0F);
		plutoSpaceStation.setTierRequired(4);
		plutoSpaceStation.setDimensionInfo(Config.plutoSpaceStationID, Config.plutoSpaceStationStaticID, WorldProviderPlutoOrbit.class);
		plutoSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));

		erisSpaceStation = new Satellite("spaceStation.eris").setParentBody(ExtraPlanets_Planets.eris);
		erisSpaceStation.setRelativeSize(0.2667F);
		erisSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8.5F, 8.5F));
		erisSpaceStation.setRelativeOrbitTime(20.0F);
		erisSpaceStation.setTierRequired(4);
		erisSpaceStation.setDimensionInfo(Config.erisSpaceStationID, Config.erisSpaceStationStaticID, WorldProviderErisOrbit.class);
		erisSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));
	}

	private static void registerSatellites() {
		GalaxyRegistry.registerSatellite(mercurySpaceStation);
		GalacticraftRegistry.registerTeleportType(WorldProviderMercuryOrbit.class, new TeleportTypeMercuryOrbit());
		GalacticraftRegistry.registerProvider(Config.mercurySpaceStationID, WorldProviderMercuryOrbit.class, false);
		GalacticraftRegistry.registerProvider(Config.mercurySpaceStationStaticID, WorldProviderMercuryOrbit.class, true);

		GalaxyRegistry.registerSatellite(venusSpaceStation);
		GalacticraftRegistry.registerTeleportType(WorldProviderVenusOrbit.class, new TeleportTypeVenusOrbit());
		GalacticraftRegistry.registerProvider(Config.venusSpaceStationID, WorldProviderVenusOrbit.class, false);
		GalacticraftRegistry.registerProvider(Config.venusSpaceStationStaticID, WorldProviderVenusOrbit.class, true);

		GalaxyRegistry.registerSatellite(ceresSpaceStation);
		GalacticraftRegistry.registerTeleportType(WorldProviderCeresOrbit.class, new TeleportTypeCeresOrbit());
		GalacticraftRegistry.registerProvider(Config.ceresSpaceStationID, WorldProviderCeresOrbit.class, false);
		GalacticraftRegistry.registerProvider(Config.ceresSpaceStationStaticID, WorldProviderCeresOrbit.class, true);

		GalaxyRegistry.registerSatellite(marsSpaceStation);
		GalacticraftRegistry.registerTeleportType(WorldProviderMarsOrbit.class, new TeleportTypeMarsOrbit());
		GalacticraftRegistry.registerProvider(Config.marsSpaceStationID, WorldProviderMarsOrbit.class, false);
		GalacticraftRegistry.registerProvider(Config.marsSpaceStationStaticID, WorldProviderMarsOrbit.class, true);

		GalaxyRegistry.registerSatellite(jupiterSpaceStation);
		GalacticraftRegistry.registerTeleportType(WorldProviderJupiterOrbit.class, new TeleportTypeJupiterOrbit());
		GalacticraftRegistry.registerProvider(Config.jupiterSpaceStationID, WorldProviderJupiterOrbit.class, false);
		GalacticraftRegistry.registerProvider(Config.jupiterSpaceStationStaticID, WorldProviderJupiterOrbit.class, true);

		GalaxyRegistry.registerSatellite(saturnSpaceStation);
		GalacticraftRegistry.registerTeleportType(WorldProviderSaturnOrbit.class, new TeleportTypeSaturnOrbit());
		GalacticraftRegistry.registerProvider(Config.saturnSpaceStationID, WorldProviderSaturnOrbit.class, false);
		GalacticraftRegistry.registerProvider(Config.saturnSpaceStationStaticID, WorldProviderSaturnOrbit.class, true);

		GalaxyRegistry.registerSatellite(uranusSpaceStation);
		GalacticraftRegistry.registerTeleportType(WorldProviderUranusOrbit.class, new TeleportTypeUranusOrbit());
		GalacticraftRegistry.registerProvider(Config.uranusSpaceStationID, WorldProviderUranusOrbit.class, false);
		GalacticraftRegistry.registerProvider(Config.uranusSpaceStationStaticID, WorldProviderUranusOrbit.class, true);

		GalaxyRegistry.registerSatellite(neptuneSpaceStation);
		GalacticraftRegistry.registerTeleportType(WorldProviderNeptuneOrbit.class, new TeleportTypeNeptuneOrbit());
		GalacticraftRegistry.registerProvider(Config.neptuneSpaceStationID, WorldProviderNeptuneOrbit.class, false);
		GalacticraftRegistry.registerProvider(Config.neptuneSpaceStationStaticID, WorldProviderNeptuneOrbit.class, true);

		GalaxyRegistry.registerSatellite(plutoSpaceStation);
		GalacticraftRegistry.registerTeleportType(WorldProviderPlutoOrbit.class, new TeleportTypePlutoOrbit());
		GalacticraftRegistry.registerProvider(Config.plutoSpaceStationID, WorldProviderPlutoOrbit.class, false);
		GalacticraftRegistry.registerProvider(Config.plutoSpaceStationStaticID, WorldProviderPlutoOrbit.class, true);

		GalaxyRegistry.registerSatellite(erisSpaceStation);
		GalacticraftRegistry.registerTeleportType(WorldProviderErisOrbit.class, new TeleportTypeErisOrbit());
		GalacticraftRegistry.registerProvider(Config.erisSpaceStationID, WorldProviderErisOrbit.class, false);
		GalacticraftRegistry.registerProvider(Config.erisSpaceStationStaticID, WorldProviderErisOrbit.class, true);
	}

	private static void registerSatellitesRecipes() {
		final HashMap<Object, Integer> inputMap = new HashMap<Object, Integer>();
		inputMap.put("ingotTin", 32);
		inputMap.put("waferAdvanced", 1);
		inputMap.put(Items.iron_ingot, 24);
		GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.mercurySpaceStationID, Config.mercuryID, new SpaceStationRecipe(inputMap)));
		GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.venusSpaceStationID, Config.venusID, new SpaceStationRecipe(inputMap)));
		GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.ceresSpaceStationID, Config.ceresID, new SpaceStationRecipe(inputMap)));
		GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.marsSpaceStationID, MarsModule.planetMars.getDimensionID(), new SpaceStationRecipe(inputMap)));
		GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.jupiterSpaceStationID, Config.jupiterID, new SpaceStationRecipe(inputMap)));
		GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.saturnSpaceStationID, Config.saturnID, new SpaceStationRecipe(inputMap)));
		GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.uranusSpaceStationID, Config.uranusID, new SpaceStationRecipe(inputMap)));
		GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.neptuneSpaceStationID, Config.neptuneID, new SpaceStationRecipe(inputMap)));
		GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.plutoSpaceStationID, Config.plutoID, new SpaceStationRecipe(inputMap)));
		GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.erisSpaceStationID, Config.erisID, new SpaceStationRecipe(inputMap)));
		;
	}
}
