package com.mjr.extraplanets.planets.Jupiter.worldgen;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.prefab.core.BlockMetaPair;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.ChunkProviderSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.util.ForgeDirection;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanetsBlocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanetsFluids;
import com.mjr.extraplanets.entities.EntityEvolvedBlaze;
import com.mjr.extraplanets.entities.EntityEvolvedEnderman;
import com.mjr.extraplanets.entities.EntityEvolvedMagmaCube;
import com.mjr.extraplanets.entities.EntityEvolvedPowerSkeleton;
import com.mjr.extraplanets.entities.EntityEvolvedRedCreeper;
import com.mjr.extraplanets.entities.EntityEvolvedWitch;
import com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon.MapGenDungeon;
import com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon.RoomBossJupiter;
import com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon.RoomChestsJupiter;
import com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon.RoomEmptyJupiter;
import com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon.RoomSpawnerJupiter;
import com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon.RoomTreasureJupiter;
import com.mjr.extraplanets.planets.Jupiter.worldgen.village.MapGenVillageJupiter;

public class ChunkProviderJupiter extends ChunkProviderSpace {

	private final BiomeDecoratorJupiter greenPixelBiomeDecorator = new BiomeDecoratorJupiter();

	private final MapGenCaveJupiter caveGenerator = new MapGenCaveJupiter();

	private final MapGenVillageJupiter villageGenerator = new MapGenVillageJupiter();

	private final MapGenDungeon dungeonGenerator = new MapGenDungeon(ExtraPlanetsBlocks.jupiterDungeonBrick, 14, 8, 16, 3);

	public ChunkProviderJupiter(World par1World, long seed, boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
		this.dungeonGenerator.otherRooms.add(new RoomEmptyJupiter(null, 0, 0, 0,
				ForgeDirection.UNKNOWN)); this.dungeonGenerator.otherRooms.add(new
						RoomSpawnerJupiter(null, 0, 0, 0, ForgeDirection.UNKNOWN));
				this.dungeonGenerator.otherRooms.add(new RoomSpawnerJupiter(null, 0, 0,
						0, ForgeDirection.UNKNOWN)); this.dungeonGenerator.otherRooms.add(new
								RoomSpawnerJupiter(null, 0, 0, 0, ForgeDirection.UNKNOWN));
						this.dungeonGenerator.otherRooms.add(new RoomSpawnerJupiter(null, 0, 0,
								0, ForgeDirection.UNKNOWN)); this.dungeonGenerator.otherRooms.add(new
										RoomSpawnerJupiter(null, 0, 0, 0, ForgeDirection.UNKNOWN));
								this.dungeonGenerator.otherRooms.add(new RoomSpawnerJupiter(null, 0, 0,
										0, ForgeDirection.UNKNOWN)); this.dungeonGenerator.otherRooms.add(new
												RoomSpawnerJupiter(null, 0, 0, 0, ForgeDirection.UNKNOWN));
										this.dungeonGenerator.otherRooms.add(new RoomSpawnerJupiter(null, 0, 0,
												0, ForgeDirection.UNKNOWN)); this.dungeonGenerator.otherRooms.add(new
														RoomChestsJupiter(null, 0, 0, 0, ForgeDirection.UNKNOWN));
												this.dungeonGenerator.otherRooms.add(new RoomChestsJupiter(null, 0, 0,
														0, ForgeDirection.UNKNOWN)); this.dungeonGenerator.bossRooms.add(new
																RoomBossJupiter(null, 0, 0, 0, ForgeDirection.UNKNOWN));
														this.dungeonGenerator.treasureRooms.add(new RoomTreasureJupiter(null, 0,
																0, 0, ForgeDirection.UNKNOWN));
	}

	@Override
	protected BiomeDecoratorSpace getBiomeGenerator() {
		return this.greenPixelBiomeDecorator;
	}

	@Override
	protected BiomeGenBase[] getBiomesForGeneration() {
		return new BiomeGenBase[] { JupiterBiomes.jupiter };
	}

	@Override
	protected int getSeaLevel() {
		return 64;
	}

	@Override
	protected List<MapGenBaseMeta> getWorldGenerators() {
		List<MapGenBaseMeta> generators = Lists.newArrayList();
		generators.add(this.caveGenerator);
		return generators;
	}

	@Override
	protected BiomeGenBase.SpawnListEntry[] getMonsters()
	{
		List<BiomeGenBase.SpawnListEntry> monsters = new ArrayList<BiomeGenBase.SpawnListEntry>();
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedMagmaCube.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedWitch.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedEnderman.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedRedCreeper.class, 8, 2, 3));
		//monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedWizard.class, 8, 2, 3));
		//monsters.add(new BiomeGenBase.SpawnListEntry(EvolvedFireAllen.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedPowerSkeleton.class, 8, 2, 3));
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedBlaze.class, 8, 2, 3));
		return monsters.toArray(new BiomeGenBase.SpawnListEntry[monsters.size()]);
	}

	@Override
	protected BiomeGenBase.SpawnListEntry[] getCreatures()
	{
		return new BiomeGenBase.SpawnListEntry[0];
	}

	@Override
	protected BlockMetaPair getGrassBlock() {
		if(Config.jupiterLiquid)
			return new BlockMetaPair(ExtraPlanetsFluids.magma,(byte) 0);
		else
			return new BlockMetaPair(ExtraPlanetsBlocks.jupiterSurface,(byte) 1);
	}

	@Override
	protected BlockMetaPair getDirtBlock() {
		if(Config.jupiterLiquid)
			return new BlockMetaPair(ExtraPlanetsFluids.magma,(byte) 0);
		else
			return new BlockMetaPair(ExtraPlanetsBlocks.jupiterSubSurface,(byte) 1);
	}

	@Override
	protected BlockMetaPair getStoneBlock() {
		return new BlockMetaPair(ExtraPlanetsBlocks.jupiterStone,(byte) 1);
	}

	@Override
	public double getHeightModifier() {
		return 12;
	}

	@Override
	public double getSmallFeatureHeightModifier() {
		return 26;
	}

	@Override
	public double getMountainHeightModifier() {
		return 95;
	}

	@Override
	public double getValleyHeightModifier() {
		return 50;
	}

	@Override
	public int getCraterProbability() {
		return 2000;
	}

	@Override
	public void onChunkProvide(int cX, int cZ, Block[] blocks, byte[] metadata) {
		this.dungeonGenerator.generateUsingArrays(this.worldObj,
				this.worldObj.getSeed(), cX * 16, 25, cZ * 16, cX, cZ, blocks,metadata);
	}

	@Override
	public void onPopulate(IChunkProvider provider, int cX, int cZ) {
		if(!Config.jupiterLiquid)
			this.villageGenerator.generateStructuresInChunk(this.worldObj, this.rand, cX, cZ);
		this.dungeonGenerator.handleTileEntities(this.rand);
	}

	@Override
	public void recreateStructures(int par1, int par2) {
		if(!Config.jupiterLiquid)
			this.villageGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[]) null);
	}
}
