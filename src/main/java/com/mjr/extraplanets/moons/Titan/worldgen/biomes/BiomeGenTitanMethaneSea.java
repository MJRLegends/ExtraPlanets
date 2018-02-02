package com.mjr.extraplanets.moons.Titan.worldgen.biomes;

import java.util.List;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.moons.Titan.worldgen.TitanBiomes;

public class BiomeGenTitanMethaneSea extends TitanBiomes {
	public BiomeGenTitanMethaneSea(BiomeProperties properties) {
		super(properties);
		this.topBlock = ExtraPlanets_Fluids.METHANE.getDefaultState();
		this.fillerBlock = ExtraPlanets_Fluids.METHANE.getDefaultState();
	}

	@Override
	public List<Biome.SpawnListEntry> getSpawnableList(EnumCreatureType creatureType) {
		return Lists.<Biome.SpawnListEntry> newArrayList();
	}

	@Override	
	public void registerTypes() {
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.WET, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.OCEAN);
	}
}