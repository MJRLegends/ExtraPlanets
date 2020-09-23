package com.mjr.extraplanets.client.model.bosses;

import com.mjr.extraplanets.entities.bosses.EntityEvolvedMagmaCubeBoss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelEvolvedMagmaCubeBoss extends ModelBase {
	ModelRenderer[] segments = new ModelRenderer[8];
	ModelRenderer core;

	public ModelEvolvedMagmaCubeBoss() {
		for (int i = 0; i < this.segments.length; ++i) {
			int j = 0;
			int k = i;

			if (i == 2) {
				j = 24;
				k = 10;
			} else if (i == 3) {
				j = 24;
				k = 19;
			}

			this.segments[i] = new ModelRenderer(this, j, k);
			this.segments[i].addBox(-4.0F, (float) (16 + i), -4.0F, 8, 1, 8);
		}

		this.core = new ModelRenderer(this, 0, 16);
		this.core.addBox(-2.0F, 18.0F, -2.0F, 4, 4, 4);
	}

	/**
	 * Used for easily adding entity-dependent animations. The second and third float params here are the same second and third as in the setRotationAngles method.
	 */
	public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
		EntityEvolvedMagmaCubeBoss EntityEvolvedMagmaCube = (EntityEvolvedMagmaCubeBoss) entitylivingbaseIn;
		float f = EntityEvolvedMagmaCube.prevSquishFactor + (EntityEvolvedMagmaCube.squishFactor - EntityEvolvedMagmaCube.prevSquishFactor) * partialTickTime;

		if (f < 0.0F) {
			f = 0.0F;
		}

		for (int i = 0; i < this.segments.length; ++i) {
			this.segments[i].rotationPointY = (float) (-(4 - i)) * f * 1.7F;
		}
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		this.core.render(scale);

		for (ModelRenderer modelrenderer : this.segments) {
			modelrenderer.render(scale);
		}
	}
}