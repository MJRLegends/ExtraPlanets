package com.mjr.extraplanets.client.gui.machines;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.inventory.machines.ContainerUltimateOxygenCompressor;
import com.mjr.extraplanets.tileEntities.machines.TileEntityUltimateOxygenCompressor;
import com.mjr.mjrlegendslib.util.MCUtilities;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.core.client.gui.container.GuiContainerGC;
import micdoodle8.mods.galacticraft.core.client.gui.element.GuiElementInfoRegion;
import micdoodle8.mods.galacticraft.core.energy.EnergyDisplayHelper;
import micdoodle8.mods.galacticraft.core.items.ItemOxygenTank;
import micdoodle8.mods.galacticraft.core.util.EnumColor;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiUltimateOxygenCompressor extends GuiContainerGC {
	private static final ResourceLocation compressorTexture = new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/compressor.png");

	private final TileEntityUltimateOxygenCompressor tileEntity;

	private GuiElementInfoRegion oxygenInfoRegion = new GuiElementInfoRegion((this.width - this.xSize) / 2 + 112, (this.height - this.ySize) / 2 + 24, 56, 9, new ArrayList<String>(), this.width, this.height, this);
	private GuiElementInfoRegion electricInfoRegion = new GuiElementInfoRegion((this.width - this.xSize) / 2 + 112, (this.height - this.ySize) / 2 + 37, 56, 9, new ArrayList<String>(), this.width, this.height, this);

	public GuiUltimateOxygenCompressor(InventoryPlayer inventoryPlayer, TileEntityUltimateOxygenCompressor tileEntity) {
		super(new ContainerUltimateOxygenCompressor(inventoryPlayer, tileEntity, MCUtilities.getClient().player));
		this.tileEntity = tileEntity;
		this.ySize = 180;
	}

	@Override
	public void initGui() {
		super.initGui();
		List<String> batterySlotDesc = new ArrayList<String>();
		batterySlotDesc.add(TranslateUtilities.translate("gui.battery_slot.desc.0"));
		batterySlotDesc.add(TranslateUtilities.translate("gui.battery_slot.desc.1"));
		this.infoRegions.add(new GuiElementInfoRegion((this.width - this.xSize) / 2 + 46, (this.height - this.ySize) / 2 + 26, 18, 18, batterySlotDesc, this.width, this.height, this));
		List<String> oxygenSlotDesc = new ArrayList<String>();
		oxygenSlotDesc.add(TranslateUtilities.translate("gui.oxygen_slot.desc.0"));
		oxygenSlotDesc.add(TranslateUtilities.translate("gui.oxygen_slot.desc.1"));
		this.infoRegions.add(new GuiElementInfoRegion((this.width - this.xSize) / 2 + 16, (this.height - this.ySize) / 2 + 26, 18, 18, oxygenSlotDesc, this.width, this.height, this));
		List<String> compressorSlotDesc = new ArrayList<String>();
		compressorSlotDesc.add(TranslateUtilities.translate("gui.oxygen_compressor.slot.desc.0"));
		compressorSlotDesc.add(TranslateUtilities.translate("gui.oxygen_compressor.slot.desc.1"));
		this.infoRegions.add(new GuiElementInfoRegion((this.width - this.xSize) / 2 + 132, (this.height - this.ySize) / 2 + 70, 18, 18, compressorSlotDesc, this.width, this.height, this));
		List<String> oxygenDesc = new ArrayList<String>();
		oxygenDesc.add(TranslateUtilities.translate("gui.oxygen_storage.desc.0"));
		oxygenDesc.add(EnumColor.YELLOW + TranslateUtilities.translate("gui.oxygen_storage.desc.1") + ": " + ((int) Math.floor(this.tileEntity.getOxygenStored()) + " / " + (int) Math.floor(this.tileEntity.getMaxOxygenStored())));
		this.oxygenInfoRegion.tooltipStrings = oxygenDesc;
		this.oxygenInfoRegion.xPosition = (this.width - this.xSize) / 2 + 112;
		this.oxygenInfoRegion.yPosition = (this.height - this.ySize) / 2 + 24;
		this.oxygenInfoRegion.parentWidth = this.width;
		this.oxygenInfoRegion.parentHeight = this.height;
		this.infoRegions.add(this.oxygenInfoRegion);
		List<String> electricityDesc = new ArrayList<String>();
		electricityDesc.add(TranslateUtilities.translate("gui.energy_storage.desc.0"));
		electricityDesc.add(EnumColor.YELLOW + TranslateUtilities.translate("gui.energy_storage.desc.1") + ((int) Math.floor(this.tileEntity.getEnergyStoredGC()) + " / " + (int) Math.floor(this.tileEntity.getMaxEnergyStoredGC())));
		this.electricInfoRegion.tooltipStrings = electricityDesc;
		this.electricInfoRegion.xPosition = (this.width - this.xSize) / 2 + 112;
		this.electricInfoRegion.yPosition = (this.height - this.ySize) / 2 + 37;
		this.electricInfoRegion.parentWidth = this.width;
		this.electricInfoRegion.parentHeight = this.height;
		this.infoRegions.add(this.electricInfoRegion);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString(this.tileEntity.getName(), 8, 10, 4210752);
		GCCoreUtil.drawStringRightAligned(TranslateUtilities.translate("gui.message.in.name") + ":", 99, 26, 4210752, this.fontRenderer);
		GCCoreUtil.drawStringRightAligned(TranslateUtilities.translate("gui.message.in.name") + ":", 99, 38, 4210752, this.fontRenderer);
		String status = TranslateUtilities.translate("gui.message.status.name") + ": " + this.getStatus();
		this.fontRenderer.drawString(status, this.xSize / 2 - this.fontRenderer.getStringWidth(status) / 2, 50, 4210752);
		status = TranslateUtilities.translate("gui.oxygen_use.desc") + ": " + TileEntityUltimateOxygenCompressor.TANK_TRANSFER_SPEED * 20 + TranslateUtilities.translate("gui.per_second");
		this.fontRenderer.drawString(status, this.xSize / 2 - this.fontRenderer.getStringWidth(status) / 2, 60, 4210752);
		// status = ElectricityDisplay.getDisplay(this.tileEntity.ueWattsPerTick * 20, ElectricUnit.WATT);
		// this.fontRenderer.drawString(status, this.xSize / 2 - this.fontRenderer.getStringWidth(status) / 2, 70, 4210752);
		// status = ElectricityDisplay.getDisplay(this.tileEntity.getVoltage(), ElectricUnit.VOLTAGE);
		// this.fontRenderer.drawString(status, this.xSize / 2 - this.fontRenderer.getStringWidth(status) / 2, 80, 4210752);
		this.fontRenderer.drawString(TranslateUtilities.translate("container.inventory"), 8, this.ySize - 104 + 17, 4210752);
	}

	private String getStatus() {
		if (this.tileEntity.getStackInSlot(0) == null || !(this.tileEntity.getStackInSlot(0).getItem() instanceof ItemOxygenTank)) {
			return EnumColor.DARK_RED + TranslateUtilities.translate("gui.status.missingtank.name");
		}

		if (this.tileEntity.getStackInSlot(0) != null && this.tileEntity.getStackInSlot(0).getItemDamage() == 0) {
			return EnumColor.DARK_RED + TranslateUtilities.translate("gui.status.fulltank.name");
		}

		if (this.tileEntity.getOxygenStored() < 1.0D) {
			return EnumColor.DARK_RED + TranslateUtilities.translate("gui.status.missingoxygen.name");
		}

		return this.tileEntity.getGUIstatus();
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(GuiUltimateOxygenCompressor.compressorTexture);
		final int var5 = (this.width - this.xSize) / 2;
		final int var6 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(var5, var6 + 5, 0, 0, this.xSize, 181);

		if (this.tileEntity != null) {
			int scale = this.tileEntity.getCappedScaledOxygenLevel(54);
			this.drawTexturedModalRect(var5 + 113, var6 + 25, 197, 7, Math.min(scale, 54), 7);
			scale = this.tileEntity.getScaledElecticalLevel(54);
			this.drawTexturedModalRect(var5 + 113, var6 + 38, 197, 0, Math.min(scale, 54), 7);

			if (this.tileEntity.getEnergyStoredGC() > 0) {
				this.drawTexturedModalRect(var5 + 99, var6 + 37, 176, 0, 11, 10);
			}

			if (this.tileEntity.getOxygenStored() > 0) {
				this.drawTexturedModalRect(var5 + 100, var6 + 24, 187, 0, 10, 10);
			}

			List<String> oxygenDesc = new ArrayList<String>();
			oxygenDesc.add(TranslateUtilities.translate("gui.oxygen_storage.desc.0"));
			oxygenDesc.add(EnumColor.YELLOW + TranslateUtilities.translate("gui.oxygen_storage.desc.1") + ": " + ((int) Math.floor(this.tileEntity.getOxygenStored()) + " / " + (int) Math.floor(this.tileEntity.getMaxOxygenStored())));
			this.oxygenInfoRegion.tooltipStrings = oxygenDesc;

			List<String> electricityDesc = new ArrayList<String>();
			electricityDesc.add(TranslateUtilities.translate("gui.energy_storage.desc.0"));
			EnergyDisplayHelper.getEnergyDisplayTooltip(this.tileEntity.getEnergyStoredGC(), this.tileEntity.getMaxEnergyStoredGC(), electricityDesc);
			// electricityDesc.add(EnumColor.YELLOW + TranslateUtilities.translate("gui.energy_storage.desc.1") + ((int) Math.floor(this.tileEntity.getEnergyStoredGC()) + " / " + (int) Math.floor(this.tileEntity.getMaxEnergyStoredGC())));
			this.electricInfoRegion.tooltipStrings = electricityDesc;
		}
	}
}
