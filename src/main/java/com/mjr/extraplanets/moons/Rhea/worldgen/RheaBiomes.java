package com.mjr.extraplanets.moons.Rhea.worldgen;

import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.world.biome.Biome;

public class RheaBiomes extends BiomeGenBaseGC {

	public static final Biome rhea = new BiomeGenRhea(new BiomeProperties("Rhea").setBaseHeight(2.5F).setHeightVariation(0.4F).setRainfall(0.0F).setRainDisabled());

	protected RheaBiomes(BiomeProperties properties) {
		super(properties, true);
	}
}
