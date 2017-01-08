package com.mjr.extraplanets.client.render.entity;

import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.planets.GalacticraftPlanets;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.client.model.ModelCreeperBossSaturn;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossSaturn;

public class RenderCreeperBossSaturn extends RenderLiving<EntityCreeperBossSaturn> {
	private static final ResourceLocation creeperTexture = new ResourceLocation(GalacticraftPlanets.ASSET_PREFIX, "textures/model/creeper.png");
	private static final ResourceLocation powerTexture = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/power.png");
	private final ModelBase creeperModel = new ModelCreeperBossSaturn(2.0F);

	public RenderCreeperBossSaturn(RenderManager renderManager) {
		super(renderManager, new ModelCreeperBossSaturn(), 1.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCreeperBossSaturn entity) {
		return RenderCreeperBossSaturn.creeperTexture;
	}

	@Override
	public void doRender(EntityCreeperBossSaturn par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		BossStatus.setBossStatus((IBossDisplayData) par1EntityLiving, false);

		super.doRender(par1EntityLiving, par2, par4, par6, par8, par9);
	}

	@Override
	protected void preRenderCallback(EntityCreeperBossSaturn par1EntityLiving, float par2) {
		GL11.glScalef(4.0F, 4.0F, 4.0F);
		GL11.glRotatef((float) (Math.pow(par1EntityLiving.deathTicks, 2) / 5.0F + (Math.pow(par1EntityLiving.deathTicks, 2) / 5.0F - Math.pow(par1EntityLiving.deathTicks - 1, 2) / 5.0F) * par2), 0.0F, 1.0F, 0.0F);
	}

	@Override
	protected int getColorMultiplier(EntityCreeperBossSaturn par1EntityLivingBase, float par2, float par3) {
		return super.getColorMultiplier(par1EntityLivingBase, par2, par3);
	}
}