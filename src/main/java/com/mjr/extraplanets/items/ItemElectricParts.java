package com.mjr.extraplanets.items;

import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.mjrlegendslib.item.ItemBasicMeta;

public class ItemElectricParts extends ItemBasicMeta {

	public ItemElectricParts(String assetName) {
		super(assetName, ExtraPlanets.ItemsTab, getItemList());
		this.setMaxStackSize(1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return ClientProxyCore.galacticraftItem;
	}

	public static String[] getItemList() {
		return new String[] { "battery_tier1", "battery_tier2", "electric_wheels_tier1", "electric_wheels_tier2" };
	}
}
