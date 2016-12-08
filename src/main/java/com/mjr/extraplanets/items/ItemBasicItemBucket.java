package com.mjr.extraplanets.items;

import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;

public class ItemBasicItemBucket extends ItemBucket {
	public ItemBasicItemBucket(String name, Block block) {
		super(block);
		setMaxStackSize(1);
		setUnlocalizedName(name);
		setContainerItem(Items.bucket);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity func_77613_e(ItemStack itemStack) {
		return ClientProxyCore.galacticraftItem;
	}

	public CreativeTabs func_77640_w() {
		return ExtraPlanets.ItemsTab;
	}
}
