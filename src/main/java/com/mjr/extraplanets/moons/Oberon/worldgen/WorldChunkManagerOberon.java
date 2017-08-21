package com.mjr.extraplanets.moons.Oberon.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;


public class WorldChunkManagerOberon extends WorldChunkManagerSpace {

	@Override
	public BiomeGenBase getBiome() {
		return OberonBiomes.oberon;
	}

}
