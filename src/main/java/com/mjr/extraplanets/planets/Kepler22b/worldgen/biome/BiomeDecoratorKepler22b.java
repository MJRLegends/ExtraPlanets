package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.WorldGenKepler22bDungeons;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.WorldGenKepler22bFlowers;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.WorldGenKepler22bTree;
import com.mjr.extraplanets.util.WorldGenHelper;
import com.mjr.extraplanets.world.features.WorldGenBigBlueTree;
import com.mjr.extraplanets.world.features.WorldGenBigPurpleTree;
import com.mjr.extraplanets.world.features.WorldGenBigRedTree;
import com.mjr.extraplanets.world.features.WorldGenBlueHut;
import com.mjr.extraplanets.world.features.WorldGenBlueTower;
import com.mjr.extraplanets.world.features.WorldGenBrownHut;
import com.mjr.extraplanets.world.features.WorldGenCustomLake;
import com.mjr.extraplanets.world.features.WorldGenGreenHut;
import com.mjr.extraplanets.world.features.WorldGenLogTree;
import com.mjr.extraplanets.world.features.WorldGenPurpleHut;
import com.mjr.extraplanets.world.features.WorldGenRedHut;
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
	public boolean generateHuts = true;

	private World currentWorld;
	protected Random rand;

	protected int chunkX;
	protected int chunkZ;
	private boolean isDecorating = false;

	public BiomeDecoratorKepler22b() {

	}

	@Override
	public void decorateChunk(World world, Random rand, BiomeGenBase biome, int xChunk, int zChunk) {
		if (isDecorating)
			return;
		isDecorating = true;
		this.currentWorld = world;
		this.rand = rand;
		this.chunk_X = xChunk;
		this.chunk_Z = zChunk;

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.TREE) && (i < this.blueTreesPerChunk); i++) {
			if (this.rand.nextInt(10) == 0) {
				int x = this.chunkX + this.rand.nextInt(80) + 8;
				// int y = this.rand.nextInt(16) + 16;
				int z = this.chunkZ + this.rand.nextInt(80) + 8;
				int y = this.rand.nextInt(256);
				new WorldGenCustomLake(Blocks.water).generate(this.currentWorld, this.rand, x, y, z, Blocks.grass);
			}
		}
		for (int i = 0; i < this.InfectedLakesPerChunk; i++) {
			if (this.rand.nextInt(15) == 0) {
				WorldGenHelper.generateLake(this.currentWorld, this.rand, this.chunk_X, 0, this.chunk_Z, ExtraPlanets_Fluids.infected_water, Blocks.grass);
			}
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.TREE) && (i < this.blueTreesPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;

			WorldGenKepler22bTree tree = new WorldGenKepler22bTree(false, 8, 0, 0, false, ExtraPlanets_Blocks.kepler22bMapleSapling, ExtraPlanets_Blocks.kepler22bMapleLog, ExtraPlanets_Blocks.kepler22bMapleLeaf);
			tree.setScale(1.0D, 1.0D, 1.0D);
			tree.generate(currentWorld, rand, x, this.currentWorld.getHeightValue(x, z), z);
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.TREE) && (i < this.redTreesPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;

			WorldGenKepler22bTree tree1 = new WorldGenKepler22bTree(false, 8, 1, 1, false, ExtraPlanets_Blocks.kepler22bMapleSapling, ExtraPlanets_Blocks.kepler22bMapleLog, ExtraPlanets_Blocks.kepler22bMapleLeaf);
			tree1.setScale(1.0D, 1.0D, 1.0D);
			tree1.generate(currentWorld, rand, x, this.currentWorld.getHeightValue(x, z), z);
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.TREE) && (i < this.purpleTreesPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;

			WorldGenKepler22bTree tree2 = new WorldGenKepler22bTree(false, 8, 2, 2, false, ExtraPlanets_Blocks.kepler22bMapleSapling, ExtraPlanets_Blocks.kepler22bMapleLog, ExtraPlanets_Blocks.kepler22bMapleLeaf);
			tree2.setScale(1.0D, 1.0D, 1.0D);
			tree2.generate(currentWorld, rand, x, this.currentWorld.getHeightValue(x, z), z);
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.TREE) && (i < this.yellowTreesPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;

			WorldGenKepler22bTree tree3 = new WorldGenKepler22bTree(false, 8, 3, 3, false, ExtraPlanets_Blocks.kepler22bMapleSapling, ExtraPlanets_Blocks.kepler22bMapleLog, ExtraPlanets_Blocks.kepler22bMapleLeaf);
			tree3.setScale(1.0D, 1.0D, 1.0D);
			tree3.generate(currentWorld, rand, x, this.currentWorld.getHeightValue(x, z), z);
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.TREE) && (i < this.greenTreesPerChunk); i++) {
			if (rand.nextInt(5) + 1 == 1) {
				int x = this.chunk_X + this.rand.nextInt(16) + 8;
				int z = this.chunk_Z + this.rand.nextInt(16) + 8;

				WorldGenKepler22bTree tree3 = new WorldGenKepler22bTree(false, 8, 0, 0, false, ExtraPlanets_Blocks.kepler22bMapleSapling, ExtraPlanets_Blocks.kepler22bMapleLog2, ExtraPlanets_Blocks.kepler22bMapleLeaf2);
				tree3.setScale(1.0D, 1.0D, 1.0D);
				tree3.generate(currentWorld, rand, x, this.currentWorld.getHeightValue(x, z), z);
			}
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.TREE) && (i < this.brownTreesPerChunk); i++) {
			if (rand.nextInt(5) + 1 == 1) {
				int x = this.chunk_X + this.rand.nextInt(16) + 8;
				int z = this.chunk_Z + this.rand.nextInt(16) + 8;

				WorldGenKepler22bTree tree3 = new WorldGenKepler22bTree(false, 8, 1, 1, false, ExtraPlanets_Blocks.kepler22bMapleSapling, ExtraPlanets_Blocks.kepler22bMapleLog2, ExtraPlanets_Blocks.kepler22bMapleLeaf2);
				tree3.setScale(1.0D, 1.0D, 1.0D);
				tree3.generate(currentWorld, rand, x, this.currentWorld.getHeightValue(x, z), z);
			}
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.GRASS) && (i < this.blueShortGrassPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;
			int y = this.rand.nextInt(256);

			new WorldGenKepler22bFlowers(ExtraPlanets_Blocks.kepler22bGrassFlowers, 0).generate(world, rand, x, y, z);
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.GRASS) && (i < this.blueMedGrassPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;
			int y = this.rand.nextInt(256);

			new WorldGenKepler22bFlowers(ExtraPlanets_Blocks.kepler22bGrassFlowers, 1).generate(world, rand, x, y, z);
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.GRASS) && (i < this.blueTallGrassPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;
			int y = this.rand.nextInt(256);

			new WorldGenKepler22bFlowers(ExtraPlanets_Blocks.kepler22bGrassFlowers, 2).generate(world, rand, x, y, z);
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.GRASS) && (i < this.redShortGrassPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;
			int y = this.rand.nextInt(256);

			new WorldGenKepler22bFlowers(ExtraPlanets_Blocks.kepler22bGrassFlowers, 3).generate(world, rand, x, y, z);
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.GRASS) && (i < this.redMedGrassPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;
			int y = this.rand.nextInt(256);

			new WorldGenKepler22bFlowers(ExtraPlanets_Blocks.kepler22bGrassFlowers, 4).generate(world, rand, x, y, z);
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.GRASS) && (i < this.redTallGrassPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;
			int y = this.rand.nextInt(256);

			new WorldGenKepler22bFlowers(ExtraPlanets_Blocks.kepler22bGrassFlowers, 5).generate(world, rand, x, y, z);
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.GRASS) && (i < this.purpleShortGrassPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;
			int y = this.rand.nextInt(256);

			new WorldGenKepler22bFlowers(ExtraPlanets_Blocks.kepler22bGrassFlowers, 6).generate(world, rand, x, y, z);
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.GRASS) && (i < this.purpleMedGrassPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;
			int y = this.rand.nextInt(256);

			new WorldGenKepler22bFlowers(ExtraPlanets_Blocks.kepler22bGrassFlowers, 7).generate(world, rand, x, y, z);
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.GRASS) && (i < this.purpleTallGrassPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;
			int y = this.rand.nextInt(256);

			new WorldGenKepler22bFlowers(ExtraPlanets_Blocks.kepler22bGrassFlowers, 8).generate(world, rand, x, y, z);

		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.GRASS) && (i < this.yellowShortGrassPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;
			int y = this.rand.nextInt(256);

			new WorldGenKepler22bFlowers(ExtraPlanets_Blocks.kepler22bGrassFlowers, 9).generate(world, rand, x, y, z);
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.GRASS) && (i < this.yellowMedGrassPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;
			int y = this.rand.nextInt(256);

			new WorldGenKepler22bFlowers(ExtraPlanets_Blocks.kepler22bGrassFlowers, 10).generate(world, rand, x, y, z);
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.GRASS) && (i < this.yellowTallGrassPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;
			int y = this.rand.nextInt(256);

			new WorldGenKepler22bFlowers(ExtraPlanets_Blocks.kepler22bGrassFlowers, 11).generate(world, rand, x, y, z);

		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.GRASS) && (i < this.greenShortGrassPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;
			int y = this.rand.nextInt(256);

			new WorldGenKepler22bFlowers(ExtraPlanets_Blocks.kepler22bGrassFlowers, 12).generate(world, rand, x, y, z);
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.GRASS) && (i < this.greenMedGrassPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;
			int y = this.rand.nextInt(256);

			new WorldGenKepler22bFlowers(ExtraPlanets_Blocks.kepler22bGrassFlowers, 13).generate(world, rand, x, y, z);
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.GRASS) && (i < this.greenTallGrassPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;
			int y = this.rand.nextInt(256);

			new WorldGenKepler22bFlowers(ExtraPlanets_Blocks.kepler22bGrassFlowers, 14).generate(world, rand, x, y, z);

		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.CUSTOM) && (i < 1); i++) {
			int x = chunk_X + this.rand.nextInt(16) + 8;
			int y = this.rand.nextInt(256);
			int z = chunk_Z + this.rand.nextInt(16) + 8;
			(new WorldGenKepler22bDungeons()).generate(this.currentWorld, rand, x, y, z);
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.CUSTOM) && (i < 1); i++) {
			if (this.generateHuts) {
				if (this.rand.nextInt(200) == 1) {
					int x = chunk_X + this.rand.nextInt(16) + 8;
					int z = chunk_Z + this.rand.nextInt(16) + 8;
					int y = this.currentWorld.getHeightValue(x, z);
					int randomNum = this.rand.nextInt(7) + 0;
					switch (randomNum) {
					case 1:
						(new WorldGenBlueHut()).generate(this.currentWorld, rand, x, y, z);
						break;
					case 2:
						(new WorldGenRedHut()).generate(this.currentWorld, rand, x, y, z);
						break;
					case 3:
						(new WorldGenPurpleHut()).generate(this.currentWorld, rand, x, y, z);
						break;
					case 4:
						(new WorldGenYellowHut()).generate(this.currentWorld, rand, x, y, z);
						break;
					case 5:
						(new WorldGenGreenHut()).generate(this.currentWorld, rand, x, y, z);
						break;
					case 6:
						(new WorldGenBrownHut()).generate(this.currentWorld, rand, x, y, z);
						break;
					}
				}
			}
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.CUSTOM) && (i < this.purpleBigTreesPerChunk); i++) {
			if (this.rand.nextInt(100) == 1) {
				int x = chunk_X + this.rand.nextInt(16) + 8;
				int z = chunk_Z + this.rand.nextInt(16) + 8;
				int y = this.currentWorld.getHeightValue(x, z);
				new WorldGenBigPurpleTree().generate(this.currentWorld, this.rand, x, y, z);
			}
		}
		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.CUSTOM) && (i < this.blueBigTreesPerChunk); i++) {
			if (this.rand.nextInt(100) == 1) {
				int x = chunk_X + this.rand.nextInt(16) + 8;
				int z = chunk_Z + this.rand.nextInt(16) + 8;
				int y = this.currentWorld.getHeightValue(x, z);
				new WorldGenBigBlueTree().generate(this.currentWorld, this.rand, x, y, z);
			}
		}
		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.CUSTOM) && (i < this.redBigTreesPerChunk); i++) {
			if (this.rand.nextInt(100) == 1) {
				int x = chunk_X + this.rand.nextInt(16) + 8;
				int z = chunk_Z + this.rand.nextInt(16) + 8;
				int y = this.currentWorld.getHeightValue(x, z);
				new WorldGenBigRedTree().generate(this.currentWorld, this.rand, x, y, z);
			}
		}
		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.CUSTOM) && (i < this.blueTowerPerChunk); i++) {
			if (this.rand.nextInt(100) == 1) {
				int x = chunk_X + this.rand.nextInt(16) + 8;
				int z = chunk_Z + this.rand.nextInt(16) + 8;
				int y = this.currentWorld.getHeightValue(x, z) - 1;
				(new WorldGenBlueTower()).generate(this.currentWorld, rand, x, y, z);
				break;
			}
		}
		for (int i = 0; i < this.treeWithNoLeafsPerChunk; i++) {
			int x = this.chunk_X + this.rand.nextInt(8);
			int z = this.chunk_Z + this.rand.nextInt(8);
			int y = this.currentWorld.getTopSolidOrLiquidBlock(x, z);
			new WorldGenKepler22bTree(true, 8, 0, 0, false, ExtraPlanets_Blocks.kepler22bMapleSapling, ExtraPlanets_Blocks.kepler22bMapleLog2, Blocks.air).generate(this.currentWorld, this.rand, x, y, z);
		}
		for (int i = 0; i < this.bigTreeWithNoLeafsPerChunk; i++) {
			if (this.rand.nextInt(5) == 1) {
				int x = chunk_X + this.rand.nextInt(16) + 8;
				int z = chunk_Z + this.rand.nextInt(16) + 8;
				int y = this.currentWorld.getHeightValue(x, z) - 1;
				new WorldGenLogTree().generate(this.currentWorld, this.rand, x, y, z);
			}
		}
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
		isDecorating = false;
	}
}