package com.mjr.extraplanets.planets.Neptune.worldgen;

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
import com.mjr.extraplanets.planets.Neptune.worldgen.dungeon.MapGenDungeon;
import com.mjr.extraplanets.planets.Neptune.worldgen.dungeon.RoomBossNeptune;
import com.mjr.extraplanets.planets.Neptune.worldgen.dungeon.RoomChestsNeptune;
import com.mjr.extraplanets.planets.Neptune.worldgen.dungeon.RoomEmptyNeptune;
import com.mjr.extraplanets.planets.Neptune.worldgen.dungeon.RoomSpawnerNeptune;
import com.mjr.extraplanets.planets.Neptune.worldgen.dungeon.RoomTreasureNeptune;
import com.mjr.extraplanets.planets.Neptune.worldgen.village.MapGenVillageNeptune;
import com.mjr.extraplanets.world.prefabs.ChunkProviderCustomSpace;

public class ChunkProviderNeptune extends ChunkProviderCustomSpace {
	private final BiomeDecoratorNeptune biomeDecorator = new BiomeDecoratorNeptune();
	public Random randomGenerator;

	private final MapGenCaveNeptune caveGenerator = new MapGenCaveNeptune();

	private final MapGenVillageNeptune villageGenerator = new MapGenVillageNeptune();

	private final MapGenDungeon dungeonGenerator = new MapGenDungeon(ExtraPlanets_Blocks.neptuneDungeonBrick, 14, 8, 16, 3);

	public ChunkProviderNeptune(World par1World, long seed, boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
		this.waterBlock = ExtraPlanets_Fluids.radio_active_water;
		this.dungeonGenerator.otherRooms.add(new RoomEmptyNeptune(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerNeptune(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerNeptune(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerNeptune(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerNeptune(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerNeptune(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerNeptune(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerNeptune(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerNeptune(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomChestsNeptune(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.otherRooms.add(new RoomChestsNeptune(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.bossRooms.add(new RoomBossNeptune(null, 0, 0, 0, ForgeDirection.UNKNOWN));
		this.dungeonGenerator.treasureRooms.add(new RoomTreasureNeptune(null, 0, 0, 0, ForgeDirection.UNKNOWN));
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
	}

	@Override
	public void recreateStructures(int par1, int par2) {
		if (!Config.neptuneLiquid)
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
		if (!Config.neptuneLiquid)
			this.villageGenerator.generateStructuresInChunk(this.worldObj, this.rand, cX, cZ);
		this.dungeonGenerator.handleTileEntities(this.rand);
	}
}