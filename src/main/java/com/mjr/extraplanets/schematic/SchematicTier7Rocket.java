package com.mjr.extraplanets.schematic;

import micdoodle8.mods.galacticraft.api.recipe.SchematicPage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.client.gui.rockets.GuiSchematicTier7Rocket;
import com.mjr.extraplanets.inventory.rockets.ContainerSchematicTier7Rocket;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SchematicTier7Rocket extends SchematicPage
{
	@Override
	public int getPageID()
	{
		return Config.schematicTier7PageID;
	}

	@Override
	public int getGuiID()
	{
		return Config.schematicTier7GUIID;
	}

	@Override
	public ItemStack getRequiredItem()
	{
		return new ItemStack(ExtraPlanets_Items.schematicTier7, 1, 0);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public GuiScreen getResultScreen(EntityPlayer player, int x, int y, int z)
	{
		return new GuiSchematicTier7Rocket(player.inventory, x, y, z);
	}

	@Override
	public Container getResultContainer(EntityPlayer player, int x, int y, int z)
	{
		return new ContainerSchematicTier7Rocket(player.inventory, x, y, z);
	}
}