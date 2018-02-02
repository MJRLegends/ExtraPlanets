package com.mjr.extraplanets.moons.Io.worldgen.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicIo;
import com.mjr.extraplanets.moons.Io.worldgen.IoBiomes;

public class BiomeGenIo extends IoBiomes {

	public BiomeGenIo(BiomeProperties properties) {
		super(properties);
		Biome.registerBiome(Config.IO_BIOME_ID, Constants.TEXTURE_PREFIX + this.getBiomeName(), this);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.addTypes(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD);
		this.topBlock = ExtraPlanets_Blocks.IO_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.IO_BLOCKS.getDefaultState().withProperty(BlockBasicIo.BASIC_TYPE, BlockBasicIo.EnumBlockBasic.SUB_SURFACE);
	}
}
