package com.mjr.extraplanets.client.render.entities.bosses;

import com.mjr.extraplanets.client.model.bosses.ModelEvolvedSnowmanBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedSnowmanBoss;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEvolvedSnowmanBoss extends RenderLiving<EntityEvolvedSnowmanBoss> {
	private static final ResourceLocation snowManTextures = new ResourceLocation("textures/entity/snowman.png");

	public RenderEvolvedSnowmanBoss(RenderManager renderManager) {
		super(renderManager, new ModelEvolvedSnowmanBoss(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityEvolvedSnowmanBoss entity) {
		return snowManTextures;
	}

	@Override
	public ModelEvolvedSnowmanBoss getMainModel() {
		return (ModelEvolvedSnowmanBoss) super.getMainModel();
	}

	@Override
	protected void preRenderCallback(EntityEvolvedSnowmanBoss entityLiving, float partialTickTime) {
		float f = 4.0F;
		float f1 = (10.0F + f) / 2.0F;
		float f2 = (10.0F + 1.0F / f) / 2.0F;
		GlStateManager.scale(f2, f1, f2);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.rotate((float) (Math.pow(entityLiving.deathTicks, 2) / 5.0F + (Math.pow(entityLiving.deathTicks, 2) / 5.0F - Math.pow(entityLiving.deathTicks - 1, 2) / 5.0F) * partialTickTime), 0.0F, 1.0F, 0.0F);
	}
}