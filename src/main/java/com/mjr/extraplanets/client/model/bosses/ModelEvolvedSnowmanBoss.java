package com.mjr.extraplanets.client.model.bosses;

import com.mjr.extraplanets.Constants;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelEvolvedSnowmanBoss extends ModelBase {
	public ModelRenderer body;
	public ModelRenderer bottomBody;
	public ModelRenderer head;
	public ModelRenderer rightHand;
	public ModelRenderer leftHand;

	public ModelEvolvedSnowmanBoss() {
		float f = 4.0F;
		float f1 = 0.0F;
		this.head = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
		this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f1 - 0.5F);
		this.head.setRotationPoint(0.0F, 0.0F + f, 0.0F);
		this.rightHand = (new ModelRenderer(this, 32, 0)).setTextureSize(64, 64);
		this.rightHand.addBox(-1.0F, 0.0F, -1.0F, 12, 2, 2, f1 - 0.5F);
		this.rightHand.setRotationPoint(0.0F, 0.0F + f + 9.0F - 7.0F, 0.0F);
		this.leftHand = (new ModelRenderer(this, 32, 0)).setTextureSize(64, 64);
		this.leftHand.addBox(-1.0F, 0.0F, -1.0F, 12, 2, 2, f1 - 0.5F);
		this.leftHand.setRotationPoint(0.0F, 0.0F + f + 9.0F - 7.0F, 0.0F);
		this.body = (new ModelRenderer(this, 0, 16)).setTextureSize(64, 64);
		this.body.addBox(-5.0F, -10.0F, -5.0F, 10, 10, 10, f1 - 0.5F);
		this.body.setRotationPoint(0.0F, 0.0F + f + 9.0F, 0.0F);
		this.bottomBody = (new ModelRenderer(this, 0, 36)).setTextureSize(64, 64);
		this.bottomBody.addBox(-6.0F, -12.0F, -6.0F, 12, 12, 12, f1 - 0.5F);
		this.bottomBody.setRotationPoint(0.0F, 0.0F + f + 20.0F, 0.0F);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
		this.head.rotateAngleY = netHeadYaw / (180F / Constants.floatPI);
		this.head.rotateAngleX = headPitch / (180F / Constants.floatPI);
		this.body.rotateAngleY = netHeadYaw / (180F / Constants.floatPI) * 0.25F;
		float f6 = MathHelper.sin(this.body.rotateAngleY);
		float f7 = MathHelper.cos(this.body.rotateAngleY);
		this.rightHand.rotateAngleZ = 1.0F;
		this.leftHand.rotateAngleZ = -1.0F;
		this.rightHand.rotateAngleY = 0.0F + this.body.rotateAngleY;
		this.leftHand.rotateAngleY = Constants.floatPI + this.body.rotateAngleY;
		this.rightHand.rotationPointX = f7 * 5.0F;
		this.rightHand.rotationPointZ = -f6 * 5.0F;
		this.leftHand.rotationPointX = -f7 * 5.0F;
		this.leftHand.rotationPointZ = f6 * 5.0F;
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		this.body.render(scale);
		this.bottomBody.render(scale);
		this.head.render(scale);
		this.rightHand.render(scale);
		this.leftHand.render(scale);
	}
}