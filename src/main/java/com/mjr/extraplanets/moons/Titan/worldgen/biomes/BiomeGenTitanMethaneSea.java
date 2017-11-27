package com.mjr.extraplanets.moons.Titan.worldgen.biomes;

import java.util.List;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;

public class BiomeGenTitanMethaneSea extends BiomeGenBase {
	public BiomeGenTitanMethaneSea(int par1) {
		super(par1);
		this.spawnableCreatureList.clear();
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OCEAN);
		this.topBlock = ExtraPlanets_Fluids.METHANE.getDefaultState();
		this.fillerBlock = ExtraPlanets_Fluids.METHANE.getDefaultState();
	}

	@Override
	public List<BiomeGenBase.SpawnListEntry> getSpawnableList(EnumCreatureType creatureType) {
		return null;
	}
}