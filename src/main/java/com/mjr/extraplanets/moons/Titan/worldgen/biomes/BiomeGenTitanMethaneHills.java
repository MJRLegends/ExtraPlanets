package com.mjr.extraplanets.moons.Titan.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicTitan;
import com.mjr.extraplanets.moons.Titan.worldgen.TitanBiomes;

public class BiomeGenTitanMethaneHills extends TitanBiomes {
	public BiomeGenTitanMethaneHills(BiomeProperties properties) {
		super(properties);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.HILLS);
		this.topBlock = ExtraPlanets_Blocks.TITAN_BLOCKS.getDefaultState().withProperty(BlockBasicTitan.BASIC_TYPE, BlockBasicTitan.EnumBlockBasic.METHANE_INFECTED_SURFACE_ROCK);
		this.fillerBlock = ExtraPlanets_Blocks.TITAN_BLOCKS.getDefaultState().withProperty(BlockBasicTitan.BASIC_TYPE, BlockBasicTitan.EnumBlockBasic.METHANE_INFECTED_SUB_SURFACE_ROCK);
	}
}
