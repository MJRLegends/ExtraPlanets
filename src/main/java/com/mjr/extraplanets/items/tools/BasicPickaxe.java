package com.mjr.extraplanets.items.tools;

import net.minecraft.item.ItemPickaxe;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

public class BasicPickaxe extends ItemPickaxe{
	protected BasicPickaxe(ToolMaterial p_i45347_1_, String name) {
		super(p_i45347_1_);
		this.setCreativeTab(ExtraPlanets.ToolsTab);
		this.setUnlocalizedName(name);
		this.setTextureName(Constants.TEXTURE_PREFIX + name);
	}
}
