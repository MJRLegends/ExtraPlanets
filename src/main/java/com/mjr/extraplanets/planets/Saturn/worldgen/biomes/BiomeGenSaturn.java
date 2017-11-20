package com.mjr.extraplanets.planets.Saturn.worldgen.biomes;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Saturn.worldgen.SaturnBiomes;

public class BiomeGenSaturn extends SaturnBiomes {
	public BiomeGenSaturn(int par1) {
		super(par1);
		this.topBlock = ExtraPlanets_Blocks.saturnBlocks;
		this.topMeta = 0;
		this.fillerBlock = ExtraPlanets_Blocks.saturnBlocks;
		this.fillerMeta = 1;
		this.stoneBlock = ExtraPlanets_Blocks.saturnBlocks;
		this.stoneMeta = 2;
	}
}