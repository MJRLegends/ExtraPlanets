package com.mjr.extraplanets.moons.Europa.worldgen.biomes;

import java.util.List;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.moons.Europa.worldgen.EuropaBiomes;

public class BiomeGenEuropaSaltSea extends EuropaBiomes {
	public BiomeGenEuropaSaltSea(int var1) {
		super(var1);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OCEAN);
		this.spawnableCreatureList.clear();
		this.topBlock = ExtraPlanets_Fluids.SALT.getDefaultState();
		this.fillerBlock = ExtraPlanets_Fluids.SALT.getDefaultState();
	}

	@Override
	public List<BiomeGenBase.SpawnListEntry> getSpawnableList(EnumCreatureType creatureType) {
		return Lists.<BiomeGenBase.SpawnListEntry> newArrayList();
	}
}