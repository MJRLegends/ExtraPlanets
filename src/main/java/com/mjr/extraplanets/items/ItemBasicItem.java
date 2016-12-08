package com.mjr.extraplanets.items;

import net.minecraft.item.Item;

import com.mjr.extraplanets.ExtraPlanets;

public class ItemBasicItem extends Item {
	public ItemBasicItem(String assetName) {
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(assetName);
		this.setCreativeTab(ExtraPlanets.ItemsTab);
	}
}
