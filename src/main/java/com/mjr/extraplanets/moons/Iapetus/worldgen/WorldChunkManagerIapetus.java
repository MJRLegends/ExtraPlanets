package com.mjr.extraplanets.moons.Iapetus.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldChunkManagerIapetus extends WorldChunkManagerSpace {

	@Override
	public BiomeGenBase getBiome() {
		return IapetusBiomes.iapetus;
	}

}
