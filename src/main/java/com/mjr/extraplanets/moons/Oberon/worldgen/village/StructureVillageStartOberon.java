package com.mjr.extraplanets.moons.Oberon.worldgen.village;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;

public class StructureVillageStartOberon extends StructureStart {
	public StructureVillageStartOberon() {
	}

	@SuppressWarnings("unchecked")
	public StructureVillageStartOberon(World par1World, Random par2Random, int par3, int par4, int par5) {
		super(par3, par4);

		final ArrayList<StructureVillagePieceWeightOberon> var6 = StructureVillagePiecesOberon.getStructureVillageWeightedPieceList(par2Random, par5);
		final StructureComponentOberonVillageStartPiece var7 = new StructureComponentOberonVillageStartPiece(par1World.getWorldChunkManager(), 0, par2Random, (par3 << 4) + 2, (par4 << 4) + 2, var6, par5);
		this.components.add(var7);
		var7.buildComponent(var7, this.components, par2Random);
		final ArrayList<Object> var8 = var7.field_74930_j;
		final ArrayList<Object> var9 = var7.field_74932_i;
		int var10;

		while (!var8.isEmpty() || !var9.isEmpty()) {
			StructureComponent var11;

			if (var8.isEmpty()) {
				var10 = par2Random.nextInt(var9.size());
				var11 = (StructureComponent) var9.remove(var10);
				var11.buildComponent(var7, this.components, par2Random);
			} else {
				var10 = par2Random.nextInt(var8.size());
				var11 = (StructureComponent) var8.remove(var10);
				var11.buildComponent(var7, this.components, par2Random);
			}
		}

		this.updateBoundingBox();
		var10 = 0;
		final Iterator<StructureComponent> var13 = this.components.iterator();

		while (var13.hasNext()) {
			final StructureComponent var12 = var13.next();

			if (!(var12 instanceof StructureComponentOberonVillageRoadPiece)) {
				++var10;
			}
		}
	}

	/**
	 * currently only defined for Villages, returns true if Village has more than 2 non-road components
	 */
	@Override
	public boolean isSizeableStructure() {
		return true;
	}
}
