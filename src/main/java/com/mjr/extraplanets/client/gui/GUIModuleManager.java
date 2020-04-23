package com.mjr.extraplanets.client.gui;

import java.io.IOException;
import java.util.List;

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

import micdoodle8.mods.galacticraft.core.client.gui.container.GuiContainerGC;
import micdoodle8.mods.galacticraft.core.energy.EnergyDisplayHelper;
import micdoodle8.mods.galacticraft.core.util.ColorUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GUIModuleManager extends GuiContainerGC {
	private static final ResourceLocation guiTexture = new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/module_manager.png");
	private static final ResourceLocation guiTextureSideLeft = new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/module_manager_side_left.png");
	private static final ResourceLocation guiTextureSideRight = new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/module_manager_side_right.png");
	protected static final ResourceLocation BUTTON_TEXTURES = new ResourceLocation("textures/gui/widgets.png");

	public final int iconSize = 22;
	public final int xOffset = 10; // Used to move GUI left and right
	public final int ySpacingInstalled = 8; // Used for y spacing between icons for installed modules

	private int mainColour = ColorUtil.to32BitColor(255, 0, 0, 0);
	private int sideColour = 4210752;

	public Module selectedModule;
	public Module selectedInstallModule;

	private GuiButton buttonActiveState;
	@SuppressWarnings("unused")
	private GuiButton buttonInstall;	
	@SuppressWarnings("unused")
	private GuiButton buttonUninstall;

	public GUIModuleManager(IInventory IInventory) {
		super(new ContainerModuleManager(IInventory, MCUtilities.getClient().player));
		this.xSize = 275;
		this.ySize = 167;
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		switch (button.id) {
		case 0:
			if (this.selectedModule == null)
				return;
			ExtraPlanets.packetPipeline.sendToServer(new PacketSimpleEP(EnumSimplePacket.S_UPDATE_MODULE_STATE, this.mc.world.provider.getDimensionType().getId(), new Object[] { this.selectedModule.getName() }));
			Minecraft.getMinecraft().player.closeScreen();
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
		this.guiLeft = (this.width - this.xSize) / 2;
		this.guiTop = (this.height - this.ySize) / 2;
		this.buttonList.add(this.buttonActiveState = new GuiButton(0, this.xOffset + this.guiLeft + 15, this.height / 2 + 58, 50, 20, TranslateUtilities.translate("gui.button.enable_module.name")));
		this.buttonList.add(this.buttonInstall = new GuiButton(1, this.xOffset + this.guiLeft - 65, this.height / 2 + 58, 50, 20, TranslateUtilities.translate("gui.button.install.name")));
		this.buttonList.add(this.buttonUninstall = new GuiButton(2, this.xOffset + this.guiLeft + 85, this.height / 2 + 58, 50, 20, TranslateUtilities.translate("gui.button.uninstall.name")));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRendererObj.drawString(TranslateUtilities.translate("gui.module_manager.name"), this.xOffset + 8, 5, this.mainColour);

		this.fontRendererObj.drawString(TranslateUtilities.translate("gui.modules_helmet.name"), this.xOffset + 8, 20, this.mainColour);
		this.renderModules(3, this.xOffset + 11, 31);
		this.fontRendererObj.drawString(TranslateUtilities.translate("gui.modules_chest.name"), this.xOffset + 8, 50, this.mainColour);
		this.renderModules(2, this.xOffset + 11, 31 + (1 * 22) + this.ySpacingInstalled);
		this.fontRendererObj.drawString(TranslateUtilities.translate("gui.modules_leggings.name"), this.xOffset + 8, 80, this.mainColour);
		this.renderModules(1, this.xOffset + 11, 31 + (2 * 22) + (2 * this.ySpacingInstalled));
		this.fontRendererObj.drawString(TranslateUtilities.translate("gui.modules_boots.name"), this.xOffset + 8, 110, this.mainColour);
		this.renderModules(0, this.xOffset + 11, 31 + (3 * 22) + (3 * this.ySpacingInstalled));

		this.fontRendererObj.drawString(TranslateUtilities.translate("gui.module_list.name"), this.xOffset + -75, 5, this.mainColour);
		this.renderModuleList(this.xOffset + -70, 18);

		this.fontRendererObj.drawString(TranslateUtilities.translate("gui.module_cost.name"), this.xOffset + -110, 5, this.mainColour);
		this.fontRendererObj.drawString(TranslateUtilities.translate("gui.module.description.name"), this.xOffset + 157, 40, this.mainColour);
		this.fontRendererObj.drawString(TranslateUtilities.translate("gui.module.name.name"), this.xOffset + 157, 5, this.mainColour);

		if (this.selectedInstallModule != null)
			this.renderCostList(this.xOffset + -115, 22);

		this.renderInfo(this.xOffset + 157, 15, 50, 125, 150, this.selectedInstallModule);
		this.renderInfo(this.xOffset + 157, 15, 50, 125, 150, this.selectedModule);

		this.fontRendererObj.drawString(TranslateUtilities.translate("gui.module.type.name"), this.xOffset + 157, 115, this.mainColour);
		this.fontRendererObj.drawString(TranslateUtilities.translate("gui.module.power.name"), this.xOffset + 157, 140, this.mainColour);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
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
		this.drawTexturedModalRect(x, y, 1, 23, this.iconSize, this.iconSize);
	}

	public void renderModules(int slot, int x, int y) {
		int xOffsetLocal = 0;
		ItemStack module = MCUtilities.getClient().player.inventory.armorItemInSlot(slot);
		for (Module modules : ModuleHelper.getModules(module)) {
			if (this.selectedModule != null && this.selectedModule.equals(modules)) {
				this.renderHighlightedBox(x - 3 + (10 * xOffsetLocal) + (xOffsetLocal * 12), y - 3);
			}
			this.itemRender.renderItemAndEffectIntoGUI(modules.getIcon(), x + (22 * xOffsetLocal), y);

			xOffsetLocal += 1;
		}
	}

	public void renderModuleList(int x, int y) {
		int moduleNumber = 0;
		int xOffsetLocal = 0;
		int yOffsetLocal = 0;
		for (Module modules : ExtraPlanets_Modules.getModules()) {
			if (moduleNumber == 3) {
				yOffsetLocal += this.iconSize;
				moduleNumber = 0;
				xOffsetLocal = 0;
			}
			if (this.selectedInstallModule != null && this.selectedInstallModule.equals(modules)) {
				this.renderHighlightedBox(x - 3 + (22 * xOffsetLocal), y - 3 + yOffsetLocal);
			}
			this.itemRender.renderItemAndEffectIntoGUI(modules.getIcon(), x + (22 * xOffsetLocal), y + yOffsetLocal);
			moduleNumber += 1;
			xOffsetLocal += 1;
		}
	}

	public void renderCostList(int x, int y) {
		int yOffsetLocal = 0;
		for (ItemStack stack : this.selectedInstallModule.getRequirements()) {
			this.itemRender.renderItemAndEffectIntoGUI(stack, x + 17, y - 4 + yOffsetLocal);
			this.fontRendererObj.drawString("" + stack.getCount() + " x ", x, y + yOffsetLocal, this.mainColour);
			yOffsetLocal += 18;
		}
	}

	public void renderInfo(int x, int yName, int Ydescription, int Ytype, int Ypower, Module module) {
		if (module != null) {
			String text = TranslateUtilities.translate("gui.module." + module.getName() + ".name");
			List<String> renderText = this.fontRendererObj.listFormattedStringToWidth(text, 115);
			int lineNum = 1;
			for (String line : renderText) {
				this.fontRendererObj.drawString(line, x, yName + ((lineNum - 1) * 10), this.sideColour);
				lineNum += 1;
			}

			text = TranslateUtilities.translate("gui.module." + module.getDescription());

			renderText = this.fontRendererObj.listFormattedStringToWidth(text, 115);
			lineNum = 1;
			for (String line : renderText) {
				this.fontRendererObj.drawString(line, x, Ydescription + ((lineNum - 1) * 10), this.sideColour);
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
			this.fontRendererObj.drawString(temp, x, Ytype, this.sideColour);
			text = TranslateUtilities.translate("gui.module.power.name");
			this.fontRendererObj.drawString(EnergyDisplayHelper.getEnergyDisplayS(ModuleHelper.getModulePassiveCost(module)) + "/s : " + EnergyDisplayHelper.getEnergyDisplayS(ModuleHelper.getModuleUseCost(module)) + " (P:U) ", x, Ypower,
					this.sideColour);
		}
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		// Check Inputs for Installed Modules
		this.checkInputInstalled(this.guiLeft + 8, this.guiTop + 29, mouseX, mouseY);

		// Check Inputs for List of Modules
		this.checkInputInstall(this.guiLeft - 73, this.guiTop + 14, mouseX, mouseY);
	}

	public void checkInputInstalled(int startX, int startY, int mouseX, int mouseY) {
		for (int i = 3; i > -1; i--) {
			int increase = i == 3 ? 0 : i == 2 ? 1 : i == 1 ? 2 : i == 0 ? 3 : 0;
			startY = this.guiTop + 29 + (increase * this.iconSize) + (increase * this.ySpacingInstalled);
			for (int j = 0; j < ModuleHelper.getModules(MCUtilities.getClient().player.inventory.armorItemInSlot(i)).size(); j++) {
				if (checkInputForIcon(j, startX, startY, mouseX, mouseY)) {
					this.selectedModule = ModuleHelper.getModules(MCUtilities.getClient().player.inventory.armorItemInSlot(i)).get(j);
					this.selectedInstallModule = null;
				}
			}
		}
	}

	public void checkInputInstall(int startX, int startY, int mouseX, int mouseY) {
		int moduleNumber = 0;
		for (int i = 0; i < ExtraPlanets_Modules.getModules().size(); i++) {
			if (moduleNumber == 3) {
				moduleNumber = 0;
				startX = this.guiLeft - 73;
				startY = startY + this.iconSize;
			}
			if (checkInputForIcon(moduleNumber, startX, startY, mouseX, mouseY)) {
				this.selectedInstallModule = ExtraPlanets_Modules.getModules().get(i);
				this.selectedModule = null;
			}
			moduleNumber += 1;
		}
	}

	public boolean checkInputForIcon(int slot, int startX, int startY, int mouseX, int mouseY) {
		startX = this.xOffset + startX;
		if ((mouseX >= startX + (slot * this.iconSize) && mouseX <= startX + this.iconSize + (slot * this.iconSize)) && (mouseY >= startY && mouseY <= startY + this.iconSize))
			return true;
		else
			return false;
	}

}