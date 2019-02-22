package com.mjr.extraplanets.moons.Oberon.worldgen.biomes;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicOberon;
import com.mjr.extraplanets.moons.Oberon.worldgen.OberonBiomes;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenOberon extends OberonBiomes {

	public BiomeGenOberon(BiomeProperties properties) {
		super(properties);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD);
		this.topBlock = ExtraPlanets_Blocks.OBERON_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.OBERON_BLOCKS.getDefaultState().withProperty(BlockBasicOberon.BASIC_TYPE, BlockBasicOberon.EnumBlockBasic.SUB_SURFACE);
	}
}
