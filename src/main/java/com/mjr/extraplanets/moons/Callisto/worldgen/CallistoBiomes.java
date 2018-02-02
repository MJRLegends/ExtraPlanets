package com.mjr.extraplanets.moons.Callisto.worldgen;

import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.world.biome.BiomeGenBase;
import com.mjr.extraplanets.Config;

public class CallistoBiomes extends BiomeGenBaseGC {

	public static final BiomeGenBase callisto = new BiomeGenCallisto(Config.CALLISTO_BIOME_ID).setBiomeName("Callisto").setHeight(new Height(2.5F, 0.4F));

	protected CallistoBiomes(int var1) {
		super(var1);
		this.rainfall = 0F;
	}
}
