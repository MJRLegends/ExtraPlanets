package com.mjr.extraplanets.planets.Ceres.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenCeres extends CeresBiomes {

	public BiomeGenCeres(int var1) {
		super(var1);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
