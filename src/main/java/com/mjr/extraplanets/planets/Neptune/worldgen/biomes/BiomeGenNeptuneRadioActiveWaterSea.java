package com.mjr.extraplanets.planets.Neptune.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Neptune.worldgen.NeptuneBiomes;

public class BiomeGenNeptuneRadioActiveWaterSea extends NeptuneBiomes {

	public BiomeGenNeptuneRadioActiveWaterSea(BiomeProperties properties) {
		super(properties);
        BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OCEAN);
        this.topBlock = ExtraPlanets_Blocks.NEPTUNE_BLOCKS.getDefaultState();
        this.fillerBlock = ExtraPlanets_Blocks.NEPTUNE_BLOCKS.getStateFromMeta(1);
	}
}
