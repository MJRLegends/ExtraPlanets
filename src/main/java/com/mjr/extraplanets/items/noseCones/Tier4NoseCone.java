package com.mjr.extraplanets.items.noseCones;

import net.minecraft.item.Item;

import com.mjr.extraplanets.ExtraPlanets;

public class Tier4NoseCone extends Item {
	public Tier4NoseCone(String name) {
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