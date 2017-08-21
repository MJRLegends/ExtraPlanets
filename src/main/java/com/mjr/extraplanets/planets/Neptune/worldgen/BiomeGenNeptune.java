package com.mjr.extraplanets.planets.Neptune.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenNeptune extends NeptuneBiomes {

	public BiomeGenNeptune(int var1) {
		super(var1);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
