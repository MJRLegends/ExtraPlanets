package com.mjr.extraplanets.planets.Neptune.worldgen;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.world.gen.structure.MapGenStructureIO;

public class MapGenDungeonNeptune extends MapGenDungeon {
	private static boolean initialized;

	static {
		try {
			MapGenDungeonNeptune.initiateStructures();
		} catch (Throwable e) {

		}
	}

	public MapGenDungeonNeptune(DungeonConfiguration configuration) {
		super(configuration);
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenDungeonNeptune.initialized) {
			MapGenStructureIO.registerStructureComponent(RoomBossNeptune.class, "NeptuneDungeonBossRoom");
			MapGenStructureIO.registerStructureComponent(RoomTreasureNeptune.class, "NeptuneDungeonTreasureRoom");
		}

		MapGenDungeonNeptune.initialized = true;
	}
}