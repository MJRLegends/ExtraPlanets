package com.mjr.extraplanets.items.tools;

import net.minecraft.item.ItemSword;

import com.mjr.extraplanets.ExtraPlanets;

public class BasicSword extends ItemSword {
	protected BasicSword(ToolMaterial p_i45347_1_, String name) {
		super(p_i45347_1_);
		this.setCreativeTab(ExtraPlanets.ToolsTab);
		this.setUnlocalizedName(name);
	}
}
