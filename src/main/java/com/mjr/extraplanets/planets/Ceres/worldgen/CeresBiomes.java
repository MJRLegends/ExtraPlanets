package com.mjr.extraplanets.planets.Ceres.worldgen;

import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.world.biome.BiomeGenBase;

import com.mjr.extraplanets.Config;

public class CeresBiomes extends BiomeGenBaseGC {
	public static final BiomeGenBase ceres = new BiomeGenCeres(Config.CERES_BIOME_ID).setBiomeName("Ceres").setHeight(new Height(0.4F, 0.0F));

	protected CeresBiomes(int var1) {
		super(var1);
		this.rainfall = 0F;
	}

	@Override
	public float getSpawningChance() {
		return 0.01F;
	}
}
