package com.mjr.extraplanets.planets.Saturn.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Saturn.worldgen.SaturnBiomes;

public class BiomeGenSaturnHydroCarbonSea extends SaturnBiomes {

	public BiomeGenSaturnHydroCarbonSea(BiomeProperties properties) {
		super(properties);
        BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OCEAN);
        this.topBlock = ExtraPlanets_Blocks.SATURN_BLOCKS.getDefaultState();
        this.fillerBlock = ExtraPlanets_Blocks.SATURN_BLOCKS.getStateFromMeta(1);
	}
}
