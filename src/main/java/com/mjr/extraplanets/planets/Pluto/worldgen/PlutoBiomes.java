package com.mjr.extraplanets.planets.Pluto.worldgen;

import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.world.biome.BiomeGenBase;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.planets.Eris.worldgen.BiomeGenEris;

public class PlutoBiomes extends BiomeGenBaseGC {
	public static final BiomeGenBase pluto = new BiomeGenEris(Config.PLUTO_BIOME_ID).setBiomeName("Pluto").setHeight(new Height(2.5F, 0.4F));

	protected PlutoBiomes(int var1) {
		super(var1);
		this.rainfall = 0F;
	}
}
