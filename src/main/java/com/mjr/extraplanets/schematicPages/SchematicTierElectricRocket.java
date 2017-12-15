package com.mjr.extraplanets.schematicPages;

import micdoodle8.mods.galacticraft.api.recipe.ISchematicPage;
import micdoodle8.mods.galacticraft.core.items.ItemSchematic;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.client.gui.rockets.GuiSchematicTier10ElectricRocket;
import com.mjr.extraplanets.inventory.rockets.ContainerSchematicTier10ElectricRocket;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class SchematicTierElectricRocket extends ItemSchematic implements ISchematicPage {

	public SchematicTierElectricRocket() {
		super("schematic");
	}

	@Override
	public int getPageID() {
		return Config.SCHEMATIC_TIER_10_ELECTRIC_ROCKET_PAGE_ID;
	}

	@Override
	public int getGuiID() {
		return Config.SCHEMATIC_TIER_10_ELECTRIC_ROCKET_GUI_ID;
	}

	@Override
	public ItemStack getRequiredItem() {
		return new ItemStack(ExtraPlanets_Items.TIER_10_ELECTRIC_ROCKET_SCHEMATIC, 1, 0);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public GuiScreen getResultScreen(EntityPlayer player, BlockPos pos) {
		return new GuiSchematicTier10ElectricRocket(player.inventory, pos);
	}

	@Override
	public Container getResultContainer(EntityPlayer player, BlockPos pos) {
		return new ContainerSchematicTier10ElectricRocket(player.inventory, pos);
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