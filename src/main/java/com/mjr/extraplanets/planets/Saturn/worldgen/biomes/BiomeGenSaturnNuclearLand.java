package com.mjr.extraplanets.planets.Saturn.worldgen.biomes;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Saturn.worldgen.SaturnBiomes;

public class BiomeGenSaturnNuclearLand extends SaturnBiomes {
	public BiomeGenSaturnNuclearLand(int par1) {
		super(par1);
		this.topBlock = ExtraPlanets_Blocks.saturnBlocks;
		this.topMeta = 9;
		this.fillerBlock = ExtraPlanets_Blocks.saturnBlocks;
		this.fillerMeta = 10;
		this.stoneBlock = ExtraPlanets_Blocks.saturnBlocks;
		this.stoneMeta = 2;
	}
}