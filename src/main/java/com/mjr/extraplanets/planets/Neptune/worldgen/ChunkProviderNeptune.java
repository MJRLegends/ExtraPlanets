package com.mjr.extraplanets.planets.Neptune.worldgen;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicNeptune;
import com.mjr.extraplanets.world.prefabs.ChunkProviderCustomSpace;

public class ChunkProviderNeptune extends ChunkProviderCustomSpace {
	private final MapGenVillageNeptune villageGenerator = new MapGenVillageNeptune();

	private final BiomeDecoratorNeptune neptuneBiomeDecorator = new BiomeDecoratorNeptune();
	private final BiomeDecoratorNeptuneOther neptuneBiomeDecorator2 = new BiomeDecoratorNeptuneOther();

	private final MapGenCaveNeptune caveGenerator = new MapGenCaveNeptune();

	private final MapGenDungeon dungeonGenerator = new MapGenDungeonNeptune(new DungeonConfiguration(ExtraPlanets_Blocks.NEPTUNE_BLOCKS.getDefaultState().withProperty(BlockBasicNeptune.BASIC_TYPE, BlockBasicNeptune.EnumBlockBasic.DUNGEON_BRICK), 30,
			8, 16, 7, 7, RoomBossNeptune.class, RoomTreasureNeptune.class));

	public ChunkProviderNeptune(World par1World, long seed, boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
		this.stoneBlock = ExtraPlanets_Blocks.NEPTUNE_BLOCKS.getStateFromMeta(2);
		this.waterBlock = ExtraPlanets_Fluids.RADIO_ACTIVE_WATER.getDefaultState();
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
		this.dungeonGenerator.generate(this, this.worldObj, cX, cZ, primer);
	}

	@Override
	public void onPopulate(int cX, int cZ) {
		this.dungeonGenerator.generateStructure(this.worldObj, this.rand, new ChunkCoordIntPair(cX, cZ));
		if (Config.NEPTUNE_VILLAGES)
			this.villageGenerator.generateStructure(this.worldObj, this.rand, new ChunkCoordIntPair(cX, cZ));
	}

	@Override
	public void recreateStructures(Chunk chunk, int x, int z) {
		this.dungeonGenerator.generate(this, this.worldObj, x, z, null);
		if (Config.NEPTUNE_VILLAGES)
			this.villageGenerator.generate(this, this.worldObj, x, z, null);
	}

	@Override
	protected void decoratePlanet(World world, Random rand, int x, int z) {
		this.neptuneBiomeDecorator.decorate(worldObj, rand, x, z);
		// this.neptuneBiomeDecorator2.decorate(world, rand, null, new BlockPos(x, 0, z));
	}

}
