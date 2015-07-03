package com.mjr.extraplanets.planets.Uranus.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldChunkManagerUranus extends WorldChunkManagerSpace {

    @Override
    public BiomeGenBase getBiome() {
	return UranusBiomes.uranus;
    }

}
