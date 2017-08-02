package com.mjr.extraplanets.client.render.entities.bosses;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.client.model.ModelEvolvedFireBatBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedFireBatBoss;

@SideOnly(Side.CLIENT)
public class RenderEvolvedFireBatBoss extends RenderLiving<EntityEvolvedFireBatBoss> {
	private static final ResourceLocation BAT_TEXTURES = new ResourceLocation("textures/entity/bat.png");

	public RenderEvolvedFireBatBoss(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelEvolvedFireBatBoss(), 0.25F);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntityEvolvedFireBatBoss entity) {
		return BAT_TEXTURES;
	}

	/**
	 * Allows the render to do state modifications necessary before the model is rendered.
	 */
	protected void preRenderCallback(EntityEvolvedFireBatBoss entitylivingbaseIn, float partialTickTime) {
		GlStateManager.scale(8.35F, 8.35F, 8.35F);
		GlStateManager.translate(0.0F, 0.9F, 0.0F);
	}

	protected void rotateCorpse(EntityEvolvedFireBatBoss entityLiving, float p_77043_2_, float p_77043_3_, float partialTicks) {
		if (entityLiving.getIsBatHanging()) {
			GlStateManager.translate(0.0F, -0.1F, 0.0F);
		} else {
			GlStateManager.translate(0.0F, MathHelper.cos(p_77043_2_ * 0.3F) * 0.2F, 0.0F);
		}

		super.rotateCorpse(entityLiving, p_77043_2_, p_77043_3_, partialTicks);
	}
}