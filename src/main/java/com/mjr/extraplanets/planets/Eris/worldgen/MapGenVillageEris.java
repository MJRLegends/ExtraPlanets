package com.mjr.extraplanets.planets.Eris.worldgen;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.planets.Eris.worldgen.village.StructureComponentVillageField;
import com.mjr.extraplanets.planets.Eris.worldgen.village.StructureComponentVillageField2;
import com.mjr.extraplanets.planets.Eris.worldgen.village.StructureComponentVillageHouse;
import com.mjr.extraplanets.planets.Eris.worldgen.village.StructureComponentVillagePathGen;
import com.mjr.extraplanets.planets.Eris.worldgen.village.StructureComponentVillageRoadPiece;
import com.mjr.extraplanets.planets.Eris.worldgen.village.StructureComponentVillageStartPiece;
import com.mjr.extraplanets.planets.Eris.worldgen.village.StructureComponentVillageTorch;
import com.mjr.extraplanets.planets.Eris.worldgen.village.StructureComponentVillageWoodHut;
import com.mjr.extraplanets.planets.Eris.worldgen.village.StructureVillageStartEris;

public class MapGenVillageEris extends MapGenStructure {
	public static List<Biome> villageSpawnBiomes = Arrays.asList(new Biome[] { BiomeGenEris.eris });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageEris.initiateStructures();
		} catch (Throwable e) {

		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageEris.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartEris.class, "ErisVillage");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageField.class, "ErisField1");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageField2.class, "ErisField2");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageHouse.class, "ErisHouse");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageRoadPiece.class, "ErisRoadPiece");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillagePathGen.class, "ErisPath");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageTorch.class, "ErisTorch");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageStartPiece.class, "ErisWell");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageWoodHut.class, "ErisWoodHut");
		}

		MapGenVillageEris.initialized = true;
	}

	public MapGenVillageEris() {
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
		final Random var7 = this.world.setRandomSeed(i, j, 10387312);
		randX *= numChunks;
		randZ *= numChunks;
		randX += var7.nextInt(numChunks - offsetChunks);
		randZ += var7.nextInt(numChunks - offsetChunks);

		return oldi == randX && oldj == randZ;

	}
	
    @Override
    public BlockPos getNearestStructurePos(World worldIn, BlockPos pos, boolean p_180706_3_)
    {
        this.world = worldIn;
        return findNearestStructurePosBySpacing(worldIn, this, pos, 32, 8, 10387312, false, 100, p_180706_3_);
    }
    
	@Override
	protected StructureStart getStructureStart(int par1, int par2) {
		if (Config.DEBUG_MODE)
			System.out.println("Generating Eris Village at x" + par1 * 16 + " z" + par2 * 16);
		return new StructureVillageStartEris(this.world, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String getStructureName() {
		return "ErisVillage";
	}
}
