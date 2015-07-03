package com.mjr.extraplanets.items.Tier6;

import java.util.List;

import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Tier6Engine extends Item
{
    public static final String[] names = { "tier6engine", // 0
    "tier6booster" }; // 1

    protected IIcon[] icons = new IIcon[Tier6Engine.names.length];

    public Tier6Engine(String assetName)
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

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
	int i = 0;

	for (final String name : Tier6Engine.names)
	{
	    this.icons[i++] = iconRegister.registerIcon(this.getIconString() + "." + name);
	}
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
	return this.getUnlocalizedName() + "." + Tier6Engine.names[itemStack.getItemDamage()];
    }

    @Override
    public IIcon getIconFromDamage(int damage)
    {
	if (this.icons.length > damage)
	{
	    return this.icons[damage];
	}

	return super.getIconFromDamage(damage);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
	for (int i = 0; i < Tier6Engine.names.length; i++)
	{
	    par3List.add(new ItemStack(par1, 1, i));
	}
    }

    @Override
    public int getMetadata(int par1)
    {
	return par1;
    }
}
