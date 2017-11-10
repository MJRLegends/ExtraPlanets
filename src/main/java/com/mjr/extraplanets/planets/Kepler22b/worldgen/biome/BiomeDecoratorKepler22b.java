package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockBasicKepler22bTallGrass;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.WorldGenKepler22bDungeons;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.WorldGenKepler22bFlowers;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.WorldGenKepler22bTree;
import com.mjr.extraplanets.world.features.WorldGenBigBlueTree;
import com.mjr.extraplanets.world.features.WorldGenBigPurpleTree;
import com.mjr.extraplanets.world.features.WorldGenBigRedTree;
import com.mjr.extraplanets.world.features.WorldGenBlueHut;
import com.mjr.extraplanets.world.features.WorldGenBlueTower;
import com.mjr.extraplanets.world.features.WorldGenBrownHut;
import com.mjr.extraplanets.world.features.WorldGenCandyCaneType1;
import com.mjr.extraplanets.world.features.WorldGenCandyCaneType2;
import com.mjr.extraplanets.world.features.WorldGenCandyCaneType3;
import com.mjr.extraplanets.world.features.WorldGenCookieRocksType1;
import com.mjr.extraplanets.world.features.WorldGenCustomLake;
import com.mjr.extraplanets.world.features.WorldGenGreenHut;
import com.mjr.extraplanets.world.features.WorldGenLogTree;
import com.mjr.extraplanets.world.features.WorldGenPurpleHut;
import com.mjr.extraplanets.world.features.WorldGenRedHut;
import com.mjr.extraplanets.world.features.WorldGenWhiteSugerCane;
import com.mjr.extraplanets.world.features.WorldGenYellowHut;

public class BiomeDecoratorKepler22b extends BiomeDecorator {

	public int LakesPerChunk;
	public int InfectedLakesPerChunk;

	public int blueTreesPerChunk;
	public int redTreesPerChunk;
	public int purpleTreesPerChunk;
	public int yellowTreesPerChunk;
	public int greenTreesPerChunk;
	public int brownTreesPerChunk;

	public int blueShortGrassPerChunk;
	public int blueMedGrassPerChunk;
	public int blueTallGrassPerChunk;

	public int redShortGrassPerChunk;
	public int redMedGrassPerChunk;
	public int redTallGrassPerChunk;

	public int purpleShortGrassPerChunk;
	public int purpleMedGrassPerChunk;
	public int purpleTallGrassPerChunk;

	public int yellowShortGrassPerChunk;
	public int yellowMedGrassPerChunk;
	public int yellowTallGrassPerChunk;

	public int greenShortGrassPerChunk;
	public int greenMedGrassPerChunk;
	public int greenTallGrassPerChunk;

	public int purpleBigTreesPerChunk;
	public int blueBigTreesPerChunk;
	public int redBigTreesPerChunk;
	public int blueTowerPerChunk;

	public int treeWithNoLeafsPerChunk;
	public int bigTreeWithNoLeafsPerChunk;
	public boolean generateHuts;

	public boolean generateCandyCanes = false;

	private boolean isDecorating = false;

