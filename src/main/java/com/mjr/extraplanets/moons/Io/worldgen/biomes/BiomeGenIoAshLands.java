package com.mjr.extraplanets.moons.Io.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Io.worldgen.BiomeDecoratorIoOther;
import com.mjr.extraplanets.moons.Io.worldgen.IoBiomes;

public class BiomeGenIoAshLands extends IoBiomes {

	public BiomeGenIoAshLands(BiomeProperties properties) {
		super(properties);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
		this.topBlock = ExtraPlanets_Blocks.ASH_ROCK.getDefaultState();
		this.fillerBlock = ExtraPlanets_Blocks.IO_BLOCKS.getStateFromMeta(1);
	}
}
