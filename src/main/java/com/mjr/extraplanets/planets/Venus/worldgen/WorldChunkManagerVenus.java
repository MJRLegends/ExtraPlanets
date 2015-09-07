package com.mjr.extraplanets.planets.Venus.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldChunkManagerVenus extends WorldChunkManagerSpace {

	@Override
	public BiomeGenBase getBiome() {
		return VenusBiomes.venus;
	}

}
