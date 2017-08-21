package com.mjr.extraplanets.moons.Titania.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenTitania extends TitaniaBiomes {

	public BiomeGenTitania(int par1) {
		super(par1);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
