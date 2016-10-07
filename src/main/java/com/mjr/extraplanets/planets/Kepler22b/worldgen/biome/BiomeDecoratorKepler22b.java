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
import com.mjr.extraplanets.worldGen.features.WorldGenBlueTree;
import com.mjr.extraplanets.worldGen.features.WorldGenCustomLake;

public class BiomeDecoratorKepler22b extends BiomeDecorator {

	private WorldGenerator copperGen;
	private WorldGenerator tinGen;
	private WorldGenerator ironGen;
	private WorldGenerator zincGen;
	private WorldGenerator frozenNitrogenGen;
	private int LakesPerChunk = 40;

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
	public void decorateChunk(World world, Random rand, BiomeGenBase biome, int xChunk, int zChunk)
	{
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
				int y = this.currentWorld.getHeightValue(x, z);
				new WorldGenCustomLake(Blocks.water).generate(this.currentWorld, this.rand, x, y, z, Blocks.grass);
			}
		}
		
	    int chance = 4;
	    if (this.rand.nextInt(10) == 0) {
	      chance++;
	    }
	    for (int i = 0; TerrainGen.decorate(this.currentWorld, this.rand, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.TREE) && (i < chance); i++)
	    {
	      int x = this.chunk_X + this.rand.nextInt(16) + 8;
	      int z = this.chunk_Z + this.rand.nextInt(16) + 8;
	      
	      WorldGenBlueTree tree = new WorldGenBlueTree(false, 8, 0, 0, false);
	      tree.setScale(1.0D, 1.0D, 1.0D);
	      tree.generate(currentWorld, rand, x, this.currentWorld.getHeightValue(x, z), z);
	    }

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, this.chunkX, this.chunkZ));

		//generateOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY);
	}
}