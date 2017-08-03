package com.mjr.extraplanets.moons.Oberon.worldgen.biomes;

import micdoodle8.mods.miccore.IntCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

import com.mjr.extraplanets.moons.Oberon.worldgen.OberonBiomes;

public class GenLayerOberonBiomes extends GenLayer {
	private static final BiomeGenBase[] biomes = new BiomeGenBase[] { OberonBiomes.oberon, OberonBiomes.oberonLargeIceMountain };
	private static final BiomeGenBase[] biomesRare = new BiomeGenBase[] { OberonBiomes.oberon };

	public GenLayerOberonBiomes(long l, GenLayer parent) {
		super(l);
		this.parent = parent;
	}

	public GenLayerOberonBiomes(long l) {
		super(l);
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth) {
		int[] dest = IntCache.getIntCache(width * depth);

		for (int k = 0; k < depth; ++k) {
			for (int i = 0; i < width; ++i) {
				initChunkSeed(x + i, z + k);
				dest[i + k * width] = biomes[nextInt(biomes.length)].biomeID;

				// if (this.nextInt(15) == 0)
				// {
				// dest[i + k * width] = BiomeGenBase.getIdForBiome(biomesRare[nextInt(biomesRare.length)]);
				// }
				// else
				// {
				// dest[i + k * width] = BiomeGenBase.getIdForBiome(biomes[nextInt(biomes.length)]);
				// }
			}
		}

		return dest;
	}
}