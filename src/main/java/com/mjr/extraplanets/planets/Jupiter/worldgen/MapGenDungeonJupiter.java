package com.mjr.extraplanets.planets.Jupiter.worldgen;

import java.util.List;
import java.util.Random;

import com.mjr.extraplanets.planets.Jupiter.worldgen.dungeon.*;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;

import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;

public class MapGenDungeonJupiter extends MapGenDungeon {
	private static boolean initialized;
	private DungeonConfiguration configuration;

	// static { //Disabled due to needing to overriding GC StructureComponent so calling in constructor instead now
	// try {
	// MapGenDungeonJupiter.initiateStructures();
	// } catch (Throwable e) {
	//
	// }
	// }

	public MapGenDungeonJupiter(DungeonConfiguration configuration) {
		super(configuration);
		this.configuration = configuration;
		try {
			MapGenDungeonJupiter.initiateStructures();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenDungeonJupiter.initialized) {
			MapGenStructureIO.registerStructure(Start.class, "JupiterDungeon");
			MapGenStructureIO.registerStructureComponent(DungeonStartJupiter.class, "JupiterDungeonStart");
			MapGenStructureIO.registerStructureComponent(CorridorJupiter.class, "JupiterDungeonCorridor");
			MapGenStructureIO.registerStructureComponent(RoomEmptyJupiter.class, "JupiterDungeonEmptyRoom");
			MapGenStructureIO.registerStructureComponent(RoomBossJupiter.class, "JupiterDungeonBossRoom");
			MapGenStructureIO.registerStructureComponent(RoomTreasureJupiter.class, "JupiterDungeonTreasureRoom");
			MapGenStructureIO.registerStructureComponent(RoomSpawnerJupiter.class, "JupiterDungeonSpawnerRoom");
			MapGenStructureIO.registerStructureComponent(RoomChestJupiter.class, "JupiterDungeonChestRoom");
			MapGenStructureIO.registerStructureComponent(RoomEntranceJupiter.class, "JupiterDungeonEntranceRoom");
		}

		MapGenDungeonJupiter.initialized = true;
	}

	@Override
	protected StructureStart getStructureStart(int chunkX, int chunkZ) {
		return new Start(this.worldObj, this.rand, chunkX, chunkZ, this.configuration);
	}

	public static class Start extends StructureStart {
		private DungeonConfiguration configuration;
		DungeonStartJupiter startPiece;

		public Start() {
		}

		public Start(World worldIn, Random rand, int chunkX, int chunkZ, DungeonConfiguration configuration) {
			super(chunkX, chunkZ);
			this.configuration = configuration;
			startPiece = new DungeonStartJupiter(worldIn, configuration, rand, (chunkX << 4) + 2, (chunkZ << 4) + 2);
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