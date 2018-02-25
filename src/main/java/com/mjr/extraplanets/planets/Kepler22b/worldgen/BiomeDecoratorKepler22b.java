package com.mjr.extraplanets.planets.Kepler22b.worldgen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockBasicKepler22bTallGrass;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeLog2;
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
import com.mjr.extraplanets.world.features.WorldGenGreenHut;
import com.mjr.extraplanets.world.features.WorldGenLogTree;
import com.mjr.extraplanets.world.features.WorldGenPurpleHut;
import com.mjr.extraplanets.world.features.WorldGenRedHut;
import com.mjr.extraplanets.world.features.WorldGenWhiteSugerCane;
import com.mjr.extraplanets.world.features.WorldGenYellowHut;
import com.mjr.mjrlegendslib.util.WorldGenUtilities;
import com.mjr.mjrlegendslib.world.features.WorldGenSphere;

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

	public int diamondTreesPerChunk;
	public int diamondSpheresPerChunk;
	public int coalTreesPerChunk;
	public int coalSpheresPerChunk;
	public int ironTreesPerChunk;
	public int ironSpheresPerChunk;
	public int goldTreesPerChunk;
	public int goldSpheresPerChunk;
	public int emeraldTreesPerChunk;
	public int emeraldSpheresPerChunk;

	public boolean generateHuts;

	public boolean generateCandyCanes = false;

	private boolean isDecorating = false;

	@Override
	public void decorate(World world, Random rand, BiomeGenBase p_180292_3_, BlockPos pos) {
		if (isDecorating)
			return;
		isDecorating = true;

		for (int i = 0; i < this.LakesPerChunk; i++) {
			if (rand.nextInt(10) == 0) {
				WorldGenUtilities.generateLake(world, rand, new BlockPos(pos.getX(), 0, pos.getZ()), Blocks.water, Blocks.grass);
			}
		}
		for (int i = 0; i < this.InfectedLakesPerChunk; i++) {
			if (rand.nextInt(15) == 0) {
				WorldGenUtilities.generateLake(world, rand, new BlockPos(pos.getX(), 0, pos.getZ()), ExtraPlanets_Fluids.INFECTED_WATER, Blocks.grass);
			}
		}
		if (Config.GENERATE_KEPLER22B_DUNGEONS) {
			for (int i = 0; i < 1; i++) {
				WorldGenUtilities.generateStructureWithRandom(new WorldGenKepler22bDungeons(), world, rand, pos, 16, 256);
			}
		}
		if (Config.GENERATE_KEPLER22B_HUTS) {
			for (int i = 0; i < 1; i++) {
				if (generateHuts) {
					if (rand.nextInt(200) == 1) {
						switch (rand.nextInt(7)) {
						case 1:
							WorldGenUtilities.generateStructureWithRandom(new WorldGenBlueHut(), world, rand, pos, 16);
							break;
						case 2:
							WorldGenUtilities.generateStructureWithRandom(new WorldGenRedHut(), world, rand, pos, 16);
							break;
						case 3:
							WorldGenUtilities.generateStructureWithRandom(new WorldGenPurpleHut(), world, rand, pos, 16);
							break;
						case 4:
							WorldGenUtilities.generateStructureWithRandom(new WorldGenYellowHut(), world, rand, pos, 16);
							break;
						case 5:
							WorldGenUtilities.generateStructureWithRandom(new WorldGenGreenHut(), world, rand, pos, 16);
							break;
						case 6:
							WorldGenUtilities.generateStructureWithRandom(new WorldGenBrownHut(), world, rand, pos, 16);
							break;
						}
					}
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			if (generateCandyCanes) {
				if (Config.GENERATE_KEPLER22B_CANDY_CANES && rand.nextInt(5) == 1) {
					switch (rand.nextInt(7)) {
					default:
					case 1:
						WorldGenUtilities.generateStructureWithRandom(new WorldGenCandyCaneType1(), world, rand, pos, 16);
						break;
					case 2:
						WorldGenUtilities.generateStructureWithRandom(new WorldGenCandyCaneType2(), world, rand, pos, 16);
						break;
					case 3:
						WorldGenUtilities.generateStructureWithRandom(new WorldGenCandyCaneType3(), world, rand, pos, 16);
						break;
					}
				}
				if (rand.nextInt(2) == 1) {
					world.setBlockState(world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + (rand.nextInt(6)), 0, pos.getZ() + (rand.nextInt(6)))), Blocks.cake.getDefaultState());
				}
				if (Config.GENERATE_KEPLER22B_COOKIE_ROCKS && rand.nextInt(100) == 1) {
					BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + (rand.nextInt(6)), 0, pos.getZ() + (rand.nextInt(6))).down(2));
					(new WorldGenCookieRocksType1()).generate(world, rand, blockpos);
				}
				if (rand.nextInt(10) == 0) {
					WorldGenUtilities.generateLake(world, rand, pos, ExtraPlanets_Fluids.LIQUID_CHOCOLATE, ExtraPlanets_Blocks.CAKE_BLOCKS);
				}
				if (rand.nextInt(10) == 0) {
					WorldGenUtilities.generateLake(world, rand, pos, ExtraPlanets_Fluids.LIQUID_CARAMEL, ExtraPlanets_Blocks.CAKE_BLOCKS);
				}
				for (int k4 = 0; k4 < this.reedsPerChunk; ++k4) {
					int x = rand.nextInt(16) + 8;
					int z = rand.nextInt(16) + 8;
					int y = world.getHeight(pos.add(x, 0, z)).getY() * 2;

					if (y > 0) {
						y = rand.nextInt(y);
						new WorldGenWhiteSugerCane().generate(world, rand, pos.add(x, y, z));
					}
				}
			}
		}
		if (Config.GENERATE_KEPLER22B_TOWERS) {
			for (int i = 0; i < this.blueTowerPerChunk; i++) {
				if (rand.nextInt(100) == 1) {
					WorldGenUtilities.generateStructureWithRandom(new WorldGenBlueTower(), world, rand, pos, 8);
				}
			}
		}
		if (Config.GENERATE_KEPLER22B_NO_LEAF_SMALL_TREES) {
			for (int i = 0; i < this.treeWithNoLeafsPerChunk; i++) {
				BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
				if (rand.nextInt(5) < 5)
					blockpos = blockpos.add(rand.nextInt(12), 0, rand.nextInt(12));
				else
					blockpos = blockpos.add(rand.nextInt(12) * -1, 0, rand.nextInt(12) * -1);
				new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG_2.getDefaultState().withProperty(BlockKepler22bMapleTreeLog2.VARIANT, BlockKepler22bMapleTreeLog2.EnumType.MAPLE_GREEN), Blocks.air.getDefaultState(), false)
						.generate(world, rand, blockpos);
			}
		}
		if (Config.GENERATE_KEPLER22B_NO_LEAF_BIG_TREES) {
			for (int i = 0; i < this.bigTreeWithNoLeafsPerChunk; i++) {
				if (rand.nextInt(5) == 1) {
					BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
					blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
					new WorldGenLogTree().generate(world, rand, blockpos);
				}
			}
		}
		if (Config.GENERATE_KEPLER22B_SPHERES) {
			for (int i = 0; i < this.diamondSpheresPerChunk; i++) {
				if (rand.nextInt(5) == 1) {
					WorldGenUtilities.generateStructureWithRandom(new WorldGenSphere(Config.DEBUG_MODE, Constants.modID, Blocks.diamond_ore.getDefaultState(), 9, 0), world, rand, pos, 6);
				}
			}
			for (int i = 0; i < this.coalSpheresPerChunk; i++) {
				if (rand.nextInt(5) == 1) {
					WorldGenUtilities.generateStructureWithRandom(new WorldGenSphere(Config.DEBUG_MODE, Constants.modID, Blocks.coal_ore.getDefaultState(), 9, 0), world, rand, pos, 6);
				}
			}

			for (int i = 0; i < this.ironSpheresPerChunk; i++) {
				if (rand.nextInt(5) == 1) {
					WorldGenUtilities.generateStructureWithRandom(new WorldGenSphere(Config.DEBUG_MODE, Constants.modID, Blocks.iron_ore.getDefaultState(), 9, 0), world, rand, pos, 6);
				}
			}

			for (int i = 0; i < this.goldSpheresPerChunk; i++) {
				if (rand.nextInt(5) == 1) {
					WorldGenUtilities.generateStructureWithRandom(new WorldGenSphere(Config.DEBUG_MODE, Constants.modID, Blocks.gold_ore.getDefaultState(), 9, 0), world, rand, pos, 6);
				}
			}
			for (int i = 0; i < this.emeraldSpheresPerChunk; i++) {
				if (rand.nextInt(5) == 1) {
					WorldGenUtilities.generateStructureWithRandom(new WorldGenSphere(Config.DEBUG_MODE, Constants.modID, Blocks.emerald_ore.getDefaultState(), 9, 0), world, rand, pos, 6);
				}
			}
		}
		if (Config.GENERATE_KEPLER22B_MATERIAL_TREES) {
			for (int i = 0; i < this.diamondTreesPerChunk; i++) {
				if (rand.nextInt(5) == 1) {
					BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
					blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
					new WorldGenKepler22bTree(true, 12, Blocks.diamond_ore.getDefaultState(), Blocks.diamond_block.getDefaultState(), false).generate(world, rand, blockpos);
				}
			}
			for (int i = 0; i < this.coalTreesPerChunk; i++) {
				if (rand.nextInt(5) == 1) {
					BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
					blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
					new WorldGenKepler22bTree(true, 12, Blocks.coal_ore.getDefaultState(), Blocks.coal_block.getDefaultState(), false).generate(world, rand, blockpos);
				}
			}
			for (int i = 0; i < this.ironTreesPerChunk; i++) {
				if (rand.nextInt(5) == 1) {
					BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
					blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
					new WorldGenKepler22bTree(true, 12, Blocks.iron_ore.getDefaultState(), Blocks.iron_block.getDefaultState(), false).generate(world, rand, blockpos);
				}
			}
			for (int i = 0; i < this.goldTreesPerChunk; i++) {
				if (rand.nextInt(5) == 1) {
					BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
					blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
					new WorldGenKepler22bTree(true, 12, Blocks.gold_ore.getDefaultState(), Blocks.gold_block.getDefaultState(), false).generate(world, rand, blockpos);
				}
			}
			for (int i = 0; i < this.emeraldTreesPerChunk; i++) {
				if (rand.nextInt(5) == 1) {
					BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
					blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
					new WorldGenKepler22bTree(true, 12, Blocks.emerald_ore.getDefaultState(), Blocks.emerald_block.getDefaultState(), false).generate(world, rand, blockpos);
				}
			}
		}
		if (Config.GENERATE_KEPLER22B_BIG_TREES) {
			for (int i = 0; i < this.purpleBigTreesPerChunk; i++) {
				if (rand.nextInt(100) == 1) {
					BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
					blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
					new WorldGenBigPurpleTree().generate(world, rand, blockpos);
				}
			}
			for (int i = 0; i < this.blueBigTreesPerChunk; i++) {
				if (rand.nextInt(100) == 1) {
					BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
					blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
					new WorldGenBigBlueTree().generate(world, rand, blockpos);
				}
			}
			for (int i = 0; i < this.redBigTreesPerChunk; i++) {
				if (rand.nextInt(100) == 1) {
					BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
					blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
					new WorldGenBigRedTree().generate(world, rand, blockpos);
				}
			}
		}
		if (Config.GENERATE_KEPLER22B_SMALL_TREES) {
			for (int i = 0; i < blueTreesPerChunk; i++) {
				BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
				if (rand.nextInt(5) < 5)
					blockpos = blockpos.add(rand.nextInt(12), 0, rand.nextInt(12));
				else
					blockpos = blockpos.add(rand.nextInt(12) * -1, 0, rand.nextInt(12) * -1);
				new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(0), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(0), false).generate(world, rand, blockpos);
			}
			for (int i = 0; i < redTreesPerChunk; i++) {
				BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
				if (rand.nextInt(5) < 5)
					blockpos = blockpos.add(rand.nextInt(12), 0, rand.nextInt(12));
				else
					blockpos = blockpos.add(rand.nextInt(12) * -1, 0, rand.nextInt(12) * -1);
				new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(1), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(1), false).generate(world, rand, blockpos);
			}
			for (int i = 0; i < purpleTreesPerChunk; i++) {
				BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
				if (rand.nextInt(5) < 5)
					blockpos = blockpos.add(rand.nextInt(12), 0, rand.nextInt(12));
				else
					blockpos = blockpos.add(rand.nextInt(12) * -1, 0, rand.nextInt(12) * -1);
				new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), false).generate(world, rand, blockpos);
			}
			for (int i = 0; i < yellowTreesPerChunk; i++) {
				BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
				if (rand.nextInt(5) < 5)
					blockpos = blockpos.add(rand.nextInt(12), 0, rand.nextInt(12));
				else
					blockpos = blockpos.add(rand.nextInt(12) * -1, 0, rand.nextInt(12) * -1);
				new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(3), false).generate(world, rand, blockpos);
			}
			for (int i = 0; i < greenTreesPerChunk; i++) {
				BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
				if (rand.nextInt(5) < 5)
					blockpos = blockpos.add(rand.nextInt(12), 0, rand.nextInt(12));
				else
					blockpos = blockpos.add(rand.nextInt(12) * -1, 0, rand.nextInt(12) * -1);
				new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG_2.getStateFromMeta(0), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF2.getStateFromMeta(0), false).generate(world, rand, blockpos);
			}
			for (int i = 0; i < brownTreesPerChunk; i++) {
				BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
				if (rand.nextInt(5) < 5)
					blockpos = blockpos.add(rand.nextInt(12), 0, rand.nextInt(12));
				else
					blockpos = blockpos.add(rand.nextInt(12) * -1, 0, rand.nextInt(12) * -1);
				new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG_2.getStateFromMeta(1), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF2.getStateFromMeta(1), false).generate(world, rand, blockpos);
			}
		}
		for (int i = 0; i < this.blueShortGrassPerChunk; i++) {
			BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
			blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 0).generate(world, rand, blockpos);
		}
		for (int i = 0; i < this.blueMedGrassPerChunk; i++) {
			BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
			blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 1).generate(world, rand, blockpos);
		}
		for (int i = 0; i < this.blueTallGrassPerChunk; i++) {
			BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
			blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 2).generate(world, rand, blockpos);
		}
		for (int i = 0; i < this.redShortGrassPerChunk; i++) {
			BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
			blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 3).generate(world, rand, blockpos);
		}
		for (int i = 0; i < this.redMedGrassPerChunk; i++) {
			BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
			blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 4).generate(world, rand, blockpos);
		}
		for (int i = 0; i < this.redTallGrassPerChunk; i++) {
			BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
			blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 5).generate(world, rand, blockpos);
		}
		for (int i = 0; i < this.purpleShortGrassPerChunk; i++) {
			BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
			blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 6).generate(world, rand, blockpos);
		}
		for (int i = 0; i < this.purpleMedGrassPerChunk; i++) {
			BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
			blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 7).generate(world, rand, blockpos);
		}
		for (int i = 0; i < this.purpleTallGrassPerChunk; i++) {
			BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
			blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 8).generate(world, rand, blockpos);
		}
		for (int i = 0; i < this.yellowShortGrassPerChunk; i++) {
			BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
			blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 9).generate(world, rand, blockpos);
		}
		for (int i = 0; i < this.yellowMedGrassPerChunk; i++) {
			BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
			blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 10).generate(world, rand, blockpos);
		}
		for (int i = 0; i < this.yellowTallGrassPerChunk; i++) {
			BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
			blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 11).generate(world, rand, blockpos);
		}
		for (int i = 0; i < this.greenShortGrassPerChunk; i++) {
			BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
			blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 12).generate(world, rand, blockpos);
		}
		for (int i = 0; i < this.greenMedGrassPerChunk; i++) {
			BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
			blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 13).generate(world, rand, blockpos);
		}
		for (int i = 0; i < this.greenTallGrassPerChunk; i++) {
			BlockPos blockpos = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + 8, 0, pos.getZ() + 8));
			blockpos = blockpos.add(rand.nextInt(8), 0, rand.nextInt(8));
			new WorldGenKepler22bFlowers((BlockBasicKepler22bTallGrass) ExtraPlanets_Blocks.KEPLER22B_MAPLE_FLOWERS, 14).generate(world, rand, blockpos);
		}
		isDecorating = false;
	}
}