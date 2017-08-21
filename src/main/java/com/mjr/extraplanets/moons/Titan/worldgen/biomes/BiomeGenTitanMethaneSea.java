package com.mjr.extraplanets.moons.Titan.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;

public class BiomeGenTitanMethaneSea extends Biome {
	public BiomeGenTitanMethaneSea(Biome.BiomeProperties properties) {
		super(properties);
		this.spawnableCreatureList.clear();
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OCEAN);
		this.topBlock = ExtraPlanets_Fluids.METHANE.getDefaultState();
		this.fillerBlock = ExtraPlanets_Fluids.METHANE.getDefaultState();
	}
}