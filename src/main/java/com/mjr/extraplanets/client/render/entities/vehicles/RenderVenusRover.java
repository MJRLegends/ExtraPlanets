package com.mjr.extraplanets.client.render.entities.vehicles;

import micdoodle8.mods.galacticraft.core.util.ClientUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJModel;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.entities.vehicles.EntityVenusRover;

@SideOnly(Side.CLIENT)
public class RenderVenusRover extends Render<EntityVenusRover> {
	private OBJModel.OBJBakedModel modelRover;
	private OBJModel.OBJBakedModel modelRoverWindows;
	private OBJModel.OBJBakedModel modelRoverCase1;
	private OBJModel.OBJBakedModel modelRoverCase2;
	private OBJModel.OBJBakedModel modelRoverCase3;

	private OBJModel.OBJBakedModel modelRoverWheelLeft;
	private OBJModel.OBJBakedModel modelRoverWheelRight;

	public RenderVenusRover(RenderManager manager) {
		super(manager);
		this.shadowSize = 0.0F;

	}

	@SuppressWarnings("deprecation")
	private void updateModels() {
		if (modelRover == null) {
			OBJModel model;
			try {
				model = (OBJModel) ModelLoaderRegistry.getModel(new ResourceLocation(Constants.ASSET_PREFIX, "venus_rover.obj"));
				model = (OBJModel) model.process(ImmutableMap.of("flip-v", "true"));
				Function<ResourceLocation, TextureAtlasSprite> spriteFunction = location -> Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());

				modelRover = (OBJModel.OBJBakedModel) model.bake(
						new OBJModel.OBJState(ImmutableList.of("Battery", "Battery2", "BraceFrontWheelLeft", "BraceFrontWheelLeft2", "BraceFrontWheelLeft003", "BraceFrontWheelLeft004", "BraceFrontWheelRight", "BraceFrontWheelRight2",
								"BraceFrontWheelRight003", "BraceFrontWheelRight004", "BraceFrontWheelRight005", "BraceFrontWheelRight006", "Clip1", "Clip2", "door", "doorhandle", "Doorhinge1", "Doorhinge2", "Floor", "Frame2", "Frame003", "RTG",
								"Seat", "Spinka", "Helm", "PoleHelm", "RTGPart1", "RtGPart2", "TRGPart3", "TRGPart4", "TRGPart5", "Line001", "Box002", "Box003"), false), DefaultVertexFormats.ITEM, spriteFunction);

				modelRoverWindows = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("FrontWindow", "LeftWall", "RightWall"), false), DefaultVertexFormats.ITEM, spriteFunction);

				modelRoverCase1 = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("Container"), false), DefaultVertexFormats.ITEM, spriteFunction);
				modelRoverCase2 = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("Container2"), false), DefaultVertexFormats.ITEM, spriteFunction);
				modelRoverCase3 = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("Container3"), false), DefaultVertexFormats.ITEM, spriteFunction);

				model = (OBJModel) ModelLoaderRegistry.getModel(new ResourceLocation(Constants.ASSET_PREFIX, "venus_rover_wheel.obj"));
				model = (OBJModel) model.process(ImmutableMap.of("flip-v", "true"));

				modelRoverWheelLeft = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("Wheel"), false), DefaultVertexFormats.ITEM, spriteFunction);

				model = (OBJModel) ModelLoaderRegistry.getModel(new ResourceLocation(Constants.ASSET_PREFIX, "venus_rover_wheel.obj"));
				model = (OBJModel) model.process(ImmutableMap.of("flip-v", "true"));

				modelRoverWheelRight = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("Wheel"), false), DefaultVertexFormats.ITEM, spriteFunction);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityVenusRover par1Entity) {
		return new ResourceLocation("missing");
	}

	@Override
	public void doRender(EntityVenusRover entity, double par2, double par4, double par6, float par8, float par9) {
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);

		GL11.glPushMatrix();
		final float var24 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * par9;
		GlStateManager.translate((float) par2, (float) par4, (float) par6);
		GL11.glScalef(1.25F, 1.25F, 1.25F);
		GL11.glRotatef(0.0F - par8, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-var24, 0.0F, 0.0F, 1.0F);
		GL11.glScalef(0.51F, 0.51F, 0.51F);

		this.updateModels();
		this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

		if (Minecraft.isAmbientOcclusionEnabled()) {
			GlStateManager.shadeModel(GL11.GL_SMOOTH);
		} else {
			GlStateManager.shadeModel(GL11.GL_FLAT);
		}

		float rotation = entity.wheelRotationX;

		// Front
		GL11.glPushMatrix();
		GlStateManager.translate(0.0F, 1.1F, 2.20F);
		GL11.glRotatef(entity.wheelRotationZ, 0, 1, 0);
		GL11.glRotatef(rotation, 1, 0, 0);
		GlStateManager.translate(4.1F, 0.0F, 0.0F);
		GL11.glScalef(1.5F, 1.9F, 1.9F);
		ClientUtil.drawBakedModel(modelRoverWheelRight);
		GlStateManager.translate(-5.3F, 0.0F, 0.0F);
		ClientUtil.drawBakedModel(modelRoverWheelLeft);
		GL11.glPopMatrix();

		// Back wheels
		GL11.glPushMatrix();
		GlStateManager.translate(0.0F, 1.1F, -4.45F);
		GL11.glRotatef(entity.wheelRotationZ, 0, 1, 0);
		GL11.glRotatef(rotation, 1, 0, 0);
		GlStateManager.translate(4.1F, 0.0F, 0.0F);
		GL11.glScalef(1.5F, 1.9F, 1.9F);
		ClientUtil.drawBakedModel(modelRoverWheelRight);
		GlStateManager.translate(-5.3F, 0.0F, 0.0F);
		ClientUtil.drawBakedModel(modelRoverWheelLeft);
		GL11.glPopMatrix();

		GlStateManager.translate(0.0F, 0.7F, 0.0F);
		ClientUtil.drawBakedModel(modelRover);

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
		ClientUtil.drawBakedModel(modelRoverWindows);
		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ZERO);
		GL11.glDisable(GL11.GL_BLEND);

		if (entity.roverType > 0) {
			ClientUtil.drawBakedModel(modelRoverCase1);

			if (entity.roverType > 1) {
				ClientUtil.drawBakedModel(modelRoverCase2);

				if (entity.roverType > 2) {
					ClientUtil.drawBakedModel(modelRoverCase3);
				}
			}
		}

		GL11.glPopMatrix();
		RenderHelper.enableStandardItemLighting();
	}
}