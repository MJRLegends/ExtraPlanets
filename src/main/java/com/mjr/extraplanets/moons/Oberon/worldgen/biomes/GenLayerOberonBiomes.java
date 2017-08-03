package com.mjr.extraplanets.moons.Oberon.worldgen.biomes;

import micdoodle8.mods.miccore.IntCache;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;

import com.mjr.extraplanets.moons.Oberon.worldgen.OberonBiomes;

public class GenLayerOberonBiomes extends GenLayer {
	private static final Biome[] biomes = new Biome[] { OberonBiomes.oberon, OberonBiomes.oberonValleys };
	private static final Biome[] biomesRare = new Biome[] { OberonBiomes.oberonLargeMountain };

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
				if (this.nextInt(10) == 0)
				{
					dest[i + k * width] = Biome.getIdForBiome(biomesRare[nextInt(biomesRare.length)]);
				}
				else
				{
					dest[i + k * width] = Biome.getIdForBiome(biomes[nextInt(biomes.length)]);
				}
			}
		}

		return dest;
	}
}