package com.mjr.extraplanets.moons.Phobos.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldChunkManagerPhobos extends WorldChunkManagerSpace {

	@Override
	public BiomeGenBase getBiome() {
		return PhobosBiomes.phobos;
	}

}
