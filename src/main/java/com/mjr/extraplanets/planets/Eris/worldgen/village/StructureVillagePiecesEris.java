package com.mjr.extraplanets.planets.Eris.worldgen.village;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.util.MathHelper;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureVillagePiecesEris {
	public static ArrayList<StructureVillagePieceWeightEris> getStructureVillageWeightedPieceList(Random par0Random, int par1) {
		final ArrayList<StructureVillagePieceWeightEris> var2 = new ArrayList<StructureVillagePieceWeightEris>();
		var2.add(new StructureVillagePieceWeightEris(StructureComponentErisVillageWoodHut.class, 5, MathHelper.getRandomIntegerInRange(par0Random, 2 + par1, 5 + par1 * 3)));
		var2.add(new StructureVillagePieceWeightEris(StructureComponentErisVillageField.class, 5, MathHelper.getRandomIntegerInRange(par0Random, 3 + par1, 5 + par1)));
		var2.add(new StructureVillagePieceWeightEris(StructureComponentErisVillageHouse.class, 5, MathHelper.getRandomIntegerInRange(par0Random, 3 + par1, 4 + par1 * 2)));

		final Iterator<StructureVillagePieceWeightEris> var3 = var2.iterator();

		while (var3.hasNext()) {
			if (var3.next().villagePiecesLimit == 0) {
				var3.remove();
			}
		}

		return var2;
	}

	private static int func_75079_a(List<StructureVillagePieceWeightEris> par0List) {
		boolean var1 = false;
		int var2 = 0;
		StructureVillagePieceWeightEris var4;

		for (final Iterator<StructureVillagePieceWeightEris> var3 = par0List.iterator(); var3.hasNext(); var2 += var4.villagePieceWeight) {
			var4 = var3.next();

			if (var4.villagePiecesLimit > 0 && var4.villagePiecesSpawned < var4.villagePiecesLimit) {
				var1 = true;
			}
		}

		return var1 ? var2 : -1;
	}

	private static StructureComponentErisVillage func_75083_a(StructureComponentErisVillageStartPiece par0ComponentVillageStartPiece, StructureVillagePieceWeightEris par1StructureVillagePieceWeight, List<StructureComponent> par2List, Random par3Random, int par4, int par5, int par6, int par7, int par8) {
		final Class<?> var9 = par1StructureVillagePieceWeight.villagePieceClass;
		Object var10 = null;

		if (var9 == StructureComponentErisVillageWoodHut.class) {
			var10 = StructureComponentErisVillageWoodHut.func_74908_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
		} else if (var9 == StructureComponentErisVillageField.class) {
			var10 = StructureComponentErisVillageField.func_74900_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
		} else if (var9 == StructureComponentErisVillageHouse.class) {
			var10 = StructureComponentErisVillageHouse.func_74921_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
		}

		return (StructureComponentErisVillage) var10;
	}

	private static StructureComponentErisVillage getNextVillageComponent(StructureComponentErisVillageStartPiece par0ComponentVillageStartPiece, List<StructureComponent> par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
		final int var8 = StructureVillagePiecesEris.func_75079_a(par0ComponentVillageStartPiece.structureVillageWeightedPieceList);

		if (var8 <= 0) {
			return null;
		} else {
			int var9 = 0;

			while (var9 < 5) {
				++var9;
				int var10 = par2Random.nextInt(var8);
				final Iterator<StructureVillagePieceWeightEris> var11 = par0ComponentVillageStartPiece.structureVillageWeightedPieceList.iterator();

				while (var11.hasNext()) {
					final StructureVillagePieceWeightEris var12 = var11.next();
					var10 -= var12.villagePieceWeight;

					if (var10 < 0) {
						if (!var12.canSpawnMoreVillagePiecesOfType(par7) || var12 == par0ComponentVillageStartPiece.structVillagePieceWeight && par0ComponentVillageStartPiece.structureVillageWeightedPieceList.size() > 1) {
							break;
						}

						final StructureComponentErisVillage var13 = StructureVillagePiecesEris.func_75083_a(par0ComponentVillageStartPiece, var12, par1List, par2Random, par3, par4, par5, par6, par7);

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

			final StructureBoundingBox var14 = StructureComponentErisVillageTorch.func_74904_a(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6);

			if (var14 != null) {
				return new StructureComponentErisVillageTorch(par0ComponentVillageStartPiece, par7, par2Random, var14, par6);
			} else {
				return null;
			}
		}
	}

	/**
	 * attempts to find a next Structure Component to be spawned, private Village function
	 */
	private static StructureComponent getNextVillageStructureComponent(StructureComponentErisVillageStartPiece par0ComponentVillageStartPiece, List<StructureComponent> par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
		if (par7 > 50) {
			return null;
		} else if (Math.abs(par3 - par0ComponentVillageStartPiece.getBoundingBox().minX) <= 112 && Math.abs(par5 - par0ComponentVillageStartPiece.getBoundingBox().minZ) <= 112) {
			final StructureComponentErisVillage var8 = StructureVillagePiecesEris.getNextVillageComponent(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7 + 1);

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

	private static StructureComponent getNextComponentVillagePath(StructureComponentErisVillageStartPiece par0ComponentVillageStartPiece, List<StructureComponent> par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
		if (par7 > 3 + par0ComponentVillageStartPiece.terrainType) {
			return null;
		} else if (Math.abs(par3 - par0ComponentVillageStartPiece.getBoundingBox().minX) <= 112 && Math.abs(par5 - par0ComponentVillageStartPiece.getBoundingBox().minZ) <= 112) {
			final StructureBoundingBox var8 = StructureComponentErisVillagePathGen.func_74933_a(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6);

			if (var8 != null && var8.minY > 10) {
				final StructureComponentErisVillagePathGen var9 = new StructureComponentErisVillagePathGen(par0ComponentVillageStartPiece, par7, par2Random, var8, par6);

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
	static StructureComponent getNextStructureComponent(StructureComponentErisVillageStartPiece par0ComponentVillageStartPiece, List<StructureComponent> par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
		return StructureVillagePiecesEris.getNextVillageStructureComponent(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7);
	}

	static StructureComponent getNextStructureComponentVillagePath(StructureComponentErisVillageStartPiece par0ComponentVillageStartPiece, List<StructureComponent> par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
		return StructureVillagePiecesEris.getNextComponentVillagePath(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7);
	}
}
