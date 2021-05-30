package com.mjr.extraplanets.planets.Uranus.worldgen;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicUranus;
import com.mjr.mjrlegendslib.world.ChunkProviderMultiBiomeSpace;
import com.mjr.mjrlegendslib.world.gen.MapGenBaseMeta;
import com.mjr.mjrlegendslib.world.gen.MapGenCaveGen;
import com.mjr.mjrlegendslib.world.gen.MapGenRavineGen;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;

public class ChunkProviderUranus extends ChunkProviderMultiBiomeSpace {
	private final MapGenVillageUranus villageGenerator = new MapGenVillageUranus();

	private final BiomeDecoratorUranus uranusBiomeDecorator = new BiomeDecoratorUranus();
	private final MapGenRavineGen ravineGenerator = new MapGenRavineGen(ExtraPlanets_Fluids.FROZEN_WATER);
	private final MapGenCaveGen caveGenerator = new MapGenCaveGen(ExtraPlanets_Blocks.URANUS_BLOCKS, 0, 1, 2);

	private final MapGenDungeon dungeonGenerator = new MapGenDungeonUranus(
			new DungeonConfiguration(ExtraPlanets_Blocks.URANUS_BLOCKS.getDefaultState().withProperty(BlockBasicUranus.BASIC_TYPE, BlockBasicUranus.EnumBlockBasic.DUNGEON_BRICK), 30, 8, 16, 7, 7, RoomBossUranus.class, RoomTreasureUranus.class));

	public ChunkProviderUranus(World par1World, long seed, boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
		this.stoneBlock = ExtraPlanets_Blocks.URANUS_BLOCKS.getDefaultState().withProperty(BlockBasicUranus.BASIC_TYPE, BlockBasicUranus.EnumBlockBasic.STONE);
		this.waterBlock = ExtraPlanets_Fluids.FROZEN_WATER.getDefaultState();
	}

	@Override
	protected List<MapGenBaseMeta> getWorldGenerators() {
		List<MapGenBaseMeta> generators = Lists.newArrayList();
		generators.add(this.caveGenerator);
		return generators;
	}

	@Override
	public int getCraterProbability() {
		return 2000;
	}

	@Override
	public void onChunkProvide(int cX, int cZ, ChunkPrimer primer) {
		this.ravineGenerator.generate(this.worldObj, cX, cZ, primer);
		this.dungeonGenerator.generate(this.worldObj, cX, cZ, primer);
	}

	@Override
	public void onPopulate(int cX, int cZ) {
		this.dungeonGenerator.generateStructure(this.worldObj, this.rand, new ChunkPos(cX, cZ));
		if (Config.URANUS_VILLAGES)
			this.villageGenerator.generateStructure(this.worldObj, this.rand, new ChunkPos(cX, cZ));
	}

	@Override
	public void recreateStructures(Chunk chunk, int x, int z) {
		this.dungeonGenerator.generate(this.worldObj, x, z, null);
		if (Config.URANUS_VILLAGES)
			this.villageGenerator.generate(this.worldObj, x, z, null);

	}

	@Override
	protected void decoratePlanet(World world, Random rand, int x, int z) {
		this.uranusBiomeDecorator.decorate(worldObj, rand, x, z);
	}
}
