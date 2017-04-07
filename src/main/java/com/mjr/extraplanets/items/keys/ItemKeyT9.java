package com.mjr.extraplanets.items.keys;

import java.util.List;

import micdoodle8.mods.galacticraft.api.item.IKeyItem;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.planets.mars.MarsModule;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.mjr.extraplanets.ExtraPlanets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemKeyT9 extends Item implements IKeyItem {
	public static String[] keyTypes = new String[] { "T9" };
	public IIcon[] keyIcons = new IIcon[1];

	public ItemKeyT9() {
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setCreativeTab(ExtraPlanets.ItemsTab);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return "item." + "key." + ItemKeyT9.keyTypes[itemStack.getItemDamage()];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return ClientProxyCore.galacticraftItem;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		int i = 0;

		for (final String name : ItemKeyT9.keyTypes) {
			this.keyIcons[i++] = iconRegister.registerIcon(MarsModule.TEXTURE_PREFIX + "key_" + name);
		}
	}

	@Override
	public IIcon getIconFromDamage(int damage) {
		if (this.keyIcons.length > damage) {
			return this.keyIcons[damage];
		}

		return super.getIconFromDamage(damage);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < ItemKeyT9.keyTypes.length; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}

	@Override
	public int getTier(ItemStack keyStack) {
		return 9;
	}
}