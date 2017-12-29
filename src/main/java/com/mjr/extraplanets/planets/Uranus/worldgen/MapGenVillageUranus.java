package com.mjr.extraplanets.planets.Uranus.worldgen;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.planets.Uranus.worldgen.biomes.BiomeGenUranus;
import com.mjr.extraplanets.planets.Uranus.worldgen.village.StructureComponentVillageField;
import com.mjr.extraplanets.planets.Uranus.worldgen.village.StructureComponentVillageField2;
import com.mjr.extraplanets.planets.Uranus.worldgen.village.StructureComponentVillageHouse;
import com.mjr.extraplanets.planets.Uranus.worldgen.village.StructureComponentVillagePathGen;
import com.mjr.extraplanets.planets.Uranus.worldgen.village.StructureComponentVillageRoadPiece;
import com.mjr.extraplanets.planets.Uranus.worldgen.village.StructureComponentVillageStartPiece;
import com.mjr.extraplanets.planets.Uranus.worldgen.village.StructureComponentVillageTorch;
import com.mjr.extraplanets.planets.Uranus.worldgen.village.StructureComponentVillageWoodHut;
import com.mjr.extraplanets.planets.Uranus.worldgen.village.StructureVillageStartUranus;
import com.mjr.mjrlegendslib.util.MessageUtilities;

public class MapGenVillageUranus extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenUranus.uranus });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageUranus.initiateStructures();
		} catch (Throwable e) {

		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageUranus.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartUranus.class, "UranusVillage");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageField.class, "UranusField1");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageField2.class, "UranusField2");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageHouse.class, "UranusHouse");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageRoadPiece.class, "UranusRoadPiece");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillagePathGen.class, "UranusPath");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageTorch.class, "UranusTorch");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageStartPiece.class, "UranusWell");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageWoodHut.class, "UranusWoodHut");
		}

		MapGenVillageUranus.initialized = true;
	}

	public MapGenVillageUranus() {
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
			MessageUtilities.debugMessageToLog(Constants.modID, "Generating Uranus Village at x" + par1 * 16 + " z" + par2 * 16);
		return new StructureVillageStartUranus(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String getStructureName() {
		return "UranusVillage";
	}
}
