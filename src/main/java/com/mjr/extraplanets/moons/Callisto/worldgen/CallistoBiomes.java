package com.mjr.extraplanets.moons.Callisto.worldgen;

import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.world.biome.Biome;

public class CallistoBiomes extends BiomeGenBaseGC {

	public static final Biome callisto = new BiomeGenCallisto(new BiomeProperties("Callisto").setBaseHeight(2.5F).setHeightVariation(0.4F).setRainfall(0.0F).setRainDisabled());

	protected CallistoBiomes(BiomeProperties properties) {
		super(properties);
	}
}
