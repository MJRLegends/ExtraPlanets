package com.mjr.extraplanets.items.Tier7;

import java.util.List;

import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Tier7HeavyDutyPlate  extends Item
{
    public Tier7HeavyDutyPlate(String assetName)
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
    public void addInformation(ItemStack itemStack, EntityPlayer player,
	    List list, boolean par4) {
	if (player.worldObj.isRemote) {
	    list.add(EnumChatFormatting.GRAY
		    + GCCoreUtil.translate("tier7.heavyDutyPlate.name"));
	}
    }
}