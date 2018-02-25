package com.mjr.extraplanets.items.planetAndMoonItems;

import java.util.List;

import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.util.EnumColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.mjrlegendslib.item.ItemBasicMeta;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class ItemTier4Items extends ItemBasicMeta {

	public ItemTier4Items(String assetName) {
		super(assetName, ExtraPlanets.ItemsTab, getItemList());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack itemStack) {
		return ClientProxyCore.galacticraftItem;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> list, boolean par4) {
		if (itemStack != null && itemStack.getItemDamage() == 3) {
			if (player.worldObj.isRemote) {
				list.add(EnumColor.GREY + TranslateUtilities.translate("tier4.heavy_duty_plate.name"));
			}
		}
	}

	public static String[] getItemList() {
		return new String[] { "tier4engine", "tier4booster", "tier4fin", "tier4heavy_duty_plate", "compressed_carbon", "ingot_carbon", "diamond_shard" };
	}
}
