package com.mjr.extraplanets.util;

import java.util.ArrayList;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

public class RegisterHelper {

	public static void registerExtraPlanetsNonMobEntity(Class<? extends Entity> var0, String var1, int trackingDistance, int updateFreq, boolean sendVel) {
		EntityRegistry.registerModEntity(var0, var1, GCCoreUtil.nextInternalID(), ExtraPlanets.instance, trackingDistance, updateFreq, sendVel);
	}

	public static void setHarvestLevel(Block block, String toolClass, int level, int meta) {
		block.setHarvestLevel(toolClass, level, block.getStateFromMeta(meta));
	}

	public static Planet registerUnreachablePlanet(String name, SolarSystem system) {
		ArrayList<CelestialBody> cBodyList = new ArrayList<CelestialBody>();
		cBodyList.addAll(GalaxyRegistry.getRegisteredPlanets().values());
		for (CelestialBody body : cBodyList) {
			if (body instanceof Planet && name.equals(body.getName()))
				if (((Planet) body).getParentSolarSystem() == system)
					return null;
		}

		Planet planet = new Planet(name).setParentSolarSystem(system);
		planet.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/" + name + ".png"));
		GalaxyRegistry.registerPlanet(planet);
		return planet;
	}

	public static Moon registerUnreachableMoon(String name, Planet parent) {
		ArrayList<CelestialBody> cBodyList = new ArrayList<CelestialBody>();
		cBodyList.addAll(GalaxyRegistry.getRegisteredMoons().values());
		for (CelestialBody body : cBodyList) {
			if (body instanceof Moon && name.equals(body.getName()))
				if (((Moon) body).getParentPlanet() == parent)
					return null;
		}
		Moon moon = new Moon(name).setParentPlanet(parent);
		if (name.equalsIgnoreCase("callisto") || name.equalsIgnoreCase("europa") || name.equalsIgnoreCase("io") || name.equalsIgnoreCase("ganymede"))
			moon.setBodyIcon(new ResourceLocation(micdoodle8.mods.galacticraft.core.Constants.ASSET_PREFIX, "textures/gui/celestialbodies/" + name + ".png"));
		else
			moon.setBodyIcon(new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/celestialbodies/" + name + ".png"));
		GalaxyRegistry.registerMoon(moon);
		return moon;
	}
}
