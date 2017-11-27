package com.mjr.extraplanets.moons.Titan.worldgen.biomes;

import micdoodle8.mods.miccore.IntCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

import com.mjr.extraplanets.moons.Titan.worldgen.TitanBiomes;

public class GenLayerTitanBiomes extends GenLayer {
	private static final BiomeGenBase[] biomes = new BiomeGenBase[] { TitanBiomes.titan, TitanBiomes.titanMethaneSea, TitanBiomes.titanMethaneHills  };

	public GenLayerTitanBiomes(long l, GenLayer parent) {
		super(l);
		this.parent = parent;
	}

	public GenLayerTitanBiomes(long l) {
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
