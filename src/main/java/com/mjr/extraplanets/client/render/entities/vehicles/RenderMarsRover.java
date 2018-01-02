package com.mjr.extraplanets.client.render.entities.vehicles;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.entities.vehicles.EntityMarsRover;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMarsRover extends Render {
	private static final ResourceLocation buggyTextureBody = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket_dark_grey.png");
	private static final ResourceLocation buggyTextureWheel = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket_black.png");
	private static final ResourceLocation buggyTextureStorage = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket.png");
	private static final ResourceLocation buggyTextureOther = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket_white.png");
	private static final ResourceLocation buggyTextureOther2 = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket_orange_textured.png");
	private static final ResourceLocation buggyTextureOther3 = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket_textured.png");
	private static final ResourceLocation buggyTextureOther4 = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket_light_blue_textured.png");
	private static final ResourceLocation buggyTextureOther5 = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket_blue_textured.png");
	private static final ResourceLocation buggyTextureBatteryBolt = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket_yellow.png");

	private final IModelCustom modelRover;
	private final IModelCustom modelRoverWheelLeft = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/MarsRover-Wheel.obj"));
	private final IModelCustom modelRoverWheelRight = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/MarsRover-Wheel.obj"));

	public RenderMarsRover(IModelCustom modelRover) {
		this.shadowSize = 2.0F;
		this.modelRover = modelRover;
	}

	protected ResourceLocation func_110779_a(EntityMarsRover par1EntityArrow) {
		return RenderMarsRover.buggyTextureBody;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return this.func_110779_a((EntityMarsRover) par1Entity);
	}

	public void renderRover(EntityMarsRover entity, double par2, double par4, double par6, float par8, float par9) {
		GL11.glPushMatrix();
		final float var24 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * par9;
		GL11.glTranslatef((float) par2, (float) par4 - 2.8F, (float) par6);
		GL11.glScalef(1.25F, 1.25F, 1.25F);
		GL11.glRotatef(-180.0F - par8, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-var24, 0.0F, 0.0F, 1.0F);
		GL11.glScalef(0.51F, 0.51F, 0.51F);
		this.bindTexture(RenderMarsRover.buggyTextureWheel);

		float rotation = entity.wheelRotationX;

		// Front
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, 1.2F, 2.2F);
		GL11.glRotatef(entity.wheelRotationZ, 0, 1, 0);
		GL11.glRotatef(rotation, 1, 0, 0);
		GL11.glTranslatef(2.0F, 0.0F, 0.0F);
		this.modelRoverWheelRight.renderPart("Wheel");
		GL11.glTranslatef(-3.9F, 0.0F, 0.0F);
		this.modelRoverWheelLeft.renderPart("Wheel");
		GL11.glPopMatrix();

		// Middle wheels
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, 1.2F, -0.2F);
		GL11.glRotatef(entity.wheelRotationZ, 0, 1, 0);
		GL11.glRotatef(rotation, 1, 0, 0);
		GL11.glTranslatef(1.9F, 0.0F, 0.0F);
		this.modelRoverWheelRight.renderPart("Wheel");
		GL11.glTranslatef(-3.7F, 0.0F, 0.0F);
		this.modelRoverWheelLeft.renderPart("Wheel");
		GL11.glPopMatrix();

		// Back wheels
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, 1.2F, -3.7F);
		GL11.glRotatef(entity.wheelRotationZ, 0, 1, 0);
		GL11.glRotatef(rotation, 1, 0, 0);
		GL11.glTranslatef(1.9F, 0.0F, 0.0F);
		this.modelRoverWheelRight.renderPart("Wheel");
		GL11.glTranslatef(-3.7F, 0.0F, 0.0F);
		this.modelRoverWheelLeft.renderPart("Wheel");
		GL11.glPopMatrix();

		GL11.glTranslatef(0.0F, 0.7F, 0.0F);
		this.bindTexture(RenderMarsRover.buggyTextureBody);
		this.modelRover.renderPart("RoofRover");
		this.modelRover.renderPart("FloorRover");
		this.bindTexture(RenderMarsRover.buggyTextureOther2);
		this.modelRover.renderPart("Clip1");
		this.modelRover.renderPart("Clip2");
		this.bindTexture(RenderMarsRover.buggyTextureStorage);
		this.modelRover.renderPart("AxisBack");
		this.modelRover.renderPart("AxisFront");
		this.modelRover.renderPart("AxisFront001");
		this.modelRover.renderPart("AxisMiddle");
		this.bindTexture(RenderMarsRover.buggyTextureStorage);
		this.modelRover.renderPart("FrameSegment010");
		this.modelRover.renderPart("FrameSegment011");
		this.modelRover.renderPart("FrameSegment012");
		this.modelRover.renderPart("FrameSegment013");
		this.modelRover.renderPart("FrameSegment014");
		this.modelRover.renderPart("FrameSegment015");
		this.modelRover.renderPart("FrameSegment021");
		this.modelRover.renderPart("FrameSegment022");
		this.modelRover.renderPart("FrameSegment023");
		this.modelRover.renderPart("FrameSegment024");
		this.modelRover.renderPart("FrameSegment025");
		this.modelRover.renderPart("FrameSegment026");
		this.modelRover.renderPart("FrameSegment027");
		this.modelRover.renderPart("FrameSegment028");
		this.modelRover.renderPart("FrameSegment029");
		this.modelRover.renderPart("FrameSegment030");
		this.modelRover.renderPart("FrameSegment031");
		this.modelRover.renderPart("FrameSegment032");
		this.modelRover.renderPart("FrameSegment033");
		this.modelRover.renderPart("FrameSegment044");
		this.modelRover.renderPart("FrameSegment045");
		this.modelRover.renderPart("FrameSegment046");
		this.modelRover.renderPart("FrameSegment047");
		this.modelRover.renderPart("FrameSegment048");
		this.modelRover.renderPart("FrameSegment049");
		this.modelRover.renderPart("FrameSegment050");
		this.modelRover.renderPart("FrameSegment051");
		this.modelRover.renderPart("FrameSegment052");
		this.modelRover.renderPart("FrameSegment053");
		this.modelRover.renderPart("FrameSegment054");
		this.modelRover.renderPart("FrameSegment055");
		this.modelRover.renderPart("FrameSegment056");
		this.modelRover.renderPart("FrameSegment057");
		this.modelRover.renderPart("FrameSegment058");
		this.modelRover.renderPart("FrameSegment059");
		this.modelRover.renderPart("Line001");
		this.bindTexture(RenderMarsRover.buggyTextureWheel);
		this.modelRover.renderPart("HelmKeeper");
		this.bindTexture(RenderMarsRover.buggyTextureOther);
		this.modelRover.renderPart("Helm");
		this.modelRover.renderPart("Seat");
		this.modelRover.renderPart("Seat001");
		this.bindTexture(RenderMarsRover.buggyTextureBody);
		this.modelRover.renderPart("SolarPanel");
		this.bindTexture(RenderMarsRover.buggyTextureOther4);
		this.modelRover.renderPart("PoleSolarPanel");
		this.bindTexture(RenderMarsRover.buggyTextureWheel);
		this.modelRover.renderPart("SolarPanelBlock");
		this.bindTexture(RenderMarsRover.buggyTextureOther3);
		this.modelRover.renderPart("Wire");
		this.bindTexture(RenderMarsRover.buggyTextureOther5);
		this.modelRover.renderPart("Battery");
		this.bindTexture(RenderMarsRover.buggyTextureBody);
		this.modelRover.renderPart("Line002");
		this.bindTexture(RenderMarsRover.buggyTextureStorage);
		this.modelRover.renderPart("CaseBack1");
		this.modelRover.renderPart("CaseBack2");
		this.modelRover.renderPart("CaseBack3");
		this.bindTexture(RenderMarsRover.buggyTextureBody);
		this.modelRover.renderPart("WindowBack");
		this.modelRover.renderPart("WindowFragment3");
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
		this.modelRover.renderPart("WindowFront1");
		this.modelRover.renderPart("WindowFront2");
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);

		this.bindTexture(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/solar_panel.png"));
		this.modelRover.renderPart("SolarPlane");

		this.bindTexture(RenderMarsRover.buggyTextureBatteryBolt);
		this.modelRover.renderPart("Lightning");
		this.modelRover.renderPart("Lightning2");

		this.bindTexture(RenderMarsRover.buggyTextureStorage);

		if (entity.roverType > 0) {
			this.modelRover.renderPart("Container");

			if (entity.roverType > 1) {
				this.modelRover.renderPart("Container2");

				if (entity.roverType > 2) {
					this.modelRover.renderPart("Container3");
				}
			}
		}

		GL11.glPopMatrix();
	}

	@Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.renderRover((EntityMarsRover) par1Entity, par2, par4, par6, par8, par9);
	}
}