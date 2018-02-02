package com.mjr.extraplanets.moons.Ganymede.worldgen;

import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.world.biome.Biome;

public class GanymedeBiomes extends BiomeGenBaseGC {

	public static final Biome ganymede = new BiomeGenGanymede(new BiomeProperties("Ganymede").setBaseHeight(2.5F).setHeightVariation(0.4F).setRainfall(0.0F).setRainDisabled());

	protected GanymedeBiomes(BiomeProperties properties) {
		super(properties);
	}
}
