package com.mjr.extraplanets.moons.Io.worldgen.biomes;

import micdoodle8.mods.miccore.IntCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

import com.mjr.extraplanets.moons.Io.worldgen.IoBiomes;

public class GenLayerIoBiomes extends GenLayer {
	private static final BiomeGenBase[] biomes = new BiomeGenBase[] { IoBiomes.io, IoBiomes.ioAshLands, IoBiomes.ioBurningPlains };

	public GenLayerIoBiomes(long l, GenLayer parent) {
		super(l);
		this.parent = parent;
	}

	public GenLayerIoBiomes(long l) {
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