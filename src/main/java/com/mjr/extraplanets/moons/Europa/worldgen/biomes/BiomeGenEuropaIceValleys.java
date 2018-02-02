package com.mjr.extraplanets.moons.Europa.worldgen.biomes;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Europa.worldgen.EuropaBiomes;

public class BiomeGenEuropaIceValleys extends EuropaBiomes {
	public BiomeGenEuropaIceValleys(BiomeProperties properties) {
		super(properties);
		this.topBlock = Blocks.ICE.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.DENSE_ICE.getDefaultState();
	}

	@Override
	public void registerTypes() {
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.addTypes(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.WET, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SNOWY);
	}
}
