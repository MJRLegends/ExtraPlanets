package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.Kepler22bBiomes;

public class BiomeGenKepler22bBlueMapleForest extends Kepler22bBiomes {
	public BiomeGenKepler22bBlueMapleForest(BiomeProperties properties) {
		super(properties);
		this.topBlock = ExtraPlanets_Blocks.KEPLER22B_GRASS_BLUE.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState();

		this.getBiomeDecorator().blueTreesPerChunk = 5;
		this.getBiomeDecorator().blueShortGrassPerChunk = 90;
		this.getBiomeDecorator().blueMedGrassPerChunk = 90;
		this.getBiomeDecorator().blueTallGrassPerChunk = 90;
		this.getBiomeDecorator().blueBigTreesPerChunk = 50;
		this.getBiomeDecorator().blueTowerPerChunk = 10;
		this.getBiomeDecorator().generateHuts = true;
	}

	@Override
	public void registerTypes(Biome b) {
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.addTypes(b, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DEAD);
	}
}