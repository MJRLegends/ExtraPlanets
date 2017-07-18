package com.mjr.extraplanets.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public abstract class ArmorCustomModel extends ModelBiped {

	public int color = -1;

	public abstract void pre();

	public abstract void post();

	public abstract void partHead();

	public abstract void partBody();

	public abstract void partRightArm();

	public abstract void partLeftArm();

	public abstract void partRightLeg();

	public abstract void partLeftLeg();

	public void render(Entity entity, float x, float y, float z, float yaw, float pitch, float parTicks) {
		super.render(entity, x, y, z, yaw, pitch, parTicks);
		GL11.glPushMatrix();
		if (color != -1) {
			float red = (float) (color >> 16 & 255) / 255F;
			float blue = (float) (color >> 8 & 255) / 255F;
			float green = (float) (color & 255) / 255F;
			GL11.glColor3f(red, blue, green);
		}

		pre();
		float f6 = 2.0F;

		{// partHead
			GL11.glPushMatrix();
			if (isChild) {
				GL11.glScalef(1.5F / f6, 1.5F / f6, 1.5F / f6);
				GL11.glTranslatef(0.0F, 16.0F * parTicks, 0.0F);
			}
			GL11.glTranslatef(bipedHead.rotationPointX * parTicks, bipedHead.rotationPointY * parTicks, bipedHead.rotationPointZ * parTicks);
			GL11.glRotatef(bipedHead.rotateAngleZ * (180F / (float) Math.PI), 0F, 0F, 1F);
			GL11.glRotatef(bipedHead.rotateAngleY * (180F / (float) Math.PI), 0F, 1F, 0F);
			GL11.glRotatef(bipedHead.rotateAngleX * (180F / (float) Math.PI), 1F, 0F, 0F);
			GL11.glRotatef(180F, 1F, 0F, 0F);
			partHead();
			GL11.glPopMatrix();
		}

		if (isChild) {
			GL11.glPushMatrix();
			GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
			GL11.glTranslatef(0.0F, 24.0F * parTicks, 0.0F);
		}

		{// partBody
			GL11.glPushMatrix();
			GL11.glTranslatef(bipedBody.rotationPointX * parTicks, bipedBody.rotationPointY * parTicks, bipedBody.rotationPointZ * parTicks);
			GL11.glRotatef(bipedBody.rotateAngleZ * (180F / (float) Math.PI), 0F, 0F, 1F);
			GL11.glRotatef(bipedBody.rotateAngleY * (180F / (float) Math.PI), 0F, 1F, 0F);
			GL11.glRotatef(bipedBody.rotateAngleX * (180F / (float) Math.PI), 1F, 0F, 0F);
			GL11.glRotatef(180F, 1F, 0F, 0F);
			partBody();
			GL11.glPopMatrix();
		}

		{// partRightArm
			GL11.glPushMatrix();
			GL11.glTranslatef(bipedRightArm.rotationPointX * parTicks, bipedRightArm.rotationPointY * parTicks, bipedRightArm.rotationPointZ * parTicks);
			GL11.glRotatef(bipedRightArm.rotateAngleZ * (180F / (float) Math.PI), 0F, 0F, 1F);
			GL11.glRotatef(bipedRightArm.rotateAngleY * (180F / (float) Math.PI), 0F, 1F, 0F);
			GL11.glRotatef(bipedRightArm.rotateAngleX * (180F / (float) Math.PI), 1F, 0F, 0F);
			GL11.glRotatef(180F, 1F, 0F, 0F);
			partRightArm();
			GL11.glPopMatrix();
		}

		{// partLeftArm
			GL11.glPushMatrix();
			GL11.glTranslatef(bipedLeftArm.rotationPointX * parTicks, bipedLeftArm.rotationPointY * parTicks, bipedLeftArm.rotationPointZ * parTicks);
			GL11.glRotatef(bipedLeftArm.rotateAngleZ * (180F / (float) Math.PI), 0F, 0F, 1F);
			GL11.glRotatef(bipedLeftArm.rotateAngleY * (180F / (float) Math.PI), 0F, 1F, 0F);
			GL11.glRotatef(bipedLeftArm.rotateAngleX * (180F / (float) Math.PI), 1F, 0F, 0F);
			GL11.glRotatef(180F, 1F, 0F, 0F);
			partLeftArm();
			GL11.glPopMatrix();
		}

		{// partRightLeg
			GL11.glPushMatrix();
			GL11.glTranslatef(bipedRightLeg.rotationPointX * parTicks, bipedRightLeg.rotationPointY * parTicks, bipedRightLeg.rotationPointZ * parTicks);
			GL11.glRotatef(bipedRightLeg.rotateAngleZ * (180F / (float) Math.PI), 0F, 0F, 1F);
			GL11.glRotatef(bipedRightLeg.rotateAngleY * (180F / (float) Math.PI), 0F, 1F, 0F);
			GL11.glRotatef(bipedRightLeg.rotateAngleX * (180F / (float) Math.PI), 1F, 0F, 0F);
			GL11.glRotatef(180F, 1F, 0F, 0F);
			partRightLeg();
			GL11.glPopMatrix();
		}

		{// partLeftLeg
			GL11.glPushMatrix();
			GL11.glTranslatef(bipedLeftLeg.rotationPointX * parTicks, bipedLeftLeg.rotationPointY * parTicks, bipedLeftLeg.rotationPointZ * parTicks);
			GL11.glRotatef(bipedLeftLeg.rotateAngleZ * (180F / (float) Math.PI), 0F, 0F, 1F);
			GL11.glRotatef(bipedLeftLeg.rotateAngleY * (180F / (float) Math.PI), 0F, 1F, 0F);
			GL11.glRotatef(bipedLeftLeg.rotateAngleX * (180F / (float) Math.PI), 1F, 0F, 0F);
			GL11.glRotatef(180F, 1F, 0F, 0F);
			partLeftLeg();
			GL11.glPopMatrix();
		}

		if (isChild) {
			GL11.glPopMatrix();
		}
		post();
		GL11.glColor3f(1F, 1F, 1F);
		GL11.glPopMatrix();
	}
}