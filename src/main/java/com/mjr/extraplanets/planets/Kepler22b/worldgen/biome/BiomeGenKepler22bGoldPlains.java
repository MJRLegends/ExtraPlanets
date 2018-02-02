package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.Kepler22bBiomes;

public class BiomeGenKepler22bGoldPlains extends Kepler22bBiomes {
	public BiomeGenKepler22bGoldPlains(BiomeProperties properties) {
		super(properties);
		this.topBlock = ExtraPlanets_Blocks.GOLD_GRIT.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.GOLD_GRIT.getDefaultState();
		this.getBiomeDecorator().goldTreesPerChunk = 10;
		this.getBiomeDecorator().goldSpheresPerChunk = 2;
	}

	@Override
	public void registerTypes(Biome b) {
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.addTypes(b, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.LUSH);
	}
}