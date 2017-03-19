package com.mjr.extraplanets.schematic;

import micdoodle8.mods.galacticraft.api.recipe.ISchematicPage;
import micdoodle8.mods.galacticraft.core.items.ItemSchematic;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.client.gui.rockets.GuiSchematicTier6Rocket;
import com.mjr.extraplanets.inventory.rockets.ContainerSchematicTier6Rocket;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class SchematicTier6Rocket extends ItemSchematic implements ISchematicPage {

	public SchematicTier6Rocket()
    {
        super("schematic");
    }

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
	public GuiScreen getResultScreen(EntityPlayer player, BlockPos pos) {
		return new GuiSchematicTier6Rocket(player.inventory, pos);
	}

	@Override
	public Container getResultContainer(EntityPlayer player, BlockPos pos) {
		return new ContainerSchematicTier6Rocket(player.inventory, pos);
	}

	@Override
	public int compareTo(ISchematicPage o) {
		if (this.getPageID() > o.getPageID()) {
			return 1;
		} else {
			return -1;
		}
	}
}