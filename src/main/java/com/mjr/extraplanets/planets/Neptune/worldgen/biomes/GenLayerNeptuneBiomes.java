package com.mjr.extraplanets.planets.Neptune.worldgen.biomes;

import micdoodle8.mods.miccore.IntCache;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;

import com.mjr.extraplanets.planets.Neptune.worldgen.NeptuneBiomes;

public class GenLayerNeptuneBiomes extends GenLayer {
    private static final Biome[] biomes = new Biome[] { NeptuneBiomes.neptune, NeptuneBiomes.neptuneRadioActiveWaterSea, NeptuneBiomes.neptuneLayeredHills };

	public GenLayerNeptuneBiomes(long l, GenLayer parent) {
		super(l);
		this.parent = parent;
	}

	public GenLayerNeptuneBiomes(long l) {
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