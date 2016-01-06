package com.mjr.extraplanets.planets.Neptune.worldgen.biome;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class BiomeGenTest extends BiomeGenBaseNeptune
{
	public BiomeGenTest()
	{
		super(225);
		this.enableRain = true;
		this.enableSnow = true;
		this.topBlock = ExtraPlanets_Blocks.neptuneBlocks;
		this.topMeta = 0;
		this.fillerBlock = ExtraPlanets_Blocks.neptuneBlocks;
		this.fillerMeta = 1;
		this.stoneBlock = ExtraPlanets_Blocks.neptuneBlocks;
		this.stoneMeta = 2;
	}
}