package com.mjr.extraplanets.planets.Neptune.worldgen.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import com.mjr.extraplanets.planets.Neptune.worldgen.NeptuneBiomes;

public class GenLayerNeptuneBiomes extends GenLayer {
	protected BiomeGenBase[] biomes = { NeptuneBiomes.neptune, NeptuneBiomes.neptuneRadioActiveWaterSea };

	public GenLayerNeptuneBiomes(long seed, GenLayer genlayer) {
		super(seed);
		this.parent = genlayer;
	}

	public GenLayerNeptuneBiomes(long seed) {
		super(seed);
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth) {
		int[] dest = IntCache.getIntCache(width * depth);

		for (int dz = 0; dz < depth; dz++) {
			for (int dx = 0; dx < width; dx++) {
				this.initChunkSeed(dx + x, dz + z);
				dest[dx + dz * width] = this.biomes[this.nextInt(this.biomes.length)].biomeID;
			}
		}
		return dest;
	}
}
