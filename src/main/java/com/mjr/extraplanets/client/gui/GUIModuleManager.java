package com.mjr.extraplanets.client.gui;

import java.io.IOException;
import java.util.List;

import micdoodle8.mods.galacticraft.core.client.gui.container.GuiContainerGC;
import micdoodle8.mods.galacticraft.core.util.ColorUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.inventory.ContainerModuleManager;
import com.mjr.extraplanets.items.armor.modules.ExtraPlanets_Modules;
import com.mjr.extraplanets.items.armor.modules.Module;
import com.mjr.extraplanets.items.armor.modules.ModuleHelper;
import com.mjr.extraplanets.network.PacketSimpleEP;
import com.mjr.extraplanets.network.PacketSimpleEP.EnumSimplePacket;
import com.mjr.mjrlegendslib.util.MCUtilities;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

@SuppressWarnings("unused")
public class GUIModuleManager extends GuiContainerGC {
	private static final ResourceLocation guiTexture = new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/module_manager.png");
	private static final ResourceLocation guiTextureSideLeft = new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/module_manager_side_left.png");
	private static final ResourceLocation guiTextureSideRight = new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/module_manager_side_right.png");

	private int xOffset = 10; // Used to center the gui

	public Module selectedModule;
	public Module selectedInstallModule;

	private GuiButton buttonActiveState;
	private GuiButton buttonInstall;
	private GuiButton buttonUninstall;

