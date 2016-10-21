package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import java.util.Random;

import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.WorldGenKepler22bDungeons;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.WorldGenKepler22bFlowers;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.WorldGenKepler22bTree;
import com.mjr.extraplanets.worldGen.features.WorldGenCustomLake;

public class BiomeDecoratorKepler22b extends BiomeDecorator {

	public int LakesPerChunk;

	public int blueTreesPerChunk;
	public int redTreesPerChunk;
	public int purpleTreesPerChunk;
	public int yellowTreesPerChunk;

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

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.CUSTOM) && (i < 1); i++) {
			int x = chunk_X + this.rand.nextInt(16) + 8;
			int y = this.rand.nextInt(256);
			int z = chunk_Z + this.rand.nextInt(16) + 8;
			(new WorldGenKepler22bDungeons()).generate(this.currentWorld, rand, x, y, z);
		}
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
		isDecorating = false;
	}
}