	@Override
	protected void genDecorations(Biome biomeIn, World worldIn, Random random) {
		if (isDecorating)
			return;
		isDecorating = true;

		for (int i = 0; i < this.LakesPerChunk; i++) {
			if (random.nextInt(10) == 0) {
				int x = this.chunkPos.getX() + random.nextInt(80) + 8;
				int z = this.chunkPos.getZ() + random.nextInt(80) + 8;
				int y = random.nextInt(256);
				new WorldGenCustomLake(Blocks.WATER).generate(worldIn, random, new BlockPos(x, y, z), Blocks.GRASS);
			}
		}
		for (int i = 0; i < this.InfectedLakesPerChunk; i++) {
			if (random.nextInt(15) == 0) {
				int x = this.chunkPos.getX() + random.nextInt(80) + 8;
				int z = this.chunkPos.getZ() + random.nextInt(80) + 8;
				int y = random.nextInt(256);
				new WorldGenCustomLake(ExtraPlanets_Fluids.INFECTED_WATER).generate(worldIn, random, new BlockPos(x, y, z), Blocks.GRASS);
			}
		}
		for (int i = 0; i < this.treeWithNoLeafsPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			if (random.nextInt(5) < 5)
				blockpos = blockpos.add(random.nextInt(12), 0, random.nextInt(12));
			else
				blockpos = blockpos.add(random.nextInt(12) * -1, 0, random.nextInt(12) * -1);
			new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG_2.getStateFromMeta(1), Blocks.AIR.getDefaultState(), false).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < this.bigTreeWithNoLeafsPerChunk; i++) {
			if (random.nextInt(5) == 1) {
				BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
				blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
				new WorldGenLogTree().generate(worldIn, random, blockpos);
			}
		}
		for (int i = 0; i < this.purpleBigTreesPerChunk; i++) {
			if (random.nextInt(100) == 1) {
				BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
				blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
				new WorldGenBigPurpleTree().generate(worldIn, random, blockpos);
			}
		}
		for (int i = 0; i < this.blueBigTreesPerChunk; i++) {
			if (random.nextInt(100) == 1) {
				BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
				blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
				new WorldGenBigBlueTree().generate(worldIn, random, blockpos);
			}
		}
		for (int i = 0; i < this.redBigTreesPerChunk; i++) {
			if (random.nextInt(100) == 1) {
				BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
				blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
				new WorldGenBigRedTree().generate(worldIn, random, blockpos);
			}
		}
		for (int i = 0; i < this.blueTowerPerChunk; i++) {
			if (random.nextInt(100) == 1) {
				BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
				blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
				blockpos = blockpos.down(4);
				(new WorldGenBlueTower()).generate(worldIn, random, blockpos);
				break;
			}
		}
		for (int i = 0; i < blueTreesPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			if (random.nextInt(5) < 5)
				blockpos = blockpos.add(random.nextInt(12), 0, random.nextInt(12));
			else
				blockpos = blockpos.add(random.nextInt(12) * -1, 0, random.nextInt(12) * -1);
			new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(0), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(0), false).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < redTreesPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			if (random.nextInt(5) < 5)
				blockpos = blockpos.add(random.nextInt(12), 0, random.nextInt(12));
			else
				blockpos = blockpos.add(random.nextInt(12) * -1, 0, random.nextInt(12) * -1);
			new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(1), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(1), false).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < purpleTreesPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			if (random.nextInt(5) < 5)
				blockpos = blockpos.add(random.nextInt(12), 0, random.nextInt(12));
			else
				blockpos = blockpos.add(random.nextInt(12) * -1, 0, random.nextInt(12) * -1);
			new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), false).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < yellowTreesPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			if (random.nextInt(5) < 5)
				blockpos = blockpos.add(random.nextInt(12), 0, random.nextInt(12));
			else
				blockpos = blockpos.add(random.nextInt(12) * -1, 0, random.nextInt(12) * -1);
			new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(3), false).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < greenTreesPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			if (random.nextInt(5) < 5)
				blockpos = blockpos.add(random.nextInt(12), 0, random.nextInt(12));
			else
				blockpos = blockpos.add(random.nextInt(12) * -1, 0, random.nextInt(12) * -1);
			new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG_2.getStateFromMeta(0), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF2.getStateFromMeta(0), false).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < brownTreesPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			if (random.nextInt(5) < 5)
				blockpos = blockpos.add(random.nextInt(12), 0, random.nextInt(12));
			else
				blockpos = blockpos.add(random.nextInt(12) * -1, 0, random.nextInt(12) * -1);
			new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG_2.getStateFromMeta(1), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF2.getStateFromMeta(1), false).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < 1; i++) {
			int x = this.chunkPos.getX() + random.nextInt(16) + 8;
			int y = random.nextInt(256);
			int z = this.chunkPos.getZ() + random.nextInt(16) + 8;
			(new WorldGenKepler22bDungeons()).generate(worldIn, random, new BlockPos(x, y, z));
		}
		for (int i = 0; i < 1; i++) {
			if (generateHuts) {
				if (random.nextInt(200) == 1) {
					BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + (random.nextInt(16) + 8), 0, this.chunkPos.getZ() + (random.nextInt(16) + 8)));
					int randomNum = random.nextInt(7) + 0;
					switch (randomNum) {
					case 1:
						(new WorldGenBlueHut()).generate(worldIn, random, blockpos);
						break;
					case 2:
						(new WorldGenRedHut()).generate(worldIn, random, blockpos);
						break;
					case 3:
						(new WorldGenPurpleHut()).generate(worldIn, random, blockpos);
						break;
					case 4:
						(new WorldGenYellowHut()).generate(worldIn, random, blockpos);
						break;
					case 5:
						(new WorldGenGreenHut()).generate(worldIn, random, blockpos);
						break;
					case 6:
						(new WorldGenBrownHut()).generate(worldIn, random, blockpos);
						break;
					}
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			if (generateCandyCanes) {
				if (random.nextInt(5) == 1) {
					BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + (random.nextInt(16)), 0, this.chunkPos.getZ() + (random.nextInt(16))));
					blockpos = blockpos.down(2);
					int randomNum = random.nextInt(7) + 0;
					switch (randomNum) {
					default:
					case 1:
						(new WorldGenCandyCaneType1()).generate(worldIn, random, blockpos);
						break;
					case 2:
						(new WorldGenCandyCaneType2()).generate(worldIn, random, blockpos);
						break;
					case 3:
						(new WorldGenCandyCaneType3()).generate(worldIn, random, blockpos);
						break;
					}
				}
				if (random.nextInt(2) == 1) {
					worldIn.setBlockState(worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + (random.nextInt(6)), 0, this.chunkPos.getZ() + (random.nextInt(6)))), Blocks.CAKE.getDefaultState());
				}
				if (random.nextInt(100) == 1) {
					BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + (random.nextInt(6)), 0, this.chunkPos.getZ() + (random.nextInt(6))).down(2));
					(new WorldGenCookieRocksType1()).generate(worldIn, random, blockpos);
				}
				if (random.nextInt(10) == 0) {
					BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + (random.nextInt(6)), 0, this.chunkPos.getZ() + (random.nextInt(6))).down(1));
					new WorldGenCustomLake(ExtraPlanets_Fluids.LIQUID_CHOCOLATE).generate(worldIn, random, blockpos, ExtraPlanets_Blocks.CAKE_BLOCKS);
				}
				if (random.nextInt(10) == 0) {
					BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + (random.nextInt(16) + 6), 0, this.chunkPos.getZ() + (random.nextInt(16) + 6)).down(1));
					new WorldGenCustomLake(ExtraPlanets_Fluids.LIQUID_CARAMEL).generate(worldIn, random, blockpos, ExtraPlanets_Blocks.CAKE_BLOCKS);
				}
				for (int k4 = 0; k4 < this.reedsPerChunk; ++k4)
		        {
		            int x = random.nextInt(16) + 8;
		            int z = random.nextInt(16) + 8;
		            int y = worldIn.getHeight(this.chunkPos.add(x, 0, z)).getY() * 2;

		            if (y > 0)
		            {
		                y = random.nextInt(y);
		                new WorldGenWhiteSugerCane().generate(worldIn, random, this.chunkPos.add(x, y, z));
		            }
		        }
			}
		}
		for (int i = 0; i < this.blueShortGrassPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 0).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < this.blueMedGrassPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 1).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < this.blueTallGrassPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 2).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < this.redShortGrassPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 3).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < this.redMedGrassPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 4).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < this.redTallGrassPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 5).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < this.purpleShortGrassPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 6).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < this.purpleMedGrassPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 7).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < this.purpleTallGrassPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 8).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < this.yellowShortGrassPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 9).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < this.yellowMedGrassPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 10).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < this.yellowTallGrassPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 11).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < this.greenShortGrassPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 12).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < this.greenMedGrassPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 13).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < this.greenTallGrassPerChunk; i++) {
			BlockPos blockpos = worldIn.getTopSolidOrLiquidBlock(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 14).generate(worldIn, random, blockpos);
		}
		isDecorating = false;
	}
}