package com.mjr.extraplanets.client.model.bosses;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelEvolvedIceSlimeBoss extends ModelBase {
	ModelRenderer slimeBodies;
	ModelRenderer slimeRightEye;
	ModelRenderer slimeLeftEye;
	ModelRenderer slimeMouth;

	public ModelEvolvedIceSlimeBoss(int p_i1157_1_) {
		this.slimeBodies = new ModelRenderer(this, 0, p_i1157_1_);
		this.slimeBodies.addBox(-4.0F, 16.0F, -4.0F, 8, 8, 8);

		if (p_i1157_1_ > 0) {
			this.slimeBodies = new ModelRenderer(this, 0, p_i1157_1_);
			this.slimeBodies.addBox(-3.0F, 17.0F, -3.0F, 6, 6, 6);
			this.slimeRightEye = new ModelRenderer(this, 32, 0);
			this.slimeRightEye.addBox(-3.25F, 18.0F, -3.5F, 2, 2, 2);
			this.slimeLeftEye = new ModelRenderer(this, 32, 4);
			this.slimeLeftEye.addBox(1.25F, 18.0F, -3.5F, 2, 2, 2);
			this.slimeMouth = new ModelRenderer(this, 32, 8);
			this.slimeMouth.addBox(0.0F, 21.0F, -3.5F, 1, 1, 1);
		}
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		this.slimeBodies.render(scale);

		if (this.slimeRightEye != null) {
			this.slimeRightEye.render(scale);
			this.slimeLeftEye.render(scale);
			this.slimeMouth.render(scale);
		}
	}
}