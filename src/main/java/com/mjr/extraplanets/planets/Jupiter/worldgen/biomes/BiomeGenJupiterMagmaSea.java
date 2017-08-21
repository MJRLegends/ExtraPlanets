package com.mjr.extraplanets.planets.Jupiter.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Jupiter.worldgen.JupiterBiomes;

public class BiomeGenJupiterMagmaSea extends JupiterBiomes {

	public BiomeGenJupiterMagmaSea(BiomeProperties properties) {
		super(properties);
        BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OCEAN);
        this.topBlock = ExtraPlanets_Blocks.JUPITER_BLOCKS.getDefaultState();
        this.fillerBlock = ExtraPlanets_Blocks.JUPITER_BLOCKS.getStateFromMeta(1);
	}
}
