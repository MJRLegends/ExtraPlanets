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
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.WorldGenKepler22bFlowers;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.WorldGenKepler22bTree;
import com.mjr.extraplanets.worldGen.features.WorldGenCustomLake;

public class BiomeDecoratorKepler22b extends BiomeDecorator {

	private WorldGenerator copperGen;
	private WorldGenerator tinGen;
	private WorldGenerator ironGen;
	private WorldGenerator zincGen;
	private WorldGenerator frozenNitrogenGen;
	public int LakesPerChunk = 40;

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

	public BiomeDecoratorKepler22b() {
		this.copperGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.neptuneBlocks, 4, 5, true, ExtraPlanets_Blocks.neptuneBlocks, 2);
		this.tinGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.neptuneBlocks, 4, 4, true, ExtraPlanets_Blocks.neptuneBlocks, 2);
		this.ironGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.neptuneBlocks, 8, 3, true, ExtraPlanets_Blocks.neptuneBlocks, 2);
		this.zincGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.neptuneBlocks, 8, 6, true, ExtraPlanets_Blocks.neptuneBlocks, 2);
		this.frozenNitrogenGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.frozenNitrogen, 8, 0, true, ExtraPlanets_Blocks.neptuneBlocks, 0);

		// WorldGenMinableMeta(Block OreBlock, int numberOfBlocks, int OreMeta,
		// boolean usingMetaData, Block StoneBlock, int StoneMeta);

	}

	@SuppressWarnings("unused")
	protected void generateOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY) {
		World currentWorld;
		for (int var5 = 0; var5 < amountPerChunk; ++var5) {
			final int var6 = this.chunkX + this.rand.nextInt(16);
			final int var7 = this.rand.nextInt(maxY - minY) + minY;
			final int var8 = this.chunkZ + this.rand.nextInt(16);
			worldGenerator.generate(this.currentWorld, this.rand, var6, var7, var8);
		}
	}

	@Override
	public void decorateChunk(World world, Random rand, BiomeGenBase biome, int xChunk, int zChunk) {
		this.currentWorld = world;
		this.rand = rand;
		this.chunk_X = xChunk;
		this.chunk_Z = zChunk;
		this.generateOre(26, this.copperGen, 0, 60);
		this.generateOre(23, this.tinGen, 0, 60);
		this.generateOre(20, this.ironGen, 0, 64);
		this.generateOre(20, this.zincGen, 0, 64);
		this.generateOre(5, this.frozenNitrogenGen, 0, 256);

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
		for (int i = 0; i < this.LakesPerChunk; i++) {
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

			WorldGenKepler22bTree tree = new WorldGenKepler22bTree(false, 8, 0, 0, false, ExtraPlanets_Blocks.blueMapleSapling, ExtraPlanets_Blocks.blueMapleLog, ExtraPlanets_Blocks.blueMapleLeaf);
			tree.setScale(1.0D, 1.0D, 1.0D);
			tree.generate(currentWorld, rand, x, this.currentWorld.getHeightValue(x, z), z);
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.TREE) && (i < this.redTreesPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;

			WorldGenKepler22bTree tree1 = new WorldGenKepler22bTree(false, 8, 0, 0, false, ExtraPlanets_Blocks.redMapleSapling, ExtraPlanets_Blocks.redMapleLog, ExtraPlanets_Blocks.redMapleLeaf);
			tree1.setScale(1.0D, 1.0D, 1.0D);
			tree1.generate(currentWorld, rand, x, this.currentWorld.getHeightValue(x, z), z);
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.TREE) && (i < this.purpleTreesPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;

			WorldGenKepler22bTree tree2 = new WorldGenKepler22bTree(false, 8, 0, 0, false, ExtraPlanets_Blocks.purpleMapleSapling, ExtraPlanets_Blocks.purpleMapleLog, ExtraPlanets_Blocks.purpleMapleLeaf);
			tree2.setScale(1.0D, 1.0D, 1.0D);
			tree2.generate(currentWorld, rand, x, this.currentWorld.getHeightValue(x, z), z);
		}

		for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.TREE) && (i < this.yellowTreesPerChunk); i++) {
			int x = this.chunk_X + this.rand.nextInt(16) + 8;
			int z = this.chunk_Z + this.rand.nextInt(16) + 8;

			WorldGenKepler22bTree tree3 = new WorldGenKepler22bTree(false, 8, 0, 0, false, ExtraPlanets_Blocks.yellowMapleSapling, ExtraPlanets_Blocks.yellowMapleLog, ExtraPlanets_Blocks.yellowMapleLeaf);
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
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, this.chunkX, this.chunkZ));

		// generateOre(int amountPerChunk, WorldGenerator worldGenerator, int
		// minY, int maxY);
	}
}