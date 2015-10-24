package com.mjr.extraplanets.planets.Neptune.worldgen.biome;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanetsBlocks;

public class BiomeGenNeptune extends BiomeGenBaseNeptune
{
	public BiomeGenNeptune()
	{
		super(224);
		this.enableRain = true;
		this.enableSnow = true;
		this.topBlock = ExtraPlanetsBlocks.neptuneSurface;
		this.topMeta = 0;
		this.fillerBlock = ExtraPlanetsBlocks.neptuneSubSurface;
		this.fillerMeta = 0;
		this.stoneBlock = ExtraPlanetsBlocks.neptuneStone;
		this.stoneMeta = 0;
	}
}