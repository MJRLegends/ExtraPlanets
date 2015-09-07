package com.mjr.extraplanets.items.schematics;

import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.ISchematicItem;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SchematicTier4 extends Item implements ISchematicItem {
	public SchematicTier4(String name) {
		super();
		this.setUnlocalizedName(name);
		this.setCreativeTab(ExtraPlanets.ItemsTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister
				.registerIcon(Constants.TEXTURE_PREFIX + "tier4_schematic_rocket");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player,
			List list, boolean par4) {
		if (player.worldObj.isRemote) {
			list.add(EnumChatFormatting.GRAY
					+ GCCoreUtil.translate("schematic.tier4.rocket.name"));
		}
	}
}
