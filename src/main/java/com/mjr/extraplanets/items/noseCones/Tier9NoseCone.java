package com.mjr.extraplanets.items.noseCones;

import net.minecraft.item.Item;

import com.mjr.extraplanets.ExtraPlanets;

public class Tier9NoseCone extends Item {
	public Tier9NoseCone(String assetName) {
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(assetName);
		this.setCreativeTab(ExtraPlanets.ItemsTab);
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}
}