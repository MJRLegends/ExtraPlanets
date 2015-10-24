package com.mjr.extraplanets.planets;

import java.util.HashMap;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.galaxies.Satellite;
import micdoodle8.mods.galacticraft.api.recipe.SpaceStationRecipe;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;
import micdoodle8.mods.galacticraft.api.world.SpaceStationType;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.planets.mars.MarsModule;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.planets.Ceres.TeleportTypeCeres;
import com.mjr.extraplanets.planets.Ceres.WorldProviderCeres;
import com.mjr.extraplanets.planets.Ceres.spacestation.TeleportTypeCeresOrbit;
import com.mjr.extraplanets.planets.Ceres.spacestation.WorldProviderCeresOrbit;
import com.mjr.extraplanets.planets.Eris.TeleportTypeEris;
import com.mjr.extraplanets.planets.Eris.WorldProviderEris;
import com.mjr.extraplanets.planets.Eris.spacestation.TeleportTypeErisOrbit;
import com.mjr.extraplanets.planets.Eris.spacestation.WorldProviderErisOrbit;
import com.mjr.extraplanets.planets.Jupiter.TeleportTypeJupiter;
import com.mjr.extraplanets.planets.Jupiter.WorldProviderJupiter;
import com.mjr.extraplanets.planets.Jupiter.spacestation.TeleportTypeJupiterOrbit;
import com.mjr.extraplanets.planets.Jupiter.spacestation.WorldProviderJupiterOrbit;
import com.mjr.extraplanets.planets.Mercury.TeleportTypeMercury;
import com.mjr.extraplanets.planets.Mercury.WorldProviderMercury;
import com.mjr.extraplanets.planets.Mercury.spacestation.TeleportTypeMercuryOrbit;
import com.mjr.extraplanets.planets.Mercury.spacestation.WorldProviderMercuryOrbit;
import com.mjr.extraplanets.planets.Neptune.TeleportTypeNeptune;
import com.mjr.extraplanets.planets.Neptune.WorldProviderNeptune;
import com.mjr.extraplanets.planets.Neptune.spacestation.TeleportTypeNeptuneOrbit;
import com.mjr.extraplanets.planets.Neptune.spacestation.WorldProviderNeptuneOrbit;
import com.mjr.extraplanets.planets.Pluto.TeleportTypePluto;
import com.mjr.extraplanets.planets.Pluto.WorldProviderPluto;
import com.mjr.extraplanets.planets.Pluto.spacestation.TeleportTypePlutoOrbit;
import com.mjr.extraplanets.planets.Pluto.spacestation.WorldProviderPlutoOrbit;
import com.mjr.extraplanets.planets.Saturn.TeleportTypeSaturn;
import com.mjr.extraplanets.planets.Saturn.WorldProviderSaturn;
import com.mjr.extraplanets.planets.Saturn.spacestation.TeleportTypeSaturnOrbit;
import com.mjr.extraplanets.planets.Saturn.spacestation.WorldProviderSaturnOrbit;
import com.mjr.extraplanets.planets.Uranus.TeleportTypeUranus;
import com.mjr.extraplanets.planets.Uranus.WorldProviderUranus;
import com.mjr.extraplanets.planets.Uranus.spacestation.TeleportTypeUranusOrbit;
import com.mjr.extraplanets.planets.Uranus.spacestation.WorldProviderUranusOrbit;
import com.mjr.extraplanets.planets.Venus.TeleportTypeVenus;
import com.mjr.extraplanets.planets.Venus.WorldProviderVenus;
import com.mjr.extraplanets.planets.Venus.spacestation.TeleportTypeVenusOrbit;
import com.mjr.extraplanets.planets.Venus.spacestation.WorldProviderVenusOrbit;
import com.mjr.extraplanets.planets.mars.spacestation.TeleportTypeMarsOrbit;
import com.mjr.extraplanets.planets.mars.spacestation.WorldProviderMarsOrbit;

