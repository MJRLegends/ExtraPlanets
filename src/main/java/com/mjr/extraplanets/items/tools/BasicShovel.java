package com.mjr.extraplanets.items.tools;

import net.minecraft.item.ItemSword;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

public class BasicShovel extends ItemSword{
    protected BasicShovel(ToolMaterial p_i45347_1_, String name) {
	super(p_i45347_1_);
	this.setCreativeTab(ExtraPlanets.ToolsTab);
	this.setUnlocalizedName(name);
	this.setTextureName(Constants.TEXTURE_PREFIX + name);
    }
}
