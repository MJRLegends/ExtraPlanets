package com.mjr.extraplanets.schematic;

import micdoodle8.mods.galacticraft.api.recipe.SchematicPage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.client.gui.rockets.GuiSchematicTier4Rocket;
import com.mjr.extraplanets.inventory.rockets.ContainerSchematicTier4Rocket;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SchematicTier4Rocket extends SchematicPage {
	@Override
	public int getPageID() {
		return Config.schematicTier4PageID;
	}

	@Override
	public int getGuiID() {
		return Config.schematicTier4GUIID;
	}

	@Override
	public ItemStack getRequiredItem() {
		return new ItemStack(ExtraPlanets_Items.schematicTier4, 1, 0);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public GuiScreen getResultScreen(EntityPlayer player, int x, int y, int z) {
		return new GuiSchematicTier4Rocket(player.inventory, x, y, z);
	}

	@Override
	public Container getResultContainer(EntityPlayer player, int x, int y, int z) {
		return new ContainerSchematicTier4Rocket(player.inventory, x, y, z);
	}
}