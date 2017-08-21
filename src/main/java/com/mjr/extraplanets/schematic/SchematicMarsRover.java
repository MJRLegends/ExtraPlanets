package com.mjr.extraplanets.schematic;

import micdoodle8.mods.galacticraft.api.recipe.SchematicPage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.client.gui.vehicles.GuiSchematicMarsRover;
import com.mjr.extraplanets.inventory.vehicles.ContainerSchematicMarsRover;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class SchematicMarsRover extends SchematicPage {
	@Override
	public int getPageID() {
		return Config.SCHEMATIC_MARS_ROVER_PAGE_ID;
	}

	@Override
	public int getGuiID() {
		return Config.SCHEMATIC_MARS_ROVER_GUI_ID;
	}

	@Override
	public ItemStack getRequiredItem() {
		return new ItemStack(ExtraPlanets_Items.MARS_ROVER_SCHEMATIC, 1, 0);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public GuiScreen getResultScreen(EntityPlayer player, BlockPos pos) {
		return new GuiSchematicMarsRover(player.inventory, pos);
	}

	@Override
	public Container getResultContainer(EntityPlayer player, BlockPos pos) {
		return new ContainerSchematicMarsRover(player.inventory, pos);
	}
}