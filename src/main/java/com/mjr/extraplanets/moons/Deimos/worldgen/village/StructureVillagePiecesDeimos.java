package com.mjr.extraplanets.moons.Deimos.worldgen.village;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.util.MathHelper;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureVillagePiecesDeimos {
    public static ArrayList<StructureVillagePieceWeightDeimos> getStructureVillageWeightedPieceList(Random par0Random, int par1) {
	final ArrayList<StructureVillagePieceWeightDeimos> var2 = new ArrayList<StructureVillagePieceWeightDeimos>();
	var2.add(new StructureVillagePieceWeightDeimos(StructureComponentDeimosVillageWoodHut.class, 5, MathHelper.getRandomIntegerInRange(par0Random, 2 + par1, 5 + par1 * 3)));
	var2.add(new StructureVillagePieceWeightDeimos(StructureComponentDeimosVillageField.class, 5, MathHelper.getRandomIntegerInRange(par0Random, 3 + par1, 5 + par1)));
	var2.add(new StructureVillagePieceWeightDeimos(StructureComponentDeimosVillageHouse.class, 5, MathHelper.getRandomIntegerInRange(par0Random, 3 + par1, 4 + par1 * 2)));

	final Iterator<StructureVillagePieceWeightDeimos> var3 = var2.iterator();

	while (var3.hasNext()) {
	    if (var3.next().villagePiecesLimit == 0) {
		var3.remove();
	    }
	}

	return var2;
    }

    private static int func_75079_a(List<StructureVillagePieceWeightDeimos> par0List) {
	boolean var1 = false;
	int var2 = 0;
	StructureVillagePieceWeightDeimos var4;

	for (final Iterator<StructureVillagePieceWeightDeimos> var3 = par0List.iterator(); var3.hasNext(); var2 += var4.villagePieceWeight) {
	    var4 = var3.next();

	    if (var4.villagePiecesLimit > 0 && var4.villagePiecesSpawned < var4.villagePiecesLimit) {
		var1 = true;
	    }
	}

	return var1 ? var2 : -1;
    }

    private static StructureComponentDeimosVillage func_75083_a(StructureComponentDeimosVillageStartPiece par0ComponentVillageStartPiece, StructureVillagePieceWeightDeimos par1StructureVillagePieceWeight, List<StructureComponent> par2List, Random par3Random, int par4, int par5, int par6, int par7, int par8) {
	final Class<?> var9 = par1StructureVillagePieceWeight.villagePieceClass;
	Object var10 = null;

	if (var9 == StructureComponentDeimosVillageWoodHut.class) {
	    var10 = StructureComponentDeimosVillageWoodHut.func_74908_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
	} else if (var9 == StructureComponentDeimosVillageField.class) {
	    var10 = StructureComponentDeimosVillageField.func_74900_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
	} else if (var9 == StructureComponentDeimosVillageHouse.class) {
	    var10 = StructureComponentDeimosVillageHouse.func_74921_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
	}

	return (StructureComponentDeimosVillage) var10;
    }

    private static StructureComponentDeimosVillage getNextVillageComponent(StructureComponentDeimosVillageStartPiece par0ComponentVillageStartPiece, List<StructureComponent> par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
	final int var8 = StructureVillagePiecesDeimos.func_75079_a(par0ComponentVillageStartPiece.structureVillageWeightedPieceList);

	if (var8 <= 0) {
	    return null;
	} else {
	    int var9 = 0;

	    while (var9 < 5) {
		++var9;
		int var10 = par2Random.nextInt(var8);
		final Iterator<StructureVillagePieceWeightDeimos> var11 = par0ComponentVillageStartPiece.structureVillageWeightedPieceList.iterator();

		while (var11.hasNext()) {
		    final StructureVillagePieceWeightDeimos var12 = var11.next();
		    var10 -= var12.villagePieceWeight;

		    if (var10 < 0) {
			if (!var12.canSpawnMoreVillagePiecesOfType(par7) || var12 == par0ComponentVillageStartPiece.structVillagePieceWeight && par0ComponentVillageStartPiece.structureVillageWeightedPieceList.size() > 1) {
			    break;
			}

			final StructureComponentDeimosVillage var13 = StructureVillagePiecesDeimos.func_75083_a(par0ComponentVillageStartPiece, var12, par1List, par2Random, par3, par4, par5, par6, par7);

			if (var13 != null) {
			    ++var12.villagePiecesSpawned;
			    par0ComponentVillageStartPiece.structVillagePieceWeight = var12;

			    if (!var12.canSpawnMoreVillagePieces()) {
				par0ComponentVillageStartPiece.structureVillageWeightedPieceList.remove(var12);
			    }

			    return var13;
			}
		    }
		}
	    }

	    final StructureBoundingBox var14 = StructureComponentDeimosVillageTorch.func_74904_a(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6);

	    if (var14 != null) {
		return new StructureComponentDeimosVillageTorch(par0ComponentVillageStartPiece, par7, par2Random, var14, par6);
	    } else {
		return null;
	    }
	}
    }

    /**
     * attempts to find a next Structure Component to be spawned, private Village function
     */
    private static StructureComponent getNextVillageStructureComponent(StructureComponentDeimosVillageStartPiece par0ComponentVillageStartPiece, List<StructureComponent> par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
	if (par7 > 50) {
	    return null;
	} else if (Math.abs(par3 - par0ComponentVillageStartPiece.getBoundingBox().minX) <= 112 && Math.abs(par5 - par0ComponentVillageStartPiece.getBoundingBox().minZ) <= 112) {
	    final StructureComponentDeimosVillage var8 = StructureVillagePiecesDeimos.getNextVillageComponent(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7 + 1);

	    if (var8 != null) {
		par1List.add(var8);
		par0ComponentVillageStartPiece.field_74932_i.add(var8);
		return var8;
	    }

	    return null;
	} else {
	    return null;
	}
    }

    private static StructureComponent getNextComponentVillagePath(StructureComponentDeimosVillageStartPiece par0ComponentVillageStartPiece, List<StructureComponent> par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
	if (par7 > 3 + par0ComponentVillageStartPiece.terrainType) {
	    return null;
	} else if (Math.abs(par3 - par0ComponentVillageStartPiece.getBoundingBox().minX) <= 112 && Math.abs(par5 - par0ComponentVillageStartPiece.getBoundingBox().minZ) <= 112) {
	    final StructureBoundingBox var8 = StructureComponentDeimosVillagePathGen.func_74933_a(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6);

	    if (var8 != null && var8.minY > 10) {
		final StructureComponentDeimosVillagePathGen var9 = new StructureComponentDeimosVillagePathGen(par0ComponentVillageStartPiece, par7, par2Random, var8, par6);

		par1List.add(var9);
		par0ComponentVillageStartPiece.field_74930_j.add(var9);
		return var9;
	    }

	    return null;
	} else {
	    return null;
	}
    }

    /**
     * attempts to find a next Structure Component to be spawned
     */
    static StructureComponent getNextStructureComponent(StructureComponentDeimosVillageStartPiece par0ComponentVillageStartPiece, List<StructureComponent> par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
	return StructureVillagePiecesDeimos.getNextVillageStructureComponent(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7);
    }

    static StructureComponent getNextStructureComponentVillagePath(StructureComponentDeimosVillageStartPiece par0ComponentVillageStartPiece, List<StructureComponent> par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
	return StructureVillagePiecesDeimos.getNextComponentVillagePath(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7);
    }
}
