package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.Kepler22bBiomes;

public class BiomeGenKepler22bCoalPlains extends Kepler22bBiomes {
	public BiomeGenKepler22bCoalPlains(BiomeProperties properties) {
		super(properties);
		this.topBlock = ExtraPlanets_Blocks.COAL_GRIT.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.COAL_GRIT.getDefaultState();
		this.getBiomeDecorator().coalTreesPerChunk = 10;
		this.getBiomeDecorator().coalSpheresPerChunk = 2;
	}

	@Override
	public void registerTypes() {
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.LUSH);
	}
}