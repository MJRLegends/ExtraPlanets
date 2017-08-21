package com.mjr.extraplanets.moons.Titania.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldChunkManagerTitania extends WorldChunkManagerSpace {

	@Override
	public BiomeGenBase getBiome() {
		return TitaniaBiomes.titania;
	}

}
