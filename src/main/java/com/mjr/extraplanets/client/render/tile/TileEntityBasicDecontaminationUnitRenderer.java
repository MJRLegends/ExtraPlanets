package com.mjr.extraplanets.client.render.tile;

import org.lwjgl.opengl.GL11;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicDecontaminationUnit;
import com.mjr.mjrlegendslib.util.MCUtilities;
import com.mjr.mjrlegendslib.util.ModelUtilities;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJModel;

public class TileEntityBasicDecontaminationUnitRenderer extends TileEntitySpecialRenderer<TileEntityBasicDecontaminationUnit> {
	private static OBJModel.OBJBakedModel mainModel;

	@SuppressWarnings("deprecation")
	private void updateModels() {
		if (mainModel == null) {
			try {
				OBJModel model = (OBJModel) ModelLoaderRegistry.getModel(new ResourceLocation(Constants.ASSET_PREFIX, "block/basic_decontamination_unit.obj"));
				model = (OBJModel) model.process(ImmutableMap.of("flip-v", "true"));

				Function<ResourceLocation, TextureAtlasSprite> spriteFunction = location -> MCUtilities.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());
				mainModel = (OBJModel.OBJBakedModel) model.bake(
						new OBJModel.OBJState(ImmutableList.of("Body", "Water_Baloons", "AtomizersOne", "AtomizersThree", "AtomizersFive", "AtomizersSix", "AtomizersFour", "The_back_wall", "AtomaziersTwo"), false), DefaultVertexFormats.ITEM,
						spriteFunction);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public void render(TileEntityBasicDecontaminationUnit te, double x, double y, double z, float partialTickTime, int par9, float alpha) {
		GlStateManager.disableRescaleNormal();
		GL11.glPushMatrix();
		this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
		if (Minecraft.isAmbientOcclusionEnabled()) {
			GlStateManager.shadeModel(GL11.GL_SMOOTH);
		} else {
			GlStateManager.shadeModel(GL11.GL_FLAT);
		}
		updateModels();

		GL11.glTranslatef((float) x + 0.5F, (float) y, (float) z + 0.5F);

		GL11.glScalef(0.21F, 0.15F, 0.15F);

		ModelUtilities.drawBakedModel(mainModel);

		GL11.glPopMatrix();
		RenderHelper.enableStandardItemLighting();
	}
}
