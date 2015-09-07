package com.mjr.extraplanets.planets.Eris.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldChunkManagerEris extends WorldChunkManagerSpace {

	@Override
	public BiomeGenBase getBiome() {
		return ErisBiomes.eris;
	}

}
