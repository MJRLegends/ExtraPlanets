package com.mjr.extraplanets.planets.Eris.worldgen;

import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.world.biome.Biome;

public class ErisBiomes extends BiomeGenBaseGC {

	public static final Biome eris = new BiomeGenEris(new BiomeProperties("Eris").setBaseHeight(2.5F).setHeightVariation(0.4F).setRainfall(0.0F).setRainDisabled());

	protected ErisBiomes(BiomeProperties properties) {
		super(properties);
	}
}
