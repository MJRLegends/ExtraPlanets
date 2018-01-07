package com.mjr.extraplanets.world.biome;

import net.minecraft.world.biome.Biome;

import com.mjr.extraplanets.ExtraPlanets;

public abstract class BiomeGenBase extends Biome {
	protected BiomeGenBase(BiomeProperties var1) {
		super(var1);
		ExtraPlanets.biomesList.add(this);
	}

	public void registerTypes() {
	}
}
