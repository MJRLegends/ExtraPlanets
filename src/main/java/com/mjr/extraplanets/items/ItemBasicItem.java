package com.mjr.extraplanets.items;

import java.util.List;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.handlers.capabilities.CapabilityStatsHandler;
import com.mjr.extraplanets.handlers.capabilities.IStatsCapability;
import com.mjr.mjrlegendslib.util.PlayerUtilties;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import micdoodle8.mods.galacticraft.core.util.EnumColor;

public class ItemBasicItem extends Item {
	public ItemBasicItem(String name) {
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(name);
		this.setCreativeTab(ExtraPlanets.ItemsTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> list, boolean par4) {
		if (player.worldObj.isRemote) {
			if (itemStack.getItem() == ExtraPlanets_Items.TIER_1_ARMOR_LAYER)
				list.add(EnumColor.YELLOW + TranslateUtilities.translate("tier1_armor_layer.desc"));
			else if (itemStack.getItem() == ExtraPlanets_Items.TIER_2_ARMOR_LAYER)
				list.add(EnumColor.YELLOW + TranslateUtilities.translate("tier2_armor_layer.desc"));
			else if (itemStack.getItem() == ExtraPlanets_Items.TIER_3_ARMOR_LAYER)
				list.add(EnumColor.YELLOW + TranslateUtilities.translate("tier3_armor_layer.desc"));
			else if (itemStack.getItem() == ExtraPlanets_Items.TIER_4_ARMOR_LAYER)
				list.add(EnumColor.YELLOW + TranslateUtilities.translate("tier4_armor_layer.desc"));
			else if (itemStack.getItem() == ExtraPlanets_Items.ANTI_RADIATION) {
				String text = TranslateUtilities.translate("anti_radiation.desc");
				if (text.contains("{PERCENT}"))
					text = text.replace("{PERCENT}", Config.RADIATION_ANTI_RAD_REDUCE_AMOUNT + "%");
				list.add(EnumColor.YELLOW + text);
			}
		}
	}

	@Override
	public EnumAction getItemUseAction(ItemStack itemStack) {
		if (itemStack.getItem() == ExtraPlanets_Items.ANTI_RADIATION)
			return EnumAction.DRINK;
		return null;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack itemStack) {
		if (itemStack.getItem() == ExtraPlanets_Items.ANTI_RADIATION)
			return 32;
		return 0;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World world, EntityPlayer player) {
		if (itemStackIn.getItem() == ExtraPlanets_Items.ANTI_RADIATION)
			if (!player.capabilities.isCreativeMode)
				player.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
		return itemStackIn;
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack itemStack, World world, EntityPlayer player) {
		if (itemStack.getItem() == ExtraPlanets_Items.ANTI_RADIATION) {
			if (!player.capabilities.isCreativeMode) {
				--itemStack.stackSize;
			}

			if (!world.isRemote) {
				IStatsCapability stats = null;

				if (player != null) {
					stats = player.getCapability(CapabilityStatsHandler.EP_STATS_CAPABILITY, null);
				}
				if (Config.RADIATION_ANTI_RAD_REDUCE_AMOUNT != 0) {
					double temp = stats.getRadiationLevel();
					double level = (temp * Config.RADIATION_ANTI_RAD_REDUCE_AMOUNT) / 100;
					if (level < 0)
						stats.setRadiationLevel(0);
					else
						stats.setRadiationLevel(level);
					PlayerUtilties.sendMessage(player, "" + EnumChatFormatting.AQUA + EnumChatFormatting.BOLD + player.getName() + EnumChatFormatting.GOLD + ", " + TranslateUtilities.translate("gui.radiation.reduced.message") + " "
							+ Config.RADIATION_SLEEPING_REDUCE_AMOUNT + "% " + TranslateUtilities.translate("gui.radiation.reduced.message.2"));
					PlayerUtilties.sendMessage(player, "" + EnumChatFormatting.AQUA + EnumChatFormatting.BOLD + player.getName() + EnumChatFormatting.DARK_AQUA + ", " + TranslateUtilities.translate("gui.radiation.current.message") + ": "
							+ (int) stats.getRadiationLevel() + "%");
				}
			}

			if (!player.capabilities.isCreativeMode) {
				if (itemStack.stackSize <= 0) {
					return new ItemStack(Items.glass_bottle);
				}

				player.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle));
			}
		}
		return itemStack;
	}

	@Override
	public int getItemStackLimit(ItemStack itemStack) {
		if (itemStack.getItem() == ExtraPlanets_Items.ANTI_RADIATION)
			return 1;
		return this.maxStackSize;
	}
}