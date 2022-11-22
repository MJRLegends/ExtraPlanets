package com.mjr.extraplanets.items;

import java.util.List;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.util.EnumColor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemTools extends Item {
	public static final String[] names = { "sledge_hammer", "grinding_wheel", "mesh", "filter" };

	public ItemTools(String name) {
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(name);
		this.setCreativeTab(ExtraPlanets.ItemsTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack itemStack) {
		return ClientProxyCore.galacticraftItem;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return this.getUnlocalizedName() + "." + ItemTools.names[itemStack.getItemDamage()];
	}

	@Override
	public void getSubItems(CreativeTabs par2CreativeTabs, NonNullList<ItemStack> par3List) {
		if (!this.isInCreativeTab(par2CreativeTabs))
			return;
		for (int i = 0; i < ItemTools.names.length; i++) {
			par3List.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack itemstack) {
		if(itemstack.getUnlocalizedName().contains(names[0])) {
			if(!itemstack.hasTagCompound())
				itemstack.setTagCompound(new NBTTagCompound());
			int nbtDamage = itemstack.getTagCompound().getInteger("damage") + 1;
			if(nbtDamage < 100)
			{
				ItemStack copyItemStack = itemstack.copy();
				copyItemStack.getTagCompound().setInteger("damage", nbtDamage);
				return copyItemStack;
			} else
				return null;
		}
		return super.getContainerItem(itemstack);
	}

	@Override
	public boolean hasContainerItem(ItemStack stack) {
		if(stack.getUnlocalizedName().contains(names[0])) {
			return true;
		}
		return super.hasContainerItem(stack);
	}

	@Override
	public int getItemStackLimit(ItemStack stack) {
		if(stack.getUnlocalizedName().contains(names[0]))
			return 1;		
		return super.getItemStackLimit(stack);
	}

	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		if(stack.getUnlocalizedName().contains(names[0])) {
			if(stack.hasTagCompound() && stack.getTagCompound().getInteger("damage") > 0)
				return true;
		}
		return super.showDurabilityBar(stack);
	}
	

	@Override
	public double getDurabilityForDisplay(ItemStack stack) {
		if(stack.getUnlocalizedName().contains(names[0])) {
			if(stack.hasTagCompound())
				return stack.getTagCompound().getInteger("damage") / 100.0;
		}
		return super.getDurabilityForDisplay(stack);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		if(stack.getUnlocalizedName().contains(names[0])) {
			if(stack.hasTagCompound())
				tooltip.add(EnumColor.BRIGHT_GREEN + TranslateUtilities.translate("item.tool.usage.name") + ": " + (100 - stack.getTagCompound().getInteger("damage")) + " / 100");
		}
		super.addInformation(stack, playerIn, tooltip, advanced);
	}
	
	
}
