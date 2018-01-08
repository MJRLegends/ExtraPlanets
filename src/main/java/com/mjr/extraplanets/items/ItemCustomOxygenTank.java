package com.mjr.extraplanets.items;

import java.util.List;

import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStats;
import micdoodle8.mods.galacticraft.core.items.ItemOxygenTank;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class ItemCustomOxygenTank extends ItemOxygenTank {
	public ItemCustomOxygenTank(int tier, String assetName) {
		super(tier, assetName);
		this.setMaxStackSize(1);
		this.setMaxDamage(tier * 900);
		this.setUnlocalizedName(assetName);
		this.setNoRepair();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, this.getMaxDamage()));
	}

	@Override
	public CreativeTabs getCreativeTab() {
		return ExtraPlanets.ItemsTab;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return ClientProxyCore.galacticraftItem;
	}

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer player, List<String> tooltip, boolean b) {
		tooltip.add(TranslateUtilities.translate("gui.tank.oxygen_remaining") + ": " + (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()));
	}

	@Override
	public EnumSortCategoryItem getCategory(int meta) {
		return EnumSortCategoryItem.GEAR;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World worldIn, EntityPlayer player) {
		if (player instanceof EntityPlayerMP) {
			GCPlayerStats stats = GCPlayerStats.get(player);
			ItemStack gear = stats.getExtendedInventory().getStackInSlot(2);
			ItemStack gear1 = stats.getExtendedInventory().getStackInSlot(3);

			if (gear == null) {
				stats.getExtendedInventory().setInventorySlotContents(2, itemStack.copy());
				itemStack.stackSize = 0;
			} else if (gear1 == null) {
				stats.getExtendedInventory().setInventorySlotContents(3, itemStack.copy());
				itemStack.stackSize = 0;
			}
		}
		return itemStack;
	}
}