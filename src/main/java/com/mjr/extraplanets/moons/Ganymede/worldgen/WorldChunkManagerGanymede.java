package com.mjr.extraplanets.moons.Ganymede.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;


public class WorldChunkManagerGanymede extends WorldChunkManagerSpace {

	@Override
	public BiomeGenBase getBiome() {
		return GanymedeBiomes.ganymede;
	}

}
