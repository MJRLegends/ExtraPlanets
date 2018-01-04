package com.mjr.extraplanets.client.render.entities.bosses;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.client.model.bosses.ModelEvolvedGhastBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedGhastBoss;

@SideOnly(Side.CLIENT)
public class RenderEvolvedGhastBoss extends RenderLiving<EntityEvolvedGhastBoss> {
	private static final ResourceLocation ghastTextures = new ResourceLocation("textures/entity/ghast/ghast.png");
	private static final ResourceLocation ghastShootingTextures = new ResourceLocation("textures/entity/ghast/ghast_shooting.png");

	public RenderEvolvedGhastBoss(RenderManager renderManager) {
		super(renderManager, new ModelEvolvedGhastBoss(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityEvolvedGhastBoss entity) {
		return entity.isAttacking() ? ghastShootingTextures : ghastTextures;
	}

	@Override
	protected void preRenderCallback(EntityEvolvedGhastBoss entitylivingbaseIn, float partialTickTime) {
		float f = 2.0F;
		float f1 = (8.0F + f) / 2.0F;
		float f2 = (8.0F + 1.0F / f) / 2.0F;
		GlStateManager.scale(f2, f1, f2);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.rotate((float) (Math.pow(entitylivingbaseIn.deathTicks, 2) / 5.0F + (Math.pow(entitylivingbaseIn.deathTicks, 2) / 5.0F - Math.pow(entitylivingbaseIn.deathTicks - 1, 2) / 5.0F) * partialTickTime), 0.0F, 1.0F, 0.0F);
	}
}