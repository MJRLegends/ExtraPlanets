package com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon;

import java.util.Random;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class EntranceCraterJupiter extends SizedPieceJupiter
{
    private final int range = 16;

    public EntranceCraterJupiter()
    {
    }

    public EntranceCraterJupiter(World world, DungeonConfiguration configuration, Random rand, int blockPosX, int blockPosZ)
    {
        super(configuration, rand.nextInt(4) + 6, 12, rand.nextInt(4) + 6, EnumFacing.Plane.HORIZONTAL.random(rand));
        this.setCoordBaseMode(EnumFacing.SOUTH);

        this.boundingBox = new StructureBoundingBox(blockPosX - range, configuration.getYPosition() + 11, blockPosZ - range, blockPosX + range, 150, blockPosZ + range);
    }

    @Override
    public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
    {
        int maxLevel = 0;

        for (int i = -range; i <= range; i++)
        {
            for (int k = -range; k <= range; k++)
            {
                int j = 150;
                int x = this.getXWithOffset(i + range, k + range);
                int z = this.getZWithOffset(i + range, k + range);

                while (j >= 0)
                {
                    j--;

                    int y = this.getYWithOffset(j);
                    BlockPos blockpos = new BlockPos(x, y, z);
                    Block block = worldIn.getBlockState(blockpos).getBlock();

                    if (Blocks.AIR != block)
                    {
                        break;
                    }
                }

                maxLevel = Math.max(maxLevel, j + 3);
            }
        }

        Mirror mirror = Mirror.NONE;
        Rotation rotation = Rotation.NONE;
        if (this.getCoordBaseMode() != null)
        {
            switch (this.getCoordBaseMode())
            {
                case SOUTH:
                    mirror = Mirror.LEFT_RIGHT;
                    break;
                case WEST:
                    mirror = Mirror.LEFT_RIGHT;
                    rotation = Rotation.CLOCKWISE_90;
                    break;
                case EAST:
                    rotation = Rotation.CLOCKWISE_90;
                    break;
                default:
                    break;
            }
        }

        for (int i = -range; i < range; i++)
        {
            for (int k = -range; k < range; k++)
            {
                final double xDev = i / 20D;
                final double zDev = k / 20D;
                final double distance = xDev * xDev + zDev * zDev;
                final int depth = (int) Math.abs(0.5 / (distance + .00001D));
                int helper = 0;
                for (int j = maxLevel; j > 1 && helper <= depth; j--)
                {
                    {
                        BlockPos blockpos = new BlockPos(this.getXWithOffset(i + range, k + range), this.getYWithOffset(j), this.getZWithOffset(i + range, k + range));
                        IBlockState state = Blocks.AIR.getDefaultState();

                        if (mirror != Mirror.NONE)
                        {
                            state = state.withMirror(mirror);
                        }

                        if (rotation != Rotation.NONE)
                        {
                            state = state.withRotation(rotation);
                        }

                        worldIn.setBlockState(blockpos, state, 2);
                        helper++;
                    }
                }
            }
        }

        return true;
    }

    @Override
    public PieceJupiter getNextPiece(DungeonStartJupiter startPiece, Random rand)
    {
        return new RoomEntranceJupiter(this.configuration, rand, this.boundingBox.minX + this.boundingBox.getXSize() / 2, this.boundingBox.minZ + this.boundingBox.getZSize() / 2);
    }
}
