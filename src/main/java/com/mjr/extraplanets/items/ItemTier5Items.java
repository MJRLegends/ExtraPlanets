package com.mjr.extraplanets.items;

import java.util.List;

import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTier5Items extends Item {
    public static final String[] names = { "tier5engine", "tier5booster", "tier5Fin", "tier5HeavyDutyPlate", "compressedPalladium", "ingotPalladium" };

    protected IIcon[] icons = new IIcon[ItemTier5Items.names.length];

    public ItemTier5Items(String assetName) {
	super();
	this.setMaxDamage(0);
	this.setHasSubtypes(true);
	this.setUnlocalizedName(assetName);
	this.setTextureName(Constants.TEXTURE_PREFIX + assetName);
	this.setCreativeTab(ExtraPlanets.ItemsTab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack) {
	return ClientProxyCore.galacticraftItem;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
	int i = 0;

	for (final String name : ItemTier5Items.names) {
	    this.icons[i++] = iconRegister.registerIcon(this.getIconString() + "." + name);
	}
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
	return this.getUnlocalizedName() + "." + ItemTier5Items.names[itemStack.getItemDamage()];
    }

    @Override
    public IIcon getIconFromDamage(int damage) {
	if (this.icons.length > damage) {
	    return this.icons[damage];
	}

	return super.getIconFromDamage(damage);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
	for (int i = 0; i < ItemTier5Items.names.length; i++) {
	    par3List.add(new ItemStack(par1, 1, i));
	}
    }

    @Override
    public int getMetadata(int par1) {
	return par1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
	if (itemStack != null && itemStack.getItemDamage() == 3) {
	    if (player.worldObj.isRemote) {
		list.add(EnumChatFormatting.GRAY + GCCoreUtil.translate("tier5.heavyDutyPlate.name"));
	    }
	}
    }

}
