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
import com.mjr.extraplanets.entities.vehicles.EntityMarsRover;

@SideOnly(Side.CLIENT)
public class RenderMarsRover extends Render<EntityMarsRover> {
	private OBJModel.OBJBakedModel modelRover;
	private OBJModel.OBJBakedModel modelRoverWindows;
	private OBJModel.OBJBakedModel modelRoverCase1;
	private OBJModel.OBJBakedModel modelRoverCase2;
	private OBJModel.OBJBakedModel modelRoverCase3;

	private OBJModel.OBJBakedModel modelRoverWheelLeft;
	private OBJModel.OBJBakedModel modelRoverWheelRight;

	public RenderMarsRover(RenderManager manager) {
		super(manager);
		this.shadowSize = 0.0F;

	}

	@SuppressWarnings("deprecation")
	private void updateModels() {
		if (modelRover == null) {
			OBJModel model;
			try {
				model = (OBJModel) ModelLoaderRegistry.getModel(new ResourceLocation(Constants.ASSET_PREFIX, "mars_rover.obj"));
				model = (OBJModel) model.process(ImmutableMap.of("flip-v", "true"));
				Function<ResourceLocation, TextureAtlasSprite> spriteFunction = location -> Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());

				modelRover = (OBJModel.OBJBakedModel) model.bake(
						new OBJModel.OBJState(ImmutableList.of("RoofRover", "FloorRover", "Clip1", "Clip2", "AxisBack", "AxisFront", "AxisFront001", "AxisMiddle", "FrameSegment010", "FrameSegment011", "FrameSegment012", "FrameSegment013",
								"FrameSegment014", "FrameSegment015", "FrameSegment021", "FrameSegment022", "FrameSegment023", "FrameSegment024", "FrameSegment025", "FrameSegment026", "FrameSegment027", "FrameSegment028", "FrameSegment029",
								"FrameSegment030", "FrameSegment031", "FrameSegment032", "FrameSegment033", "FrameSegment044", "FrameSegment045", "FrameSegment046", "FrameSegment047", "FrameSegment048", "FrameSegment049", "FrameSegment050",
								"FrameSegment051", "FrameSegment052", "FrameSegment053", "FrameSegment054", "FrameSegment055", "FrameSegment056", "FrameSegment057", "FrameSegment058", "FrameSegment059", "Line001", "HelmKeeper", "Helm", "Seat",
								"Seat001", "SolarPanel", "PoleSolarPanel", "SolarPanelBlock", "Wire", "Battery", "Line002", "WindowBack", "WindowFragment3", "Lightning", "Lightning2", "CaseBack1", "CaseBack2", "CaseBack3", "SolarPlane"), false),
						DefaultVertexFormats.ITEM, spriteFunction);

				modelRoverWindows = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("WindowFront1", "WindowFront2"), false), DefaultVertexFormats.ITEM, spriteFunction);

				modelRoverCase1 = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("Container"), false), DefaultVertexFormats.ITEM, spriteFunction);
				modelRoverCase2 = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("Container2"), false), DefaultVertexFormats.ITEM, spriteFunction);
				modelRoverCase3 = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("Container3"), false), DefaultVertexFormats.ITEM, spriteFunction);

				model = (OBJModel) ModelLoaderRegistry.getModel(new ResourceLocation(Constants.ASSET_PREFIX, "mars_rover_wheel.obj"));
				model = (OBJModel) model.process(ImmutableMap.of("flip-v", "true"));

				modelRoverWheelLeft = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("Wheel"), false), DefaultVertexFormats.ITEM, spriteFunction);

				model = (OBJModel) ModelLoaderRegistry.getModel(new ResourceLocation(Constants.ASSET_PREFIX, "mars_rover_wheel.obj"));
				model = (OBJModel) model.process(ImmutableMap.of("flip-v", "true"));

				modelRoverWheelRight = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("Wheel"), false), DefaultVertexFormats.ITEM, spriteFunction);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityMarsRover par1Entity) {
		return new ResourceLocation("missing");
	}

	@Override
	public void doRender(EntityMarsRover entity, double par2, double par4, double par6, float par8, float par9) {
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);

		GL11.glPushMatrix();
		final float var24 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * par9;
		GlStateManager.translate((float) par2, (float) par4 - 0.3F, (float) par6);
		GL11.glScalef(1.25F, 1.25F, 1.25F);
		GL11.glRotatef(-180.0F - par8, 0.0F, 1.0F, 0.0F);
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
		GlStateManager.translate(0.0F, 1.2F, 2.2F);
		GL11.glRotatef(entity.wheelRotationZ, 0, 1, 0);
		GL11.glRotatef(rotation, 1, 0, 0);
		GlStateManager.translate(2.0F, 0.0F, 0.0F);
		ClientUtil.drawBakedModel(modelRoverWheelRight);
		GlStateManager.translate(-3.9F, 0.0F, 0.0F);
		ClientUtil.drawBakedModel(modelRoverWheelLeft);
		GL11.glPopMatrix();

		// Middle wheels
		GL11.glPushMatrix();
		GlStateManager.translate(0.0F, 1.2F, -0.2F);
		GL11.glRotatef(entity.wheelRotationZ, 0, 1, 0);
		GL11.glRotatef(rotation, 1, 0, 0);
		GlStateManager.translate(1.9F, 0.0F, 0.0F);
		ClientUtil.drawBakedModel(modelRoverWheelRight);
		GlStateManager.translate(-3.7F, 0.0F, 0.0F);
		ClientUtil.drawBakedModel(modelRoverWheelLeft);
		GL11.glPopMatrix();

		// Back wheels
		GL11.glPushMatrix();
		GlStateManager.translate(0.0F, 1.2F, -3.7F);
		GL11.glRotatef(entity.wheelRotationZ, 0, 1, 0);
		GL11.glRotatef(rotation, 1, 0, 0);
		GlStateManager.translate(1.9F, 0.0F, 0.0F);
		ClientUtil.drawBakedModel(modelRoverWheelRight);
		GlStateManager.translate(-3.7F, 0.0F, 0.0F);
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