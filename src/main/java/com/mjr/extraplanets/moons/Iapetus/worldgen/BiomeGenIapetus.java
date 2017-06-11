package com.mjr.extraplanets.moons.Iapetus.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenIapetus extends IapetusBiomes {

	public BiomeGenIapetus(BiomeProperties properties) {
		super(properties);
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
