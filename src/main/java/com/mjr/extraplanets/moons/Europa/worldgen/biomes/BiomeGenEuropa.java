package com.mjr.extraplanets.moons.Europa.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicEuropa;
import com.mjr.extraplanets.moons.Europa.worldgen.EuropaBiomes;

public class BiomeGenEuropa extends EuropaBiomes {

	public BiomeGenEuropa(int var1) {
		super(var1);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.WET, BiomeDictionary.Type.DEAD);
		this.topBlock = ExtraPlanets_Blocks.EUROPA_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.EUROPA_BLOCKS.getDefaultState().withProperty(BlockBasicEuropa.BASIC_TYPE, BlockBasicEuropa.EnumBlockBasic.SUB_SURFACE);
	}
}
