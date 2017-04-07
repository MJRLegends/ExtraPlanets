package com.mjr.extraplanets.moons.Io.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenIo extends IoBiomes {

	public BiomeGenIo(BiomeProperties properties) {
		super(properties);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
