package com.mjr.extraplanets.moons;

import java.util.ArrayList;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.planets.mars.MarsModule;
import net.minecraft.util.ResourceLocation;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.moons.Deimos.TeleportTypeDeimos;
import com.mjr.extraplanets.moons.Deimos.WorldProviderDeimos;
import com.mjr.extraplanets.moons.Europa.TeleportTypeEuropa;
import com.mjr.extraplanets.moons.Europa.WorldProviderEuropa;
import com.mjr.extraplanets.moons.Io.TeleportTypeIo;
import com.mjr.extraplanets.moons.Io.WorldProviderIo;
import com.mjr.extraplanets.moons.Phobos.TeleportTypePhobos;
import com.mjr.extraplanets.moons.Phobos.WorldProviderPhobos;
import com.mjr.extraplanets.moons.triton.TeleportTypeTriton;
import com.mjr.extraplanets.moons.triton.WorldProviderTriton;
import com.mjr.extraplanets.planets.PlanetsMain;

public class MoonsMain {
    public static Moon triton;

    public static Moon callisto;
    public static Moon europa;
    public static Moon ganymede;
    public static Moon io;

    public static Moon deimos;
    public static Moon phobos;

    public static Moon iapetus;
    public static Moon rhea;
    public static Moon titan;

    public static Moon oberon;
    public static Moon titania;

    public static void init() {
	initializeMoons();
	registerMoons();
	initializeUnReachableMoons();
    }

