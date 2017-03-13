package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.WorldGenKepler22bTree;
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

	private boolean isDecorating = false;

	@Override
	protected void genDecorations(BiomeGenBase biomeGenBaseIn) {
		if (isDecorating)
			return;
		isDecorating = true;

		for (int i = 0; i < this.LakesPerChunk; i++) {
			if (this.randomGenerator.nextInt(10) == 0) {
				int x = this.field_180294_c.getX() + this.randomGenerator.nextInt(80) + 8;
				int z = this.field_180294_c.getZ() + this.randomGenerator.nextInt(80) + 8;
				int y = this.randomGenerator.nextInt(256);
				new WorldGenCustomLake(Blocks.water).generate(this.currentWorld, this.randomGenerator, new BlockPos(x, y, z), Blocks.grass);
			}
		}
		for (int i = 0; i < blueTreesPerChunk; i++) {
			BlockPos blockpos = this.currentWorld.getHeight(new BlockPos((this.field_180294_c.getX() * 16)+ 8, 0, (this.field_180294_c.getZ()*16 )+ 8));
			blockpos = blockpos.add(this.randomGenerator.nextInt(8), 0, this.randomGenerator.nextInt(8));
			new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.kepler22bMapleLog.getStateFromMeta(0), ExtraPlanets_Blocks.kepler22bMapleLeaf.getStateFromMeta(0), false).generate(this.currentWorld, this.randomGenerator, blockpos);
		}
		for (int i = 0; i < redTreesPerChunk; i++) {
			BlockPos blockpos = this.currentWorld.getHeight(new BlockPos((this.field_180294_c.getX() * 16)+ 8, 0, (this.field_180294_c.getZ()*16 )+ 8));
			blockpos = blockpos.add(this.randomGenerator.nextInt(8), 0, this.randomGenerator.nextInt(8));
			new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.kepler22bMapleLog.getStateFromMeta(1), ExtraPlanets_Blocks.kepler22bMapleLeaf.getStateFromMeta(1), false).generate(this.currentWorld, this.randomGenerator, blockpos);
		}
		for (int i = 0; i < purpleTreesPerChunk; i++) {
			BlockPos blockpos = this.currentWorld.getHeight(new BlockPos((this.field_180294_c.getX() * 16)+ 8, 0, (this.field_180294_c.getZ()*16 )+ 8));
			blockpos = blockpos.add(this.randomGenerator.nextInt(8), 0, this.randomGenerator.nextInt(8));
			new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.kepler22bMapleLog.getStateFromMeta(2), ExtraPlanets_Blocks.kepler22bMapleLeaf.getStateFromMeta(2), false).generate(this.currentWorld, this.randomGenerator, blockpos);
		}
		for (int i = 0; i < yellowTreesPerChunk; i++) {
			BlockPos blockpos = this.currentWorld.getHeight(new BlockPos((this.field_180294_c.getX() * 16)+ 8, 0, (this.field_180294_c.getZ()*16 )+ 8));
			blockpos = blockpos.add(this.randomGenerator.nextInt(8), 0, this.randomGenerator.nextInt(8));
			new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.kepler22bMapleLog.getStateFromMeta(3), ExtraPlanets_Blocks.kepler22bMapleLeaf.getStateFromMeta(3), false).generate(this.currentWorld, this.randomGenerator, blockpos);
		}
		for (int i = 0; i < greenTreesPerChunk; i++) {
			BlockPos blockpos = this.currentWorld.getHeight(new BlockPos((this.field_180294_c.getX() * 16)+ 8, 0, (this.field_180294_c.getZ()*16 )+ 8));
			blockpos = blockpos.add(this.randomGenerator.nextInt(8), 0, this.randomGenerator.nextInt(8));
			new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.kepler22bMapleLog2.getStateFromMeta(0), ExtraPlanets_Blocks.kepler22bMapleLeaf.getStateFromMeta(4), false).generate(this.currentWorld, this.randomGenerator, blockpos);
		}
		for (int i = 0; i < brownTreesPerChunk; i++) {
			BlockPos blockpos = this.currentWorld.getHeight(new BlockPos((this.field_180294_c.getX() * 16)+ 8, 0, (this.field_180294_c.getZ()*16 )+ 8));
			blockpos = blockpos.add(this.randomGenerator.nextInt(8), 0, this.randomGenerator.nextInt(8));
			new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.kepler22bMapleLog2.getStateFromMeta(1), ExtraPlanets_Blocks.kepler22bMapleLeaf.getStateFromMeta(5), false).generate(this.currentWorld, this.randomGenerator, blockpos);
		}
		isDecorating = false;
	}
}