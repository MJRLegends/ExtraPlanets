package com.mjr.extraplanets.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;

public class ItemAppleDiamond extends ItemFood {
	public ItemAppleDiamond(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setHasSubtypes(true);
		this.setAlwaysEdible();
		this.setCreativeTab(ExtraPlanets.ItemsTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack itemStack) {
		return itemStack.getItemDamage() > 0;
	}

	@Override
	public EnumRarity getRarity(ItemStack itemStack) {
		return itemStack.getItemDamage() == 0 ? EnumRarity.RARE : EnumRarity.EPIC;
	}

	@Override
	protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 600, 2));
			player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 6000, 1));
			player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000, 0));
			player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 1200, 0));
		}

		if (itemStack.getItemDamage() > 0) {
			if (!world.isRemote) {
				player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 1200, 3));
				player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 6000, 3));
				player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000, 0));
				player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 6000, 0));
				player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 6000, 0));
				player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 2400, 1));
			}
		} else {
			super.onFoodEaten(itemStack, world, player);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
		if(!this.isInCreativeTab(tab)) return;
		list.add(new ItemStack(this, 1, 0));
		list.add(new ItemStack(this, 1, 1));
	}
}
