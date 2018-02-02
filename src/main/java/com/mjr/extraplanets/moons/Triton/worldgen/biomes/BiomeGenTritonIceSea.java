package com.mjr.extraplanets.moons.Triton.worldgen.biomes;

import java.util.List;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.moons.Triton.worldgen.TritonBiomes;

public class BiomeGenTritonIceSea extends TritonBiomes {

	public BiomeGenTritonIceSea(BiomeProperties properties) {
		super(properties);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.WET, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.OCEAN);
		this.topBlock = ExtraPlanets_Fluids.NITROGEN_ICE.getDefaultState();
		this.fillerBlock = ExtraPlanets_Fluids.NITROGEN_ICE.getDefaultState();
	}

	@Override
	public List<Biome.SpawnListEntry> getSpawnableList(EnumCreatureType creatureType) {
		return Lists.<Biome.SpawnListEntry> newArrayList();
	}
}
