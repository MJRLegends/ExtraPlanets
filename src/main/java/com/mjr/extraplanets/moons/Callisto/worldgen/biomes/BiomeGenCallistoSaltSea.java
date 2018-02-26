package com.mjr.extraplanets.moons.Callisto.worldgen.biomes;

import java.util.List;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicCallisto;
import com.mjr.extraplanets.moons.Callisto.worldgen.CallistoBiomes;

public class BiomeGenCallistoSaltSea extends CallistoBiomes {
	public BiomeGenCallistoSaltSea(int var1) {
		super(var1);
		this.spawnableCreatureList.clear();
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.WET, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.OCEAN);
		this.topBlock = ExtraPlanets_Blocks.CALLISTO_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.CALLISTO_BLOCKS.getDefaultState().withProperty(BlockBasicCallisto.BASIC_TYPE, BlockBasicCallisto.EnumBlockBasic.SUB_SURFACE);
	}

	@Override
	public List<BiomeGenBase.SpawnListEntry> getSpawnableList(EnumCreatureType creatureType) {
		return Lists.<BiomeGenBase.SpawnListEntry> newArrayList();
	}
}