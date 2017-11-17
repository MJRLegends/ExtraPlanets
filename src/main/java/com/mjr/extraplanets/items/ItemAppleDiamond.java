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

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemAppleDiamond extends ItemFood {
	public ItemAppleDiamond(int p_i45341_1_, float p_i45341_2_, boolean p_i45341_3_) {
		super(p_i45341_1_, p_i45341_2_, p_i45341_3_);
		this.setHasSubtypes(true);
		this.setAlwaysEdible();
		this.setUnlocalizedName("appleDiamond");
		this.setTextureName(Constants.TEXTURE_PREFIX + "apple_diamond");
		this.setCreativeTab(ExtraPlanets.ItemsTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack p_77636_1_) {
		return p_77636_1_.getItemDamage() > 0;
	}

	/**
	 * Return an item rarity from EnumRarity
	 */
	@Override
	public EnumRarity getRarity(ItemStack p_77613_1_) {
		return p_77613_1_.getItemDamage() == 0 ? EnumRarity.rare : EnumRarity.epic;
	}

	@Override
	protected void onFoodEaten(ItemStack p_77849_1_, World p_77849_2_, EntityPlayer p_77849_3_) {
		if (!p_77849_2_.isRemote) {
			p_77849_3_.addPotionEffect(new PotionEffect(Potion.regeneration.id, 600, 2));
			p_77849_3_.addPotionEffect(new PotionEffect(Potion.resistance.id, 6000, 1));
			p_77849_3_.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 0));
			p_77849_3_.addPotionEffect(new PotionEffect(Potion.nightVision.id, 1200, 0));
		}

		if (p_77849_1_.getItemDamage() > 0) {
			if (!p_77849_2_.isRemote) {
				p_77849_3_.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1200, 3));
				p_77849_3_.addPotionEffect(new PotionEffect(Potion.resistance.id, 6000, 3));
				p_77849_3_.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 0));
				p_77849_3_.addPotionEffect(new PotionEffect(Potion.nightVision.id, 6000, 0));
				p_77849_3_.addPotionEffect(new PotionEffect(Potion.invisibility.id, 6000, 0));
				p_77849_3_.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 2400, 1));
			}
		} else {
			super.onFoodEaten(p_77849_1_, p_77849_2_, p_77849_3_);
		}
	}

	/**
	 * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_) {
		p_150895_3_.add(new ItemStack(p_150895_1_, 1, 0));
		p_150895_3_.add(new ItemStack(p_150895_1_, 1, 1));
	}
}
