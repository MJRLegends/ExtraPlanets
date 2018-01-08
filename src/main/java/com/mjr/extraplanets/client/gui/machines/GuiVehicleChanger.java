package com.mjr.extraplanets.client.gui.machines;

import java.util.ArrayList;
import java.util.List;

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

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.inventory.machines.ContainerVehicleChanger;
import com.mjr.extraplanets.tileEntities.machines.TileEntityVehicleChanger;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class GuiVehicleChanger extends GuiContainerGC {
	private static final ResourceLocation vehicleChangerTexture = new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/vehicle_charger.png");

	private final TileEntityVehicleChanger vehicleChanger;

	private GuiButton buttonloadpower;
	private GuiElementInfoRegion electricInfoRegion = new GuiElementInfoRegion((this.width - this.xSize) / 2 + 112, (this.height - this.ySize) / 2 + 65, 56, 9, new ArrayList<String>(), this.width, this.height, this);

	public GuiVehicleChanger(InventoryPlayer par1InventoryPlayer, TileEntityVehicleChanger par2TileEntityAirDistributor) {
		super(new ContainerVehicleChanger(par1InventoryPlayer, par2TileEntityAirDistributor));
		this.vehicleChanger = par2TileEntityAirDistributor;
		this.ySize = 180;
	}

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		switch (par1GuiButton.id) {
		case 0:
			GalacticraftCore.packetPipeline.sendToServer(new PacketSimple(EnumSimplePacket.S_UPDATE_DISABLEABLE_BUTTON, GCCoreUtil.getDimensionID(this.vehicleChanger.getWorld()), new Object[] { this.vehicleChanger.getPos(), 0 }));
			break;
		}
	}

	@Override
	public void initGui() {
		super.initGui();
		List<String> batterySlotDesc = new ArrayList<String>();
		batterySlotDesc.add(TranslateUtilities.translate("gui.battery_slot.desc.0"));
		batterySlotDesc.add(TranslateUtilities.translate("gui.battery_slot.desc.1"));
		this.infoRegions.add(new GuiElementInfoRegion((this.width - this.xSize) / 2 + 50, (this.height - this.ySize) / 2 + 54, 18, 18, batterySlotDesc, this.width, this.height, this));
		List<String> electricityDesc = new ArrayList<String>();
		electricityDesc.add(TranslateUtilities.translate("gui.energy_storage.desc.0"));
		electricityDesc.add(EnumColor.YELLOW + TranslateUtilities.translate("gui.energy_storage.desc.1") + ((int) Math.floor(this.vehicleChanger.getEnergyStoredGC()) + " / " + (int) Math.floor(this.vehicleChanger.getMaxEnergyStoredGC())));
		this.electricInfoRegion.tooltipStrings = electricityDesc;
		this.electricInfoRegion.xPosition = (this.width - this.xSize) / 2 + 112;
		this.electricInfoRegion.yPosition = (this.height - this.ySize) / 2 + 65;
		this.electricInfoRegion.parentWidth = this.width;
		this.electricInfoRegion.parentHeight = this.height;
		this.infoRegions.add(this.electricInfoRegion);
		this.buttonList.add(this.buttonloadpower = new GuiButton(0, this.width / 2 + 2, this.height / 2 - 49, 76, 20, TranslateUtilities.translate("gui.button.loadpower.name")));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		this.fontRenderer.drawString(this.vehicleChanger.getName(), 52, 10, 4210752);
		this.buttonloadpower.displayString = !this.vehicleChanger.getDisabled(0) ? TranslateUtilities.translate("gui.button.stoploading.name") : TranslateUtilities.translate("gui.button.loadpower.name");
		this.fontRenderer.drawString(TranslateUtilities.translate("gui.message.status.name") + ": " + this.getStatus(), 28, 45 + 23 - 46, 4210752);
		this.fontRenderer.drawString(TranslateUtilities.translate("container.inventory"), 8, this.ySize - 118 + 2 + 11, 4210752);
	}

	private String getStatus() {
		return this.vehicleChanger.getGUIstatus();
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(GuiVehicleChanger.vehicleChangerTexture);
		final int var5 = (this.width - this.xSize) / 2;
		final int var6 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(var5, var6 + 5, 0, 0, this.xSize, 181);
		List<String> electricityDesc = new ArrayList<String>();
		electricityDesc.add(TranslateUtilities.translate("gui.energy_storage.desc.0"));
		EnergyDisplayHelper.getEnergyDisplayTooltip(this.vehicleChanger.getEnergyStoredGC(), this.vehicleChanger.getMaxEnergyStoredGC(), electricityDesc);
		this.electricInfoRegion.tooltipStrings = electricityDesc;

		if (this.vehicleChanger.getEnergyStoredGC() > 0) {
			this.drawTexturedModalRect(var5 + 99, var6 + 65, 192, 7, 11, 10);
		}

		this.drawTexturedModalRect(var5 + 113, var6 + 66, 192, 0, Math.min(this.vehicleChanger.getScaledElecticalLevel(54), 54), 7);
	}
}
