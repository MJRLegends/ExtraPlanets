package com.mjr.extraplanets.moons.Iapetus.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenIapetus extends IapetusBiomes {

	public BiomeGenIapetus(int par1) {
		super(par1);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
