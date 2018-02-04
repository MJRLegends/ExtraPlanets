package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.Kepler22bBiomes;

public class BiomeGenKepler22bPurpleMapleForest extends Kepler22bBiomes {
	public BiomeGenKepler22bPurpleMapleForest(BiomeProperties properties) {
		super(properties);
		this.topBlock = ExtraPlanets_Blocks.KEPLER22B_GRASS_PURPLE.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState();

		this.getBiomeDecorator().purpleTreesPerChunk = 5;
		this.getBiomeDecorator().purpleShortGrassPerChunk = 90;
		this.getBiomeDecorator().purpleMedGrassPerChunk = 90;
		this.getBiomeDecorator().purpleTallGrassPerChunk = 90;
		this.getBiomeDecorator().purpleBigTreesPerChunk = 90;
		this.getBiomeDecorator().generateHuts = true;
	}

	@Override
	public void registerTypes(Biome b) {
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.addTypes(b, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DEAD);
	}
}