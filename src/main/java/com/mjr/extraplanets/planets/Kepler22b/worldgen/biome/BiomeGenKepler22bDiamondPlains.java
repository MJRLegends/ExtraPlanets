package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.Kepler22bBiomes;

public class BiomeGenKepler22bDiamondPlains extends Kepler22bBiomes {
	public BiomeGenKepler22bDiamondPlains(BiomeProperties properties) {
		super(properties);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.LUSH);
		this.topBlock = ExtraPlanets_Blocks.DIAMOND_GRIT.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.DIAMOND_GRIT.getDefaultState();
		this.getBiomeDecorator().diamondTreesPerChunk = 10;
		this.getBiomeDecorator().diamondSpheresPerChunk = 2;
	}
}