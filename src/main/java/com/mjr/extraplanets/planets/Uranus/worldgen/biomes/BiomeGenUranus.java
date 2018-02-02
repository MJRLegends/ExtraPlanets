package com.mjr.extraplanets.planets.Uranus.worldgen.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicUranus;
import com.mjr.extraplanets.planets.Uranus.worldgen.UranusBiomes;

public class BiomeGenUranus extends UranusBiomes {

	public BiomeGenUranus(BiomeProperties properties) {
		super(properties);
		this.topBlock = ExtraPlanets_Blocks.URANUS_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.URANUS_BLOCKS.getDefaultState().withProperty(BlockBasicUranus.BASIC_TYPE, BlockBasicUranus.EnumBlockBasic.SUB_SURFACE);
	}

	@Override
	public void registerTypes(Biome b) {
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.addTypes(b, BiomeDictionary.Type.COLD, BiomeDictionary.Type.WET, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SNOWY);
	}
}
