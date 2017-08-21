package com.mjr.extraplanets.moons.Rhea.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;


public class WorldChunkManagerRhea extends WorldChunkManagerSpace {

	@Override
	public BiomeGenBase getBiome() {
		return RheaBiomes.rhea;
	}

}
