package com.mjr.extraplanets.planets.Mercury.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.world.features.WorldGenCustomLake;

public class BiomeDecoratorMercury extends BiomeDecoratorSpace {

	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator ironGen;
	private WorldGenerator mercuryGen;
	private WorldGenerator carbonGen;
	private WorldGenerator gravelGen;
	private WorldGenerator fossilsGen;
	private WorldGenerator potashGen;

	private World currentWorld;

	private boolean isDecorating = false;

	public BiomeDecoratorMercury() {
		this.copperGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.MERCURY_BLOCKS, 4, 5, true, ExtraPlanets_Blocks.MERCURY_BLOCKS, 2);
		this.tinGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.MERCURY_BLOCKS, 4, 4, true, ExtraPlanets_Blocks.MERCURY_BLOCKS, 2);
		this.ironGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.MERCURY_BLOCKS, 8, 3, true, ExtraPlanets_Blocks.MERCURY_BLOCKS, 2);
		this.mercuryGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.MERCURY_BLOCKS, 4, 6, true, ExtraPlanets_Blocks.MERCURY_BLOCKS, 2);
		this.carbonGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.MERCURY_BLOCKS, 4, 11, true, ExtraPlanets_Blocks.MERCURY_BLOCKS, 2);
		this.gravelGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.MERCURY_GRAVEL, 12, 0, true, ExtraPlanets_Blocks.MERCURY_BLOCKS, 2);
		this.fossilsGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.FOSSIL, 3, 0, true, ExtraPlanets_Blocks.MERCURY_BLOCKS, 1);
		this.potashGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.ORE_POTASH, 5, 0, true, ExtraPlanets_Blocks.MERCURY_BLOCKS, 2);

		// WorldGenMinableMeta(Block OreBlock, int numberOfBlocks, int OreMeta,
		// boolean usingMetaData, Block StoneBlock, int StoneMeta);
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
		this.generateOre(20, this.mercuryGen, 0, 64);
		this.generateOre(20, this.carbonGen, 0, 64);
		this.generateOre(15, this.gravelGen, 0, 80);
		this.generateOre(10, this.fossilsGen, 0, 256);
		this.generateOre(10, this.potashGen, 0, 20);

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, new BlockPos(this.chunkX, 0, this.chunkZ)));
		for (int i = 0; i < 1; i++) {
			if (this.rand.nextInt(100) == 0) {
				int x = this.chunkX + 8;
				int z = this.chunkZ + 8;
				int y = this.currentWorld.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z)).getY() - 2;
				new WorldGenCustomLake(ExtraPlanets_Fluids.INFECTED_WATER).generate(this.currentWorld, this.rand, new BlockPos(x, y, z), ExtraPlanets_Blocks.CERES_BLOCKS);
			}
		}
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, new BlockPos(this.chunkX, 0, this.chunkZ)));

		isDecorating = false;
		// generateOre(int amountPerChunk, WorldGenerator worldGenerator, int
		// minY, int maxY);
	}

}