	public GUIModuleManager(IInventory par1IInventory) {
		super(new ContainerModuleManager(par1IInventory, MCUtilities.getClient().player));
	}

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		switch (par1GuiButton.id) {
		case 0:
			if (this.selectedModule == null)
				return;
			this.selectedModule.setActive(this.selectedModule.isActive() ? false : true);
			ItemStack temp = MCUtilities.getClient().player.inventory.armorItemInSlot(selectedModule.getSlotType());
			ModuleHelper.updateModuleActiveState(temp, this.selectedModule, this.selectedModule.isActive());
			break;
		case 1:
			if (this.selectedInstallModule == null)
				return;
			ExtraPlanets.packetPipeline.sendToServer(new PacketSimpleEP(EnumSimplePacket.S_INSTALL_MODULE, this.mc.world.provider.getDimensionType().getId(), new Object[] { this.selectedInstallModule.getName() }));
			Minecraft.getMinecraft().player.closeScreen();
			break;
		case 2:
			if (this.selectedModule == null)
				return;
			ExtraPlanets.packetPipeline.sendToServer(new PacketSimpleEP(EnumSimplePacket.S_UNINSTALL_MODULE, this.mc.world.provider.getDimensionType().getId(), new Object[] { this.selectedModule.getName() }));
			Minecraft.getMinecraft().player.closeScreen();
			break;
		}
	}

	@Override
	public void initGui() {
		super.initGui();
		this.buttonList.add(this.buttonActiveState = new GuiButton(0, xOffset + this.width / 2 - 75, this.height / 2 + 55, 50, 20, TranslateUtilities.translate("gui.button.enable_module.name")));
		this.buttonList.add(this.buttonInstall = new GuiButton(1, xOffset + this.width / 2 - 152, this.height / 2 + 55, 50, 20, TranslateUtilities.translate("gui.button.install.name")));
		this.buttonList.add(this.buttonUninstall = new GuiButton(2, xOffset + this.width / 2, this.height / 2 + 55, 50, 20, TranslateUtilities.translate("gui.button.uninstall.name")));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		this.fontRenderer.drawString(TranslateUtilities.translate("gui.module_manager.name"), xOffset + 8, 5, ColorUtil.to32BitColor(255, 0, 0, 0));

		this.fontRenderer.drawString(TranslateUtilities.translate("gui.modules_helmet.name"), xOffset + 8, 20, ColorUtil.to32BitColor(255, 0, 0, 0));
		int x = 0;
		int y = 0;
		ItemStack helmet = MCUtilities.getClient().player.inventory.armorItemInSlot(3);
		for (Module modules : ModuleHelper.getModules(helmet)) {
			if (selectedModule == null)
				selectedModule = modules;
			if (selectedModule.equals(modules)) {
				this.mc.getTextureManager().bindTexture(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket.png"));
				this.drawTexturedModalRect(xOffset + 8 + (10 * x) + (x * 12), 30 + (10 * y) + (y * 5), 0, 0, 16, 16);
			}
			this.itemRender.renderItemAndEffectIntoGUI(modules.getIcon(), xOffset + 8 + (10 * x) + (x * 12), 30 + (10 * y) + (y * 5));

			x += 1;
		}

		this.fontRenderer.drawString(TranslateUtilities.translate("gui.modules_chest.name"), xOffset + 8, 50, ColorUtil.to32BitColor(255, 0, 0, 0));
		x = 0;
		y = 0;
		ItemStack chest = MCUtilities.getClient().player.inventory.armorItemInSlot(2);
		for (Module modules : ModuleHelper.getModules(chest)) {
			if (selectedModule == null)
				selectedModule = modules;
			if (selectedModule.equals(modules)) {
				this.mc.getTextureManager().bindTexture(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket.png"));
				this.drawTexturedModalRect(xOffset + 8 + (10 * x) + (x * 12), 60 + (10 * y) + (y * 5), 0, 0, 16, 16);
			}
			this.itemRender.renderItemAndEffectIntoGUI(modules.getIcon(), xOffset + 8 + (10 * x) + (x * 12), 60 + (10 * y) + (y * 5));
			x += 1;
		}

		this.fontRenderer.drawString(TranslateUtilities.translate("gui.modules_leggings.name"), xOffset + 8, 80, ColorUtil.to32BitColor(255, 0, 0, 0));
		x = 0;
		y = 0;
		ItemStack legs = MCUtilities.getClient().player.inventory.armorItemInSlot(1);
		for (Module modules : ModuleHelper.getModules(legs)) {
			if (selectedModule == null)
				selectedModule = modules;
			if (selectedModule.equals(modules)) {
				this.mc.getTextureManager().bindTexture(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket.png"));
				this.drawTexturedModalRect(xOffset + 8 + (10 * x) + (x * 12), 90 + (10 * y) + (y * 5), 0, 0, 16, 16);
			}
			this.itemRender.renderItemAndEffectIntoGUI(modules.getIcon(), xOffset + 8 + (10 * x) + (x * 12), 90 + (10 * y) + (y * 5));
			x += 1;
		}

		this.fontRenderer.drawString(TranslateUtilities.translate("gui.modules_boots.name"), xOffset + 8, 110, ColorUtil.to32BitColor(255, 0, 0, 0));
		x = 0;
		y = 0;
		ItemStack boots = MCUtilities.getClient().player.inventory.armorItemInSlot(0);
		for (Module modules : ModuleHelper.getModules(boots)) {
			if (selectedModule == null)
				selectedModule = modules;
			if (selectedModule.equals(modules)) {
				this.mc.getTextureManager().bindTexture(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket.png"));
				this.drawTexturedModalRect(xOffset + 8 + (10 * x) + (x * 12), 120 + (10 * y) + (y * 5), 0, 0, 16, 16);
			}
			this.itemRender.renderItemAndEffectIntoGUI(modules.getIcon(), xOffset + 8 + (10 * x) + (x * 12), 120 + (10 * y) + (y * 5));
			x += 1;
		}

		this.fontRenderer.drawString(TranslateUtilities.translate("gui.module_list.name"), xOffset + -75, 5, ColorUtil.to32BitColor(255, 0, 0, 0));
		int moduleNumber = 0;
		x = 0;
		y = 0;
		for (Module modules : ExtraPlanets_Modules.getModules()) {
			if (selectedInstallModule == null)
				selectedInstallModule = modules;
			if (moduleNumber == 3) {
				y += 18;
				moduleNumber = 0;
				x = 0;
			}
			if (selectedInstallModule.equals(modules)) {
				this.mc.getTextureManager().bindTexture(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket.png"));
				this.drawTexturedModalRect(xOffset + -70 + (10 * x) + (x * 12), 18 + y, 0, 0, 16, 16);
			}
			this.itemRender.renderItemAndEffectIntoGUI(modules.getIcon(), xOffset + -70 + (10 * x) + (x * 12), 18 + y);
			moduleNumber += 1;
			x += 1;
		}

		this.fontRenderer.drawString(TranslateUtilities.translate("gui.module_cost.name"), xOffset + -110, 5, ColorUtil.to32BitColor(255, 0, 0, 0));
		y = 0;
		for (ItemStack stack : this.selectedInstallModule.getRequirements()) {
			this.itemRender.renderItemAndEffectIntoGUI(stack, xOffset + -98, 18 + y);
			this.fontRenderer.drawString("" + stack.getCount() + " x ", xOffset + -115, 22 + y, ColorUtil.to32BitColor(255, 0, 0, 0));
			y += 18;
		}

		if (this.selectedInstallModule != null) {
			this.fontRenderer.drawString(TranslateUtilities.translate("gui.module." + this.selectedInstallModule.getName() + ".name"), 165, 5, ColorUtil.to32BitColor(255, 0, 0, 0));
			this.fontRenderer.drawString("Description:", 190, 20, ColorUtil.to32BitColor(255, 0, 0, 0));
			String text = TranslateUtilities.translate("gui.module." + this.selectedInstallModule.getDescription());
			int charsPerLine = 20;

			List<String> renderText = this.fontRenderer.listFormattedStringToWidth(text, 115);
			String textTemp = "";
			int lineNum = 1;
			for (String line : renderText) {
				this.fontRenderer.drawString(line, 165, 35 + ((lineNum - 1) * 10), 4210752);
				lineNum += 1;
			}
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		this.buttonActiveState.enabled = true;
		if (this.selectedModule != null)
			this.buttonActiveState.displayString = this.selectedModule.isActive() ? TranslateUtilities.translate("gui.button.enable_module.name") : TranslateUtilities.translate("gui.button.disable_module.name");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		final int var5 = (this.width - this.xSize) / 2 + xOffset;
		final int var6 = (this.height - this.ySize) / 2;
		this.mc.getTextureManager().bindTexture(guiTextureSideLeft);
		this.drawTexturedModalRect(var5 - 120, var6, 0, 0, 122, 167);
		this.mc.getTextureManager().bindTexture(guiTexture);
		this.drawTexturedModalRect(var5 + 2, var6, 0, 0, 150, 167);
		this.mc.getTextureManager().bindTexture(guiTextureSideRight);
		this.drawTexturedModalRect(var5 + 150, var6, 0, 0, 122, 167);
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);

		int startX = this.width / 2 - 80;
		int startY = this.height / 2 - 53;

		for (int i = 0; i < ModuleHelper.getModules(MCUtilities.getClient().player.inventory.armorItemInSlot(3)).size(); i++) {
			if (i != 0)
				startX = startX + 8;
			if ((mouseX >= xOffset + startX + (i * 16) && mouseX <= xOffset + startX + 16 + (i * 16)) && (mouseY >= startY && mouseY <= startY + 16)) {
				this.selectedModule = ModuleHelper.getModules(MCUtilities.getClient().player.inventory.armorItemInSlot(3)).get(i);
			}
		}
		startX = this.width / 2 - 80;
		startY = startY + 30;
		for (int i = 0; i < ModuleHelper.getModules(MCUtilities.getClient().player.inventory.armorItemInSlot(2)).size(); i++) {
			if (i != 0)
				startX = startX + 8;
			if ((mouseX >= xOffset + startX + (i * 16) && mouseX <= xOffset + startX + 16 + (i * 16)) && (mouseY >= startY && mouseY <= startY + 16)) {
				this.selectedModule = ModuleHelper.getModules(MCUtilities.getClient().player.inventory.armorItemInSlot(2)).get(i);
			}
		}
		startX = this.width / 2 - 80;
		startY = startY + 30;
		for (int i = 0; i < ModuleHelper.getModules(MCUtilities.getClient().player.inventory.armorItemInSlot(1)).size(); i++) {
			if (i != 0)
				startX = startX + 8;
			if ((mouseX >= xOffset + startX + (i * 16) && mouseX <= xOffset + startX + 16 + (i * 16)) && (mouseY >= startY && mouseY <= startY + 16)) {
				this.selectedModule = ModuleHelper.getModules(MCUtilities.getClient().player.inventory.armorItemInSlot(1)).get(i);
			}
		}
		startX = this.width / 2 - 80;
		startY = startY + 30;
		for (int i = 0; i < ModuleHelper.getModules(MCUtilities.getClient().player.inventory.armorItemInSlot(0)).size(); i++) {
			if (i != 0)
				startX = startX + 8;
			if ((mouseX >= xOffset + startX + (i * 16) && mouseX <= xOffset + startX + 16 + (i * 16)) && (mouseY >= startY && mouseY <= startY + 16)) {
				this.selectedModule = ModuleHelper.getModules(MCUtilities.getClient().player.inventory.armorItemInSlot(0)).get(i);
			}
		}

		startX = this.width / 2 - 160;
		startY = this.height / 2 - 64;

		int moduleNumber = 0;
		int x = 0;
		for (int i = 0; i < ExtraPlanets_Modules.getModules().size(); i++) {
			if (moduleNumber == 3) {
				moduleNumber = 0;
				startX = this.width / 2 - 160;
				startY = startY + 18;
				x = 0;
			}
			if (x != 0)
				startX = startX + 8;
			if ((mouseX >= xOffset + startX + (x * 16) && mouseX <= xOffset + startX + 16 + (x * 16)) && (mouseY >= startY && mouseY <= startY + 16)) {
				this.selectedInstallModule = ExtraPlanets_Modules.getModules().get(i);
			}
			moduleNumber += 1;
			x += 1;
		}
	}
}