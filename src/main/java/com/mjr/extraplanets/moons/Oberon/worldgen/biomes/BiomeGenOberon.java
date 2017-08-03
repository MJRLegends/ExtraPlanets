package com.mjr.extraplanets.moons.Oberon.worldgen.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Oberon.worldgen.OberonBiomes;

public class BiomeGenOberon extends OberonBiomes {

	public BiomeGenOberon(BiomeProperties properties) {
		super(properties);
		Biome.registerBiome(Config.OBERON_BIOME_ID, Constants.TEXTURE_PREFIX + this.getBiomeName(), this);
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);	
		this.topBlock = ExtraPlanets_Blocks.OBERON_BLOCKS.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.OBERON_BLOCKS.getStateFromMeta(1);
	}
}
