package com.mjr.extraplanets.moons;

import java.util.ArrayList;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.planets.mars.MarsModule;
import net.minecraft.util.ResourceLocation;

import com.mjr.extraplanets.Constants;
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
    }

    public static void initializeUnReachableMoons() {
	// Neptune Moons
	triton = makeUnreachableMoon("triton", PlanetsMain.neptune);
	if (triton != null)
	    triton.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F)
	    .setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F)).setRelativeOrbitTime(100.0F);

	// Juptier Moons
	io = makeUnreachableMoon("io", PlanetsMain.jupiter);
	if (io != null)
	    io.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F)
	    .setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F)).setRelativeOrbitTime(100.0F);
	europa = makeUnreachableMoon("europa", PlanetsMain.jupiter);
	if (europa != null)
	    europa.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F)
	    .setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F)).setRelativeOrbitTime(100.0F);
	ganymede = makeUnreachableMoon("ganymede", PlanetsMain.jupiter);
	if (ganymede != null)
	    ganymede.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F)
	    .setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(27F, 27F)).setRelativeOrbitTime(100.0F);

	callisto = makeUnreachableMoon("callisto", PlanetsMain.jupiter);
	if (callisto != null)
	    callisto.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F)
	    .setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(36F, 36F)).setRelativeOrbitTime(100.0F);

	// Mars Moons
	phobos = makeUnreachableMoon("phobos", MarsModule.planetMars);
	if (phobos != null)
	    phobos.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F)
	    .setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F)).setRelativeOrbitTime(100.0F);

	deimos = makeUnreachableMoon("deimos", MarsModule.planetMars);
	if (deimos != null)
	    deimos.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F)
	    .setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F)).setRelativeOrbitTime(100.0F);

	// Saturn Moons
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
	// triton = new Moon("Triton").setParentPlanet(neptune);
	// triton.setPhaseShift(2.436F);
	// triton.setRelativeDistanceFromCenter(new
	// CelestialBody.ScalableDistance(9F, 9F));
	// triton.setRelativeOrbitTime(100.0F);
	// triton.setTierRequired(7);
	// triton.setRelativeSize(0.3867F);
	// triton.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
	// triton.setBodyIcon(new
	// ResourceLocation("textures/gui/celestialbodies/triton.png"));
	// triton.setDimensionInfo(19, WorldProviderTriton.class);

    }

    private static void registerMoons() {
	// GalaxyRegistry.registerMoon(triton);
	// GalacticraftRegistry.registerTeleportType(WorldProviderTriton.class,
	// new TeleportTypeTriton());
	// GalacticraftRegistry.registerRocketGui(WorldProviderTriton.class, new
	// ResourceLocation(Constants.ASSET_PREFIX,
	// "textures/gui/tritonRocketGui.png"));
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
