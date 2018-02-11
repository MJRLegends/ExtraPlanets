package com.mjr.extraplanets.planets.Pluto.worldgen;

import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.world.biome.Biome;

public class PlutoBiomes extends BiomeGenBaseGC {

	public static final Biome pluto = new BiomeGenPluto(new BiomeProperties("Pluto").setBaseHeight(2.5F).setHeightVariation(0.4F).setRainfall(0.0F).setRainDisabled());

	protected PlutoBiomes(BiomeProperties properties) {
		super(properties);
	}
}
