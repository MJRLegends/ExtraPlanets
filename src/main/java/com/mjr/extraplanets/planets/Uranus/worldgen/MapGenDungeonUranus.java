package com.mjr.extraplanets.planets.Uranus.worldgen;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.world.gen.structure.MapGenStructureIO;

public class MapGenDungeonUranus extends MapGenDungeon
{
    private static boolean initialized;

    static
    {
        try
        {
            MapGenDungeonUranus.initiateStructures();
        }
        catch (Throwable e)
        {

        }
    }

    public MapGenDungeonUranus(DungeonConfiguration configuration)
    {
        super(configuration);
    }

    public static void initiateStructures() throws Throwable
    {
        if (!MapGenDungeonUranus.initialized)
        {
            MapGenStructureIO.registerStructureComponent(RoomBossUranus.class, "UranusDungeonBossRoom");
            MapGenStructureIO.registerStructureComponent(RoomTreasureUranus.class, "UranusDungeonTreasureRoom");
        }

        MapGenDungeonUranus.initialized = true;
    }
}
