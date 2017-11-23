package com.mjr.extraplanets.client.render.entities.bosses.defaultBosses;

import micdoodle8.mods.galacticraft.planets.GalacticraftPlanets;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import com.mjr.extraplanets.client.model.bosses.defaultBosses.ModelCreeperBossEris;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossEris;

public class RenderCreeperBossEris extends RenderLiving<EntityCreeperBossEris> {
	private static final ResourceLocation creeperTexture = new ResourceLocation(GalacticraftPlanets.ASSET_PREFIX, "textures/model/creeper.png");

	public RenderCreeperBossEris(RenderManager renderManager) {
		super(renderManager, new ModelCreeperBossEris(), 1.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCreeperBossEris entity) {
		return RenderCreeperBossEris.creeperTexture;
	}

	@Override
	public void doRender(EntityCreeperBossEris par1EntityLiving, double x, double y, double z, float entityYaw, float partialTicks) {
		super.doRender(par1EntityLiving, x, y, z, entityYaw, partialTicks);
	}

	@Override
	protected void preRenderCallback(EntityCreeperBossEris par1EntityLiving, float partialTickTime) {
		GlStateManager.scale(4.0F, 4.0F, 4.0F);
		GlStateManager.rotate((float) (Math.pow(par1EntityLiving.deathTicks, 2) / 5.0F + (Math.pow(par1EntityLiving.deathTicks, 2) / 5.0F - Math.pow(par1EntityLiving.deathTicks - 1, 2) / 5.0F) * partialTickTime), 0.0F, 1.0F, 0.0F);
	}

	@Override
	protected int getColorMultiplier(EntityCreeperBossEris par1EntityLivingBase, float lightBrightness, float partialTickTime) {
		return super.getColorMultiplier(par1EntityLivingBase, lightBrightness, partialTickTime);
	}
}