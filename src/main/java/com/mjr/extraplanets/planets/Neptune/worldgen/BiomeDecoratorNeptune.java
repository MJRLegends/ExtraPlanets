package com.mjr.extraplanets.planets.Neptune.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class BiomeDecoratorNeptune extends BiomeDecoratorSpace {

	private WorldGenerator copperGen;
	private WorldGenerator tinGen;
	private WorldGenerator ironGen;
	private WorldGenerator zincGen;
	private WorldGenerator frozenNitrogenGen;
	private WorldGenerator blueGemGen;

	private int LakesPerChunk = 5;

	private World currentWorld;

	private boolean isDecorating = false;

	public BiomeDecoratorNeptune() {
		this.copperGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 4, 5, true, ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 2);
		this.tinGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 4, 4, true, ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 2);
		this.ironGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 8, 3, true, ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 2);
		this.zincGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 4, 6, true, ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 2);
		this.frozenNitrogenGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.FROZEN_NITROGEN, 8, 0, true, ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 0);
		this.blueGemGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 4, 9, true, ExtraPlanets_Blocks.NEPTUNE_BLOCKS, 2);
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
		this.generateOre(20, this.zincGen, 0, 32);
		this.generateOre(5, this.frozenNitrogenGen, 0, 256);
		this.generateOre(10, this.blueGemGen, 0, 10);

//		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
//		for (int i = 0; i < this.LakesPerChunk; i++) {
//			if (this.rand.nextInt(10) == 0) {
//				int x = this.chunkX + this.rand.nextInt(16) + 8;
//				// int y = this.rand.nextInt(16) + 16;
//				int z = this.chunkZ + this.rand.nextInt(16) + 8;
//				int y = this.currentWorld.getHeightValue(x, z);
//				new WorldGenCustomLake(ExtraPlanets_Fluids.nitrogen).generate(this.currentWorld, this.rand, x, y, z, ExtraPlanets_Blocks.neptuneBlocks);
//			}
//		}
//		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, this.chunkX, this.chunkZ));

		isDecorating = false;
		// generateOre(int amountPerChunk, WorldGenerator worldGenerator, int
		// minY, int maxY);
	}
}