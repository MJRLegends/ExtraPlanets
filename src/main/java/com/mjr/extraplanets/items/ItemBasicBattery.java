package com.mjr.extraplanets.items;

import com.mjr.extraplanets.ExtraPlanets;

import micdoodle8.mods.galacticraft.api.item.IItemElectric;
import micdoodle8.mods.galacticraft.core.energy.item.ItemElectricBase;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBasicBattery extends ItemElectricBase implements IItemElectric {

	private float max;
	private int tier;

	public ItemBasicBattery(String name, Float max, int tier) {
		this.setUnlocalizedName(name);
		this.setCreativeTab(ExtraPlanets.ItemsTab);
		this.max = max;
		this.tier = tier;
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity func_77613_e(ItemStack itemStack) {
		return ClientProxyCore.galacticraftItem;
	}

	@Override
	public float getMaxElectricityStored(ItemStack itemStack) {
		return max;
	}

	@Override
	public int getTierGC(ItemStack itemStack) {
		return tier;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getItemStackLimit(ItemStack stack) {
		if (stack.getItemDamage() < 100 || stack.hasTagCompound() && stack.getTagCompound().hasKey("electricity")) {
			return 1;
		}
		return this.getItemStackLimit();
	}
}
