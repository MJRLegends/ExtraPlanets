package com.mjr.extraplanets.moons.Rhea.worldgen;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;

public class BiomeGenRhea extends RheaBiomes {

	public BiomeGenRhea(BiomeProperties properties) {
		super(properties);
	}

	@Override
	public void registerTypes(Biome b) {
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.addTypes(b, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD);
	}
}
