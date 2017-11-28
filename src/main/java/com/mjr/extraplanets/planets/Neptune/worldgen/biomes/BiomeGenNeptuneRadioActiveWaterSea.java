package com.mjr.extraplanets.planets.Neptune.worldgen.biomes;

import java.util.Collections;
import java.util.List;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Neptune.worldgen.NeptuneBiomes;

public class BiomeGenNeptuneRadioActiveWaterSea extends NeptuneBiomes {

	public BiomeGenNeptuneRadioActiveWaterSea(int var1) {
		super(var1);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OCEAN);
		this.topBlock = ExtraPlanets_Blocks.NEPTUNE_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.NEPTUNE_BLOCKS.getStateFromMeta(1);
	}

	@Override
	public List<BiomeGenBase.SpawnListEntry> getSpawnableList(EnumCreatureType creatureType) {
		return Collections.<BiomeGenBase.SpawnListEntry> emptyList();
	}
}
