package com.mjr.extraplanets.schematicPages;

import micdoodle8.mods.galacticraft.api.recipe.SchematicPage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.client.gui.rockets.GuiSchematicTier6Rocket;
import com.mjr.extraplanets.inventory.rockets.ContainerSchematicTier6Rocket;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SchematicTier6Rocket extends SchematicPage {
	@Override
	public int getPageID() {
		return Config.schematicTier6PageID;
	}

	@Override
	public int getGuiID() {
		return Config.schematicTier6GUIID;
	}

	@Override
	public ItemStack getRequiredItem() {
		return new ItemStack(ExtraPlanets_Items.schematicTier6, 1, 0);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public GuiScreen getResultScreen(EntityPlayer player, int x, int y, int z) {
		return new GuiSchematicTier6Rocket(player.inventory, x, y, z);
	}

	@Override
	public Container getResultContainer(EntityPlayer player, int x, int y, int z) {
		return new ContainerSchematicTier6Rocket(player.inventory, x, y, z);
	}
}