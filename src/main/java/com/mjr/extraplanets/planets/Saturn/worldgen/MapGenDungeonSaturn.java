package com.mjr.extraplanets.planets.Saturn.worldgen;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.world.gen.structure.MapGenStructureIO;

public class MapGenDungeonSaturn extends MapGenDungeon
{
    private static boolean initialized;

    static
    {
        try
        {
            MapGenDungeonSaturn.initiateStructures();
        }
        catch (Throwable e)
        {

        }
    }

    public MapGenDungeonSaturn(DungeonConfiguration configuration)
    {
        super(configuration);
    }

    public static void initiateStructures() throws Throwable
    {
        if (!MapGenDungeonSaturn.initialized)
        {
            MapGenStructureIO.registerStructureComponent(RoomBossSaturn.class, "SaturnDungeonBossRoom");
            MapGenStructureIO.registerStructureComponent(RoomTreasureSaturn.class, "SaturnDungeonTreasureRoom");
        }

        MapGenDungeonSaturn.initialized = true;
    }
}