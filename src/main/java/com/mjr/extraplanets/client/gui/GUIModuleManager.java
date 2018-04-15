package com.mjr.extraplanets.client.gui;

import java.io.IOException;

import micdoodle8.mods.galacticraft.core.client.gui.container.GuiContainerGC;
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

	public Module selectedModule;
	public Module selectedInstallModule;

	private GuiButton buttonActiveState;
	private GuiButton buttonInstall;
	private GuiButton buttonUninstall;

	public GUIModuleManager(IInventory par1IInventory) {
		super(new ContainerModuleManager(par1IInventory, MCUtilities.getClient().thePlayer));
	}

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		switch (par1GuiButton.id) {
		case 0:
			if (this.selectedModule == null)
				return;
			this.selectedModule.setActive(this.selectedModule.isActive() ? false : true);
			ItemStack temp = MCUtilities.getClient().thePlayer.inventory.armorItemInSlot(selectedModule.getSlotType());
			ModuleHelper.updateModuleActiveState(temp, this.selectedModule, this.selectedModule.isActive());
			break;
		case 1:
			if (this.selectedInstallModule == null)
				return;
			ExtraPlanets.packetPipeline.sendToServer(new PacketSimpleEP(EnumSimplePacket.S_INSTALL_MODULE, this.mc.theWorld.provider.getDimensionId(), new Object[] { this.selectedInstallModule.getName() }));
			Minecraft.getMinecraft().thePlayer.closeScreen();
			break;
		case 2:
			if (this.selectedModule == null)
				return;
			ExtraPlanets.packetPipeline.sendToServer(new PacketSimpleEP(EnumSimplePacket.S_UNINSTALL_MODULE, this.mc.theWorld.provider.getDimensionId(), new Object[] { this.selectedModule.getName() }));
			Minecraft.getMinecraft().thePlayer.closeScreen();
			break;
		}
	}

	@Override
	public void initGui() {
		super.initGui();
		this.buttonList.add(this.buttonActiveState = new GuiButton(0, this.width / 2 - 75, this.height / 2 + 55, 85, 20, TranslateUtilities.translate("gui.button.enable_module.name")));
		this.buttonList.add(this.buttonInstall = new GuiButton(1, this.width / 2 - 163, this.height / 2 + 55, 75, 20, TranslateUtilities.translate("gui.button.install.name")));
		this.buttonList.add(this.buttonUninstall = new GuiButton(2, this.width / 2 + 15, this.height / 2 + 55, 85, 20, TranslateUtilities.translate("gui.button.uninstall.name")));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		this.fontRendererObj.drawString(TranslateUtilities.translate("gui.module_manager.name"), 8, 5, 4210752);

		this.fontRendererObj.drawString(TranslateUtilities.translate("gui.modules_helmet.name"), 8, 20, 4210752);
		int x = 0;
		int y = 0;
		ItemStack helmet = MCUtilities.getClient().thePlayer.inventory.armorItemInSlot(3);
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

		this.fontRendererObj.drawString(TranslateUtilities.translate("gui.modules_chest.name"), 8, 50, 4210752);
		x = 0;
		y = 0;
		ItemStack chest = MCUtilities.getClient().thePlayer.inventory.armorItemInSlot(2);
		for (Module modules : ModuleHelper.getModules(chest)) {
			if (selectedModule == null)
				selectedModule = modules;
			if (selectedModule.equals(modules)) {
				this.mc.getTextureManager().bindTexture(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket.png"));
				this.drawTexturedModalRect(8 + (10 * x) + (x * 12), 60 + (10 * y) + (y * 5), 0, 0, 16, 16);
			}
			this.itemRender.renderItemAndEffectIntoGUI(modules.getIcon(), 8 + (10 * x) + (x * 12), 60 + (10 * y) + (y * 5));
			x += 1;
		}

		this.fontRendererObj.drawString(TranslateUtilities.translate("gui.modules_leggings.name"), 8, 80, 4210752);
		x = 0;
		y = 0;
		ItemStack legs = MCUtilities.getClient().thePlayer.inventory.armorItemInSlot(1);
		for (Module modules : ModuleHelper.getModules(legs)) {
			if (selectedModule == null)
				selectedModule = modules;
			if (selectedModule.equals(modules)) {
				this.mc.getTextureManager().bindTexture(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket.png"));
				this.drawTexturedModalRect(8 + (10 * x) + (x * 12), 90 + (10 * y) + (y * 5), 0, 0, 16, 16);
			}
			this.itemRender.renderItemAndEffectIntoGUI(modules.getIcon(), 8 + (10 * x) + (x * 12), 90 + (10 * y) + (y * 5));
			x += 1;
		}

		this.fontRendererObj.drawString(TranslateUtilities.translate("gui.modules_boots.name"), 8, 110, 4210752);
		x = 0;
		y = 0;
		ItemStack boots = MCUtilities.getClient().thePlayer.inventory.armorItemInSlot(0);
		for (Module modules : ModuleHelper.getModules(boots)) {
			if (selectedModule == null)
				selectedModule = modules;
			if (selectedModule.equals(modules)) {
				this.mc.getTextureManager().bindTexture(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket.png"));
				this.drawTexturedModalRect(8 + (10 * x) + (x * 12), 120 + (10 * y) + (y * 5), 0, 0, 16, 16);
			}
			this.itemRender.renderItemAndEffectIntoGUI(modules.getIcon(), 8 + (10 * x) + (x * 12), 120 + (10 * y) + (y * 5));
			x += 1;
		}

		this.fontRendererObj.drawString(TranslateUtilities.translate("gui.module_list.name"), -75, 5, 4210752);
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
				this.drawTexturedModalRect(-70 + (10 * x) + (x * 12), 18 + y, 0, 0, 16, 16);
			}
			this.itemRender.renderItemAndEffectIntoGUI(modules.getIcon(), -70 + (10 * x) + (x * 12), 18 + y);
			moduleNumber += 1;
			x += 1;
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		this.buttonActiveState.enabled = true;
		if (this.selectedModule != null)
			this.buttonActiveState.displayString = this.selectedModule.isActive() ? TranslateUtilities.translate("gui.button.enable_module.name") : TranslateUtilities.translate("gui.button.disable_module.name");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		final int var5 = (this.width - this.xSize) / 2;
		final int var6 = (this.height - this.ySize) / 2;
		this.mc.getTextureManager().bindTexture(guiTexture);
		this.drawTexturedModalRect(var5, var6, 0, 0, 196, 167);
		this.mc.getTextureManager().bindTexture(guiTexture);
		this.drawTexturedModalRect(var5 - 80, var6, 0, 0, 80, 167);
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);

		int startX = this.width / 2 - 80;
		int startY = this.height / 2 - 53;
		for (int i = 0; i < ModuleHelper.getModules(MCUtilities.getClient().thePlayer.inventory.armorItemInSlot(3)).size(); i++) {
			if (i != 0)
				startX = startX + 8;
			if ((mouseX >= startX + (i * 16) && mouseX <= startX + 16 + (i * 16)) && (mouseY >= startY && mouseY <= startY + 16)) {
				this.selectedModule = ModuleHelper.getModules(MCUtilities.getClient().thePlayer.inventory.armorItemInSlot(3)).get(i);
			}
		}
		startX = this.width / 2 - 80;
		startY = startY + 30;
		for (int i = 0; i < ModuleHelper.getModules(MCUtilities.getClient().thePlayer.inventory.armorItemInSlot(2)).size(); i++) {
			if (i != 0)
				startX = startX + 8;
			if ((mouseX >= startX + (i * 16) && mouseX <= startX + 16 + (i * 16)) && (mouseY >= startY && mouseY <= startY + 16)) {
				this.selectedModule = ModuleHelper.getModules(MCUtilities.getClient().thePlayer.inventory.armorItemInSlot(2)).get(i);
			}
		}
		startX = this.width / 2 - 80;
		startY = startY + 30;
		for (int i = 0; i < ModuleHelper.getModules(MCUtilities.getClient().thePlayer.inventory.armorItemInSlot(1)).size(); i++) {
			if (i != 0)
				startX = startX + 8;
			if ((mouseX >= startX + (i * 16) && mouseX <= startX + 16 + (i * 16)) && (mouseY >= startY && mouseY <= startY + 16)) {
				this.selectedModule = ModuleHelper.getModules(MCUtilities.getClient().thePlayer.inventory.armorItemInSlot(1)).get(i);
			}
		}
		startX = this.width / 2 - 80;
		startY = startY + 30;
		for (int i = 0; i < ModuleHelper.getModules(MCUtilities.getClient().thePlayer.inventory.armorItemInSlot(0)).size(); i++) {
			if (i != 0)
				startX = startX + 8;
			if ((mouseX >= startX + (i * 16) && mouseX <= startX + 16 + (i * 16)) && (mouseY >= startY && mouseY <= startY + 16)) {
				this.selectedModule = ModuleHelper.getModules(MCUtilities.getClient().thePlayer.inventory.armorItemInSlot(0)).get(i);
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
			if ((mouseX >= startX + (x * 16) && mouseX <= startX + 16 + (x * 16)) && (mouseY >= startY && mouseY <= startY + 16)) {
				this.selectedInstallModule = ExtraPlanets_Modules.getModules().get(i);
			}
			moduleNumber += 1;
			x += 1;
		}
	}
}