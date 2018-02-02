package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.Kepler22bBiomes;

public class BiomeGenKepler22bIronPlains extends Kepler22bBiomes {
	public BiomeGenKepler22bIronPlains(int var1) {
		super(var1);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.LUSH);
		this.topBlock = ExtraPlanets_Blocks.IRON_GRIT.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.IRON_GRIT.getDefaultState();
		this.getBiomeDecorator().ironTreesPerChunk = 10;
		this.getBiomeDecorator().ironSpheresPerChunk = 2;
	}
}