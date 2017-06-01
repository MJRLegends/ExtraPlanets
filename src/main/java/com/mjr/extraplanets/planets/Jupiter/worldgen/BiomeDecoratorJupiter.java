package com.mjr.extraplanets.planets.Jupiter.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.world.features.WorldGenBasicHideout;
import com.mjr.extraplanets.world.features.WorldGenCustomLake;

public class BiomeDecoratorJupiter extends BiomeDecoratorSpace {

	private WorldGenerator deshGen;
	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator ironGen;
	private WorldGenerator palladiumGen;
	private WorldGenerator nickelGen;
	private WorldGenerator gravelGen;
	private WorldGenerator redGemGen;
	private WorldGenerator ashRockGen;
	private WorldGenerator volcanicRockGen;
	private WorldGenerator skyBlocksGen;

	private int LakesPerChunk = 5;

	private World currentWorld;

	private boolean isDecorating = false;

	public BiomeDecoratorJupiter() {
		this.copperGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.JUPITER_BLOCKS, 4, 5, true, ExtraPlanets_Blocks.JUPITER_BLOCKS, 2);
		this.tinGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.JUPITER_BLOCKS, 4, 4, true, ExtraPlanets_Blocks.JUPITER_BLOCKS, 2);
		this.ironGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.JUPITER_BLOCKS, 8, 3, true, ExtraPlanets_Blocks.JUPITER_BLOCKS, 2);
		this.palladiumGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.JUPITER_BLOCKS, 4, 6, true, ExtraPlanets_Blocks.JUPITER_BLOCKS, 2);
		this.nickelGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.JUPITER_BLOCKS, 4, 7, true, ExtraPlanets_Blocks.JUPITER_BLOCKS, 2);
		this.gravelGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.JUPITER_GRAVEL, 12, 0, true, ExtraPlanets_Blocks.JUPITER_BLOCKS, 2);
		this.redGemGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.JUPITER_BLOCKS, 4, 10, true, ExtraPlanets_Blocks.JUPITER_BLOCKS, 2);
		this.redGemGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.JUPITER_BLOCKS, 4, 10, true, ExtraPlanets_Blocks.JUPITER_BLOCKS, 2);
		this.ashRockGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.ASH_ROCK, 5, 0, true, ExtraPlanets_Blocks.JUPITER_BLOCKS, 1);
		this.volcanicRockGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.VOLCANIC_ROCK, 5, 0, true, ExtraPlanets_Blocks.JUPITER_BLOCKS, 1);
		this.skyBlocksGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.JUPITER_BLOCKS, 3, 2, false, Blocks.AIR, 0);
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
		this.generateOre(20, this.palladiumGen, 0, 32);
		this.generateOre(20, this.nickelGen, 32, 40);
		this.generateOre(15, this.gravelGen, 0, 80);
		this.generateOre(10, this.redGemGen, 0, 10);
		this.generateOre(10, this.ashRockGen, 0, 256);
		this.generateOre(10, this.volcanicRockGen, 0, 256);
		this.generateOre(100, this.skyBlocksGen, 63, 256);

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, new BlockPos(this.chunkX, 0, this.chunkZ)));
		for (int i = 0; i < this.LakesPerChunk; i++) {
			if (this.rand.nextInt(10) == 0) {
				int x = this.chunkX + 8;
				// int y = this.rand.nextInt(16) + 16;
				int z = this.chunkZ + 8;
				int y = this.currentWorld.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z)).getY() - 2;
				new WorldGenCustomLake(ExtraPlanets_Fluids.MAGMA).generate(this.currentWorld, this.rand, new BlockPos(x, y, z), ExtraPlanets_Blocks.JUPITER_BLOCKS);
			}
		}

		if (this.rand.nextInt(50) == 1) {
			int x = this.chunkX + 8;
			int z = this.chunkZ + 8;
			int y = this.currentWorld.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z)).getY();
			new WorldGenBasicHideout().generate(this.currentWorld, this.rand, new BlockPos(x, y, z));
		}
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, new BlockPos(this.chunkX, 0, this.chunkZ)));

		isDecorating = false;
		// generateOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY);
	}

}
