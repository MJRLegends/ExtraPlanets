package com.mjr.extraplanets.items;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.items.armor.ExtraPlanets_Armor;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

import micdoodle8.mods.galacticraft.core.items.ISortableItem;
import micdoodle8.mods.galacticraft.core.items.ItemDesc;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryItem;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemHandlerHelper;

public class ItemEnviroEmergencyKit extends ItemDesc implements ISortableItem {
	private static final int SIZE = 4;

	public ItemEnviroEmergencyKit(String assetName) {
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(false);
		this.setMaxStackSize(1);
		this.setUnlocalizedName(assetName);
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
	public EnumSortCategoryItem getCategory(int meta) {
		return EnumSortCategoryItem.GEAR;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (player instanceof EntityPlayerMP) {
			for (int i = 0; i < SIZE; i++) {
				ItemStack newGear = getContents(i);
				if (newGear.getItem() instanceof ItemArmor) {
					ItemArmor armor = ((ItemArmor) newGear.getItem());
					if (armor.armorType == 0) {
						if (player.inventory.armorItemInSlot(3) == null) {
							player.inventory.armorInventory[3] = newGear;
							continue;
						}
					} else if (armor.armorType == 1) {
						if (player.inventory.armorItemInSlot(2) == null) {
							player.inventory.armorInventory[2] = newGear;
							continue;
						}
					} else if (armor.armorType == 2) {
						if (player.inventory.armorItemInSlot(1) == null) {
							player.inventory.armorInventory[1] = newGear;
							continue;
						}
					} else if (armor.armorType == 3) {
						if (player.inventory.armorItemInSlot(0) == null) {
							player.inventory.armorInventory[0] = newGear;
							continue;
						}
					}
				}
				ItemHandlerHelper.giveItemToPlayer(player, newGear, 0);
			}

			itemStack = null;
		}
		return itemStack;

	}

	public static ItemStack getContents(int slot) {
		switch (slot) {
		case 0:
			return new ItemStack(ExtraPlanets_Armor.TIER_0_SPACE_SUIT_HELMET);
		case 1:
			return new ItemStack(ExtraPlanets_Armor.TIER_0_SPACE_SUIT_CHEST);
		case 2:
			return new ItemStack(ExtraPlanets_Armor.TIER_0_SPACE_SUIT_LEGINGS);
		case 3:
			return new ItemStack(ExtraPlanets_Armor.TIER_0_SPACE_SUIT_BOOTS);
		default:
			return null;
		}
	}

	@Override
	public String getShiftDescription(int meta) {
		return TranslateUtilities.translate("item.enviro_emergency_kit.description");
	}

	@Override
	public boolean showDescription(int meta) {
		return true;
	}
}