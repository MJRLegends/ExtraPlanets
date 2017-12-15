package com.mjr.extraplanets.schematicPages;

import micdoodle8.mods.galacticraft.api.recipe.SchematicPage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.client.gui.vehicles.GuiSchematicMarsRover;
import com.mjr.extraplanets.inventory.vehicles.ContainerSchematicMarsRover;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SchematicMarsRover extends SchematicPage {
	@Override
	public int getPageID() {
		return Config.schematicMarsRoverPageID;
	}

	@Override
	public int getGuiID() {
		return Config.schematicMarsRoverGUIID;
	}

	@Override
	public ItemStack getRequiredItem() {
		return new ItemStack(ExtraPlanets_Items.schematicMarsRover, 1, 0);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public GuiScreen getResultScreen(EntityPlayer player, int x, int y, int z) {
		return new GuiSchematicMarsRover(player.inventory);
	}

	@Override
	public Container getResultContainer(EntityPlayer player, int x, int y, int z) {
		return new ContainerSchematicMarsRover(player.inventory, x, y, z);
	}
}