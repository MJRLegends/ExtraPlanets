package com.mjr.extraplanets.client.render.entities.bosses.defaultBosses;

import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.planets.GalacticraftPlanets;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.client.model.bosses.defaultBosses.ModelCreeperBossEris;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossEris;

public class RenderCreeperBossEris extends RenderLiving<EntityCreeperBossEris> {
	private static final ResourceLocation creeperTexture = new ResourceLocation(GalacticraftPlanets.ASSET_PREFIX, "textures/model/creeper.png");
	private static final ResourceLocation powerTexture = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/power.png");
	private final ModelBase creeperModel = new ModelCreeperBossEris(2.0F);

	public RenderCreeperBossEris(RenderManager renderManager) {
		super(renderManager, new ModelCreeperBossEris(), 1.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCreeperBossEris entity) {
		return RenderCreeperBossEris.creeperTexture;
	}

	@Override
	public void doRender(EntityCreeperBossEris par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(par1EntityLiving, par2, par4, par6, par8, par9);
	}

	@Override
	protected void preRenderCallback(EntityCreeperBossEris par1EntityLiving, float par2) {
		GL11.glScalef(4.0F, 4.0F, 4.0F);
		GL11.glRotatef((float) (Math.pow(par1EntityLiving.deathTicks, 2) / 5.0F + (Math.pow(par1EntityLiving.deathTicks, 2) / 5.0F - Math.pow(par1EntityLiving.deathTicks - 1, 2) / 5.0F) * par2), 0.0F, 1.0F, 0.0F);
	}

	@Override
	protected int getColorMultiplier(EntityCreeperBossEris par1EntityLivingBase, float par2, float par3) {
		return super.getColorMultiplier(par1EntityLivingBase, par2, par3);
	}
}