package com.mjr.extraplanets.moons.Callisto.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicCallisto;
import com.mjr.extraplanets.moons.Callisto.worldgen.CallistoBiomes;

public class BiomeGenCallistoShaleMountains extends CallistoBiomes {

	public BiomeGenCallistoShaleMountains(int id) {
		super(id);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.MOUNTAIN);
		this.topBlock = ExtraPlanets_Blocks.CALLISTO_BLOCKS.getDefaultState().withProperty(BlockBasicCallisto.BASIC_TYPE, BlockBasicCallisto.EnumBlockBasic.DRIED_OIL);
		this.fillerBlock = ExtraPlanets_Blocks.CALLISTO_BLOCKS.getDefaultState().withProperty(BlockBasicCallisto.BASIC_TYPE, BlockBasicCallisto.EnumBlockBasic.SHALE_OIL);
	}
}
