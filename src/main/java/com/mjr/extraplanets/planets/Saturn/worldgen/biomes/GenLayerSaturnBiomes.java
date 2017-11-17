package com.mjr.extraplanets.planets.Saturn.worldgen.biomes;

import micdoodle8.mods.miccore.IntCache;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;

import com.mjr.extraplanets.planets.Saturn.worldgen.SaturnBiomes;

public class GenLayerSaturnBiomes extends GenLayer {
    private static final Biome[] biomes = new Biome[] { SaturnBiomes.saturn, SaturnBiomes.saturnHydroCarbonSea, SaturnBiomes.saturnNuclearLand};

	public GenLayerSaturnBiomes(long l, GenLayer parent) {
		super(l);
		this.parent = parent;
	}

	public GenLayerSaturnBiomes(long l) {
		super(l);
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth) {
		int[] dest = IntCache.getIntCache(width * depth);

		for (int k = 0; k < depth; ++k) {
			for (int i = 0; i < width; ++i) {
				initChunkSeed(x + i, z + k);
				dest[i + k * width] = Biome.getIdForBiome(biomes[nextInt(biomes.length)]);
			}
		}

		return dest;
	}
}