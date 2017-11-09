package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.BlockCakeBlocks;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class BiomeGenKepler22bCandyLand extends BiomeGenBaseKepler22b {
	public BiomeGenKepler22bCandyLand(BiomeProperties properties) {
		super(properties);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
		this.topBlock = ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState().withProperty(BlockCakeBlocks.BASIC_TYPE, BlockCakeBlocks.EnumBlockBasic.WHITE_ICING_RED_DOTS);
		this.fillerBlock = ExtraPlanets_Blocks.CAKE_BLOCKS.getDefaultState();

		this.getBiomeDecorator().generateHuts = false;
		this.getBiomeDecorator().generateCandyCanes = true;
	}
}