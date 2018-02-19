package com.mjr.extraplanets.client.render.entities.vehicles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IFlexibleBakedModel;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.google.common.collect.ImmutableList;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.entities.vehicles.EntityMarsRover;
import com.mjr.mjrlegendslib.util.ModelUtilities;

@SideOnly(Side.CLIENT)
public class RenderMarsRover extends Render<EntityMarsRover> {
	private IFlexibleBakedModel modelRover;
	private IFlexibleBakedModel modelRoverWindows;
	private IFlexibleBakedModel modelRoverCase1;
	private IFlexibleBakedModel modelRoverCase2;
	private IFlexibleBakedModel modelRoverCase3;

	private IFlexibleBakedModel modelRoverWheelLeft;
	private IFlexibleBakedModel modelRoverWheelRight;

	public RenderMarsRover(RenderManager manager) {
		super(manager);
		this.shadowSize = 0.0F;
	}

	private void updateModels() {
		if (modelRover == null) {
			try {
				modelRover = ModelUtilities.modelFromOBJ(new ResourceLocation(Constants.ASSET_PREFIX, "mars_rover.obj"), ImmutableList.of("RoofRover", "FloorRover", "Clip1", "Clip2", "AxisBack", "AxisFront", "AxisFront001", "AxisMiddle",
						"FrameSegment010", "FrameSegment011", "FrameSegment012", "FrameSegment013", "FrameSegment014", "FrameSegment015", "FrameSegment021", "FrameSegment022", "FrameSegment023", "FrameSegment024", "FrameSegment025",
						"FrameSegment026", "FrameSegment027", "FrameSegment028", "FrameSegment029", "FrameSegment030", "FrameSegment031", "FrameSegment032", "FrameSegment033", "FrameSegment044", "FrameSegment045", "FrameSegment046",
						"FrameSegment047", "FrameSegment048", "FrameSegment049", "FrameSegment050", "FrameSegment051", "FrameSegment052", "FrameSegment053", "FrameSegment054", "FrameSegment055", "FrameSegment056", "FrameSegment057",
						"FrameSegment058", "FrameSegment059", "Line001", "HelmKeeper", "Helm", "Seat", "Seat001", "SolarPanel", "PoleSolarPanel", "SolarPanelBlock", "Wire", "Battery", "Line002", "WindowBack", "WindowFragment3", "Lightning",
						"Lightning2", "CaseBack1", "CaseBack2", "CaseBack3", "SolarPlane"));

				modelRoverWindows = ModelUtilities.modelFromOBJ(new ResourceLocation(Constants.ASSET_PREFIX, "mars_rover.obj"), ImmutableList.of("WindowFront1", "WindowFront2"));
				modelRoverCase1 = ModelUtilities.modelFromOBJ(new ResourceLocation(Constants.ASSET_PREFIX, "mars_rover.obj"), ImmutableList.of("Container"));
				modelRoverCase2 = ModelUtilities.modelFromOBJ(new ResourceLocation(Constants.ASSET_PREFIX, "mars_rover.obj"), ImmutableList.of("Container2"));
				modelRoverCase3 = ModelUtilities.modelFromOBJ(new ResourceLocation(Constants.ASSET_PREFIX, "mars_rover.obj"), ImmutableList.of("Container3"));

				modelRoverWheelLeft = ModelUtilities.modelFromOBJ(new ResourceLocation(Constants.ASSET_PREFIX, "mars_rover_wheel.obj"), ImmutableList.of("Wheel"));
				modelRoverWheelRight = ModelUtilities.modelFromOBJ(new ResourceLocation(Constants.ASSET_PREFIX, "mars_rover_wheel.obj"), ImmutableList.of("Wheel"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityMarsRover par1Entity) {
		return TextureMap.locationBlocksTexture;
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
		this.bindTexture(TextureMap.locationBlocksTexture);

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
		ModelUtilities.drawBakedModel(modelRoverWheelRight);
		GlStateManager.translate(-3.9F, 0.0F, 0.0F);
		ModelUtilities.drawBakedModel(modelRoverWheelLeft);
		GL11.glPopMatrix();

		// Middle wheels
		GL11.glPushMatrix();
		GlStateManager.translate(0.0F, 1.2F, -0.2F);
		GL11.glRotatef(entity.wheelRotationZ, 0, 1, 0);
		GL11.glRotatef(rotation, 1, 0, 0);
		GlStateManager.translate(1.9F, 0.0F, 0.0F);
		ModelUtilities.drawBakedModel(modelRoverWheelRight);
		GlStateManager.translate(-3.7F, 0.0F, 0.0F);
		ModelUtilities.drawBakedModel(modelRoverWheelLeft);
		GL11.glPopMatrix();

		// Back wheels
		GL11.glPushMatrix();
		GlStateManager.translate(0.0F, 1.2F, -3.7F);
		GL11.glRotatef(entity.wheelRotationZ, 0, 1, 0);
		GL11.glRotatef(rotation, 1, 0, 0);
		GlStateManager.translate(1.9F, 0.0F, 0.0F);
		ModelUtilities.drawBakedModel(modelRoverWheelRight);
		GlStateManager.translate(-3.7F, 0.0F, 0.0F);
		ModelUtilities.drawBakedModel(modelRoverWheelLeft);
		GL11.glPopMatrix();

		GlStateManager.translate(0.0F, 0.7F, 0.0F);
		ModelUtilities.drawBakedModel(modelRover);

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
		ModelUtilities.drawBakedModel(modelRoverWindows);
		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ZERO);
		GL11.glDisable(GL11.GL_BLEND);

		if (entity.roverType > 0) {
			ModelUtilities.drawBakedModel(modelRoverCase1);

			if (entity.roverType > 1) {
				ModelUtilities.drawBakedModel(modelRoverCase2);

				if (entity.roverType > 2) {
					ModelUtilities.drawBakedModel(modelRoverCase3);
				}
			}
		}

		GL11.glPopMatrix();
		RenderHelper.enableStandardItemLighting();
	}
}