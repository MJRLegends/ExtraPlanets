package com.mjr.extraplanets.planets.Pluto.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenPluto extends PlutoBiomes {

	public BiomeGenPluto(int var1) {
		super(var1);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
