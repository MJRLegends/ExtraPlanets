package com.mjr.extraplanets.client.render.entities.vehicles;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.entities.vehicles.EntityMarsRover;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMarsRover extends Render {
	private static final ResourceLocation buggyTextureBody = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blankRocketDarkGrey.png");
	private static final ResourceLocation buggyTextureWheel = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blankRocketDarkGrey.png");
	private static final ResourceLocation buggyTextureStorage = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blankRocketDarkGrey.png");

	private final IModelCustom modelRover;

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
		GL11.glTranslatef((float) par2, (float) par4 - 2.5F, (float) par6);
		GL11.glScalef(1.25F, 1.25F, 1.25F);
		GL11.glRotatef(180.0F - par8, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-var24, 0.0F, 0.0F, 1.0F);
		GL11.glScalef(0.51F, 0.51F, 0.51F);
		this.bindTexture(RenderMarsRover.buggyTextureWheel);

		float rotation = entity.wheelRotationX;

		// Front
		GL11.glPushMatrix();
		GL11.glRotatef(entity.wheelRotationZ, 0, 1, 0);
		GL11.glRotatef(rotation, 1, 0, 0);
		this.modelRover.renderPart("WheelFrontRight");
		this.modelRover.renderPart("WheelFrontLeft");
		GL11.glPopMatrix();

		// Middle wheels
		GL11.glPushMatrix();
		GL11.glRotatef(-entity.wheelRotationZ, 0, 1, 0);
		GL11.glRotatef(rotation, 1, 0, 0);
		this.modelRover.renderPart("WheelMiddleRight");
		this.modelRover.renderPart("WheelMiddleLeft");
		GL11.glPopMatrix();

		// Back wheels
		GL11.glPushMatrix();
		GL11.glRotatef(-entity.wheelRotationZ, 0, 1, 0);
		GL11.glRotatef(rotation, 1, 0, 0);
		this.modelRover.renderPart("WheelBackRight");
		this.modelRover.renderPart("WheelBackLeft");
		GL11.glPopMatrix();

		this.bindTexture(RenderMarsRover.buggyTextureBody);
		this.modelRover.renderPart("AxisFront001");
		this.modelRover.renderPart("AxisMiddle");
		this.modelRover.renderPart("Clip1");
		this.modelRover.renderPart("Clip2");
		this.modelRover.renderPart("FloorRover");
		this.modelRover.renderPart("FrameSegment1");
		this.modelRover.renderPart("FrameSegment2");
		this.modelRover.renderPart("FrameSegment3");
		this.modelRover.renderPart("FrameSegment10");
		this.modelRover.renderPart("FrameSegment11");
		this.modelRover.renderPart("FrameSegment12");
		this.modelRover.renderPart("FrameSegment13");
		this.modelRover.renderPart("FrameSegment14");
		this.modelRover.renderPart("FrameSegment15");
		this.modelRover.renderPart("FrameSegment16");
		this.modelRover.renderPart("FrameSegment17");
		this.modelRover.renderPart("FrameSegment18");
		this.modelRover.renderPart("FrameSegment20");
		this.modelRover.renderPart("FrameSegment21");
		this.modelRover.renderPart("FrameSegment22");
		this.modelRover.renderPart("FrameSegment23");
		this.modelRover.renderPart("FrameSegment24");
		this.modelRover.renderPart("FrameSegment25");
		this.modelRover.renderPart("FrameSegment26");
		this.modelRover.renderPart("FrameSegment27");
		this.modelRover.renderPart("FrameSegment28");
		this.modelRover.renderPart("FrameSegment29");
		this.modelRover.renderPart("FrameSegment30");
		this.modelRover.renderPart("FrameSegment31");
		this.modelRover.renderPart("FrameSegment32");
		this.modelRover.renderPart("FrameSegment33");
		this.modelRover.renderPart("FrameSegment44");
		this.modelRover.renderPart("FrameSegment45");
		this.modelRover.renderPart("FrameSegment46");
		this.modelRover.renderPart("FrameSegment47");
		this.modelRover.renderPart("FrameSegment48");
		this.modelRover.renderPart("FrameSegment49");
		this.modelRover.renderPart("FrameSegment50");
		this.modelRover.renderPart("FrameSegment51");
		this.modelRover.renderPart("FrameSegment52");
		this.modelRover.renderPart("FrameSegment53");
		this.modelRover.renderPart("FrameSegment54");
		this.modelRover.renderPart("GlaasBack003");
		this.modelRover.renderPart("GlaasBack1");
		this.modelRover.renderPart("Helm");
		this.modelRover.renderPart("HelmKeeper");
		this.modelRover.renderPart("Line001");
		this.modelRover.renderPart("PoleSolarPanel");
		this.modelRover.renderPart("RoofRover");
		this.modelRover.renderPart("Seat");
		this.modelRover.renderPart("Seat001");
		this.modelRover.renderPart("SolarPanel");
		this.modelRover.renderPart("SolarPanelBlock");

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