package com.mjr.extraplanets.moons.Rhea.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenRhea extends RheaBiomes {

	public BiomeGenRhea(int par1)
	{
		super(par1);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
