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
			player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 600, 2));
			player.addPotionEffect(new PotionEffect(Potion.resistance.id, 6000, 1));
			player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 0));
			player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 1200, 0));
		}

		if (itemStack.getItemDamage() > 0) {
			if (!world.isRemote) {
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1200, 3));
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 6000, 3));
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 0));
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 6000, 0));
				player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 6000, 0));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 2400, 1));
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
