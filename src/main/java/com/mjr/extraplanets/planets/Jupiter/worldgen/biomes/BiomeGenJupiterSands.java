package com.mjr.extraplanets.planets.Jupiter.worldgen.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Jupiter.worldgen.JupiterBiomes;

public class BiomeGenJupiterSands extends JupiterBiomes {

	public BiomeGenJupiterSands(BiomeProperties properties) {
		super(properties);
		Biome.registerBiome(Config.JUPITER_SANDS_BIOME_ID, Constants.TEXTURE_PREFIX + this.getBiomeName(), this);
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OCEAN);
		this.topBlock = ExtraPlanets_Blocks.ORANGE_SAND.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.ORANGE_SANDSTONE.getStateFromMeta(1);
	}
}
