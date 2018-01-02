package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class BiomeDecoratorKepler22bOres extends BiomeDecoratorSpace {

	private WorldGenerator copperGen;
	private WorldGenerator tinGen;
	private WorldGenerator ironGen;
	private WorldGenerator denseCoal;
	private WorldGenerator blueDiamondOre;
	private WorldGenerator redDiamondOre;
	private WorldGenerator yellowDiamondOre;
	private WorldGenerator purpleDiamondOre;
	private WorldGenerator greenDiamondOre;
	private WorldGenerator marbleGen;
	private WorldGenerator platinumOre;

	private World currentWorld;

	private boolean isDecorating = false;

	public BiomeDecoratorKepler22bOres() {
		this.copperGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.kepler22bBlocks, 4, 3, true, ExtraPlanets_Blocks.kepler22bBlocks, 1);
		this.tinGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.kepler22bBlocks, 4, 4, true, ExtraPlanets_Blocks.kepler22bBlocks, 1);
		this.ironGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.kepler22bBlocks, 8, 2, true, ExtraPlanets_Blocks.kepler22bBlocks, 1);
		this.denseCoal = new WorldGenMinableMeta(ExtraPlanets_Blocks.kepler22bBlocks, 8, 5, true, ExtraPlanets_Blocks.kepler22bBlocks, 1);
		this.blueDiamondOre = new WorldGenMinableMeta(ExtraPlanets_Blocks.kepler22bBlocks, 8, 6, true, ExtraPlanets_Blocks.kepler22bBlocks, 1);
		this.redDiamondOre = new WorldGenMinableMeta(ExtraPlanets_Blocks.kepler22bBlocks, 8, 7, true, ExtraPlanets_Blocks.kepler22bBlocks, 1);
		this.yellowDiamondOre = new WorldGenMinableMeta(ExtraPlanets_Blocks.kepler22bBlocks, 8, 8, true, ExtraPlanets_Blocks.kepler22bBlocks, 1);
		this.purpleDiamondOre = new WorldGenMinableMeta(ExtraPlanets_Blocks.kepler22bBlocks, 8, 9, true, ExtraPlanets_Blocks.kepler22bBlocks, 1);
		this.greenDiamondOre = new WorldGenMinableMeta(ExtraPlanets_Blocks.kepler22bBlocks, 8, 10, true, ExtraPlanets_Blocks.kepler22bBlocks, 1);
		this.marbleGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.decorativeBlocks, 10, 0, true, ExtraPlanets_Blocks.kepler22bBlocks, 1);
		this.platinumOre = new WorldGenMinableMeta(ExtraPlanets_Blocks.kepler22bBlocks, 3, 13, true, ExtraPlanets_Blocks.kepler22bBlocks, 1);
		// WorldGenMinableMeta(Block OreBlock, int numberOfBlocks, int OreMeta, boolean usingMetaData, Block StoneBlock, int StoneMeta);
	}

	@Override
	protected void setCurrentWorld(World world) {
		this.currentWorld = world;
	}

	@Override
	protected World getCurrentWorld() {
		return this.currentWorld;
	}

	@Override
	protected void decorate() {
		if (isDecorating)
			return;
		isDecorating = true;
		this.generateOre(26, this.copperGen, 0, 60);
		this.generateOre(23, this.tinGen, 0, 60);
		this.generateOre(20, this.ironGen, 0, 64);
		this.generateOre(4, this.denseCoal, 0, 25);
		this.generateOre(4, this.blueDiamondOre, 0, 10);
		this.generateOre(4, this.redDiamondOre, 0, 10);
		this.generateOre(4, this.yellowDiamondOre, 0, 10);
		this.generateOre(4, this.purpleDiamondOre, 0, 10);
		this.generateOre(4, this.greenDiamondOre, 0, 10);
		this.generateOre(4, this.platinumOre, 0, 10);
		this.generateOre(20, this.marbleGen, 0, 30);

		// generateOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY);

		isDecorating = false;
	}
}