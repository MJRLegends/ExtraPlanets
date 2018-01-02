package com.mjr.extraplanets.planets.Pluto.worldgen;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.world.gen.structure.MapGenStructureIO;

public class MapGenDungeonPluto extends MapGenDungeon {
	private static boolean initialized;

	static {
		try {
			MapGenDungeonPluto.initiateStructures();
		} catch (Throwable e) {

		}
	}

	public MapGenDungeonPluto(DungeonConfiguration configuration) {
		super(configuration);
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenDungeonPluto.initialized) {
			MapGenStructureIO.registerStructureComponent(RoomBossPluto.class, "PlutoDungeonBossRoom");
			MapGenStructureIO.registerStructureComponent(RoomTreasurePluto.class, "PlutoDungeonTreasureRoom");
		}

		MapGenDungeonPluto.initialized = true;
	}
}
