package com.mjr.extraplanets.items.noseCones;

import com.mjr.extraplanets.ExtraPlanets;

import net.minecraft.item.Item;

public class Tier10NoseCone extends Item {
	public Tier10NoseCone(String name) {
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(name);
		this.setCreativeTab(ExtraPlanets.ItemsTab);
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}
}