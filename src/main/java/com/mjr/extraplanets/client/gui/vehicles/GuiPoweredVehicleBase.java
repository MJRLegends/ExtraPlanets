package com.mjr.extraplanets.client.gui.vehicles;

import micdoodle8.mods.galacticraft.core.client.gui.container.GuiContainerGC;
import micdoodle8.mods.galacticraft.core.util.EnumColor;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.entities.vehicles.EntityPoweredVehicleBase;
import com.mjr.extraplanets.inventory.vehicles.ContainerPoweredVehicleBase;
import com.mjr.mjrlegendslib.util.MCUtilities;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

@SideOnly(Side.CLIENT)
public class GuiPoweredVehicleBase extends GuiContainerGC {
	private static ResourceLocation[] sealerTexture = new ResourceLocation[4];

	static {
		for (int i = 0; i < 4; i++) {
			GuiPoweredVehicleBase.sealerTexture[i] = new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/powered_vehicle_" + i * 18 + ".png");
		}
	}

	private final IInventory upperChestInventory;
	private final int type;

	public GuiPoweredVehicleBase(IInventory par1IInventory, IInventory par2IInventory, int type) {
		super(new ContainerPoweredVehicleBase(par1IInventory, par2IInventory, type, MCUtilities.getClient().player));
		this.upperChestInventory = par1IInventory;
		this.allowUserInput = false;
		this.type = type;
		this.ySize = 145 + this.type * 36;
	}

	@Override
	public void initGui() {
		super.initGui();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		this.fontRendererObj.drawString(TranslateUtilities.translate("gui.message.power.name"), 8, 2 + 3, 4210752);
		this.fontRendererObj.drawString(TranslateUtilities.translate(this.upperChestInventory.getName()), 8, this.type == 0 ? 50 : 39, 4210752);

		if (this.mc.player != null && this.mc.player.getRidingEntity() != null && this.mc.player.getRidingEntity() instanceof EntityPoweredVehicleBase) {
			this.fontRendererObj.drawString(TranslateUtilities.translate("gui.message.power.message.name") + ":", 130, 15 + 3, 4210752);
			final int percentage = (int) (((EntityPoweredVehicleBase) this.mc.player.getRidingEntity()).getCurrentPowerCapacity() / 100);
			final String color = percentage > 80.0D ? EnumColor.BRIGHT_GREEN.getCode() : percentage > 40.0D ? EnumColor.ORANGE.getCode() : EnumColor.RED.getCode();
			final String str = percentage + "% ";
			this.fontRendererObj.drawString(color + str, 140 - str.length() / 2, 20 + 8, 4210752);
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		this.mc.getTextureManager().bindTexture(GuiPoweredVehicleBase.sealerTexture[this.type]);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		final int var5 = (this.width - this.xSize) / 2;
		final int var6 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(var5, var6, 0, 0, 176, this.ySize);

		if (this.mc.player != null && this.mc.player.getRidingEntity() != null && this.mc.player.getRidingEntity() instanceof EntityPoweredVehicleBase) {
			final int percentage = (int) ((int) (((EntityPoweredVehicleBase) this.mc.player.getRidingEntity()).getCurrentPowerCapacity() / 100) / 2.6);
			this.drawTexturedModalRect((this.width - this.xSize) / 2 + 95, (this.height - this.ySize) / 2 + 45 - percentage, 176, 38 - percentage, 25, percentage);
		}
	}
}