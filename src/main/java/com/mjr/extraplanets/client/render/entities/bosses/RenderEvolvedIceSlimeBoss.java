package com.mjr.extraplanets.client.render.entities.bosses;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.client.model.bosses.ModelEvolvedIceSlimeBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedIceSlimeBoss;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEvolvedIceSlimeBoss extends RenderLiving<EntityEvolvedIceSlimeBoss> {
	private static final ResourceLocation slimeTextures = new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/entity/slime/iceslime.png");

	public RenderEvolvedIceSlimeBoss(RenderManager renderManager) {
		super(renderManager, new ModelEvolvedIceSlimeBoss(0), 0.25F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityEvolvedIceSlimeBoss entity) {
		return slimeTextures;
	}

	@Override
	protected void preRenderCallback(EntityEvolvedIceSlimeBoss entityLiving, float partialTickTime) {
		int i = entityLiving.getSlimeSize();
		float f = (entityLiving.prevSquishFactor + (entityLiving.squishFactor - entityLiving.prevSquishFactor) * partialTickTime) / (i * 0.5F + 1.0F);
		float f1 = 1.0F / (f + 1.0F);
		float f2 = i;
		GlStateManager.scale(f1 * f2, 1.0F / f1 * f2, f1 * f2);
		GlStateManager.rotate((float) (Math.pow(entityLiving.deathTicks, 2) / 5.0F + (Math.pow(entityLiving.deathTicks, 2) / 5.0F - Math.pow(entityLiving.deathTicks - 1, 2) / 5.0F) * partialTickTime), 0.0F, 1.0F, 0.0F);
	}
}