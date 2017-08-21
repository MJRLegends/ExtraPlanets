package com.mjr.extraplanets.moons.Titan.worldgen.biomes;

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
}