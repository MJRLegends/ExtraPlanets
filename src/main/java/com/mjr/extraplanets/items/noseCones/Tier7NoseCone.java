package com.mjr.extraplanets.items.noseCones;

import com.mjr.extraplanets.ExtraPlanets;

import net.minecraft.item.Item;

public class Tier7NoseCone extends Item {
	public Tier7NoseCone(String name) {
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