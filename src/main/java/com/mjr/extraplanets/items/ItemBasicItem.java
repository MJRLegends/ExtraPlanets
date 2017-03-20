package com.mjr.extraplanets.items;

import java.util.List;

import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.handlers.EPPlayerStats;

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
			if (itemStack.getItem() == ExtraPlanets_Items.tier1ArmorLayer)
				list.add(EnumChatFormatting.GOLD + GCCoreUtil.translate("tier1ArmorLayer.desc"));
			else if (itemStack.getItem() == ExtraPlanets_Items.tier2ArmorLayer)
				list.add(EnumChatFormatting.GOLD + GCCoreUtil.translate("tier2ArmorLayer.desc"));
			else if (itemStack.getItem() == ExtraPlanets_Items.tier3ArmorLayer)
				list.add(EnumChatFormatting.GOLD + GCCoreUtil.translate("tier3ArmorLayer.desc"));
			else if (itemStack.getItem() == ExtraPlanets_Items.tier4ArmorLayer)
				list.add(EnumChatFormatting.GOLD + GCCoreUtil.translate("tier4ArmorLayer.desc"));
			else if (itemStack.getItem() == ExtraPlanets_Items.anti_radiation)
				list.add(EnumChatFormatting.GOLD + GCCoreUtil.translate("antiRadiation.desc"));
		}
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		if (stack.getItem() == ExtraPlanets_Items.anti_radiation)
			return EnumAction.DRINK;
		return null;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		if (stack.getItem() == ExtraPlanets_Items.anti_radiation)
			return 32;
		return 0;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		if (itemStackIn.getItem() == ExtraPlanets_Items.anti_radiation)
			if (!playerIn.capabilities.isCreativeMode)
				playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
		return itemStackIn;
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		if (stack.getItem() == ExtraPlanets_Items.anti_radiation) {
			if (!playerIn.capabilities.isCreativeMode) {
				--stack.stackSize;
			}

			if (!worldIn.isRemote) {
				final EPPlayerStats EPPlayer = EPPlayerStats.get((EntityPlayerMP) playerIn);
				EPPlayer.radiationLevel = EPPlayer.radiationLevel / 2;
			}

			if (!playerIn.capabilities.isCreativeMode) {
				if (stack.stackSize <= 0) {
					return new ItemStack(Items.glass_bottle);
				}

				playerIn.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle));
			}
		}
		return stack;
	}

	@Override
	public int getItemStackLimit(ItemStack stack) {
		if (stack.getItem() == ExtraPlanets_Items.anti_radiation)
			return 1;
		return this.maxStackSize;
	}
}
