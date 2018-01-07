package com.mjr.extraplanets.moons.Ganymede.worldgen;

import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenGanymede extends GanymedeBiomes {

	public BiomeGenGanymede(BiomeProperties properties) {
		super(properties);
	}

	@Override
	public void registerTypes() {
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
