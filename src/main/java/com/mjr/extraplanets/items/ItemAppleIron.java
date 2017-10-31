package com.mjr.extraplanets.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;

public class ItemAppleIron extends ItemFood {
	public ItemAppleIron(int amount, float saturation, boolean isWolfFood) {
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
			player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 250, 0));
			player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 400, 0));
			player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 600, 0));
			player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 120, 1));
			player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 120, 1));

		}

		if (itemStack.getItemDamage() > 0) {
			if (!world.isRemote) {
				player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 350, 0));
				player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 600, 0));
				player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 700, 0));
				player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 850, 1));
				player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 240, 2));
				player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 300, 1));
			}
		} else {
			super.onFoodEaten(itemStack, world, player);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, NonNullList<ItemStack> list) {
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
	}
}
