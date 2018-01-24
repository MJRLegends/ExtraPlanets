package com.mjr.extraplanets.moons.Europa.worldgen.biomes;

import micdoodle8.mods.miccore.IntCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

import com.mjr.extraplanets.moons.Europa.worldgen.EuropaBiomes;

public class GenLayerEuropaBiomes extends GenLayer {
	private static final BiomeGenBase[] biomes = new BiomeGenBase[] { EuropaBiomes.europa, EuropaBiomes.europaSaltSea, EuropaBiomes.europaIceValleys };
	private static final BiomeGenBase[] biomesRare = new BiomeGenBase[] { EuropaBiomes.europa };

	public GenLayerEuropaBiomes(long l, GenLayer parent) {
		super(l);
		this.parent = parent;
	}

	public GenLayerEuropaBiomes(long l) {
		super(l);
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth) {
		int[] dest = IntCache.getIntCache(width * depth);

		for (int k = 0; k < depth; ++k) {
			for (int i = 0; i < width; ++i) {
				initChunkSeed(x + i, z + k);
				if (this.nextInt(10) == 0) {
					dest[i + k * width] = biomesRare[nextInt(biomesRare.length)].biomeID;
				} else {
					dest[i + k * width] = biomes[nextInt(biomes.length)].biomeID;
				}
			}
		}

		return dest;
	}
}