package com.mjr.extraplanets.client.gui;

import java.io.IOException;

import micdoodle8.mods.galacticraft.core.client.gui.container.GuiContainerGC;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.inventory.ContainerModuleManager;
import com.mjr.extraplanets.items.armor.modules.Module;
import com.mjr.extraplanets.items.armor.modules.ModuleHelper;
import com.mjr.mjrlegendslib.util.MCUtilities;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class GUIModuleManager extends GuiContainerGC {

	public Module selectedModule;
	private GuiButton buttonActiveState;

	public GUIModuleManager(IInventory par1IInventory) {
		super(new ContainerModuleManager(par1IInventory, MCUtilities.getClient().player));
	}

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		switch (par1GuiButton.id) {
		case 0:
			this.selectedModule.setActive(this.selectedModule.isActive() ? false : true);
			ItemStack temp = MCUtilities.getClient().player.inventory.armorItemInSlot(selectedModule.getSlotType());
			ModuleHelper.updateModuleActiveState(temp, this.selectedModule, this.selectedModule.isActive());
			break;
		}
	}

	@Override
	public void initGui() {
		super.initGui();
		this.buttonList.add(this.buttonActiveState = new GuiButton(0, this.width / 2 + 35, this.height / 2 - 75, 60, 20, TranslateUtilities.translate("gui.button.enable.name")));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		this.fontRenderer.drawString(TranslateUtilities.translate("gui.module_manager.name"), 8, 5, 4210752);

		this.fontRenderer.drawString(TranslateUtilities.translate("gui.modules_helmet.name"), 8, 20, 4210752);
		int x = 0;
		int y = 0;
		ItemStack helmet = MCUtilities.getClient().player.inventory.armorItemInSlot(3);
		for (Module modules : ModuleHelper.getModules(helmet)) {
			if (selectedModule == null)
				selectedModule = modules;
			if (selectedModule.equals(modules)) {
				this.mc.getTextureManager().bindTexture(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket.png"));
				this.drawTexturedModalRect(8 + (10 * x) + (x * 12), 30 + (10 * y) + (y * 5), 0, 0, 16, 16);
			}
			this.itemRender.renderItemAndEffectIntoGUI(modules.getIcon(), 8 + (10 * x) + (x * 12), 30 + (10 * y) + (y * 5));

			x += 1;
		}

		this.fontRenderer.drawString(TranslateUtilities.translate("gui.modules_chest.name"), 8, 50, 4210752);
		x = 0;
		y = 0;
		ItemStack chest = MCUtilities.getClient().player.inventory.armorItemInSlot(2);
		for (Module modules : ModuleHelper.getModules(chest)) {
			if (selectedModule.equals(modules)) {
				this.mc.getTextureManager().bindTexture(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket.png"));
				this.drawTexturedModalRect(8 + (10 * x) + (x * 12), 60 + (10 * y) + (y * 5), 0, 0, 16, 16);
			}
			this.itemRender.renderItemAndEffectIntoGUI(modules.getIcon(), 8 + (10 * x) + (x * 12), 60 + (10 * y) + (y * 5));
			x += 1;
		}

		this.fontRenderer.drawString(TranslateUtilities.translate("gui.modules_leggings.name"), 8, 80, 4210752);
		x = 0;
		y = 0;
		ItemStack legs = MCUtilities.getClient().player.inventory.armorItemInSlot(1);
		for (Module modules : ModuleHelper.getModules(legs)) {
			if (selectedModule.equals(modules)) {
				this.mc.getTextureManager().bindTexture(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket.png"));
				this.drawTexturedModalRect(8 + (10 * x) + (x * 12), 90 + (10 * y) + (y * 5), 0, 0, 16, 16);
			}
			this.itemRender.renderItemAndEffectIntoGUI(modules.getIcon(), 8 + (10 * x) + (x * 12), 90 + (10 * y) + (y * 5));
			x += 1;
		}

		this.fontRenderer.drawString(TranslateUtilities.translate("gui.modules_boots.name"), 8, 110, 4210752);
		x = 0;
		y = 0;
		ItemStack boots = MCUtilities.getClient().player.inventory.armorItemInSlot(0);
		for (Module modules : ModuleHelper.getModules(boots)) {
			if (selectedModule.equals(modules)) {
				this.mc.getTextureManager().bindTexture(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket.png"));
				this.drawTexturedModalRect(8 + (10 * x) + (x * 12), 120 + (10 * y) + (y * 5), 0, 0, 16, 16);
			}
			this.itemRender.renderItemAndEffectIntoGUI(modules.getIcon(), 8 + (10 * x) + (x * 12), 120 + (10 * y) + (y * 5));
			x += 1;
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		this.buttonActiveState.enabled = true;
		if(this.selectedModule != null)
			this.buttonActiveState.displayString = this.selectedModule.isActive() ? TranslateUtilities.translate("gui.button.disable.name") : TranslateUtilities.translate("gui.button.enable.name");
		// this.mc.getTextureManager().bindTexture();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		final int var5 = (this.width - this.xSize) / 2;
		final int var6 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(var5, var6, 0, 0, 196, 255);
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);

		int startX = this.width / 2 - 80;
		int startY = this.height / 2 - 53;
		for (int i = 0; i < ModuleHelper.getModules(MCUtilities.getClient().player.inventory.armorItemInSlot(3)).size(); i++) {
			if (i != 0)
				startX = startX + 8;
			if ((mouseX >= startX + (i * 16) && mouseX <= startX + 16 + (i * 16)) && (mouseY >= startY && mouseY <= startY + 16)) {
				this.selectedModule = ModuleHelper.getModules(MCUtilities.getClient().player.inventory.armorItemInSlot(3)).get(i);
			}
		}
		startX = this.width / 2 - 80;
		startY = startY + 30;
		for (int i = 0; i < ModuleHelper.getModules(MCUtilities.getClient().player.inventory.armorItemInSlot(2)).size(); i++) {
			if (i != 0)
				startX = startX + 8;
			if ((mouseX >= startX + (i * 16) && mouseX <= startX + 16 + (i * 16)) && (mouseY >= startY && mouseY <= startY + 16)) {
				this.selectedModule = ModuleHelper.getModules(MCUtilities.getClient().player.inventory.armorItemInSlot(2)).get(i);
			}
		}
		startX = this.width / 2 - 80;
		startY = startY + 30;
		for (int i = 0; i < ModuleHelper.getModules(MCUtilities.getClient().player.inventory.armorItemInSlot(1)).size(); i++) {
			if (i != 0)
				startX = startX + 8;
			if ((mouseX >= startX + (i * 16) && mouseX <= startX + 16 + (i * 16)) && (mouseY >= startY && mouseY <= startY + 16)) {
				this.selectedModule = ModuleHelper.getModules(MCUtilities.getClient().player.inventory.armorItemInSlot(1)).get(i);
			}
		}
		startX = this.width / 2 - 80;
		startY = startY + 30;
		System.out.println(startY);
		System.out.println(mouseY);
		for (int i = 0; i < ModuleHelper.getModules(MCUtilities.getClient().player.inventory.armorItemInSlot(0)).size(); i++) {
			if (i != 0)
				startX = startX + 8;
			if ((mouseX >= startX + (i * 16) && mouseX <= startX + 16 + (i * 16)) && (mouseY >= startY && mouseY <= startY + 16)) {
				this.selectedModule = ModuleHelper.getModules(MCUtilities.getClient().player.inventory.armorItemInSlot(0)).get(i);
			}
		}
	}
}