    public static void initializeUnReachableMoons() {
	// Neptune Moons
	triton = makeUnreachableMoon("triton", PlanetsMain.neptune);
	if (triton != null)
	    triton.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F)
	    .setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F)).setRelativeOrbitTime(100.0F);

	ganymede = makeUnreachableMoon("ganymede", PlanetsMain.jupiter);
	if (ganymede != null)
	    ganymede.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F)
	    .setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(27F, 27F)).setRelativeOrbitTime(100.0F);

	callisto = makeUnreachableMoon("callisto", PlanetsMain.jupiter);
	if (callisto != null)
	    callisto.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F)
	    .setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(36F, 36F)).setRelativeOrbitTime(100.0F);

	rhea = makeUnreachableMoon("rhea", PlanetsMain.saturn);
	if (rhea != null)
	    rhea.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F)
	    .setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F)).setRelativeOrbitTime(100.0F);
	titan = makeUnreachableMoon("titan", PlanetsMain.saturn);
	if (titan != null)
	    titan.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F)
	    .setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F)).setRelativeOrbitTime(100.0F);
	iapetus = makeUnreachableMoon("iapetus", PlanetsMain.saturn);
	if (iapetus != null)
	    iapetus.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F)
	    .setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(27F, 27F)).setRelativeOrbitTime(100.0F);

	// Uranus Moons
	titania = makeUnreachableMoon("titania", PlanetsMain.uranus);
	if (titania != null)
	    titania.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F)
	    .setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F)).setRelativeOrbitTime(100.0F);
	oberon = makeUnreachableMoon("oberon", PlanetsMain.uranus);
	if (oberon != null)
	    oberon.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F)
	    .setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F)).setRelativeOrbitTime(100.0F);
    }

    private static void initializeMoons() {
	if (Config.triton) {
	    triton = new Moon("Triton").setParentPlanet(PlanetsMain.neptune);
	    triton.setPhaseShift(2.436F);
	    triton.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
	    triton.setRelativeOrbitTime(100.0F);
	    triton.setTierRequired(7);
	    triton.setRelativeSize(0.3867F);
	    triton.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM)
	    .atmosphereComponent(IAtmosphericGas.METHANE);
	    triton.setBodyIcon(new ResourceLocation("textures/gui/celestialbodies/triton.png"));
	    triton.setDimensionInfo(Config.tritonID, WorldProviderTriton.class);
	}
	if (Config.europa) {
	    europa = new Moon("europa").setParentPlanet(PlanetsMain.jupiter);
	    europa.setPhaseShift(2.436F);
	    europa.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F));
	    europa.setRelativeOrbitTime(100.0F);
	    europa.setTierRequired(4);
	    europa.setRelativeSize(0.3867F);
	    europa.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM)
	    .atmosphereComponent(IAtmosphericGas.METHANE);
	    europa.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/europa.png"));
	    europa.setDimensionInfo(Config.europaID, WorldProviderEuropa.class);
	}
	if (Config.io) {
	    io = new Moon("io").setParentPlanet(PlanetsMain.jupiter);
	    io.setPhaseShift(2.436F);
	    io.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
	    io.setRelativeOrbitTime(100.0F);
	    io.setTierRequired(4);
	    io.setRelativeSize(0.3867F);
	    io.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM)
	    .atmosphereComponent(IAtmosphericGas.METHANE);
	    io.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/io.png"));
	    io.setDimensionInfo(Config.ioID, WorldProviderIo.class);
	}
	if (Config.deimos) {
	    deimos = new Moon("deimos").setParentPlanet(MarsModule.planetMars);
	    deimos.setPhaseShift(2.436F);
	    deimos.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F));
	    deimos.setRelativeOrbitTime(100.0F);
	    deimos.setTierRequired(2);
	    deimos.setRelativeSize(0.3867F);
	    deimos.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM)
	    .atmosphereComponent(IAtmosphericGas.METHANE);
	    deimos.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/deimos.png"));
	    deimos.setDimensionInfo(Config.deimosID, WorldProviderDeimos.class);
	}
	if (Config.phobos) {
	    phobos = new Moon("phobos").setParentPlanet(MarsModule.planetMars);
	    phobos.setPhaseShift(2.436F);
	    phobos.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
	    phobos.setRelativeOrbitTime(100.0F);
	    phobos.setTierRequired(2);
	    phobos.setRelativeSize(0.3867F);
	    phobos.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM)
	    .atmosphereComponent(IAtmosphericGas.METHANE);
	    phobos.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/phobos.png"));
	    phobos.setDimensionInfo(Config.phobosID, WorldProviderPhobos.class);
	}
    }

    private static void registerMoons() {
	if (Config.triton) {
	    GalaxyRegistry.registerMoon(triton);
	    GalacticraftRegistry.registerTeleportType(WorldProviderTriton.class, new TeleportTypeTriton());
	    GalacticraftRegistry.registerRocketGui(WorldProviderTriton.class, new ResourceLocation(Constants.ASSET_PREFIX,
		    "textures/gui/tritonRocketGui.png"));
	}
	if (Config.europa) {
	    GalaxyRegistry.registerMoon(europa);
	    GalacticraftRegistry.registerTeleportType(WorldProviderEuropa.class, new TeleportTypeEuropa());
	    GalacticraftRegistry.registerRocketGui(WorldProviderEuropa.class, new ResourceLocation(Constants.ASSET_PREFIX,
		    "textures/gui/europaRocketGui.png"));
	}
	if (Config.io) {
	    GalaxyRegistry.registerMoon(io);
	    GalacticraftRegistry.registerTeleportType(WorldProviderIo.class, new TeleportTypeIo());
	    GalacticraftRegistry.registerRocketGui(WorldProviderIo.class, new ResourceLocation(Constants.ASSET_PREFIX,
		    "textures/gui/ioRocketGui.png"));
	}
	if (Config.deimos) {
	    GalaxyRegistry.registerMoon(deimos);
	    GalacticraftRegistry.registerTeleportType(WorldProviderDeimos.class, new TeleportTypeDeimos());
	    GalacticraftRegistry.registerRocketGui(WorldProviderDeimos.class, new ResourceLocation(Constants.ASSET_PREFIX,
		    "textures/gui/deimosRocketGui.png"));
	}
	if (Config.phobos) {
	    GalaxyRegistry.registerMoon(phobos);
	    GalacticraftRegistry.registerTeleportType(WorldProviderPhobos.class, new TeleportTypePhobos());
	    GalacticraftRegistry.registerRocketGui(WorldProviderPhobos.class, new ResourceLocation(Constants.ASSET_PREFIX,
		    "textures/gui/phobosRocketGui.png"));
	}
    }

    private static Moon makeUnreachableMoon(String name, Planet parent) {
	ArrayList<CelestialBody> cBodyList = new ArrayList<CelestialBody>();
	cBodyList.addAll(GalaxyRegistry.getRegisteredMoons().values());
	for (CelestialBody body : cBodyList) {
	    if (body instanceof Moon && name.equals(body.getName()))
		if (((Moon) body).getParentPlanet() == parent)
		    return null;
	}
	Moon moon = new Moon(name).setParentPlanet(parent);
	if (name.equalsIgnoreCase("callisto") || name.equalsIgnoreCase("europa") || name.equalsIgnoreCase("io")
		|| name.equalsIgnoreCase("ganymede"))
	    moon.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/" + name + ".png"));
	else
	    moon.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/celestialbodies/" + name + ".png"));
	GalaxyRegistry.registerMoon(moon);
	return moon;
    }
}
