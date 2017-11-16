package com.mjr.extraplanets.planets.Neptune.worldgen.biomes;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.BlockDecorativeBlocks2;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Neptune.worldgen.NeptuneBiomes;

public class BiomeGenNeptuneLayeredHills extends NeptuneBiomes {

	public IBlockState secondtopBlock;
	public IBlockState thridtopBlocks;

	public BiomeGenNeptuneLayeredHills(int var1) {
		super(var1);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.HOT);
		this.topBlock = ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.BLUE_BLOCK);
		this.thridtopBlocks = ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.LIGHT_BLUE_BLOCK);
		this.secondtopBlock = ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.GREEN_BLOCK);
		this.fillerBlock = ExtraPlanets_Blocks.DECORATIVE_BLOCKS2.getDefaultState().withProperty(BlockDecorativeBlocks2.BASIC_TYPE, BlockDecorativeBlocks2.EnumBlockBasic.YELLOW_BLOCK);
	}

	@Override
	public void genTerrainBlocks(World world, Random rand, ChunkPrimer chunk, int x, int z, double stoneNoise) {
		this.generateNeptuneBiomeTerrain(rand, chunk, x, z, stoneNoise);
	}

	@Override
	public void generateNeptuneBiomeTerrain(Random rand, ChunkPrimer chunk, int x, int z, double stoneNoise) {
		IBlockState iblockstate = this.topBlock;
		IBlockState iblockstate3 = this.secondtopBlock;
		IBlockState iblockstate4 = this.thridtopBlocks;
		IBlockState iblockstate1 = this.fillerBlock;
		int j = -1;
		int k = (int) (stoneNoise / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
		int l = x & 15;
		int i1 = z & 15;
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

		for (int j1 = 255; j1 >= 0; --j1) {
			if (j1 <= rand.nextInt(5)) {
				chunk.setBlockState(i1, j1, l, Blocks.bedrock.getDefaultState());
			} else {
				IBlockState iblockstate2 = chunk.getBlockState(i1, j1, l);
				if (iblockstate2.getBlock().getMaterial() == Material.air) {
					j = -1;
				} else if (iblockstate2.getBlock() == ExtraPlanets_Blocks.NEPTUNE_BLOCKS.getStateFromMeta(2).getBlock()) {
					if (j == -1) {
						if (k <= 0) {
							iblockstate = null;
							iblockstate1 = ExtraPlanets_Blocks.NEPTUNE_BLOCKS.getStateFromMeta(2);
							iblockstate3 = null;
							iblockstate4 = null;
						} else if (j1 >= 63 - 4 && j1 <= 63 + 1) {
							iblockstate = this.topBlock;
							iblockstate1 = this.fillerBlock;
							iblockstate3 = this.secondtopBlock;
							iblockstate4 = this.thridtopBlocks;
						}

						if (j1 < 63 && (iblockstate == null || iblockstate.getBlock().getMaterial() == Material.air)) {
							if (this.getFloatTemperature(blockpos$mutableblockpos.set(x, j1, z)) < 0.15F) {
								iblockstate = Blocks.ice.getDefaultState();
							} else {
								iblockstate = Blocks.water.getDefaultState();
							}
						}

						j = k;

						if (j1 >= 65 + 18) {
							chunk.setBlockState(i1, j1, l, iblockstate);
							iblockstate1 = iblockstate;
							iblockstate3 = iblockstate;
							iblockstate4 = iblockstate;
						} else if (j1 >= 65 + 12) {
							chunk.setBlockState(i1, j1, l, iblockstate3);
							iblockstate1 = iblockstate3;
							iblockstate = iblockstate3;
							iblockstate4 = iblockstate3;
						} else if (j1 >= 65 + 4) {
							chunk.setBlockState(i1, j1, l, iblockstate4);
							iblockstate1 = iblockstate4;
							iblockstate = iblockstate4;
							iblockstate3 = iblockstate4;
						} else if (j1 < 63 - 7 - k) {
							iblockstate = null;
							iblockstate3 = null;
							iblockstate1 = ExtraPlanets_Blocks.NEPTUNE_BLOCKS.getStateFromMeta(2);
							chunk.setBlockState(i1, j1, l, Blocks.gravel.getDefaultState());
						} else {
							chunk.setBlockState(i1, j1, l, iblockstate1);
						}
					} else if (j > 0) {
						--j;
						chunk.setBlockState(i1, j1, l, iblockstate1);
					}
				}
			}
		}
	}
}
