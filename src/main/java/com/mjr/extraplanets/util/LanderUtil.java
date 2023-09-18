package com.mjr.extraplanets.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkProviderServer;

public class LanderUtil {
	
    public static void makeSmallLandingSpot(World world, int x, int z, IBlockState block, boolean clearAbovePlatform)
    {
        loadChunksAround(x, z, -1, (ChunkProviderServer) world.getChunkProvider());
        makePlatform(world, x, world.getSeaLevel() - 1, z, block, clearAbovePlatform);
        return;
    }

    private static void loadChunksAround(int x, int z, int i, ChunkProviderServer cp)
    {
        cp.loadChunk(x >> 4, z >> 4);
        if ((x + i) >> 4 != x >> 4)
        {
            cp.loadChunk((x + i) >> 4, z >> 4);
            if ((z + i) >> 4 != z >> 4)
            {
                cp.loadChunk(x >> 4, (z + i) >> 4);
                cp.loadChunk((x + i) >> 4, (z + i) >> 4);
            }
        }
        else if ((z + i) >> 4 != z >> 4)
        {
            cp.loadChunk(x >> 4, (z + i) >> 4);
        }
    }

    private static void makePlatform(World world, int x, int y, int z, IBlockState block, boolean clearAbovePlatform)
    {
    	boolean isLiquidSpawn = world.getBlockState(world.getTopSolidOrLiquidBlock(new BlockPos(x, 255, z))).getMaterial().isLiquid();
    	if(clearAbovePlatform) {
    		if(!isLiquidSpawn)
    			y = world.getTopSolidOrLiquidBlock(new BlockPos(x, 255, z)).getY() - 1;
	        {
	            for (int zz = -3; zz < 3; zz++)
	            {
	    	    	for (int yy = 64; yy < 256; yy++)
	    	        {
		                if (xx == -3 && (zz == -3 || zz == 2))
		                {
		                    continue;
		                }
		                if (xx == 2 && (zz == -3 || zz == 2))
		                {
		                    continue;
		                }
		                doBlock(world, x + xx, yy, z + zz, Blocks.AIR.getDefaultState());
	    	        }
	            }
	        }
        }
		if(isLiquidSpawn) {
	        for (int xx = -3; xx < 3; xx++)
	        {
	            for (int zz = -3; zz < 3; zz++)
	            {
	                if (xx == -3 && (zz == -3 || zz == 2))
	                {
	                    continue;
	                }
	                if (xx == 2 && (zz == -3 || zz == 2))
	                {
	                    continue;
	                }
	                doBlock(world, x + xx, y, z + zz, block);
	            }
	        }
	        
	        for (int xx = -2; xx < 2; xx++)
	        {
	            for (int zz = -2; zz < 2; zz++)
	            {
	                doBlock(world, x + xx, y - 1, z + zz, block);
	            }
	        }
	        doBlock(world, x - 1, y - 2, z - 1, block);
	        doBlock(world, x - 1, y - 2, z, block);
	        doBlock(world, x, y - 2, z, block);
	        doBlock(world, x, y - 2, z - 1, block);
		}
    }
    
    private static void doBlock(World world, int x, int y, int z, IBlockState block)
    {
    	world.setBlockState(new BlockPos(x, y, z), block, 3);
    }
}
