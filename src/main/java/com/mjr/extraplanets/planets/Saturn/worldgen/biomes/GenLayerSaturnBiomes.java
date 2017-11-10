package com.mjr.extraplanets.planets.Saturn.worldgen.biomes;

import micdoodle8.mods.miccore.IntCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

import com.mjr.extraplanets.planets.Saturn.worldgen.SaturnBiomes;

public class GenLayerSaturnBiomes extends GenLayer {
	private static final BiomeGenBase[] biomes = new BiomeGenBase[] { SaturnBiomes.saturn, SaturnBiomes.saturnHydroCarbonSea };

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
				dest[i + k * width] = biomes[nextInt(biomes.length)].biomeID;
			}
		}

		return dest;
	}
}