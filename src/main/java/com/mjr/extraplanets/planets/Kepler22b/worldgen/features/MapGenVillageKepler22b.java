package com.mjr.extraplanets.planets.Kepler22b.worldgen.features;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraftforge.fml.common.FMLLog;

import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.village.StructureComponentVillageField;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.village.StructureComponentVillageField2;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.village.StructureComponentVillageHouse;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.village.StructureComponentVillagePathGen;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.village.StructureComponentVillageRoadPiece;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.village.StructureComponentVillageStartPiece;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.village.StructureComponentVillageTorch;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.village.StructureComponentVillageWoodHut;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.village.StructureVillageStartKepler22b;

public class MapGenVillageKepler22b extends MapGenStructure
{
    public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenBaseKepler22b.kepler22bPlains });
    private final int terrainType;
    private static boolean initialized;

    static
    {
        try
        {
            MapGenVillageKepler22b.initiateStructures();
        }
        catch (Throwable e)
        {

        }
    }

    public static void initiateStructures() throws Throwable
    {
        if (!MapGenVillageKepler22b.initialized)
        {
            MapGenStructureIO.registerStructure(StructureVillageStartKepler22b.class, "Kepler22bVillage");
            MapGenStructureIO.registerStructureComponent(StructureComponentVillageField.class, "Kepler22bField1");
            MapGenStructureIO.registerStructureComponent(StructureComponentVillageField2.class, "Kepler22bField2");
            MapGenStructureIO.registerStructureComponent(StructureComponentVillageHouse.class, "Kepler22bHouse");
            MapGenStructureIO.registerStructureComponent(StructureComponentVillageRoadPiece.class, "Kepler22bRoadPiece");
            MapGenStructureIO.registerStructureComponent(StructureComponentVillagePathGen.class, "Kepler22bPath");
            MapGenStructureIO.registerStructureComponent(StructureComponentVillageTorch.class, "Kepler22bTorch");
            MapGenStructureIO.registerStructureComponent(StructureComponentVillageStartPiece.class, "Kepler22bWell");
            MapGenStructureIO.registerStructureComponent(StructureComponentVillageWoodHut.class, "Kepler22bWoodHut");
        }

        MapGenVillageKepler22b.initialized = true;
    }

    public MapGenVillageKepler22b()
    {
        this.terrainType = 0;
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int i, int j)
    {
        final byte numChunks = 32;
        final byte offsetChunks = 8;
        final int oldi = i;
        final int oldj = j;

        if (i < 0)
        {
            i -= numChunks - 1;
        }

        if (j < 0)
        {
            j -= numChunks - 1;
        }

        int randX = i / numChunks;
        int randZ = j / numChunks;
        final Random var7 = this.worldObj.setRandomSeed(i, j, 10387312);
        randX *= numChunks;
        randZ *= numChunks;
        randX += var7.nextInt(numChunks - offsetChunks);
        randZ += var7.nextInt(numChunks - offsetChunks);

        return oldi == randX && oldj == randZ;

    }

    @Override
    protected StructureStart getStructureStart(int par1, int par2)
    {
        FMLLog.info("Generating Kepler22b Village at x" + par1 * 16 + " z" + par2 * 16);
        return new StructureVillageStartKepler22b(this.worldObj, this.rand, par1, par2, this.terrainType);
    }

    @Override
    public String getStructureName()
    {
        return "Kepler22bVillage";
    }
}
