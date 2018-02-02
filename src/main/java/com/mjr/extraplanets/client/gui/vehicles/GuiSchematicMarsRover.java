package com.mjr.extraplanets.client.gui.vehicles;

import micdoodle8.mods.galacticraft.api.recipe.ISchematicResultPage;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.client.gui.container.GuiPositionedContainer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.inventory.vehicles.ContainerSchematicMarsRover;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class GuiSchematicMarsRover extends GuiPositionedContainer implements ISchematicResultPage {
	private static final ResourceLocation marsRoverBenchTexture = new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/mars_roverbench.png");

	private int pageIndex;

	public GuiSchematicMarsRover(InventoryPlayer par1InventoryPlayer, BlockPos pos) {
		super(new ContainerSchematicMarsRover(par1InventoryPlayer, pos), pos);
		this.ySize = 221;
	}

	@Override
	public void initGui() {
		super.initGui();
		this.buttonList.clear();
		this.buttonList.add(new GuiButton(0, this.width / 2 - 130, this.height / 2 - 110, 40, 20, TranslateUtilities.translate("gui.button.back.name")));
		this.buttonList.add(new GuiButton(1, this.width / 2 - 130, this.height / 2 - 110 + 25, 40, 20, TranslateUtilities.translate("gui.button.next.name")));
	}

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		if (par1GuiButton.enabled) {
			switch (par1GuiButton.id) {
			case 0:
				SchematicRegistry.flipToLastPage(this, this.pageIndex);
				break;
			case 1:
				SchematicRegistry.flipToNextPage(this, this.pageIndex);
				break;
			}
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		this.fontRendererObj.drawString(TranslateUtilities.translate("schematic.mars.rover.name"), 7, -20 + 27, 4210752);
		this.fontRendererObj.drawString(TranslateUtilities.translate("container.inventory"), 8, 202 - 104 + 2 + 27, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(GuiSchematicMarsRover.marsRoverBenchTexture);
		final int var5 = (this.width - this.xSize) / 2;
		final int var6 = (this.height - 220) / 2;
		this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, 220);
	}

	@Override
	public void setPageIndex(int index) {
		this.pageIndex = index;
	}
}