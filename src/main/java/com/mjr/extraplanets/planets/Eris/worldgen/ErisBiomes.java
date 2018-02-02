package com.mjr.extraplanets.planets.Eris.worldgen;

import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.world.biome.BiomeGenBase;

import com.mjr.extraplanets.Config;

public class ErisBiomes extends BiomeGenBaseGC {
	public static final BiomeGenBase eris = new BiomeGenEris(Config.ERIS_BIOME_ID).setBiomeName("Eris").setHeight(new Height(0.4F, 0.0F));

	protected ErisBiomes(int var1) {
		super(var1);
		this.rainfall = 0F;
	}
}
