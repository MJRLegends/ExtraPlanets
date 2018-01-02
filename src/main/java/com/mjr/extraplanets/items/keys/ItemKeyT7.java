package com.mjr.extraplanets.items.keys;

import micdoodle8.mods.galacticraft.api.item.IKeyItem;
import micdoodle8.mods.galacticraft.core.items.ISortableItem;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;

public class ItemKeyT7 extends Item implements IKeyItem, ISortableItem {
	public ItemKeyT7(String assetName) {
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(assetName);
		// this.setTextureName("arrow");
	}

	@Override
	public CreativeTabs getCreativeTab() {
		return ExtraPlanets.ItemsTab;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return this.getUnlocalizedName();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return ClientProxyCore.galacticraftItem;
	}

	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, NonNullList<ItemStack> par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}

	@Override
	public int getTier(ItemStack keyStack) {
		return 7;
	}

	@Override
	public EnumSortCategoryItem getCategory(int meta) {
		return EnumSortCategoryItem.GENERAL;
	}
}
