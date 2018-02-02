package com.mjr.extraplanets.planets.Jupiter.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Jupiter.worldgen.JupiterBiomes;

public class BiomeGenJupiterSands extends JupiterBiomes {

	public BiomeGenJupiterSands(BiomeProperties properties) {
		super(properties);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
		this.topBlock = ExtraPlanets_Blocks.ORANGE_SAND.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.ORANGE_SANDSTONE.getDefaultState();
	}
}
