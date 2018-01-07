package com.mjr.extraplanets.planets.Neptune.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicNeptune;
import com.mjr.extraplanets.planets.Neptune.worldgen.NeptuneBiomes;

public class BiomeGenNeptune extends NeptuneBiomes {

	public BiomeGenNeptune(BiomeProperties properties) {
		super(properties);
		this.topBlock = ExtraPlanets_Blocks.NEPTUNE_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.NEPTUNE_BLOCKS.getDefaultState().withProperty(BlockBasicNeptune.BASIC_TYPE, BlockBasicNeptune.EnumBlockBasic.SUB_SURFACE);
	}

	@Override
	public void registerTypes() {
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
