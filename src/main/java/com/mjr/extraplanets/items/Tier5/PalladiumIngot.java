package com.mjr.extraplanets.items.Tier5;

import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PalladiumIngot extends Item
{
    public PalladiumIngot(String assetName)
    {
	super();
	this.setMaxDamage(0);
	this.setHasSubtypes(true);
	this.setUnlocalizedName(assetName);
	this.setTextureName(Constants.TEXTURE_PREFIX + assetName);
	this.setCreativeTab(ExtraPlanets.ItemsTab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
	return ClientProxyCore.galacticraftItem;
    }
}