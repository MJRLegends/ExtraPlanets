package com.mjr.extraplanets.items;

import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;

public class ItemElectricParts extends Item {
	public static final String[] names = { "battery_tier1", "battery_tier2", "electric_wheels_tier1", "electric_wheels_tier2" };

	public ItemElectricParts(String assetName) {
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(assetName);
		this.setCreativeTab(ExtraPlanets.ItemsTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return ClientProxyCore.galacticraftItem;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return this.getUnlocalizedName() + "." + ItemElectricParts.names[itemStack.getItemDamage()];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, NonNullList<ItemStack> par3List) {
		for (int i = 0; i < ItemElectricParts.names.length; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}
}
