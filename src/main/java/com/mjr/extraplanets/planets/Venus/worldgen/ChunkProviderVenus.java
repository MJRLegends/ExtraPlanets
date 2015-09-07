package com.mjr.extraplanets.planets.Venus.worldgen;

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
import com.mjr.extraplanets.blocks.ExtraPlanetsBlocks;
import com.mjr.extraplanets.entities.EntityEvolvedBlaze;
import com.mjr.extraplanets.entities.EntityEvolvedEnderman;
import com.mjr.extraplanets.entities.EntityEvolvedMagmaCube;
import com.mjr.extraplanets.planets.Venus.worldgen.dungeon.MapGenDungeon;
import com.mjr.extraplanets.planets.Venus.worldgen.dungeon.RoomBossVenus;
import com.mjr.extraplanets.planets.Venus.worldgen.dungeon.RoomChestsVenus;
import com.mjr.extraplanets.planets.Venus.worldgen.dungeon.RoomEmptyVenus;
import com.mjr.extraplanets.planets.Venus.worldgen.dungeon.RoomSpawnerVenus;
import com.mjr.extraplanets.planets.Venus.worldgen.dungeon.RoomTreasureVenus;
import com.mjr.extraplanets.planets.Venus.worldgen.village.MapGenVillageVenus;

public class ChunkProviderVenus extends ChunkProviderSpace {

	private final BiomeDecoratorVenus greenPixelBiomeDecorator = new BiomeDecoratorVenus();

	private final MapGenCaveVenus caveGenerator = new MapGenCaveVenus();

	private final MapGenVillageVenus villageGenerator = new MapGenVillageVenus();

	private final MapGenDungeon dungeonGenerator = new MapGenDungeon(ExtraPlanetsBlocks.veunsDungeonBrick, 14, 8, 16, 3);

	public ChunkProviderVenus(World par1World, long seed, boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
		this.dungeonGenerator.otherRooms.add(new RoomEmptyVenus(null, 0, 0, 0,
				ForgeDirection.UNKNOWN)); this.dungeonGenerator.otherRooms.add(new
						RoomSpawnerVenus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
				this.dungeonGenerator.otherRooms.add(new RoomSpawnerVenus(null, 0, 0,
						0, ForgeDirection.UNKNOWN)); this.dungeonGenerator.otherRooms.add(new
								RoomSpawnerVenus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
						this.dungeonGenerator.otherRooms.add(new RoomSpawnerVenus(null, 0, 0,
								0, ForgeDirection.UNKNOWN)); this.dungeonGenerator.otherRooms.add(new
										RoomSpawnerVenus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
								this.dungeonGenerator.otherRooms.add(new RoomSpawnerVenus(null, 0, 0,
										0, ForgeDirection.UNKNOWN)); this.dungeonGenerator.otherRooms.add(new
												RoomSpawnerVenus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
										this.dungeonGenerator.otherRooms.add(new RoomSpawnerVenus(null, 0, 0,
												0, ForgeDirection.UNKNOWN)); this.dungeonGenerator.otherRooms.add(new
														RoomChestsVenus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
												this.dungeonGenerator.otherRooms.add(new RoomChestsVenus(null, 0, 0,
														0, ForgeDirection.UNKNOWN)); this.dungeonGenerator.bossRooms.add(new
																RoomBossVenus(null, 0, 0, 0, ForgeDirection.UNKNOWN));
														this.dungeonGenerator.treasureRooms.add(new RoomTreasureVenus(null, 0,
																0, 0, ForgeDirection.UNKNOWN));
	}

	@Override
	protected BiomeDecoratorSpace getBiomeGenerator() {
		return this.greenPixelBiomeDecorator;
	}

	@Override
	protected BiomeGenBase[] getBiomesForGeneration() {
		return new BiomeGenBase[] { VenusBiomes.venus };
	}

	@Override
	protected int getSeaLevel(){
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
		monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedEnderman.class, 8, 2, 3));
		//monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedWizard.class, 8, 2, 3));
		//monsters.add(new BiomeGenBase.SpawnListEntry(EvolvedFireAllen.class, 8, 2, 3));
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
		return new BlockMetaPair(ExtraPlanetsBlocks.venusSurface,(byte) 1);
	}

	@Override
	protected BlockMetaPair getDirtBlock() {
		return new BlockMetaPair(ExtraPlanetsBlocks.venusSubSurface,(byte) 1);
	}

	@Override
	protected BlockMetaPair getStoneBlock() {
		return new BlockMetaPair(ExtraPlanetsBlocks.venusStone,(byte) 1);
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
		this.villageGenerator.generateStructuresInChunk(this.worldObj, this.rand, cX, cZ);
		this.dungeonGenerator.handleTileEntities(this.rand);
	}

	@Override
	public void recreateStructures(int par1, int par2) {
		this.villageGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[]) null);
	}

}
