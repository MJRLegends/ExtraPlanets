package com.mjr.extraplanets.planets.Mercury.worldgen.dungeon;

import java.util.Random;

import com.mjr.extraplanets.Constants;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;

import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class RoomSpawner2Mercury extends RoomEmptyMercury
{
    public RoomSpawner2Mercury()
    {
    }

    public RoomSpawner2Mercury(DungeonConfiguration configuration, Random rand, int blockPosX, int blockPosZ, int sizeX, int sizeY, int sizeZ, EnumFacing entranceDir)
    {
        super(configuration, rand, blockPosX, blockPosZ, sizeX, sizeY, sizeZ, entranceDir);
    }

    @Override
    public boolean addComponentParts(World worldIn, Random random, StructureBoundingBox boundingBox)
    {
        if (super.addComponentParts(worldIn, random, boundingBox))
        {
            for (int i = 1; i <= this.sizeX - 1; ++i)
            {
                for (int j = 1; j <= this.sizeY - 1; ++j)
                {
                    for (int k = 1; k <= this.sizeZ - 1; ++k)
                    {
                        if (random.nextFloat() < 0.035F)
                        {
                            this.setBlockState(worldIn, Blocks.WEB.getDefaultState(), i, j, k, boundingBox);
                        }
                    }
                }
            }

            this.setBlockState(worldIn, Blocks.MOB_SPAWNER.getDefaultState(), 3, 0, 3, boundingBox);
            this.setBlockState(worldIn, Blocks.MOB_SPAWNER.getDefaultState(), this.sizeX - 3, 0, this.sizeZ - 3, boundingBox);
            
            this.setBlockState(worldIn, Blocks.MOB_SPAWNER.getDefaultState(), 2, 0, 2, boundingBox);
            this.setBlockState(worldIn, Blocks.MOB_SPAWNER.getDefaultState(), this.sizeX - 2, 0, this.sizeZ - 2, boundingBox);
            
            for(int i = 1; i < 7; i++)
            	this.setBlockState(worldIn, Blocks.LAVA.getDefaultState(), 1, i, 1, boundingBox);
            for(int i = 1; i < 7; i++)
            	this.setBlockState(worldIn, Blocks.LAVA.getDefaultState(), this.sizeX - 1, i, this.sizeZ - 1, boundingBox);
            for(int i = 1; i < 7; i++)
            	this.setBlockState(worldIn, Blocks.LAVA.getDefaultState(), 2, i, 2, boundingBox);
            for(int i = 1; i < 7; i++)
            	this.setBlockState(worldIn, Blocks.LAVA.getDefaultState(), this.sizeX - 2, i, this.sizeZ - 2, boundingBox);
            
            BlockPos blockpos = new BlockPos(this.getXWithOffset(3, 3), this.getYWithOffset(0), this.getZWithOffset(3, 3));
            TileEntityMobSpawner spawner = (TileEntityMobSpawner) worldIn.getTileEntity(blockpos);

            if (spawner != null)
            {
                spawner.getSpawnerBaseLogic().setEntityName(getMob(random));
            }

            blockpos = new BlockPos(this.getXWithOffset(this.sizeX - 3, this.sizeZ - 3), this.getYWithOffset(0), this.getZWithOffset(this.sizeX - 3, this.sizeZ - 3));
            spawner = (TileEntityMobSpawner) worldIn.getTileEntity(blockpos);

            if (spawner != null)
            {
                spawner.getSpawnerBaseLogic().setEntityName(getMob(random));
            }
            
            blockpos = new BlockPos(this.getXWithOffset(2, 2), this.getYWithOffset(0), this.getZWithOffset(2, 2));
            spawner = (TileEntityMobSpawner) worldIn.getTileEntity(blockpos);

            if (spawner != null)
            {
                spawner.getSpawnerBaseLogic().setEntityName(getMob(random));
            }
            
            blockpos = new BlockPos(this.getXWithOffset(this.sizeX - 2, this.sizeZ - 2), this.getYWithOffset(0), this.getZWithOffset(this.sizeX - 2, this.sizeZ - 2));
            spawner = (TileEntityMobSpawner) worldIn.getTileEntity(blockpos);

            if (spawner != null)
            {
                spawner.getSpawnerBaseLogic().setEntityName(getMob(random));
            }

            return true;
        }

        return false;
    }

    private static String getMob(Random rand)
    {
        return Constants.modID + "." + "EvolvedMagmaCube";
    }
}