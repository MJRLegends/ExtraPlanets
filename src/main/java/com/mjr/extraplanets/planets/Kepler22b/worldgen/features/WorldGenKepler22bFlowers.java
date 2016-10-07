package com.mjr.extraplanets.planets.Kepler22b.worldgen.features;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenKepler22bFlowers extends WorldGenerator
{
    private Block flowerBlock;
    private int flowerBlockMeta;

    public WorldGenKepler22bFlowers(Block flowerBlock, int flowerBlockMeta)
    {
        this.flowerBlock = flowerBlock;
        this.flowerBlockMeta = flowerBlockMeta;
    }

    public boolean generate(World world, Random rand, int x, int y, int z)
    {
        for (int l = 0; l < 64; ++l)
        {
            int i1 = x + rand.nextInt(8) - rand.nextInt(8);
            int j1 = y + rand.nextInt(4) - rand.nextInt(4);
            int k1 = z + rand.nextInt(8) - rand.nextInt(8);

            if (world.isAirBlock(i1, j1, k1) && (!world.provider.hasNoSky || j1 < 255) && this.flowerBlock.canBlockStay(world, i1, j1, k1))
            {
                world.setBlock(i1, j1, k1, this.flowerBlock, this.flowerBlockMeta, 2);
            }
        }

        return true;
    }
}