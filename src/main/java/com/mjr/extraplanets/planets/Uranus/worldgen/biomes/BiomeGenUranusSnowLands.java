package com.mjr.extraplanets.planets.Uranus.worldgen.biomes;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Uranus.worldgen.UranusBiomes;

public class BiomeGenUranusSnowLands extends UranusBiomes {

	public BiomeGenUranusSnowLands(int var1) {
		super(var1);
		if (Config.REGISTER_BIOME_TYPES)
			BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.WET, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SNOWY);
		this.topBlock = Blocks.snow.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.URANUS_BLOCKS.getStateFromMeta(1);
	}
}
