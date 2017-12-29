package com.mjr.extraplanets.planets.Neptune.worldgen;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.planets.Neptune.worldgen.biomes.BiomeGenNeptune;
import com.mjr.extraplanets.planets.Neptune.worldgen.village.StructureComponentVillageField;
import com.mjr.extraplanets.planets.Neptune.worldgen.village.StructureComponentVillageField2;
import com.mjr.extraplanets.planets.Neptune.worldgen.village.StructureComponentVillageHouse;
import com.mjr.extraplanets.planets.Neptune.worldgen.village.StructureComponentVillagePathGen;
import com.mjr.extraplanets.planets.Neptune.worldgen.village.StructureComponentVillageRoadPiece;
import com.mjr.extraplanets.planets.Neptune.worldgen.village.StructureComponentVillageStartPiece;
import com.mjr.extraplanets.planets.Neptune.worldgen.village.StructureComponentVillageTorch;
import com.mjr.extraplanets.planets.Neptune.worldgen.village.StructureComponentVillageWoodHut;
import com.mjr.extraplanets.planets.Neptune.worldgen.village.StructureVillageStartNeptune;
import com.mjr.mjrlegendslib.util.MessageUtilities;

public class MapGenVillageNeptune extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenNeptune.neptune });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageNeptune.initiateStructures();
		} catch (Throwable e) {

		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageNeptune.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartNeptune.class, "NeptuneVillage");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageField.class, "NeptuneField1");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageField2.class, "NeptuneField2");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageHouse.class, "NeptuneHouse");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageRoadPiece.class, "NeptuneRoadPiece");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillagePathGen.class, "NeptunePath");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageTorch.class, "NeptuneTorch");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageStartPiece.class, "NeptuneWell");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageWoodHut.class, "NeptuneWoodHut");
		}

		MapGenVillageNeptune.initialized = true;
	}

	public MapGenVillageNeptune() {
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
			MessageUtilities.debugMessageToLog(Constants.modID, "Generating Neptune Village at x" + par1 * 16 + " z" + par2 * 16);
		return new StructureVillageStartNeptune(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String getStructureName() {
		return "NeptuneVillage";
	}
}
