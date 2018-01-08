package com.mjr.extraplanets.moons.Oberon.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicOberon;
import com.mjr.extraplanets.moons.Oberon.worldgen.OberonBiomes;

public class BiomeGenOberon extends OberonBiomes {

	public BiomeGenOberon(BiomeProperties properties) {
		super(properties);
		this.topBlock = ExtraPlanets_Blocks.OBERON_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.OBERON_BLOCKS.getDefaultState().withProperty(BlockBasicOberon.BASIC_TYPE, BlockBasicOberon.EnumBlockBasic.SUB_SURFACE);
	}

	@Override
	public void registerTypes() {
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
