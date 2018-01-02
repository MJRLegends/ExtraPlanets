package com.mjr.extraplanets.client.render.tile;

import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.core.client.model.block.ModelSolarPanel;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

import com.mjr.extraplanets.blocks.machines.BlockSolar;
import com.mjr.extraplanets.tileEntities.machines.TileEntitySolar;

public class TileEntitySolarPanelRenderer extends TileEntitySpecialRenderer<TileEntitySolar> {
	private static final ResourceLocation solarPanelAdvTexture = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/solar_panel_advanced.png");
	public ModelSolarPanel model = new ModelSolarPanel();

	@Override
	public void renderTileEntityAt(TileEntitySolar panel, double par2, double par4, double par6, float partialTickTime, int par9) {
		if (panel.getBlockMetadata() >= BlockSolar.HYBRID_METADATA) {
			this.bindTexture(TileEntitySolarPanelRenderer.solarPanelAdvTexture);
		} else {
			this.bindTexture(TileEntitySolarPanelRenderer.solarPanelAdvTexture);
		}

		GlStateManager.pushMatrix();
		GlStateManager.enableRescaleNormal();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.translate((float) par2, (float) par4, (float) par6);

		GlStateManager.translate(0.5F, 1.0F, 0.5F);
		this.model.renderPole();
		GlStateManager.translate(0.0F, 1.5F, 0.0F);

		GlStateManager.rotate(180.0F, 0, 0, 1);
		GlStateManager.rotate(-90.0F, 0, 1, 0);

		float celestialAngle = (panel.getWorld().getCelestialAngle(1.0F) - 0.784690560F) * 360.0F;
		float celestialAngle2 = panel.getWorld().getCelestialAngle(1.0F) * 360.0F;

		GlStateManager.rotate(panel.currentAngle - (celestialAngle - celestialAngle2), 1.0F, 0.0F, 0.0F);

		this.model.renderPanel();

		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	}
}