package com.mjr.extraplanets.client.render.entities.bosses.defaultBosses;

import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.planets.GalacticraftPlanets;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.client.model.ModelCreeperBossJupiter;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossJupiter;

public class RenderCreeperBossJupiter extends RenderLiving<EntityCreeperBossJupiter> {
	private static final ResourceLocation creeperTexture = new ResourceLocation(GalacticraftPlanets.ASSET_PREFIX, "textures/model/creeper.png");
	private static final ResourceLocation powerTexture = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/power.png");
	private final ModelBase creeperModel = new ModelCreeperBossJupiter(2.0F);

	public RenderCreeperBossJupiter(RenderManager renderManager) {
		super(renderManager, new ModelCreeperBossJupiter(), 1.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCreeperBossJupiter entity) {
		return RenderCreeperBossJupiter.creeperTexture;
	}

	@Override
	public void doRender(EntityCreeperBossJupiter par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		BossStatus.setBossStatus((IBossDisplayData) par1EntityLiving, false);

		super.doRender(par1EntityLiving, par2, par4, par6, par8, par9);
	}

	@Override
	protected void preRenderCallback(EntityCreeperBossJupiter par1EntityLiving, float par2) {
		GL11.glScalef(4.0F, 4.0F, 4.0F);
		GL11.glRotatef((float) (Math.pow(par1EntityLiving.deathTicks, 2) / 5.0F + (Math.pow(par1EntityLiving.deathTicks, 2) / 5.0F - Math.pow(par1EntityLiving.deathTicks - 1, 2) / 5.0F) * par2), 0.0F, 1.0F, 0.0F);
	}

	@Override
	protected int getColorMultiplier(EntityCreeperBossJupiter par1EntityLivingBase, float par2, float par3) {
		return super.getColorMultiplier(par1EntityLivingBase, par2, par3);
	}
}