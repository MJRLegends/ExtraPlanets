package com.mjr.extraplanets.client.render.entities.vehicles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.google.common.collect.ImmutableList;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.entities.vehicles.EntityVenusRover;
import com.mjr.mjrlegendslib.util.ModelUtilities;

@SideOnly(Side.CLIENT)
public class RenderVenusRover extends Render<EntityVenusRover> {
	private IBakedModel modelRover;
	private IBakedModel modelRoverWindows;
	private IBakedModel modelRoverCase1;
	private IBakedModel modelRoverCase2;
	private IBakedModel modelRoverCase3;

	private IBakedModel modelRoverWheelLeft;
	private IBakedModel modelRoverWheelRight;

	public RenderVenusRover(RenderManager manager) {
		super(manager);
		this.shadowSize = 0.0F;

	}

	@SuppressWarnings("deprecation")
	private void updateModels() {
		if (modelRover == null) {
			try {
				modelRover = ModelUtilities.modelFromOBJ(new ResourceLocation(Constants.ASSET_PREFIX, "venus_rover.obj"), ImmutableList.of("Battery", "Battery2", "BraceFrontWheelLeft", "BraceFrontWheelLeft2", "BraceFrontWheelLeft003",
						"BraceFrontWheelLeft004", "BraceFrontWheelRight", "BraceFrontWheelRight2", "BraceFrontWheelRight003", "BraceFrontWheelRight004", "BraceFrontWheelRight005", "BraceFrontWheelRight006", "Clip1", "Clip2", "door", "doorhandle",
						"Doorhinge1", "Doorhinge2", "Floor", "Frame2", "Frame003", "RTG", "Seat", "Spinka", "Helm", "PoleHelm", "RTGPart1", "RtGPart2", "TRGPart3", "TRGPart4", "TRGPart5", "Line001", "Box002", "Box003"));

				modelRoverWindows = ModelUtilities.modelFromOBJ(new ResourceLocation(Constants.ASSET_PREFIX, "venus_rover.obj"), ImmutableList.of("FrontWindow", "LeftWall", "RightWall"));
				modelRoverCase1 = ModelUtilities.modelFromOBJ(new ResourceLocation(Constants.ASSET_PREFIX, "venus_rover.obj"), ImmutableList.of("Container"));
				modelRoverCase2 = ModelUtilities.modelFromOBJ(new ResourceLocation(Constants.ASSET_PREFIX, "venus_rover.obj"), ImmutableList.of("Container2"));
				modelRoverCase3 = ModelUtilities.modelFromOBJ(new ResourceLocation(Constants.ASSET_PREFIX, "venus_rover.obj"), ImmutableList.of("Container3"));

				modelRoverWheelLeft = ModelUtilities.modelFromOBJ(new ResourceLocation(Constants.ASSET_PREFIX, "venus_rover_wheel.obj"), ImmutableList.of("Wheel"));
				modelRoverWheelRight = ModelUtilities.modelFromOBJ(new ResourceLocation(Constants.ASSET_PREFIX, "venus_rover_wheel.obj"), ImmutableList.of("Wheel"));
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
		ModelUtilities.drawBakedModel(modelRoverWheelRight);
		GlStateManager.translate(-5.3F, 0.0F, 0.0F);
		ModelUtilities.drawBakedModel(modelRoverWheelLeft);
		GL11.glPopMatrix();

		// Back wheels
		GL11.glPushMatrix();
		GlStateManager.translate(0.0F, 1.1F, -4.45F);
		GL11.glRotatef(entity.wheelRotationZ, 0, 1, 0);
		GL11.glRotatef(rotation, 1, 0, 0);
		GlStateManager.translate(4.1F, 0.0F, 0.0F);
		GL11.glScalef(1.5F, 1.9F, 1.9F);
		ModelUtilities.drawBakedModel(modelRoverWheelRight);
		GlStateManager.translate(-5.3F, 0.0F, 0.0F);
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