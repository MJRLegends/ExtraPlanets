package com.mjr.extraplanets.planets.Uranus.worldgen.biomes;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Uranus.worldgen.UranusBiomes;

public class BiomeGenUranus extends UranusBiomes {
	public BiomeGenUranus(int par1) {
		super(par1);
		this.topBlock = ExtraPlanets_Blocks.uranusBlocks;
		this.topMeta = 0;
		this.fillerBlock = ExtraPlanets_Blocks.uranusBlocks;
		this.fillerMeta = 1;
		this.stoneBlock = ExtraPlanets_Blocks.uranusBlocks;
		this.stoneMeta = 2;
	}
}