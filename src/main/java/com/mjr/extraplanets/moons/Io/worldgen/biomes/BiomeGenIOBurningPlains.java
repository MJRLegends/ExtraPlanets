package com.mjr.extraplanets.moons.Io.worldgen.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Io.worldgen.IoBiomes;

public class BiomeGenIOBurningPlains extends IoBiomes {

	public BiomeGenIOBurningPlains(BiomeProperties properties) {
		super(properties);
		Biome.registerBiome(Config.IO_BURNING_PLAINS_BIOME_ID, Constants.TEXTURE_PREFIX + this.getBiomeName(), this);
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.SPOOKY);
		this.topBlock = ExtraPlanets_Blocks.VOLCANIC_ROCK.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.ASH_ROCK.getDefaultState();
	}
}
