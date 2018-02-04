package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.Kepler22bBiomes;

public class BiomeGenKepler22bPlains extends Kepler22bBiomes {
	public BiomeGenKepler22bPlains(BiomeProperties properties) {
		super(properties);
		this.topBlock = ExtraPlanets_Blocks.KEPLER22B_GRASS_GREEN.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState();

		this.getBiomeDecorator().brownTreesPerChunk = 3;
		this.getBiomeDecorator().greenTreesPerChunk = 3;
		this.getBiomeDecorator().greenShortGrassPerChunk = 90;
		this.getBiomeDecorator().greenMedGrassPerChunk = 90;
		this.getBiomeDecorator().greenTallGrassPerChunk = 90;
		this.getBiomeDecorator().generateHuts = true;
	}

	@Override
	public void registerTypes(Biome b) {
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.addTypes(b, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD);
	}
}