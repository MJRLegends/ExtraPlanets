package com.mjr.extraplanets.planets.Mercury.worldgen;

import java.util.List;
import java.util.Random;

import com.mjr.extraplanets.planets.Mercury.worldgen.dungeon.*;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;

import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;

public class MapGenDungeonMercury extends MapGenDungeon {
	private static boolean initialized;
	private DungeonConfiguration configuration;

	// static { //Disabled due to needing to overriding GC StructureComponent so calling in constructor instead now
	// try {
	// MapGenDungeonMercury.initiateStructures();
	// } catch (Throwable e) {
	//
	// }
	// }

	public MapGenDungeonMercury(DungeonConfiguration configuration) {
		super(configuration);
		this.configuration = configuration;
		try {
			MapGenDungeonMercury.initiateStructures();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenDungeonMercury.initialized) {
			MapGenStructureIO.registerStructure(Start.class, "MercuryDungeon");
			MapGenStructureIO.registerStructureComponent(DungeonStartMercury.class, "MercuryDungeonStart");
			MapGenStructureIO.registerStructureComponent(CorridorMercury.class, "MercuryDungeonCorridor");
			MapGenStructureIO.registerStructureComponent(RoomEmptyMercury.class, "MercuryDungeonEmptyRoom");
			MapGenStructureIO.registerStructureComponent(RoomBossMercury.class, "MercuryDungeonBossRoom");
			MapGenStructureIO.registerStructureComponent(RoomTreasureMercury.class, "MercuryDungeonTreasureRoom");
			MapGenStructureIO.registerStructureComponent(RoomSpawnerMercury.class, "MercuryDungeonSpawnerRoom");
			MapGenStructureIO.registerStructureComponent(RoomSpawner2Mercury.class, "MercuryDungeonSpawner2Room");
			MapGenStructureIO.registerStructureComponent(RoomSpawner3Mercury.class, "MercuryDungeonSpawner3Room");
			MapGenStructureIO.registerStructureComponent(RoomChestMercury.class, "MercuryDungeonChestRoom");
			MapGenStructureIO.registerStructureComponent(RoomEntranceMercury.class, "MercuryDungeonEntranceRoom");
		}

		MapGenDungeonMercury.initialized = true;
	}

	@Override
	protected StructureStart getStructureStart(int chunkX, int chunkZ) {
		return new Start(this.world, this.rand, chunkX, chunkZ, this.configuration);
	}

	public static class Start extends StructureStart {
		private DungeonConfiguration configuration;
		DungeonStartMercury startPiece;

		public Start() {
		}

		public Start(World worldIn, Random rand, int chunkX, int chunkZ, DungeonConfiguration configuration) {
			super(chunkX, chunkZ);
			this.configuration = configuration;
			startPiece = new DungeonStartMercury(worldIn, configuration, rand, (chunkX << 4) + 2, (chunkZ << 4) + 2);
			startPiece.buildComponent(startPiece, this.components, rand);
			List<StructureComponent> list = startPiece.attachedComponents;

			while (!list.isEmpty()) {
				int i = rand.nextInt(list.size());
				StructureComponent structurecomponent = list.remove(i);
				structurecomponent.buildComponent(startPiece, this.components, rand);
			}

			this.updateBoundingBox();
		}
	}
}