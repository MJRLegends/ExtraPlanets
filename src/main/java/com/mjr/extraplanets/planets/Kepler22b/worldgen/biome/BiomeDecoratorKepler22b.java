package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.WorldGenKepler22bDungeons;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.WorldGenKepler22bTree;
import com.mjr.extraplanets.world.features.WorldGenBlueHut;
import com.mjr.extraplanets.world.features.WorldGenBrownHut;
import com.mjr.extraplanets.world.features.WorldGenCustomLake;
import com.mjr.extraplanets.world.features.WorldGenGreenHut;
import com.mjr.extraplanets.world.features.WorldGenPurpleHut;
import com.mjr.extraplanets.world.features.WorldGenRedHut;
import com.mjr.extraplanets.world.features.WorldGenYellowHut;

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
		for (int i = 0; i < blueTreesPerChunk; i++) {
			BlockPos blockpos = worldIn.getHeight(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.kepler22bMapleLog.getStateFromMeta(0), ExtraPlanets_Blocks.kepler22bMapleLeaf.getStateFromMeta(0), false).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < redTreesPerChunk; i++) {
			BlockPos blockpos = worldIn.getHeight(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.kepler22bMapleLog.getStateFromMeta(1), ExtraPlanets_Blocks.kepler22bMapleLeaf.getStateFromMeta(1), false).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < purpleTreesPerChunk; i++) {
			BlockPos blockpos = worldIn.getHeight(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.kepler22bMapleLog.getStateFromMeta(2), ExtraPlanets_Blocks.kepler22bMapleLeaf.getStateFromMeta(2), false).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < yellowTreesPerChunk; i++) {
			BlockPos blockpos = worldIn.getHeight(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.kepler22bMapleLog.getStateFromMeta(3), ExtraPlanets_Blocks.kepler22bMapleLeaf.getStateFromMeta(3), false).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < greenTreesPerChunk; i++) {
			BlockPos blockpos = worldIn.getHeight(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.kepler22bMapleLog2.getStateFromMeta(0), ExtraPlanets_Blocks.kepler22bMapleLeaf.getStateFromMeta(4), false).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < brownTreesPerChunk; i++) {
			BlockPos blockpos = worldIn.getHeight(new BlockPos(this.chunkPos.getX() + 8, 0, this.chunkPos.getZ() + 8));
			blockpos = blockpos.add(random.nextInt(8), 0, random.nextInt(8));
			new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.kepler22bMapleLog2.getStateFromMeta(1), ExtraPlanets_Blocks.kepler22bMapleLeaf.getStateFromMeta(5), false).generate(worldIn, random, blockpos);
		}
		for (int i = 0; i < 1; i++) {
			int x = this.chunkPos.getX() + random.nextInt(16) + 8;
			int y = random.nextInt(256);
			int z = this.chunkPos.getZ() + random.nextInt(16) + 8;
			(new WorldGenKepler22bDungeons()).generate(worldIn, random, new BlockPos(x, y, z));
		}
		for (int i = 0; i < 1; i++) {
			if (random.nextInt(200) == 1) {
				BlockPos blockpos = worldIn.getHeight(new BlockPos(this.chunkPos.getX() + (random.nextInt(16) + 8), 0, this.chunkPos.getZ() + (random.nextInt(16) + 8)));
				blockpos.down(2);
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
		isDecorating = false;
	}
}