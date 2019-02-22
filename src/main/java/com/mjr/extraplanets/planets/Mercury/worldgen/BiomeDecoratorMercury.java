package com.mjr.extraplanets.planets.Mercury.worldgen;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.mjrlegendslib.util.WorldGenUtilities;
import com.mjr.mjrlegendslib.world.features.WorldGenSphere;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.blocks.BlockBasic;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import micdoodle8.mods.galacticraft.planets.mars.blocks.BlockBasicMars;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

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
		if (Config.GENERATE_ORES_MERCURY) {
			this.copperGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.MERCURY_BLOCKS, 4, 5, true, ExtraPlanets_Blocks.MERCURY_BLOCKS, 2);
			this.tinGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.MERCURY_BLOCKS, 4, 4, true, ExtraPlanets_Blocks.MERCURY_BLOCKS, 2);
			this.ironGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.MERCURY_BLOCKS, 8, 3, true, ExtraPlanets_Blocks.MERCURY_BLOCKS, 2);
			this.mercuryGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.MERCURY_BLOCKS, 4, 6, true, ExtraPlanets_Blocks.MERCURY_BLOCKS, 2);
			this.carbonGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.MERCURY_BLOCKS, 4, 10, true, ExtraPlanets_Blocks.MERCURY_BLOCKS, 2);
		}
		this.gravelGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.MERCURY_GRAVEL, 12, 0, true, ExtraPlanets_Blocks.MERCURY_BLOCKS, 2);
		this.fossilsGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.FOSSIL, 3, 0, true, ExtraPlanets_Blocks.MERCURY_BLOCKS, 1);
		if (Config.RADIATION)
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
		if (Config.GENERATE_ORES_MERCURY) {
			this.generateOre(26, this.copperGen, 0, 60);
			this.generateOre(23, this.tinGen, 0, 60);
			this.generateOre(20, this.ironGen, 0, 64);
			this.generateOre(20, this.mercuryGen, 0, 64);
			this.generateOre(20, this.carbonGen, 0, 64);
		}
		this.generateOre(15, this.gravelGen, 0, 80);
		this.generateOre(10, this.fossilsGen, 0, 256);
		if (Config.RADIATION)
			this.generateOre(10, this.potashGen, 0, 20);

		// generateOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY);

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, new BlockPos(this.posX, 0, this.posZ)));
		for (int i = 0; i < 1; i++) {
			if (this.rand.nextInt(100) == 0) {
				WorldGenUtilities.generateLake(this.currentWorld, this.rand, new BlockPos(this.posX, 0, this.posZ), ExtraPlanets_Fluids.INFECTED_WATER, ExtraPlanets_Blocks.MERCURY_BLOCKS);
			}
		}
		if (Config.GENERATE_MERCURY_METEORS) {
			for (int i = 0; i < 1; i++) {
				if (rand.nextInt(25) == 1) {
					WorldGenUtilities.generateStructureWithRandom(new WorldGenSphere(true, Constants.modID, GCBlocks.basicBlock.getDefaultState().withProperty(BlockBasic.BASIC_TYPE, BlockBasic.EnumBlockBasic.DECO_BLOCK_METEOR_IRON), 8, 2),
							this.currentWorld, rand, new BlockPos(this.posX, 0, this.posZ), 6);
				}
			}
			for (int i = 0; i < 1; i++) {
				if (rand.nextInt(25) == 1) {
					WorldGenUtilities.generateStructureWithRandom(new WorldGenSphere(true, Constants.modID, MarsBlocks.marsBlock.getDefaultState().withProperty(BlockBasicMars.BASIC_TYPE, BlockBasicMars.EnumBlockBasic.DESH_BLOCK), 8, 2),
							this.currentWorld, rand, new BlockPos(this.posX, 0, this.posZ), 6);
				}
			}
		}
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, new BlockPos(this.posX, 0, this.posZ)));

		isDecorating = false;
	}

}
