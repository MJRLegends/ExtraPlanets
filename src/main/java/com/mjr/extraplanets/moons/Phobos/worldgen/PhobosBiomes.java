package com.mjr.extraplanets.moons.Phobos.worldgen;

import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.world.biome.BiomeGenBase;

import com.mjr.extraplanets.Config;

public class PhobosBiomes extends BiomeGenBaseGC {
	public static final BiomeGenBase phobos = new BiomeGenPhobos(Config.PHOBOS_BIOME_ID).setBiomeName("Phobos").setHeight(new Height(2.5F, 0.4F));

	protected PhobosBiomes(int par1) {
		super(par1);
		this.rainfall = 0F;
	}
}
