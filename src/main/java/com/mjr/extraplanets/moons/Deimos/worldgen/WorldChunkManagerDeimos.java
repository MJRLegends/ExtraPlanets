package com.mjr.extraplanets.moons.Deimos.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldChunkManagerDeimos extends WorldChunkManagerSpace {

    @Override
    public BiomeGenBase getBiome() {
	return DeimosBiomes.deimos;
    }

}
