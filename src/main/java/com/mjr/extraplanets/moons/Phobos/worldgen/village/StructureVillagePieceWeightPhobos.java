package com.mjr.extraplanets.moons.Phobos.worldgen.village;

public class StructureVillagePieceWeightPhobos {
    public Class<? extends StructureComponentPhobosVillage> villagePieceClass;
    public final int villagePieceWeight;
    public int villagePiecesSpawned;
    public int villagePiecesLimit;

    public StructureVillagePieceWeightPhobos(Class<? extends StructureComponentPhobosVillage> par1Class, int par2, int par3) {
	this.villagePieceClass = par1Class;
	this.villagePieceWeight = par2;
	this.villagePiecesLimit = (int) (par3 / 1.5D);
    }

    public boolean canSpawnMoreVillagePiecesOfType(int par1) {
	return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
    }

    public boolean canSpawnMoreVillagePieces() {
	return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
    }
}
