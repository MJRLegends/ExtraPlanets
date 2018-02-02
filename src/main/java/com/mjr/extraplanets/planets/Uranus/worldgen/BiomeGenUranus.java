package com.mjr.extraplanets.planets.Uranus.worldgen;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

public class BiomeGenUranus extends UranusBiomes {

	public BiomeGenUranus(BiomeProperties properties) {
		super(properties);
	}

	@Override
	public void registerTypes(Biome b) {
		BiomeDictionary.addTypes(b, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
	}
}
