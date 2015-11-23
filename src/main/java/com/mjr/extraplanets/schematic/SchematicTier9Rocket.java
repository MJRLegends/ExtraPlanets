package com.mjr.extraplanets.schematic;

import micdoodle8.mods.galacticraft.api.recipe.SchematicPage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.client.gui.GuiSchematicTier9Rocket;
import com.mjr.extraplanets.inventory.ContainerSchematicTier9Rocket;
import com.mjr.extraplanets.items.ExtraPlanetsItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SchematicTier9Rocket extends SchematicPage {
	@Override
	public int getPageID() {
		return Config.schematicTier9PageID;
	}

	@Override
	public int getGuiID() {
		return Config.schematicTier9GUIID;
	}

	@Override
	public ItemStack getRequiredItem() {
		return new ItemStack(ExtraPlanetsItems.schematicTier9, 1, 0);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public GuiScreen getResultScreen(EntityPlayer player, int x, int y, int z) {
		return new GuiSchematicTier9Rocket(player.inventory, x, y, z);
	}

	@Override
	public Container getResultContainer(EntityPlayer player, int x, int y, int z) {
		return new ContainerSchematicTier9Rocket(player.inventory, x, y, z);
	}
}