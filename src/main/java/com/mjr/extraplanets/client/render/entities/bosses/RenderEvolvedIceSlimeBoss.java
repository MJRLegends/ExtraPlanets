package com.mjr.extraplanets.client.render.entities.bosses;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.client.model.bosses.ModelEvolvedIceSlimeBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedIceSlimeBoss;

@SideOnly(Side.CLIENT)
public class RenderEvolvedIceSlimeBoss extends RenderLiving<EntityEvolvedIceSlimeBoss> {
	private static final ResourceLocation slimeTextures = new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/entity/slime/iceslime.png");

	public RenderEvolvedIceSlimeBoss(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelEvolvedIceSlimeBoss(0), 0.25F);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	@Override
	protected ResourceLocation getEntityTexture(EntityEvolvedIceSlimeBoss entity) {
		return slimeTextures;
	}

	/**
	 * Allows the render to do any OpenGL state modifications necessary before
	 * the model is rendered. Args: entityLiving, partialTickTime
	 */
	@Override
	protected void preRenderCallback(EntityEvolvedIceSlimeBoss entitylivingbaseIn, float partialTickTime) {
		int i = entitylivingbaseIn.getSlimeSize();
		float f = (entitylivingbaseIn.prevSquishFactor + (entitylivingbaseIn.squishFactor - entitylivingbaseIn.prevSquishFactor) * partialTickTime) / (i * 0.5F + 1.0F);
		float f1 = 1.0F / (f + 1.0F);
		float f2 = i;
		GlStateManager.scale(f1 * f2, 1.0F / f1 * f2, f1 * f2);
		GL11.glRotatef((float) (Math.pow(entitylivingbaseIn.deathTicks, 2) / 5.0F + (Math.pow(entitylivingbaseIn.deathTicks, 2) / 5.0F - Math.pow(entitylivingbaseIn.deathTicks - 1, 2) / 5.0F) * partialTickTime), 0.0F, 1.0F, 0.0F);
	}
}