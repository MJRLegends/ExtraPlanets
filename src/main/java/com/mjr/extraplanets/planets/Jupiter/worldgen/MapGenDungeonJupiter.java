package com.mjr.extraplanets.planets.Jupiter.worldgen;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.world.gen.structure.MapGenStructureIO;

public class MapGenDungeonJupiter extends MapGenDungeon {
	private static boolean initialized;

	static {
		try {
			MapGenDungeonJupiter.initiateStructures();
		} catch (Throwable e) {

		}
	}

	public MapGenDungeonJupiter(DungeonConfiguration configuration) {
		super(configuration);
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenDungeonJupiter.initialized) {
			MapGenStructureIO.registerStructureComponent(RoomBossJupiter.class, "JupiterDungeonBossRoom");
			MapGenStructureIO.registerStructureComponent(RoomTreasureJupiter.class, "JupiterDungeonTreasureRoom");
		}

		MapGenDungeonJupiter.initialized = true;
	}
}