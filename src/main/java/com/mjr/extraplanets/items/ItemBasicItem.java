package com.mjr.extraplanets.items;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

import net.minecraft.item.Item;

public class ItemBasicItem extends Item {
	public ItemBasicItem(String assetName) {
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(assetName);
		this.setTextureName(Constants.TEXTURE_PREFIX + assetName);
		this.setCreativeTab(ExtraPlanets.ItemsTab);
	}
}
