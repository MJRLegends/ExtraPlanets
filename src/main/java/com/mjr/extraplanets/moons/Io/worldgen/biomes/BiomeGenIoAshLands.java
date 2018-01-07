package com.mjr.extraplanets.moons.Io.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicIo;
import com.mjr.extraplanets.moons.Io.worldgen.IoBiomes;

public class BiomeGenIoAshLands extends IoBiomes {

	public BiomeGenIoAshLands(BiomeProperties properties) {
		super(properties);
		this.topBlock = ExtraPlanets_Blocks.ASH_ROCK.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.IO_BLOCKS.getDefaultState().withProperty(BlockBasicIo.BASIC_TYPE, BlockBasicIo.EnumBlockBasic.SUB_SURFACE);
	}

	@Override
	public void registerTypes() {
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
