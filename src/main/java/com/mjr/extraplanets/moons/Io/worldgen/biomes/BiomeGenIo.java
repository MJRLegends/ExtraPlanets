package com.mjr.extraplanets.moons.Io.worldgen.biomes;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Io.worldgen.IoBiomes;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenIo extends IoBiomes {

	public BiomeGenIo(int par1) {
		super(par1);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD);
		this.topBlock = ExtraPlanets_Blocks.IO_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.IO_BLOCKS.getStateFromMeta(1);
	}
}
