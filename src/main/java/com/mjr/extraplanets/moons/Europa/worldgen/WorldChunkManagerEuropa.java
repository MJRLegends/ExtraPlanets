package com.mjr.extraplanets.moons.Europa.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;


public class WorldChunkManagerEuropa extends WorldChunkManagerSpace {

	@Override
	public BiomeGenBase getBiome() {
		return EuropaBiomes.europa;
	}

}
