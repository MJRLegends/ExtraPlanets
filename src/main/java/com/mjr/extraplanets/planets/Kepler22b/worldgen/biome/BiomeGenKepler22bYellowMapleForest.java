package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.Kepler22bBiomes;

public class BiomeGenKepler22bYellowMapleForest extends Kepler22bBiomes {
	public BiomeGenKepler22bYellowMapleForest(BiomeProperties properties) {
		super(properties);
		this.topBlock = ExtraPlanets_Blocks.KEPLER22B_GRASS_YELLOW.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState();

		this.getBiomeDecorator().yellowTreesPerChunk = 5;
		this.getBiomeDecorator().yellowShortGrassPerChunk = 90;
		this.getBiomeDecorator().yellowMedGrassPerChunk = 90;
		this.getBiomeDecorator().yellowTallGrassPerChunk = 90;
		this.getBiomeDecorator().generateHuts = true;
	}

	@Override
	public void registerTypes(Biome b) {
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.addTypes(b, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DEAD);
	}
}