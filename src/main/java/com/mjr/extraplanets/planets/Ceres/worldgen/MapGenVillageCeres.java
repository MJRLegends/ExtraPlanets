package com.mjr.extraplanets.planets.Ceres.worldgen;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.planets.Ceres.worldgen.village.StructureComponentVillageField;
import com.mjr.extraplanets.planets.Ceres.worldgen.village.StructureComponentVillageField2;
import com.mjr.extraplanets.planets.Ceres.worldgen.village.StructureComponentVillageHouse;
import com.mjr.extraplanets.planets.Ceres.worldgen.village.StructureComponentVillagePathGen;
import com.mjr.extraplanets.planets.Ceres.worldgen.village.StructureComponentVillageRoadPiece;
import com.mjr.extraplanets.planets.Ceres.worldgen.village.StructureComponentVillageStartPiece;
import com.mjr.extraplanets.planets.Ceres.worldgen.village.StructureComponentVillageTorch;
import com.mjr.extraplanets.planets.Ceres.worldgen.village.StructureComponentVillageWoodHut;
import com.mjr.extraplanets.planets.Ceres.worldgen.village.StructureVillageStartCeres;
import com.mjr.extraplanets.util.MessageUtilities;

public class MapGenVillageCeres extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenCeres.ceres });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageCeres.initiateStructures();
		} catch (Throwable e) {

		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageCeres.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartCeres.class, "CeresVillage");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageField.class, "CeresField1");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageField2.class, "CeresField2");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageHouse.class, "CeresHouse");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageRoadPiece.class, "CeresRoadPiece");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillagePathGen.class, "CeresPath");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageTorch.class, "CeresTorch");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageStartPiece.class, "CeresWell");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageWoodHut.class, "CeresWoodHut");
		}

		MapGenVillageCeres.initialized = true;
	}

	public MapGenVillageCeres() {
		this.terrainType = 0;
	}

	@Override
	protected boolean canSpawnStructureAtCoords(int i, int j) {
		final byte numChunks = 32;
		final byte offsetChunks = 8;
		final int oldi = i;
		final int oldj = j;

		if (i < 0) {
			i -= numChunks - 1;
		}

		if (j < 0) {
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
	protected StructureStart getStructureStart(int par1, int par2) {
		if (Config.DEBUG_MODE)
			MessageUtilities.debugMessageToLog("Generating Ceres Village at x" + par1 * 16 + " z" + par2 * 16);
		return new StructureVillageStartCeres(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String getStructureName() {
		return "CeresVillage";
	}
}
