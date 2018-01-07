package com.mjr.extraplanets.planets.Jupiter.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Jupiter.worldgen.JupiterBiomes;

public class BiomeGenJupiterSands extends JupiterBiomes {

	public BiomeGenJupiterSands(BiomeProperties properties) {
		super(properties);
		this.topBlock = ExtraPlanets_Blocks.ORANGE_SAND.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.ORANGE_SANDSTONE.getDefaultState();
	}

	@Override
	public void registerTypes() {
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OCEAN);
	}
}
