package com.mjr.extraplanets.moons.Callisto.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenCallisto extends CallistoBiomes {

	public BiomeGenCallisto(int par1) {
		super(par1);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
