package com.mjr.extraplanets.planets.Uranus.worldgen;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.planets.Uranus.worldgen.dungeon.MapGenDungeon;
import com.mjr.extraplanets.planets.Uranus.worldgen.dungeon.RoomBossUranus;
import com.mjr.extraplanets.planets.Uranus.worldgen.dungeon.RoomChestsUranus;
import com.mjr.extraplanets.planets.Uranus.worldgen.dungeon.RoomEmptyUranus;
import com.mjr.extraplanets.planets.Uranus.worldgen.dungeon.RoomSpawnerUranus;
import com.mjr.extraplanets.planets.Uranus.worldgen.dungeon.RoomTreasureUranus;
import com.mjr.extraplanets.planets.Uranus.worldgen.village.MapGenVillageUranus;
import com.mjr.extraplanets.world.prefabs.ChunkProviderCustomSpace;

public class ChunkProviderUranus extends ChunkProviderCustomSpace {
	private final BiomeDecoratorUranus biomeDecorator = new BiomeDecoratorUranus();
	public Random randomGenerator;

	private final MapGenCaveUranus caveGenerator = new MapGenCaveUranus();

	private final MapGenRavineUranus ravineGenerator = new MapGenRavineUranus();

	private final MapGenVillageUranus villageGenerator = new MapGenVillageUranus();

	private final MapGenDungeon dungeonGenerator = new MapGenDungeon(ExtraPlanets_Blocks.uranusDungeonBrick, 14, 8, 16, 3);

	public ChunkProviderUranus(World par1World, long seed, boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
		this.waterBlock = ExtraPlanets_Fluids.frozen_water;
		this.dungeonGenerator.otherRooms.add(new RoomEmptyUranus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerUranus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerUranus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerUranus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerUranus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerUranus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerUranus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerUranus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerUranus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomChestsUranus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomChestsUranus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.bossRooms.add(new RoomBossUranus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.treasureRooms.add(new RoomTreasureUranus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
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
		this.villageGenerator.generateStructuresInChunk(this.worldObj, this.rand, cX, cZ);
		this.dungeonGenerator.handleTileEntities(this.rand);
	}
}