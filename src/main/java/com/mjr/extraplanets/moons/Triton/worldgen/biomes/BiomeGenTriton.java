package com.mjr.extraplanets.moons.Triton.worldgen.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicTriton;
import com.mjr.extraplanets.moons.Triton.worldgen.TritonBiomes;

public class BiomeGenTriton extends TritonBiomes {

	public BiomeGenTriton(BiomeProperties properties) {
		super(properties);
		Biome.registerBiome(Config.TRITON_BIOME_ID, Constants.TEXTURE_PREFIX + this.getBiomeName(), this);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.WET, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SNOWY);
		this.topBlock = ExtraPlanets_Blocks.TRITON_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.TRITON_BLOCKS.getDefaultState().withProperty(BlockBasicTriton.BASIC_TYPE, BlockBasicTriton.EnumBlockBasic.SUB_SURFACE);
	}
}
