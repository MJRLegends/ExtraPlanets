package com.mjr.extraplanets.planets.Neptune.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldChunkManagerNeptune extends WorldChunkManagerSpace {

    @Override
    public BiomeGenBase getBiome() {
	return NeptuneBiomes.neptune;
    }

}
