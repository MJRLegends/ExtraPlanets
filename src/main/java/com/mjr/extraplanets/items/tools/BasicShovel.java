package com.mjr.extraplanets.items.tools;

import net.minecraft.item.ItemSpade;

import com.mjr.extraplanets.ExtraPlanets;

public class BasicShovel extends ItemSpade {
	protected BasicShovel(ToolMaterial p_i45347_1_, String name) {
		super(p_i45347_1_);
		this.setCreativeTab(ExtraPlanets.ToolsTab);
		this.setUnlocalizedName(name);
	}
}
