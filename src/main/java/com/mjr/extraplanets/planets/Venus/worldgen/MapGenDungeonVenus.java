package com.mjr.extraplanets.planets.Venus.worldgen;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.world.gen.structure.MapGenStructureIO;

public class MapGenDungeonVenus extends MapGenDungeon
{
    private static boolean initialized;

    static
    {
        try
        {
            MapGenDungeonVenus.initiateStructures();
        }
        catch (Throwable e)
        {

        }
    }

    public MapGenDungeonVenus(DungeonConfiguration configuration)
    {
        super(configuration);
    }

    public static void initiateStructures() throws Throwable
    {
        if (!MapGenDungeonVenus.initialized)
        {
            MapGenStructureIO.registerStructureComponent(RoomBossVenus.class, "VenusDungeonBossRoom");
            MapGenStructureIO.registerStructureComponent(RoomTreasureVenus.class, "VenusDungeonTreasureRoom");
        }

        MapGenDungeonVenus.initialized = true;
    }
}