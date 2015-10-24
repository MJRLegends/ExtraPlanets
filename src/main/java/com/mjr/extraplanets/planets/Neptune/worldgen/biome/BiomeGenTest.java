package com.mjr.extraplanets.planets.Neptune.worldgen.biome;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanetsBlocks;

public class BiomeGenTest extends BiomeGenBaseNeptune
{
	public BiomeGenTest()
	{
		super(225);
		this.enableRain = true;
		this.enableSnow = true;
		this.topBlock = ExtraPlanetsBlocks.uranusSurface;
		this.topMeta = 0;
		this.fillerBlock = ExtraPlanetsBlocks.uranusSubSurface;
		this.fillerMeta = 0;
		this.stoneBlock = ExtraPlanetsBlocks.uranusStone;
		this.stoneMeta = 0;
	}
}