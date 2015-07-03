package com.mjr.extraplanets.tools;

import net.minecraft.item.ItemSpade;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

public class BasicSword extends ItemSpade{
    protected BasicSword(ToolMaterial p_i45347_1_, String name) {
	super(p_i45347_1_);
	this.setCreativeTab(ExtraPlanets.ToolsTab);
	this.setUnlocalizedName(name);
	this.setTextureName(Constants.TEXTURE_PREFIX + name);
    }
}
