package com.mjr.extraplanets.moons.Io.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Io.worldgen.IoBiomes;

public class BiomeGenIOBurningPlains extends IoBiomes {

	public BiomeGenIOBurningPlains(BiomeProperties properties) {
		super(properties);
		this.topBlock = ExtraPlanets_Blocks.VOLCANIC_ROCK.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.ASH_ROCK.getDefaultState();
	}

	@Override
	public void registerTypes() {
		BiomeDictionary.addTypes(this, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.SPOOKY);
	}
}
