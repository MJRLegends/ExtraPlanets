package com.mjr.extraplanets.planets.Mercury.worldgen;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.world.gen.structure.MapGenStructureIO;

public class MapGenDungeonMercury extends MapGenDungeon
{
    private static boolean initialized;

    static
    {
        try
        {
            MapGenDungeonMercury.initiateStructures();
        }
        catch (Throwable e)
        {

        }
    }

    public MapGenDungeonMercury(DungeonConfiguration configuration)
    {
        super(configuration);
    }

    public static void initiateStructures() throws Throwable
    {
        if (!MapGenDungeonMercury.initialized)
        {
            MapGenStructureIO.registerStructureComponent(RoomBossMercury.class, "MercuryDungeonBossRoom");
            MapGenStructureIO.registerStructureComponent(RoomTreasureMercury.class, "MercuryDungeonTreasureRoom");
        }

        MapGenDungeonMercury.initialized = true;
    }
}