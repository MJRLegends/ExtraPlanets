package com.mjr.extraplanets.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.google.common.collect.ObjectArrays;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

public class RegisterHelper {
	private static int id = 0;

	public static void registerBlock(Block block, String name) {
		GameRegistry.register(block.setRegistryName(Constants.modID, name));
		GameRegistry.register(new ItemBlock(block).setRegistryName(Constants.modID, name));
	}

	public static void registerBlock(Block block, Class<? extends ItemBlock> itemclass, String name) throws NoSuchMethodException {
		Object[] itemCtorArgs = new Object[] {};
		ItemBlock i = null;
		if (itemclass != null) {
			Class<?>[] ctorArgClasses = new Class<?>[itemCtorArgs.length + 1];
			ctorArgClasses[0] = Block.class;
			for (int idx = 1; idx < ctorArgClasses.length; idx++) {
				ctorArgClasses[idx] = itemCtorArgs[idx - 1].getClass();
			}
			Constructor<? extends ItemBlock> itemCtor = itemclass.getConstructor(ctorArgClasses);
			try {
				i = itemCtor.newInstance(ObjectArrays.concat(block, itemCtorArgs));
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e) {
				e.printStackTrace();
			}
		}
		GameRegistry.register(block.setRegistryName(Constants.modID, name));
		GameRegistry.register(i.setRegistryName(Constants.modID, name));
	}

	public static void registerItem(Item item) {
		GameRegistry.register(item);
	}

	public static void registerItem(Item item, String name) {
		GameRegistry.register(item.setRegistryName(name));
	}

	public static void registerExtraPlanetsNonMobEntity(Class<? extends Entity> var0, String var1, int trackingDistance, int updateFreq, boolean sendVel) {
        ResourceLocation registryName = new ResourceLocation(Constants.modID, var1);
		EntityRegistry.registerModEntity(registryName, var0, var1, id++, ExtraPlanets.instance, trackingDistance, updateFreq, sendVel);

	}

	public static void registerExtraPlanetsMobEntity(Class<? extends Entity> entityClass, String name, int back, int fore) {
		registerExtraPlanetsNonMobEntity(entityClass, name, 80, 3, true);
		ResourceLocation resourcelocation = new ResourceLocation(Constants.modID, name);
		EntityList.ENTITY_EGGS.put(resourcelocation, new EntityList.EntityEggInfo(resourcelocation, back, fore));
	}

	@SuppressWarnings("deprecation")
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
