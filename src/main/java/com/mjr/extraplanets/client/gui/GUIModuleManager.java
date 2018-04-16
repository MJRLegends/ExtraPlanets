package com.mjr.extraplanets.client.gui;

import java.io.IOException;
import java.util.List;

import micdoodle8.mods.galacticraft.core.client.gui.container.GuiContainerGC;
import micdoodle8.mods.galacticraft.core.util.ColorUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
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
	protected static final ResourceLocation BUTTON_TEXTURES = new ResourceLocation("textures/gui/widgets.png");

	private int xOffset = 10; // Used to center the gui

	private int mainColour = ColorUtil.to32BitColor(255, 0, 0, 0);
	private int sideColour = 4210752;

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
		this.buttonList.add(this.buttonActiveState = new GuiButton(0, this.xOffset + this.width / 2 - 75, this.height / 2 + 58, 50, 20, TranslateUtilities.translate("gui.button.enable_module.name")));
		this.buttonList.add(this.buttonInstall = new GuiButton(1, this.xOffset + this.width / 2 - 152, this.height / 2 + 58, 50, 20, TranslateUtilities.translate("gui.button.install.name")));
		this.buttonList.add(this.buttonUninstall = new GuiButton(2, this.xOffset + this.width / 2, this.height / 2 + 58, 50, 20, TranslateUtilities.translate("gui.button.uninstall.name")));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		this.fontRenderer.drawString(TranslateUtilities.translate("gui.module_manager.name"), this.xOffset + 8, 5, this.mainColour);

		this.fontRenderer.drawString(TranslateUtilities.translate("gui.modules_helmet.name"), this.xOffset + 8, 20, this.mainColour);
		this.renderModules(3, this.xOffset + 11, 31);
		this.fontRenderer.drawString(TranslateUtilities.translate("gui.modules_chest.name"), this.xOffset + 8, 50, this.mainColour);
		this.renderModules(2, this.xOffset + 11, 61);
		this.fontRenderer.drawString(TranslateUtilities.translate("gui.modules_leggings.name"), this.xOffset + 8, 80, this.mainColour);
		this.renderModules(1, this.xOffset + 11, 91);
		this.fontRenderer.drawString(TranslateUtilities.translate("gui.modules_boots.name"), this.xOffset + 8, 110, this.mainColour);
		this.renderModules(0, this.xOffset + 11, 121);

		this.fontRenderer.drawString(TranslateUtilities.translate("gui.module_list.name"), this.xOffset + -75, 5, this.mainColour);
		this.renderModuleList(this.xOffset + -70, 18);

		this.fontRenderer.drawString(TranslateUtilities.translate("gui.module_cost.name"), this.xOffset + -110, 5, this.mainColour);
		this.fontRenderer.drawString(TranslateUtilities.translate("gui.module.description.name"), 167, 40, this.mainColour);
		this.fontRenderer.drawString(TranslateUtilities.translate("gui.module.name.name"), 167, 5, this.mainColour);

		if (this.selectedInstallModule != null)
			this.renderCostList(this.xOffset + -115, 22);

		this.renderInfo(167, 15, 55, 135, this.selectedInstallModule);
		this.renderInfo(167, 15, 55, 135, this.selectedModule);

		this.fontRenderer.drawString(TranslateUtilities.translate("gui.module.type.name"), 167, 125, this.mainColour);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		this.buttonActiveState.enabled = true;
		if (this.selectedModule != null)
			this.buttonActiveState.displayString = this.selectedModule.isActive() ? TranslateUtilities.translate("gui.button.enable_module.name") : TranslateUtilities.translate("gui.button.disable_module.name");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		final int var5 = (this.width - this.xSize) / 2 + this.xOffset;
		final int var6 = (this.height - this.ySize) / 2;
		this.mc.getTextureManager().bindTexture(guiTextureSideLeft);
		this.drawTexturedModalRect(var5 - 120, var6, 0, 0, 122, 167);
		this.mc.getTextureManager().bindTexture(guiTexture);
		this.drawTexturedModalRect(var5 + 2, var6, 0, 0, 150, 167);
		this.mc.getTextureManager().bindTexture(guiTextureSideRight);
		this.drawTexturedModalRect(var5 + 152, var6, 0, 0, 122, 167);
	}

	public void renderHighlightedBox(int x, int y) {
		this.mc.getTextureManager().bindTexture(BUTTON_TEXTURES);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
		this.drawTexturedModalRect(x, y, 1, 23, 22, 22);
	}

	public void renderModules(int slot, int x, int y) {
		int xOffsetLocal = 0;
		ItemStack module = MCUtilities.getClient().player.inventory.armorItemInSlot(slot);
		for (Module modules : ModuleHelper.getModules(module)) {
			if (this.selectedModule != null && this.selectedModule.equals(modules)) {
				this.renderHighlightedBox(x - 3 + (10 * xOffsetLocal) + (xOffsetLocal * 12), y - 3);
			}
			this.itemRender.renderItemAndEffectIntoGUI(modules.getIcon(), x + (10 * xOffsetLocal) + (xOffsetLocal * 12), y);

			xOffsetLocal += 1;
		}
	}

	public void renderModuleList(int x, int y) {
		int moduleNumber = 0;
		int xOffsetLocal = 0;
		int yOffsetLocal = 0;
		for (Module modules : ExtraPlanets_Modules.getModules()) {
			if (moduleNumber == 3) {
				yOffsetLocal += 18;
				moduleNumber = 0;
				xOffsetLocal = 0;
			}
			if (this.selectedInstallModule != null && this.selectedInstallModule.equals(modules)) {
				this.renderHighlightedBox(x - 3 + (10 * xOffsetLocal) + (xOffsetLocal * 12), y - 3 + yOffsetLocal);
			}
			this.itemRender.renderItemAndEffectIntoGUI(modules.getIcon(), x + (10 * xOffsetLocal) + (xOffsetLocal * 12), y + yOffsetLocal);
			moduleNumber += 1;
			xOffsetLocal += 1;
		}
	}

	public void renderCostList(int x, int y) {
		int yOffsetLocal = 0;
		for (ItemStack stack : this.selectedInstallModule.getRequirements()) {
			this.itemRender.renderItemAndEffectIntoGUI(stack, x + 17, y - 4 + yOffsetLocal);
			this.fontRenderer.drawString("" + stack.getCount() + " x ", x, y + yOffsetLocal, this.mainColour);
			yOffsetLocal += 18;
		}
	}

	public void renderInfo(int x, int yName, int Ydescription, int Ytype, Module module) {
		if (module != null) {
			String text = TranslateUtilities.translate("gui.module." + module.getName() + ".name");
			List<String> renderText = this.fontRenderer.listFormattedStringToWidth(text, 115);
			String textTemp = "";
			int lineNum = 1;
			for (String line : renderText) {
				this.fontRenderer.drawString(line, x, yName + ((lineNum - 1) * 10), this.sideColour);
				lineNum += 1;
			}

			text = TranslateUtilities.translate("gui.module." + module.getDescription());
			int charsPerLine = 20;

			renderText = this.fontRenderer.listFormattedStringToWidth(text, 115);
			textTemp = "";
			lineNum = 1;
			for (String line : renderText) {
				this.fontRenderer.drawString(line, x, Ydescription + ((lineNum - 1) * 10), this.sideColour);
				lineNum += 1;
			}

			String temp = "";
			if (module.getSlotType() == 0)
				temp = TranslateUtilities.translate("gui.module.type.boots.name");
			else if (module.getSlotType() == 1)
				temp = TranslateUtilities.translate("gui.module.type.leggings.name");
			else if (module.getSlotType() == 2)
				temp = TranslateUtilities.translate("gui.module.type.chest.name");
			else if (module.getSlotType() == 3)
				temp = TranslateUtilities.translate("gui.module.type.helmet.name");
			this.fontRenderer.drawString(temp, x, Ytype, this.sideColour);
		}
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);

		// Check Inputs for Installed Modules
		int startX = this.width / 2 - 80;
		int startY = this.height / 2 - 53;
		this.checkInputForIcon(3, this.xOffset + startX, startY, mouseX, mouseY);

		startX = this.width / 2 - 80;
		startY = startY + 30;
		this.checkInputForIcon(2, this.xOffset + startX, startY, mouseX, mouseY);

		startX = this.width / 2 - 80;
		startY = startY + 30;
		this.checkInputForIcon(1, this.xOffset + startX, startY, mouseX, mouseY);

		startX = this.width / 2 - 80;
		startY = startY + 30;
		this.checkInputForIcon(0, this.xOffset + startX, startY, mouseX, mouseY);

		startX = this.width / 2 - 160;
		startY = this.height / 2 - 64;

		// Check Inputs for List of Modules
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
			if ((mouseX >= this.xOffset + startX + (x * 16) && mouseX <= this.xOffset + startX + 16 + (x * 16)) && (mouseY >= startY && mouseY <= startY + 16)) {
				this.selectedInstallModule = ExtraPlanets_Modules.getModules().get(i);
				this.selectedModule = null;
			}
			moduleNumber += 1;
			x += 1;
		}
	}

	public void checkInputForIcon(int slot, int startX, int startY, int mouseX, int mouseY) {
		for (int i = 0; i < ModuleHelper.getModules(MCUtilities.getClient().player.inventory.armorItemInSlot(slot)).size(); i++) {
			if (i != 0)
				startX = startX + 8;
			if ((mouseX >= startX + (i * 16) && mouseX <= startX + 16 + (i * 16)) && (mouseY >= startY && mouseY <= startY + 16)) {
				this.selectedModule = ModuleHelper.getModules(MCUtilities.getClient().player.inventory.armorItemInSlot(slot)).get(i);
				this.selectedInstallModule = null;
			}
		}
	}

}