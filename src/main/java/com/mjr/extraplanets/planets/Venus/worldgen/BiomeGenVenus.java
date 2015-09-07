package com.mjr.extraplanets.planets.Venus.worldgen;

public class BiomeGenVenus extends VenusBiomes {

	public BiomeGenVenus(int par1)
	{
		super(par1);
		this.setBiomeName("venus");
		this.setColor(16711680);
		this.setHeight(new Height(2.5F, 0.4F));
	}

}
