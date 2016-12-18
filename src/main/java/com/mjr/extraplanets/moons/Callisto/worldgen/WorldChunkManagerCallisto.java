package com.mjr.extraplanets.moons.Callisto.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldChunkManagerCallisto extends WorldChunkManagerSpace {

	@Override
	public BiomeGenBase getBiome() {
		return CallistoBiomes.callisto;
	}

}
