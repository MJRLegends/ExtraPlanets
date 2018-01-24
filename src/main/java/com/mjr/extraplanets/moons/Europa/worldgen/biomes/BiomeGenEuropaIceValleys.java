package com.mjr.extraplanets.moons.Europa.worldgen.biomes;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Europa.worldgen.EuropaBiomes;

public class BiomeGenEuropaIceValleys extends EuropaBiomes {
	public BiomeGenEuropaIceValleys(int var1) {
		super(var1);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.WET, BiomeDictionary.Type.DEAD);
		this.topBlock = Blocks.ice.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.DENSE_ICE.getDefaultState();
	}
}
