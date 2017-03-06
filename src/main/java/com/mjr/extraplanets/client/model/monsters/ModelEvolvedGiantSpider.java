package com.mjr.extraplanets.client.model.monsters;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEvolvedGiantSpider extends ModelBase {
	ModelRenderer RearEndLeft;
	ModelRenderer RearEndTop;
	ModelRenderer Head;
	ModelRenderer Body;
	ModelRenderer RearEnd;
	ModelRenderer Leg8;
	ModelRenderer Leg6;
	ModelRenderer Leg4;
	ModelRenderer Leg2;
	ModelRenderer Leg7;
	ModelRenderer Leg5;
	ModelRenderer Leg3;
	ModelRenderer Leg1;
	ModelRenderer Leg9;
	ModelRenderer Leg10;
	ModelRenderer RearEndRight;

	public ModelEvolvedGiantSpider() {
		this(0.0F);
	}

	public ModelEvolvedGiantSpider(float par1) {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.RearEndLeft = new ModelRenderer(this, 0, 45);
		this.RearEndLeft.addBox(-6F, 0F, 0F, 1, 6, 11);
		this.RearEndLeft.setRotationPoint(0F, 16F, 10F);
		this.RearEndLeft.setTextureSize(128, 64);
		this.RearEndLeft.mirror = true;
		setRotation(this.RearEndLeft, 0F, 0F, 0F);
		this.RearEndTop = new ModelRenderer(this, 0, 34);
		this.RearEndTop.addBox(-4F, 0F, 8F, 8, 1, 11);
		this.RearEndTop.setRotationPoint(0F, 14F, 2F);
		this.RearEndTop.setTextureSize(128, 64);
		this.RearEndTop.mirror = true;
		setRotation(this.RearEndTop, 0F, 0F, 0F);
		this.Head = new ModelRenderer(this, 76, 1);
		this.Head.addBox(-5F, -5F, -9F, 9, 9, 9);
		this.Head.setRotationPoint(0F, 20F, -3F);
		this.Head.setTextureSize(128, 64);
		this.Head.mirror = true;
		setRotation(this.Head, 0F, 0F, 0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.addBox(-4F, -3F, -3F, 8, 6, 12);
		this.Body.setRotationPoint(0F, 20F, 0F);
		this.Body.setTextureSize(128, 64);
		this.Body.mirror = true;
		setRotation(this.Body, 0F, 0F, 0F);
		this.RearEnd = new ModelRenderer(this, 0, 12);
		this.RearEnd.addBox(-5F, -5F, 0F, 10, 8, 13);
		this.RearEnd.setRotationPoint(0F, 20F, 9F);
		this.RearEnd.setTextureSize(128, 64);
		this.RearEnd.mirror = true;
		setRotation(this.RearEnd, 0F, 0F, 0F);
		this.Leg8 = new ModelRenderer(this, 18, 0);
		this.Leg8.addBox(-1F, -1F, -1F, 16, 2, 2);
		this.Leg8.setRotationPoint(4F, 20F, -1F);
		this.Leg8.setTextureSize(128, 64);
		this.Leg8.mirror = true;
		setRotation(this.Leg8, 0F, 0.5759587F, 0.1919862F);
		this.Leg6 = new ModelRenderer(this, 18, 0);
		this.Leg6.addBox(-1F, -1F, -1F, 16, 2, 2);
		this.Leg6.setRotationPoint(4F, 20F, 0F);
		this.Leg6.setTextureSize(128, 64);
		this.Leg6.mirror = true;
		setRotation(this.Leg6, 0F, 0.2792527F, 0.1919862F);
		this.Leg4 = new ModelRenderer(this, 18, 0);
		this.Leg4.addBox(-1F, -1F, -1F, 16, 2, 2);
		this.Leg4.setRotationPoint(4F, 20F, 1F);
		this.Leg4.setTextureSize(128, 64);
		this.Leg4.mirror = true;
		setRotation(this.Leg4, 0F, -0.2792527F, 0.1919862F);
		this.Leg2 = new ModelRenderer(this, 18, 0);
		this.Leg2.addBox(-1F, -1F, -1F, 16, 2, 2);
		this.Leg2.setRotationPoint(4F, 20F, 2F);
		this.Leg2.setTextureSize(128, 64);
		this.Leg2.mirror = true;
		setRotation(this.Leg2, 0F, -0.5759587F, 0.1919862F);
		this.Leg7 = new ModelRenderer(this, 18, 0);
		this.Leg7.addBox(-15F, -1F, -1F, 16, 2, 2);
		this.Leg7.setRotationPoint(-4F, 20F, -1F);
		this.Leg7.setTextureSize(128, 64);
		this.Leg7.mirror = true;
		setRotation(this.Leg7, 0F, -0.5759587F, -0.1919862F);
		this.Leg5 = new ModelRenderer(this, 18, 0);
		this.Leg5.addBox(-15F, -1F, -1F, 16, 2, 2);
		this.Leg5.setRotationPoint(-4F, 20F, 0F);
		this.Leg5.setTextureSize(128, 64);
		this.Leg5.mirror = true;
		setRotation(this.Leg5, 0F, -0.2792527F, -0.1919862F);
		this.Leg3 = new ModelRenderer(this, 18, 0);
		this.Leg3.addBox(-15F, -1F, -1F, 16, 2, 2);
		this.Leg3.setRotationPoint(-4F, 20F, 1F);
		this.Leg3.setTextureSize(128, 64);
		this.Leg3.mirror = true;
		setRotation(this.Leg3, 0F, 0.2792527F, -0.1919862F);
		this.Leg1 = new ModelRenderer(this, 18, 0);
		this.Leg1.addBox(-15F, -1F, -1F, 16, 2, 2);
		this.Leg1.setRotationPoint(-4F, 20F, 2F);
		this.Leg1.setTextureSize(128, 64);
		this.Leg1.mirror = true;
		setRotation(Leg1, 0F, 0.5759587F, -0.1919862F);
		this.Leg9 = new ModelRenderer(this, 18, 0);
		this.Leg9.addBox(-1F, -1F, 2F, 16, 2, 2);
		this.Leg9.setRotationPoint(4F, 20F, 0F);
		this.Leg9.setTextureSize(128, 64);
		this.Leg9.mirror = true;
		setRotation(this.Leg9, 0F, -0.8901179F, 0.0785398F);
		this.Leg10 = new ModelRenderer(this, 18, 0);
		this.Leg10.addBox(-1F, -1F, -4F, 16, 2, 2);
		this.Leg10.setRotationPoint(-4F, 20F, 0F);
		this.Leg10.setTextureSize(128, 64);
		this.Leg10.mirror = true;
		setRotation(this.Leg10, 0F, -2.286381F, 0.0785398F);
		this.RearEndRight = new ModelRenderer(this, 0, 45);
		this.RearEndRight.addBox(0F, 7F, -1F, 1, 6, 11);
		this.RearEndRight.setRotationPoint(5F, 9F, 11F);
		this.RearEndRight.setTextureSize(128, 64);
		this.RearEndRight.mirror = true;
		setRotation(this.RearEndRight, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.RearEndLeft.render(f5);
	    this.RearEndTop.render(f5);
	    this.Head.render(f5);
	    this.Body.render(f5);
	    this.RearEnd.render(f5);
	    this.Leg8.render(f5);
	    this.Leg6.render(f5);
	    this.Leg4.render(f5);
	    this.Leg2.render(f5);
	    this.Leg7.render(f5);
	    this.Leg5.render(f5);
	    this.Leg3.render(f5);
	    this.Leg1.render(f5);
	    this.Leg9.render(f5);
	    this.Leg10.render(f5);
	    this.RearEndRight.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity) {
	    super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
	}
}
