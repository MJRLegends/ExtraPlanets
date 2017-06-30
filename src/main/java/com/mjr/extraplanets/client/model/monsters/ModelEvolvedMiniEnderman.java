package com.mjr.extraplanets.client.model.monsters;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEvolvedMiniEnderman extends ModelBase {
	// fields
	ModelRenderer Head;
	ModelRenderer Headwear;
	ModelRenderer Body;
	ModelRenderer RightArm;
	ModelRenderer LeftArm;
	ModelRenderer RightLeg;
	ModelRenderer LeftLeg;

	public ModelEvolvedMiniEnderman() {
		textureWidth = 64;
		textureHeight = 32;

		this.Head = new ModelRenderer(this, 0, 0);
		this.Head.addBox(-4F, -8F, -4F, 8, 8, 8);
		this.Head.setRotationPoint(0F, 1F, 0F);
		this.Head.setTextureSize(64, 32);
		this.Head.mirror = true;
		setRotation(this.Head, 0F, 0F, 0F);
		this.Headwear = new ModelRenderer(this, 0, 16);
		this.Headwear.addBox(-4F, -8F, -4F, 8, 8, 8);
		this.Headwear.setRotationPoint(0F, 1F, 0F);
		this.Headwear.setTextureSize(64, 32);
		this.Headwear.mirror = true;
		setRotation(this.Headwear, 0F, 0F, 0F);
		this.Body = new ModelRenderer(this, 32, 16);
		this.Body.addBox(-4F, 0F, -2F, 8, 12, 4);
		this.Body.setRotationPoint(0F, 1F, 0F);
		this.Body.setTextureSize(64, 32);
		this.Body.mirror = true;
		setRotation(this.Body, 0F, 0F, 0F);
		this.RightArm = new ModelRenderer(this, 56, 0);
		this.RightArm.addBox(-1F, -2F, -1F, 2, 12, 2);
		this.RightArm.setRotationPoint(-5F, 3F, 0F);
		this.RightArm.setTextureSize(64, 32);
		this.RightArm.mirror = true;
		setRotation(this.RightArm, -0.2268928F, 0F, 0F);
		this.RightArm.mirror = true;
		this.LeftArm = new ModelRenderer(this, 56, 0);
		this.LeftArm.addBox(-1F, -2F, -1F, 2, 12, 2);
		this.LeftArm.setRotationPoint(5F, 3F, 0F);
		this.LeftArm.setTextureSize(64, 32);
		this.LeftArm.mirror = true;
		setRotation(this.LeftArm, -0.2268928F, 0F, 0F);
		this.LeftArm.mirror = false;
		this.RightLeg = new ModelRenderer(this, 56, 0);
		this.RightLeg.addBox(-1F, 0F, -1F, 2, 11, 2);
		this.RightLeg.setRotationPoint(-2F, 13F, 0F);
		this.RightLeg.setTextureSize(64, 32);
		this.RightLeg.mirror = true;
		setRotation(this.RightLeg, 0F, 0F, 0F);
		this.RightLeg.mirror = true;
		this.LeftLeg = new ModelRenderer(this, 56, 0);
		this.LeftLeg.addBox(-1F, 0F, -1F, 2, 11, 2);
		this.LeftLeg.setRotationPoint(2F, 13F, 0F);
		this.LeftLeg.setTextureSize(64, 32);
		this.LeftLeg.mirror = true;
		setRotation(this.LeftLeg, 0F, 0F, 0F);
		this.LeftLeg.mirror = false;
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Head.render(f5);
		Headwear.render(f5);
		Body.render(f5);
		RightArm.render(f5);
		LeftArm.render(f5);
		RightLeg.render(f5);
		LeftLeg.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
