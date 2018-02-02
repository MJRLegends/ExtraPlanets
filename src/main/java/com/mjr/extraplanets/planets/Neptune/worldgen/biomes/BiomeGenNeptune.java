package com.mjr.extraplanets.planets.Neptune.worldgen.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
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
	public void registerTypes(Biome b) {
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.addTypes(b, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD);
	}
}