public class PlanetsMain {
	public static Planet mercury;
	public static Planet venus;
	public static Planet ceres;
	public static Planet jupiter;
	public static Planet saturn;
	public static Planet uranus;
	public static Planet neptune;
	public static Planet pluto;
	public static Planet eris;
	public static Planet kuiperBelt;
	
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
		initializePlanets();
		initializeSatellites();
		registerPlanets();
		registerSatellites();
		registerSatellitesRecipes();
	}

	private static void initializePlanets() {
		if (Config.mercury) {
			mercury = new Planet("Mercury").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			mercury.setTierRequired(Config.mercuryRocketTier);
			mercury.setRingColorRGB(0.1F, 0.9F, 0.6F);
			mercury.setPhaseShift(1.45F);
			mercury.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.5F, 0.5F));
			mercury.setRelativeOrbitTime(0.24096385542168674698795180722892F);
			mercury.atmosphereComponent(IAtmosphericGas.HYDROGEN);
			mercury.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/mercury.png"));
			mercury.setDimensionInfo(Config.mercuryID, WorldProviderMercury.class);
		}
		if (Config.venus) {
			venus = new Planet("Venus").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			venus.setTierRequired(3);
			venus.setRingColorRGB(0.1F, 0.9F, 0.6F);
			venus.setPhaseShift(2.0F);
			venus.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.75F, 0.75F));
			venus.setRelativeOrbitTime(0.61527929901423877327491785323111F);
			venus.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.CO2);
			venus.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/venus.png"));
			venus.setDimensionInfo(Config.venusID, WorldProviderVenus.class);
		}
		if (Config.ceres) {
			ceres = new Planet("Ceres").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			ceres.setTierRequired(Config.ceresRocketTier);
			ceres.setRingColorRGB(0.1F, 0.9F, 0.6F);
			ceres.setPhaseShift((float) Math.PI);
			ceres.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.50F, 1.50F));
			ceres.setRelativeOrbitTime(11.861993428258488499452354874042F);
			ceres.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM);
			ceres.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/ceres.png"));
			ceres.setDimensionInfo(Config.ceresID, WorldProviderCeres.class);
		}
		if (Config.jupiter) {
			jupiter = new Planet("Jupiter").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			jupiter.setTierRequired(4);
			jupiter.setRingColorRGB(0.1F, 0.9F, 0.6F);
			jupiter.setPhaseShift((float) Math.PI);
			jupiter.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.75F, 1.75F));
			jupiter.setRelativeOrbitTime(11.861993428258488499452354874042F);
			jupiter.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM);
			jupiter.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/jupiter.png"));
			jupiter.setDimensionInfo(Config.jupiterID, WorldProviderJupiter.class);
		}
		if (Config.saturn) {
			saturn = new Planet("Saturn").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			saturn.setTierRequired(5);
			saturn.setRingColorRGB(0.1F, 0.9F, 0.6F);
			saturn.setPhaseShift(5.45F);
			saturn.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.00F, 1.00F));
			saturn.setRelativeOrbitTime(29.463307776560788608981380065717F);
			saturn.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM)
			.atmosphereComponent(IAtmosphericGas.METHANE);
			saturn.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/saturn.png"));
			saturn.setDimensionInfo(Config.saturnID, WorldProviderSaturn.class);
		}
		if (Config.uranus) {
			uranus = new Planet("Uranus").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			uranus.setTierRequired(6);
			uranus.setRingColorRGB(0.1F, 0.9F, 0.6F);
			uranus.setPhaseShift(1.38F);
			uranus.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.25F, 2.25F));
			uranus.setRelativeOrbitTime(84.063526834611171960569550930997F);
			uranus.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM)
			.atmosphereComponent(IAtmosphericGas.METHANE).atmosphereComponent(IAtmosphericGas.WATER);
			uranus.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/uranus.png"));
			uranus.setDimensionInfo(Config.uranusID, WorldProviderUranus.class);
		}
		if (Config.neptune) {
			neptune = new Planet("Neptune").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			neptune.setTierRequired(7);
			neptune.setRingColorRGB(0.1F, 0.9F, 0.6F);
			neptune.setPhaseShift(1.0F);
			neptune.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.50F, 2.50F));
			neptune.setRelativeOrbitTime(164.84118291347207009857612267251F);
			neptune.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM)
			.atmosphereComponent(IAtmosphericGas.WATER);
			neptune.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/neptune.png"));
			neptune.setDimensionInfo(Config.neptuneID, WorldProviderNeptune.class);
		}
		if (Config.pluto) {
			pluto = new Planet("Pluto").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			pluto.setTierRequired(Config.plutoRocketTier);
			pluto.setRingColorRGB(0.1F, 0.9F, 0.6F);
			pluto.setPhaseShift(1.0F);
			pluto.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.75F, 2.75F));
			pluto.setRelativeOrbitTime(164.84118291347207009857612267251F);
			pluto.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM)
			.atmosphereComponent(IAtmosphericGas.WATER);
			pluto.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/pluto.png"));
			pluto.setDimensionInfo(Config.plutoID, WorldProviderPluto.class);
		}
		if (Config.eris) {
			eris = new Planet("Eris").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			eris.setTierRequired(Config.erisRocketTier);
			eris.setRingColorRGB(0.1F, 0.9F, 0.6F);
			eris.setPhaseShift(1.0F);
			eris.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(3.50F, 3.50F));
			eris.setRelativeOrbitTime(164.84118291347207009857612267251F);
			eris.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM)
			.atmosphereComponent(IAtmosphericGas.WATER);
			eris.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/eris.png"));
			eris.setDimensionInfo(Config.erisID, WorldProviderEris.class);
		}

		kuiperBelt = GalacticraftCore.instance.makeUnreachablePlanet("kuiperBelt", GalacticraftCore.solarSystemSol);
		if (kuiperBelt != null)
			kuiperBelt.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F)
			.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(4.50F, 4.50F))
			.setRelativeOrbitTime(164.84118291347207009857612267251F);
		kuiperBelt.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kuiperBelt.png"));
	}
	
	private static void initializeSatellites() {
		mercurySpaceStation = new Satellite("spaceStation.mercury").setParentBody(mercury);
		mercurySpaceStation.setRelativeSize(0.2667F);
		mercurySpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8.5F, 8.5F));
		mercurySpaceStation.setRelativeOrbitTime(20.0F);
		mercurySpaceStation.setTierRequired(4);
		mercurySpaceStation.setDimensionInfo(Config.mercurySpaceStationID,Config.mercurySpaceStationStaticID, WorldProviderMercuryOrbit.class);
		mercurySpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));
	    
	    venusSpaceStation = new Satellite("spaceStation.venus").setParentBody(venus);
	    venusSpaceStation.setRelativeSize(0.2667F);
	    venusSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8.5F, 8.5F));
	    venusSpaceStation.setRelativeOrbitTime(20.0F);
	    venusSpaceStation.setTierRequired(4);
	    venusSpaceStation.setDimensionInfo(Config.venusSpaceStationID,Config.venusSpaceStationStaticID, WorldProviderVenusOrbit.class);
	    venusSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));
	    
	    ceresSpaceStation = new Satellite("spaceStation.ceres").setParentBody(ceres);
	    ceresSpaceStation.setRelativeSize(0.2667F);
	    ceresSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8.5F, 8.5F));
	    ceresSpaceStation.setRelativeOrbitTime(20.0F);
	    ceresSpaceStation.setTierRequired(4);
	    ceresSpaceStation.setDimensionInfo(Config.ceresSpaceStationID,Config.ceresSpaceStationStaticID, WorldProviderCeresOrbit.class);
	    ceresSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));
	    
	    marsSpaceStation = new Satellite("spaceStation.mars").setParentBody(MarsModule.planetMars);
	    marsSpaceStation.setRelativeSize(0.2667F);
	    marsSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8.5F, 8.5F));
	    marsSpaceStation.setRelativeOrbitTime(20.0F);
	    marsSpaceStation.setTierRequired(4);
	    marsSpaceStation.setDimensionInfo(Config.marsSpaceStationID,Config.marsSpaceStationStaticID, WorldProviderMarsOrbit.class);
	    marsSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));
		
	    jupiterSpaceStation = new Satellite("spaceStation.jupiter").setParentBody(jupiter);
	    jupiterSpaceStation.setRelativeSize(0.2667F);
	    jupiterSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8.5F, 8.5F));
	    jupiterSpaceStation.setRelativeOrbitTime(20.0F);
	    jupiterSpaceStation.setTierRequired(4);
	    jupiterSpaceStation.setDimensionInfo(Config.jupiterSpaceStationID,Config.jupiterSpaceStationStaticID, WorldProviderJupiterOrbit.class);
	    jupiterSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));
		
	    saturnSpaceStation = new Satellite("spaceStation.saturn").setParentBody(saturn);
	    saturnSpaceStation.setRelativeSize(0.2667F);
	    saturnSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8.5F, 8.5F));
	    saturnSpaceStation.setRelativeOrbitTime(20.0F);
	    saturnSpaceStation.setTierRequired(4);
	    saturnSpaceStation.setDimensionInfo(Config.saturnSpaceStationID,Config.saturnSpaceStationStaticID, WorldProviderSaturnOrbit.class);
	    saturnSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));

	    uranusSpaceStation = new Satellite("spaceStation.uranus").setParentBody(uranus);
	    uranusSpaceStation.setRelativeSize(0.2667F);
	    uranusSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8.5F, 8.5F));
	    uranusSpaceStation.setRelativeOrbitTime(20.0F);
	    uranusSpaceStation.setTierRequired(4);
	    uranusSpaceStation.setDimensionInfo(Config.uranusSpaceStationID,Config.uranusSpaceStationStaticID, WorldProviderUranusOrbit.class);
	    uranusSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));

	    neptuneSpaceStation = new Satellite("spaceStation.neptune").setParentBody(neptune);
	    neptuneSpaceStation.setRelativeSize(0.2667F);
	    neptuneSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8.5F, 8.5F));
	    neptuneSpaceStation.setRelativeOrbitTime(20.0F);
	    neptuneSpaceStation.setTierRequired(4);
	    neptuneSpaceStation.setDimensionInfo(Config.neptuneSpaceStationID,Config.neptuneSpaceStationStaticID, WorldProviderNeptuneOrbit.class);
	    neptuneSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));

	    plutoSpaceStation = new Satellite("spaceStation.pluto").setParentBody(pluto);
	    plutoSpaceStation.setRelativeSize(0.2667F);
	    plutoSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8.5F, 8.5F));
	    plutoSpaceStation.setRelativeOrbitTime(20.0F);
	    plutoSpaceStation.setTierRequired(4);
	    plutoSpaceStation.setDimensionInfo(Config.plutoSpaceStationID,Config.plutoSpaceStationStaticID, WorldProviderPlutoOrbit.class);
	    plutoSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));

	    erisSpaceStation = new Satellite("spaceStation.eris").setParentBody(eris);
	    erisSpaceStation.setRelativeSize(0.2667F);
	    erisSpaceStation.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8.5F, 8.5F));
	    erisSpaceStation.setRelativeOrbitTime(20.0F);
	    erisSpaceStation.setTierRequired(4);
	    erisSpaceStation.setDimensionInfo(Config.erisSpaceStationID,Config.erisSpaceStationStaticID, WorldProviderErisOrbit.class);
	    erisSpaceStation.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/spaceStation.png"));
	}

	private static void registerPlanets() {
		if (Config.mercury) {
			GalaxyRegistry.registerPlanet(mercury);
			GalacticraftRegistry.registerTeleportType(WorldProviderMercury.class, new TeleportTypeMercury());
			GalacticraftRegistry.registerRocketGui(WorldProviderMercury.class, new ResourceLocation(Constants.ASSET_PREFIX,
					"textures/gui/mercuryRocketGui.png"));
		}
		if (Config.venus) {
			GalaxyRegistry.registerPlanet(venus);
			GalacticraftRegistry.registerTeleportType(WorldProviderVenus.class, new TeleportTypeVenus());
			GalacticraftRegistry.registerRocketGui(WorldProviderVenus.class, new ResourceLocation(Constants.ASSET_PREFIX,
					"textures/gui/venusRocketGui.png"));
		}
		if (Config.ceres) {
			GalaxyRegistry.registerPlanet(ceres);
			GalacticraftRegistry.registerTeleportType(WorldProviderCeres.class, new TeleportTypeCeres());
			GalacticraftRegistry.registerRocketGui(WorldProviderCeres.class, new ResourceLocation(Constants.ASSET_PREFIX,
					"textures/gui/ceresRocketGui.png"));
		}
		if (Config.jupiter) {
			GalaxyRegistry.registerPlanet(jupiter);
			GalacticraftRegistry.registerTeleportType(WorldProviderJupiter.class, new TeleportTypeJupiter());
			GalacticraftRegistry.registerRocketGui(WorldProviderJupiter.class, new ResourceLocation(Constants.ASSET_PREFIX,
					"textures/gui/jupiterRocketGui.png"));
		}
		if (Config.saturn) {
			GalaxyRegistry.registerPlanet(saturn);
			GalacticraftRegistry.registerTeleportType(WorldProviderSaturn.class, new TeleportTypeSaturn());
			GalacticraftRegistry.registerRocketGui(WorldProviderSaturn.class, new ResourceLocation(Constants.ASSET_PREFIX,
					"textures/gui/saturnRocketGui.png"));
		}
		if (Config.uranus) {
			GalaxyRegistry.registerPlanet(uranus);
			GalacticraftRegistry.registerTeleportType(WorldProviderUranus.class, new TeleportTypeUranus());
			GalacticraftRegistry.registerRocketGui(WorldProviderUranus.class, new ResourceLocation(Constants.ASSET_PREFIX,
					"textures/gui/uranusRocketGui.png"));
		}
		if (Config.neptune) {
			GalaxyRegistry.registerPlanet(neptune);
			GalacticraftRegistry.registerTeleportType(WorldProviderNeptune.class, new TeleportTypeNeptune());
			GalacticraftRegistry.registerRocketGui(WorldProviderNeptune.class, new ResourceLocation(Constants.ASSET_PREFIX,
					"textures/gui/neptuneRocketGui.png"));
		}
		if (Config.pluto) {
			GalaxyRegistry.registerPlanet(pluto);
			GalacticraftRegistry.registerTeleportType(WorldProviderPluto.class, new TeleportTypePluto());
			GalacticraftRegistry.registerRocketGui(WorldProviderPluto.class, new ResourceLocation(Constants.ASSET_PREFIX,
					"textures/gui/plutoRocketGui.png"));
		}
		if (Config.eris) {
			GalaxyRegistry.registerPlanet(eris);
			GalacticraftRegistry.registerTeleportType(WorldProviderEris.class, new TeleportTypeEris());
			GalacticraftRegistry.registerRocketGui(WorldProviderEris.class, new ResourceLocation(Constants.ASSET_PREFIX,
					"textures/gui/erisRocketGui.png"));
		}
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
        GalacticraftRegistry.registerSpaceStation(new SpaceStationType(Config.erisSpaceStationID, Config.erisID, new SpaceStationRecipe(inputMap)));;
	}
}