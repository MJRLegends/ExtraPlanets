package com.mjr.extraplanets.moons.Europa.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenEuropa extends EuropaBiomes {

	public BiomeGenEuropa(int var1) {
		super(var1);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
