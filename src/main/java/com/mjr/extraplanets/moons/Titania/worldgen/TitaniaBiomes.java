package com.mjr.extraplanets.moons.Titania.worldgen;

import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.world.biome.Biome;

public class TitaniaBiomes extends BiomeGenBaseGC {

	public static final Biome titania = new BiomeGenTitania(new BiomeProperties("Titania").setBaseHeight(2.5F).setHeightVariation(0.4F).setRainfall(0.0F).setRainDisabled());

	protected TitaniaBiomes(BiomeProperties properties) {
		super(properties, true);
	}
}
