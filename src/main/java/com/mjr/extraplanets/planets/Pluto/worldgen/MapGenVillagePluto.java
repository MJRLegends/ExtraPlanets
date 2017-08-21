package com.mjr.extraplanets.planets.Pluto.worldgen;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraftforge.fml.common.FMLLog;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.planets.Pluto.worldgen.village.StructureComponentVillageField;
import com.mjr.extraplanets.planets.Pluto.worldgen.village.StructureComponentVillageField2;
import com.mjr.extraplanets.planets.Pluto.worldgen.village.StructureComponentVillageHouse;
import com.mjr.extraplanets.planets.Pluto.worldgen.village.StructureComponentVillagePathGen;
import com.mjr.extraplanets.planets.Pluto.worldgen.village.StructureComponentVillageRoadPiece;
import com.mjr.extraplanets.planets.Pluto.worldgen.village.StructureComponentVillageStartPiece;
import com.mjr.extraplanets.planets.Pluto.worldgen.village.StructureComponentVillageTorch;
import com.mjr.extraplanets.planets.Pluto.worldgen.village.StructureComponentVillageWoodHut;
import com.mjr.extraplanets.planets.Pluto.worldgen.village.StructureVillageStartPluto;

public class MapGenVillagePluto extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenPluto.pluto });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillagePluto.initiateStructures();
		} catch (Throwable e) {

		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillagePluto.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartPluto.class, "PlutoVillage");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageField.class, "PlutoField1");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageField2.class, "PlutoField2");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageHouse.class, "PlutoHouse");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageRoadPiece.class, "PlutoRoadPiece");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillagePathGen.class, "PlutoPath");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageTorch.class, "PlutoTorch");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageStartPiece.class, "PlutoWell");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageWoodHut.class, "PlutoWoodHut");
		}

		MapGenVillagePluto.initialized = true;
	}

	public MapGenVillagePluto() {
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
			FMLLog.info("Generating Pluto Village at x" + par1 * 16 + " z" + par2 * 16);
		return new StructureVillageStartPluto(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String getStructureName() {
		return "PlutoVillage";
	}
}
