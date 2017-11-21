package com.mjr.extraplanets.planets.Saturn.worldgen.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import com.mjr.extraplanets.planets.Saturn.worldgen.SaturnBiomes;

public class GenLayerSaturnBiomes extends GenLayer {
	protected BiomeGenBase[] biomes = { SaturnBiomes.saturn, SaturnBiomes.saturnHydrocarbonSea, SaturnBiomes.saturnNuclearLand };

	public GenLayerSaturnBiomes(long seed, GenLayer genlayer) {
		super(seed);
		this.parent = genlayer;
	}

	public GenLayerSaturnBiomes(long seed) {
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
