package com.mjr.extraplanets.items;

import java.util.List;

import micdoodle8.mods.galacticraft.core.util.EnumColor;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;

public class ItemBasicItem extends Item {
	public ItemBasicItem(String assetName) {
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(assetName);
		this.setCreativeTab(ExtraPlanets.ItemsTab);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		if (player.worldObj.isRemote) {
			if(itemStack.getItem() == ExtraPlanets_Items.tier1ArmorLayer)
				list.add(EnumColor.YELLOW + GCCoreUtil.translate("tier1ArmorLayer.desc"));
			else if(itemStack.getItem() == ExtraPlanets_Items.tier2ArmorLayer)
				list.add(EnumColor.YELLOW + GCCoreUtil.translate("tier2ArmorLayer.desc"));
			else if(itemStack.getItem() == ExtraPlanets_Items.tier3ArmorLayer)
				list.add(EnumColor.YELLOW + GCCoreUtil.translate("tier3ArmorLayer.desc"));
			else if(itemStack.getItem() == ExtraPlanets_Items.tier4ArmorLayer)
				list.add(EnumColor.YELLOW + GCCoreUtil.translate("tier4ArmorLayer.desc"));
		}
	}
}
