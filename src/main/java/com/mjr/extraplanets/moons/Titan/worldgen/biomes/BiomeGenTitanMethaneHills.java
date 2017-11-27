package com.mjr.extraplanets.moons.Titan.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Titan.worldgen.TitanBiomes;

public class BiomeGenTitanMethaneHills extends TitanBiomes {
	public BiomeGenTitanMethaneHills(int var1) {
		super(var1);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
		this.topBlock = ExtraPlanets_Blocks.titanBlocks;
		this.topMeta = 6;
		this.fillerBlock = ExtraPlanets_Blocks.titanBlocks;
		this.fillerMeta = 7;
		this.stoneBlock = ExtraPlanets_Blocks.titanBlocks;
		this.stoneMeta = 2;
	}
}
