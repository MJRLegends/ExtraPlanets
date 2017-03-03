package com.mjr.extraplanets.planets.Kepler22b.worldgen.features;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockBasicKepler22bPlanks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeLeaves;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeLog;

public class WorldGenKepler22bBlueMapleTree extends WorldGenAbstractTree
{
    private static final IBlockState field_181629_a = Blocks.log.getDefaultState().withProperty(BlockKepler22bMapleTreeLog.VARIANT, BlockKepler22bMapleTreeLog.EnumType.MAPLE_BLUE);
    private static final IBlockState field_181630_b = Blocks.leaves.getDefaultState().withProperty(BlockKepler22bMapleTreeLeaves.VARIANT, BlockBasicKepler22bPlanks.EnumType.MAPLE_BLUE).withProperty(BlockKepler22bMapleTreeLeaves.CHECK_DECAY, Boolean.valueOf(false));
    private boolean useExtraRandomHeight;

    public WorldGenKepler22bBlueMapleTree(boolean p_i45449_1_, boolean p_i45449_2_)
    {
        super(p_i45449_1_);
        this.useExtraRandomHeight = p_i45449_2_;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        int i = rand.nextInt(3) + 5;

        if (this.useExtraRandomHeight)
        {
            i += rand.nextInt(7);
        }

        boolean flag = true;

        if (position.getY() >= 1 && position.getY() + i + 1 <= 256)
        {
            for (int j = position.getY(); j <= position.getY() + 1 + i; ++j)
            {
                int k = 1;

                if (j == position.getY())
                {
                    k = 0;
                }

                if (j >= position.getY() + 1 + i - 2)
                {
                    k = 2;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for (int l = position.getX() - k; l <= position.getX() + k && flag; ++l)
                {
                    for (int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1)
                    {
                        if (j >= 0 && j < 256)
                        {
                            if (!this.isReplaceable(worldIn, blockpos$mutableblockpos.set(l, j, i1)))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                BlockPos down = position.down();
                Block block1 = worldIn.getBlockState(down).getBlock();
                boolean isSoil = block1.canSustainPlant(worldIn, down, net.minecraft.util.EnumFacing.UP, ((net.minecraft.block.BlockSapling)Blocks.sapling));

                if (isSoil && position.getY() < 256 - i - 1)
                {
                    block1.onPlantGrow(worldIn, down, position);

                    for (int i2 = position.getY() - 3 + i; i2 <= position.getY() + i; ++i2)
                    {
                        int k2 = i2 - (position.getY() + i);
                        int l2 = 1 - k2 / 2;

                        for (int i3 = position.getX() - l2; i3 <= position.getX() + l2; ++i3)
                        {
                            int j1 = i3 - position.getX();

                            for (int k1 = position.getZ() - l2; k1 <= position.getZ() + l2; ++k1)
                            {
                                int l1 = k1 - position.getZ();

                                if (Math.abs(j1) != l2 || Math.abs(l1) != l2 || rand.nextInt(2) != 0 && k2 != 0)
                                {
                                    BlockPos blockpos = new BlockPos(i3, i2, k1);
                                    Block block = worldIn.getBlockState(blockpos).getBlock();

                                    if (block.isAir(worldIn, blockpos) || block.isLeaves(worldIn, blockpos))
                                    {
                                        this.setBlockAndNotifyAdequately(worldIn, blockpos, field_181630_b);
                                    }
                                }
                            }
                        }
                    }

                    for (int j2 = 0; j2 < i; ++j2)
                    {
                        BlockPos upN = position.up(j2);
                        Block block2 = worldIn.getBlockState(upN).getBlock();
                        if (block2.isAir(worldIn, upN) || block2.isLeaves(worldIn, upN))
                        {
                            this.setBlockAndNotifyAdequately(worldIn, position.up(j2), field_181629_a);
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }
}