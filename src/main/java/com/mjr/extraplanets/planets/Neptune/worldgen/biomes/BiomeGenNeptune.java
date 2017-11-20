package com.mjr.extraplanets.planets.Neptune.worldgen.biomes;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Neptune.worldgen.NeptuneBiomes;

public class BiomeGenNeptune extends NeptuneBiomes {
	public BiomeGenNeptune(int par1) {
		super(par1);
		this.topBlock = ExtraPlanets_Blocks.neptuneBlocks;
		this.topMeta = 0;
		this.fillerBlock = ExtraPlanets_Blocks.neptuneBlocks;
		this.fillerMeta = 1;
		this.stoneBlock = ExtraPlanets_Blocks.neptuneBlocks;
		this.stoneMeta = 2;
	}
}