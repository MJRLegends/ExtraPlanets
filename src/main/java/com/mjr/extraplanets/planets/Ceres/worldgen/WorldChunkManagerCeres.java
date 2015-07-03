package com.mjr.extraplanets.planets.Ceres.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldChunkManagerCeres extends WorldChunkManagerSpace {

    @Override
    public BiomeGenBase getBiome() {
	return CeresBiomes.ceres;
    }

}
