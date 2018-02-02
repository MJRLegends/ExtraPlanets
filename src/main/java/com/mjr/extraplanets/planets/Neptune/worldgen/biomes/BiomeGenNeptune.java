package com.mjr.extraplanets.planets.Neptune.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicNeptune;
import com.mjr.extraplanets.planets.Neptune.worldgen.NeptuneBiomes;

public class BiomeGenNeptune extends NeptuneBiomes {

	public BiomeGenNeptune(BiomeProperties properties) {
		super(properties);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD);
		this.topBlock = ExtraPlanets_Blocks.NEPTUNE_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.NEPTUNE_BLOCKS.getDefaultState().withProperty(BlockBasicNeptune.BASIC_TYPE, BlockBasicNeptune.EnumBlockBasic.SUB_SURFACE);
	}
}
