package com.mjr.extraplanets.items;

import java.util.List;

import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.util.EnumColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.mjrlegendslib.item.ItemBasicMeta;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class ItemCannedFood extends ItemBasicMeta {

	public ItemCannedFood(String assetName) {
		super(assetName, ExtraPlanets.ItemsTab, getItemList());
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		if (itemStack.getItemDamage() < 5) {
			return this.getUnlocalizedName() + ".canned_food";
		}

		return this.getUnlocalizedName() + "." + getItemList()[itemStack.getItemDamage()];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list, boolean par4) {
		if (itemStack.getItemDamage() < 19) {
			list.add(EnumColor.BRIGHT_GREEN + TranslateUtilities.translate(this.getUnlocalizedName() + "." + getItemList()[itemStack.getItemDamage()] + ".name"));
		}
	}

	public int getHealAmount(ItemStack itemStack) {
		switch (itemStack.getItemDamage()) {
		case 0:
			return 16;
		case 1:
			return 4;
		case 2:
			return 4;
		case 3:
			return 12;
		default:
			return 0;
		}
	}

	public float getSaturationModifier(ItemStack itemStack) {
		switch (itemStack.getItemDamage()) {
		case 0:
			return 0.8F;
		case 1:
			return 0.1F;
		case 2:
			return 0.1F;
		case 3:
			return 0.6F;
		default:
			return 0.0F;
		}
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if (entityPlayer instanceof EntityPlayer) {
			if (itemStack.getItemDamage() < 5) {
				--itemStack.stackSize;
				EntityPlayer entityplayer = entityPlayer;
				entityplayer.getFoodStats().addStats(this.getHealAmount(itemStack), this.getSaturationModifier(itemStack));
				world.playSoundAtEntity(entityPlayer, "rand.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
				if (!world.isRemote) {
					entityPlayer.entityDropItem(new ItemStack(GCItems.canister, 1, 0), 0.0F);
				}
				return itemStack;
			}
		}
		return super.onItemUseFinish(itemStack, world, entityPlayer);
	}

	@Override
	public int getMaxItemUseDuration(ItemStack itemStack) {
		if (itemStack.getItemDamage() < 5) {
			return 32;
		}

		return super.getMaxItemUseDuration(itemStack);
	}

	@Override
	public EnumAction getItemUseAction(ItemStack itemStack) {
		if (itemStack.getItemDamage() < 5) {
			return EnumAction.EAT;
		}

		return super.getItemUseAction(itemStack);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if (itemStack.getItemDamage() < 5 && entityPlayer.canEat(false)) {
			entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
		}

		return itemStack;
	}

	public static String[] getItemList() {
		return new String[] { "dehydrated_porkchop", "dehydrated_fish", "dehydrated_salmon", "dehydrated_chicken" };
	}

}
