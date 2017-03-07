package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

import com.mjr.extraplanets.world.features.WorldGenCustomLake;

public class BiomeDecoratorKepler22b extends BiomeDecorator {

	public int LakesPerChunk;

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

	private World currentWorld;
	protected Random rand;

	protected int chunkX;
	protected int chunkZ;
	private boolean isDecorating = false;

	public BiomeDecoratorKepler22b() {

	}

	protected void genDecorations(BiomeGenBase biomeGenBaseIn) {
		if (isDecorating)
			return;
		isDecorating = true;
		net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.terraingen.DecorateBiomeEvent.Pre(currentWorld, randomGenerator, field_180294_c));
		this.generateOres();

		if (net.minecraftforge.event.terraingen.TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.LAKE_WATER)) {
			if (this.rand.nextInt(10) == 0) {
				int x = this.chunkX + this.rand.nextInt(80) + 8;
				// int y = this.rand.nextInt(16) + 16;
				int z = this.chunkZ + this.rand.nextInt(80) + 8;
				int y = this.rand.nextInt(256);
				new WorldGenCustomLake(Blocks.water).generate(this.currentWorld, this.rand, new BlockPos(x, y, z), Blocks.grass);
			}
		}
		if (net.minecraftforge.event.terraingen.TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE)) {
			int x = this.chunkX + this.rand.nextInt(16) + 8;
			int z = this.chunkZ + this.rand.nextInt(16) + 8;

			// WorldGenKepler22bTree tree = new WorldGenKepler22bTree(false, 8, 0, 0, false, ExtraPlanets_Blocks.kepler22bMapleSapling, ExtraPlanets_Blocks.kepler22bMapleLog, ExtraPlanets_Blocks.kepler22bMapleLeaf);
			// tree.setScale(1.0D, 1.0D, 1.0D);
			// tree.generate(currentWorld, rand, x, this.currentWorld.getHeight(new BlockPos(x, 0, z));
		}

		if (net.minecraftforge.event.terraingen.TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE)) {
			int x = this.chunkX + this.rand.nextInt(16) + 8;
			int z = this.chunkZ + this.rand.nextInt(16) + 8;

			// WorldGenKepler22bTree tree1 = new WorldGenKepler22bTree(false, 8, 1, 1, false, ExtraPlanets_Blocks.kepler22bMapleSapling, ExtraPlanets_Blocks.kepler22bMapleLog, ExtraPlanets_Blocks.kepler22bMapleLeaf);
			// tree1.setScale(1.0D, 1.0D, 1.0D);
			// tree.generate(currentWorld, rand, x, this.currentWorld.getHeight(new BlockPos(x, 0, z));
		}

		if (net.minecraftforge.event.terraingen.TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE)) {
			int x = this.chunkX + this.rand.nextInt(16) + 8;
			int z = this.chunkZ + this.rand.nextInt(16) + 8;

			// WorldGenKepler22bTree tree2 = new WorldGenKepler22bTree(false, 8, 2, 2, false, ExtraPlanets_Blocks.kepler22bMapleSapling, ExtraPlanets_Blocks.kepler22bMapleLog, ExtraPlanets_Blocks.kepler22bMapleLeaf);
			// tree2.setScale(1.0D, 1.0D, 1.0D);
			// tree.generate(currentWorld, rand, x, this.currentWorld.getHeight(new BlockPos(x, 0, z));
		}

		if (net.minecraftforge.event.terraingen.TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE)) {
			int x = this.chunkX + this.rand.nextInt(16) + 8;
			int z = this.chunkZ + this.rand.nextInt(16) + 8;

			// WorldGenKepler22bTree tree3 = new WorldGenKepler22bTree(false, 8, 3, 3, false, ExtraPlanets_Blocks.kepler22bMapleSapling, ExtraPlanets_Blocks.kepler22bMapleLog, ExtraPlanets_Blocks.kepler22bMapleLeaf);
			// tree3.setScale(1.0D, 1.0D, 1.0D);
			// tree.generate(currentWorld, rand, x, this.currentWorld.getHeight(new BlockPos(x, 0, z));
		}

		if (net.minecraftforge.event.terraingen.TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE)) {
			if (rand.nextInt(5) + 1 == 1) {
				int x = this.chunkX + this.rand.nextInt(16) + 8;
				int z = this.chunkZ + this.rand.nextInt(16) + 8;

				// WorldGenKepler22bTree tree3 = new WorldGenKepler22bTree(false, 8, 0, 4, false, ExtraPlanets_Blocks.kepler22bMapleSapling, ExtraPlanets_Blocks.kepler22bMapleLog2, ExtraPlanets_Blocks.kepler22bMapleLeaf);
				// tree3.setScale(1.0D, 1.0D, 1.0D);
				// tree.generate(currentWorld, rand, x, this.currentWorld.getHeight(new BlockPos(x, 0, z));
			}
		}

		if (net.minecraftforge.event.terraingen.TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE)) {
			if (rand.nextInt(5) + 1 == 1) {
				int x = this.chunkX + this.rand.nextInt(16) + 8;
				int z = this.chunkZ + this.rand.nextInt(16) + 8;

				// WorldGenKepler22bTree tree3 = new WorldGenKepler22bTree(false, 8, 1, 5, false, ExtraPlanets_Blocks.kepler22bMapleSapling, ExtraPlanets_Blocks.kepler22bMapleLog2, ExtraPlanets_Blocks.kepler22bMapleLeaf);
				// tree3.setScale(1.0D, 1.0D, 1.0D);
				// tree.generate(currentWorld, rand, x, this.currentWorld.getHeight(new BlockPos(x, 0, z));
			}
		}

		net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.terraingen.DecorateBiomeEvent.Post(currentWorld, randomGenerator, field_180294_c));
		isDecorating = false;
	}
}