package com.mjr.extraplanets.client.render.block;

import micdoodle8.mods.galacticraft.api.tile.IFuelDock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.api.IPowerDock;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class BlockRendererCustomLandingPad implements ISimpleBlockRenderingHandler {
	final int renderID;

	public BlockRendererCustomLandingPad(int var1) {
		this.renderID = var1;
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess var1, int var2, int var3, int var4, Block var5, int var6, RenderBlocks var7) {
		this.renderBlockLandingPad(var7, var5, var1, var2, var3, var4);
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return this.renderID;
	}

	public static void renderInvNormalBlock(RenderBlocks var0, Block var1, int var2) {
		final Tessellator var3 = Tessellator.instance;
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		var0.setRenderBounds(0.15F, 0.15F, 0.15F, 0.85F, 0.85F, 0.85F);
		var3.startDrawingQuads();
		var3.setNormal(0.0F, -0.8F, 0.0F);
		var0.renderFaceYNeg(var1, 0.0D, 0.0D, 0.0D, var1.getIcon(0, var2));
		var3.draw();
		var3.startDrawingQuads();
		var3.setNormal(0.0F, 0.8F, 0.0F);
		var0.renderFaceYPos(var1, 0.0D, 0.0D, 0.0D, var1.getIcon(1, var2));
		var3.draw();
		var3.startDrawingQuads();
		var3.setNormal(0.0F, 0.0F, -0.8F);
		var0.renderFaceXPos(var1, 0.0D, 0.0D, 0.0D, var1.getIcon(2, var2));
		var3.draw();
		var3.startDrawingQuads();
		var3.setNormal(0.0F, 0.0F, 0.8F);
		var0.renderFaceXNeg(var1, 0.0D, 0.0D, 0.0D, var1.getIcon(3, var2));
		var3.draw();
		var3.startDrawingQuads();
		var3.setNormal(-0.8F, 0.0F, 0.0F);
		var0.renderFaceZNeg(var1, 0.0D, 0.0D, 0.0D, var1.getIcon(4, var2));
		var3.draw();
		var3.startDrawingQuads();
		var3.setNormal(0.8F, 0.0F, 0.0F);
		var0.renderFaceZPos(var1, 0.0D, 0.0D, 0.0D, var1.getIcon(5, var2));
		var3.draw();
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		BlockRendererCustomLandingPad.renderInvNormalBlock(renderer, block, metadata);
	}

	public void renderBlockLandingPad(RenderBlocks renderBlocks, Block par1Block, IBlockAccess var1, int par2, int par3, int par4) {
		renderBlocks.setRenderBounds(-1F, 0F, -1F, 4F, 0.2F, 4F);
		renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);

		if (var1.getBlockMetadata(par2, par3, par4) == 0) {
			renderBlocks.setRenderBounds(0.5F, 0.2F, 0.5F, 2.5F, 0.3F, 2.5F);
			renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
			renderBlocks.setRenderBounds(1F, 0.3F, 1F, 2F, 0.4F, 2F);
			renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
		}
		if (var1.getBlockMetadata(par2, par3, par4) == 1) {
			renderBlocks.setRenderBounds(0.5F, 0.2F, 0.5F, 2.5F, 0.3F, 2.5F);
			renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
			renderBlocks.setRenderBounds(1F, 0.3F, 1F, 2F, 0.4F, 2F);
			renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
		}
		if (var1.getBlockMetadata(par2, par3, par4) != 2){
			IFuelDock landingPad = (IFuelDock) var1.getTileEntity(par2, par3, par4);
			if (landingPad != null) {
				if (landingPad.isBlockAttachable(var1, par2 + 4, par3, par4 - 1)) {
					renderBlocks.setRenderBounds(3.5F, 0.2F, -0.9F, 4.0F, 0.901F, -0.1F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2 + 4, par3, par4)) {
					renderBlocks.setRenderBounds(3.5F, 0.2F, 0.1F, 4.0F, 0.901F, 0.9F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2 + 4, par3, par4 + 1)) {
					renderBlocks.setRenderBounds(3.5F, 0.2F, 1.1F, 4.0F, 0.901F, 1.9F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2 + 4, par3, par4 + 2)) {
					renderBlocks.setRenderBounds(3.5F, 0.2F, 2.1F, 4.0F, 0.901F, 2.9F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2 + 4, par3, par4 + 3)) {
					renderBlocks.setRenderBounds(3.5F, 0.2F, 3.1F, 4.0F, 0.901F, 3.9F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				
				if (landingPad.isBlockAttachable(var1, par2-2, par3, par4 - 1)) {
					renderBlocks.setRenderBounds(-1.5F, 0.2F, -0.9F, -0.5F, 0.901F, -0.1F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2-2, par3, par4)) {
					renderBlocks.setRenderBounds(-1.5F, 0.2F, 0.1F, -0.5F, 0.901F, 0.9F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2-2, par3, par4 + 1)) {
					renderBlocks.setRenderBounds(-1.5F, 0.2F, 1.1F, -0.5F, 0.901F, 1.9F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2-2, par3, par4 + 2)) {
					renderBlocks.setRenderBounds(-1.5F, 0.2F, 2.1F, -0.5F, 0.901F, 2.9F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2-2, par3, par4 + 3)) {
					renderBlocks.setRenderBounds(-1.5F, 0.2F, 3.1F, -0.5F, 0.901F, 3.9F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				
				if (landingPad.isBlockAttachable(var1, par2 + 3, par3, par4 - 2)) {
					renderBlocks.setRenderBounds(3.1F, 0.2F, -1.0F, 3.9F, 0.901F, -0.5F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2 + 2, par3, par4 - 2)) {
					renderBlocks.setRenderBounds(2.1F, 0.2F, -1.0F, 2.9F, 0.901F, -0.5F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2 + 1, par3, par4 - 2)) {
					renderBlocks.setRenderBounds(1.1F, 0.2F, -1.0F, 1.9F, 0.901F, -0.5F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2, par3, par4 - 2)) {
					renderBlocks.setRenderBounds(0.1F, 0.2F, -1.0F, 0.9F, 0.901F, -0.5F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2 - 1, par3, par4 - 2)) {
					renderBlocks.setRenderBounds(-0.9F, 0.2F, -1.0F, -0.1F, 0.901F, -0.5F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				
				if (landingPad.isBlockAttachable(var1, par2 + 3, par3, par4 + 4)) {
					renderBlocks.setRenderBounds(3.1F, 0.2F, 3.5F, 3.9F, 0.901F, 4.0F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2 + 2, par3, par4 + 4)) {
					renderBlocks.setRenderBounds(2.1F, 0.2F, 3.5F, 2.9F, 0.901F, 4.0F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2 + 1, par3, par4 + 4)) {
					renderBlocks.setRenderBounds(1.1F, 0.2F, 3.5F, 1.9F, 0.901F, 4.0F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2, par3, par4 + 4)) {
					renderBlocks.setRenderBounds(0.1F, 0.2F, 3.5F, 0.9F, 0.901F, 4.0F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2 - 1, par3, par4 + 4)) {
					renderBlocks.setRenderBounds(-0.9F, 0.2F, 3.5F, -0.1F, 0.901F, 4.0F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
			}
		}
		else{
			IPowerDock landingPad = (IPowerDock) var1.getTileEntity(par2, par3, par4);
			if (landingPad != null) {
				if (landingPad.isBlockAttachable(var1, par2 + 4, par3, par4 - 1)) {
					renderBlocks.setRenderBounds(3.5F, 0.2F, -0.9F, 4.0F, 0.901F, -0.1F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2 + 4, par3, par4)) {
					renderBlocks.setRenderBounds(3.5F, 0.2F, 0.1F, 4.0F, 0.901F, 0.9F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2 + 4, par3, par4 + 1)) {
					renderBlocks.setRenderBounds(3.5F, 0.2F, 1.1F, 4.0F, 0.901F, 1.9F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2 + 4, par3, par4 + 2)) {
					renderBlocks.setRenderBounds(3.5F, 0.2F, 2.1F, 4.0F, 0.901F, 2.9F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2 + 4, par3, par4 + 3)) {
					renderBlocks.setRenderBounds(3.5F, 0.2F, 3.1F, 4.0F, 0.901F, 3.9F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				
				if (landingPad.isBlockAttachable(var1, par2-2, par3, par4 - 1)) {
					renderBlocks.setRenderBounds(-1.5F, 0.2F, -0.9F, -0.5F, 0.901F, -0.1F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2-2, par3, par4)) {
					renderBlocks.setRenderBounds(-1.5F, 0.2F, 0.1F, -0.5F, 0.901F, 0.9F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2-2, par3, par4 + 1)) {
					renderBlocks.setRenderBounds(-1.5F, 0.2F, 1.1F, -0.5F, 0.901F, 1.9F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2-2, par3, par4 + 2)) {
					renderBlocks.setRenderBounds(-1.5F, 0.2F, 2.1F, -0.5F, 0.901F, 2.9F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2-2, par3, par4 + 3)) {
					renderBlocks.setRenderBounds(-1.5F, 0.2F, 3.1F, -0.5F, 0.901F, 3.9F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				
				if (landingPad.isBlockAttachable(var1, par2 + 3, par3, par4 - 2)) {
					renderBlocks.setRenderBounds(3.1F, 0.2F, -1.0F, 3.9F, 0.901F, -0.5F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2 + 2, par3, par4 - 2)) {
					renderBlocks.setRenderBounds(2.1F, 0.2F, -1.0F, 2.9F, 0.901F, -0.5F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2 + 1, par3, par4 - 2)) {
					renderBlocks.setRenderBounds(1.1F, 0.2F, -1.0F, 1.9F, 0.901F, -0.5F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2, par3, par4 - 2)) {
					renderBlocks.setRenderBounds(0.1F, 0.2F, -1.0F, 0.9F, 0.901F, -0.5F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2 - 1, par3, par4 - 2)) {
					renderBlocks.setRenderBounds(-0.9F, 0.2F, -1.0F, -0.1F, 0.901F, -0.5F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				
				if (landingPad.isBlockAttachable(var1, par2 + 3, par3, par4 + 4)) {
					renderBlocks.setRenderBounds(3.1F, 0.2F, 3.5F, 3.9F, 0.901F, 4.0F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2 + 2, par3, par4 + 4)) {
					renderBlocks.setRenderBounds(2.1F, 0.2F, 3.5F, 2.9F, 0.901F, 4.0F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2 + 1, par3, par4 + 4)) {
					renderBlocks.setRenderBounds(1.1F, 0.2F, 3.5F, 1.9F, 0.901F, 4.0F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2, par3, par4 + 4)) {
					renderBlocks.setRenderBounds(0.1F, 0.2F, 3.5F, 0.9F, 0.901F, 4.0F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
				if (landingPad.isBlockAttachable(var1, par2 - 1, par3, par4 + 4)) {
					renderBlocks.setRenderBounds(-0.9F, 0.2F, 3.5F, -0.1F, 0.901F, 4.0F);
					renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
				}
			}
		}

		renderBlocks.clearOverrideBlockTexture();
		par1Block.setBlockBoundsForItemRender();
		renderBlocks.uvRotateTop = 0;
	}
}
