package com.mjr.extraplanets.items;

import java.util.List;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.mjrlegendslib.item.ItemBasicMeta;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.util.EnumColor;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCannedFood extends ItemBasicMeta {

	public ItemCannedFood(String name) {
		super(name, ExtraPlanets.ItemsTab, getItemList());
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
	public void addInformation(ItemStack itemStack, EntityPlayer par2EntityPlayer, List<String> par3List, boolean par4) {
		if (itemStack.getItemDamage() < 19) {
			par3List.add(EnumColor.BRIGHT_GREEN + TranslateUtilities.translate(this.getUnlocalizedName() + "." + getItemList()[itemStack.getItemDamage()] + ".name"));
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
	public ItemStack onItemUseFinish(ItemStack itemStack, World par2World, EntityLivingBase par3EntityPlayer) {
		if (par3EntityPlayer instanceof EntityPlayer) {
			if (itemStack.getItemDamage() < 5) {
				--itemStack.stackSize;
				EntityPlayer entityplayer = (EntityPlayer) par3EntityPlayer;
				entityplayer.getFoodStats().addStats(this.getHealAmount(itemStack), this.getSaturationModifier(itemStack));
				par2World.playSound((EntityPlayer) null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
				if (!par2World.isRemote) {
					par3EntityPlayer.entityDropItem(new ItemStack(GCItems.canister, 1, 0), 0.0F);
				}
				return itemStack;
			}
		}
		return super.onItemUseFinish(itemStack, par2World, par3EntityPlayer);
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
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World world, EntityPlayer playerIn, EnumHand hand) {
		if (playerIn.canEat(false)) {
			playerIn.setActiveHand(hand);
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
		} else {
			return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemStackIn);
		}
	}

	public static String[] getItemList() {
		return new String[] { "dehydrated_porkchop", "dehydrated_fish", "dehydrated_salmon", "dehydrated_chicken" };
	}

}
