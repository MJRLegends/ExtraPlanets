package com.mjr.extraplanets.moons.Europa.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicEuropa;
import com.mjr.extraplanets.moons.Europa.worldgen.EuropaBiomes;

public class BiomeGenEuropa extends EuropaBiomes {

	public BiomeGenEuropa(BiomeProperties properties) {
		super(properties);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.WET, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SNOWY);
		this.topBlock = ExtraPlanets_Blocks.EUROPA_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.EUROPA_BLOCKS.getDefaultState().withProperty(BlockBasicEuropa.BASIC_TYPE, BlockBasicEuropa.EnumBlockBasic.SUB_SURFACE);
	}
}
