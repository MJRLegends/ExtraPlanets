package com.mjr.extraplanets.planets.Jupiter.worldgen.biomes;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicJupiter;
import com.mjr.extraplanets.planets.Jupiter.worldgen.JupiterBiomes;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenJupiter extends JupiterBiomes {

	public BiomeGenJupiter(BiomeProperties properties) {
		super(properties);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
		this.topBlock = ExtraPlanets_Blocks.JUPITER_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.JUPITER_BLOCKS.getDefaultState().withProperty(BlockBasicJupiter.BASIC_TYPE, BlockBasicJupiter.EnumBlockBasic.SUB_SURFACE);
	}
}
