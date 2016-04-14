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
	}

	private static void initializeSatellites() {
		if (Config.mercurySpaceStation) {
			mercurySpaceStation = new Satellite("spaceStation.mercury").setParentBody(ExtraPlanets_Planets.mercury);
			mercurySpaceStation.setRelativeSize(0.2667F);
			mercurySpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			mercurySpaceStation.setRelativeOrbitTime(20.0F);
			mercurySpaceStation.setTierRequired(Config.mercuryRocketTier);
			mercurySpaceStation.setDimensionInfo(Config.mercurySpaceStationID, Config.mercurySpaceStationStaticID, WorldProviderMercuryOrbit.class);
			mercurySpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));
		}
		if (Config.venusSpaceStation) {
			venusSpaceStation = new Satellite("spaceStation.venus").setParentBody(ExtraPlanets_Planets.venus);
			venusSpaceStation.setRelativeSize(0.2667F);
			venusSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			venusSpaceStation.setRelativeOrbitTime(20.0F);
			venusSpaceStation.setTierRequired(3);
			venusSpaceStation.setDimensionInfo(Config.venusSpaceStationID, Config.venusSpaceStationStaticID, WorldProviderVenusOrbit.class);
			venusSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));
		}
		if (Config.ceresSpaceStation) {
			ceresSpaceStation = new Satellite("spaceStation.ceres").setParentBody(ExtraPlanets_Planets.ceres);
			ceresSpaceStation.setRelativeSize(0.2667F);
			ceresSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			ceresSpaceStation.setRelativeOrbitTime(20.0F);
			ceresSpaceStation.setTierRequired(Config.ceresRocketTier);
			ceresSpaceStation.setDimensionInfo(Config.ceresSpaceStationID, Config.ceresSpaceStationStaticID, WorldProviderCeresOrbit.class);
			ceresSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));
		}
		if (Config.marsSpaceStation) {
			marsSpaceStation = new Satellite("spaceStation.mars").setParentBody(MarsModule.planetMars);
			marsSpaceStation.setRelativeSize(0.2667F);
			marsSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			marsSpaceStation.setRelativeOrbitTime(20.0F);
			marsSpaceStation.setTierRequired(4);
			marsSpaceStation.setDimensionInfo(Config.marsSpaceStationID, Config.marsSpaceStationStaticID, WorldProviderMarsOrbit.class);
			marsSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));
		}
		if (Config.jupiterSpaceStation) {
			jupiterSpaceStation = new Satellite("spaceStation.jupiter").setParentBody(ExtraPlanets_Planets.jupiter);
			jupiterSpaceStation.setRelativeSize(0.2667F);
			jupiterSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			jupiterSpaceStation.setRelativeOrbitTime(20.0F);
			jupiterSpaceStation.setTierRequired(4);
			jupiterSpaceStation.setDimensionInfo(Config.jupiterSpaceStationID, Config.jupiterSpaceStationStaticID, WorldProviderJupiterOrbit.class);
			jupiterSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));
		}
		if (Config.saturnSpaceStation) {
			saturnSpaceStation = new Satellite("spaceStation.saturn").setParentBody(ExtraPlanets_Planets.saturn);
			saturnSpaceStation.setRelativeSize(0.2667F);
			saturnSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			saturnSpaceStation.setRelativeOrbitTime(20.0F);
			saturnSpaceStation.setTierRequired(5);
			saturnSpaceStation.setDimensionInfo(Config.saturnSpaceStationID, Config.saturnSpaceStationStaticID, WorldProviderSaturnOrbit.class);
			saturnSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));
		}
		if (Config.uranusSpaceStation) {
			uranusSpaceStation = new Satellite("spaceStation.uranus").setParentBody(ExtraPlanets_Planets.uranus);
			uranusSpaceStation.setRelativeSize(0.2667F);
			uranusSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			uranusSpaceStation.setRelativeOrbitTime(20.0F);
			uranusSpaceStation.setTierRequired(6);
			uranusSpaceStation.setDimensionInfo(Config.uranusSpaceStationID, Config.uranusSpaceStationStaticID, WorldProviderUranusOrbit.class);
			uranusSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));
		}
		if (Config.neptuneSpaceStation) {
			neptuneSpaceStation = new Satellite("spaceStation.neptune").setParentBody(ExtraPlanets_Planets.neptune);
			neptuneSpaceStation.setRelativeSize(0.2667F);
			neptuneSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			neptuneSpaceStation.setRelativeOrbitTime(20.0F);
			neptuneSpaceStation.setTierRequired(7);
			neptuneSpaceStation.setDimensionInfo(Config.neptuneSpaceStationID, Config.neptuneSpaceStationStaticID, WorldProviderNeptuneOrbit.class);
			neptuneSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));
		}
		if (Config.plutoSpaceStation) {
			plutoSpaceStation = new Satellite("spaceStation.pluto").setParentBody(ExtraPlanets_Planets.pluto);
			plutoSpaceStation.setRelativeSize(0.2667F);
			plutoSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			plutoSpaceStation.setRelativeOrbitTime(20.0F);
			plutoSpaceStation.setTierRequired(8);
			plutoSpaceStation.setDimensionInfo(Config.plutoSpaceStationID, Config.plutoSpaceStationStaticID, WorldProviderPlutoOrbit.class);
			plutoSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));
		}
		if (Config.erisSpaceStation) {
			erisSpaceStation = new Satellite("spaceStation.eris").setParentBody(ExtraPlanets_Planets.eris);
			erisSpaceStation.setRelativeSize(0.2667F);
			erisSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(5.5F, 5.5F));
			erisSpaceStation.setRelativeOrbitTime(20.0F);
			erisSpaceStation.setTierRequired(Config.erisRocketTier);
			erisSpaceStation.setDimensionInfo(Config.erisSpaceStationID, Config.erisSpaceStationStaticID, WorldProviderErisOrbit.class);
			erisSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));
		}
	}

	private static void registerSatellites() {
		if (Config.mercurySpaceStation && Config.mercury) {
			GalaxyRegistry.registerSatellite(mercurySpaceStation);
			GalacticraftRegistry.registerTeleportType(WorldProviderMercuryOrbit.class, new TeleportTypeMercuryOrbit());
			GalacticraftRegistry.registerProvider(Config.mercurySpaceStationID, WorldProviderMercuryOrbit.class, false, 0);
			GalacticraftRegistry.registerProvider(Config.mercurySpaceStationStaticID, WorldProviderMercuryOrbit.class, true, 0);
		}
		if (Config.venusSpaceStation && Config.venus) {
			GalaxyRegistry.registerSatellite(venusSpaceStation);
			GalacticraftRegistry.registerTeleportType(WorldProviderVenusOrbit.class, new TeleportTypeVenusOrbit());
			GalacticraftRegistry.registerProvider(Config.venusSpaceStationID, WorldProviderVenusOrbit.class, false, 0);
			GalacticraftRegistry.registerProvider(Config.venusSpaceStationStaticID, WorldProviderVenusOrbit.class, true, 0);
		}
		if (Config.ceresSpaceStation && Config.ceres) {
			GalaxyRegistry.registerSatellite(ceresSpaceStation);
			GalacticraftRegistry.registerTeleportType(WorldProviderCeresOrbit.class, new TeleportTypeCeresOrbit());
			GalacticraftRegistry.registerProvider(Config.ceresSpaceStationID, WorldProviderCeresOrbit.class, false, 0);
			GalacticraftRegistry.registerProvider(Config.ceresSpaceStationStaticID, WorldProviderCeresOrbit.class, true, 0);
		}
		if (Config.marsSpaceStation) {
			GalaxyRegistry.registerSatellite(marsSpaceStation);
			GalacticraftRegistry.registerTeleportType(WorldProviderMarsOrbit.class, new TeleportTypeMarsOrbit());
			GalacticraftRegistry.registerProvider(Config.marsSpaceStationID, WorldProviderMarsOrbit.class, false, 0);
			GalacticraftRegistry.registerProvider(Config.marsSpaceStationStaticID, WorldProviderMarsOrbit.class, true, 0);
		}
		if (Config.jupiterSpaceStation && Config.jupiter) {
			GalaxyRegistry.registerSatellite(jupiterSpaceStation);
			GalacticraftRegistry.registerTeleportType(WorldProviderJupiterOrbit.class, new TeleportTypeJupiterOrbit());
			GalacticraftRegistry.registerProvider(Config.jupiterSpaceStationID, WorldProviderJupiterOrbit.class, false, 0);
			GalacticraftRegistry.registerProvider(Config.jupiterSpaceStationStaticID, WorldProviderJupiterOrbit.class, true, 0);
		}
		if (Config.saturnSpaceStation && Config.saturn) {
			GalaxyRegistry.registerSatellite(saturnSpaceStation);
			GalacticraftRegistry.registerTeleportType(WorldProviderSaturnOrbit.class, new TeleportTypeSaturnOrbit());
			GalacticraftRegistry.registerProvider(Config.saturnSpaceStationID, WorldProviderSaturnOrbit.class, false, 0);
			GalacticraftRegistry.registerProvider(Config.saturnSpaceStationStaticID, WorldProviderSaturnOrbit.class, true, 0);
		}
		if (Config.uranusSpaceStation && Config.uranus) {
			GalaxyRegistry.registerSatellite(uranusSpaceStation);
			GalacticraftRegistry.registerTeleportType(WorldProviderUranusOrbit.class, new TeleportTypeUranusOrbit());
			GalacticraftRegistry.registerProvider(Config.uranusSpaceStationID, WorldProviderUranusOrbit.class, false, 0);
			GalacticraftRegistry.registerProvider(Config.uranusSpaceStationStaticID, WorldProviderUranusOrbit.class, true, 0);
		}
		if (Config.neptuneSpaceStation && Config.neptune) {
			GalaxyRegistry.registerSatellite(neptuneSpaceStation);
			GalacticraftRegistry.registerTeleportType(WorldProviderNeptuneOrbit.class, new TeleportTypeNeptuneOrbit());
			GalacticraftRegistry.registerProvider(Config.neptuneSpaceStationID, WorldProviderNeptuneOrbit.class, false, 0);
			GalacticraftRegistry.registerProvider(Config.neptuneSpaceStationStaticID, WorldProviderNeptuneOrbit.class, true, 0);
		}
		if (Config.plutoSpaceStation && Config.pluto) {
			GalaxyRegistry.registerSatellite(plutoSpaceStation);
			GalacticraftRegistry.registerTeleportType(WorldProviderPlutoOrbit.class, new TeleportTypePlutoOrbit());
			GalacticraftRegistry.registerProvider(Config.plutoSpaceStationID, WorldProviderPlutoOrbit.class, false, 0);
			GalacticraftRegistry.registerProvider(Config.plutoSpaceStationStaticID, WorldProviderPlutoOrbit.class, true, 0);
		}
		if (Config.erisSpaceStation && Config.eris) {
			GalaxyRegistry.registerSatellite(erisSpaceStation);
			GalacticraftRegistry.registerTeleportType(WorldProviderErisOrbit.class, new TeleportTypeErisOrbit());
			GalacticraftRegistry.registerProvider(Config.erisSpaceStationID, WorldProviderErisOrbit.class, false, 0);
			GalacticraftRegistry.registerProvider(Config.erisSpaceStationStaticID, WorldProviderErisOrbit.class, true, 0);
		}
	}
}
