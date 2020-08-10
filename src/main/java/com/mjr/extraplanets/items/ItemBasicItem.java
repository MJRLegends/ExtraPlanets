package com.mjr.extraplanets.items;

import java.util.List;

import javax.annotation.Nullable;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.handlers.capabilities.CapabilityStatsHandler;
import com.mjr.extraplanets.handlers.capabilities.IStatsCapability;
import com.mjr.mjrlegendslib.util.PlayerUtilties;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
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
	public void addInformation(ItemStack itemStack, @Nullable World world, List<String> list, ITooltipFlag flagIn) {
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

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		if (stack.getItem() == ExtraPlanets_Items.ANTI_RADIATION)
			return EnumAction.DRINK;
		return null;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		if (stack.getItem() == ExtraPlanets_Items.ANTI_RADIATION)
			return 32;
		return 0;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer playerIn, EnumHand hand) {
		ItemStack itemStackIn = playerIn.getHeldItem(hand);
		playerIn.setActiveHand(hand);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entityLiving) {
		if (stack.getItem() == ExtraPlanets_Items.ANTI_RADIATION) {
			EntityPlayer entityplayer = entityLiving instanceof EntityPlayer ? (EntityPlayer) entityLiving : null;

			if (entityplayer == null || !entityplayer.capabilities.isCreativeMode) {
				stack.shrink(1);
			}

			if (!world.isRemote) {
				IStatsCapability stats = null;

				if (entityLiving != null) {
					stats = entityLiving.getCapability(CapabilityStatsHandler.EP_STATS_CAPABILITY, null);
				}
				if (Config.RADIATION_ANTI_RAD_REDUCE_AMOUNT != 0) {
					double temp = stats.getRadiationLevel();
					double level = (temp * Config.RADIATION_ANTI_RAD_REDUCE_AMOUNT) / 100;
					if (level < 0)
						stats.setRadiationLevel(0);
					else
						stats.setRadiationLevel(level);
					PlayerUtilties.sendMessage(entityplayer, "" + TextFormatting.AQUA + TextFormatting.BOLD + entityplayer.getName() + TextFormatting.GOLD + ", " + TranslateUtilities.translate("gui.radiation.reduced.message") + " "
							+ Config.RADIATION_SLEEPING_REDUCE_AMOUNT + "% " + TranslateUtilities.translate("gui.radiation.reduced.message.2"));
					PlayerUtilties.sendMessage(entityplayer,
							"" + TextFormatting.AQUA + TextFormatting.BOLD + entityplayer.getName() + TextFormatting.DARK_AQUA + ", " + TranslateUtilities.translate("gui.radiation.current.message") + ": " + (int) stats.getRadiationLevel() + "/100");
				}
			}

			if (entityplayer == null || !entityplayer.capabilities.isCreativeMode) {
				if (!stack.isEmpty()) {
					return new ItemStack(Items.GLASS_BOTTLE);
				}

				if (entityplayer != null) {
					entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
				}
			}
		}
		return stack;
	}

	@Override
	public int getItemStackLimit(ItemStack stack) {
		if (stack.getItem() == ExtraPlanets_Items.ANTI_RADIATION)
			return 1;
		return this.maxStackSize;
	}
}