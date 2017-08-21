package com.mjr.extraplanets.planets.Jupiter.worldgen;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicJupiter;
import com.mjr.extraplanets.world.prefabs.ChunkProviderCustomSpace;

public class ChunkProviderJupiter extends ChunkProviderCustomSpace {
	private final MapGenVillageJupiter villageGenerator = new MapGenVillageJupiter();

	private final BiomeDecoratorJupiter jupiterBiomeDecorator = new BiomeDecoratorJupiter();

	private final MapGenCaveJupiter caveGenerator = new MapGenCaveJupiter();

	private final MapGenDungeon dungeonGenerator = new MapGenDungeonJupiter(new DungeonConfiguration(ExtraPlanets_Blocks.JUPITER_BLOCKS.getDefaultState().withProperty(BlockBasicJupiter.BASIC_TYPE, BlockBasicJupiter.EnumBlockBasic.DUNGEON_BRICK), 30,
			8, 16, 7, 7, RoomBossJupiter.class, RoomTreasureJupiter.class));

	public ChunkProviderJupiter(World par1World, long seed, boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
		this.stoneBlock = ExtraPlanets_Blocks.JUPITER_BLOCKS.getStateFromMeta(2);
		this.waterBlock = ExtraPlanets_Fluids.MAGMA.getDefaultState();
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
		this.dungeonGenerator.generate(this.worldObj, cX, cZ, primer);
	}

	@Override
	public void onPopulate(int cX, int cZ) {
		this.dungeonGenerator.generateStructure(this.worldObj, this.rand, new ChunkPos(cX, cZ));
		if (Config.JUPITER_VILLAGES)
			this.villageGenerator.generateStructure(this.worldObj, this.rand, new ChunkPos(cX, cZ));
	}

	@Override
	public void recreateStructures(Chunk chunk, int x, int z) {
		this.dungeonGenerator.generate(this.worldObj, x, z, null);
		if (Config.JUPITER_VILLAGES)
			this.villageGenerator.generate(this.worldObj, x, z, null);
	}

	@Override
	protected void decoratePlanet(World world, Random rand, int x, int z) {
		this.jupiterBiomeDecorator.decorate(worldObj, rand, x, z);
	}

}
