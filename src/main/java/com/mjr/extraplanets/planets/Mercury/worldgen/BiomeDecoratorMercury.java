package com.mjr.extraplanets.planets.Mercury.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.mjr.extraplanets.blocks.ExtraPlanetsBlocks;

public class BiomeDecoratorMercury extends BiomeDecoratorSpace {

	private WorldGenerator deshGen;
	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator ironGen;
	private WorldGenerator mercuryGen;
	private WorldGenerator gravelGen;
	private WorldGenerator fossilsGen;

	private World currentWorld;

	public BiomeDecoratorMercury()
	{
		this.copperGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.mercuryBlocks, 4, 5, true, ExtraPlanetsBlocks.mercuryBlocks, 2);
		this.tinGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.mercuryBlocks, 4, 4, true, ExtraPlanetsBlocks.mercuryBlocks, 2);
		this.ironGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.mercuryBlocks, 8, 3, true, ExtraPlanetsBlocks.mercuryBlocks, 2);
		this.mercuryGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.mercuryBlocks, 8, 6, true, ExtraPlanetsBlocks.mercuryBlocks, 2);
		this.gravelGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.mercuryGravel, 12, 0, true, ExtraPlanetsBlocks.mercuryBlocks, 2);
		this.fossilsGen = new WorldGenMinableMeta(ExtraPlanetsBlocks.fossil, 1, 0, true, ExtraPlanetsBlocks.mercuryBlocks, 1);

		//WorldGenMinableMeta(Block OreBlock, int numberOfBlocks, int OreMeta, boolean usingMetaData, Block StoneBlock, int StoneMeta);
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
		this.generateOre(26, this.copperGen, 0, 60);
		this.generateOre(23, this.tinGen, 0, 60);
		this.generateOre(20, this.ironGen, 0, 64);
		this.generateOre(20, this.mercuryGen, 0, 64);
		this.generateOre(15, this.gravelGen, 0, 80);
		this.generateOre(1, this.fossilsGen, 0, 256);

		//generateOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY);
	}

}
