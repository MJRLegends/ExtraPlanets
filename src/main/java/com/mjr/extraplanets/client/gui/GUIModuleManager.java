package com.mjr.extraplanets.client.gui;

import micdoodle8.mods.galacticraft.core.client.gui.container.GuiContainerGC;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.inventory.ContainerModuleManager;
import com.mjr.extraplanets.items.armor.modules.Module;
import com.mjr.extraplanets.items.armor.modules.ModuleHelper;
import com.mjr.mjrlegendslib.util.MCUtilities;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class GUIModuleManager extends GuiContainerGC {

	public GUIModuleManager(IInventory par1IInventory) {
		super(new ContainerModuleManager(par1IInventory, MCUtilities.getClient().player));
	}

	@Override
	public void initGui() {
		super.initGui();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		this.fontRenderer.drawString(TranslateUtilities.translate("gui.modulemanger.name"), 8, 5, 4210752);

		this.fontRenderer.drawString(TranslateUtilities.translate("gui.helmet.name"), 8, 20, 4210752);
		int x = 0;
		int y = 0;
		ItemStack helmet = MCUtilities.getClient().player.inventory.armorItemInSlot(3);
		for (Module modules : ModuleHelper.getModules(helmet)) {
			this.mc.getTextureManager().bindTexture(modules.getIconTexture());
			this.drawTexturedModalRect(12 + (10 * x) + (x * 3), 30 + (10 * y) + (y * 5), 0, 0, 16, 16);
			x += 1;
			y += 1;
		}

		this.fontRenderer.drawString(TranslateUtilities.translate("gui.chest.name"), 8, 50, 4210752);
		x = 0;
		y = 0;
		ItemStack chest = MCUtilities.getClient().player.inventory.armorItemInSlot(2);
		for (Module modules : ModuleHelper.getModules(chest)) {
			this.mc.getTextureManager().bindTexture(modules.getIconTexture());
			this.drawTexturedModalRect(12 + (10 * x) + (x * 3), 60 + (10 * y) + (y * 5), 0, 0, 16, 16);
			x += 1;
			y += 1;
		}

		this.fontRenderer.drawString(TranslateUtilities.translate("gui.leggings.name"), 8, 80, 4210752);
		x = 0;
		y = 0;
		ItemStack legs = MCUtilities.getClient().player.inventory.armorItemInSlot(1);
		for (Module modules : ModuleHelper.getModules(legs)) {
			this.mc.getTextureManager().bindTexture(modules.getIconTexture());
			this.drawTexturedModalRect(12 + (10 * x) + (x * 3), 90 + (10 * y) + (y * 5), 0, 0, 16, 16);
			x += 1;
			y += 1;
		}

		this.fontRenderer.drawString(TranslateUtilities.translate("gui.boots.name"), 8, 110, 4210752);
		x = 0;
		y = 0;
		ItemStack boots = MCUtilities.getClient().player.inventory.armorItemInSlot(0);
		for (Module modules : ModuleHelper.getModules(boots)) {
			this.mc.getTextureManager().bindTexture(modules.getIconTexture());
			this.drawTexturedModalRect(12 + (10 * x) + (x * 3), 120 + (10 * y) + (y * 5), 0, 0, 16, 16);
			x += 1;
			y += 1;
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		//this.mc.getTextureManager().bindTexture();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		final int var5 = (this.width - this.xSize) / 2;
		final int var6 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(var5, var6, 0, 0, 196, 255);
	}
}