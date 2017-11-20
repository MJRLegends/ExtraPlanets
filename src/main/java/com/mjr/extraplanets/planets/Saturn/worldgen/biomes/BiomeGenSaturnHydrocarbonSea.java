package com.mjr.extraplanets.planets.Saturn.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Saturn.worldgen.SaturnBiomes;

public class BiomeGenSaturnHydrocarbonSea extends SaturnBiomes {

	public BiomeGenSaturnHydrocarbonSea(int par1) {
		super(par1);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OCEAN);
		this.topBlock = null;
		this.topMeta = 0;
		this.fillerBlock = null;
		this.fillerMeta = 1;
		this.stoneBlock = ExtraPlanets_Blocks.saturnBlocks;
		this.stoneMeta = 2;
	}
}