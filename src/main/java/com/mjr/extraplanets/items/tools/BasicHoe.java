package com.mjr.extraplanets.items.tools;

import net.minecraft.item.ItemHoe;

import com.mjr.extraplanets.ExtraPlanets;

public class BasicHoe extends ItemHoe{
	protected BasicHoe(ToolMaterial p_i45347_1_, String name) {
		super(p_i45347_1_);
		this.setCreativeTab(ExtraPlanets.ToolsTab);
		this.setUnlocalizedName(name);
	}
}
