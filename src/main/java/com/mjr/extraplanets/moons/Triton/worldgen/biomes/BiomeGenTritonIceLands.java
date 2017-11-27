package com.mjr.extraplanets.moons.Triton.worldgen.biomes;

import net.minecraftforge.common.BiomeDictionary;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Triton.worldgen.TritonBiomes;

public class BiomeGenTritonIceLands extends TritonBiomes {
	public BiomeGenTritonIceLands(int var1) {
		super(var1);
		BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
		this.topBlock = ExtraPlanets_Blocks.frozenNitrogen;
		this.topMeta = 0;
		this.fillerBlock = ExtraPlanets_Blocks.tritonBlocks;
		this.fillerMeta = 1;
		this.stoneBlock = ExtraPlanets_Blocks.tritonBlocks;
		this.stoneMeta = 2;
	}
}
