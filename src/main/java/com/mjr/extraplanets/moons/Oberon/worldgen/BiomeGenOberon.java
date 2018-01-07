package com.mjr.extraplanets.moons.Oberon.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenOberon extends OberonBiomes {

	public BiomeGenOberon(BiomeProperties properties) {
		super(properties);
	}

	@Override
	public void registerTypes() {
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
