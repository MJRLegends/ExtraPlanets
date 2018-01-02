package com.mjr.extraplanets.moons.Deimos.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenDeimos extends DeimosBiomes {

	public BiomeGenDeimos(int par1) {
		super(par1);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
