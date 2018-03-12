package com.mjr.extraplanets.planets.Jupiter.worldgen;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon.MapGenDungeon;
import com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon.RoomBossJupiter;
import com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon.RoomChestsJupiter;
import com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon.RoomEmptyJupiter;
import com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon.RoomSpawnerJupiter;
import com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon.RoomTreasureJupiter;
import com.mjr.extraplanets.planets.Jupiter.worldgen.village.MapGenVillageJupiter;
import com.mjr.extraplanets.world.prefabs.ChunkProviderCustomSpace;

public class ChunkProviderJupiter extends ChunkProviderCustomSpace {
	private final BiomeDecoratorJupiter biomeDecorator = new BiomeDecoratorJupiter();
	public Random randomGenerator;

	private final MapGenCaveJupiter caveGenerator = new MapGenCaveJupiter();

	private final MapGenRavineJupiter ravineGenerator = new MapGenRavineJupiter();

	private final MapGenVillageJupiter villageGenerator = new MapGenVillageJupiter();

	private final MapGenDungeon dungeonGenerator = new MapGenDungeon(ExtraPlanets_Blocks.jupiterDungeonBrick, 14, 8, 16, 3);

	public ChunkProviderJupiter(World par1World, long seed, boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
		this.waterBlock = ExtraPlanets_Fluids.magma;
		this.dungeonGenerator.otherRooms.add(new RoomEmptyJupiter(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerJupiter(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerJupiter(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerJupiter(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerJupiter(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerJupiter(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerJupiter(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerJupiter(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerJupiter(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomChestsJupiter(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomChestsJupiter(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.bossRooms.add(new RoomBossJupiter(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.treasureRooms.add(new RoomTreasureJupiter(null, 0, 0, 0, ForgeDirection.UNKNOWN));
	}

	@Override
	protected List<MapGenBaseMeta> getWorldGenerators() {
		List<MapGenBaseMeta> generators = Lists.newArrayList();
		generators.add(this.caveGenerator);
		return generators;
	}

	@Override
	public void onChunkProvide(int cX, int cZ, Block[] blocks, byte[] metadata) {
		this.dungeonGenerator.generateUsingArrays(this.worldObj, this.worldObj.getSeed(), cX * 16, 25, cZ * 16, cX, cZ, blocks, metadata);
		this.ravineGenerator.func_151539_a(this, this.worldObj, cX, cZ, blocks);
	}

	@Override
	public void recreateStructures(int par1, int par2) {
		if (Config.jupiterVillages)
			this.villageGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[]) null);
	}

	@Override
	public void decoratePlanet(World world, Random rand, int x, int z) {
		this.biomeDecorator.decorateChunk(world, rand, null, x, z);
	}

	@Override
	protected int getCraterProbability() {
		return 0;
	}

	@Override
	public void onPopulate(int cX, int cZ) {
		if (Config.jupiterVillages)
			this.villageGenerator.generateStructuresInChunk(this.worldObj, this.rand, cX, cZ);
		this.dungeonGenerator.handleTileEntities(this.rand);
	}
}