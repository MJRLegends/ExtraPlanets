package com.mjr.extraplanets.planets.Saturn.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicSaturn;
import com.mjr.extraplanets.planets.Saturn.worldgen.biomes.BiomeGenSaturn;
import com.mjr.extraplanets.planets.Saturn.worldgen.biomes.BiomeGenSaturnNuclearLand;
import com.mjr.extraplanets.util.WorldGenHelper;
import com.mjr.extraplanets.world.features.WorldGenNuclearPile;
import com.mjr.extraplanets.world.features.WorldGenSlimeTree;

public class BiomeDecoratorSaturn extends BiomeDecoratorSpace {

	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator ironGen;
	private WorldGenerator iceGen;
	private WorldGenerator magnesiumGen;
	private WorldGenerator gravelGen;
	private WorldGenerator slimeGen;

	private int LakesPerChunk = 5;

	private World currentWorld;

	private boolean isDecorating = false;

	public BiomeDecoratorSaturn() {
		this.copperGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.SATURN_BLOCKS, 4, 5, true, ExtraPlanets_Blocks.SATURN_BLOCKS, 2);
		this.tinGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.SATURN_BLOCKS, 4, 4, true, ExtraPlanets_Blocks.SATURN_BLOCKS, 2);
		this.ironGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.SATURN_BLOCKS, 8, 3, true, ExtraPlanets_Blocks.SATURN_BLOCKS, 2);
		this.iceGen = new WorldGenMinableMeta(Blocks.ice, 18, 0, true, ExtraPlanets_Blocks.SATURN_BLOCKS, 2);
		this.magnesiumGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.SATURN_BLOCKS, 4, 6, true, ExtraPlanets_Blocks.SATURN_BLOCKS, 2);
		this.gravelGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.SATURN_GRAVEL, 12, 0, true, ExtraPlanets_Blocks.SATURN_BLOCKS, 2);
		this.slimeGen = new WorldGenMinableMeta(ExtraPlanets_Blocks.SATURN_BLOCKS, 12, 12, true, ExtraPlanets_Blocks.SATURN_BLOCKS, 10);
		// WorldGenMinableMeta(Block OreBlock, int numberOfBlocks, int OreMeta,boolean usingMetaData, Block StoneBlock, int StoneMeta);
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
		this.generateOre(4, this.iceGen, 50, 120);
		this.generateOre(20, this.magnesiumGen, 0, 32);
		this.generateOre(15, this.gravelGen, 0, 80);
		this.generateOre(10, this.slimeGen, 60, 256);
		// generateOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY);
		
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, new BlockPos(this.posX, 0, this.posZ)));

		if (this.getCurrentWorld().getBiomeGenForCoords(new BlockPos(this.posX, 0, this.posZ)) instanceof BiomeGenSaturn)
			for (int i = 0; i < this.LakesPerChunk; i++) {
				if (this.rand.nextInt(10) == 0) {
					WorldGenHelper.generateLake(this.currentWorld, this.rand, new BlockPos(this.posX, 0, this.posZ), ExtraPlanets_Fluids.GLOWSTONE,
							ExtraPlanets_Blocks.SATURN_BLOCKS.getDefaultState().withProperty(BlockBasicSaturn.BASIC_TYPE, BlockBasicSaturn.EnumBlockBasic.SURFACE));
				}
			}

		if (this.getCurrentWorld().getBiomeGenForCoords(new BlockPos(this.posX, 0, this.posZ)) instanceof BiomeGenSaturnNuclearLand) {
			for (int i = 0; i < LakesPerChunk * 2; i++) {
				if (this.rand.nextInt(10) == 0) {
					WorldGenHelper.generateLake(this.currentWorld, this.rand, new BlockPos(this.posX, 0, this.posZ), ExtraPlanets_Fluids.METHANE,
							ExtraPlanets_Blocks.SATURN_BLOCKS.getDefaultState().withProperty(BlockBasicSaturn.BASIC_TYPE, BlockBasicSaturn.EnumBlockBasic.BROKEN_INFECTED_STONE));
				}
			}
			if (this.rand.nextInt(5) == 1) {
				BlockPos blockpos = this.currentWorld.getTopSolidOrLiquidBlock(new BlockPos(this.posX + (this.rand.nextInt(16) + 8), 0, this.posZ + (this.rand.nextInt(16) + 8)));
				new WorldGenNuclearPile().generate(this.currentWorld, this.rand, blockpos);
			}
			if (this.rand.nextInt(5) == 1) {
				BlockPos blockpos = this.currentWorld.getTopSolidOrLiquidBlock(new BlockPos(this.posX + (this.rand.nextInt(16) + 8), 0, this.posZ + (this.rand.nextInt(16) + 8)));
				new WorldGenSlimeTree().generate(this.currentWorld, this.rand, blockpos);
			}
		}
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, new BlockPos(this.posX, 0, this.posZ)));

		isDecorating = false;
	}
}
