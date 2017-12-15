package com.mjr.extraplanets.client.render.tile;

import micdoodle8.mods.galacticraft.core.client.model.block.ModelTreasureChest;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.tileEntities.treasureChests.TileEntityT10TreasureChest;

@SideOnly(Side.CLIENT)
public class TileEntityT10TreasureChestRenderer extends TileEntitySpecialRenderer<TileEntityT10TreasureChest> {
	private static final ResourceLocation treasureChestTexture = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/treasure_t10.png");

	private final ModelTreasureChest chestModel = new ModelTreasureChest();

	@Override
	public void renderTileEntityAt(TileEntityT10TreasureChest chest, double par2, double par4, double par6, float partialTickTime, int par9) {
		int var9;

		if (!chest.hasWorldObj()) {
			var9 = 0;
		} else {
			final Block var10 = chest.getBlockType();
			var9 = chest.getBlockMetadata();

			if (var10 != null && var9 == 0) {
				var9 = chest.getBlockMetadata();
			}
		}

		ModelTreasureChest var14 = null;

		var14 = this.chestModel;
		this.bindTexture(TileEntityT10TreasureChestRenderer.treasureChestTexture);

		GlStateManager.pushMatrix();
		GlStateManager.enableRescaleNormal();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.translate((float) par2, (float) par4 + 1.0F, (float) par6 + 1.0F);
		GlStateManager.scale(1.0F, -1.0F, -1.0F);
		GlStateManager.translate(0.5F, 0.5F, 0.5F);
		short var11 = 0;

		if (var9 == 2) {
			var11 = 180;
		}

		if (var9 == 3) {
			var11 = 0;
		}

		if (var9 == 4) {
			var11 = 90;
		}

		if (var9 == 5) {
			var11 = -90;
		}

		GlStateManager.rotate(var11, 0.0F, 1.0F, 0.0F);
		GlStateManager.translate(-0.5F, -0.5F, -0.5F);
		float var12 = chest.prevLidAngle + (chest.lidAngle - chest.prevLidAngle) * partialTickTime;

		var12 = 1.0F - var12;
		var12 = 1.0F - var12 * var12 * var12;

		if (var14 != null) {
			var14.chestLid.rotateAngleX = -(var12 * Constants.floatPI / 4.0F);
			var14.renderAll(!chest.locked);
		}

		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	}
}
