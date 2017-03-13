package com.mjr.extraplanets.client.gui;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.core.client.gui.container.GuiContainerGC;
import micdoodle8.mods.galacticraft.core.client.gui.element.GuiElementInfoRegion;
import micdoodle8.mods.galacticraft.core.energy.EnergyDisplayHelper;
import micdoodle8.mods.galacticraft.core.util.EnumColor;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.inventory.machines.ContainerBasicCrystallizer;
import com.mjr.extraplanets.tile.machines.TileEntityBasicCrystallizer;

@SideOnly(Side.CLIENT)
public class GuiBasicCrystallizer extends GuiContainerGC {
	private static final ResourceLocation decrystallizerTexture = new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/decrystallizer.png");

	private final TileEntityBasicCrystallizer tileEntity;

	private GuiElementInfoRegion inputTankRegion = new GuiElementInfoRegion((this.width - this.xSize) / 2 + 153, (this.height - this.ySize) / 2 + 28, 16, 38, new ArrayList<String>(), this.width, this.height, this);
	private GuiElementInfoRegion electricInfoRegion = new GuiElementInfoRegion((this.width - this.xSize) / 2 + 62, (this.height - this.ySize) / 2 + 16, 56, 9, new ArrayList<String>(), this.width, this.height, this);

	public GuiBasicCrystallizer(InventoryPlayer par1InventoryPlayer, TileEntityBasicCrystallizer tileEntity) {
		super(new ContainerBasicCrystallizer(par1InventoryPlayer, tileEntity, FMLClientHandler.instance().getClient().thePlayer));
		this.tileEntity = tileEntity;
		this.ySize = 168;
	}

	@Override
	public void initGui() {
		super.initGui();
		List<String> batterySlotDesc = new ArrayList<String>();
		batterySlotDesc.add(GCCoreUtil.translate("gui.battery_slot.desc.0"));
		batterySlotDesc.add(GCCoreUtil.translate("gui.battery_slot.desc.1"));
		this.infoRegions.add(new GuiElementInfoRegion((this.width - this.xSize) / 2 + 49, (this.height - this.ySize) / 2 + 50, 18, 18, batterySlotDesc, this.width, this.height, this));
		List<String> inputTankDesc = new ArrayList<String>();
		inputTankDesc.add(GCCoreUtil.translate("gui.fuel_tank.desc.4"));
		int fuelLevel = this.tileEntity.inputTank != null && this.tileEntity.inputTank.getFluid() != null ? this.tileEntity.inputTank.getFluid().amount : 0;
		int fuelCapacity = this.tileEntity.inputTank != null ? this.tileEntity.inputTank.getCapacity() : 0;
		inputTankDesc.add(EnumColor.YELLOW + GCCoreUtil.translate("gui.message.fuel.name") + ": " + fuelLevel + " / " + fuelCapacity);
		this.inputTankRegion.tooltipStrings = inputTankDesc;
		this.inputTankRegion.xPosition = (this.width - this.xSize) / 2 + 7;
		this.inputTankRegion.yPosition = (this.height - this.ySize) / 2 + 28;
		this.inputTankRegion.parentWidth = this.width;
		this.inputTankRegion.parentHeight = this.height;
		this.infoRegions.add(this.inputTankRegion);
		List<String> fuelSlotDesc = new ArrayList<String>();
		fuelSlotDesc.add(GCCoreUtil.translate("gui.fuel_output.desc.0"));
		fuelSlotDesc.add(GCCoreUtil.translate("gui.fuel_output.desc.1"));
		fuelSlotDesc.add(GCCoreUtil.translate("gui.fuel_output.desc.2"));
		this.infoRegions.add(new GuiElementInfoRegion((this.width - this.xSize) / 2 + 152, (this.height - this.ySize) / 2 + 6, 18, 18, fuelSlotDesc, this.width, this.height, this));
		List<String> electricityDesc = new ArrayList<String>();
		electricityDesc.add(GCCoreUtil.translate("gui.energy_storage.desc.0"));
		electricityDesc.add(EnumColor.YELLOW + GCCoreUtil.translate("gui.energy_storage.desc.1") + ((int) Math.floor(this.tileEntity.getEnergyStoredGC()) + " / " + (int) Math.floor(this.tileEntity.getMaxEnergyStoredGC())));
		this.electricInfoRegion.tooltipStrings = electricityDesc;
		this.electricInfoRegion.xPosition = (this.width - this.xSize) / 2 + 62;
		this.electricInfoRegion.yPosition = (this.height - this.ySize) / 2 + 16;
		this.electricInfoRegion.parentWidth = this.width;
		this.electricInfoRegion.parentHeight = this.height;
		this.infoRegions.add(this.electricInfoRegion);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		GCCoreUtil.drawStringCentered(this.tileEntity.getName(), this.xSize / 2, 5, 4210752, this.fontRendererObj);
		String displayText = "";
		int yOffset = -10;

		if (this.tileEntity.canProcess()) {
			displayText = EnumColor.BRIGHT_GREEN + GCCoreUtil.translate("gui.status.crystallizing.name");
		} else {
			displayText = EnumColor.RED + GCCoreUtil.translate("gui.status.idle.name");
		}

		this.fontRendererObj.drawString(GCCoreUtil.translate("gui.message.status.name") + ": " + displayText, 65 - displayText.length(), 45 + 23 + yOffset, 4210752);
		this.fontRendererObj.drawString(GCCoreUtil.translate("container.inventory"), 8, this.ySize - 118 + 2 + 23, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		this.mc.renderEngine.bindTexture(GuiBasicCrystallizer.decrystallizerTexture);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		int containerWidth = (this.width - this.xSize) / 2;
		int containerHeight = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(containerWidth, containerHeight, 0, 0, this.xSize, this.ySize);

		int displayInt = this.tileEntity.getScaledFuelLevel(38);
		this.drawTexturedModalRect((this.width - this.xSize) / 2 + 153, (this.height - this.ySize) / 2 + 17 + 49 - displayInt, 176 + 16, 38 - displayInt, 16, displayInt);

		List<String> inputTankDesc = new ArrayList<String>();
		inputTankDesc.add(GCCoreUtil.translate("gui.salt_water_tank.desc.4"));
		int fuelLevel = this.tileEntity.inputTank != null && this.tileEntity.inputTank.getFluid() != null ? this.tileEntity.inputTank.getFluid().amount : 0;
		int fuelCapacity = this.tileEntity.inputTank != null ? this.tileEntity.inputTank.getCapacity() : 0;
		inputTankDesc.add(EnumColor.YELLOW + GCCoreUtil.translate("gui.message.salt_water.name") + ": " + fuelLevel + " / " + fuelCapacity);
		this.inputTankRegion.tooltipStrings = inputTankDesc;

		List<String> electricityDesc = new ArrayList<String>();
		electricityDesc.add(GCCoreUtil.translate("gui.energy_storage.desc.0"));
		EnergyDisplayHelper.getEnergyDisplayTooltip(this.tileEntity.getEnergyStoredGC(), this.tileEntity.getMaxEnergyStoredGC(), electricityDesc);
		this.electricInfoRegion.tooltipStrings = electricityDesc;

		if (this.tileEntity.getEnergyStoredGC() > 0) {
			this.drawTexturedModalRect(containerWidth + 49, containerHeight + 16, 208, 0, 11, 10);
		}

		this.drawTexturedModalRect(containerWidth + 63, containerHeight + 17, 176, 38, Math.min(this.tileEntity.getScaledElecticalLevel(54), 54), 7);
	}
}