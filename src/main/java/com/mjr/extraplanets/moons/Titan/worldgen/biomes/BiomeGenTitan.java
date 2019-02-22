package com.mjr.extraplanets.moons.Titan.worldgen.biomes;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Titan.worldgen.TitanBiomes;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenTitan extends TitanBiomes {
	public BiomeGenTitan(int par1) {
		super(par1);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD);
		this.topBlock = ExtraPlanets_Blocks.TITAN_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.TITAN_BLOCKS.getStateFromMeta(1);
	}
}
