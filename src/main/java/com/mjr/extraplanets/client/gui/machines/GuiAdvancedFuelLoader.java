package com.mjr.extraplanets.client.gui.machines;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.inventory.machines.ContainerAdvancedFuelLoader;
import com.mjr.extraplanets.tileEntities.machines.TileEntityAdvancedFuelLoader;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.client.gui.container.GuiContainerGC;
import micdoodle8.mods.galacticraft.core.client.gui.element.GuiElementInfoRegion;
import micdoodle8.mods.galacticraft.core.energy.EnergyDisplayHelper;
import micdoodle8.mods.galacticraft.core.network.PacketSimple;
import micdoodle8.mods.galacticraft.core.network.PacketSimple.EnumSimplePacket;
import micdoodle8.mods.galacticraft.core.util.EnumColor;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiAdvancedFuelLoader extends GuiContainerGC {
	private static final ResourceLocation fuelLoaderTexture = new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/fuel_loader.png");

	private final TileEntityAdvancedFuelLoader tileEntity;

	private GuiButton buttonLoadFuel;
	private GuiElementInfoRegion electricInfoRegion = new GuiElementInfoRegion((this.width - this.xSize) / 2 + 112, (this.height - this.ySize) / 2 + 65, 56, 9, new ArrayList<String>(), this.width, this.height, this);

	public GuiAdvancedFuelLoader(InventoryPlayer inventoryPlayer, TileEntityAdvancedFuelLoader tileEntity) {
		super(new ContainerAdvancedFuelLoader(inventoryPlayer, tileEntity));
		this.tileEntity = tileEntity;
		this.ySize = 180;
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		switch (button.id) {
		case 0:
			GalacticraftCore.packetPipeline.sendToServer(new PacketSimple(EnumSimplePacket.S_UPDATE_DISABLEABLE_BUTTON, GCCoreUtil.getDimensionID(this.tileEntity.getWorld()), new Object[] { this.tileEntity.getPos(), 0 }));
			break;
		}
	}

	@Override
	public void initGui() {
		super.initGui();
		List<String> fuelTankDesc = new ArrayList<String>();
		fuelTankDesc.add(TranslateUtilities.translate("gui.fuel_tank.desc.2"));
		fuelTankDesc.add(TranslateUtilities.translate("gui.fuel_tank.desc.3"));
		this.infoRegions.add(new GuiElementInfoRegion((this.width - this.xSize) / 2 + 7, (this.height - this.ySize) / 2 + 33, 16, 38, fuelTankDesc, this.width, this.height, this));
		List<String> batterySlotDesc = new ArrayList<String>();
		batterySlotDesc.add(TranslateUtilities.translate("gui.battery_slot.desc.0"));
		batterySlotDesc.add(TranslateUtilities.translate("gui.battery_slot.desc.1"));
		this.infoRegions.add(new GuiElementInfoRegion((this.width - this.xSize) / 2 + 50, (this.height - this.ySize) / 2 + 54, 18, 18, batterySlotDesc, this.width, this.height, this));
		List<String> electricityDesc = new ArrayList<String>();
		electricityDesc.add(TranslateUtilities.translate("gui.energy_storage.desc.0"));
		electricityDesc.add(EnumColor.YELLOW + TranslateUtilities.translate("gui.energy_storage.desc.1") + ((int) Math.floor(this.tileEntity.getEnergyStoredGC()) + " / " + (int) Math.floor(this.tileEntity.getMaxEnergyStoredGC())));
		this.electricInfoRegion.tooltipStrings = electricityDesc;
		this.electricInfoRegion.xPosition = (this.width - this.xSize) / 2 + 112;
		this.electricInfoRegion.yPosition = (this.height - this.ySize) / 2 + 65;
		this.electricInfoRegion.parentWidth = this.width;
		this.electricInfoRegion.parentHeight = this.height;
		this.infoRegions.add(this.electricInfoRegion);
		this.buttonList.add(this.buttonLoadFuel = new GuiButton(0, this.width / 2 + 2, this.height / 2 - 49, 76, 20, TranslateUtilities.translate("gui.button.loadfuel.name")));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString(this.tileEntity.getName(), 40, 10, 4210752);
		this.buttonLoadFuel.enabled = this.tileEntity.disableCooldown == 0 && !(this.tileEntity.fuelTank.getFluid() == null || this.tileEntity.fuelTank.getFluid().amount == 0);
		this.buttonLoadFuel.displayString = !this.tileEntity.getDisabled(0) ? TranslateUtilities.translate("gui.button.stoploading.name") : TranslateUtilities.translate("gui.button.loadfuel.name");
		this.fontRenderer.drawString(TranslateUtilities.translate("gui.message.status.name") + ": " + this.getStatus(), 28, 45 + 23 - 46, 4210752);
		// this.fontRenderer.drawString("" + this.tileEntity.storage.getMaxExtract(), 28, 56 + 23 - 46, 4210752);
		// this.fontRenderer.drawString(ElectricityDisplay.getDisplay(this.tileEntity.getVoltage(), ElectricUnit.VOLTAGE), 28, 68 + 23 - 46, 4210752);
		this.fontRenderer.drawString(TranslateUtilities.translate("container.inventory"), 8, this.ySize - 118 + 2 + 11, 4210752);
	}

	private String getStatus() {
		if (this.tileEntity.fuelTank.getFluid() == null || this.tileEntity.fuelTank.getFluid().amount == 0) {
			return EnumColor.DARK_RED + TranslateUtilities.translate("gui.status.nofuel.name");
		}

		return this.tileEntity.getGUIstatus();
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(GuiAdvancedFuelLoader.fuelLoaderTexture);
		final int var5 = (this.width - this.xSize) / 2;
		final int var6 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(var5, var6 + 5, 0, 0, this.xSize, 181);

		final int fuelLevel = this.tileEntity.getScaledFuelLevel(38);
		this.drawTexturedModalRect((this.width - this.xSize) / 2 + 7, (this.height - this.ySize) / 2 + 17 + 54 - fuelLevel, 176, 38 - fuelLevel, 16, fuelLevel);

		List<String> electricityDesc = new ArrayList<String>();
		electricityDesc.add(TranslateUtilities.translate("gui.energy_storage.desc.0"));
		EnergyDisplayHelper.getEnergyDisplayTooltip(this.tileEntity.getEnergyStoredGC(), this.tileEntity.getMaxEnergyStoredGC(), electricityDesc);
		// electricityDesc.add(EnumColor.YELLOW + TranslateUtilities.translate("gui.energy_storage.desc.1") + ((int) Math.floor(this.tileEntity.getEnergyStoredGC()) + " / " + (int) Math.floor(this.tileEntity.getMaxEnergyStoredGC())));
		this.electricInfoRegion.tooltipStrings = electricityDesc;

		if (this.tileEntity.getEnergyStoredGC() > 0) {
			this.drawTexturedModalRect(var5 + 99, var6 + 65, 192, 7, 11, 10);
		}

		this.drawTexturedModalRect(var5 + 113, var6 + 66, 192, 0, Math.min(this.tileEntity.getScaledElecticalLevel(54), 54), 7);
	}
}