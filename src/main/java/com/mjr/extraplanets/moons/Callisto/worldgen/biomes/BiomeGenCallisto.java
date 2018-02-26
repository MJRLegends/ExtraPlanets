package com.mjr.extraplanets.moons.Callisto.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicCallisto;
import com.mjr.extraplanets.moons.Callisto.worldgen.CallistoBiomes;

public class BiomeGenCallisto extends CallistoBiomes {

	public BiomeGenCallisto(int var1) {
		super(var1);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.WET, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SNOWY);
		this.topBlock = ExtraPlanets_Blocks.CALLISTO_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.CALLISTO_BLOCKS.getDefaultState().withProperty(BlockBasicCallisto.BASIC_TYPE, BlockBasicCallisto.EnumBlockBasic.SUB_SURFACE);
	}
}
