package com.mjr.extraplanets.planets.Kepler22b.worldgen.layer;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import com.mjr.extraplanets.planets.Kepler22b.worldgen.biome.BiomeGenBaseKepler22b;

public class GenLayerKepler22bBiomes extends GenLayer
{
	protected Biome[] commonBiomes = { 
			BiomeGenBaseKepler22b.kepler22bPlains, 
			BiomeGenBaseKepler22b.kepler22bBlueForest, 
			BiomeGenBaseKepler22b.kepler22bPurpleForest, 
			BiomeGenBaseKepler22b.kepler22bRedForest, 
			BiomeGenBaseKepler22b.kepler22bYellowForest
	};
	
	protected Biome[] rareBiomes = {BiomeGenBaseKepler22b.kepler22bBlueForest};

	public GenLayerKepler22bBiomes(long seed, GenLayer genlayer)
	{
		super(seed);
		this.parent = genlayer;
	}

	public GenLayerKepler22bBiomes(long seed)
	{
		super(seed);
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth)
	{
		int[] dest = IntCache.getIntCache(width * depth);

		for (int dz = 0; dz < depth; dz++)
		{
			for (int dx = 0; dx < width; dx++)
			{
				this.initChunkSeed(dx + x, dz + z);

				if (this.nextInt(15) == 0)
				{
					dest[dx + dz * width] = Biome.getIdForBiome(this.rareBiomes[this.nextInt(this.rareBiomes.length)]);
				}
				else
				{
					dest[dx + dz * width] = Biome.getIdForBiome(this.commonBiomes[this.nextInt(this.commonBiomes.length)]);
				}
			}
		}
		return dest;
	}
}
