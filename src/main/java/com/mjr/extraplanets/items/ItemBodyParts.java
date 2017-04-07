package com.mjr.extraplanets.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.mjr.extraplanets.ExtraPlanets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBodyParts extends Item {
	public static final String[] names = { "arm", "leg" };

	protected IIcon[] icons = new IIcon[ItemBodyParts.names.length];

	public ItemBodyParts() {
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setUnlocalizedName("bodyparts");
	}

	@Override
	public CreativeTabs getCreativeTab() {
		return ExtraPlanets.ItemsTab;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		int i = 0;

		for (final String name : ItemBodyParts.names) {
			this.icons[i++] = iconRegister.registerIcon(this.getIconString() + "." + name);
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return this.getUnlocalizedName() + "." + ItemBodyParts.names[itemStack.getItemDamage()];
	}

	@Override
	public IIcon getIconFromDamage(int damage) {
		if (this.icons.length > damage) {
			return this.icons[damage];
		}

		return super.getIconFromDamage(damage);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < ItemBodyParts.names.length; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}
}
