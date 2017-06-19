package com.mjr.extraplanets.moons.Titan.worldgen.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Titan.worldgen.TitanBiomes;

public class BiomeGenTitan extends TitanBiomes {
	public BiomeGenTitan(BiomeProperties properties) {
		super(properties);
		Biome.registerBiome(Config.TITAN_BIOME_ID, Constants.TEXTURE_PREFIX + this.getBiomeName(), this);
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
		this.topBlock = ExtraPlanets_Blocks.TITAN_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.TITAN_BLOCKS.getStateFromMeta(1);
	}
}
