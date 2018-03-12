package com.mjr.extraplanets.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public abstract class ArmorCustomModel extends ModelBiped {

	public ArmorCustomModel() {
		super(1.0F);
	}

	public int color = -1;

	public abstract void pre();

	public abstract void post();

	public abstract void partHead();

	public abstract void partBody();

	public abstract void partRightArm();

	public abstract void partLeftArm();

	public abstract void partRightLeg();

	public abstract void partLeftLeg();

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		GL11.glPushMatrix();
		if (color != -1) {
			float red = (color >> 16 & 255) / 255F;
			float blue = (color >> 8 & 255) / 255F;
			float green = (color & 255) / 255F;
			GL11.glColor3f(red, blue, green);
		}

		pre();
		GL11.glScalef(1.1F, 1.1F, 1.1F);
		float f6 = 4.0F;
		{// partHead
			GL11.glPushMatrix();
			if (isChild) {
				GL11.glScalef(1.5F / f6, 1.5F / f6, 1.5F / f6);
				GL11.glTranslatef(0.0F, 16.0F * scale, 0.0F);
			}
			GL11.glTranslatef(bipedHead.rotationPointX * scale, bipedHead.rotationPointY * scale, bipedHead.rotationPointZ * scale);
			GL11.glRotatef(bipedHead.rotateAngleZ * (180F / (float) Math.PI), 0F, 0F, 1F);
			GL11.glRotatef(bipedHead.rotateAngleY * (180F / (float) Math.PI), 0F, 1F, 0F);
			GL11.glRotatef(bipedHead.rotateAngleX * (180F / (float) Math.PI), 1F, 0F, 0F);
			GL11.glRotatef(180F, 1F, 0F, 0F);
			GL11.glRotatef(180F, 0F, 1F, 0F);
			if (isSneak) {
				GL11.glTranslatef(0F, -0.125F, 0F);
				if (bipedHead.rotateAngleX < 0.48)
					GL11.glRotatef(-bipedHead.rotateAngleX * 2, 1F, 0F, 0F);
				else if (bipedHead.rotateAngleX > 0.48)
					GL11.glTranslatef(0F, bipedHead.rotateAngleX / 10, -bipedHead.rotateAngleX / 10);
			}
			partHead();
			GL11.glPopMatrix();
		}

		if (isChild) {
			GL11.glPushMatrix();
			GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
			GL11.glTranslatef(0.0F, 24.0F * scale, 0.0F);
		}

		{// partBody
			GL11.glPushMatrix();
			GL11.glTranslatef(bipedBody.rotationPointX * scale, bipedBody.rotationPointY * scale, bipedBody.rotationPointZ * scale);
			GL11.glRotatef(bipedBody.rotateAngleZ * (180F / (float) Math.PI), 0F, 0F, 1F);
			GL11.glRotatef(bipedBody.rotateAngleY * (180F / (float) Math.PI), 0F, 1F, 0F);
			GL11.glRotatef(bipedBody.rotateAngleX * (180F / (float) Math.PI), 1F, 0F, 0F);
			GL11.glRotatef(180F, 1F, 0F, 0F);
			GL11.glRotatef(180F, 0F, 1F, 0F);
			if (isSneak)
				GL11.glTranslatef(0F, -0.20F, -0.1F);
			partBody();
			GL11.glPopMatrix();
		}

		{// partRightArm
			GL11.glPushMatrix();
			GL11.glTranslatef(bipedRightArm.rotationPointX * scale, bipedRightArm.rotationPointY * scale, bipedRightArm.rotationPointZ * scale);
			GL11.glRotatef(bipedRightArm.rotateAngleZ * (180F / (float) Math.PI), 0F, 0F, 1F);
			GL11.glRotatef(bipedRightArm.rotateAngleY * (180F / (float) Math.PI), 0F, 1F, 0F);
			GL11.glRotatef(bipedRightArm.rotateAngleX * (180F / (float) Math.PI), 1F, 0F, 0F);
			GL11.glRotatef(180F, 1F, 0F, 0F);
			GL11.glRotatef(180F, 0F, 1F, 0F);
			if (isSneak)
				GL11.glTranslatef(-0.04F, -0.1F, -0.10F + limbSwingAmount / 10);
			partRightArm();
			GL11.glPopMatrix();
		}

		{// partLeftArm
			GL11.glPushMatrix();
			GL11.glTranslatef(bipedLeftArm.rotationPointX * scale, bipedLeftArm.rotationPointY * scale, bipedLeftArm.rotationPointZ * scale);
			GL11.glRotatef(bipedLeftArm.rotateAngleZ * (180F / (float) Math.PI), 0F, 0F, 1F);
			GL11.glRotatef(bipedLeftArm.rotateAngleY * (180F / (float) Math.PI), 0F, 1F, 0F);
			GL11.glRotatef(bipedLeftArm.rotateAngleX * (180F / (float) Math.PI), 1F, 0F, 0F);
			GL11.glRotatef(180F, 1F, 0F, 0F);
			GL11.glRotatef(180F, 0F, 1F, 0F);
			if (isSneak)
				GL11.glTranslatef(0.04F, -0.1F, -0.15F + limbSwingAmount / 10);
			partLeftArm();
			GL11.glPopMatrix();
		}

		{// partRightLeg
			GL11.glPushMatrix();
			GL11.glTranslatef(bipedRightLeg.rotationPointX * scale, bipedRightLeg.rotationPointY * scale, bipedRightLeg.rotationPointZ * scale);
			GL11.glRotatef(-bipedRightLeg.rotateAngleZ * (180F / (float) Math.PI), 0F, 0F, 1F);
			GL11.glRotatef(-bipedRightLeg.rotateAngleY * (180F / (float) Math.PI), 0F, 1F, 0F);
			GL11.glRotatef(-bipedRightLeg.rotateAngleX * (180F / (float) Math.PI), 1F, 0F, 0F);
			GL11.glRotatef(180F, 1F, 0F, 0F);
			GL11.glRotatef(180F, 0F, 1F, 0F);
			if (isSneak)
				GL11.glTranslatef(0F, -0.225F, -0.10F);
			partRightLeg();
			GL11.glPopMatrix();
		}

		{// partLeftLeg
			GL11.glPushMatrix();
			GL11.glTranslatef(bipedLeftLeg.rotationPointX * scale, bipedLeftLeg.rotationPointY * scale, bipedLeftLeg.rotationPointZ * scale);
			GL11.glRotatef(-bipedLeftLeg.rotateAngleZ * (180F / (float) Math.PI), 0F, 0F, 1F);
			GL11.glRotatef(-bipedLeftLeg.rotateAngleY * (180F / (float) Math.PI), 0F, 1F, 0F);
			GL11.glRotatef(-bipedLeftLeg.rotateAngleX * (180F / (float) Math.PI), 1F, 0F, 0F);
			GL11.glRotatef(180F, 1F, 0F, 0F);
			GL11.glRotatef(180F, 0F, 1F, 0F);
			if (isSneak)
				GL11.glTranslatef(0F, -0.225F, -0.10F);
			partLeftLeg();
			GL11.glPopMatrix();
		}

		if (isChild) {
			GL11.glPopMatrix();
		}
		post();
		// GL11.glColor3f(1F, 1F, 1F);
		GL11.glPopMatrix();
	}
}