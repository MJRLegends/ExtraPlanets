package com.mjr.extraplanets.moons.Oberon.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Oberon.worldgen.OberonBiomes;

public class BiomeGenOberon extends OberonBiomes {

	public BiomeGenOberon(int var1) {
		super(var1);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD);
		this.topBlock = ExtraPlanets_Blocks.OBERON_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.OBERON_BLOCKS.getStateFromMeta(1);
	}
}
