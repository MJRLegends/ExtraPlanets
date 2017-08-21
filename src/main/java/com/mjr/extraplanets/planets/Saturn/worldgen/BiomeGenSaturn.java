package com.mjr.extraplanets.planets.Saturn.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenSaturn extends SaturnBiomes {

	public BiomeGenSaturn(int par1)
	{
		super(par1);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
