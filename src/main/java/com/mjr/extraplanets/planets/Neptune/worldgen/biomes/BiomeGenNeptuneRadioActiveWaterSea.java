package com.mjr.extraplanets.planets.Neptune.worldgen.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Neptune.worldgen.NeptuneBiomes;

public class BiomeGenNeptuneRadioActiveWaterSea extends NeptuneBiomes {

	public BiomeGenNeptuneRadioActiveWaterSea(BiomeProperties properties) {
		super(properties);
		Biome.registerBiome(Config.NEPTUNE_RADIO_ACTIVE_WATER_SEA_BIOME_ID, Constants.TEXTURE_PREFIX + this.getBiomeName(), this);
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OCEAN);
		this.topBlock = ExtraPlanets_Blocks.NEPTUNE_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.NEPTUNE_BLOCKS.getStateFromMeta(1);
	}
}
