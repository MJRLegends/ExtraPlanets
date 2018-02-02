package com.mjr.extraplanets.planets.Saturn.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Saturn.worldgen.SaturnBiomes;

public class BiomeGenSaturn extends SaturnBiomes {

	public BiomeGenSaturn(int var1) {
		super(var1);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
		this.topBlock = ExtraPlanets_Blocks.SATURN_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.SATURN_BLOCKS.getStateFromMeta(1);
	}
}
