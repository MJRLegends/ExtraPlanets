package com.mjr.extraplanets.moons.triton.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldChunkManagerTriton extends WorldChunkManagerSpace {

	@Override
	public BiomeGenBase getBiome() {
		return TritonBiomes.triton;
	}

}
