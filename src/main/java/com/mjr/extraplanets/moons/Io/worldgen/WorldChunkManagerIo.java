package com.mjr.extraplanets.moons.Io.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldChunkManagerIo extends WorldChunkManagerSpace {

	@Override
	public BiomeGenBase getBiome() {
		return IoBiomes.io;
	}

}
