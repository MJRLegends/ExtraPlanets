package com.mjr.extraplanets.client.render.entities.vehicles;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.entities.vehicles.EntityVenusRover;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderVenusRover extends Render {
	private static final ResourceLocation buggyTextureBody = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blankRocketDarkGrey.png");
	private static final ResourceLocation buggyTextureWheel = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blankRocket.png");
	private static final ResourceLocation buggyTextureStorage = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blankRocket.png");
	private static final ResourceLocation buggyTextureOther = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blankRocketWhite.png");

	private final IModelCustom modelRover;

	public RenderVenusRover(IModelCustom modelRover) {
		this.shadowSize = 2.0F;
		this.modelRover = modelRover;
	}

	protected ResourceLocation func_110779_a(EntityVenusRover par1EntityArrow) {
		return RenderVenusRover.buggyTextureBody;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return this.func_110779_a((EntityVenusRover) par1Entity);
	}

	public void renderRover(EntityVenusRover entity, double par2, double par4, double par6, float par8, float par9) {
		GL11.glPushMatrix();
		final float var24 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * par9;
		GL11.glTranslatef((float) par2, (float) par4 - 2.5F, (float) par6);
		GL11.glScalef(1.25F, 1.25F, 1.25F);
		GL11.glRotatef(0.0F - par8, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-var24, 0.0F, 0.0F, 1.0F);
		GL11.glScalef(0.51F, 0.51F, 0.51F);
		this.bindTexture(RenderVenusRover.buggyTextureWheel);

		float rotation = entity.wheelRotationX;

		// Front
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, -1.0F, -2.7F);
		GL11.glRotatef(entity.wheelRotationZ, 0, 1, 0);
		GL11.glRotatef(rotation, 1, 0, 0);
		GL11.glTranslatef(1.4F, 0.0F, 0.0F);
		this.modelRover.renderPart("WheelFrontRight");
		// this.modelRover.renderPart("WheelFrontLeft");
		GL11.glPopMatrix();
		//
		// // Middle wheels
		// GL11.glPushMatrix();
		// GL11.glTranslatef(0.0F, 0.0F, 0.0F);
		// GL11.glRotatef(-entity.wheelRotationZ, 0, 1, 0);
		// GL11.glRotatef(rotation, 1, 0, 0);
		// GL11.glTranslatef(0.0F, 0.0F, 0.0F);
		// this.modelRover.renderPart("WheelMiddleRight");
		// GL11.glTranslatef(0.0F, 0.0F, 0.0F);
		// this.modelRover.renderPart("WheelMiddleLeft");
		// GL11.glPopMatrix();
		//
		// // Back wheels
		// GL11.glPushMatrix();
		// GL11.glTranslatef(0.0F, 0.0F, 0.0F);
		// GL11.glRotatef(-entity.wheelRotationZ, 0, 1, 0);
		// GL11.glRotatef(rotation, 1, 0, 0);
		// GL11.glTranslatef(0.0F, 0.0F, 0.0F);
		// this.modelRover.renderPart("WheelBackRight");
		// GL11.glTranslatef(0.0F, 0.0F, 0.0F);
		// this.modelRover.renderPart("WheelBackLeft");
		// GL11.glPopMatrix();

		GL11.glTranslatef(0.0F, 0.5F, 0.0F);
		this.bindTexture(RenderVenusRover.buggyTextureBody);
		this.modelRover.renderPart("BraceFrontWheelLeft");
		this.modelRover.renderPart("BraceFrontWheelLeft2");
		this.modelRover.renderPart("BraceFrontWheelLeft003");
		this.modelRover.renderPart("BraceFrontWheelLeft004");
		this.modelRover.renderPart("BraceFrontWheelRight");
		this.modelRover.renderPart("BraceFrontWheelRight2");
		this.modelRover.renderPart("BraceFrontWheelRight003");
		this.modelRover.renderPart("BraceFrontWheelRight004");
		this.modelRover.renderPart("BraceFrontWheelRight005");
		this.modelRover.renderPart("BraceFrontWheelRight006");
		this.modelRover.renderPart("Frame");
		this.modelRover.renderPart("Frame2");
		this.modelRover.renderPart("GlassFront");
		this.modelRover.renderPart("GlassPaneRoof");
		this.modelRover.renderPart("Helm");
		this.modelRover.renderPart("PoleHelm");
		this.modelRover.renderPart("Box001");
		this.bindTexture(RenderVenusRover.buggyTextureOther);
		this.modelRover.renderPart("Box002");
		this.modelRover.renderPart("Box003");

		this.bindTexture(RenderVenusRover.buggyTextureStorage);

//		if (entity.roverType > 0) {
//			this.modelRover.renderPart("Box001");
//
//			if (entity.roverType > 1) {
//				this.modelRover.renderPart("Box002");
//
//				if (entity.roverType > 2) {
//					this.modelRover.renderPart("Box003");
//				}
//			}
//		}

		GL11.glPopMatrix();
	}

	@Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.renderRover((EntityVenusRover) par1Entity, par2, par4, par6, par8, par9);
	}
}