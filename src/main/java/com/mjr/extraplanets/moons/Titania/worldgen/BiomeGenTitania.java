package com.mjr.extraplanets.moons.Titania.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenTitania extends TitaniaBiomes {

	public BiomeGenTitania(BiomeProperties properties) {
		super(properties);
	}

	@Override
	public void registerTypes() {
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
