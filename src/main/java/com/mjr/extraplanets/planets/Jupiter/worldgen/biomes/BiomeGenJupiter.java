package com.mjr.extraplanets.planets.Jupiter.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Jupiter.worldgen.JupiterBiomes;

public class BiomeGenJupiter extends JupiterBiomes {

	public BiomeGenJupiter(BiomeProperties properties) {
		super(properties);
        BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
        this.topBlock = ExtraPlanets_Blocks.JUPITER_BLOCKS.getDefaultState();
        this.fillerBlock = ExtraPlanets_Blocks.JUPITER_BLOCKS.getStateFromMeta(1);
	}
}
