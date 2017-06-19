package com.mjr.extraplanets.moons.Titan.worldgen.biomes;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public abstract class GenLayerTitan extends GenLayer
{
    public GenLayerTitan(long l)
    {
        super(l);
    }

    public static GenLayer[] createWorld(long l)
    {
        GenLayer biomes = new GenLayerTitanBiomes(l);
        biomes = new GenLayerZoom(1000L, biomes);
        biomes = new GenLayerZoom(1001L, biomes);
        biomes = new GenLayerZoom(1002L, biomes);
        biomes = new GenLayerZoom(1003L, biomes);
        GenLayer genLayerVeronoiZoom = new GenLayerVoronoiZoom(10L, biomes);
        biomes.initWorldGenSeed(l);
        genLayerVeronoiZoom.initWorldGenSeed(l);

        return new GenLayer[] { biomes, genLayerVeronoiZoom };
    }
}
