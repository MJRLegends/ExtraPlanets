package com.mjr.extraplanets.moons.Callisto.worldgen.biomes;

import micdoodle8.mods.miccore.IntCache;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;

import com.mjr.extraplanets.moons.Callisto.worldgen.CallistoBiomes;

public class GenLayerCallistoBiomes extends GenLayer {
	private static final Biome[] biomes = new Biome[] { CallistoBiomes.callisto, CallistoBiomes.callistoSaltSea, CallistoBiomes.callistoShaleLargeMountains, CallistoBiomes.callistoShaleSmallMountains };

	public GenLayerCallistoBiomes(long l, GenLayer parent) {
		super(l);
		this.parent = parent;
	}

	public GenLayerCallistoBiomes(long l) {
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