package com.mjr.extraplanets.planets.Saturn.worldgen;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.planets.Saturn.worldgen.biomes.BiomeGenSaturn;
import com.mjr.extraplanets.planets.Saturn.worldgen.village.StructureComponentVillageField;
import com.mjr.extraplanets.planets.Saturn.worldgen.village.StructureComponentVillageField2;
import com.mjr.extraplanets.planets.Saturn.worldgen.village.StructureComponentVillageHouse;
import com.mjr.extraplanets.planets.Saturn.worldgen.village.StructureComponentVillagePathGen;
import com.mjr.extraplanets.planets.Saturn.worldgen.village.StructureComponentVillageRoadPiece;
import com.mjr.extraplanets.planets.Saturn.worldgen.village.StructureComponentVillageStartPiece;
import com.mjr.extraplanets.planets.Saturn.worldgen.village.StructureComponentVillageTorch;
import com.mjr.extraplanets.planets.Saturn.worldgen.village.StructureComponentVillageWoodHut;
import com.mjr.extraplanets.planets.Saturn.worldgen.village.StructureVillageStartSaturn;
import com.mjr.mjrlegendslib.util.MessageUtilities;

public class MapGenVillageSaturn extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenSaturn.saturn });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageSaturn.initiateStructures();
		} catch (Throwable e) {

		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageSaturn.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartSaturn.class, "SaturnVillage");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageField.class, "SaturnField1");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageField2.class, "SaturnField2");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageHouse.class, "SaturnHouse");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageRoadPiece.class, "SaturnRoadPiece");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillagePathGen.class, "SaturnPath");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageTorch.class, "SaturnTorch");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageStartPiece.class, "SaturnWell");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageWoodHut.class, "SaturnWoodHut");
		}

		MapGenVillageSaturn.initialized = true;
	}

	public MapGenVillageSaturn() {
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

		int randomX = i / numChunks;
		int randomZ = j / numChunks;
		final Random var7 = this.worldObj.setRandomSeed(i, j, 10387312);
		randomX *= numChunks;
		randomZ *= numChunks;
		randomX += var7.nextInt(numChunks - offsetChunks);
		randomZ += var7.nextInt(numChunks - offsetChunks);

		return oldi == randomX && oldj == randomZ;

	}

	@Override
	protected StructureStart getStructureStart(int par1, int par2) {
		if (Config.DEBUG_MODE)
			MessageUtilities.debugMessageToLog(Constants.modID, "Generating Saturn Village at x" + par1 * 16 + " z" + par2 * 16);
		return new StructureVillageStartSaturn(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String getStructureName() {
		return "SaturnVillage";
	}
}
