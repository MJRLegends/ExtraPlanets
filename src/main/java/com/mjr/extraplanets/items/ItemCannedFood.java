package com.mjr.extraplanets.items;

import java.util.List;

import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.util.EnumColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class ItemCannedFood extends Item {

	public static final String[] names = { "dehydrated_porkchop", "dehydrated_fish", "dehydrated_salmon", "dehydrated_chicken", "dehydrated_beef" };

	public ItemCannedFood(String assetName) {
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(assetName);
	}

	@Override
	public CreativeTabs getCreativeTab() {
		return ExtraPlanets.ItemsTab;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		if (itemStack.getItemDamage() < 5) {
			return this.getUnlocalizedName() + ".canned_food";
		}

		return this.getUnlocalizedName() + "." + ItemCannedFood.names[itemStack.getItemDamage()];
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < ItemCannedFood.names.length; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if (par1ItemStack.getItemDamage() < 19) {
			par3List.add(EnumColor.BRIGHT_GREEN + TranslateUtilities.translate(this.getUnlocalizedName() + "." + ItemCannedFood.names[par1ItemStack.getItemDamage()] + ".name"));
		}
	}

	public int getHealAmount(ItemStack par1ItemStack) {
		switch (par1ItemStack.getItemDamage()) {
		case 0:
			return 16;
		case 1:
			return 4;
		case 2:
			return 4;
		case 3:
			return 12;
		case 4:
			return 16;
		default:
			return 0;
		}
	}

	public float getSaturationModifier(ItemStack par1ItemStack) {
		switch (par1ItemStack.getItemDamage()) {
		case 0:
			return 0.8F;
		case 1:
			return 0.1F;
		case 2:
			return 0.1F;
		case 3:
			return 0.6F;
		case 4:
			return 0.8F;
		default:
			return 0.0F;
		}
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (par3EntityPlayer instanceof EntityPlayer) {
			if (par1ItemStack.getItemDamage() < 5) {
				--par1ItemStack.stackSize;
				EntityPlayer entityplayer = par3EntityPlayer;
				entityplayer.getFoodStats().addStats(this.getHealAmount(par1ItemStack), this.getSaturationModifier(par1ItemStack));
				par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
				if (!par2World.isRemote) {
					par3EntityPlayer.entityDropItem(new ItemStack(GCItems.canister, 1, 0), 0.0F);
				}
				return par1ItemStack;
			}
		}
		return super.onItemUseFinish(par1ItemStack, par2World, par3EntityPlayer);
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		if (par1ItemStack.getItemDamage() < 5) {
			return 32;
		}

		return super.getMaxItemUseDuration(par1ItemStack);
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		if (par1ItemStack.getItemDamage() < 5) {
			return EnumAction.EAT;
		}

		return super.getItemUseAction(par1ItemStack);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (par1ItemStack.getItemDamage() < 5 && par3EntityPlayer.canEat(false)) {
			par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		}

		return par1ItemStack;
	}
}