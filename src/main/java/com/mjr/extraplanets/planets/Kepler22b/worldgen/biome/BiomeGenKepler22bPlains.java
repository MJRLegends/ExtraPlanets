package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import net.minecraft.init.Blocks;

public class BiomeGenKepler22bPlains extends BiomeGenBaseKepler22b
{
	public BiomeGenKepler22bPlains()
	{
		super(224);
		this.enableRain = true;
		this.enableSnow = true;
		this.topBlock = Blocks.grass;
		this.topMeta = 0;
		this.fillerBlock = Blocks.dirt;
		this.fillerMeta = 1;
		this.stoneBlock = Blocks.stone;
		this.stoneMeta = 2;
	}
}