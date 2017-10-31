package com.mjr.extraplanets.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
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
			player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 250, 0));
			player.addPotionEffect(new PotionEffect(Potion.resistance.id, 400, 0));
			player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 600, 0));
			player.addPotionEffect(new PotionEffect(Potion.jump.id, 120, 1));
			player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 120, 1));

		}

		if (itemStack.getItemDamage() > 0) {
			if (!world.isRemote) {
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 350, 0));
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 600, 0));
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 700, 0));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 850, 1));
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 240, 2));
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 300, 1));
			}
		} else {
			super.onFoodEaten(itemStack, world, player);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> list) {
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
	}
}
